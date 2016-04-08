package com.cloudskol.jokema.api;

public class JokemaAPI {
    public Joke getJoke() {
        return JokeFactory.getInstance().getJoke();
    }
}
