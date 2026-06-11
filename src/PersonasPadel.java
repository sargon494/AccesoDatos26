import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonasPadel {

    // Bytes por registro generico
    public static final int tamnNom = 20; // 20 caracteres 40 bytes
    public static final int tanByte = 54; // Total bytes por registro

    // Atributos comunes
    private int idPareja;
    private char estado;
    private String nombrePareja;
    private int partidosWon;
    private int partidosLost;

    // Constructor
    public PersonasPadel(char estado, int idPareja, String nombrePareja, int partidosWon, int partidosLost) {
        this.idPareja = idPareja;
        this.estado = estado;
        this.nombrePareja = nombrePareja;
        this.partidosWon = partidosWon;
        this.partidosLost = partidosLost;
    }

    // Getters & Setters
    public int getIdPareja() {
        return idPareja;
    }

    public void setIdPareja(int idPareja) {
        this.idPareja = idPareja;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getNombrePareja() {
        return nombrePareja;
    }

    public void setNombrePareja(String nombrePareja) {
        this.nombrePareja = nombrePareja;
    }

    public int getPartidosWon() {
        return partidosWon;
    }

    public void setPartidosWon(int partidosWon) {
        this.partidosWon = partidosWon;
    }

    public int getPartidosLost() {
        return partidosLost;
    }

    public void setPartidosLost(int partidosLost) {
        this.partidosLost = partidosLost;
    }


    // Metodo para escribir registros con RAF
    public void escribir(RandomAccessFile raf) throws IOException {
        raf.writeChar(this.estado);
        raf.writeInt(this.idPareja);
        String nombreParejaF = String.format("%-" + tamnNom + "s", this.nombrePareja).substring(0, tamnNom);
        raf.writeChars(nombreParejaF);
        raf.writeInt(this.partidosWon);
        raf.writeInt(this.partidosLost);
    }

    // Metodo para escribir los registros
    public static PersonasPadel leer(RandomAccessFile raf) throws IOException {
        char estado = raf.readChar();
        int idPareja = raf.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamnNom; i++) {
            sb.append(raf.readChar());
        }
        String nombrePareja = sb.toString().trim();
        int partidosWon = raf.readInt();
        int partidosLost = raf.readInt();

        PersonasPadel pdl = new PersonasPadel(estado, idPareja, nombrePareja, partidosWon, partidosLost);

        return pdl;
    }

    // Formato toString()
    @Override
    public String toString() {
        return "PersonasPadel{" +
                "idPareja=" + idPareja +
                ", estado=" + estado +
                ", nombrePareja='" + nombrePareja + '\'' +
                ", partidosWon=" + partidosWon +
                ", partidosLost=" + partidosLost +
                '}';
    }
}