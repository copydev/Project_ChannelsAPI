package com.example.sampleproject;

import com.example.sampleproject.ApiExceptions.ApiEmptyException;
import com.example.sampleproject.ApiExceptions.ApiRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    //Project Service
//    @Autowired
//    private ProjectService projectService;
    private static Logger logger = LogManager.getLogger(ProjectController.class);


//    private ProjectRepository projectRepository;

//    public ProjectController(ProjectRepository projectRepository) { // VERY NECESSARY
//        this.projectRepository = projectRepository;
//    }

    public ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Welcome Mapping
    @RequestMapping("/")
    public String welcomeScreen(){
        return "Hello";
    }

    //GET
    @RequestMapping("/projects/all")
    public ResponseEntity<List<Project>> getAllProjects() throws ApiRequestException {

        logger.info("GET all projects requested.");

//        List<Project> projects = projectRepository.findAll();
        List<Project> projects = projectService.getAllProjects();
        if(projects.isEmpty()){
            logger.warn("GET all project is returning null.");
            return ResponseEntity.noContent().build();
//            return ResponseEntity.projects;
        }

        logger.info("GET all project successful");
        return ResponseEntity.ok().body(projects);
    }

    //GET SINGLE
    @RequestMapping("/projects/id/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) throws ApiEmptyException {
        logger.info("GET Project "+id+" requested.");
//        Optional<Project> project = projectRepository.findById(id);
        Optional<Project> project = projectService.findProjectById(id);
        if(project.isPresent()){
            logger.info("GET Project "+id + " Successful.");
            return ResponseEntity.ok().body(project.get());
        }
        else {
            logger.error("GET Project "+id+" Not Successful.");
            throw new ApiEmptyException("Project "+id+" is not found");
        }
    }

    @RequestMapping("/projects/name/{name}")
    public ResponseEntity<Project> getProjectByName(@PathVariable String name) throws Exception {
        logger.info("GET Project by name: "+name+" requested.");
//        Optional<Project> project = projectRepository.findById(id);
        Optional<Project> project = projectService.findProjectByName(name);
        if(project.isPresent()){
            logger.info("GET Project by name: "+name + " Successful.");
            return ResponseEntity.ok().body(project.get());
        }
        else {
            logger.error("GET Project by name:"+name+" Not Successful.");
            throw new ApiEmptyException("Project "+name+" is not found");
        }
    }

    //POST REQUEST
    @RequestMapping(method = RequestMethod.POST,value = "/projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project) throws ApiRequestException {

        logger.info("POST Project requested.");

//        if( project.project_id == null || !projectRepository.findById(project.project_id).isPresent()) {
        if(project.project_id == null || !projectService.findProjectById(project.project_id).isPresent()){
//            projectRepository.save(project);
            projectService.addProject(project);
            logger.info("POST PROJECT successful");
            return new ResponseEntity<>("Project created successfully", HttpStatus.CREATED);
        }
        else {
            logger.error("POST project unsuccessful. Project already present.");
            throw new ApiRequestException("Requested project already exists.");
        }
    }

    //PUT REQUEST
    @RequestMapping(method = RequestMethod.PUT,value = "/projects")
    public ResponseEntity<Object> replaceProject(@RequestBody Project project) throws ApiEmptyException {
//        System.out.println(id+"hello world");
        logger.info("PUT project requested.");
//        if(project.project_id == null || !projectRepository.findById(project.project_id).isPresent()){
        if(project.project_id == null || !projectService.findProjectById(project.project_id).isPresent()){
            logger.error("PUT Project unsuccessful. Project is not present. Request  POST first.");
            throw new ApiEmptyException();
        }
        else {
//            projectRepository.save(project);
            projectService.addProject(project);
            logger.info("PUT Project successful");
            return new ResponseEntity<>("Project "+project.project_id +" Updated Successfully",HttpStatus.OK);
        }
    }

    //DELETE REQUEST
    @RequestMapping(method = RequestMethod.DELETE,value = "/projects/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable String id) throws ApiEmptyException {
        logger.info("DELETE project requested.");
//        if(projectRepository.findById(id).isPresent()){
        if(projectService.findProjectById(id).isPresent()){
//            projectRepository.deleteById(id);
            projectService.deleteProject(id);
            logger.info("DELETE Project Successful");
            return new ResponseEntity<>("Project "+ id + " Deleted Successfully",HttpStatus.OK);
        }
        else {
            logger.error("DELETE Project Unsuccessful. Project is not present. REQUEST POST first.");
            throw new ApiEmptyException();
        }

    }

    //ADD CHANNEL __ Extra Task....
//    @RequestMapping(method = RequestMethod.POST, value = "/projects/{id}/channels")
//    public void addChannel(@RequestBody Channel channel, @PathVariable String id){
//        Optional<Project> optional = projectRepository.findById(id);
//        Project project = optional.get();
//        ArrayList<Channel> list = project.genreToChannel.get(channel.genre);
//        list.add(channel);
//        project.genreToChannel.put(channel.genre,list);
//        this.projectRepository.save(project);
//    }


}
