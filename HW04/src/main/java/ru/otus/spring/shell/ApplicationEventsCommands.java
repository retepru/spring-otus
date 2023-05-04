package ru.otus.spring.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring.domain.User;
import ru.otus.spring.io.Bundle;
import ru.otus.spring.io.ConsoleOut;
import ru.otus.spring.service.AppRun;
import ru.otus.spring.service.QuizService;
import ru.otus.spring.service.UserService;

@ShellComponent
public class ApplicationEventsCommands {

    private final AppRun appRun;
    private final QuizService quizService;
    private final Bundle bundle;
    private final ConsoleOut consoleOut;
    private final UserService userService;

    public ApplicationEventsCommands(AppRun appRun, QuizService quizService, Bundle bundle, ConsoleOut consoleOut, UserService userService) {
        this.appRun = appRun;
        this.quizService = quizService;
        this.bundle = bundle;
        this.consoleOut = consoleOut;
        this.userService = userService;
    }

    @ShellMethod(value = "Create user", key={"cu", "create-user"})
    public void createUser () {
        userService.createUser();
        quizService.clearResult();
    }

    @ShellMethod(value = "Quiz run", key={"qr", "quiz-run"})
    @ShellMethodAvailability(value = "isUserCreate")
    public void quizRun () {
        quizService.askQuestions();
    }

    @ShellMethod(value = "Find out the results", key={"for", "find-out-results"})
    @ShellMethodAvailability(value = "isUserCreateAndRunQuiz")
    public void findOutResults () {
        User user = userService.getUser();
        long count = quizService.getNumberCorrectAnswers();
        consoleOut.println(bundle.getString("you.result.test", user.getFirstName(), count));
    }

    private Availability isUserCreate() {
        return userService.getUser() == null ? Availability.unavailable(bundle.getString("please.create.user")) : Availability.available();
    }

    private Availability isUserCreateAndRunQuiz() {
        if (userService.getUser() == null) {
            return Availability.unavailable(bundle.getString("please.create.user"));
        }
        else if (quizService.getAllResults().isEmpty()) {
            return Availability.unavailable(bundle.getString("please.take.test"));
        }
        return Availability.available();
    }
}
