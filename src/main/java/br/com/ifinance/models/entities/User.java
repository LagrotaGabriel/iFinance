package br.com.ifinance.models.entities;

import br.com.ifinance.models.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Builder
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
    @Column(name = "nm_user", columnDefinition="VARCHAR(60)")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "birthdate_user")
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Income> incomes;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inflow> inflows;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patrimony> assets;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Liability> liabilities;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
