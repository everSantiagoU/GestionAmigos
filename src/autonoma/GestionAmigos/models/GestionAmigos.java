
package autonoma.GestionAmigos.models;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import java.util.List;
public class GestionAmigos {
    private List<Amigo> amigos;

    public GestionAmigos() {
        this.amigos = new ArrayList<>();
    }

    public boolean agregarAmigo(Amigo amigo) throws AmigoDuplicadoException {
        for (Amigo a : amigos) {
            if (a.getCorreoElectronico().equals(amigo.getCorreoElectronico())) {
                throw new AmigoDuplicadoException("El amigo con correo '" + amigo.getCorreoElectronico() + "' ya está registrado.");
            }
        }
        amigos.add(amigo);
        return true;
    }

    public Amigo buscarAmigo(String correoElectronico) throws AmigoNoEncontradoException {
        for (Amigo a : amigos) {
            if (a.getCorreoElectronico().equals(correoElectronico)) {
                return a;
            }
        }
        throw new AmigoNoEncontradoException("No se encontro un amigo con el correo '" + correoElectronico + "'.");
    }

    public boolean eliminarAmigo(String correoElectronico) throws AmigoNoEncontradoException {
        for (Amigo a : amigos) {
            if (a.getCorreoElectronico().equals(correoElectronico)) {
                amigos.remove(a);
                return true;
            }
        }
        throw new AmigoNoEncontradoException("No se puede eliminar. No se encontro un amigo con el correo '" + correoElectronico + "'.");
    }

    public String mostrarInformacionApp() {
        return "Aplicacion: Gestion de Amigos\n" +
               "Asignatura: Programacion Orientada a Objetos\n" +
               "Universidad: Universidad Autonoma de Manizales\n" +
               "Desarrolladores: Ever Santiago Uribe Quintero y Juan Diego Pinilla Agudelo";
    }
    public boolean salirApp() {
        System.out.println("Saliendo de la aplicacion...");
            return true;
    }
}