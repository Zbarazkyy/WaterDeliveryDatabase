package command;

import entity.Clients;
import entity.Users;
import service.ClientsService;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        String name = request.getParameter("name");
        String password = request.getParameter("password");


        UsersService usersService = new UsersService();
        Users user = null;

        user = usersService.getUser(name, password);

        String result = (user.getUserName() == null) ? "login.jsp" : "main.jsp";

        if (user.getUserName() == null) {
            request.setAttribute("notExistsAtLogin", "This user not exists");
        } else {
            request.getSession().setAttribute("user", user);
        }
        ClientsService clientsService = new ClientsService();
        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        return result;
    }
}
