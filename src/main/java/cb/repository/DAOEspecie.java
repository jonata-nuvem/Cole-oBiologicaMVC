package cb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cb.basica.Especie;
/*Consulta se existe um registro com lote informado
 * @param lote
 * @return
 */
public class DAOEspecie {
 public Especie consulta(String lote) {
	String url = "jdbc:mysql://localhost:3306/coleção?useTimezone=true&serverTimezone=UTC";
	String user = "root";
	String password = "1234";
	try {
		Connection c = driverManager.getConnection(url, user, password);
		String sql = "SELECT id, nomeespecie, lote, especimes FROM especie WHERE lote=?";
		PreparedStatement pstm = c.prepareStatement(sql);
		pstm.setString(1,  lote);
		ResultSet rs = pstm.executeQuery();
		Especie nomeespecie = null;
		if(rs.next()) {
			nomeespecie = new Especie();
			nomeespecie.setId( rs.getInt("id"));
			nomeespecie.setNomeespecie( rs.getString("nomeespecie"));
			nomeespecie.setLote( rs.getString("lote"));
			nomeespecie.setEspecimes( rs.getString("especiemes"));
		}
	}catch(SQLException e) {
		throw new RepositoryException(e.getMessage());
	}
	return nomeespecie;
	
 }
}
