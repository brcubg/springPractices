package com.brcubg.demospringproject.dao.userdao;

import com.brcubg.demospringproject.entity.User;
import com.brcubg.demospringproject.repository.UserRepository;
import com.brcubg.demospringproject.request.userrequest.UserCreateRequest;
import com.brcubg.demospringproject.request.userrequest.UserQueryRequest;
import com.brcubg.demospringproject.response.userresponse.UserQueryResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{
    private final UserRepository userRepository;
    @PersistenceContext
    EntityManager entityManager;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // JPA API Technologies
    @Override
    public List<User> isFilteredUsers(UserQueryRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> user = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if (request.getId() != null) {
            predicates.add(
                    criteriaBuilder.equal(user.get("id"), request.getId()));
        }
        if (!Strings.isEmpty(request.getUserName())) {
            predicates.add(
                    criteriaBuilder.like(user.get("userName"), "%" + request.getUserName() + "%"));
        }
        criteriaQuery.select(user)
                .where(predicates.toArray(new Predicate[]{}));

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    @Override
    public boolean isExistId(Long id){
        return userRepository.existsById(id);
    }
    @Override
    public UserQueryResponse getUser(Long id){
        Optional<User> user = Optional.of(userRepository.findById(id).orElseThrow());
        return UserQueryResponse.builder()
                .id(user.get().getId())
                .userName(user.get().getUserName())
                .password(user.get().getPassword())
                .role(user.get().getRoleId())
                .build();
    }
    @Override
    public User createUser(UserCreateRequest request) {
        User user = User.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .roleId(request.getRole())
                .build();
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        Optional<User> user = Optional.of(userRepository.findById(id).orElseThrow());
        userRepository.delete(user.get());
    }
    @Override
    public User updateUser(Long id, UserCreateRequest request) {
        Optional<User> user = Optional.of(userRepository.findById(id).orElseThrow());
        user.get().setUserName(request.getUserName());
        user.get().setPassword(request.getPassword());
        user.get().setRoleId(request.getRole());
        userRepository.save(user.get());
        return user.get();
    }
}
