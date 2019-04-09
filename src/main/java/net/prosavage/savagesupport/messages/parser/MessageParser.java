package net.prosavage.savagesupport.messages.parser;

public class MessageParser {

    public boolean parse(String message) {
        // More than 3 chars, and more than 1 word.
        return message.length() >= 3 && message.split(" ").length >= 2;
    }


}
