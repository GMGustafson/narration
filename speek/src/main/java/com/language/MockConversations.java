package com.language;

import java.util.ArrayList;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class MockConversations extends Question{
    private String topic;
    private ArrayList<String> script;
    private ArrayList<String> roles;
    private ArrayList<String> answers;

    /**
    * Constructor for MockConversations
    * @param question
    */
    public MockConversations(String question) {
        super(question);
    }

    /**
     * getTopic method
     * Returns topic of mock conversation
     * @return topic
     */
    public String getTopic(){
        return topic != null ? topic : "No topic available";
	}

    /**
     * setTopic method
     * sets topic
     * @param topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

     /**
     * getScript method
     * Returns script of mock conversation
     * @return script
     */
	public String getScript(){
        return script != null && !script.isEmpty() ? String.join("\n", script) : "No script available";
	}

    /**
     * setScript method
     * sets script as a list of strings
     * @param script
     */
    public void setScript(ArrayList<String> script) {
        this.script = script;
    }

     /**
     * getRoles method
     * Returns roles of mock conversation
     * @return roles
     */
	public String getRoles(){
        return roles != null && !roles.isEmpty() ? String.join(", ", roles) : "No roles available";
    }

    /**
     * setRoles method
     * sets roles as a list of strings
     * @param roles
     */
    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

     /**
     * getAnswers method
     * Returns answers of mock conversation
     * @return answers
     */
    public String getAnswers(){
        return answers != null && !answers.isEmpty() ? String.join(", ", answers) : "No answers available";
    }

    /**
     * setAnswers method
     * sets answers as a list of strings
     * @param answers
     */
    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

     /**
     * getOptions method
     * Returns options of mock conversation
     * @return options
     */
    public String getOptions(){
        String options = "Choose an option:";
        for (int i = 0; i < answers.size(); i++) {
            options += (i + 1) + ": " + answers.get(i);
        }
        return options; 
    }

     /**
     * toString method
     * Returns string in toString format
     * @return topic, script, roles, and answers of mock conversation in toString format
     */
    public String toString(){
        return "Topic: " + getTopic() + "\n" +
               "Script: " + getScript() + "\n" +
               "Roles: " + getRoles() + "\n" +
               "Answers: " + getAnswers(); 
    }

}
