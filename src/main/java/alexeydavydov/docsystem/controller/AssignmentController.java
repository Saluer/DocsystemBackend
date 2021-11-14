package alexeydavydov.docsystem.controller;

import alexeydavydov.docsystem.model.Assignment;
import alexeydavydov.docsystem.model.Employee;
import alexeydavydov.docsystem.service.AssignmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;

    AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("")
    public List<Assignment> allAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/to/me")
    public List<Assignment> allAssignmentsToMe() {
        return assignmentService.findAssignmentsToMe();
    }

    @GetMapping("/from/me")
    public List<Assignment> allAssignmentsFromMe() {
        return assignmentService.findAssignmentsFromMe();
    }

}
