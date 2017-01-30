package ifpb.ads.jsf.infra;

import ifpb.ads.jsf.domain.Pessoa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/01/2017, 07:35:44
 */
public class PessoaMemoria implements Pessoas {

    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public void salvar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
        System.out.println(pessoas.size());
    }

    @Override
    public List<Pessoa> todasAsPessoas() {
        return Collections.unmodifiableList(pessoas);
    }

    @Override
    public void excluirPessoa(Pessoa pessoa) {
        this.pessoas.remove(pessoa);
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa) {

        for (Pessoa pessoaDaLista : pessoas) {
            if (pessoaDaLista.getId()
                    == pessoa.getId()) {
                pessoaDaLista.setNome(pessoa.getNome());
                break;
            }
        }
    }

}
