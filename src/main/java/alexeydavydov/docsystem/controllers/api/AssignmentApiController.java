package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.domain.Assignment;
import alexeydavydov.docsystem.services.api.AssignmentAPIService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/assignments")
public class AssignmentApiController {

    private final AssignmentAPIService assignmentService;

    AssignmentApiController(AssignmentAPIService assignmentService) {
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
