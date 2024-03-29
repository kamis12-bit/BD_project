package mimuw.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promoter_promo_message")
public class PromoMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "NUMBER(10)")
    private Long id;

//    @Column(columnDefinition = "VARCHAR2(100) NOT NULL")
    @Column(length = 100, nullable = false)
    private String name;

//    @Column(columnDefinition = "DATE NOT NULL")
    @Column(nullable = false)
    private LocalDateTime publicationDate;

//    @Column(columnDefinition = "NUMBER(1) NOT NULL")
    @Column(nullable = false)
    private Integer published;

//    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    @Column(nullable = false)
    private Long event;

//    @Column(columnDefinition = "NUMBER(10)")
    private Long graphics;

//    @Column(columnDefinition = "NUMBER(10)")
    private Long description;

//    @Column(columnDefinition = "NUMBER(10) NOT NULL")
    @Column(nullable = false)
    private Long hasType;

    public PromoMessage(PromoMessage promoMessage) {
        this.id = null;
        this.name = promoMessage.getName();
        this.publicationDate = promoMessage.getPublicationDate();
        this.published = promoMessage.getPublished();
        this.event = promoMessage.getEvent();
        this.graphics = promoMessage.getGraphics();
        this.description = promoMessage.getDescription();
        this.hasType = promoMessage.getHasType();
    }
}
