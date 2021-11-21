package alexeydavydov.docsystem.controllers;

import alexeydavydov.docsystem.domain.Organization;
import alexeydavydov.docsystem.services.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final Logger log = LoggerFactory.getLogger(OrganizationController.class);
    private final OrganizationService organizationService;

    OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public Optional<Organization> findById(@PathVariable("id") int id) {
        log.info("Получен запрос на получение данных организации по следующему id: " + id);

        return organizationService.findById(id);
    }
}
