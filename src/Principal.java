import java.util.ArrayList;

public class Principal {
    // Instanciar la clase PersonaDAO
    private static PersonaDAO personaDAO = new PersonaDAO();

    //metodo main
    public static void main(String[] args){
        // Crear algunas personas
        Persona p1 = new Persona(1, "Ana", 25);
        Persona p2 = new Persona(2, "Luis", 30);
        Persona p3 = new Persona(3, "Pedro", 35);

        // Insertar las personas en la base de datos
        personaDAO.insertar(p1);
        personaDAO.insertar(p2);
        personaDAO.insertar(p3);

        // Consultar todas las personas
        ArrayList<Persona> lista = personaDAO.consultarTodos();

        // Mostrar la lista de personas por consola
        System.out.println("Lista de personas:");
        for (Persona p : lista) {
            System.out.println(p);
        }

        // Modificar la edad de una persona
        p2.setEdad(40);
        personaDAO.modificar(p2);

        // Consultar la persona modificada por su id
        Persona p4 = personaDAO.consultarPorId(2);

        // Mostrar la persona modificada por consola
        System.out.println("Persona modificada:");
        System.out.println(p4);

        // Eliminar una persona por su id
        personaDAO.eliminar(3);

        // Consultar todas las personas de nuevo
        lista = personaDAO.consultarTodos();

        // Mostrar la lista de personas actualizada por consola
        System.out.println("Lista de personas actualizada:");
        for (Persona p : lista) {
            System.out.println(p);
        }


    }
}
