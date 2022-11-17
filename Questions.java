import java.util.ArrayList;

public class Questions{
    private ArrayList<Question> questions;
    private int questionSelected;

    public Questions(){
        questions = new ArrayList<Question>(); 
        createQuestions();
    }

    private void createQuestions(){        
        Question question1 = new Question("Cuando gano argentina su ultimo mundial?", "A. 1978", "B. 1986", "C. 2014", "A");
        questions.add(question1);    
        Question question2 = new Question("Cual es el primer apellido del trainer Carlos?", "A. Arrazcaita", "B. Azcarraga", "C. Arjona", "B");
        questions.add(question2);    
        Question question3 = new Question("Quien es el trainee de menor edad?", "A. Brayan", "B. Carolina", "C. Mauricio", "C");
        questions.add(question3);    
        Question question4 = new Question("Cual es el resutado de la siguiente operación? 2*5+10(3*2)", "A. 70", "B. 120", "C. 130", "A");
        questions.add(question4);    
        Question question5 = new Question("Cual pesa mas un litro de agua o un litro de pegamento?", "A. Pesan lo mismo", "B. Pegamento", "C. Agua", "B");
        questions.add(question5);    
        Question question6 = new Question("De las siguientes opciones que pais tiene la mayor cantidad de copas del mundo?", "A. Fancia", "B. Argentina", "C. Italia", "C");
        questions.add(question6);

    }

    public Question getQuestion(int questionNumber){
        this.questionSelected = questionNumber;
        return questions.get(questionNumber);
    }

    public boolean checkAnswer(String answer){
        Question question = questions.get(this.questionSelected);
        if(question.correctAnswer == answer){
            return true;
        }
        
        return false;
    }


}