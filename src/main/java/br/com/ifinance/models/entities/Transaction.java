package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.Mean;
import br.com.ifinance.models.enums.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_transaction", name = "transaction")
@Table(name = "TB_TRANSACTION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction")
    @Column(name = "id_transaction")
    private Long id;

    @Column(name = "nm_transaction")
    private String name;

    @Column(name = "dsc_transaction")
    private String description;

    @Column(name = "amount_transaction")
    private Double amount;

    @Column(name = "dt_transaction")
    private String date;

    @Column(name = "done_transaction")
    private Boolean done;

    @Column(name = "toDo_Transaction")
    private String toDo;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_transaction")
    private TransactionType transactionType;

    @Column(name = "means_transaction")
    @Enumerated(EnumType.STRING)
    private Mean mean;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
