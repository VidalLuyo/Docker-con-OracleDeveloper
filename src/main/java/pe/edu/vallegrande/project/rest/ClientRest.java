package pe.edu.vallegrande.project.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.project.model.Client;
import pe.edu.vallegrande.project.service.ClientService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/client")
public class ClientRest {

    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Optional<Client> client = clientService.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar por estado
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Client>> findByStatus(@PathVariable String status) {
        return ResponseEntity.ok(clientService.findByStatus(status));
    }

    // Crear cliente
    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    // Actualizar cliente
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(clientService.update(id, client));
    }

    //  Eliminar lógicamente
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ♻ Restaurar cliente
    @PutMapping("/restore/{id}")
    public ResponseEntity<Void> restore(@PathVariable Long id) {
        clientService.restore(id);
        return ResponseEntity.noContent().build();
    }
}
