package greta.speedymarket.services;

import greta.speedymarket.dao.TbLigneCommandeDAO;
import greta.speedymarket.model.TbLigneCommande;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbLigneCommandeService")
@ViewScoped
public class TbLigneCommandeService {

    private TbLigneCommande selectedLigneCommande;

    public TbLigneCommande getSelectedLigneCommande() {
        return selectedLigneCommande;
    }

    public void setSelectedLigneCommande(TbLigneCommande selectedLigneCommande) {
        this.selectedLigneCommande = selectedLigneCommande;
    }

    /**
     * récupère toutes les lignes de commande de la base
     * 
     * @return la liste des lignes de commande
     */
    public List<TbLigneCommande> loadLignesCommande() {
        TbLigneCommandeDAO tbLigneCommandeDao = new TbLigneCommandeDAO();
        return tbLigneCommandeDao.findAll();
    }    
    
    /**
     * récupère les lignes de commande relatives à une commande
     * @param idCommande la commande pour laquelle on cherche les lignes de commande
     * @return la liste des lignes de commande de la commande
     */
    public List<TbLigneCommande> loadLignesCommandeByCommande(Integer idCommande) {
        TbLigneCommandeDAO tbLigneCommandeDao = new TbLigneCommandeDAO();
        return tbLigneCommandeDao.findByCommande(idCommande);
    }
    
    /**
     * récupère les lignes de commande relatives à un article
     * @param idArticle l'article pour lequel on cherche les lignes de commande
     * @return la liste des lignes de commandes relatives à l'aricle souhaité
     */
    public List<TbLigneCommande> loadLignesCommandeByArticle(Integer idArticle) {
        TbLigneCommandeDAO tbLigneCommandeDao = new TbLigneCommandeDAO();
        return tbLigneCommandeDao.findByArticle(idArticle);
    }   
    
}