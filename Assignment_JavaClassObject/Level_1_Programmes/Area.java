//  Problem 2 Program to Compute Area of a Circle
// Problem Statement: Write a program to create a Circle class with an attribute radius. Add methods to calculate and display the area and circumference of the circle.

class Area{
    double radius;
    Area(double radius){
        this.radius=radius;
    }
    void DisplayArea(){
        System.out.println("Area of Circle is-> "+3.14*radius*radius);
    }
    public static void main(String[] args){
        Area a=new Area(5);
        a.DisplayArea();
    }
 }