package entidades;


import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name = "DetalleFactura")
@Audited
public class DetalleFactura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_Articulo")
    private Articulo articulo;
}
