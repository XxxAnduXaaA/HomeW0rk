package task;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FirstServlet extends HttpServlet {

    private ObjectMapper mapper;

    public static final String JSON_VALUE = "application/json";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plane");
        resp.getWriter().write("pong");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(JSON_VALUE);
        if (!req.getContentType().contains(JSON_VALUE)) {
            resp.setStatus(400);
            mapper.writeValue(resp.getWriter(), Map.of("error", "Expected " + JSON_VALUE));
            return;
        }

        Message value;
        try {
            value = mapper.readValue(req.getInputStream(), Message.class);
        } catch (DatabindException ex) {
            resp.setStatus(400);
            mapper.writeValue(resp.getWriter(), Map.of("error", "incorrect json"));
            return;
        }

        if (value == null || value.getValue() == null) {
            resp.setStatus(400);
            mapper.writeValue(resp.getWriter(), Map.of("error", "message is null"));
            return;
        }

        String message = value.getValue();
        mapper.writeValue(resp.getOutputStream(), new Message(message.toUpperCase()));
        resp.setStatus(200);
    }
}