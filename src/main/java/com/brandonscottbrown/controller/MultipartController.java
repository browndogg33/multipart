package com.brandonscottbrown.controller;


import com.brandonscottbrown.response.MultipartResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping(value = "/multipart")
public class MultipartController {

    @RequestMapping(value = "/long", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<MultipartResponse> fileUploadWithNumber(@RequestPart(value = "id", required = true) Long id,
                                                           @RequestPart(value = "file", required = true) MultipartFile file) {
        MultipartResponse response = new MultipartResponse("SAVED", new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/string", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<MultipartResponse> fileUploadWithString(@RequestPart(value = "id", required = true) String id,
                                                                  @RequestPart(value = "file", required = true) MultipartFile file) {
        MultipartResponse response = new MultipartResponse("SAVED", new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

