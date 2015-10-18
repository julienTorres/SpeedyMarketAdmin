package greta.speedymarket.dao;

import greta.speedymarket.model.TbStatut;
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
@ManagedBean(name="TbStatutDAO")
public class TbStatutDAO {
    
    public void save(TbStatut statut) {
        System.out.println("persist statut");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(statut);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbStatut statut) {
        System.out.println("merge statut " + statut.getIdStatut() + " - " + statut.getSLibelle());
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(statut);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbStatut statut) {
        System.out.println("Suppression du statut "+statut);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(statut);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        }
    
    public List<TbStatut> findAll() {
        List<TbStatut> lesStatuts = new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesStatuts = session.createQuery("from TbStatut").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return lesStatuts;
    }
    
//    public TbStatut findById(Integer id) {
//        TbStatut statut = null;
//        
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        
//        statut = (TbStatut) session.get(TbStatut.class, id);
//        
//        session.close();
//        
//        return statut;
//    }
//    
//    public TbStatut findByLibelle(String libelle) {
//        TbStatut statut = null;
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            Query query = session.createQuery("from TbStatut where SLibelle = :SLibelle");
//            if (query.list().isEmpty()) {
//                statut = (TbStatut) query.list().get(0);
//            }
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        
//        return statut;
//    } 
    
}