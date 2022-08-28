package com.brcubg.demoSpringProject.dao.RoleDao;

import com.brcubg.demoSpringProject.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Role> findRolesByRoleName(String roleName){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);

        Root<Role> role = criteriaQuery.from(Role.class);
        Predicate roleNamePredicate = criteriaBuilder.like(role.get("roleName"), "%" + roleName + "%");
        criteriaQuery.where(roleNamePredicate);

        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
