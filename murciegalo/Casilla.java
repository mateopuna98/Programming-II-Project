package murciegalo;

public abstract class Casilla {
	protected MurciegaloGame game;
	private char letra;

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public char getLetra() {
		return letra;
	}

	
}
