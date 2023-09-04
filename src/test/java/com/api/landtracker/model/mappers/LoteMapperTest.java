package com.api.landtracker.model.mappers;

import com.api.landtracker.model.dto.LoteDTO;
import com.api.landtracker.model.entities.EstadoLote;
import com.api.landtracker.model.entities.Lote;
import com.api.landtracker.model.entities.PosicionLote;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoteMapperTest {

    private static LoteMapper loteMapper;

    @BeforeAll
    public static void setUp(){
        loteMapper = new LoteMapperImpl();
    }
    @Test
    public void testLoteToLoteDTO() {
        Lote lote = Lote.builder()
                .id(1L)
                .estadoLote(EstadoLote.DISPONIBLE)
                .nombre("Un lote")
                .superficie(1000)
                .posicionLote(new PosicionLote(1.0,2.0,3.0))
                .build();

        LoteDTO loteDTO = loteMapper.loteToLoteDTO(lote);

        assertAll(
                () -> {
                    assertEquals("Un lote", loteDTO.getNombre());
                    assertEquals(1000, loteDTO.getSuperficie());
                    assertEquals(EstadoLote.DISPONIBLE, loteDTO.getEstadoLote());
                    assertEquals(lote.getPosicionLote().getX(), loteDTO.getPosicionLote().getX());
                    assertEquals(lote.getPosicionLote().getY(), loteDTO.getPosicionLote().getY());
                    assertEquals(lote.getPosicionLote().getZ(), loteDTO.getPosicionLote().getZ());
                }
        );
    }

    @Test
    public void testLoteDTOToLote() {
        LoteDTO loteDTO = new LoteDTO();
        loteDTO.setNombre("Lote B");
        loteDTO.setSuperficie(150);
        loteDTO.setEstadoLote(EstadoLote.RESERVADO);

        Lote lote = loteMapper.loteDTOToLote(loteDTO);

        assertNotNull(lote);
        assertEquals("Lote B", lote.getNombre());
        assertEquals(150, lote.getSuperficie());
        assertEquals(EstadoLote.RESERVADO, lote.getEstadoLote());
    }
}
