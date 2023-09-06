import java.util.*;

public class RedSocial {

    HashMap<String, Usuario> listaUsuarios = new LinkedHashMap<>(); //LinkedHashMap para que los almacene en orden de entrada//
    HashMap<Post, Comentario> listaComentarios = new HashMap<>();
    Usuario userActivo;

    public RedSocial() {

        listaUsuarios.put("David", new Usuario("David", new ArrayList<>(), new ArrayList<>()));
        listaUsuarios.put("Andres", new Usuario("Andres", new ArrayList<>(), new ArrayList<>()));
        listaUsuarios.put("Sara", new Usuario("Sara", new ArrayList<>(), new ArrayList<>()));
        listaUsuarios.put("Angel", new Usuario("Angel", new ArrayList<>(), new ArrayList<>()));


    }

    public void añadirUser(Usuario user) {
        listaUsuarios.put(user.getNombre(), user);
    }

    public void eliminarUser(Usuario user) {
        if (listaUsuarios.containsKey(user.getNombre())) {
            listaUsuarios.remove(user.getNombre());
            System.out.println("Usuario eliminado con exito");
        } else {
            System.out.println("Ese usuario no existe o no está escrito correctamente.");
        }

    }

    public Usuario extraerUser(String nombre) {
        for (Map.Entry u : listaUsuarios.entrySet()) {
            if (u.getKey().equals(nombre)) {
                return (Usuario) u.getValue();
            }
        }
        return null;
    }

    public void mostrarUsers() {
        int contador = 1;
        for (Map.Entry u : listaUsuarios.entrySet()) {
            System.out.println("-"+ contador+ " " + u.getKey());
            contador++;
        }
    }

    public Post extraer_1_Post(Usuario user, String titulo) {
        for (Post p : user.getListaPosts()) {
            if (p.getTitulo().equals(titulo)) {
                return p;
            }
        }
        return null;
    }

    public void eliminarPost(Usuario user, String titulo) {
        if (user.getListaPosts().contains(titulo)) {
            user.getListaPosts().remove(titulo);
        }
    }

    public void mostrarPostsUser(Usuario user) {
        System.out.println("Los posts de " + user.getNombre() + " son:");
        for (Post p : user.getListaPosts()) {
            System.out.println("-" + p.getTitulo() + ". Tipo:  " + p.getTipo());
        }
    }

    public boolean seguirUser(Usuario user1, Usuario user2) {
        if (user1.getListaSeguidos().contains(user2)) {
            System.out.println("Ya sigues a este usuario.");
            return false;
        } else {
            user1.getListaSeguidos().add(user2);
            System.out.println("Usuario seguido con exito.");
            return true;
        }
    }

    public boolean dejarDeSeguirUser(Usuario user1, Usuario user2) {
        if (user1.getListaSeguidos().contains(user2)) {
            user1.getListaSeguidos().remove(user2);
            System.out.println("Ya no sigues a este usuario.");
            return false;
        } else {
            user2.getListaSeguidos().add(user1);
            System.out.println("No sigues a " + user2.getNombre());
            return true;
        }
    }

    public void añadirComentarioLista(Post post, Comentario comentario) {
        listaComentarios.put(post, comentario);
    }

    public void mostrarComentariosUser(Usuario user) {
        System.out.println("Tus comentarios son: ");
        for (Map.Entry<Post, Comentario> c : listaComentarios.entrySet()) {
            if (c.getValue().getPropietario().equals(user)) {
                System.out.println("-" + c.getValue().getTexto() + ". Con fecha: " + c.getValue().getFechaComentario());
            }
        }
    }

    public void mostrar_muro (Usuario user){
        if (user.getListaSeguidos().isEmpty()){
            System.out.println("El muro de " + user.getNombre()+ " está vacio actualmente");
        } else {
            System.out.println("Muro de " + user.getNombre());
            ArrayList<Post> listaPostsMuro = new ArrayList<>();
            for (Usuario u: user.getListaSeguidos()) {
                listaPostsMuro.addAll(u.getListaPosts());
            }
            // Comparador personalizado para comparar por fecha de creación
            Comparator<Post> comparadorPorFecha = Comparator.comparing(Post::getFechaCreacion);

            // Ordenar listaPostsMuro utilizando el comparador
            Collections.sort(listaPostsMuro, comparadorPorFecha);
            Collections.reverse(listaPostsMuro);

            int contador = 1;
            for (Post p: listaPostsMuro){
                if (contador<=10){
                    System.out.println( "-Post: "+p.getTitulo()+ "\n   Usuario: " + p.getPropietario().getNombre() + "\n   Tipo: " + p.getTipo() + "\n   Fecha de creación: " + p.getFechaCreacion());
                    for (Comentario c: p.getListaComentarios()){
                         System.out.println("      $"+c.getPropietario().getNombre() + " comentó: " + c.getTexto());
                    }
                }
            }
        }
    }


    public HashMap<Post, Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(HashMap<Post, Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }

    public HashMap<String, Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(HashMap<String, Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUserActivo() {
        return userActivo;
    }

    public void setUserActivo(Usuario userActivo) {
        this.userActivo = userActivo;
    }
}
