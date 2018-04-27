package AIHW;

public class City {
    int index;
    double x;
    double y;



    public City(int index, double x, double y){
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public double getIndex(){
        return this.index;
    }
    public double getX(){
        return this.x;
    }


    public double getY(){
        return this.y;
    }


    public double distanceTo(City city){
        double xDistance = Math.abs(getX() - city.getX());
        double yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    @Override
    public String toString(){
        return getIndex()+": "+getX()+", "+getY();
    }
}