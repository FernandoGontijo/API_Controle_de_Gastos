package gontijo.fernando.desafioexacta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Gasto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGasto;


    private String nome;


    private String descricao;


    private LocalDateTime date;


    private Double valor;


    private String Tags;






}
