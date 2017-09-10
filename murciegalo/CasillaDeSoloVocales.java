package murciegalo;

public class CasillaDeSoloVocales extends Casilla {

	@Override
	public void setLetra(char letra) {

		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == ' ') {
			super.setLetra(letra);
		} else {
			game.mostrarMensaje("Las casillas coloreadas sólo aceptan vocales o espacios");
		}
	}

}
