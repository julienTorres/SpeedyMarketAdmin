package greta.speedymarket.services;

import greta.speedymarket.dao.TbCategorieDAO;
import greta.speedymarket.model.TbCategorie;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbCategorieService")
@ViewScoped
public class TbCategorieService {

    private List<TbCategorie> categories;
    private TbCategorie selectedCategorie;

    public TbCategorie getSelectedCategorie() {
        return selectedCategorie;
    }

    public void setSelectedCategorie(TbCategorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }
    
    
    /**
     * crée une catégorie avec un nom générique
     */
    public void createCategorie() {
        TbCategorie newCategorie = new TbCategorie("Nouvelle catégorie");
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        tbCategorieDAO.save(newCategorie);
    }
    
    /**
     * met à jour une catégorie
     * @param categorie la catégorie à mettre à jour
     */
    public void saveCategorie(TbCategorie categorie) {
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.update(categorie);
        }
    }

    /**
     * supprime une catégorie
     * @param categorie la catégorie à supprimer
     */
    public void deleteCategorie(TbCategorie categorie) {
        if (categorie != null) {
            TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
            tbCategorieDAO.remove(categorie);
        }
    }    
    /**
     * récupère toutes les catégories de la base de données
     * @return la liste des catégories
     */
    public List<TbCategorie> loadCategories() {
        TbCategorieDAO tbCategorieDAO = new TbCategorieDAO();
        return tbCategorieDAO.findAll();
    }
 
}