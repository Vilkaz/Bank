package classes;


import java.io.IOException;
import org.json.simple.JSONObject;

/**
 * Created by Vilkaz on 27.06.2015.
 */
public class Address {
    private String streetAndHouseNr;
    private String city;
    private int postalIndex;

    public Address(String streetAndHouseNr, String city, int postalIndex){
        this.setStreetAndHouseNr(streetAndHouseNr);
        this.setCity(city);
        this.setPostalIndex(postalIndex);
    }

    public String toJson() throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("streetAndHouseNr",this.getStreetAndHouseNr());
        obj.put("city",this.getCity());
        obj.put("postalIndex",this.getPostalIndex());
        return obj.toJSONString();
    }
    //region getter and setter

    public String getStreetAndHouseNr() {
        return streetAndHouseNr;
    }

    public void setStreetAndHouseNr(String streetAndHouseNr) {
        this.streetAndHouseNr = streetAndHouseNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalIndex() {
        return postalIndex;
    }

    public void setPostalIndex(int postalIndex) {
        this.postalIndex = postalIndex;
    }

    //endregion getter and setter
}
