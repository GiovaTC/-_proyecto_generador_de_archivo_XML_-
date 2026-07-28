package dao;

import config.ConexionBD;
import model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO {

    public ArrayList<Persona> obtenerPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();

        String sql = "SELECT * FROM personas";

        try {
            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Persona persona = new Persona();

                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setEdad(rs.getInt("edad"));
                persona.setCiudad(rs.getString("ciudad"));

                lista.add(persona);
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }
}
