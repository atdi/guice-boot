package org.aav.guice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Entity
@Getter
@EqualsAndHashCode(of = {"id"})
@GeneratePojoBuilder(withCopyMethod = true)
public class User {

    @Id
    @Column(name = "id", unique = true)
    private UUID id;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "birth_date")
    private Date birthDate;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "email", unique = true)
    private String email;
    @NotNull
    @Size(min = 3, max = 200)
    @Column(name = "password", unique = true)
    private String password;
    @Column(name = "active")
    private boolean active = false;
    @Column(name = "admin")
    private boolean admin = false;
}
