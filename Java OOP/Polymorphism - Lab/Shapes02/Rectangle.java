package Polymorphism02;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }
}
