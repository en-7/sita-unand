package protensi.sita.model;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", updatable = false, nullable = false)
    private Integer idUser;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    // @NotNull
    // @ElementCollection(targetClass = EnumRole.class)
    // @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name =
    // "id_user"))
    // @Enumerated(EnumType.STRING)
    // @Column(name = "role", nullable = false)
    // private Set<EnumRole> roles;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumRole role;

    @NotNull
    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // @NotNull
    // @CreationTimestamp
    // @Column(name = "created_at", nullable = false)
    // private Timestamp created_at;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    public UserModel(String nama, EnumRole role, String username, String password, String email) {
        this.nama = nama;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}