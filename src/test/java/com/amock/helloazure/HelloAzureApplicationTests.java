package com.amock.helloazure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloAzureApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void getTestEndpointReturnsExpectedPayload() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Kalyan. This is version 2"));
    }

    @Test
    void getTest2EndpointReturnsExpectedPayload() throws Exception {
        mockMvc.perform(get("/test2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Kalyan2"));
    }

    @Test
    void postTestPostEchoesPayload() throws Exception {
        String payload = "{\"firstName\":\"Azure\",\"lastName\":\"Spring\"}";

        mockMvc.perform(post("/testpost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Azure"))
                .andExpect(jsonPath("$.lastName").value("Spring"));
    }
}
