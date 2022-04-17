package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusLiability;
import lombok.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_liability", name = "liability")
@Table(name = "TB_LIABILITY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Liability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "liability")
    @Column(name = "id_liability")
    private Long id;

    @Column(name = "dsc_liability")
    private String description;

    @Column(name = "vl_liability")
    private Double value;

    @Column(name = "dt_liability")
    private String date;

    @Column(name ="scheduling_liability")
    private String scheduling;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_liability")
    private StatusLiability statusLiability;

    @Enumerated(EnumType.STRING)
    @Column(name = "mean_liability")
    private Mean mean;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


}
