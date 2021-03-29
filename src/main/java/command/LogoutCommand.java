package command;

import com.mysql.cj.Session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "login.jsp";
    }
}
