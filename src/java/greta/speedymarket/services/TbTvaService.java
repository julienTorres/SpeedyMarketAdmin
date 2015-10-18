package greta.speedymarket.services;

import greta.speedymarket.dao.TbTvaDAO;
import greta.speedymarket.model.TbTva;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbTvaService")
@ViewScoped
public class TbTvaService {
    
    private TbTva selectedTva;

    public TbTva getSelectedTva() {
        return selectedTva;
    }

    public void setSelectedTva(TbTva selectedTva) {
        this.selectedTva = selectedTva;
    }
    
    
    /**
     * crée un tva avec un nom générique
     * @param libelle le libellé de la nouvelle tva
     * @param taux le taux de la nouvelle tva
     */
    public void createTva(String libelle, Float taux) {
        TbTva newTva = new TbTva(libelle, taux);
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        tbTvaDAO.save(newTva);
    }

    /**
     * met à jour une tva
     * @param tva la tva à mettre à jour
     */
    public void saveTva(TbTva tva) {
        if (tva != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.update(tva);
        }
    }

    /**
     * supprime une tva
     * @param tva la tva à supprimer
     */
    public void deleteTva(TbTva tva) {
        if (tva != null) {
            TbTvaDAO tbTvaDAO = new TbTvaDAO();
            tbTvaDAO.remove(tva);
        }
    }

    /**
     * récupère toutes les tva de la base de données
     * @return la liste des tva
     */
    public List<TbTva> loadTva() {
        TbTvaDAO tbTvaDAO = new TbTvaDAO();
        return tbTvaDAO.findAll();
    }
}