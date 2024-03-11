package gontijo.fernando.desafioexacta.repository;

import gontijo.fernando.desafioexacta.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    List<Gasto> findAll();

    Optional<Gasto> findById(Long id);

    Gasto save(Gasto gasto);

}
