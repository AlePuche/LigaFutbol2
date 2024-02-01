public class Jugador {
    private String nombre;
    private String posicion;
    private int velocidad;
    private int regate;
    private boolean lesionado;

    public Jugador() {
    }

    public Jugador(String nombre, String posicion, int velocidad, int regate, String lesionado) {
        this.nombre = nombre;
        this.posicion = posicion;
        setVelocidad(velocidad);
        setRegate(regate);
        setLesionado(lesionado);
    }

    @Override
    public String toString() {
        String estaLesionado = "Si";
        if(!lesionado){
            estaLesionado = "No";
        }
        return "\nJUGADOR: " + nombre + "\n" +
                "Posición: " + posicion + '\n' +
                "Velocidad: " + velocidad + '\n' +
                "Regate: " + regate + '\n' +
                "Lesionado: " + estaLesionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        while(velocidad<0 || velocidad>100){
                velocidad=Liga.leerInt("Introduzca una VELOCIDAD correcta: (entero 0-100)");
        }
        this.velocidad = velocidad;
    }

    public int getRegate() {
        return regate;
    }

    public void setRegate(int regate) {
        while(regate<0 || regate>100){
            regate=Liga.leerInt("Introduzca un REGATE correcto: (entero 0-100)");
        }
        this.regate = regate;
    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(String lesionado) {
        while(!lesionado.equalsIgnoreCase("s") && !lesionado.equalsIgnoreCase("n")){
                System.out.println("Confirma la LESION con 's' o 'n' (solo una letra) ");
                lesionado = Liga.teclado.next();
        }
        this.lesionado = lesionado.equalsIgnoreCase("s");
    }
}
