package greta.speedymarket.services;

import greta.speedymarket.dao.TbCommandeDAO;
import greta.speedymarket.model.TbCommande;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name="TbCommandeService")
public class TbCommandeService {

    @ManagedProperty(value="#{TbCommandeDAO}")
    TbCommandeDAO tbCommandeDAO;

    private TbCommande selectedCommande;

    public void setTbCommandeDAO(TbCommandeDAO tbCommandeDAO) {
        this.tbCommandeDAO = tbCommandeDAO;
    }

    public List<TbCommande> loadCommandes() {
        return tbCommandeDAO.findAll(); 
    }

    public TbCommande getSelectedCommande() {
        return selectedCommande;
    }

    public void setSelectedCommande(TbCommande selectedCommande) {
        this.selectedCommande = selectedCommande;
    }

}