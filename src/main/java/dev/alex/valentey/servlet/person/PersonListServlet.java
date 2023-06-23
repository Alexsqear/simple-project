package dev.alex.valentey.servlet.person;

//import dev.alex.valentey.dao.impl.PersonMysqlJdbcDao;
import dev.alex.valentey.entity.Person;
import dev.alex.valentey.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
        import java.util.List;


@WebServlet("/person/list")
public class PersonListServlet extends HttpServlet {

    private PersonService personService = new PersonService();
    private int counter = 0;

    @Override
    public void init() throws ServletException {
        counter = 10;
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("counter", counter);
        counter++;
        req.setAttribute("message", "My first jsp");

        Person somePerson = new Person(1, "vova", 35);
        req.setAttribute("somePerson", somePerson);

        req.setAttribute("persId", somePerson.getPersonId());
        req.setAttribute("persName", somePerson.getName());
        req.setAttribute("persAge", somePerson.getAge());

        List<Person> personList = personService.readAllPersons();
        req.setAttribute("personList", personList);

        req.getRequestDispatcher("/pages/person/personListPage.jsp").forward(req, resp);
//        resp.sendRedirect("/simple-project/pages/person/personListPage.jsp");
    }
}
