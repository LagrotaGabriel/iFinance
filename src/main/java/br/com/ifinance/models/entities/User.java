package br.com.ifinance.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "TB_USER")
@SequenceGenerator(allocationSize = 1, sequenceName = "sq_user", name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user")
    @Column(name = "id_user")
    private Long id;

    @Column(name = "usrnm_user")
    private String username;
    @Column(name = "pwd_user")
    private String password;
    @Column(name = "nm_user")
    private String name;
    @Column(name = "lastname_user")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "birthdate_user")
    private String birthDate;
    @Column(name = "works_user")
    private Boolean works;
    @Column(name = "fixedIncome_user")
    private Double fixedIncome;
    @Column(name = "wage_user")
    private Double wage;
    @Column(name = "variableIncome_user")
    private Double variableIncome;
    @Column(name = "extraIncome_user")
    private Double extraIncome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patrimony> assets;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Liability> liabilities;
}
