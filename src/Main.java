import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static File archivo = new File ("resultados_padel.dat");

    public static void menu(){
        System.out.println("""
                1) Escribir registro.
                2) Leer registro.
                3) Marcar borrado.
                4) Listar registro.
                5) Compactar registro.
                0) Salir.
                """);
    }

    public static void main(String[] args) throws IOException {
        while(true) {

            menu();

            System.out.print("Opcion: ");

            int op = sc.nextInt();

            switch (op){
                case 1: escribirRegistro(); break;
                //case 2: leerRegistro(); break;
                //case 3: marcarBorrado(); break;
                //case 4: listar(); break;
                //case 5: compactar(); break;
                case 0: System.out.println("Saliendo..."); System.exit(0);
                default: System.out.println("Opción invalida, eliga una entre el 1 al 5."); break;
            }
        }
    }

    public static void escribirRegistro() throws IOException {
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombrePareja = sc.nextLine();

        System.out.print("Id Pareja: ");
        int idPareja = sc.nextInt();

        System.out.print("Partidos Ganados: ");
        int partidoWon = sc.nextInt();

        System.out.print("Partidos Lost: ");
        int partidoLost = sc.nextInt();

        System.out.print("Posicion: ");
        int pos = sc.nextInt();

        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            raf.seek((long) pos * PersonasPadel.tanByte);
            PersonasPadel pdl = new PersonasPadel('A', idPareja, nombrePareja, partidoWon, partidoLost);
            pdl.escribir(raf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
