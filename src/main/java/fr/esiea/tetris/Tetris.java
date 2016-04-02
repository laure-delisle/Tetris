package fr.esiea.tetris;

import fr.esiea.tetris.controler.Controler;

public class Tetris {
	public static void main(String[] args) {
		//facade qui cache l'architecture MVC
		Controler controler = new Controler();
	}
}
