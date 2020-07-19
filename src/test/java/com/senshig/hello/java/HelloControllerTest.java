package com.senshig.hello.java;

import com.senshig.hello.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_응답_패스하니() throws Exception {
        String hello = "hello3";
        mvc.perform(get("/hello"))
            .andExpect(status().isOk());
     }


    @Test
    public void hello_world가_리턴되니() throws Exception {
        String str = "hello_world";
        mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string(str));
    }

    @Test
    public void hello가_리턴되니() throws Exception {
        String str = "hello";
        mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string(str));
    }
  
}