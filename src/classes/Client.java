package classes;

import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Vilkaz on 27.06.2015.
 */
public class Client {
    private String name;
    private String lastname;
    private Date birthday;
    private Address adress;

    public Client(String name, String lastname, Date birthday, Address address) {
        this.setName(name);
        this.setLastname(lastname);
        this.setBirthday(birthday);
        this.setAdress(address);
    }

    public String toJson() throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name",this.getName());
        obj.put("lastname",this.getLastname());
        obj.put("birthday",this.getBirthday());
        String addressJson = this.getAdress().toJson();
        obj.put("address", addressJson);
        return obj.toJSONString();


    }

    //region getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }
    //endregion getter and setter

}
