package greta.speedymarket.services;

import greta.speedymarket.dao.TbStatutDAO;
import greta.speedymarket.model.TbStatut;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbStatutService")
@ViewScoped
public class TbStatutService {

    private TbStatut selectedStatut;

    public TbStatut getSelectedStatut() {
        return this.selectedStatut;
    }

    public void setSelectedStatut(TbStatut selectedStatut) {
        this.selectedStatut = selectedStatut;
    }

    /**
     * crée un statut avec un nom générique
     */
    public void createStatut() {
        TbStatut newStatut = new TbStatut("Nouveau statut");
        TbStatutDAO tbStatutDAO = new TbStatutDAO();
        tbStatutDAO.save(newStatut);
    }

    /**
     * met à jour un statut
     * @param statut le statut à mettre à jour
     */
    public void saveStatut(TbStatut statut) {
        if (statut != null) {
            TbStatutDAO tbStatutDAO = new TbStatutDAO();
            tbStatutDAO.update(statut);
        }
    }

    /**
     * supprime un statut
     * @param statut le statut à supprimer
     */
    public void deleteStatut(TbStatut statut) {
        if (statut != null) {
            TbStatutDAO tbStatutDAO = new TbStatutDAO();
            tbStatutDAO.remove(statut);
        }
    }

    /**
     * récupère tous les statuts de la base de données
     * @return la liste des statuts
     */
    public List<TbStatut> loadStatuts() {
        TbStatutDAO tbStatutDAO = new TbStatutDAO();
        return tbStatutDAO.findAll();
    }
}