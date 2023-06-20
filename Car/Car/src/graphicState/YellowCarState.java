package graphicState;

import java.awt.Color;

import drawingTool.Scene;

public class YellowCarState extends State{
	private static YellowCarState instance;
	
	private YellowCarState(Scene scene) {
		this.scene = scene;
	}

	public static YellowCarState getInstance(Scene scene) {
		if (instance == null) {
			instance = new YellowCarState(scene);
		}
		return instance;
	}
	
	@Override
	public State setBlueCars() {
		scene.removeAllObjects();
		scene.generateCars(Color.BLUE);
		return BlueCarState.getInstance(scene); 
	}

	@Override
	public State setRedCars() {
		scene.removeAllObjects();
		scene.generateCars(Color.RED);
		return RedCarState.getInstance(scene);
	}

	@Override
	public State setYellowCars() {
		scene.removeAllObjects();
		scene.generateCars(Color.YELLOW);
		return YellowCarState.getInstance(scene);
	}

	@Override
	public State setAllCars() {
		scene.removeAllObjects();
		scene.generateCars();
		return AllCarState.getInstance(scene);
	}

	@Override
	public State setNoCars() {
		scene.removeAllObjects();
		return NoCarState.getInstance(scene);
	}
}
