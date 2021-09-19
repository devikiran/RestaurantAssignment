package com.mongo.assignment.RestaurantAssignment.DataLoader;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResturantJson {
    @JsonIgnore
    @JsonProperty("URL")
    private String URL;

    @JsonProperty("_id")
    private Map<String,String> _id;

    private String address;
    @JsonProperty("address line 2")

    private String addressline2;
    private String name;
    private String outcode;
    private String postcode;

    @JsonIgnoreProperties
    private String rating;

    private String type_of_food;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Map<String,String> getResturantID() {
        return _id;
    }

    public void setResturantID(Map<String,String> resturantID) {
        this._id = resturantID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutcode() {
        return outcode;
    }

    public void setOutcode(String outcode) {
        this.outcode = outcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType_of_food() {
        return type_of_food;
    }

    public void setType_of_food(String type_of_food) {
        this.type_of_food = type_of_food;
    }


}
