import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    private static ArrayList listaPer = new ArrayList();
    public static Scanner teclado = new Scanner(System.in);
    public static Scanner leerFrase = new Scanner(System.in);
    private static int numJ;

    public static void main(String[] args) {
        int opcion = 0;
        do{
            menuPrincipal();
            opcion = leerInt("Dame opcion: ");
            switch (opcion) {
                case 1:
                    // -------   Inserta Jugador   -------
                    insertaJugador();
                    break;
                case 2:
                    // -------   Inserta Arbitro   -------
                    insertaArbitro();
                    break;
                case 3:
                    // -------   Muestra Vector   -------
                    if (listaPer.isEmpty()) {
                        System.err.println("El vector esta vacio");
                    } else {
                        mostrarTodo();
                    }
                    break;
                case 4:
                    // -------   Ordena por Velocidad   -------
                    if (listaPer.isEmpty()) {
                        System.err.println("El vector esta vacio");
                    }else if(listaPer.size()==1){
                        System.err.println("Solo hay una persona en la lista");
                    }else{
                    //ordenaPerVelo();
                    ordenaPerVeloRecursivo(0, 1);
                    System.out.println("Vector ordenado, para verlo usa la opcion 3");
                    }
                    break;
                case 5:
                    // -------   Muestra Jugadores   -------
                    if(numJ==0){
                        System.err.println("No hay jugadores en la lista");
                    }else{
                    mostrarJugadores();
                    }
                    break;
                case 6:
                    // -------   Buscar por nombre   -------
                    if (listaPer.isEmpty()) {
                        System.err.println("El vector esta vacio");
                    }else{
                        //int posi = buscarPersona();
                        System.out.print("Dame nombre para buscar: ");
                        String nombre = leerFrase.nextLine();
                        int posi = buscarPersonaRecursivo(0, nombre);
                        if(posi==-1){
                            System.err.println("No esta en la lista");
                        }else{
                            System.out.println(listaPer.get(posi).toString());
                        }
                    }
                    break;
                case 7:
                    // -------   Jugador con mas Regate   -------
                    if(numJ<2){
                        System.err.println("Hay 0-1 jugador/es, no se puede comparar");
                    }else{
                        System.out.println(jugadorMasRegateRecursivo(0,listaPer.get(0),0));
                    }
                    break;
                case 8:
                    // -------   Suma todas las velocidades   -------
                    if(numJ<2){
                        System.err.println("Hay 0-1 jugador/es, no se puede comparar");
                    }else{
                        int velo;
                        if(listaPer.get(0) instanceof Jugador){
                            velo = ((Jugador) listaPer.get(0)).getVelocidad();
                        }else{
                            velo = ((Arbitro) listaPer.get(0)).getVelocidad();
                        }
                        System.out.println("La suma de velocidades es : " + sumaVelocidadesRecursivo(0, velo));
                    }
                    break;
                case 9:
                    System.out.println("FIN PROGRAMA");
                    break;
                default:
                    System.err.println("Elige una opcion entre 1-9");
                    break;
            }
        }while(opcion!=9);
    }

    private static int sumaVelocidadesRecursivo(int i, int veloi){
        if(i==listaPer.size()-1){
            if(listaPer.get(i) instanceof Jugador){
                veloi = ((Jugador) listaPer.get(i)).getVelocidad();
            }else{
                veloi = ((Arbitro) listaPer.get(i)).getVelocidad();
            }
            return veloi;
        }else{
            return veloi + sumaVelocidadesRecursivo(i+1, veloi);
        }
    }
    private static void jugadorMasRegate() {
        Object aux=null;
        int regatei=0, regateAux=0;
        System.out.print("El jugador con MAS REGATE es: ");
        for(int i=0; i<listaPer.size();i++){
                if(listaPer.get(i) instanceof Jugador){
                    regatei = ((Jugador) listaPer.get(i)).getRegate();
                }
                if(regatei>regateAux){
                    regateAux = ((Jugador) listaPer.get(i)).getRegate();
                    aux = listaPer.get(i);
                }
        }
        System.out.println(aux);
    }
