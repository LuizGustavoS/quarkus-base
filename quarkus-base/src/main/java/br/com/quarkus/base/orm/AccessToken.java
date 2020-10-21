package br.com.quarkus.base.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Data
@Entity
@Table(name = "access_token")
@EqualsAndHashCode(callSuper = true)
public class AccessToken extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "access_token", nullable = false, updatable = false, unique = true, length = 36)
    private String accessToken;

    @Column(name = "refresh_token", nullable = false, updatable = false, unique = true, length = 36)
    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private Usuario usuario;

    public static Optional<AccessToken> testToken(String accessToken){
        return Optional.of(new AccessToken());
    }

}
