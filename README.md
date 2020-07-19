# SpringBoot

+ gradle




+ helloController

    ```java
    package com.senshig.hello.web;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HelloController {
        
        @GetMapping("/hello")
        public String hello(){
            return "hello";
        }
    }

    ```

+ helloController Test 코드 작성
    + 메인 프로그램을 실행시키지 않고도 테스트코드로 정상동작되는지 확인할 수 있다.

    ```
    @RunWith(SpringRunner.class)

    테스트를 진행할때 JUinit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
    여기서는 SpringRunner라는 스프링 실행자 사용.

    @WebMvcTest
    SpringMVC 에 집중할 수 있는 어노테이션

    private MockMvc mvc
    웹 API를 테스트할 때 사용. 스프링MVC의 시작점
    
    mvc.perform(get("/hello"))
    MockMvc를 통해 /hello Url로 HTTP GET 요청을 한다.

    .andExpect(status().isOk())
    mvc.perform의 status를 검증.(200,400,500 ...)
    isOk() 200,

    .andExpect(content().string(hello));
    mvc.perform의 결과를 검증
    음답 본문의 내용을 검증

    get,satus,content는
    
  import static org.springframework.test.web.servlet.request.  MockMvcRequestBuilders.*;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
    가 필요하다.

    ```

    ```java
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
        public void hello가_리턴된다() throws Exception {
            String hello = "hello";
            mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
        }

    
    }
    ```
