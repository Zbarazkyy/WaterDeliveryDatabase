package command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static CommandFactory factory = null;
    private Map<String, Command> command = new HashMap<String, Command>();

    private CommandFactory() {
    }
    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }
    {
        command.put("login", new LoginCommand());
        command.put("register", new RegisterCommand());
        command.put("items", new ItemsCommand());
        command.put("ordersList", new OrdersCommandGetAll());
        command.put("addClients", new ClientsCommandAdd());
        command.put("addOrder", new OrdersCommandAdd());
        command.put("clientsList", new ClientsListCommand());
        command.put("logout", new LogoutCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        Command command = this.command.get(action);
        return command;
    }
}
