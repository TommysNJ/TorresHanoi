public class Juego {
    private Torre torre1;
    private Torre torre2;
    private Torre torre3;

    public Juego (int numBloques){
        torre1 = new Torre("A");
        torre2 = new Torre("B");
        torre3 = new Torre("C");

        for (int i = numBloques; i>=1; i-- ){
            torre1.pushBloque(new Bloque(i));
        }
    }
    public Torre getTorre(String nombreTorre) {
        switch (nombreTorre) {
            case "A":
                return torre1;
            case "B":
                return torre2;
            case "C":
                return torre3;
            default:
                throw new IllegalArgumentException("Nombre de torre inválido: " + nombreTorre);
        }
    }
    public void moverBloque(String actual, String destino) {
        Torre torreActual = getTorre(actual);
        Torre torreDestino = getTorre(destino);

        if (torreActual.isEmpty()) {
            throw new IllegalStateException("La torre de origen está vacía.");
        }

        if (!torreDestino.isEmpty() && torreActual.getTopBloque().getTamanio() > torreDestino.getTopBloque().getTamanio()) {
            throw new IllegalStateException("No se puede mover un bloque sobre uno más pequeño.");
        }

        Bloque bloque = torreActual.popBloque();
        torreDestino.pushBloque(bloque);
    }
    public boolean finJuego() {
        return torre1.isEmpty() && torre2.isEmpty() || torre1.isEmpty() && torre3.isEmpty();
    }
}
