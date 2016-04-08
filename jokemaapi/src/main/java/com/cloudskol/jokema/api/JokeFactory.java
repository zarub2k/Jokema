package com.cloudskol.jokema.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author tham
 */
public class JokeFactory {
    private static JokeFactory instance;

    private static List<Joke> jokes;

    private JokeFactory() {}

    public static final JokeFactory getInstance() {
        if (instance == null) {
            instance = new JokeFactory();
        }

        if (jokes == null || jokes.isEmpty()) {
            jokes = new ArrayList<Joke>(8);
            addJoke("Yo mamma is so ugly when she tried to join an ugly contest they said, " +
                    "\"Sorry, no professionals.\"");
            addJoke("Don't break anybody's heart; they only have 1. Break their bones; they have 206.");
        }

        return instance;
    }

    public Joke getJoke() {
        final Random random = new Random();
        final int index = random.nextInt(jokes.size());
        return jokes.get(index);
    }

    private static void addJoke(String summary) {
        jokes.add(new Joke(summary));
    }
}
