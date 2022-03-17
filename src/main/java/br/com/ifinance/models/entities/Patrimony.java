package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.PatrimonyType;
import lombok.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_patrimony", name = "patrimony")
@Table(name = "TB_PATRIMONY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Patrimony {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "patrimony")
    @Column(name = "id_patrimony")
    private Long id;

    @Column(name = "nm_patrimony")
    private String name;

    @Column(name = "dsc_patrimony")
    private String description;

    @Column(name = "vl_patrimony")
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_patrimony")
    private PatrimonyType patrimonyType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
