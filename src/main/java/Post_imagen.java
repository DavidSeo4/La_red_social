import java.util.ArrayList;
import java.util.Date;

public class Post_imagen extends Post {

    private String dimensiones;

    public Post_imagen(Date fechaCreacion, ArrayList<Comentario> listaComentarios, String tipo, String titulo, String dimensiones){
        super(fechaCreacion,listaComentarios,tipo, titulo);
        this.dimensiones = dimensiones;

    }


}
