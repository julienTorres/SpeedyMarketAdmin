package greta.speedymarket.services;

import greta.speedymarket.dao.TbArticleDAO;
import greta.speedymarket.model.TbArticle;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author julienTorres
 */
@ManagedBean(name="TbArticleService")
@ViewScoped
public class TbArticleService {

    private TbArticle selectedArticle;
   
    public TbArticle getSelectedArticle() {
        return selectedArticle;
    }

    public void setSelectedArticle(TbArticle selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    /**
     * crée un nouvel article avec un nom générique et un statut invisible
     */
    public void createArticle() {
        TbArticle newArticle = new TbArticle("Nouvel article", false);
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        tbArticleDAO.save(newArticle);
    }

    /**
     * met à jour un article
     * @param article l'article à mettre à jour
     */
    public void saveArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.update(article);
        }
    }

    /**
     * supprime un article
     * @param article l'article à supprimer
     */
    public void deleteArticle(TbArticle article) {
        if (article != null) {
            TbArticleDAO tbArticleDAO = new TbArticleDAO();
            tbArticleDAO.remove(article);
        }
    }
    
    /**
     * récupère tous les articles de la base de données
     * @return la liste des articles
     */
    public List<TbArticle> loadArticles() {
        TbArticleDAO tbArticleDAO = new TbArticleDAO();
        return tbArticleDAO.findAll(); 
    }
    
}