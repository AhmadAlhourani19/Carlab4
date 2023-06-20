package drawingTool;
import java.awt.Color;
import java.util.ArrayList;
import graphicState.AllCarState;
import graphicState.State;

public class Scene {
    private ArrayList<LocatedRectangle> sceneObjects = null;
    private static State graphicState;
    
    public Scene() {
        sceneObjects = new ArrayList<LocatedRectangle>();
        graphicState = AllCarState.getInstance(this);

    }
    
    private void addObject(LocatedRectangle newObject) {
        boolean intersection = false;
        
        for (LocatedRectangle m : sceneObjects) {
            intersection = intersection || m.intersects(newObject);
        }
        if (!intersection) {
            sceneObjects.add(newObject);
        }
    }

    public void draw() {
        for (LocatedRectangle o : sceneObjects) {
            if (o.getClass() == Car.class) {
                ((Car)o).draw();
            } 
        }
    }
    
    public void setBlueCar() {
        graphicState = graphicState.setBlueCars();
    }
    
    public void setRedCar() {
        graphicState = graphicState.setRedCars();
    }
    
    public void setYellowCar() {
        graphicState = graphicState.setYellowCars();
    }
    
    public void setAllCars() {
        graphicState = graphicState.setAllCars();
    }
    
    public void setNoCars() {
        graphicState = graphicState.setNoCars();
    }
    
    public void generateCars() {
        for (int i = 0; i < 100; i++) {
            int x = RandomNumber.between(0, 1200);
            int y = RandomNumber.between(0, 700);
            
            LocatedRectangle aCar = new Car(x, y, randomColor());
            addObject(aCar);
        } 
    }
    
    public void generateCars(Color color) {
        for (int i = 0; i < 100; i++) {
            int x = RandomNumber.between(0, 1200);
            int y = RandomNumber.between(0, 700);
            
            LocatedRectangle aCar = new Car(x, y, color);
            addObject(aCar);
        } 
    }
    
    public void removeAllObjects() {
        sceneObjects.removeAll(sceneObjects);
    }
    
    public Color randomColor() {
        int k = RandomNumber.between(0, 2);
        
        switch(k) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.YELLOW;
            default:
                return Color.RED;
        }
    }
}
