package dev.alex.valentey.servlet.person;

import dev.alex.valentey.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/create")
public class PersonCreateServlet extends HttpServlet {
    private PersonService personService = new PersonService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/person/personCreatePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String createPersonIdParamString = req.getParameter("createPersonIdParam");
        String createPersonNameParamString = req.getParameter("createPersonNameParam");
        String createPersonAgeParamString = req.getParameter("createPersonAgeParam");

        try {
            personService.createPerson(createPersonIdParamString, createPersonNameParamString, createPersonAgeParamString);
        } catch (Exception e) {
            req.getRequestDispatcher("/error").forward(req, resp);
        }

        req.getRequestDispatcher("/person/list").forward(req, resp);
    }


}
