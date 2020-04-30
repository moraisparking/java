package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.Eventos;

public class ConexaoEventos {
	
	private Connection conexao;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public ConexaoEventos(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirEvento(Eventos evento) throws SQLException {
		 
		String sql = "insert into eventos(evento, data_inicio, data_fim, local, vagas, vagas_extras, status) values(?,?,?,?,?,?, 'futuro')";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, evento.getNomeEvento());
		stmt.setString(2, sdf.format(evento.getDataInicio()));
		stmt.setString(3, sdf.format(evento.getDataFim()));
		stmt.setString(4, evento.getBlocoRealizado());
		stmt.setInt(5, evento.getVagasConsumidas());
		stmt.setInt(6, evento.getVagaExtras());
		
		
		stmt.execute();
		
	}
	
	public List<Eventos> pesquisarEvento(String status) throws SQLException {
		
		String sql = "select * from eventos where status = ?;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, status);
		
		stmt.execute();
		
		List<Eventos> tabela = new ArrayList<>();
		
		ResultSet resultado = stmt.getResultSet();
		
		
		while(resultado.next()) {
			Eventos evento = new Eventos();
			evento.setNomeEvento(resultado.getString("evento"));
			evento.setDataInicio(resultado.getDate("data_inicio"));
			evento.setDataFim(resultado.getDate("data_fim"));
			evento.setBlocoRealizado(resultado.getString("local"));
			evento.setVagasConsumidas(resultado.getInt("vagas"));
			evento.setVagaExtras(resultado.getInt("vagas_extras"));
			evento.setStatus(resultado.getString("status"));
			tabela.add(evento);
		}
		return tabela;	
		
	}
	
	

}
