public class Arbitro {
    private String nombre;
    private String colegio;
    private int velocidad;
    private int acierto;
    private boolean activo;

    public Arbitro() {
    }

    public Arbitro(String nombre, String colegio, int velocidad, int acierto, String activo) {
        this.nombre = nombre;
        this.colegio = colegio;
        setVelocidad(velocidad);
        setAcierto(acierto);
        setActivo(activo);
    }

    @Override
    public String toString() {
        String estaActivo = "Si";
        if(!activo){
            estaActivo = "No";
        }
        return "\nARBITRO: " + nombre + "\n" +
                "Colegio: " + colegio + '\n' +
                "Velocidad: " + velocidad + '\n' +
                "Acierto: " + acierto + '\n' +
                "Activo: " + estaActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
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

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        while(acierto<0 || acierto>100){
                acierto=Liga.leerInt("Introduzca un ACIERTO correcto: (entero 0-100)");
        }
        this.acierto = acierto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        while(!activo.equalsIgnoreCase("s") && !activo.equalsIgnoreCase("n")) {
                System.out.println("Confirma si esta ACTIVO con 's' o 'n' (solo una letra) ");
                activo = Liga.teclado.next();
        }
        this.activo = activo.equalsIgnoreCase("s");
    }
}
