package command;

import entity.Clients;
import entity.Users;
import service.ClientsService;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class RegisterCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

        UsersService usersService = new UsersService();

        Users user = new Users();
        user.setUserName(userName);
        System.out.println(user.getUserName());
        user.setPassword(password);
        System.out.println(user.getPassword());
        user.setAdmin(admin);
        System.out.println(user.isAdmin());
        int testAddUser = 0 ;

        Set<Users> userSList = usersService.getAllUsers();

        if (!userSList.contains(user)) {
            testAddUser = usersService.addUser(user);
            System.out.println("Adding user is - " + testAddUser);
        }
        if (testAddUser == 0) {
            request.setAttribute("notAdd", "This user exists");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }

        String result = (testAddUser == 0) ? "register.jsp" : "main.jsp";

        ClientsService clientsService = new ClientsService();
        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        return result;
    }
}
