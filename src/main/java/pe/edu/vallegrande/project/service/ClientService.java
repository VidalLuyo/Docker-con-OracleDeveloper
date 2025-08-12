package pe.edu.vallegrande.project.service;

import pe.edu.vallegrande.project.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAll();

    Optional<Client> findById(Long id);

    List<Client> findByStatus(String status);

    Client save(Client client);

    Client update(Long id, Client client);

    void delete(Long id);

    void restore(Long id);
}
