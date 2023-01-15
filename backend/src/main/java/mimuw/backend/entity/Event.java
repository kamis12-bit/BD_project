package mimuw.backend.entity;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "promoter_event")
public class Event {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false)
    private String name;

    private String description;

//    @Column(nullable = false)
    private String beginDate;

//    @Column(nullable = false)
    private String endDate;

//    @Column(nullable = false)
    private Integer archived;
}
