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
@Table(name = "promoter_promo_message")
public class PromoMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String publicationDate;

    @Column(nullable = false)
    private Integer published;

    @Column(nullable = false)
    private Long event;

    private Long graphics;

    private Long description;

    @Column(nullable = false)
    private Long hasType;
}
