package com.udacity.gradle.builditbigger.test; /**
 * Created by kristenwoodward on 2/26/17.
 */

import com.udacity.gradle.builditbigger.GetJokeTask;
import com.udacity.gradle.builditbigger.OnTaskCompleted;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class testAsyncUnit{

    @Test
    public final void testAsyncTask() throws Throwable {

        final GetJokeTask getJokeTask = new GetJokeTask(new OnTaskCompleted() {
            @Override
            public void OnTaskCompleted(String result) {
                assertNotNull(result);
                assertTrue("Result is empty", result.length()>0);
            }
        });

        getJokeTask.execute();
    }

}
