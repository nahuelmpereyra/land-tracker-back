package com.api.landtracker.model.dto;

import com.api.landtracker.model.entities.EstadoLote;
import com.api.landtracker.model.entities.PosicionLote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoteDTO {

    private Long id;

    private String nombre;

    private Integer superficie;

    private EstadoLote estadoLote;

    @Embedded
    private PosicionLoteDTO posicionLote;

}
