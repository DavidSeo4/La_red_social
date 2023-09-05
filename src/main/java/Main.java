import util.Input;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner_nombre = new Scanner(System.in);
        String userActivo;
        boolean userSelecionadoMenu = false;
        boolean salirAlMenu = false;
        RedSocial redSocial = new RedSocial();

        do {
            System.out.println("Red social de CampusDual. Escribe el nombre del usuario deseas utilizar");
            redSocial.mostrarUsers();
            userActivo = scanner_nombre.nextLine();
            for (Map.Entry u : redSocial.getListaUsuarios().entrySet()) {
                if (userActivo.equals(u.getKey())) {
                    System.out.println("Has selecionado: " + u.getKey());
                    redSocial.setUserActivo(redSocial.extraerUser(userActivo));
                    userSelecionadoMenu = true;
                }
            }
        } while (userSelecionadoMenu == false);


        do {
            System.out.println("¿Que deseas hacer, " + userActivo + "? \n1 Añadir un user \n2 Añadir un Post \n3 Añadir un comentario \n4 Dejar de seguir a un usuario " +
                    "\n5 Comenzar a seguir a un usuario \n6 Eliminar un user \n7 Eliminar un Post \n8 Eliminar un Comentario \n9 Listar todos los posts de un usuario " +
                    "\n10 Listar todos los comentarios de un usuario \n11 Mostrar el numero de comentarios que tiene un post \n12 Mostrar todos los usuarios \n13 Salir de la aplicación ");
            Scanner scanner_añadir_datos = new Scanner(System.in);
            Scanner scanner_menu = new Scanner(System.in);
            int selectorMenu = scanner_menu.nextInt();
            switch (selectorMenu) {
                case 1:
                    System.out.println("Nombre del user?");
                    String nombre = scanner_añadir_datos.nextLine();
                    Usuario nuevo_user = new Usuario(nombre, new ArrayList<>(), new ArrayList<>());
                    if (redSocial.getListaUsuarios().containsKey(nombre)) {
                        System.out.println("Ya existe un user con ese nombre. Prueba otro distinto.");
                    } else {
                        redSocial.añadirUser(nuevo_user);
                        System.out.println("Usuario añadido con éxito");
                    }
                    break;
                case 2:
                    int tipo_post = 0;
                    try {
                        System.out.println("Tipo del post? \n1 Texto \n2 Imagen \n3 Video");
                        Scanner scanner_añadir_datos2 = new Scanner(System.in);
                        tipo_post = scanner_añadir_datos2.nextInt();
                    } catch (InputMismatchException exception){
                        exception.printStackTrace();
                        System.out.println("Selecciona una de las 3 opciones de posts disponibles.");
                    }
                    switch (tipo_post) {
                        case 1:
                            System.out.println("Escribe el titulo del post");
                            String titulo = scanner_añadir_datos.nextLine();
                            System.out.println("Escribe el contenido del post");
                            String contenido = scanner_añadir_datos.nextLine();
                            Post post = new Post_texto(new Date(), new ArrayList<>(), "Texto", titulo, contenido);
                            redSocial.getUserActivo().getListaPosts().add(post);
                            System.out.println("Post creado con exito");
                            break;
                        case 2:
                            System.out.println("Escribe el titulo de la imagen");
                            String titulo2 = scanner_añadir_datos.nextLine();
                            System.out.println("Escribe las dimensiones de la imagen. EX: 345x256");
                            String dimensiones = scanner_añadir_datos.nextLine();
                            Post post2 = new Post_imagen(new Date(), new ArrayList<>(), "Imagen", titulo2, dimensiones);
                            redSocial.getUserActivo().getListaPosts().add(post2);
                            System.out.println("Post creado con exito");
                            break;
                        case 3:
                            System.out.println("Escribe el titulo del video");
                            String titulo3 = scanner_añadir_datos.nextLine();
                            System.out.println("Escribe la calidad del video. EX: 720p");
                            String calidad = scanner_añadir_datos.nextLine();
                            System.out.println("Escribe la duración del video");
                            int duracion = scanner_añadir_datos.nextInt();
                            Post post3 = new Post_video(new Date(), new ArrayList<>(), "Video", titulo3, calidad, duracion);
                            redSocial.getUserActivo().getListaPosts().add(post3);
                            System.out.println("Post creado con exito");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("A que usuario quieres hacerle un comentario?");
                    redSocial.mostrarUsers();
                    String usuario = scanner_añadir_datos.nextLine();
                    if (redSocial.extraerUser(usuario).getListaPosts().isEmpty()){
                        System.out.println("El usuario " + redSocial.extraerUser(usuario).getNombre() + " todavia no tiene ningun post");
                    } else {
                        System.out.println("Que post deseas comentar? Escribe el nombre con claridad");
                        for (Post p: redSocial.extraerUser(usuario).getListaPosts()){
                            System.out.println("-"+p.getTitulo());
                        }
                        String post_a_comentar = scanner_añadir_datos.nextLine();
                        System.out.println("Escribe tu comentario");
                        String comentario = scanner_añadir_datos.nextLine();
                        redSocial.extraer_1_Post(redSocial.extraerUser(usuario), post_a_comentar).getListaComentarios().add(new Comentario(comentario, new Date(), redSocial.getUserActivo()));
                        System.out.println("Comentario realizado con exito.");
                        redSocial.añadirComentarioLista(redSocial.extraer_1_Post(redSocial.extraerUser(usuario), post_a_comentar), new Comentario(comentario, new Date(), redSocial.getUserActivo()));
                    }
                    break;
                case 4:
                    if (redSocial.extraerUser(userActivo).getListaSeguidos().isEmpty()){
                        System.out.println("Todavia no sigues a nadie.");
                    } else {
                        System.out.println("¿A quien quieres dejar de seguir?");
                        String user = Input.string();
                        redSocial.dejarDeSeguirUser(redSocial.extraerUser(userActivo),  redSocial.extraerUser(user));
                    }
                  break;
                case 5:
                    System.out.println("¿A quien quieres seguir?");
                    String user2 = Input.string();
                    redSocial.seguirUser(redSocial.extraerUser(userActivo),  redSocial.extraerUser(user2));
                    break;
                case 6:
                    System.out.println("¿A quien deseas eliminar?");
                    redSocial.mostrarUsers();
                    String user = Input.string();
                    if (user.equals(redSocial.extraerUser(userActivo))){
                        System.out.println("No puedes eliminarte a ti mismo. Intentalo desde otro user.");
                    } else {
                        redSocial.eliminarUser(redSocial.extraerUser(user));
                    }
                    break;
                case 7:
                    if (redSocial.extraerUser(userActivo).getListaPosts().isEmpty()){
                        System.out.println("No tienes ningún Post publicado");
                    } else {
                        System.out.println("Que post deseas eliminar?");
                        redSocial.mostrarPostsUser(redSocial.extraerUser(userActivo));
                        String titulo = Input.string();
                        redSocial.eliminarPost(redSocial.extraerUser(userActivo), titulo);
                    }
                    break;
                case 8:
                    //Eliminar un comentario//
                    System.out.println("Elige el post en el que borrar un comentario.");
                    redSocial.mostrarPostsUser(redSocial.extraerUser(userActivo));


                    break;
                case 9:
                    //Listar todos los posts de un usuario//
                    if (redSocial.extraerUser(userActivo).getListaPosts().isEmpty()){
                        System.out.println("No tienes ningun post que mostrar");
                    } else {
                        redSocial.mostrarPostsUser(redSocial.extraerUser(userActivo));
                    }
                    break;
                case 10:
                    //Listar todos los comentarios de un usuario//
                    redSocial.mostrarComentariosUser(redSocial.extraerUser(userActivo));
                    break;
                case 11:
                    //Mostrar el número de comentarios que tiene un post//
                    if (redSocial.extraerUser(userActivo).getListaPosts().isEmpty()){
                        System.out.println("No tienes ningun post que mostrar, por lo tanto no tienes comentarios");
                    } else {
                        System.out.println("Indica el post que quieres consultar.");
                        redSocial.mostrarPostsUser(redSocial.extraerUser(userActivo));
                        String post_a_consultar = Input.string();
                        System.out.println("El post " + post_a_consultar + " tiene un total de " +
                                redSocial.extraer_1_Post( redSocial.extraerUser(userActivo),post_a_consultar).getListaComentarios().size()
                                +" comentarios ");
                    }
                    break;
                case 12:
                    redSocial.mostrarUsers();
                    break;
                case 13:
                    salirAlMenu = true;
            }

        } while (salirAlMenu == false);

    }
}
