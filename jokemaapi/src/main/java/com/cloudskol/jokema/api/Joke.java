package com.cloudskol.jokema.api;

/**
 * @author tham
 */
public class Joke {
    private JokeType type;
    private String summary;

    public Joke(JokeType type, String summary) {
        this.type = type;
        this.summary = summary;
    }

    public Joke(String summary) {
        this(JokeType.GENERAL, summary);
    }

    public JokeType getType() {
        return type;
    }

    public String getSummary() {
        return summary;
    }
}
