package murciegalo;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;

public class MurciegaloUI implements UI {
	private AndroidGameGUI gui;
	private MurciegaloGame game = new MurciegaloGame(this);

	public MurciegaloUI(AndroidGameGUI gui) {
		this.gui = gui;
	}

	@Override
	public void onButtonPressed(String name) {
		if (name.equals("Reiniciar Nivel")) {

		} else if (name.equals("Regresar a la pantalla de inicio")) {
			this.gui.removeAllButtons();
			this.initialiseInterface();
		}
	}

	@Override
	public void onCellPressed(int vertical, int horizontal) {
		this.game.click(vertical, horizontal);
		if (vertical == 2 || vertical == 3 || vertical == 4 && game.pantallaDeInicio) {
			this.gui.addButton("Reiniciar Nivel", 20, 60);
			this.gui.addButton("Regresar a la pantalla de inicio", 15, 60);

		}

	}

	@Override
	public void initialiseInterface() {
		// Crea una matriz de sólo una columna con 5 filas, en las que irán,
		// respectivamente, el nombre del juego, la cantidad de dinero disponible, y un
		// acceso a cada uno de los niveles de palabras jugables
		// Todavía se debe realizar la implementación de las imágenes

		this.gui.configureGrid(6, 1, 1, 0, 12);
		this.gui.setBottomSectionProportion(0.2);
		for (int i = 0; i < 6; i++) {
			this.dibujarImagen(0, i, "pantallaDeInicio" + i);
		}
		// this.gui.addButton("Iniciar Juego", 20, 60);
	}

	public void mostrarComentario(String mensaje) {
		this.gui.showTemporaryMessage(mensaje, false);

	}

	public void crearMatriz(int numberOfRows, int numberOfColumns, int verticalSpacing, int horizontalSpacing,
			int textSize) {
		this.gui.configureGrid(numberOfRows, numberOfColumns, verticalSpacing, horizontalSpacing, textSize);
	}

	public void dibujarImagen(int v, int h, String nombreDeImagen) {
		this.gui.setImageOnCell(v, h, nombreDeImagen);
	}

	public void dibujarLetraSeleccionada(int v, int h, String nombreDeImagen) {
		this.gui.setImageOnCell(v, h, nombreDeImagen + "seleccionada");
	}

}
