package com.cloudskol.jokema;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Test;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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
        activity_.setAsyncTesting(true);
        onView(withId(R.id.cloudJokeBtn)).perform(click());
        assertNotNull(activity_.);
//        final JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(activity_);
//
//        try {
//            String result = jokeAsyncTask.execute().get();
//            assertNotNull(result);
//
//            System.out.println("Result: " + result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
