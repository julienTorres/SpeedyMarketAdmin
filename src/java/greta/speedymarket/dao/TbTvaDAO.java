package greta.speedymarket.dao;

import greta.speedymarket.model.TbTva;
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
@ManagedBean(name="TbTvaDAO")
public class TbTvaDAO {
    
    public void save(TbTva tva) {
        System.out.println("persist tva");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(tva);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbTva tva) {
        System.out.println("merge tva " + tva.getIdTva() + " - " + tva.getTLibelle());
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(tva);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbTva tva) {
        System.out.println("Suppression de tva "+tva);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(tva);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbTva> findAll() {
        List<TbTva> lesTva = new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesTva = session.createQuery("from TbTva").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return lesTva;
    }
    
//    public TbTva findById(Integer id) {
//        TbTva tva = null;
//        
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        
//        tva = (TbTva) session.get(TbTva.class, id);
//        
//        session.close();
//        
//        return tva;
//    }
//    
//    public TbTva findByLibelle(String libelle) {
//        TbTva tva = null;
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            Query query = session.createQuery("from TbTva where SLibelle = :SLibelle");
//            if (query.list().isEmpty()) {
//                tva = (TbTva) query.list().get(0);
//            }
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        
//        return tva;
//    } 
    
}