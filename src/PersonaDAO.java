import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDAO implements Crud{

    // Instanciar la clase Conexion
    private Conexion SQL = new Conexion();

    // Llamar al método que devuelve una conexión
    private Connection conn = SQL.conectarMySQL();

    // Atributo para almacenar el resultado de las consultas
    private ResultSet rs = null;

    // Atributo para preparar las consultas SQL
    private PreparedStatement ps = null;

    // Método para insertar una persona
    @Override
    public boolean insertar(Persona persona) {
        // Variable para indicar si se insertó o no
        boolean insertado = false;

        // Query que se quiere ejecutar
        String sSQL = "INSERT INTO persona (nombre, edad) VALUES (?, ?)";

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sSQL);

            // Asignar los valores a los parámetros
            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getEdad());

            // Ejecutar la consulta
            int n = ps.executeUpdate();

            // Si se insertó un registro, cambiar el valor de la variable
            if (n > 0) {
                insertado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver el valor de la variable
        return insertado;
    }

    @Override
    public Persona consultarPorId(int id) {
        // Variable para almacenar la persona consultada
        Persona persona = null;

        // Query que se quiere ejecutar
        String sSQL = "SELECT * FROM persona WHERE id = ?";

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sSQL);

            // Asignar el valor al parámetro
            ps.setInt(1, id);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            // Si se encontró un registro, crear el objeto persona y asignar sus atributos
            if (rs.next()) {
                persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setEdad(rs.getInt("edad"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver el objeto persona
        return persona;
    }

    @Override
    public ArrayList<Persona> consultarTodos() {
        // Variable para almacenar la lista de personas
        ArrayList<Persona> lista = new ArrayList<>();

        // Query que se quiere ejecutar
        String sSQL = "SELECT * FROM persona";

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sSQL);

            // Ejecutar la consulta
            rs = ps.executeQuery();

            // Recorrer el resultado y crear objetos persona con sus atributos
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setId(rs.getInt("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setEdad(rs.getInt("edad"));
                // Agregar el objeto persona a la lista
                lista.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver la lista de personas
        return lista;
    }

    @Override
    public boolean modificar(Persona persona) {
        // Variable para indicar si se modificó o no
        boolean modificado = false;

        // Query que se quiere ejecutar
        String sSQL = "UPDATE persona SET nombre = ?, edad = ? WHERE id = ?";

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sSQL);

            // Asignar los valores a los parámetros
            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getEdad());
            ps.setInt(3, persona.getId());

            // Ejecutar la consulta
            int n = ps.executeUpdate();

            // Si se modificó un registro, cambiar el valor de la variable
            if (n > 0) {
                modificado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver el valor de la variable
        return modificado;
    }

    @Override
    public boolean eliminar(int id) {
        // Variable para indicar si se eliminó o no
        boolean eliminado = false;

        // Query que se quiere ejecutar
        String sSQL = "DELETE FROM persona WHERE id = ?";

        try {
            // Preparar la consulta
            ps = conn.prepareStatement(sSQL);

            // Asignar el valor al parámetro
            ps.setInt(1, id);

            // Ejecutar la consulta
            int n = ps.executeUpdate();

            // Si se eliminó un registro, cambiar el valor de la variable
            if (n > 0) {
                eliminado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver el valor de la variable
        return eliminado;
    }
}
