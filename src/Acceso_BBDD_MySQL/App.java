package Acceso_BBDD_MySQL;
public class App {
    public static void main(String[] args) {
        Acceso miAcceso = new Acceso();
        miAcceso.conectar();
        miAcceso.realizarConsulta("SELECT * FROM ALUMNOS");



        miAcceso.desconectar();
    }
}
