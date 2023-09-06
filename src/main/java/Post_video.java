import java.util.ArrayList;
import java.util.Date;

public class Post_video extends Post {

    private String calidad;
    private int duracionEnSeg;

    public Post_video(Date fechaCreacion, ArrayList<Comentario> listaComentarios, String tipo, String titulo, String calidad, int duracionEnSeg, Usuario propietario ){
        super(fechaCreacion,listaComentarios,tipo, titulo, propietario);
        this.calidad = calidad;
        this.duracionEnSeg = duracionEnSeg;

    }
}
