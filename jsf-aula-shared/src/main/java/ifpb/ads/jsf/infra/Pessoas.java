 
package ifpb.ads.jsf.infra;

import ifpb.ads.jsf.domain.Pessoa;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/01/2017, 08:27:44
 */
public interface Pessoas {

    void atualizarPessoa(Pessoa pessoa);

    void excluirPessoa(Pessoa pessoa);

    void salvar(Pessoa pessoa);

    List<Pessoa> todasAsPessoas();
    
}
