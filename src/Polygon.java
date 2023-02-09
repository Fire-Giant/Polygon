/**
 * @file
 * @date 2/2/2023
 * @author Theo
 * @description creates any regular polygon with a variety of methods
 */
import java.text.DecimalFormat;
public class Polygon {
    private int numSides;
    private double sideLength;
    private String shapeName;
    private boolean validPolygonSides = true;
    private boolean validPolygonSideLength = true;
    public Polygon(){
        numSides = 3;
        sideLength = 1;
        shapeName = "triangle";
    }
    //Allows the sides, side length, and shape type to be set
    public Polygon(int sides, double length, String shape){
        shapeName = shape;
        //tests if side amount is allowed and assigns numSides if true
        if(sides >= 3){
            numSides = sides;
        }
        //side number is set to -1 if invalid and invalid is set to true
        else{
            numSides = 3;
            validPolygonSides = false;
        }
        //Tests is sidelength is allowed and sets it if allowed
        if(length > 0) {
            sideLength = length;
        }
        //if sideLength is invalids sets to -1 and makes polygon false
        else{
            sideLength = 1;
            validPolygonSideLength = false;
        }


    }
    //returns value numSides
    public int getNumSides(){
        return numSides;
    }
    //returns value sidelength
    public double getSideLength(){
        return sideLength;
    }
    //returns name of polygon
    public String getShapeType(){
        return shapeName;
    }

    public boolean isValidPolygon(){
        return validPolygonSideLength && validPolygonSides;
    }

    /**
     * @Description Modifies the number of sides of the polygon
     * @param n
     */
    public void setNumSides(int n){

        if(n >= 3){
            numSides = n;
            validPolygonSides = true;
        }
        else{
            numSides = 3;
            validPolygonSides = false;
        }

    }

    /**
     * @Description Modifies the side length of the Polygon
     * @param sideL
     */
    public void setSideLength(double sideL){
        if(sideL > 0){
            sideLength = sideL;
            validPolygonSideLength = true;
        }
        else{
            sideLength = 1;
            validPolygonSideLength = false;
        }
    }

    /**
     * @Desciption Changes the name of the polygon
     * @param name
     */
    public void setShape(String name){
        shapeName = name;
    }

    public double calculatePerimeter(){

            return sideLength*numSides;
    }
    /**
     * @Description Calculates and returns the area of the polygon
     */
    public double calculateArea(){
        double apothem = sideLength/(2*Math.tan(Math.PI/numSides));

        return (sideLength*numSides*apothem)/2;
    }
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("#.###");
        if(validPolygonSides && validPolygonSideLength){
            return "Your shape is a "+shapeName+ " and it has "+numSides+" sides.\n" +
                    "It has a side length of "+sideLength+"\nIt has a perimeter of "+formatter.format(calculatePerimeter())+" units."+
                    "\nIt has an area of "+formatter.format(calculateArea())+".";

        }
        else{
            return "Not a valid polygon. Your polygon has "+numSides+" sides, is named "+shapeName+", and has a side length of " +sideLength;
        }
    }

}




