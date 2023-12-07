package cb.model;

import cb.basica.Especie;

public class RNEspecieSalvar {
	public void salvar(Especie nomeespecie)   throws Exception {
		//validar dados
		validar(nomeespecie);
		//verificar inconsistencias
		//enviar para o responsável pela persistencia
	}
	
	private void validar(Especie nomeespecie) throws Exception{
		if ((nomeespecie.getNomeespecie()==null) ||
					nomeespecie.getNomeespecie().isEmpty()) {
				throw new Exception("Nome da espécie inválido");
			}
		if ((nomeespecie.getLote()==null) ||
				nomeespecie.getLote().isEmpty()) {
			throw new Exception("Lote da espécie inválido");
		}
		if ((nomeespecie.getEspecimes()==null) ||
				nomeespecie.getEspecimes().isEmpty()) {
			throw new Exception("Especimes da espécie inválido");
		}

	}
}