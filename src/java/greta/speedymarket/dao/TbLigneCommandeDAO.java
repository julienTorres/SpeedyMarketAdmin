package greta.speedymarket.dao;

import greta.speedymarket.model.TbCategorie;
import greta.speedymarket.model.TbLigneCommande;
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
@ManagedBean(name="TbLigneCommandeDAO")
public class TbLigneCommandeDAO {

    public List<TbLigneCommande> findAll() {
        List<TbLigneCommande> lesLigneCommandes = new ArrayList<>();
        
        Session session = HibernateUtil
                            .getSessionFactory()
                            .getCurrentSession();
        session.beginTransaction();
        
        lesLigneCommandes = session
                            .createQuery("select c from TbLigneCommande as c")
                            .list();
        
        session.close();
        return lesLigneCommandes;
    }
    
    public TbLigneCommande findByArticle(Integer article) {
        TbLigneCommande ligneCommande = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from TbLigneCommande where tbArticle = :tbArticle");
            if (query.list().isEmpty()) {
                ligneCommande = (TbLigneCommande) query.list().get(0);
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return ligneCommande;
    }   
    
    public List<TbLigneCommande> findByCommande(Integer commande) {
        List<TbLigneCommande> ligneCommande = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from TbLigneCommande where tbCommande = :tbCommande");
            if (query.list().isEmpty()) {
                ligneCommande = (List<TbLigneCommande>) query.list();
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return ligneCommande;
    }   
    
}
