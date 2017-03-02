package com.brandonscottbrown.controller;


import com.brandonscottbrown.response.MultipartResponse;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MultipartController {

    @RequestMapping(value = "/multipart", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<MultipartResponse> fileUploadWithParams(@RequestPart(value = "id", required = true) Long id,
                                                           @RequestPart(value = "file", required = true) MultipartFile file) {
        //do some stuff
        MultipartResponse response = new MultipartResponse("SAVED", new DateTime());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

