package cb.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cb.basica.Especie;
/*Consulta se existe um registro com lote informado
 * e retorna o registro, ou null
 * @param lote
 * @return
 */
public class DAOEspecie { 
//////////////////////CONSULTAR////////////////////
	public Especie consulta(String lote) throws ConexaoException, RepositoryException, ClassNotFoundException {
	String url = "jdbc:mysql://localhost:3306/colecaobiologica?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "1234";
	Especie especie = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	//forName("com.mysql.cj.jdbc.Driver");
	Connection c;
	try {
		c = DriverManager.getConnection(url, user, password);
	}catch(SQLException e){
		throw new ConexaoException(e.getMessage());
	}
	String sql = "SELECT id, lote, nomeespecie, especimes FROM especie WHERE lote=?";
	try {	
		PreparedStatement pstm = c.prepareStatement(sql);
		pstm.setString(1,  lote);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			especie = new Especie();
			especie.setId( rs.getInt("id"));
			especie.setLote( rs.getString("lote"));
			especie.setNomeespecie( rs.getString("nomeespecie"));
			especie.setEspecimes( rs.getString("especiemes"));
		}
	}catch(SQLException e) {
		throw new RepositoryException(e.getMessage());
	}
	return especie;
	
 }
	
//////////////////////INSERIR////////////////////
	public void inserir(Especie especie) throws ConexaoException, RepositoryException, ClassNotFoundException {
	String url = "jdbc:mysql://localhost:3306/colecaobiologica?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "1234";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c;
	try {
		c = DriverManager.getConnection(url, user, password);
	}catch(SQLException e){
		throw new ConexaoException(e.getMessage());
	}
	String sql = "INSERT INTO especies(nomeespecie, lote, especimes) VALUE(?,?,?)";
	try {	
		PreparedStatement pstm = c.prepareStatement(sql);
		pstm.setString(1,especie.getNomeespecie());
		pstm.setString(2,especie.getLote());
		pstm.setString(3,especie.getEspecimes());
		pstm.executeUpdate();
	}catch(SQLException e) {
		throw new RepositoryException(e.getMessage());
	}
	}
}