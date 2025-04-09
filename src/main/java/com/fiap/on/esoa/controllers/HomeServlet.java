package com.fiap.on.esoa.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acessando o servlet...");

        List<Map<String, Object>> produtos = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Map<String, Object> produto = new HashMap<>();
            produto.put("nomeProduto", "Château Elegance " + (2020 + i));
            produto.put("preco", 89.90 + i * 10); // mockando preços diferentes
            produto.put("nota", (i % 5) + 1); // notas de 1 a 5
            produto.put("descricao", "Vinho da safra " + (2020 + i));
            produto.put("urlImagem", req.getContextPath() + "/images/produtos.svg"); // usando caminho relativo
            produtos.add(produto);
        }

        req.setAttribute("produtos", produtos);

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}
