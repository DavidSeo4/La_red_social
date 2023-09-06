import java.util.ArrayList;
import java.util.Date;

public class Post_imagen extends Post {

    private String dimensiones;

    public Post_imagen(Date fechaCreacion, ArrayList<Comentario> listaComentarios, String tipo, String titulo, String dimensiones, Usuario propietario){
        super(fechaCreacion,listaComentarios,tipo, titulo, propietario);
        this.dimensiones = dimensiones;

    }


}
