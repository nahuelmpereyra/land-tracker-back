package com.api.landtracker.controller;

import com.api.landtracker.model.dto.LoteDTO;
import com.api.landtracker.model.entities.Lote;
import com.api.landtracker.service.LoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
@RequiredArgsConstructor
public class LoteController {

    private final LoteService loteService;

    @GetMapping
    public List<Lote> obtenerTodosLosLotes() {
        return loteService.obtenerTodosLosLotes();
    }

    @PostMapping
    public Lote guardarLote(@RequestBody LoteDTO lote) {
        return loteService.guardarLote(lote);
    }
}
