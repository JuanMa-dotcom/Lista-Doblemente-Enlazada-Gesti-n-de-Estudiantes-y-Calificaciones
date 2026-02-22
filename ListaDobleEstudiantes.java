/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jv134
 */
public class ListaDobleEstudiantes {
    private Nodo cabeza;
    private Nodo cola;
    private Nodo actual;
    private int tamanio;

    public ListaDobleEstudiantes() {
        cabeza = null;
        cola = null;
        actual = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Nodo getActual() {
        return actual;
    }

    // Insertar al final de la lista
    public void insertar(Estudiante estudiante) {
        if (estudiante == null) throw new IllegalArgumentException("El estudiante no puede ser nulo.");
        validarDatos(estudiante);

        Nodo nuevo = new Nodo(estudiante);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamanio++;
    }

    // Eliminar por correo (identificador único)
    public boolean eliminar(String correo) {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía. No hay estudiantes para eliminar.");
        if (correo == null || correo.trim().isEmpty()) throw new IllegalArgumentException("El correo no puede estar vacío.");

        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.estudiante.getCorreo().equalsIgnoreCase(correo.trim())) {
                // Ajustar puntero actual
                if (temp == actual) {
                    if (temp.siguiente != null) actual = temp.siguiente;
                    else if (temp.anterior != null) actual = temp.anterior;
                    else actual = null;
                }
                // Desenlazar nodo
                if (temp.anterior != null) temp.anterior.siguiente = temp.siguiente;
                else cabeza = temp.siguiente;

                if (temp.siguiente != null) temp.siguiente.anterior = temp.anterior;
                else cola = temp.anterior;

                tamanio--;
                return true;
            }
            temp = temp.siguiente;
        }
        throw new IllegalArgumentException("No se encontró ningún estudiante con el correo: " + correo);
    }

    // Buscar por correo
    public Nodo buscar(String correo) {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía.");
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.estudiante.getCorreo().equalsIgnoreCase(correo.trim())) {
                actual = temp;
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    // Navegar al primero
    public Nodo irAlPrimero() {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía.");
        actual = cabeza;
        return actual;
    }

    // Navegar al último
    public Nodo irAlUltimo() {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía.");
        actual = cola;
        return actual;
    }

    // Navegar al siguiente
    public Nodo siguiente() {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía.");
        if (actual == null) actual = cabeza;
        else if (actual.siguiente != null) actual = actual.siguiente;
        return actual;
    }

    // Navegar al anterior
    public Nodo anterior() {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía.");
        if (actual == null) actual = cola;
        else if (actual.anterior != null) actual = actual.anterior;
        return actual;
    }

    // Obtener todos los estudiantes como arreglo de Object[] para la tabla
    public Object[][] getDatosTabla() {
        Object[][] datos = new Object[tamanio][5];
        Nodo temp = cabeza;
        int i = 0;
        while (temp != null) {
            Estudiante e = temp.estudiante;
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidoPaterno();
            datos[i][2] = e.getApellidoMaterno();
            datos[i][3] = e.getCarrera();
            datos[i][4] = e.getCorreo();
            i++;
            temp = temp.siguiente;
        }
        return datos;
    }

    private void validarDatos(Estudiante e) {
        if (e.getNombre() == null || e.getNombre().trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (e.getApellidoPaterno() == null || e.getApellidoPaterno().trim().isEmpty())
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
        if (e.getApellidoMaterno() == null || e.getApellidoMaterno().trim().isEmpty())
            throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
        if (e.getCarrera() == null || e.getCarrera().trim().isEmpty())
            throw new IllegalArgumentException("La carrera no puede estar vacía.");
        if (e.getCorreo() == null || e.getCorreo().trim().isEmpty())
            throw new IllegalArgumentException("El correo no puede estar vacío.");
        if (!e.getCorreo().contains("@"))
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        // Verificar correo duplicado
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.estudiante.getCorreo().equalsIgnoreCase(e.getCorreo().trim()))
                throw new IllegalArgumentException("Ya existe un estudiante con el correo: " + e.getCorreo());
            temp = temp.siguiente;
        }
    }
}
