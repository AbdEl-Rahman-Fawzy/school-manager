import java.util.List;

// Quiz class
class Quiz {
    private String quizID;
    private String title;
    private Quiztype quiztype;
    private List<String> questions;
    private int duration;
    private String startDate;
    private String endDate;
    private boolean isActive;
    private double score;
    private Instructor quizCreator;

    //methods
    public void startQuiz(){}
    public void endQuiz(){}
    public void attemptQuiz(){}
    public void submitAnswers(List<String> studentAnswers){}
    public void checkAnswers(List<String> studentAnswers){}
    public void shuffleQuestions(){}
    public void getQuizDetails(){}
}
enum Quiztype{
    Simple,
    Midterm,
    Final,
    Practical
}
