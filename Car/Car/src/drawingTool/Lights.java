package drawingTool;
public class Lights {
    
	private Frontlight frontLight; // composite
    private Headlight backLight; // composite
    private Blinker blinker; // composite
    private int x,y;
    
    public Lights(int x, int y){
        frontLight = new Frontlight(x + 20, y + 20);
        backLight = new Headlight(x+ 460, y+ 20);
        blinker = new Blinker(x+ 100, y+ 30);
    }
    public void draw() {
        frontLight.draw();
        backLight.draw();
        blinker.draw();
    }
}
