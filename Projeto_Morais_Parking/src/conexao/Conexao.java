package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	private String endereco = "jdbc:mysql://localhost/db_morais_parking?allowPublicKeyRetrieval=true&useSSL=false";
	private String usuario = "namikoka";
	private String senha = "Y1832902204c";
	
	//M�todo para fazer conexao
	public Connection fazer_conexao() throws SQLException {
		//fa�o uma conexao do tipo Cennection
		//Onde � preciso chamar o DriverManager para pegar uma conexao .getConnection
		Connection fazer_conexao = DriverManager.getConnection(endereco,usuario,senha);
		//Como o m�todo � do tipo Connection, � preciso retornar uma conexao
		return fazer_conexao;
		
		
	}

}
