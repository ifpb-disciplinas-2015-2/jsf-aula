package ifpb.ads.jsf.web;

import ifpb.ads.jsf.domain.Pessoa;
import ifpb.ads.jsf.infra.Pessoas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/01/2017, 07:24:44
 */
@Named
@SessionScoped
//@RequestScoped

public class ControladorPessoa implements Serializable {

    private Pessoa pessoa;
    
//    @Inject
    @EJB
    private Pessoas daoPessoa;
    
    private List<Pessoa> listaDePessoa;

    private boolean editando = false;

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
//        this.daoPessoa = new PessoaMemoria();
//        this.daoPessoa = new PessoaBD();
        this.listaDePessoa = daoPessoa.todasAsPessoas();
    }

    public String editar(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.editando = true;
        return null;
    }

    public String excluir(Pessoa pessoa) {
        this.daoPessoa.excluirPessoa(pessoa);
        this.listaDePessoa = daoPessoa.todasAsPessoas();
        return null;
    }

    public String atualizar() {
        daoPessoa.atualizarPessoa(pessoa);
        this.editando = false;
        this.pessoa = new Pessoa();
        this.listaDePessoa = daoPessoa.todasAsPessoas();
        return null; //redirecionando
    }

    public String salvar() {
        daoPessoa.salvar(pessoa);
        this.pessoa = new Pessoa();
        this.listaDePessoa = daoPessoa.todasAsPessoas();
        return null; //redirecionando
    }

    public List<Pessoa> getListaDePessoa() {
        return listaDePessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

}
