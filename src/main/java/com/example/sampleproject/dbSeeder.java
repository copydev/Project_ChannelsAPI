package com.example.sampleproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Component
public class dbSeeder implements CommandLineRunner {

    private ProjectRepository projectRepository;

    public dbSeeder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        ArrayList<Channel> news = new ArrayList<>(Arrays.asList(new Channel(101,"H","news",20), new Channel(102,"L","news",25)));
        ArrayList<Channel> sport = new ArrayList<>(Arrays.asList(new Channel(103,"S","sport",50)));
        ArrayList<Channel> cartoon = new ArrayList<>(Arrays.asList(new Channel(104,"CN","cartoon",12)));


        List<Project> projects = new ArrayList<>(Arrays.asList(
                new Project("abc",10.0,3, new HashMap<String,ArrayList<Channel>>(){{
                    put("news", news);
                }}),
                new Project("def",20.0,3,new HashMap<String, ArrayList<Channel>>(){{
                    put("sport",sport);
                    put("cartoon",cartoon);
                }} )
        ));

        this.projectRepository.deleteAll();
        this.projectRepository.saveAll(projects);

    }
}
