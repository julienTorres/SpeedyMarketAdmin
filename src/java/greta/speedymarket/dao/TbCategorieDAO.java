package greta.speedymarket.dao;

import greta.speedymarket.model.TbCategorie;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbCategorieDAO")
public class TbCategorieDAO {
    
    public void save(TbCategorie categorie) {
        System.out.println("persist categorie");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(categorie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbCategorie categorie) {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(categorie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbCategorie categorie) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(categorie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbCategorie> findAll() {
        List<TbCategorie> lesCategories = new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        lesCategories = session.createQuery("select c from TbCategorie as c").list();

        session.close();
        return lesCategories;
    }
    
    public TbCategorie findById(Integer id) {
        TbCategorie categorie = null;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        categorie = (TbCategorie) session.get(TbCategorie.class, id);
        
        session.close();
        return categorie;
    }
    
    public TbCategorie findByLibelle(String libelle) {
        TbCategorie categorie = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from TbCategorie where CLibelle = :CLibelle");
            if (query.list().isEmpty()) {
                categorie = (TbCategorie) query.list().get(0);
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return categorie;
    }
}
