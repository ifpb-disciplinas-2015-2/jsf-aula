package ifpb.ads.jsf.aulas;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/01/2017, 09:22:14
 */
@Named
@RequestScoped
public class Bean {

    private String nome;

    public String tratarEvento() {
        // trabalhar a lógica de negócio
        this.nome = "Chaves";
        // redirecionar
//        return "admin/home.xhtml?faces-redirect=true";

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("", new FacesMessage("oi"));
            context.addMessage("", new FacesMessage("oi2"));
            context.addMessage("", new FacesMessage("oi3 "));
            
        return "admin/home.xhtml";

    }

    
    public String segundoEvento(){
        return null;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
