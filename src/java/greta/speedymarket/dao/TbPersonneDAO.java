package greta.speedymarket.dao;

import greta.speedymarket.model.TbPersonne;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name="TbPersonneDAO")
public class TbPersonneDAO {
    
    public void save(TbPersonne personne) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(personne);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbPersonne personne) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(personne);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbPersonne personne) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(personne);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbPersonne> findAll() {
        List<TbPersonne> lesPersonnes = new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesPersonnes = session.createQuery("from TbPersonne").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return lesPersonnes;
    }
    
    public TbPersonne findByNom(String libelle) {
        TbPersonne personne = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from TbPersonne where PNom = :PNom");
            if (query.list().isEmpty()) {
                personne = (TbPersonne) query.list().get(0);
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return personne;
    }   
    
    public TbPersonne findById(Integer id) {
        TbPersonne personne = null;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        personne = (TbPersonne) session.get(TbPersonne.class, id);
        
        session.close();
        
        return personne;
    }
    
}