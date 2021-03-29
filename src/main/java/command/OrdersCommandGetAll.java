package command;

import entity.Clients;
import entity.Orders;
import service.ClientsService;
import service.OrdersService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrdersCommandGetAll implements Command{
    @Override
    public String execute(HttpServletRequest request) {

        ClientsService clientsService = new ClientsService();
        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        OrdersService ordersService = new OrdersService();
        List<Orders> ordersList = ordersService.getAllOrders();

        request.setAttribute("ordersList", ordersList);
        return "orders.jsp";
    }
}
