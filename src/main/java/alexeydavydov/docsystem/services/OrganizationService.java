package alexeydavydov.docsystem.services;

import alexeydavydov.docsystem.domain.Organization;
import alexeydavydov.docsystem.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Optional<Organization> findById(int id) {
        return organizationRepository.findById(id);
    }
}
