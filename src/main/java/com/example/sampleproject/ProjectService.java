package com.example.sampleproject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
//        System.out.println("ok");
        return projectRepository.findAll();
    }

    public Optional<Project> findProjectById(String id){
//        return projects.stream().filter(p -> p.project_id.equals(id)).findFirst().get();
        return projectRepository.findById(id);
    }

    public Optional<Project> findProjectByName(String name) throws Exception {
        throw new Exception();
//        return projectRepository.findProjectByName(name);
    }


    public void addProject(Project project) {
//        projects.add(project);
        projectRepository.save(project);
    }

//    public void replaceProject(Project project, String id) {
////        for(int i = 0;i<projects.size();i++){
////            Project p = projects.get(i);
//////            System.out.println(i);
////            if((p.getProject_id()).equals(id)){
//////                System.out.println("ok");
////                projects.set(i,project);
////                return;
////            }
////        }
//        projectRepository.save(project);
//    }

    public void deleteProject(String id)  {
//        projects.removeIf(p->p.getProject_id().equals(id));
//        throw new Exception();
        projectRepository.deleteById(id);
    }
}
