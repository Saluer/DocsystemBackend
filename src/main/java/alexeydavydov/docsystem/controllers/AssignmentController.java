package alexeydavydov.docsystem.controllers;

import alexeydavydov.docsystem.domain.assignment.Assignment;
import alexeydavydov.docsystem.requests.CreateAssignmentRequest;
import alexeydavydov.docsystem.requests.UpdateAssignmentRequest;
import alexeydavydov.docsystem.services.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final Logger log = LoggerFactory.getLogger(AssignmentController.class);
    private final AssignmentService assignmentService;

    AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    //TODO подумать над добавление find в начале
    @GetMapping("")
    public List<Assignment> allAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/to/me")
    public List<Assignment> allAssignmentsToMe() {
        log.info("Получен запрос на получение всех поручений от меня");

        return assignmentService.findAssignmentsToMe();
    }

    @GetMapping("/from/me")
    public List<Assignment> allAssignmentsFromMe() {
        log.info("Получен запрос на получение всех поручений мне");

        return assignmentService.findAssignmentsFromMe();
    }

    @PostMapping("/create")
    public Assignment createAssignment(CreateAssignmentRequest request) {
        log.info("Получен запрос на создание нового поручения: " + request);

        return assignmentService.createAssignment(request);
    }

    @PostMapping("/update/{id}")
    public Assignment updateAssignment(@PathVariable int id, UpdateAssignmentRequest request) {
        log.info("Получен запрос на редактирование поручения по следующему id: " + id + ". Данные запроса: " + request);

        return assignmentService.updateAssignment(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable int id) {
        log.info("Получен запрос на удаление поручения по следующему id: " + id);

        assignmentService.deleteAssignment(id);
    }

    @GetMapping("/{id}")
    public Optional<Assignment> findAssignmentById(@PathVariable int id) {
        log.info("Получен запрос на получение поручения по следующему id: " + id);

        return assignmentService.findById(id);
    }

}
