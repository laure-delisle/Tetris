package fr.esiea.tetris.controler;

import java.awt.event.KeyListener;

import fr.esiea.tetris.model.*;
import fr.esiea.tetris.view.*;

public class Controler {
	private Model model;
	private View view;
	private KeyListenerner keyListener;
	private int keyCode;
	
	public Controler() {
		model = new Model();
		view = new View();
		
	}
}
