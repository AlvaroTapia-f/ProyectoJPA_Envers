package audit;


import lombok.*;
import org.hibernate.envers.RevisionEntity;
import config.CustomRevisionListener;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Revision implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(name = "revision_seq", sequenceName = "rbac.seq_revision_id", allocationSize = 1)
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    private Date date;
}
