package modelo;

import java.util.Date;

public class Eventos {
	
	private String nomeEvento;
	private String tipoEvento;
	private Date dataInicio;
	private Date dataFim;
	private String blocoRealizado;
	private int vagasConsumidas;
	private int vagaExtras;
	private String status;
	

	public Eventos(String nomeEvento, Date dataInicio, Date dataFim, String blocoRealizado,
			int vagasConsumidas, int vagaExtras) {
		this.nomeEvento = nomeEvento;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.blocoRealizado = blocoRealizado;
		this.vagasConsumidas = vagasConsumidas;
		this.vagaExtras = vagaExtras;
	}

	public Eventos() {
		// TODO Auto-generated constructor stub
	}

	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getBlocoRealizado() {
		return blocoRealizado;
	}
	public void setBlocoRealizado(String blocoRealizado) {
		this.blocoRealizado = blocoRealizado;
	}
	public int getVagasConsumidas() {
		return vagasConsumidas;
	}
	public void setVagasConsumidas(int vagasConsumidas) {
		this.vagasConsumidas = vagasConsumidas;
	}
	public int getVagaExtras() {
		return vagaExtras;
	}
	public void setVagaExtras(int vagaExtras) {
		this.vagaExtras = vagaExtras;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
