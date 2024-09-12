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
@Table(name = "Categoria")
@Audited
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
}
