package ifpb.ads.jsf.aula.jse;

//import ifpb.ads.jsf.infra.PessoaBD;
import ifpb.ads.jsf.domain.Pessoa;
import ifpb.ads.jsf.infra.Pessoas;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2017, 09:42:26
 */
public class Principal {

    public static void main(String[] args) {
        Pessoas bd = new ServiceLocator()
                .lookup("java:global/jsf-aula-core/PessoaBD", 
                        Pessoas.class);

        for (Pessoa pessoa : bd.todasAsPessoas()) {
               System.out.println(pessoa.getNome()); 
        }
//        Pessoa pessoa = new Pessoa(1, "Job");
//        bd.atualizarPessoa(pessoa);
    }
}
