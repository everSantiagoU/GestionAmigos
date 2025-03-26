
package autonoma.GestionAmigos.models;

import autonoma.GestionAmigos.exceptions.CorreoInvalidoException;
import autonoma.GestionAmigos.exceptions.TelefonoInvalidoException;

/**
 *
 * @author ACER
 */
public class Amigo {
    private String correoElectronico;
    private String nombre;
    private String telefono;

    public Amigo(String correoElectronico, String nombre, String telefono) 
            throws CorreoInvalidoException, TelefonoInvalidoException {
        
        if (!correoElectronico.contains("@")) {
            throw new CorreoInvalidoException("El correo electronico debe contener '@'.");
        }
        if (!(telefono.startsWith("606") || telefono.startsWith("30"))) {
            throw new TelefonoInvalidoException("El numero de telefono debe iniciar con '606' o '30'.");
        }
        
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "correo='" + correoElectronico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
