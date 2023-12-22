package cb.basica;

//entidade ou básica
public class Especie {
	private Integer id;
	private String nomeespecie;
	private String lote;
	private String especimes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeespecie() {
		return nomeespecie;
	}
	public void setNomeespecie(String nomeespecie) {
		this.nomeespecie = nomeespecie;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getEspecimes() {
		return especimes;
	}
	public void setEspecimes(String especimes) {
		this.especimes = especimes;
	}

}
