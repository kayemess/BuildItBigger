/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.kristenwoodward.myapplication.backend;

import com.example.JavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import com.example.JavaJoke;

import java.util.Random;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.kristenwoodward.example.com",
                ownerName = "backend.myapplication.kristenwoodward.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    MyJoke myJoke;
    JavaJoke newJavaJoke;
    String mJoke;

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke(@Named("radomInt") int randomInt) {
        myJoke = new MyJoke();
        newJavaJoke = new JavaJoke();

        mJoke = newJavaJoke.getJoke(randomInt);

        myJoke.setData(mJoke);

        return myJoke;
    }

}
