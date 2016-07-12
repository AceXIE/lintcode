/**
 * Created by Administrator on 2016/7/12.
 */

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Triangle1 implements Shape {
    public void draw() {
        System.out.println("  /\\  ");
        System.out.println(" /  \\ ");
        System.out.println("/____\\");
    }
}

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equals("Square")) {
            return new Square();
        } else if (shapeType.equals("Triangle")) {
            return new Triangle1();
        } else if (shapeType.equals("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape shape = sf.getShape("Square");
        shape.draw();
    }
}
