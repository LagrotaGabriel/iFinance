package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.Frequency;
import br.com.ifinance.models.enums.IncomeType;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_income", name = "income")
@Table(name = "TB_INCOME")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "income")
    @Column(name = "id_income")
    private Long id;

    @Column(name = "dsc_income")
    private String description;

    @Column(name = "vl_income")
    private Double value;

    @Column(name = "dt_income")
    private String date;

    @Column(name = "frequency_income")
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(name = "type_income")
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
