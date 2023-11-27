import java.util.ArrayList;

public interface Crud {
    // Método para insertar una persona
    public boolean insertar(Persona persona);

    // Método para consultar una persona por su id
    public Persona consultarPorId(int id);

    // Método para consultar todas las personas
    public ArrayList<Persona> consultarTodos();

    // Método para modificar una persona
    public boolean modificar(Persona persona);

    // Método para eliminar una persona por su id
    public boolean eliminar(int id);
}
