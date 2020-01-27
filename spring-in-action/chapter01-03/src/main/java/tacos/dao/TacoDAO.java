package tacos.dao;

import tacos.model.Taco;

import javax.persistence.EntityManager;

public class TacoDAO {

    EntityManager em = HibernateUtil.getEntityManager();

    public void insert(Taco taco) {
        em.getTransaction().begin();
        em.persist(taco);
        em.getTransaction().commit();
    }
}