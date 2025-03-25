/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.GestionAmigos.Main;

/**
 *
 * @author ACER
 */
import autonoma.GestionAmigos.exceptions.AmigoDuplicadoException;
import autonoma.GestionAmigos.exceptions.AmigoNoEncontradoException;
import autonoma.GestionAmigos.exceptions.CorreoInvalidoException;
import autonoma.GestionAmigos.exceptions.TelefonoInvalidoException;
import autonoma.GestionAmigos.models.Amigo;
import autonoma.GestionAmigos.models.GestionAmigos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionAmigos gestion = new GestionAmigos();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n Menu");
            System.out.println("1. Agregar amigo");
            System.out.println("2. Buscar amigo");
            System.out.println("3. Eliminar amigo");
            System.out.println("4. Mostrar informacion de la app");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  
            
            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Correo electronico: ");
                        String correo = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Telefono: ");
                        String telefono = scanner.nextLine();

                        Amigo nuevoAmigo = new Amigo(correo, nombre, telefono);
                        gestion.agregarAmigo(nuevoAmigo);
                        System.out.println("Amigo agregado.");
                        break;
                    
                    case 2:
                        System.out.print("Ingrese el correo del amigo que desea buscar: ");
                        String correoBuscar = scanner.nextLine();
                        Amigo encontrado = gestion.buscarAmigo(correoBuscar);
                        System.out.println("Amigo encontrado: " + encontrado);
                        break;

                    case 3:
                        System.out.print("Ingrese el correo del amigo que desea eliminar: ");
                        String correoEliminar = scanner.nextLine();
                        gestion.eliminarAmigo(correoEliminar);
                        System.out.println("Amigo eliminado.");
                        break;

                    case 4:
                        System.out.println(gestion.mostrarInformacionApp());
                        break;

                    case 5:
                        gestion.salirApp();
                        System.out.println("Gracias por usar la aplicacion.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (CorreoInvalidoException | TelefonoInvalidoException | 
                     AmigoDuplicadoException | AmigoNoEncontradoException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}


