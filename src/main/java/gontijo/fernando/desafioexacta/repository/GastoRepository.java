package gontijo.fernando.desafioexacta.repository;

import gontijo.fernando.desafioexacta.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> findAll();

    Gasto findByIdGasto(Long idGasto);

    Gasto save(Gasto gasto);

}
