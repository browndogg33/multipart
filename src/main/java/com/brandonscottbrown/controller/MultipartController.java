package com.brandonscottbrown.controller;


import com.brandonscottbrown.model.JsonPartRequest;
import com.brandonscottbrown.response.MultipartResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping(value = "/multipart")
public class MultipartController {

    @RequestMapping(value = "/long", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<MultipartResponse> fileUploadWithNumber(@RequestParam(value = "id", required = true) Long id,
                                                           @RequestParam(value = "file", required = true) MultipartFile file) {
        MultipartResponse response = new MultipartResponse("SAVED", new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/string", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<MultipartResponse> fileUploadWithString(@RequestPart(value = "jsonPartRequest", required = true) JsonPartRequest jsonPartRequest,
                                                                  @RequestPart(value = "data", required = true) MultipartFile file) {
        MultipartResponse response = new MultipartResponse("SAVED", new Date());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

