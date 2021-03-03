package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.DefaultUserService;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.web.mvc.controller.PageController;
import org.geektimes.web.mvc.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * User 操作
 */
@Path("/register")
public class RegisterUserController implements PageController {

    private UserService userService;

    public RegisterUserController() {
        this.userService = new DefaultUserService();
    }

    @Override
    @POST
    @Path("")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        ServletContext servletContext = request.getServletContext();
        Map<String, String> params = request.getParameterMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()[0]));
        servletContext.log(params.values().toString());
        User user = BeanUtils.initByMap(User::new, params);
        user.setId(UUID.randomUUID().getLeastSignificantBits());
        servletContext.log(user.toString());
        System.out.println(request.getServletContext().getAttribute("dbRepo"));
        userService.register(user);
        return "success.jsp";
    }
}
