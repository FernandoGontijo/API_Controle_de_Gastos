package gontijo.fernando.desafioexacta.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import gontijo.fernando.desafioexacta.dto.GastoDTO;
import gontijo.fernando.desafioexacta.model.Gasto;
import gontijo.fernando.desafioexacta.repository.GastoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



class GastoServiceTest {

    @Mock
    private GastoRepository gastoRepository;

    @InjectMocks
    private GastoService gastoService;

    GastoDTO gastoDTO_01 = new GastoDTO();
    GastoDTO gastoDTO_02 = new GastoDTO();
    Gasto gasto_01 = new Gasto();
    Gasto gasto_02 = new Gasto();

    List<Gasto> gastos = new ArrayList<>();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        gastoDTO_01.setId(1L);
        gastoDTO_01.setNome("Usuario_01");
        gastoDTO_01.setDescricao("Compras Teste 01");
        gastoDTO_01.setDate(LocalDateTime.parse("2024-03-01T11:45:13"));
        gastoDTO_01.setValor(100.00);

        gastoDTO_02.setId(2L);
        gastoDTO_02.setNome("Usuario_02");
        gastoDTO_02.setDescricao("Compras teste 02");
        gastoDTO_02.setDate(LocalDateTime.parse("2024-03-01T15:30:56"));
        gastoDTO_02.setValor(200.00);


        gasto_01.setId(1L);
        gasto_01.setNome("Usuario_01");
        gasto_01.setDescricao("Compras Teste 01");
        gasto_01.setDate(LocalDateTime.parse("2024-03-01T11:45:13"));
        gasto_01.setValor(100.00);

        gasto_02.setId(2L);
        gasto_02.setNome("Usuario_02");
        gasto_02.setDescricao("Compras teste 02");
        gasto_02.setDate(LocalDateTime.parse("2024-03-01T15:30:56"));
        gasto_02.setValor(200.00);

        gastos.add(gasto_01);
        gastos.add(gasto_02);

    }


    @Test
    void criarGasto_Valido() {
        when(gastoRepository.save(any())).thenReturn(gasto_01);
        GastoDTO gastoDTO = gastoService.criarGasto(gastoDTO_01);
        Assertions.assertEquals(gastoDTO, gastoDTO_01);
    }


    @Test
    void listarGastos() {
        when(gastoRepository.findAll()).thenReturn(gastos);
        List<GastoDTO> listaGastos = gastoService.listarGastos();
        Assertions.assertNotNull(listaGastos);
    }


    @Test
    void listarGastoPorId() {
        when(gastoRepository.findById(1L)).thenReturn(Optional.of(gasto_01));
        GastoDTO gastoDTO = gastoService.listarGastoPorId(1L);
        Assertions.assertNotNull(gastoDTO);
    }

    @Test
    void listarGastoPorId_Null() {
        when(gastoRepository.findById(3L)).thenReturn(Optional.empty());
        GastoDTO gastoDTO = gastoService.listarGastoPorId(3L);
        Assertions.assertNull(gastoDTO);
    }

    @Test
    void criarGasto_SemNome() {
        gastoDTO_01.setNome(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gastoService.criarGasto(gastoDTO_01));
        Assertions.assertEquals("O nome da pessoa é obrigatório", exception.getMessage());
    }

    @Test
    void criarGasto_SemDescricao() {
        gastoDTO_01.setDescricao(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gastoService.criarGasto(gastoDTO_01));
        Assertions.assertEquals("A descrição é obrigatória.", exception.getMessage());
    }

    @Test
    void criarGasto_SemData() {
        gastoDTO_01.setDate(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gastoService.criarGasto(gastoDTO_01));
        Assertions.assertEquals("A data/hora é obrigatória.", exception.getMessage());
    }

    @Test
    void criarGasto_ValorNegativo() {
        gastoDTO_01.setValor(-100.00);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gastoService.criarGasto(gastoDTO_01));
        Assertions.assertEquals("O valor é obrigatório e deve ser maior que zero.", exception.getMessage());
    }

    @Test
    void criarGasto_ValorZero() {
        gastoDTO_01.setValor(0.00);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> gastoService.criarGasto(gastoDTO_01));
        Assertions.assertEquals("O valor é obrigatório e deve ser maior que zero.", exception.getMessage());
    }
}
