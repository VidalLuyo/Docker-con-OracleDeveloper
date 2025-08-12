package pe.edu.vallegrande.project.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "CLIENT", schema = "DEVELOPER_01") // Se fuerza el esquema y nombre exacto
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "phone", columnDefinition = "CHAR(9)") // match exacto con CHAR(9)
    private String phone;

    @Column(name = "status", nullable = false, columnDefinition = "CHAR(1) DEFAULT 'A'")
    private String status = "A";

    @Column(name = "register_date")
    private LocalDate registerDate;

}
