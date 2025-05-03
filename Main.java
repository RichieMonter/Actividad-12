import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contacto {
    private String nombre;
    private String telefono;

    // Constructor
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}

class AgendaTelefonica {
    private Map<String, Contacto> contactos;

    public AgendaTelefonica() {
        contactos = new HashMap<>();
    }

    // Agregar contacto
    public void agregarContacto(Contacto contacto) {
        contactos.put(contacto.getNombre(), contacto);
        System.out.println("Contacto agregado con éxito.");
    }

    // Buscar contacto
    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    // Mostrar todos los contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : contactos.values()) {
                System.out.println(contacto);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agenda = new AgendaTelefonica();

        while (true) {
            System.out.println("\n--- AGENDA TELEFÓNICA ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Mostrar todos los contactos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    agenda.agregarContacto(nuevoContacto);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoEncontrado = agenda.buscarContacto(nombreBuscar);
                    if (contactoEncontrado != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println(contactoEncontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    agenda.mostrarContactos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
