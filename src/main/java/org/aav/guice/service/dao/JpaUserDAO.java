package org.aav.guice.service.dao;

import com.google.inject.persist.Transactional;
import org.aav.guice.model.User;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * Created by aurel.avramescu on 15/06/2014.
 */
public class JpaUserDAO extends JpaGenericDAO<User> {

    public JpaUserDAO() {
        super(User.class);
    }

    @Transactional
    @Override
    public List<User> findByCriteria(User query) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
