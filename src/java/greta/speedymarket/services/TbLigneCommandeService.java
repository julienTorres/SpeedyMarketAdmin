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

    //load ligneCommandes !! problm de design; que doit-on afficher et pourquoi ??
    
    //load ligneCommandesByCommande 

    //load ligneCommandesByArticles
    //RQ : nécessite une nouvelle vue pour afficher les lignes de commandes 
    //indépendemment des commandes, pour des stats par example
    
}