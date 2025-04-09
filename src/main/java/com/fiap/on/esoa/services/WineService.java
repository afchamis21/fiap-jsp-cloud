package com.fiap.on.esoa.services;

import com.fiap.on.esoa.domain.Wine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WineService {
    public List<Wine> getStubWineList() {
        List<Wine> wines = new ArrayList<>();
        wines.add(new Wine(
                "Luigi Bosca",
                "Paraiso",
                "Vinho.png",
                "Imagem do vinho Paraiso",
                "Argentina",
                "Blend",
                new BigDecimal("819.90"),
                5,
                2020
        ));

        wines.add(new Wine(
                "Luigi Bosca",
                "Los Nobles",
                "Vinho2.png",
                "Imagem do vinho Nobles Malbec 2021",
                "Argentina",
                "Malbec",
                new BigDecimal("549.90"),
                4,
                2021
        ));

        wines.add(new Wine(
                "Augustali",
                "Contrasto Bianco",
                "Vinho3.png",
                "Imagem do vinho Contrasto Bianco 2023",
                "Italia",
                "Blend",
                new BigDecimal("129"),
                3,
                2023
        ));

        wines.add(new Wine(
                "Rutini",
                "Apartado Gran",
                "Vinho4.png",
                "Imagem do vinho Apartado Gran Malbec 2017",
                "Argentina",
                "Malbec",
                new BigDecimal("1200"),
                3,
                2017
        ));

        return wines;
    }

    public List<Wine> getWineList() {
        // TODO implement
        return new ArrayList<>();
    }
}
