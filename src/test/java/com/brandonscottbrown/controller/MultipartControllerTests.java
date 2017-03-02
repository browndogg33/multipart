package com.brandonscottbrown.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MultipartControllerTests{

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFileUploadWithNumber() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "file.txt",  "application/json",  "{\"json\": \"someValue\"}".getBytes());

        mvc.perform(fileUpload("/multipart/long")
                .file(file)
                .param("id", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFileUploadWithString() throws Exception {
        MockMultipartFile file = new MockMultipartFile("data", "file-name.data", "text/plain", "some other type".getBytes());
        MockMultipartFile jsonFile = new MockMultipartFile("jsonPartRequest", "", "application/json", "{\"subject\": \"someValue\", \"id\": 1}".getBytes());

        mvc.perform(fileUpload("/multipart/string")
                .file(jsonFile)
                .file(file))
                .andExpect(status().isOk());
    }
}
