package entidades;


import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "Domicilio")
@Audited
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCalle;
    private int numero;

    //Esta es la manera de hacer bidireccional una relacion OneToOne
    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

}
