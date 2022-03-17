package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.LiabilityType;
import lombok.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_liability", name = "liability")
@Table(name = "TB_LIABILITY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Liability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "liability")
    @Column(name = "id_liability")
    private Long id;

    @Column(name = "nm_liability")
    private String name;

    @Column(name = "dsc_liability")
    private String description;

    @Column(name = "vl_liability")
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_liability")
    private LiabilityType liabilityType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
