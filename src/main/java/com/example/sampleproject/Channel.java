package com.example.sampleproject;

public class Channel {
    int channel_id;
    String name;
    String genre;
    double price;

    public Channel(int channel_id, String name, String genre, double price) {
        this.channel_id = channel_id;
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
