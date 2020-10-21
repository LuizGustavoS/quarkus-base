package br.com.quarkus.base.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(callSuper = true)
public class Usuario extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "id_usuario", nullable = false, updatable = false, unique = true)
    private Long idUsuario;

    @Column(name = "ds_nome", nullable = false, unique = true)
    private String dsNome;

}
