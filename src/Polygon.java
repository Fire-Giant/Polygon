/**
 * @file
 * @date 2/2/2023
 * @author Theo
 * @description creates any regular polygon with a variety of methods
 */
import java.text.DecimalFormat;
public class Polygon {
    private int numSides; //takes the number of sides
    private double sideLength; //is for the length of the side
    private String shapeName; //takes the input for the name of the shape
    private boolean validPolygon = true; //tracks if polygon is valid
    //Creates a polygon object with side length one that is a square
    public Polygon(){
        numSides = 4;
        sideLength = 1;
        shapeName = "square";
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
            numSides = -1;
            validPolygon = false;
        }
        //Tests is sidelength is allowed and sets it if allowed
        if(length>= 0) {
            sideLength = length;
        }
        //if sideLength is invalids sets to -1 and makes polygon false
        else{
            sideLength = -1;
            validPolygon = false;
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
    public String getShapeName(){
        return shapeName;
    }
    //Next week
    public double calculatePerimeter(){

        if(validPolygon == true){
            return sideLength*numSides;
        }
        else{
            return -1;
        }
    }
    /**
     * @Description Calculates and returns the area of the polygon
     */
    public double calculateArea(){
        double apothem = sideLength/(2*Math.tan(Math.PI/numSides));

        return (sideLength*numSides*apothem)/2;
    }
    //tells whether or not the polygon can exist
    public boolean isValidPolygon(){
        return validPolygon;
    }

    /**
     * @Description Modifies the number of sides of the polygon
     * @param n
     */
    public void setNumSides(int n){

        if(n >= 3) numSides = n;
        else numSides = -1;
        if(numSides >= 3 && sideLength > 0) validPolygon = true;
        else validPolygon = false;
    }

    /**
     * @Description Modifies the side length of the Polygon
     * @param sideL
     */
    public void setSideLength(double sideL){
        if(sideL > 0) sideLength = sideL;
        else sideLength = -1;
        if(numSides >= 3 && sideLength > 0) validPolygon = true;
        else validPolygon = false;
    }

    /**
     * @Desciption Changes the name of the polygon
     * @param name
     */
    public void setShapeName(String name){
        shapeName = name;
    }

    //Returns all the attributes of the polygon or says the polygon is invalid
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("#.###");
        if(validPolygon == true){
            return "This is a " + numSides+"-sided "+shapeName+" with a side length of "+formatter.format(sideLength)+ " a perimeter of "+formatter.format(calculatePerimeter())+" and an area of "+ formatter.format(calculateArea());
        }
        else{
            return "NO: Invalid polygon!!!!!!";
        }
    }




}



