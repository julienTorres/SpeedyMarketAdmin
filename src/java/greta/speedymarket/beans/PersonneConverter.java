package greta.speedymarket.beans;

import greta.speedymarket.dao.TbPersonneDAO;
import greta.speedymarket.model.TbPersonne;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean(name="PersonneConverter")
@ViewScoped
public class PersonneConverter implements Converter, Serializable {
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                TbPersonneDAO tbPersonneDAO = new TbPersonneDAO();
                return tbPersonneDAO.findById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid personne."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((TbPersonne) object).getIdPersonne());
        }
        else {
            return null;
        }
    } 
    
}
