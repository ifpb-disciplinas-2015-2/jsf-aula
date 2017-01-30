package ifpb.ads.jsf.aula.mobile;

import ifpb.ads.jsf.domain.Pessoa;
import ifpb.ads.jsf.infra.Pessoas;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 30/01/2017, 11:06:24
 */
@Path("pessoa")
@Stateless
public class PessoaPublic {

    @Inject
    private Pessoas pessoas;
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Pessoa> recuperar(){
        return pessoas.todasAsPessoas();
    }
}
