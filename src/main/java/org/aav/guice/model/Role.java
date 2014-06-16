package org.aav.guice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Table
@Entity
@Getter
@Setter
public class Role {
    @Id
    @Column(name = "id", unique = true)
    UUID id;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", unique = true)
    String name;
}
