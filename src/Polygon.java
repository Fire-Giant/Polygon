/**
 * @file Polygon
 * @date 2/9/2023
 * @author Theo
 * @description Creates any regular polygon with a variety of methods
 */
public class Polygon {
    private int numSides;
    private double sideLength;
    private String shapeName;
    private boolean validPolygonSides = true;
    private boolean validPolygonSideLength = true;
    private double area;
  
    public Polygon(){
        numSides = 3;
        sideLength = 1;
        shapeName = "Triangle";
    }

    /**
     * Creates a new rectangle with side number, side length, and shape type
     * @param sides
     * @param length
     * @param shape
     */
    public Polygon(int sides, double length, String shape){

        if(sides >= 3 && length > 0){
            numSides = sides;
           sideLength = length;
        }
        else{
          if(sides < 3){
            validPolygonSides = false;
          }
          if(length <= 0){
            validPolygonSideLength = false;
          }
          sideLength = 1;
          numSides = 3;
          shapeName = "Triangle";
        }
      if(validPolygonSides && validPolygonSideLength){
        shapeName = shape;
      }
    }

    /**
     * @return returns the number of sides of the polygon
     */
    public int getNumSides(){
        return numSides;
    }
    /**
     * @return returns the side length of the polygon's sides 
     */
    public double getSideLength(){
        return sideLength;
    }
    /**
     * @return returns the type of the polygon
     */
    public String getShapeType(){
        return shapeName;
    }
    /**
     * @return Returns if the polygon is valid
     */
    public boolean isValidPolygon(){
        return validPolygonSideLength && validPolygonSides;
    }

    /**
     * @Description Modifies the number of sides of the polygon
     * @param n is the new number of sides
     */
    public void setNumSides(int n){

        if(n >= 3){
            numSides = n;
            validPolygonSides = true;
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
    }

    /**
     * @Desciption Changes the name of the polygon
     * @param name
     */
    public void setShapeName(String name){
        shapeName = name;
    }
    /**
     * @Description Calculates perimeter of the polygon
     * @Return Returns the perimeter of the polygon to three decimal places
     */
    public double calculatePerimeter(){

            return Math.round(1000*sideLength*numSides)/1000.0;
    }
    /**
     * @Description Calculates area of polygon
     * @Return Returns the area of the polygon to three decimal places
     */
    public double calculateArea(){
        area = Math.round(1000*sideLength*numSides*sideLength/(2*Math.tan(Math.PI/numSides))/2)/1000.0;
        return area;
    }
    /**
     * @Description Calculates area of polygon
     * @Return the area of the polygon to three decimal places
     */
    public double getArea(){
      area = calculateArea();
      return area;
    }

    /**
     * @description Prints out the information of the polygon formatted nicely
     * @return A string with the information of the polygon
     */
    public String toString(){
        if(validPolygonSides && validPolygonSideLength){
            return "Your shape is a "+getShapeType()+ " and it has "+getNumSides()+" sides." +
                    "\nIt has a side length of "+getSideLength()+
                    "\nIt has a perimeter of "+calculatePerimeter()+"units."+
                    "\nIt has an area of "+calculateArea()+".";
        }
        else{
            return "Not a valid polygon. Your polygon has "+numSides+" sides, is named "+shapeName+", and has a side length of " +sideLength+".";
        }
    }
}