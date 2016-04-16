package com.cloudskol.jokema;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * @author tham
 */
public class JokeAsynAndroidTest extends AndroidTestCase {
    public void testAsync() {
        final MainActivity activity = new MainActivity();
        final JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(activity);

        try {
            String result = jokeAsyncTask.execute().get();
            assertNotNull(result);

            System.out.println("Result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}