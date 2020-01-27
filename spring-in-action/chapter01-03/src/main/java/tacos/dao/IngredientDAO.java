package tacos.dao;

import tacos.model.Ingredient;

import javax.persistence.EntityManager;
import java.util.List;

public class IngredientDAO {

    EntityManager em = HibernateUtil.getEntityManager();

    public Ingredient findById(String id) {
        return em.find(Ingredient.class, id);
    }

    public List<Ingredient> findByType(String type) {
        String hql = "SELECT i FROM Ingredient i WHERE i.type = :type";
        return em.createQuery(hql, Ingredient.class)
                .setParameter("type", type)
                .getResultList();
    }
}