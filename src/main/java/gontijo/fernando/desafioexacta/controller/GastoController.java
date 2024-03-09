package gontijo.fernando.desafioexacta.controller;

import gontijo.fernando.desafioexacta.dto.GastoDTO;
import gontijo.fernando.desafioexacta.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;


    @PostMapping
    public ResponseEntity<GastoDTO> criarGasto(@RequestBody GastoDTO gasto) {
        GastoDTO gastoCriado = gastoService.criarGasto(gasto);
        return new ResponseEntity<>(gastoCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GastoDTO>> listarGastos() {
        List<GastoDTO> gastos = gastoService.listarGastos();
        return new ResponseEntity<>(gastos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoDTO> listarGastoPorId(@PathVariable Long id) {
        GastoDTO gasto = gastoService.listarGastoPorId(id);
        if (gasto != null) {
            return new ResponseEntity<>(gasto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
