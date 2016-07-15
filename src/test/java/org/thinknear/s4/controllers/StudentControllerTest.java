package org.thinknear.s4.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.thinknear.s4.S4Application;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.repositories.StudentRepository;

/**
 * Created by raul on 7/15/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(S4Application.class)
@WebAppConfiguration
@IntegrationTest
public class StudentControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
    Student student;
    String lastName = "Solo";
    String firstName = "Han";
    String largeText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus imperdiet ut est eu ultrices. Quisque lorem arcu, ullamcorper sed lorem ac, hendrerit placerat turpis. Nullam id leo dolor. Aenean molestie id orci eget venenatis. Sed tempor erat in amet.";
    @Autowired
    StudentRepository studentRepository;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        studentRepository.deleteAll(); //make sure to clear previous data
    }

    @After
    public void after() {
        studentRepository.deleteAll();
    }

    @Test
    public void itShouldCreateAStudent() throws Exception {
        student = new Student(firstName, lastName);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().isCreated());

        Page<Student> search = studentRepository.search(firstName, new PageRequest(1, 20));

        assertThat(search.getTotalElements(), is(1L));
    }

    @Test
    public void itShouldReturnInvalidParamWhenFirstNameIsNull() throws Exception {
        student = new Student(null, lastName);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void itShouldReturnInvalidParamWhenFirstNameIsTooLarge() throws Exception {
        student = new Student(largeText, lastName);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void itShouldReturnInvalidParamWhenFirstNameEmpty() throws Exception {
        student = new Student("", lastName);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void itShouldReturnInvalidParamWhenLastNameIsNull() throws Exception {
        student = new Student(firstName, null);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void itShouldReturnInvalidParamWhenLatNameEmpty() throws Exception {
        student = new Student(firstName, "");

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void itShouldReturnInvalidParamWhenLastNameIsTooLarge() throws Exception {
        student = new Student(firstName, largeText);

        mockMvc.perform(post("/v1/api/students").contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(student)))
                .andExpect(status().is4xxClientError());
    }

}
