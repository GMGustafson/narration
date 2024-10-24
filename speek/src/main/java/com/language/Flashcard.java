package com.language;

/**
 * Name: Hardik Marlapudi
 * Date: 10/6/2024
 */

/**
 * The Flashcards class represents a single flashcard that contains a word,
 * its translation, and an example phrase.
 * This class is designed to be used in a language learning app.
 */

public class Flashcard extends Question{

    /** The word or term on the flashcard in the target language. */
    private String word;

    /** The translation of the word in the learner's native language. */
    private String translation;

    /** An example phrase that uses the word, for contextual learning. */
    private String phrase;

    /**
     * Constructs a new Flashcard object with the specified word, translation, and phrase.
     *
     * @param word The word or term in the target language.
     * @param translation The translation of the word in the learner's native language.
     * @param phrase An example phrase using the word for contextual understanding.
     */

    public Flashcard(String word, String translation, String phrase) {
        this.word = word;
        this.translation = translation;
        this.phrase = phrase;
    }

    // Getters and setters

    /**
     * Returns the word or term in the target language.
     *
     * @return The word in the target language.
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word or term in the target language.
     *
     * @param word The new word for the flashcard.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Returns the translation of the word in the learner's native language.
     *
     * @return The translation of the word.
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Sets the translation of the word in the learner's native language.
     *
     * @param translation The new translation for the word.
     */
    public void setTranslation(String translation) {
        this.translation = translation;
    }

    /**
     * Returns the example phrase for contextual understanding.
     *
     * @return The example phrase.
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * Sets the example phrase for contextual understanding.
     *
     * @param phrase The new example phrase.
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * Returns a string representation of the flashcard object.
     *
     * @return A string containing the word, its translation, and an example phrase.
     */
    @Override
    public String toString() {
        return "Flashcard{" +
               "Word='" + word + '\'' +
               ", Translation='" + translation + '\'' +
               ", Example Phrase='" + phrase + '\'' +
               '}';
    }

    /**
     * Displays the details of the flashcard, including the word, its translation,
     * and an example phrase.
     */
    public void showFlashcard() {
        System.out.println(toString());
    }

}
