package com.fiap.on.esoa.controllers;

import com.fiap.on.esoa.domain.Wine;
import com.fiap.on.esoa.services.WineService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final WineService wineService = new WineService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Wine> wines = wineService.getWineList();

        Map<String, List<Wine>> groupedWines = new HashMap<>();
        for (Wine wine: wines) {
            if (!groupedWines.containsKey(wine.getCountry())) {
                groupedWines.put(wine.getCountry(), new ArrayList<>());
            }

            groupedWines.get(wine.getCountry()).add(wine);
        }

        req.setAttribute("wines", wines);
        req.setAttribute("groupedWines", groupedWines);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
