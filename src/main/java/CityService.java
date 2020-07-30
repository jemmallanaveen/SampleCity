import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class CityService {
    public static void main(String[] args) {
        Map<String, City>  citiesMap = new HashMap<>();
        Path path = Paths.get("/Users/njemmalla/Documents/GitHub/mobilessp-devenv/workspace/SampleCity/src/main/resources/city.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(str -> {
            String[] cities = str.split(",");
            if(citiesMap.get(cities[0]) == null) {
                City city = new City();
                city.setCityName(cities[0]);
                city.addCity(cities[1]);
                citiesMap.put(cities[0], city);
                if (citiesMap.get(cities[1]) != null){
                    City city1 = new City();
                    city1.setCityName(cities[1]);
                    city1.addCity(cities[0]);
                    citiesMap.put(cities[1], city);
                }
            } else {
                citiesMap.get(cities[0]).addCity(cities[1]);
            }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s1 = "Boston";
        String s2 = "Newark";
        System.out.println(citiesMap.get(s1).getConnectedCities().get(0));


    }
}
