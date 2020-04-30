package conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

import modelo.UsuarioVeiculo;
import modelo.Vagas;
import telas_extras.Erro;

public class ConexaoVeiculo {
	
	private Connection conexao;

	public ConexaoVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public ConexaoVeiculo(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirVeiculo(UsuarioVeiculo veiculo) throws SQLException {
		String sql = "insert into veiculos(matricula, nome, placa, marca, tipo, data, hora, status, bloco) values (?, ?, ?, ?, ?, curdate(), curtime(), 'PRESENTE', ?);";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, veiculo.getMatricula());
		stmt.setString(2, veiculo.getNome());
		stmt.setString(3, veiculo.getPlaca());
		stmt.setString(4, veiculo.getMarca());
		stmt.setString(5, veiculo.getTipo());
		stmt.setString(6, veiculo.getBloco());
		
		
		stmt.execute();
		stmt.close();
	}
	public void removerVeiculo(UsuarioVeiculo placa) throws SQLException {
		
		String sql = "update veiculos set status = 'AUSENTE', data = curdate(), hora = curtime() where placa = ?;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

		stmt.setString(1, placa.getPlaca());

		stmt.execute();
		stmt.close();
				
	}
	
	public void pesquisarVeiculo(UsuarioVeiculo veiculo) throws SQLException {
		
		String sql = "select * from veiculos where placa = ?;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, veiculo.getPlaca());
		
		stmt.execute();
		
		ResultSet resultado = stmt.getResultSet();
		if(resultado.next()){
			veiculo.setMatricula(resultado.getString("matricula"));
			veiculo.setNome(resultado.getString("nome"));
			veiculo.setMarca(resultado.getString("marca"));
			veiculo.setTipo(resultado.getString("tipo"));
			veiculo.setStatus(resultado.getString("status"));
		}else {
			Erro erro = new Erro();
		}
		stmt.close();
		
	}
	public List<UsuarioVeiculo> pesquisarVeiculoPorBloco(String bloco) throws ParseException, SQLException{
		
		
		String sql = "select * from veiculos where bloco = ? and status = 'PRESENTE';";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, bloco);
		
		stmt.execute();
		
		ResultSet resultado = stmt.getResultSet();
		
		List<UsuarioVeiculo> tabela = new ArrayList<>();
		
		try {

			while (resultado.next()) {
				UsuarioVeiculo usu = new UsuarioVeiculo();

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date data;

				usu.setMatricula(resultado.getString("matricula"));
				usu.setNome(resultado.getString("nome"));
				usu.setPlaca(resultado.getString("placa"));
				usu.setMarca(resultado.getString("marca"));
				usu.setTipo(resultado.getString("tipo"));
				usu.setData(resultado.getDate("data"));
				usu.setHora(resultado.getString("hora"));
				usu.setStatus(resultado.getString("status"));
				usu.setBloco(resultado.getString("bloco"));
				tabela.add(usu);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConexaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);

		}
		stmt.close();
		
		return tabela;
		
	}
	
	public void qntDeVagasPorBloco(Vagas local) throws SQLException {
	
		
		String sql = "select bloco as ?, count(*) as qnt from veiculos where status = 'presente' and tipo = 'carro' and bloco = ? group by bloco;";
		String sql2 = "select bloco as ?, count(*) as qnt from veiculos where status = 'presente' and tipo = 'moto' and bloco = ? group by bloco;";
		String sql3 = "select bloco as ?, count(*) as qnt from veiculos where status = 'presente' and tipo = 'especiais' and bloco = ? group by bloco;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, local.getLocal());
		stmt.setString(2, local.getLocal());
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		stmt2.setString(1, local.getLocal());
		stmt2.setString(2, local.getLocal());
		PreparedStatement stmt3 = (PreparedStatement) conexao.prepareStatement(sql3);
		stmt3.setString(1, local.getLocal());
		stmt3.setString(2, local.getLocal());
		
		stmt.execute();
		stmt2.execute();
		stmt3.execute();
		ResultSet resultado = stmt.getResultSet();
		ResultSet resultado2 = stmt2.getResultSet();
		ResultSet resultado3 = stmt3.getResultSet();
		if(resultado.next()) {
			
			if(local.getLocal().equals(resultado.getString("bloco_A"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_B"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_C"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_D"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_E"))) {
				local.setCarro( resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_F"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_G"))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString("bloco_central"))) {
				local.setCarro(resultado.getInt("qnt"));
			}
		}
		if(resultado2.next()) {
			
			String x = local.getLocal();
			System.out.println(x);
			System.out.println(y);
			
			if(local.getLocal().equals(resultado2.getString("bloco_A"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_B"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_C"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_D"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_E"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_F"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_G"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString("bloco_central"))) {
				local.setMoto(resultado2.getInt("qnt"));
			}
		}
		
		if(resultado3.next()) {
			
			if(local.getLocal().equals(resultado3.getString("bloco_A"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_B"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_C"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_D"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_E"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_F"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_G"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString("bloco_central"))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}
		}
		stmt.close();
		stmt2.close();
		stmt3.close();
		
	}

}
