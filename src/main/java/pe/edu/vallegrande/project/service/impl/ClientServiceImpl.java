package pe.edu.vallegrande.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.project.model.Client;
import pe.edu.vallegrande.project.repository.ClientRepository;
import pe.edu.vallegrande.project.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findByStatus(String status) {
        return clientRepository.findByStatus(status);
    }

    @Override
    public Client save(Client client) {
        client.setStatus("A"); // Estado por defecto activo
        return clientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        Optional<Client> existing = clientRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }

        Client updated = existing.get();
        updated.setFirstName(client.getFirstName());
        updated.setLastName(client.getLastName());
        updated.setPhone(client.getPhone());
        updated.setStatus(client.getStatus() != null ? client.getStatus() : updated.getStatus());

        return clientRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        clientRepository.findById(id).ifPresent(c -> {
            c.setStatus("I"); // Inactivo
            clientRepository.save(c);
        });
    }

    @Override
    public void restore(Long id) {
        clientRepository.findById(id).ifPresent(c -> {
            c.setStatus("A"); // Activo
            clientRepository.save(c);
        });
    }
}
