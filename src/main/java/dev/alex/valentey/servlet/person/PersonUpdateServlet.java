package dev.alex.valentey.servlet.person;

import dev.alex.valentey.entity.Person;
import dev.alex.valentey.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/update")
public class PersonUpdateServlet extends HttpServlet {
    PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateIdParam = req.getParameter("updateIdParam");
        Person person = personService.getPersonById(updateIdParam);
        req.setAttribute("person", person);
        req.getRequestDispatcher("/pages/person/personUpdatePage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdParam = req.getParameter("PersonIdParam");
        String updatedPersonNameParam = req.getParameter("updatedPersonNameParam");
        String updatedPersonAgeParam = req.getParameter("updatedPersonAgeParam");
        personService.updatePerson(personIdParam, updatedPersonNameParam, updatedPersonAgeParam);
        req.getRequestDispatcher("/person/list").forward(req, resp);
    }
}
