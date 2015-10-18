package greta.speedymarket.services;

import greta.speedymarket.dao.TbCategorieDAO;
import greta.speedymarket.model.TbCategorie;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name="TbCategorieService")
public class TbCategorieService {
 
    @ManagedProperty(value="#{TbCategorieDAO}")
    TbCategorieDAO tbCategorieDAO;

    private List<TbCategorie> categories;
    private TbCategorie selectedCategorie;

    public void setTbCategorieDAO(TbCategorieDAO tbCategorieDAO) {
        this.tbCategorieDAO = tbCategorieDAO;
    }

    public TbCategorie getSelectedCategorie() {
        return selectedCategorie;
    }

    public void setSelectedCategorie(TbCategorie selectedCategorie) {
        this.selectedCategorie = selectedCategorie;
    }

    public List<TbCategorie> loadCategories() {
    return tbCategorieDAO.findAll();
    }
 
}