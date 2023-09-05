import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private List<Usuario> listaSeguidos = new ArrayList<>();
    private List<Post> listaPosts = new ArrayList<>();


    public Usuario(String nombre, List<Usuario> listaSeguidos, List<Post> listaPosts) {
        this.nombre = nombre;
        this.listaSeguidos = listaSeguidos;
        this.listaPosts = listaPosts;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getListaSeguidos() {
        return listaSeguidos;
    }

    public void setListaSeguidos(List<Usuario> listaSeguidos) {
        this.listaSeguidos = listaSeguidos;
    }

    public List<Post> getListaPosts() {
        return listaPosts;
    }

    public void setListaPosts(List<Post> listaPosts) {
        this.listaPosts = listaPosts;
    }
}
