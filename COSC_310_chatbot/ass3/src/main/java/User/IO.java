package User;

import nlp.POS1;
import nlp.SpellCheck;

import java.io.IOException;
import java.net.URISyntaxException;


public class IO {


    String usertext;
    String Lusertext;

    GUI1 gui;
    Boolean exit = false;
    int excount=0;
    Survey survey;
    nlp.POS1 pos = new POS1();
    Server server = new Server();
    Apple apple;
    Boolean english =true;
    translator trans = new translator();
    public IO(GUI1 gui){

        this.gui=gui;
        apple = new Apple();
        solution sol = new solution();
    gui.reply("Hello! I am Team 30's Virtual Product Assistant"+"\n" +"at anytime enter apple or android to switch to advice for the specified device\n"+
            "I am set to default to apple products\n"+"try our new feature and ask to see tech tips\n"+"in order to exit the program enter exit or done\n"+
            "Chatbot: How can I help you today?\n");
    }
    public IO(ClientGUI gui){

        this.gui=gui;
        apple = new Apple();
        solution sol = new solution();
        gui.reply("Hello! I am Team 30's Virtual Product Assistant"+"\n" +"at anytime enter apple or android to switch to advice for the specified device\n"+
                "I am set to default to apple products\n"+"in order to exit the program enter exit or done\n"+
                "Chatbot: How can I help you today?\n");
    }
    void button(String txt){
        gui.screenout("Client: " + txt + "\n");//user input is added to text area
        gui.field.setText("");//reset input box
   usertext=txt;
   // receive rahman's text here.
    }

    void solfind(String txt) throws Exception {
        txt = SpellCheck.correct(txt);
        txt = pos.lstring(txt);
        String ans= solution.Findsol(txt);
        if(ans.equals("Chatbot: switching to french")) {
        english=false;
        }
        if(ans.equals("Chatbot: switching to english")) {
            english=true;
        }

       if(exit){
           exit();
       }
       else if (ans.equals("exit")){
            gui.screenout("Chatbot: please complete our survey\nplease answer the following questions by entering a score from 1-10\n" +
                    "1-not at all. 10-totaly agree\npress RETURN to contiue\n");
           survey = new Survey();
            exit();
        }
        else {

            //pos.lstring(txt);
           if(!english) {
               gui.screenout(trans.callUrlAndParseResult("en", "fr",ans + ".\n Chatbot:What else can I help you with" + "\n"));
           }
           if(english)
               gui.screenout(ans + ".\n Chatbot:What else can I help you with" + "\n");
           // add the bot's answer here, send to rahman

        }


    }

    private void exit() {
        exit = true;

            gui.screenout("ChatBot: "+survey.SurveyQuestions.get(excount)+"\n");
            Lusertext=usertext;
            if(excount>=1)
            survey.writer(survey.SurveyQuestions.get(excount-1)+": "+Lusertext);
        excount+=1;
        if(excount>=survey.SurveyQuestions.size())
        gui.close();
    }

}


