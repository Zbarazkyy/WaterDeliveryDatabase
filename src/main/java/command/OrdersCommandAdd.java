package command;

import entity.Clients;
import entity.Orders;
import entity.Users;
import service.ClientsService;
import service.ItemsService;
import service.OrdersService;
import service.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrdersCommandAdd implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        ItemsService itemsService = new ItemsService();
        int itemId = itemsService.getItemsID(request.getParameter("item"));

        ClientsService clientsService = new ClientsService();
        int clientId = clientsService.getClientId(request.getParameter("fName"));

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Date ordersDat = new Date(Calendar.getInstance().getTimeInMillis());

        UsersService usersService = new UsersService();
        int userId = 1;

        Orders orders = new Orders();
        orders.setItemId(itemId);
        orders.setClientId(clientId);
        orders.setQuantity(quantity);
        orders.setOrdersDate(ordersDat);
        orders.setUserId(userId);

        OrdersService ordersService = new OrdersService();
        ordersService.addOrder(orders);

        List<Orders> ordersList = ordersService.getAllOrders();
        request.setAttribute("ordersList", ordersList);

        List<Clients> clientsList = clientsService.getAllClients();
        request.setAttribute("clientsList", clientsList);

        return "orders.jsp";
    }
}
