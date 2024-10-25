package com.language;
/*
 * @author sri
 */
import java.util.ArrayList;
public class MockConversations extends Question{

    public MockConversations(String question) {
        super(question);
        //TODO Auto-generated constructor stub
    }

    public MockConversations() {
        //TODO Auto-generated constructor stub
    }

    /** attributes of MockConversations class */
    private String topic;
    private ArrayList<String> script;
    private ArrayList<String> roles;
    private ArrayList<String> answers;

    public String getTopic(){
        return topic != null ? topic : "No topic available";
	}

    public void setTopic(String topic) {
        this.topic = topic;
    }

	public String getScript(){
        return script != null && !script.isEmpty() ? String.join("\n", script) : "No script available";
	}

    public void setScript(ArrayList<String> script) {
        this.script = script;
    }

	public String getRoles(){
        return roles != null && !roles.isEmpty() ? String.join(", ", roles) : "No roles available";
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public String getAnswers(){
        return answers != null && !answers.isEmpty() ? String.join(", ", answers) : "No answers available";
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getOptions(){
        String options = "Choose an option:";
        for (int i = 0; i < answers.size(); i++) {
            options += (i + 1) + ": " + answers.get(i);
        }
        return options; 
    }

    public String toString(){
        return "Topic: " + getTopic() + "\n" +
               "Script: " + getScript() + "\n" +
               "Roles: " + getRoles() + "\n" +
               "Answers: " + getAnswers(); 
    }

}
