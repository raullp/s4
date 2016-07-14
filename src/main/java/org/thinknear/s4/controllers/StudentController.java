package org.thinknear.s4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.services.StudentSoftDeletableService;

import javax.websocket.server.PathParam;

/**
 * Created by raul on 7/14/16.
 */
@Controller
public class StudentController {

    @Autowired
    protected StudentSoftDeletableService softDeletableService;

    @RequestMapping(path = "/v1/api/students/{student}/enable", method = RequestMethod.GET)
    public ResponseEntity<String> enable(@PathParam("id") Student student) {
        softDeletableService.enable(student);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/v1/api/students/{student}/disable", method = RequestMethod.GET)
    public ResponseEntity<String>  disable(@PathParam("student") Student student) {
        softDeletableService.disable(student);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
