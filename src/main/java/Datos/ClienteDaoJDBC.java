package Datos;

import Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDaoJDBC {

    private static final String SQL_Select = "SELECT * FROM cliente";
    private static final String SQL_Select_by_id = "SELECT * FROM cliente WHERE id_cliente=?";
    private static final String SQL_Insert = "INSERT INTO cliente (cliente_nombre,"
            + "cliente_apellido,cliente_email,cliente_telefono,cliente_saldo) VALUES (?,?,?,?,?)";
    private static final String SQL_Update = "UPDATE cliente SET cliente_nombre=?,cliente_apellido=?"
            + ",cliente_email=?,cliente_telefono=?,cliente_saldo =? WHERE id_cliente=? ";
    private static final String SQL_Delete = "DELETE FROM cliente WHERE id_cliente=?";
   

    // metodo listar para visualizar el contenido de la tabla 
    public List<Cliente> listar() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List clientes = new ArrayList<Cliente>();

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_Select);
            rs = ps.executeQuery();

            while (rs.next()) {

                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("cliente_nombre");
                String apellido = rs.getString("cliente_apellido");
                String email = rs.getString("cliente_email");
                String telefono = rs.getString("cliente_telefono");
                double saldo = rs.getDouble("cliente_saldo");

                Cliente clientex = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

                clientes.add(clientex);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(con);
        }

        return clientes;

    }
    
    // metodo para encontrar un registro

    public Cliente encontrar(Cliente cliente) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_Select_by_id);
            ps.setInt(1, cliente.getIdCliente());
            rs = ps.executeQuery();
            rs.absolute(1); // como se supone solo sera un registro nos posicionamos en el  primer registro

            String nombre = rs.getString("cliente_nombre");
            String apellido = rs.getString("cliente_apellido");
            String email = rs.getString("cliente_apellido");
            String telefono = rs.getString("cliente_telefono");
            double saldo = rs.getDouble("cliente_saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(con);
        }

        return cliente;
    }
    
    
// metodo para insertar un nuevo registrp
    public int insertar(Cliente cliente) {

        Connection con = null;
        PreparedStatement ps = null;
        int rows = 0; //numero de regitros  modificados

        try {
            con = Conexion.getConnection();
            ps = con.prepareCall(SQL_Insert);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setDouble(5, cliente.getSaldo());
            rows = ps.executeUpdate(); // para insertar

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(ps);
            Conexion.close(con);
        }

        return rows;
    }
    
    
// metodo para actualizar un registro
    public int actualizar(Cliente cliente) {
        int rows = 0;
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_Update);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setDouble(5, cliente.getSaldo());
            ps.setInt(6, cliente.getIdCliente());
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(ps);
            Conexion.close(con);
        }

        return rows;
    }
    
    
// metodo para eliminar un registro
    public int eliminar(Cliente cliente) {
        int rows = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(SQL_Delete);
            ps.setInt(1, cliente.getIdCliente());
            rows = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(ps);
            Conexion.close(con);
        }

        return rows;
    }
    
    


}
