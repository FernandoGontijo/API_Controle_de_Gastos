package gontijo.fernando.desafioexacta.controller;

import gontijo.fernando.desafioexacta.dto.GastoDTO;
import gontijo.fernando.desafioexacta.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GastoDTO> criarGasto(@RequestBody GastoDTO gasto) {
        return Mono.just(gastoService.criarGasto(gasto));
    }

    @GetMapping
    public Flux<List<GastoDTO>> listarGastos() {
        return Flux.just(gastoService.listarGastos());
    }

    @GetMapping("/{id}")
    public Mono<GastoDTO> listarGastoPorId(@PathVariable Long id) {

        GastoDTO gasto = gastoService.listarGastoPorId(id);
        if (gasto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gasto não encontrado");
        }
        return Mono.just(gasto);
    }


}
