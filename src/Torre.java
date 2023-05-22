import java.util.Stack;

public class Torre {
    private Stack<Bloque> bloques;
    private String nombre;

    public Torre(String nombre) {
        this.nombre = nombre;
        this.bloques = new Stack<>();
    }
    public String getNombre() {
        return nombre;
    }

    public void pushBloque(Bloque bloque) {
        bloques.push(bloque);
    }

    public Bloque popBloque() {
        return bloques.pop();
    }

    public boolean isEmpty() {
        return bloques.isEmpty();
    }

    public Bloque getTopBloque() {
        return bloques.peek();
    }

    public int getNumBloque() {
        return bloques.size();
    }
}
