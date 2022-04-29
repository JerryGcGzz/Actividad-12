import java.sql.SQLOutput;
import java.util.Scanner;

public class Actividad12 {
    public static void main(String[] args) {
        showMenu();
    }
    public static void showMenu(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        AdressBook ejemplo = new AdressBook();
        System.out.println("Bienvenido a su directorio electronico: ");
        ejemplo.load();
        System.out.println();


        while(true){
            System.out.println("Opcione de directorio: \n"
                    +"1 Mostrar contactos \n"
                    +"2 Agregar nuevo contacto \n"
                    +"3 Eliminar contacto existente \n"
                    +"4 Guardar cambios \n"
                    +"0 Cerrar programa \n"
            );
            System.out.println("Elija una opción: ");
            opcion = entrada.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("Cerrando programa...");
                    return;

                case 1:
                    System.out.println("Contactos: ");
                    ejemplo.list();
                    System.out.println();
                    break;

                case 2:
                    String num;
                    String nom;
                    System.out.println("Ingrese la siguiente informacion para el nuevo contacto: ");
                    System.out.println("Numero: ");
                    num = entrada.next();
                    System.out.println("Nombre: ");
                    nom = entrada.next();
                    ejemplo.create(num, nom);
                    System.out.println("El contacto se ha añadido \n");
                    break;

                case 3:
                    System.out.println("Digite el numero del contacto que desea eliminar: ");
                    ejemplo.delete(entrada.next());
                    System.out.println("El contacto ha sido eliminado \n");
                    break;

                case 4:
                    ejemplo.save();
                    break;
            }
        }
    }
}
