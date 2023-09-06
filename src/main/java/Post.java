import java.util.ArrayList;
import java.util.Date;

public abstract class Post {

    private Date fechaCreacion;
    private ArrayList<Comentario> listaComentarios = new ArrayList<>();
    private String tipo;
    private String titulo;
    private Usuario propietario;


    public Post(Date fechaCreacion, ArrayList<Comentario> listaComentarios, String tipo, String titulo, Usuario propietario) {
        this.fechaCreacion = fechaCreacion;
        this.listaComentarios = listaComentarios;
        this.tipo = tipo;
        this.titulo = titulo;
        this.propietario = propietario;
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }
}
