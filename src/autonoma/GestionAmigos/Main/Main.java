/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.GestionAmigos.Main;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        GestionAmigos gestion = new GestionAmigos();

        try {
            Amigo amigo1 = new Amigo("juan@example.com", "Juan Pérez", "606123456");
            Amigo amigo2 = new Amigo("maria@example.com", "María López", "301234567");
            
            gestion.agregarAmigo(amigo1);
            gestion.agregarAmigo(amigo2);
            
            System.out.println(gestion.buscarAmigo("juan@example.com"));
            
            gestion.eliminarAmigo("juan@example.com");
            System.out.println(gestion.buscarAmigo("juan@example.com")); // Aquí lanzará una excepción

        } catch (CorreoInvalidoException | TelefonoInvalidoException | 
                 AmigoDuplicadoException | AmigoNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

