<%--
  Created by IntelliJ IDEA.
  User: Marie
  Date: 13/04/2023
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The Blog | Add Post</title>
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
                <p class="text-white mb-2 mb-md-0 me-3">Bonjour, ${sessionScope.username} !</p>
                <a href="logout">
                    <button class="btn btn-outline-success" type="submit" style="width: 150px">Se déconnecter</button>
                </a>
            </div>
        </div>
    </nav>
</header>

    <div class="container">
        <h1>Add post</h1>

        <form method="post" action="add-post">
            <div class="input-group mb-3">
                <input type="text" class="form-control" name="title" placeholder="Title...">
            </div>

            <div class="input-group mb-3">
                <input type="text" class="form-control" name="author" placeholder="Author...">
            </div>

            <div class="input-group mb-3">
                <textarea class="form-control" name="content" placeholder="Your content.."></textarea>
            </div>
            <div class="input-group">
                <button type="submit" class="btn btn-outline-dark">Submit</button>
            </div>
        </form>

    </div>

</body>
</html>
