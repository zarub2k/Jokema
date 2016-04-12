package com.cloudskol.jokema;

import android.app.Activity;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;

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
