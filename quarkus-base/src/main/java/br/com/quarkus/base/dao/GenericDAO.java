package br.com.quarkus.base.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class GenericDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public int count(String sql) {
        Query q = entityManager.createQuery(sql);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<?> search(String query, int offset, int limit) {
        Query q = entityManager.createQuery(query)
                .setFirstResult(offset)
                .setMaxResults(limit);
        return q.getResultList();
    }

}
