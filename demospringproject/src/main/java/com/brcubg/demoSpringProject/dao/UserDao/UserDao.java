package com.brcubg.demoSpringProject.dao.UserDao;

import com.brcubg.demoSpringProject.entity.User;
import com.brcubg.demoSpringProject.request.UserRequest.UserQueryRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class UserDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<User> findUsersByUserName(UserQueryRequest request) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> user = criteriaQuery.from(User.class);
        Predicate userNamePredicate = criteriaBuilder.like(user.get("userName"), "%" + request.getUserName() + "%");
        criteriaQuery.where(userNamePredicate);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
