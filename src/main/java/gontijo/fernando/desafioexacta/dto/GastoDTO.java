package gontijo.fernando.desafioexacta.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
public class GastoDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private String nome;

    private String descricao;

    private LocalDateTime date;

    private Double valor;

    private String Tags;

}
