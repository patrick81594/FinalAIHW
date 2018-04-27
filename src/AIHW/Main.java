package AIHW;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        Random generator = new Random();
        int tempMax = Integer.parseInt(args[1]);
        int tempMin = 1;
        double coolingRate = Double.parseDouble(args[2]);


        for (String data = ""; !data.startsWith("TYPE"); data = scan.nextLine()) {

        }
        scan.next();
        int maxCitys = scan.nextInt();
        ArrayList<City> citysTour = new ArrayList<City>();
        ArrayList<City> neighborTour = new ArrayList<City>();
        //City[] citysTour = new City[maxCitys];
        for (String data = ""; !data.equals("NODE_COORD_SECTION"); data = scan.nextLine()) ;
        for (int cityCounter = 0; cityCounter < maxCitys; cityCounter++) {
            int index = scan.nextInt();
            double xCord = scan.nextDouble();
            double yCord = scan.nextDouble();
            City city = new City(index, xCord, yCord);
            citysTour.add(city);

            System.out.println(city.toString());
        }
        //randomizes the initial tour state.
        Collections.shuffle(citysTour);
        int loops = 0;
        while (tempMax > tempMin && loops < 10) {
            int a = generator.nextInt(maxCitys - 1);
            int b = generator.nextInt(maxCitys - 1);

            neighborTour = (ArrayList<City>) citysTour.clone();

            System.out.println("TEST" + a);

            City posA = citysTour.get(a);
            City posB = citysTour.get(b);
            neighborTour.set(a, posB);
            neighborTour.set(b, posA);
            System.out.println(posA.toString());

            loops++;
        }
        distance(neighborTour);
    }

    public static int distance(ArrayList<City> tour) {
        int distance = 0;
        int counter = 0;
        for (City city : tour) {



             if(tour.indexOf(city) + 1 < tour.size() ) {
                    distance += (int)  Math.round(Math.sqrt((city.getX() - tour.get((tour.indexOf(city) + 1)).getX()) * (city.getX() - tour.get((tour.indexOf(city) + 1)).getX()) + (city.getY() - tour.get((tour.indexOf(city) + 1)).getY() * (city.getY() - tour.get((tour.indexOf(city) + 1)).getY()))));
                    System.out.println("counter" + counter);
             }
            else if(tour.indexOf(city) == tour.size()-1){
                distance += (int) Math.round(Math.sqrt((city.getX()-tour.get(0).getX()) *(city.getX()-tour.get(0).getX()) + (city.getY()-tour.get(0).getY()) * (city.getY()-tour.get(0).getY())));
            }
            counter++;
        }
        System.out.println("Distance: " + distance);
        return distance;
    }
}
