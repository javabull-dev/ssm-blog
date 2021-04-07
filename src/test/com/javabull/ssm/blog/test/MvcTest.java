//package com.javabull.ssm.blog.test;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
///**
// * 添加@WebAppConfiguration，使@Autowired自动注入WebApplicationContext
// */
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring-core.xml", "classpath:spring-mvc.xml"})
//public class MvcTest {
//
//    @Autowired
//    private WebApplicationContext context;
//    //虚拟的mvc
//    private MockMvc mockMvc;
//
//    @Before
//    public void init() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testGetDepts() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/depts")).andReturn();
//        //获取json数据
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testCheckEmpName() throws Exception {
//        //数据库中存在empName为2b2ad
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/checkName").param("empName", "2b2ad")).andReturn();
//        //获取json数据
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testDelEmp() throws Exception {
//        //数据库中存在empName为2b2ad
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/emp/10006").param("_method", "DELETE")).andReturn();
//        //获取json数据
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testUpdateEmp() throws Exception {
//        //数据库中存在empName为2b2ad
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/emp/10006").param("_method", "PUT")).andReturn();
//        //获取json数据
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testDelEmps() throws Exception {
//        //数据库中存在empName为2b2ad
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/emp/10018-10019")).andReturn();
//        //获取json数据
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);
//    }
//
//    @Test
//    public void testGetBean(){
//        Object dataSource = context.getBean("dataSource");
//        System.out.println(dataSource.getClass());
//    }
//}