// ----------- METODO JUGADOR MAS REGATE RECURSIVO -----------------
    private static Object jugadorMasRegateRecursivo(int i, Object aux, int regateAux) {
        if (i<listaPer.size()-1) {
            if (listaPer.get(i) instanceof Jugador) {
                int regatei = ((Jugador) listaPer.get(i)).getRegate();
                if (regatei > regateAux) {
                    return jugadorMasRegateRecursivo(i+1, listaPer.get(i), regatei);
                } else {
                    return jugadorMasRegateRecursivo(i+1, aux, regateAux);
                }
            } else {
                return jugadorMasRegateRecursivo(i+1, aux, regateAux);
            }
        }
        return aux;
    }

    private static int buscarPersonaRecursivo(int i, String nombre){
        if(i<listaPer.size()){
            if(listaPer.get(i) instanceof Jugador){
                if(((Jugador) listaPer.get(i)).getNombre().equalsIgnoreCase(nombre)){
                    return i;
                }
            }else{
                if(((Arbitro) listaPer.get(i)).getNombre().equalsIgnoreCase(nombre)){
                    return i;
                }
            }
            return buscarPersonaRecursivo(i+1, nombre);
        }else{
            return -1;
        }
    }
    private static int buscarPersona(){
        System.out.print("Dame nombre para buscar: ");
        String nombre = leerFrase.nextLine();
        int i=0;
        while(i<listaPer.size()){
            if(listaPer.get(i) instanceof Jugador){
                if(((Jugador) listaPer.get(i)).getNombre().equalsIgnoreCase(nombre)){
                    return i;
                }
            }else{
                if(((Arbitro) listaPer.get(i)).getNombre().equalsIgnoreCase(nombre)){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
    private static void mostrarJugadores(){
        System.out.println("---- LISTA DE JUGADORES ----");
        for(int i=0; i<listaPer.size();i++){
            if(listaPer.get(i) instanceof Jugador){
                System.out.println(listaPer.get(i).toString());
            }
        }
    }
    private static void ordenaPerVeloRecursivo(int i,int j){
        if(i<listaPer.size()-1){
            if(j<listaPer.size()){
                int veloi, veloj;
                if(listaPer.get(i) instanceof Jugador){
                    veloi = ((Jugador) listaPer.get(i)).getVelocidad();
                }else{
                    veloi = ((Arbitro) listaPer.get(i)).getVelocidad();
                }
                if(listaPer.get(j) instanceof Jugador){
                    veloj = ((Jugador) listaPer.get(j)).getVelocidad();
                }else{
                    veloj = ((Arbitro) listaPer.get(j)).getVelocidad();
                }
                if(veloi>veloj){
                    Object aux;
                    aux = listaPer.get(j);
                    listaPer.set(j, listaPer.get(i));
                    listaPer.set(i, aux);
                }
                ordenaPerVeloRecursivo(i, j+1);
            }
            ordenaPerVeloRecursivo(i+1, i+2);
        }
    }
    /*------- APUNTE ORDENAR RECURSIVO -------
            for(int I..
            for( int j =..
            if(j == size-1)
            return ordenar(listaPer,i,j+1)
            if(j != size-1)
            return ordenar(listaPer,i+1,i+2)
    para i int velo1 = (Jugador/arbitro listaPer.get(i).getVelocidad()
    para j int velo2 = ""
        if (velo1>velo2)
    Object aux para guardar el Jugador/arbitro mas rapido en el array. */
    private static void ordenaPerVelo(){
        for(int i=0; i<listaPer.size()-1;i++){
            for(int j=i+1; j<listaPer.size();j++){
                int veloi, veloj;
                if(listaPer.get(i) instanceof Jugador){
                    veloi = ((Jugador) listaPer.get(i)).getVelocidad();
                }else{
                    veloi = ((Arbitro) listaPer.get(i)).getVelocidad();
                }
                if(listaPer.get(j) instanceof Jugador){
                    veloj = ((Jugador) listaPer.get(j)).getVelocidad();
                }else{
                    veloj = ((Arbitro) listaPer.get(j)).getVelocidad();
                }
                if(veloi>veloj){
                    Object aux = listaPer.get(i);
                    listaPer.set(i, listaPer.get(j));
                    listaPer.set(j, aux);
                }
            }
        }
    }

    private static void mostrarTodo(){
        System.out.println("---- LISTA DE PERSONAS ----");
        for(int i=0; i< listaPer.size();i++){
            System.out.println(listaPer.get(i).toString());
        }
    }

    private static void insertaArbitro() {
        System.out.print("Dame NOMBRE: ");
        String nombre = leerFrase.nextLine();
        System.out.print("Dame COLEGIO del arbitro: ");
        String colegio = leerFrase.nextLine();
        int velocidad = leerInt("Dame VELOCIDAD(0-100) del arbitro : ");
        int acierto = leerInt("Dame ACIERTO(0-100) del arbitro : ");
        System.out.print("¿ Esta ACTIVO ? s/n : ");
        String activo = teclado.next();
        Arbitro arb = new Arbitro(nombre,colegio , velocidad, acierto, activo);
        listaPer.add(arb);
        System.out.print("\n--- ARBITRO INSERTADO ---");
        System.out.println(arb);
    }

    private static void insertaJugador(){
        System.out.print("Dame NOMBRE: ");
        String nombre = leerFrase.nextLine();
        System.out.print("Dame POSICION del jugador: ");
        String posicion = leerFrase.nextLine();
        int velocidad = leerInt("Dame VELOCIDAD(0-100) del jugador : ");
        int regate = leerInt("Dame REGATE(0-100) del jugador : ");
        System.out.print("¿ Esta LESIONADO ? s/n : ");
        String lesionado = teclado.next();
        Jugador jug = new Jugador(nombre, posicion, velocidad, regate, lesionado);
        listaPer.add(jug);
        numJ++;
        System.out.print("\n--- JUGADOR INSERTADO ---");
        System.out.println(jug);
    }

    public static void menuPrincipal(){
        System.out.println("\n1) Inserta Jugador");
        System.out.println("2) Inserta Arbitro");
        System.out.println("3) Mostrar todo el vector");
        System.out.println("4) Ordenar personas por velocidad"); // recursivo
        System.out.println("5) Mostrar solo jugadores");
        System.out.println("6) Buscar jugador o arbitro por nombre"); // iterativo y recursivo
        System.out.println("7) Jugador con más regate"); // iterativo
        System.out.println("8) Suma todas las velocidades"); // recursivo
        System.out.println("9) Salir");
    }
    public static int leerInt(String peticion){
        boolean correcto = true;
        int num = 0;
        do{
            try {
                correcto = true;
                System.out.print(peticion);
                num = Integer.parseInt(teclado.next());
            }catch (Exception e){
                System.err.println("Introduce un numero entero");
                correcto = false;
            }
        }while(!correcto);
        return num;
    }
}