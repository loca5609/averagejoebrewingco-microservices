package edu.averagejoecoffeeco.coffeedb.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coffee")
public class Coffee {

    @Id
    String id;

    private String name;
    private String roast;
    private String aroma;
    private String acidity;
    private String body;
    private String flavor;
    private String country;
    private String farm;
    private String production;
    private String imgUrl;
    private Integer inventory;
    private Double price;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Coffee(String name, String roast, String aroma, String acidity, String body, String flavor, String country,
            String farm, String production, String imgUrl, Integer inventory, Double price) {
        this.roast = roast;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
        this.flavor = flavor;
        this.country = country;
        this.farm = farm;
        this.production = production;
        this.imgUrl = imgUrl;
        this.inventory = inventory;
        this.price = price;
    }

    public String getRoast() {
        return this.roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getAroma() {
        return this.aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getAcidity() {
        return this.acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFlavor() {
        return this.flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFarm() {
        return this.farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getProduction() {
        return this.production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getInventory() {
        return this.inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

}
