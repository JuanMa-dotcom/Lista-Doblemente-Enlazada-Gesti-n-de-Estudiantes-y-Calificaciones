/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.ImageIcon;
/**
 *
 * @author jv134
 */
public class Estudiante {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
    private String correo;
    private ImageIcon fotografia;

    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno,
                      String carrera, String correo, ImageIcon fotografia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.correo = correo;
        this.fotografia = fotografia;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public ImageIcon getFotografia() { return fotografia; }
    public void setFotografia(ImageIcon fotografia) { this.fotografia = fotografia; }

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }
}