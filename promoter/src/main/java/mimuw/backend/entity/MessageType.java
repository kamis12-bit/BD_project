package mimuw.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promoter_message_type")
public class MessageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

//    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    @Column(length = 100, nullable = false)
    private String name;

//    @Column(columnDefinition = "VARCHAR2(20) NOT NULL")
    @Column(length = 20, nullable = false)
    private String colour;
}
