package com.language;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class FillInTheBlank extends Question{


    // Attributes
  private Phrase sampleSentence;
  private ArrayList<String> wordBank;
  private String userInput;

  public FillInTheBlank(String question, Phrase sampleSentence, ArrayList<String> wordBank) {
      //TODO Auto-generated constructor stub
      super(question);
      this.sampleSentence = sampleSentence;
      this.wordBank = wordBank;
  }

  public String checkAnswer(String userInput) 
  {
    String missingWord = getMissingWord(); 
        if (userInput != null && userInput.equalsIgnoreCase(missingWord)) {
            return "You are correct! The missing word was: " + missingWord;
        } 
        else {
            return "Sorry, that was incorrect. The correct word is: " + missingWord;
        }
  }

  public String getMissingWord() 
  {
    String sentence = sampleSentence.getTranslation();
    String[] words = sentence.split(" ");
    Random random = new Random();
    int index = random.nextInt(words.length);
    return words[index];
  }

    
  public String getSampleSentence() {
    String sentence = sampleSentence.getTranslation();
    String missingWord = getMissingWord();
    return sentence.replace(missingWord, "___"); 
  }
 
}
