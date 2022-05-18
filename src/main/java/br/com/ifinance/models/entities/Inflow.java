package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.StatusInflow;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_inflow", name = "inflow")
@Table(name = "TB_INFLOW")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Inflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "inflow")
    @Column(name = "id_inflow")
    private Long id;

    @Column(name = "dsc_inflow")
    private String description;

    @Column(name = "vl_inflow")
    private Double value;

    @Column(name = "dt_inflow")
    private String date;

    @Column(name = "scheduling_inflow")
    private String scheduling;

    @Column(name = "created_inflow")
    private String created;

    @Column(name = "status_inflow")
    @Enumerated(EnumType.STRING)
    private StatusInflow statusInflow;

    @Column(name = "mean_inflow")
    @Enumerated(EnumType.STRING)
    private Mean mean;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
