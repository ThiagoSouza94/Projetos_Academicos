package sisrh.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;

@Api
@Path("/solicitacao")
public class SolicitacaoRest {  

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitacoes() {
        try {
            List<Solicitacao> solicitacoes = Banco.listarSolicitacoes();
            GenericEntity<List<Solicitacao>> entity = new GenericEntity<List<Solicitacao>>(solicitacoes) {};
            return Response.ok().entity(entity).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao listar solicitações!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterSolicitacao(@PathParam("id") int id) {
        try {
            Solicitacao solicitacao = Banco.buscarSolicitacaoPorId(id);
            if (solicitacao != null) {
                return Response.ok().entity(solicitacao).build();
            } else {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao obter solicitação!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response incluirSolicitacao(Solicitacao solicitacao) {
        try {
            Solicitacao novaSolicitacao = Banco.incluirSolicitacao(solicitacao);
            return Response.ok().entity(novaSolicitacao).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na inclusão da solicitação!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarSolicitacao(@PathParam("id") int id, Solicitacao solicitacao) {
        try {
            Solicitacao solicitacaoExistente = Banco.buscarSolicitacaoPorId(id);
            if (solicitacaoExistente == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
            
            // Atualizar os campos da solicitação existente com os valores da solicitação recebida
            //solicitacaoExistente.setDescricao(solicitacao.getDescricao());
            //solicitacaoExistente.setStatus(solicitacao.getStatus());
            // Continue com os demais campos que deseja atualizar
            
            // Salvar a solicitação alterada no banco de dados
            Banco.alterarSolicitacao(id, solicitacaoExistente);

            return Response.ok().entity(solicitacaoExistente).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao alterar solicitação!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirSolicitacao(@PathParam("id") int id) {
        try {
            // Verificar se a solicitação existe antes de tentar excluir
            if (Banco.buscarSolicitacaoPorId(id) == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
            
            // Excluir a solicitação
            Banco.excluirSolicitacao(id);
            
            // Retornar uma mensagem informando que a exclusão foi realizada com sucesso
            return Response.ok().entity("{ \"mensagem\" : \"Solicitação excluída com sucesso!\" }").build();
        } catch (Exception e) {
            // Em caso de erro, retornar uma mensagem de erro
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha ao excluir solicitação!\", \"detalhe\" : \"" + e.getMessage() + "\" }").build();
        }
    }
}
