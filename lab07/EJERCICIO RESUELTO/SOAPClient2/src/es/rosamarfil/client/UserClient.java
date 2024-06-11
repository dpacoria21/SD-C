package es.rosamarfil.client;

import java.util.Arrays;
import java.util.List;

public class UserClient {

    public static void main(String[] args) {
        // Muestra la lista inicial de usuarios
        List<ws.User> users = getUsers();
        System.out.println("Lista de usuarios: \n" + usersToString(users));
        // Añade un nuevo usuario
        addUser("Pablo", "Ruiz");

        // Muestra la lista de usuarios después de añadir uno nuevo
        users = getUsers();
        System.out.println("Lista de usuarios: \n" + usersToString(users));
    }

    private static List<ws.User> getUsers() {
        ws.SOAPImplService service = new ws.SOAPImplService();
        ws.SOAPI port = service.getSOAPImplPort();
        return port.getUsers();
    }

    public static String usersToString(List<ws.User> users) {
        StringBuilder sb = new StringBuilder();
        for (ws.User u : users) {
            sb.append(toString(u.getName(), u.getUsername()));
        }
        return sb.toString();
    }

    public static String toString(String name, String username) {
        return "User [name=" + name + ", username=" + username + "],\n";
    }

    private static void addUser(String name, String username) {
        ws.SOAPImplService service = new ws.SOAPImplService();
        ws.SOAPI port = service.getSOAPImplPort();
        ws.User user = new ws.User();
        user.setName(name);
        user.setUsername(username);
        port.addUser(user);
    }

}

