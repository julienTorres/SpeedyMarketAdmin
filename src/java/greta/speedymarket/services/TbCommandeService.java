package greta.speedymarket.services;

import greta.speedymarket.dao.TbCommandeDAO;
import greta.speedymarket.model.TbCommande;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbCommandeService")
@ViewScoped
public class TbCommandeService {

    private TbCommande selectedCommande;

    public TbCommande getSelectedCommande() {
        return selectedCommande;
    }

    public void setSelectedCommande(TbCommande selectedCommande) {
        this.selectedCommande = selectedCommande;
    }

    /**
     * récupère toutes les commandes de la base de données
     * @return la liste des commandes
     */
    public List<TbCommande> loadCommandes() {
        TbCommandeDAO tbCommandeDAO = new TbCommandeDAO();
        return tbCommandeDAO.findAll();
    }
    
}