package modelo;

public class Vagas {
	
	private String local;
	private final int CARRO = 276;
	private final int MOTO = 69;
	private final int ESPECIAIS = 26;
	private int carro;
	private int moto;
	private int especial;
	
	public Vagas() {
	}
	
	public Vagas(String local) {
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
	public int getCarro() {
		return carro;
	}

	public void setCarro(int carro) {
		this.carro = carro;
	}

	public int getMoto() {
		return moto;
	}

	public void setMoto(int moto) {
		this.moto = moto;
	}

	public int getEspecial() {
		return especial;
	}

	public void setEspecial(int especial) {
		this.especial = especial;
	}
	
	public int totalVagasCarro() {
		return (CARRO - this.carro);
	}
	
	public int totalVagasMoto() {
		return (MOTO - this.moto);
	}
	
	public int totalVagasEspeciais() {
		return (ESPECIAIS - this.especial);
	}
	public int totalVagas() {
		return (CARRO + MOTO + ESPECIAIS)-(this.carro + this.moto + this.especial);
		
	}
	

}
