<%@ page import="com.fiap.on.esoa.domain.Wine" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: afcha
  Date: 07/04/2025
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <meta charset="UTF-8">
    <title>Vinheria Agnello</title>
    <link rel="stylesheet" href="${contextPath}/css/styles.css">
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
        <img src="${contextPath}/images/produtos.svg" alt="Imagem destaque">
    </div>
</section>

<section class="produtos">
    <h1>Nossos Vinhos Premium</h1>
    <p>Explore nossa seleção criteriosamente selecionada de vinhos excepcionais de vinhedos renomados.</p>
    <div class="produtos-grid">
        <jsp:useBean id="wines" scope="request" type="java.util.List<com.fiap.on.esoa.domain.Wine>" />
        <c:choose>
            <c:when test="${not empty wines}">
                <c:forEach var="wine" items="${wines}">
                    <div class="produto-card">
                        <img src="${contextPath}/img?id=${wine.image}" alt="${wine.alt}" title="${wine.alt}" />
                        <h3>${wine.name}</h3>
                        <span class="ano">${wine.year}</span>
                        <span class="preco">R$ ${wine.price}</span>
                        <div class="estrelas">
                            <c:forEach var="i" begin="1" end="5">
                                <c:choose>
                                    <c:when test="${i <= wine.rating}">
                                        ★
                                    </c:when>
                                    <c:otherwise>
                                        ☆
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                        <button class="btn">Adicionar ao Carrinho</button>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Nenhum produto encontrado.</p>
            </c:otherwise>
        </c:choose>
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

