public class Juego {
    private Torre torre1;
    private Torre torre2;
    private Torre torre3;

    public Juego (int numBloques){
        torre1 = new Torre("1");
        torre2 = new Torre("2");
        torre3 = new Torre("3");

        for (int i = numBloques; i>=1; i-- ){
            torre1.pushBloque(new Bloque(i));
        }
    }
    public Torre getTorre(String nombreTorre) {
        switch (nombreTorre) {
            case "1":
                return torre1;
            case "2":
                return torre2;
            case "3":
                return torre3;
            default:
                throw new IllegalArgumentException("Nombre de torre inválido: " + nombreTorre);
        }
    }
    public void moverBloque(String actual, String destino) {
        Torre torreActual = getTorre(actual);
        Torre torreDestino = getTorre(destino);

        if (torreActual.isEmpty()) {
            throw new IllegalArgumentException("La torre de origen está vacía.");
        }

        Bloque bloque = torreActual.getTopBloque();
        if (torreDestino.isEmpty() || bloque.getTamanio() < torreDestino.getTopBloque().getTamanio()) {
            torreDestino.pushBloque(torreActual.popBloque());
        } else {
            throw new IllegalArgumentException("No se puede mover un bloque a una torre con un bloque más pequeño encima.");
        }
    }
    public boolean finJuego() {
        return torre1.isEmpty() && torre2.isEmpty() || torre1.isEmpty() && torre3.isEmpty();
    }
}
