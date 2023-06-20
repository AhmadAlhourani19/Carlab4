package graphicState;

import drawingTool.Scene;

public abstract class State {
	protected Scene scene;
	
	public abstract State setBlueCars();
	public abstract State setRedCars();
	public abstract State setYellowCars();
	public abstract State setAllCars();
	public abstract State setNoCars();
}
