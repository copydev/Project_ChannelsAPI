package com.example.sampleproject;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNull;


@SpringBootTest
//@ContextConfiguration(classes = SampleProjectApplicationTests.class)
//@WebMvcTest(value = ProjectController.class)
class SampleProjectApplicationTests {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectRepository projectRepository;

//    @Test
//    void contextLoads() {
//    }

    ArrayList<Channel> news = new ArrayList<>(Arrays.asList(new Channel(303,"NDTV","news",120), new Channel(305,"Zee News","news",125)));
    ArrayList<Channel> sport = new ArrayList<>(Arrays.asList(new Channel(402,"Star Sports","sport",150), new Channel(404,"ESPN","sports",200)));
    ArrayList<Channel> cartoon = new ArrayList<>(Arrays.asList(new Channel(1000,"CN","cartoon",12)));

    List<Project> projects = new ArrayList<>(Arrays.asList(
            new Project("abc",10.0,3, new HashMap<String,ArrayList<Channel>>(){{
                put("sport", sport);
                put("cartoon",cartoon);
            }}),
            new Project("def",20.0,3,new HashMap<String, ArrayList<Channel>>(){{
                put("news",news);
                put("cartoon",cartoon);
            }} ),
            new Project("abc",30.0,5, new HashMap<String,ArrayList<Channel>>(){{
                put("sport", sport);
                put("cartoon",cartoon);
            }})
    ));

    List<Project> projects2 = new ArrayList<Project>(Arrays.asList(
            new Project("1","abc",10.0,3, new HashMap<String,ArrayList<Channel>>(){{
                put("sport", sport);
                put("cartoon",cartoon);
            }})
    ));

    @Test
    public void getAllProjectsTest() {
//        when(projectRepository.findAll()).thenReturn(projects);
        when(projectRepository.findAll()).thenReturn(projects);

//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/projects/all").accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = "{" +
//                "{\n" +
//                "    \"name\": \"abc\",\n" +
//                "    \"price\": 10.0,\n" +
//                "    \"channel_cnt\": 3,\n" +
//                "    \"genreToChannel\": {\n" +
//                "        \"news\": [\n" +
//                "            {\n" +
//                "                \"channel_id\": 101,\n" +
//                "                \"name\": \"H\",\n" +
//                "                \"genre\": \"news\",\n" +
//                "                \"price\": 20.0\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"channel_id\": 102,\n" +
//                "                \"name\": \"L\",\n" +
//                "                \"genre\": \"news\",\n" +
//                "                \"price\": 25.0\n" +
//                "            }\n" +
//                "        ]\n" +
//                "    }\n" +
//                "}" +
//                "}";
//
//        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
//
        assertEquals(projects,projectService.getAllProjects());
    }

    @Test
    public void getZeroProjectTest(){
        when(projectRepository.findAll()).thenReturn(null);
        assertNull("Null Object",projectService.getAllProjects());
    }
//
    @Test
    public void getProjectByIdTest(){
        String testid = "1";

        when(projectRepository.findById(testid)).thenReturn(Optional.ofNullable(projects2.get(0)));

        assertEquals (projects2.get(0),projectService.findProjectById("1").get());
    }

//    @Test // Sample Test to find erroe
//    public void getProjectByNameTest() throws Exception {
//        when(projectRepository.findProjectByName("abc")).thenReturn(Optional.ofNullable(projects.get(0)));
//
//        assertEquals(projectService.findProjectByName("abc").get(),projects.get(0));
//    }

    @Test
    public void addProjectTest(){
        projectService.addProject(projects.get(0));
        verify(projectRepository,times(1)).save(projects.get(0));
    }

    @Test
    public void deleteProjectTest(){
        String id = "1";
        projectService.deleteProject(id);
        verify(projectRepository,times(1)).deleteById(id);
    }



}
