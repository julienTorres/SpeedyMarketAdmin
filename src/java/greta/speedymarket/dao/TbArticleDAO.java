package greta.speedymarket.dao;

import greta.speedymarket.model.TbArticle;
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
@ManagedBean(name="TbArticleDAO")
public class TbArticleDAO {
   
    public void save(TbArticle article) {
        System.out.println("persist article");
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(article);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void update(TbArticle article) {
        System.out.println("merge article " + article.getIdArticle() + " - " + article.getADesignation());
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(article);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public void remove(TbArticle article) {
        System.out.println("Suppression de l'article "+article);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(article);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
    
    public List<TbArticle> findAll() {
        List<TbArticle> lesArticles = new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            lesArticles = session.createQuery("from TbArticle").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return lesArticles;
    }
    
//    public TbArticle findById(Integer id) {
//        TbArticle article = null;
//        
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        
//        article = (TbArticle) session.get(TbArticle.class, id);
//        
//        session.close();
//        
//        return article;
//    }
//    
//    public TbArticle findByLibelle(String libelle) {
//        TbArticle article = null;
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            session.beginTransaction();
//            Query query = session.createQuery("from TbArticle where ALibelle = :ALibelle");
//            if (query.list().isEmpty()) {
//                article = (TbArticle) query.list().get(0);
//            }
//            session.getTransaction().commit();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            session.getTransaction().rollback();
//        }
//        
//        return article;
//    }    
    
}