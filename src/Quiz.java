import java.util.Scanner;

public class Quiz {
    String question;
    String questionAnswer;

    public Quiz() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String answer) {
        this.questionAnswer = answer;
    }

    public void playQuiz (){
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println(question);
        String userAnswer = keyboardInput.nextLine();
        if (userAnswer.equals(questionAnswer)) {
            System.out.println("Congratulations! Your answer was correct. You just got 50 coins added to your wallet!");
            //  Insert "Wallet.add(50);" here
            System.out.println("You now have " + "Wallet.amount" + " coins in your wallet");
        } else {
            System.out.println("Oh no! Your answer was incorrect. The correct answer was " + questionAnswer + ". You unfortunately get 0 coins. Better luck next time!");
        }
    }
}
