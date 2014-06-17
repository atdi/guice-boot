package org.aav.guice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by aurel.avramescu on 15/06/2014.
 */
@Table
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@GeneratePojoBuilder(withCopyMethod = true)
public class Role implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    UUID id;
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", unique = true, nullable = false)
    String name;
    @ManyToMany(fetch = FetchType.LAZY)
    Set<User> users = new HashSet<User>();
}
