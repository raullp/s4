package org.thinknear.s4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.services.ClassSoftDeletableService;

import javax.websocket.server.PathParam;

/**
 * Created by raul on 7/14/16.
 */
@Controller
public class ClassController {

    @Autowired
    protected ClassSoftDeletableService classSoftDeletableService;

    @RequestMapping(path = "/v1/api/classes/{class}/enable", method = RequestMethod.GET)
    public ResponseEntity<String> enable(@PathParam("class") Class aClass) {
        classSoftDeletableService.enable(aClass);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/v1/api/classes/{class}/disable", method = RequestMethod.GET)
    public ResponseEntity<String>  disable(@PathParam("class") Class aClass) {
        classSoftDeletableService.disable(aClass);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
