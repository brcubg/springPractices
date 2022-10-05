package com.brcubg.demospringproject.dao.roledao;

import com.brcubg.demospringproject.entity.Role;
import com.brcubg.demospringproject.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    private final RoleRepository roleRepository;

    public RoleDao(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> findRolesByRoleName(String roleName){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);

        Root<Role> role = criteriaQuery.from(Role.class);
        if (roleName != null) {
            Predicate roleNamePredicate = criteriaBuilder.like(role.get("roleName"), "%" + roleName + "%");
            criteriaQuery.where(roleNamePredicate);
        }
        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
    public boolean isExistId(Long id){
        return roleRepository.existsById(id);
    }
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }
}
