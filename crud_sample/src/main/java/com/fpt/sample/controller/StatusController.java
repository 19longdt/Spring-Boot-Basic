package com.fpt.sample.controller;

import com.fpt.sample.constant.CommonConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatusController {

    @GetMapping(CommonConstant.STATUS_URL)
    public ResponseEntity<Map<Integer, String>> getAllStatus(){
        return new ResponseEntity<>(CommonConstant.MAP_STATUS,HttpStatus.OK);
    }
}
