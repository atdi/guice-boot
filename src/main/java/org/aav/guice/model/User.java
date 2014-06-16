package org.aav.guice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@GeneratePojoBuilder(withCopyMethod = true)
public class User {

    @Id
    @Column(name = "id", unique = true)
    UUID id;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "first_name")
    String firstName;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    String lastName;
    @NotNull
    @Column(name = "birth_date")
    Date birthDate;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "email", unique = true)
    String email;
    @NotNull
    @Size(min = 3, max = 200)
    @Column(name = "password", unique = true)
    String password;
    @Column(name = "active")
    boolean active = false;
    @Column(name = "admin")
    boolean admin = false;

}
