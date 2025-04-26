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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <meta charset="UTF-8">
    <title>Vinheria Agnello</title>
    <link rel="stylesheet" href="${contextPath}/css/styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
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
        <jsp:useBean id="wines" scope="request" type="java.util.List<com.fiap.on.esoa.domain.Wine>" />
        <img src="${contextPath}/img?id=WineBackground.jpg" alt="Imagem Ilustrativa Uva" title="Imagem Ilustrativa Uva" />
    </div>
</section>

<section class="produtos">
    <h1>Nossos Vinhos Premium</h1>
    <p>Explore nossa seleção criteriosamente selecionada de vinhos excepcionais de vinhedos renomados.</p>
    <div class="produtos-grid">
        <c:forEach var="wine" items="${wines}">
            <c:set var="countryCode" value="" />
            <c:choose>
                <c:when test="${wine.country == 'Argentina'}">
                    <c:set var="countryCode" value="ar" />
                </c:when>
                <c:when test="${wine.country == 'Itália'}">
                    <c:set var="countryCode" value="it" />
                </c:when>
                <c:when test="${wine.country == 'Chile'}">
                    <c:set var="countryCode" value="cl" />
                </c:when>
                <c:when test="${wine.country == 'África do Sul'}">
                    <c:set var="countryCode" value="za" />
                </c:when>
                <c:when test="${wine.country == 'França'}">
                    <c:set var="countryCode" value="fr" />
                </c:when>
            </c:choose>

            <div class="produto-card">
                <img src="${contextPath}/img?id=${wine.image}" alt="${wine.alt}" title="${wine.alt}" />
                <h3>${wine.name}</h3>

                <div class="wine-country">
                    <c:if test="${not empty countryCode}">
                        <img src="https://flagcdn.com/24x18/${countryCode}.png"
                             alt="${wine.country}"
                             class="bandeira" />
                    </c:if>
                    <span>${wine.country}</span>
                </div>

                <div class="wine-titles">
                    <span class="preco">R$ ${wine.price}</span>
                    <span class="ano">${wine.year}</span>
                </div>
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
    </div>
    <a class="btn ver-mais" href="#">Ver todos os Produtos</a>
</section>

<section class="categorias">
    <h2>Categorias de Vinho</h2>
    <p>Procure nossa coleção por tipo para encontrar a combinação perfeita</p>
    <div class="categorias-grid">
        <%
            String[] tipos = {"Red Wine", "White Wine", "Rose Wine", "Sparkling Wine"};
            String[] imagensTipos = {"RedWine.png", "WhiteWine.png", "RoseWine.png", "SparklingWine.png"};
            for (int i = 0; i < tipos.length; i++) {
                String tipo = tipos[i];
                String imagemTipo = imagensTipos[i];
        %>
        <div class="categoria-card">
            <img src="${contextPath}/img?id=<%=imagemTipo%>" alt="<%= tipo %>">
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

