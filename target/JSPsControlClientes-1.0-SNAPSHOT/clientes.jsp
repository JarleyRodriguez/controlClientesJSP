
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS se agregan esas dos lines para usarse  y s eagrega la segunda para usar los iconos-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/add6cd68de.js" crossorigin="anonymous"></script>
        
        <title>Control Clientes</title>
    </head>
    <body>
        <!-- vamos agregado el contenido que se encuentra declarado en otros jsp`s  -->
        <!-- cabecero -->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/>
        <!-- botones de  navegacion -->
        <jsp:include page="WEB-INF/paginas/comunes/notonesNavegacion.jsp"/>
        <!--listado clientes  -->
        <jsp:include page="WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        <!--  pie de pagina-->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/>
        
        
       <!-- linea para usar boostrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
        
   
    </body>
</html>
