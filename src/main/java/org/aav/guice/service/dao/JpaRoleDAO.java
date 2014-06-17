package org.aav.guice.service.dao;

import org.aav.guice.model.Role;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by aurel.avramescu on 17/06/2014.
 */
public class JpaRoleDAO extends JpaGenericDAO<Role> {

    public JpaRoleDAO() {
        super(Role.class);
    }

    @Override
    public List<Role> findByCriteria(Role query) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
