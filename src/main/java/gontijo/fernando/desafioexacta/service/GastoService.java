package gontijo.fernando.desafioexacta.service;


import gontijo.fernando.desafioexacta.dto.GastoDTO;
import gontijo.fernando.desafioexacta.model.Gasto;
import gontijo.fernando.desafioexacta.repository.GastoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    private ModelMapper modelMapper = new ModelMapper();



    public GastoDTO criarGasto(GastoDTO gastoDTO) {

        validarGasto(gastoDTO);
        Gasto gasto = modelMapper.map(gastoDTO, Gasto.class);
        Gasto gastoCriado = gastoRepository.save(gasto);
        return modelMapper.map(gastoCriado, GastoDTO.class);
    }


    private void validarGasto(GastoDTO gasto) throws IllegalArgumentException{

        if (gasto.getNome() == null || gasto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome da pessoa é obrigatório");
        }
        if (gasto.getDescricao() == null || gasto.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("A descrição é obrigatória.");
        }
        if (gasto.getDate() == null) {
            throw new IllegalArgumentException("A data/hora é obrigatória.");
        }
        if (gasto.getValor() == null || gasto.getValor() <= 0) {
            throw new IllegalArgumentException("O valor é obrigatório e deve ser maior que zero.");
        }
    }


    public List<GastoDTO> listarGastos(){

        List<Gasto> gastos = gastoRepository.findAll();
        List<GastoDTO> gastosDTO = new ArrayList<>();
        gastos.forEach(gasto -> gastosDTO.add(modelMapper.map(gasto, GastoDTO.class)));
        return gastosDTO;
    }

    public GastoDTO listarGastoPorId(Long id){

        Optional<Gasto> gasto = gastoRepository.findById(id);

        if (gasto.isPresent()) {
            return modelMapper.map(gasto.get(), GastoDTO.class);
        } else {
            return null;
        }


    }

}
