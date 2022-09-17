package com.brcubg.demoSpringProject.dao.UserDao;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.repository.UserRepository;
import com.brcubg.demoSpringProject.request.UserRequest.UserCreateRequest;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import com.brcubg.demoSpringProject.response.UserResponse.UserQueryResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    final private UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsersByUserName(UserQueryRequest request) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> user = criteriaQuery.from(User.class);
        Predicate userNamePredicate = criteriaBuilder.like(user.get("userName"), "%" + request.getUserName() + "%");
        criteriaQuery.where(userNamePredicate);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public boolean isExistId(Long id){
        return userRepository.existsById(id);
    }

    public UserQueryResponse getUser(Long id){
        Optional<User> user = userRepository.findById(id);
        UserQueryResponse response = new UserQueryResponse();
        if(user.isPresent()){
            response.setId(user.get().getId());
            response.setUserName(user.get().getUserName());
            response.setRole(user.get().getRoleId());
            response.setPassword(user.get().getPassword());
        }

        return response;
    }

    public User createUser(UserCreateRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setRoleId(request.getRole());

        return userRepository.save(user);
    }
}
