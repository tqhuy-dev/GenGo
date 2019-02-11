package com.gengroup.huy.gengo.Model;

import java.util.ArrayList;

/**
 * Created by
 * Huy on 2/10/2019.
 */

public class FoodStore extends BaseModel {
    private String ID = "";
    private String storeName = "";
    private String address = "";
    private int ratePoint = 0;
    private int status = 0;
    private int booking = 0;
    private ArrayList<MenuStore> menuStores = new ArrayList<>();

    public String getID() {
        return ID;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddress() {
        return address;
    }

    public int getRatePoint() {
        return ratePoint;
    }

    public int getStatus() {
        return status;
    }

    public int getBooking() {
        return booking;
    }

    public ArrayList<MenuStore> getMenuStores() {
        return menuStores;
    }

    public FoodStore(String ID, String storeName, String address, int ratePoint, int status, int booking, ArrayList<MenuStore> menuStores) {
        this.ID = ID;
        this.storeName = storeName;
        this.address = address;
        this.ratePoint = ratePoint;
        this.status = status;
        this.booking = booking;
        this.menuStores = menuStores;
    }

    public static class FoodStoreBuilder{
        private String ID = "";
        private String storeName = "";
        private String address = "";
        private int ratePoint = 0;
        private int status = 0;
        private int booking = 0;
        private ArrayList<MenuStore> menuStores = new ArrayList<>();

        public FoodStoreBuilder(String ID , String storeName){
            this.ID = ID;
            this.storeName = storeName;
        }

        public FoodStoreBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public FoodStoreBuilder setRatePoint(int ratePoint){
            this.ratePoint = ratePoint;
            return this;
        }

        public FoodStoreBuilder setStatus(int status){
            this.status = status;
            return this;
        }

        public FoodStoreBuilder setBooking(int booking){
            this.booking = booking;
            return this;
        }

        public FoodStoreBuilder setMenu(ArrayList<MenuStore> menu){
            this.menuStores = menu;
            return this;
        }

        public FoodStore build(){
            return new FoodStore(ID , storeName,address , ratePoint , status,booking , menuStores);
        }
    }
}
