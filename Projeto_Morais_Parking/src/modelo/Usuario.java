package modelo;

public class Usuario {
	
	private int id;
	private String usuario;
	private String email;
	private String senha;
	private String cargo;

	
	public Usuario(int id, String usuario, String email, String senha) {
		this.id = id;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String usuario, String email, String senha) {
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
