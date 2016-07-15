package org.thinknear.s4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.search.SearchableStudentRepository;
import org.thinknear.s4.services.StudentSoftDeletableService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by raul on 7/14/16.
 */
@Controller
public class StudentController {

    @Autowired
    protected StudentSoftDeletableService softDeletableService;

    @Autowired
    protected SearchableStudentRepository searchableStudentRepository;

    @RequestMapping(path = "/v1/api/students/{student}/enable", method = RequestMethod.GET)
    public ResponseEntity<String> enable(@PathParam("student") Student student) {
        softDeletableService.enable(student);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/v1/api/students/{student}/disable", method = RequestMethod.GET)
    public ResponseEntity<String>  disable(@PathParam("student") Student student) {
        softDeletableService.disable(student);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/v1/api/_search/students/{query}", method = RequestMethod.GET)
    public ResponseEntity<String>  search(@PathVariable String query) {
        List<Student> students = StreamSupport
                .stream(searchableStudentRepository.search(queryStringQuery(query)).spliterator(), false)
                .collect(Collectors.toList());
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
