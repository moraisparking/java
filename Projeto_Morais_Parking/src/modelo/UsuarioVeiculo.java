package modelo;

import java.sql.Date;

public class UsuarioVeiculo {
	
	private int id;
	private String matricula;
	private String nome;
	private String placa;
	private String marca;
	private String tipo;
	private Date data;
	private String hora;
	private String status;
	private String bloco;

	
	public UsuarioVeiculo() {
		
	}

	public UsuarioVeiculo(String matricula, String nome, String placa, String marca, String tipo) {
		this.matricula = matricula;
		this.nome = nome;
		this.placa = placa;
		this.marca = marca;
		this.tipo = tipo;
	}

	public UsuarioVeiculo(String placa) {
		this.placa = placa;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
