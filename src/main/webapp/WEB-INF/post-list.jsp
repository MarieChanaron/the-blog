<%@ page import="com.example.modelemvc.model.Post" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Marie
  Date: 12/04/2023
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>


<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous" defer></script>
</head>


<body>

<header class="mb-4">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <img src="https://img.icons8.com/plasticine/64/null/blog.png"/>
            <a class="navbar-brand" href="#">The Blog</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="posts">Home</a>
                    </li>
                    <c:if test="${sessionScope.username == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="add-post">Add post</a>
                        </li>
                    </c:if>
                </ul>
                <c:choose>
                    <c:when test="${sessionScope.username == null}">
                        <form class="d-flex mb-2 mb-md-0" role="search" action="${pageContext.request.contextPath}/connexion" method="post" style="max-width: 600px;">
                            <input name="surname" class="form-control me-2" type="search" placeholder="Pseudo" aria-label="Search">
                            <input name="password" class="form-control me-2" type="search" placeholder="Mot de passe" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit" style="width: 300px">Se connecter</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p class="text-white mb-2 mb-md-0 me-3">Bonjour, ${sessionScope.username} !</p>
                        <a href="logout">
                            <button class="btn btn-outline-success" type="submit" style="width: 150px">Se déconnecter</button>
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</header>

<div class="container">
    <h1>Posts</h1>

    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 align-content-center">
        <c:forEach var="p" items="${posts}">
            <div class="col">
                <div class="card">
                    <img src="${p.pictureUrl}" class="card-img-top" alt="${p.title}">
                    <div class="card-body">
                        <h5 class="card-title">${p.title}</h5>
                        <p class="card-text">${p.content}</p>

                        <fmt:parseDate value="${p.createdAt}" pattern="yyyy-MM-dd" var="postDate" type="date"/>
                        <fmt:formatDate pattern="dd MMMM yyyy hh:mm" value="${postDate}"/>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
