<!--

<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
        </div>
    </div>
        
    </div>
</div>
-->

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="agregarClienteModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-info text-white" >
        <h5 class="modal-title" id="agregarClienteModal">Agregar cliente</h5>
        <button  class="close" data-bs-dismiss="modal" >
            <span>&times;</span>
        </button>
      </div>
        <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="POST" class="was-validated">
            <div class="modal-body">
                <div class="form-group">
                    <label for="nombre">nombre</label>
                    <input type="text" class="form-control" name="nombre" required>
                </div>
                 <div class="form-group">
                    <label for="apellido">apellido</label>
                    <input type="text" class="form-control" name="apellido" required>
                </div>
                 <div class="form-group">
                    <label for="email">email</label>
                    <input type="email" class="form-control" name="email" required>
                </div>
                 <div class="form-group">
                    <label for="telefono">telefono</label>
                    <input type="tel" class="form-control" name="telefono" required>
                </div>
                 <div class="form-group">
                    <label for="saldo">saldo</label>
                    <input type="number" class="form-control" name="saldo" required>
                </div>
                
            </div>
            <div class="modal-footer">
                <button class="btn-primary" type="submit">Guardar</button>
            </div>
            
        
        </form>
        
    </div>
  </div>
</div>