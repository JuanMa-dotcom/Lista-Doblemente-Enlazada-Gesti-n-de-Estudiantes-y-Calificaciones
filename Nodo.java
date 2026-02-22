/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.ImageIcon;
/**
 *
 * @author jv134
 */
public class Nodo {
    public Estudiante estudiante;
    public Nodo siguiente;
    public Nodo anterior;
    //nodos

    //constructor 
    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.anterior = null;
        this.siguiente = null;
    }

}
