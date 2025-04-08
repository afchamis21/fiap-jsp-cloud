package com.fiap.on.esoa.controllers;

import com.fiap.on.esoa.domain.Wine;
import com.fiap.on.esoa.services.WineService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private final WineService wineService = new WineService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acessando o servlet...");
        List<Wine> wines = wineService.getStubWineList();
        req.setAttribute("wines", wines);
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
