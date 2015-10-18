package greta.speedymarket.dao;

import greta.speedymarket.model.TbCommande;
import greta.speedymarket.services.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbCommandeDAO")
public class TbCommandeDAO {

    public List<TbCommande> findAll() {
        List<TbCommande> lesCommandes = new ArrayList<>();        
        
        Session session = HibernateUtil
                                    .getSessionFactory()
                                    .getCurrentSession();
        session.beginTransaction();
        
        lesCommandes = session
                            .createQuery("select c from TbCommande as c")
                            .list();
        
        session.close();
        return lesCommandes;
    }

    
    public TbCommande findById(Integer id) {
        TbCommande commande = null;
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        commande = (TbCommande) session.get(TbCommande.class, id);
        
        session.close();
        return commande;
    }
    
}