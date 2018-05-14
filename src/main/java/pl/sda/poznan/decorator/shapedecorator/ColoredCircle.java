package pl.sda.poznan.decorator.shapedecorator;

//Ta klasa jest dekoratorem - dekoruje klase circle o nowe pole kolor
public class ColoredCircle implements Shape {

    private String color;
    private Shape circleToDecorate;

    public ColoredCircle(Shape circle, String color) {
        this.color = color;
        this.circleToDecorate = circle;
    }

    @Override
    public String info() {
        return circleToDecorate.info() + " has the color " + color;
    }
}
