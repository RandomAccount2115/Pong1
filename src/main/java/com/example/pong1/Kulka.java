package com.example.pong1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Kulka {

    private static final double R = 10;

    protected double ySpeed;
    protected double xSpeed;
    protected double xPos;
    protected double yPos;

    private double radius;

    protected Color color;





    Kulka(double xPos, double yPos, double xSpeed, double ySpeed){

        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        color = Color.WHITESMOKE;

        radius = 10;

    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed, Color color){

        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        this.color = color;

        radius = 10;

    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed, double radius){

        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        color = Color.WHITESMOKE;

        this.radius = radius;

    }

    Kulka(double xPos, double yPos, double xSpeed, double ySpeed, Color color, double radius){

        this.xPos = xPos;
        this.yPos = yPos;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        this.color = color;

        this.radius = radius;

    }

    public void checkBoundaryCollision (double xLeft, double yTop, double xRight, double yBottom){

        if ((xPos <= xLeft + radius || (xPos >= xRight - radius))){
            xSpeed = -xSpeed;
        }
        if ((yPos <= yTop + radius || (yPos >= yBottom - radius))){
            ySpeed = -ySpeed;
        }

    }

    public void draw(GraphicsContext gc){

        gc.setFill(Color.WHITESMOKE);
        gc.fillOval(xPos + radius, yPos + radius, 2*radius, 2*radius);

    }

    public void update(){

        xPos += xSpeed;
        yPos += ySpeed;

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
