package com.cloudskol.jokema;

import android.test.ActivityInstrumentationTestCase2;

import java.util.concurrent.ExecutionException;

/**
 * @author tham
 *
 * Functional test class for our application
 */
public class JokeAsynAndroidTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity activity_;
    public JokeAsynAndroidTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity_ = getActivity();
    }

    @Test
    public void testAsync() {
        final JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(activity_);

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
