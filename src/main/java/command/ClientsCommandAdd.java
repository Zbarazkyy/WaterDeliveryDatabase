package command;

import entity.Clients;
import service.ClientsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ClientsCommandAdd implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String fName = request.getParameter("fname");
        String lName = request.getParameter("lname");
        String addressCity = request.getParameter("city");
        String addressStreet = request.getParameter("street");
        String addressHouse = request.getParameter("house");
        String addressFlat = request.getParameter("flat");
        String addressNotes = request.getParameter("notes");
        int phone1 = 0;
        if (!request.getParameter("phone1").isEmpty())
            phone1 = Integer.parseInt(request.getParameter("phone1"));
        int phone2 = 0;
         if (!request.getParameter("phone2").isEmpty())
             Integer.parseInt(request.getParameter("phone2"));
        int phone3 = 0;
        if(!request.getParameter("phone3").isEmpty())
            Integer.parseInt(request.getParameter("phone3"));
        int userId = 1;

        ClientsService clientsService = new ClientsService();
        Clients clients = new Clients();
        clients.setfName(fName);
        clients.setlName(lName);
        clients.setAddressCity(addressCity);
        clients.setAddressStreet(addressStreet);
        clients.setAddressHouse(addressHouse);
        clients.setAddressFlat(addressFlat);
        clients.setAddressNotes(addressNotes);
        clients.setPhone1(phone1);
        clients.setPhone2(phone2);
        clients.setPhone3(phone3);
        clients.setUserId(userId);
        clientsService.addClients(clients);

        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        return "main.jsp";
    }
}
