package com.example.sampleproject;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project,String> {

    Optional<Project> findProjectByName(String name);

}
