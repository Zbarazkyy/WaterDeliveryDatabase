package command;

import entity.Clients;
import service.ClientsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ClientsListCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        ClientsService clientsService = new ClientsService();
        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        return "main.jsp";
    }
}
