    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_mx"/>


<!--  utilizamos libreria  jstl de core -->
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>listado de clientes </h4>
                    </div> 

                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>nombre</th>
                                <th>saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!- iteramos  cada elemento de la lista de clientes con jstlusando core -->
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td> ${cliente.idCliente}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServerControlado?acction=editar&idCliente=${cliente.idCliente}"
                                           class="btn btn-secondary ">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>
            </div>
            <!-- inicio de agregar tarjetas para los totales -->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalClientes}
                        </h4>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
                        
<!--agregar cliente modal-->
<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>