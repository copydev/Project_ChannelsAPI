package com.example.sampleproject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.*;

@Document(collection = "projects")
public class Project {
    @Id
    String project_id;
    String name;
    double price;
    int channel_cnt;
//    List<Channel> channels;
//    List<Channel> channels = new ArrayList<>(Arrays.asList(
//            new Channel(101,"CN","cartoon",20),
//            new Channel(102,"StarSports","sports",40),
//            new Channel(103,"Discovery","info",30)
//    ));

    Map<String,ArrayList<Channel>> genreToChannel = new HashMap<>();


    public Project() {
    }

//    public Project(int project_id, String name, double price, int channel_cnt) {
//        super();
//        this.project_id = project_id;
//        this.name = name;
//        this.price = price;
//        this.channel_cnt = channel_cnt;
////        channels = new ArrayList<>();
////        channels.add(new Channel("example"));
//        for (Channel channel : channels) {
//            genreToChannel.put(channel.getGenre(), Integer.toString(channel.getChannel_id()));
//        }
//    }
//


    public Project(String project_id, String name, double price, int channel_cnt, Map<String, ArrayList<Channel>> genreToChannel) {
        this.project_id = project_id;
        this.name = name;
        this.price = price;
        this.channel_cnt = channel_cnt;
        this.genreToChannel = genreToChannel;
    }

    public Project(String name, double price, int channel_cnt, Map<String, ArrayList<Channel>> genreToChannel) {
        this.name = name;
        this.price = price;
        this.channel_cnt = channel_cnt;
        this.genreToChannel = genreToChannel;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getChannel_cnt() {
        return channel_cnt;
    }

    public void setChannel_cnt(int channel_cnt) {
        this.channel_cnt = channel_cnt;
    }

//    public List<Channel> getChannels() {
//        return channels;
//    }
//
//    public void setChannels(List<Channel> channels) {
//        this.channels = channels;
//    }


    public Map<String, ArrayList<Channel>> getGenreToChannel() {
        return genreToChannel;
    }

    public void setGenreToChannel(Map<String, ArrayList<Channel>> genreToChannel) {
        this.genreToChannel = genreToChannel;
    }
}
