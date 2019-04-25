package net.prosavage.savagesupport.verification.profiles;

// All credit for this class goes to Tech.
public class ProfileComment {

    private String text, userId;

    public ProfileComment(String text, String userId) {
        this.text = text;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public String getUserId() {
        return userId;
    }
}