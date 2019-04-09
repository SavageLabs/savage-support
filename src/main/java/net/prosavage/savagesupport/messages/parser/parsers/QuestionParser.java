package net.prosavage.savagesupport.messages.parser.parsers;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.prosavage.savagesupport.messages.parser.MessageParser;
import net.prosavage.savagesupport.storage.Questions;


public class QuestionParser extends MessageParser {

    public MessageEmbed parseQuestion(String message) {
        if (!super.parse(message)) return null;
        boolean isQuestion = false;
        for (String word : Questions.questionCompounds) if (message.contains(word)) isQuestion = true;
        if (!isQuestion) return null;
        System.out.println("Parsing Question for answers..");
        for (String question : Questions.questionAnswerMap.keySet()) {
            if (message.contains(question)) {
                System.out.println("Question: " + message + " answered.");
                return Questions.questionAnswerMap.get(question).build();
            }
        }
        System.out.println("Question had no answer.");
        return null;
    }


}
