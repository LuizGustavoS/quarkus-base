package br.com.quarkus.base.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = true)
public class Cliente extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "id_cliente", nullable = false, updatable = false, unique = true)
    private Long idCliente;

    @Column(name = "ds_nome", nullable = false, length = 100)
    private String dsNome;

    @Column(name = "ds_cpf", nullable = false, length = 14, unique = true)
    private String dsCpf;

    @ManyToOne
    @JoinColumn(name = "id_usuario_cadastro", nullable = false, updatable = false)
    private Usuario usuarioCadastro;

}
