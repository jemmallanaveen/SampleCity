import java.util.ArrayList;
import java.util.List;

public class City {
    private String cityName;
    private List<String> connectedCities = new ArrayList<>();

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getConnectedCities() {
        return connectedCities;
    }
    public void addCity(String cityName) {
        connectedCities.add(cityName);
    }
}
