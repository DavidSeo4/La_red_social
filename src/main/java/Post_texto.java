import java.util.ArrayList;
import java.util.Date;

public class Post_texto extends Post {

    private String contenido;

    public Post_texto(Date fechaCreacion, ArrayList<Comentario> listaComentarios, String tipo, String titulo, String contenido){
        super(fechaCreacion,listaComentarios,tipo, titulo);
        this.contenido = contenido;

    }


}
