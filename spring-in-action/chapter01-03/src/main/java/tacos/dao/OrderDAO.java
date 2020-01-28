package tacos.dao;

import tacos.model.Order;

import javax.persistence.EntityManager;

public class OrderDAO {

    EntityManager em = HibernateUtil.getEntityManager();

    public void insert(Order order) {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }
}