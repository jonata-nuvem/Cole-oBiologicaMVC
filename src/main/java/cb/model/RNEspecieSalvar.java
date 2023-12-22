package cb.model;

import cb.basica.Especie;
import cb.repository.ConexaoException;
import cb.repository.DAOEspecie;
import cb.repository.RepositoryException;

public class RNEspecieSalvar {
//O método aceita um parâmetro do tipo Especie chamado especie//
	public void salvar(Especie especie) throws Exception{
		//validar dados
		validar(especie);
		//verificar inconsistencias
//		verificar(especie);
		//enviar para o responsável pela persistencia
		inserir(especie);
			}
//////////////////////INSERIR////////////////////			
			private void inserir(Especie especie)throws Exception {
				DAOEspecie dao = new DAOEspecie();
				try {
					dao.inserir(especie);
				} catch (ConexaoException e) {
					throw new Exception("Estamos com dificultadades no BD.");

				} catch (RepositoryException e) {
					throw new Exception("Estamos com dificultades no Código");
				}
	
}

//////////////////////VALIDAR////////////////////
			private void validar(Especie especie) throws Exception{
				if ((especie.getNomeespecie()==null) ||
						especie.getNomeespecie().isEmpty()) {
						throw new Exception("Nome da espécie inválido");
					}
				if ((especie.getLote()==null) ||
						especie.getLote().isEmpty()) {
					throw new Exception("Lote da espécie inválido");
				}
				if ((especie.getEspecimes()==null) ||
						especie.getEspecimes().isEmpty()) {
					throw new Exception("Especimes da espécie inválido");
				}
			}
}
			
//////////////////////VERIFICAR DUPLICATA////////////////////
			/**
			 * verifica se existe duplicidade de cadastro
			 * @param especie
			 */
/*			private void verificar (Especie especie)throws Exception {
				//chama a persistencia para ver se já existe nome da especie no BD
			DAOEspecie dao = new DAOEspecie();
			try {
				Especie aux = dao.consulta(especie.getLote());
				if(aux !=null) {
					throw new Exception("lote duplicado");
				}				
				
			} catch (ConexaoException e) {
				throw new Exception("Estamos com dificultadades no BD.");

			} catch (RepositoryException e) {
				throw new Exception("Estamos com dificultades no Código");
			}
			}
		}
			*/