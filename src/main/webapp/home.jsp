<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: afcha
  Date: 07/04/2025
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Vinheria Agnello</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<header class="header">
    <div class="logo">🍷 Vinheria Agnello</div>
    <nav>
        <a href="#">Loja</a>
        <a href="#">Categorias</a>
        <a href="#">Sobre</a>
        <a href="#">Contato</a>
    </nav>
</header>

<section class="hero">
    <div class="hero-text">
        <h1>Descubra vinhos excepcionais para cada ocasião</h1>
        <p>De safras raras a favoritos do dia a dia, explore nossa coleção selecionada de vinhos do mundo todo.</p>
        <a class="btn" href="#">Nossa Coleção</a>
    </div>
    <div class="hero-img">
        <img src="${pageContext.request.contextPath}/images/produtos.svg" alt="Imagem destaque">
    </div>
</section>

<!-- <jsp:useBean id="wines" scope="request" type="java.util.List<com.fiap.on.esoa.domain.Wine>"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <ul>
        <c:forEach var="wine" items="${wines}">
            <li>
                <p>${wine.name}</p>
                <p>${wine.year}</p>
                <p>R$ ${wine.price}</p>
    
                <img src="${contextPath}/img?id=${wine.image}" alt="${wine.alt}" title="${wine.alt}"/>
            </li>
        </c:forEach>
    </ul> -->

<section class="produtos">
    <h1>Nossos Vinhos Premium</h1>
    <p>Explore nossa seleção criteriosamente selecionada de vinhos excepcionais de vinhedos renomados.</p>
    <div class="produtos-grid">
        <%
            List<Map<String, Object>> produtos = (List<Map<String, Object>>) request.getAttribute("produtos");
            if (produtos != null) {
                for (Map<String, Object> produto : produtos) {
        %>
        <div class="produto-card">
            <img src="<%= produto.get("urlImagem") %>" alt="Vinho">
            <h3><%= produto.get("nomeProduto") %></h3>
            <span class="ano"><%= produto.get("descricao") %></span>
            <span class="preco">R$<%= String.format("%.2f", produto.get("preco")) %></span>
            <div class="estrelas">
                <%
                    int nota = (int) produto.get("nota");
                    for (int i = 0; i < nota; i++) { out.print("★"); }
                    for (int i = nota; i < 5; i++) { out.print("☆"); }
                %>
            </div>
            <button class="btn">Adicionar ao Carrinho</button>
        </div>
        <%
            }
        } else {
        %>
        <p>Nenhum produto encontrado.</p>
        <%
            }
        %>

    </div>
    <a class="btn ver-mais" href="#">Ver todos os Produtos</a>
</section>

<section class="categorias">
    <h2>Categorias de Vinho</h2>
    <p>Procure nossa coleção por tipo para encontrar a combinação perfeita</p>
    <div class="categorias-grid">
        <% String[] tipos = {"Red Wine", "White Wine", "Rosé", "Sparkling"};
            for(String tipo : tipos) { %>
        <div class="categoria-card">
            <img width="250" height="250" src="${pageContext.request.contextPath}/images/produtos.svg" alt="<%= tipo %>">
            <span><%= tipo %></span>
            <button class="btn">Explorar</button>
        </div>
        <% } %>
    </div>
</section>

<footer class="footer">
    <p>© 2025 Vinheria. Todos os direitos reservados.</p>
    <a class="termos" href="#">Termos de Serviço</a>
</footer>

</body>
</html>

