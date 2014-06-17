package org.aav.guice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@GeneratePojoBuilder(withCopyMethod = true)
public class User implements Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    UUID id;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "first_name", nullable = false)
    String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "last_name", nullable = false)
    String lastName;
    @NotNull
    @Column(name = "birth_date")
    Date birthDate;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "email", unique = true, nullable = false)
    String email;
    @NotNull
    @Size(min = 3, max = 200)
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "active")
    boolean active = false;
    @Column(name = "admin")
    boolean admin = false;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    Set<Role> roles = new HashSet<Role>();
}
