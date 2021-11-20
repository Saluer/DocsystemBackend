package alexeydavydov.docsystem.controllers.api;

import alexeydavydov.docsystem.domain.Organization;
import alexeydavydov.docsystem.services.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/organizations")
public class OrganizationApiController {
    private final Logger log = LoggerFactory.getLogger(OrganizationApiController.class);
    private final OrganizationService organizationService;

    OrganizationApiController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{id}")
    public Optional<Organization> findById(@PathVariable("id") int id) {
        log.info("Получен запрос на получение организации по следующему id: " + id);

        return organizationService.findById(id);
    }
}
