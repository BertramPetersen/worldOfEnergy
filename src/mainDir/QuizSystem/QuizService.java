package mainDir.QuizSystem;

import mainDir.PredictionService.Forecast;

public interface QuizService {
    // Quiz methods
    void takeQuiz();

    // RandomEvent methods
    void initiateRandomEvent(Forecast forecast);
}
