package coursework.javaCORE.Controllers;

import coursework.javaCORE.Model.Question;
import coursework.javaCORE.Services.ExaminerService;
import coursework.javaCORE.Services.ExaminerServiceImpl;
import coursework.javaCORE.Services.JavaQuestionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getCollectionOfRandomQuestions(@PathVariable(value = "amount", required = false) int amount) {
        return service.getQuestions(amount);
    }
}
