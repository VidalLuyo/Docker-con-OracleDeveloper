package pe.edu.vallegrande.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.project.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    // Buscar clientes por estado (A o I)
    List<Client> findByStatus(String status);

    // Buscar clientes cuyo estado NO sea el indicado
    List<Client> findByStatusNot(String status);

    // Buscar clientes por teléfono
    List<Client> findByPhone(String phone);

    // Buscar todos los clientes ordenados por nombre
    List<Client> findAllByOrderByFirstNameAsc();
}
