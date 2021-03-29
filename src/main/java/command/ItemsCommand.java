package command;

import entity.Items;
import service.ItemsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ItemsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        ItemsService itemsService = new ItemsService();
        List<Items> itemsList = itemsService.getAllItems();

        request.setAttribute("itemsList", itemsList);

        return "items.jsp";
    }
}
