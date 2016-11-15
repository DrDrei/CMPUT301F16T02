package com.dryver.UITests;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.dryver.Activities.ActivityRegistration;
import com.dryver.Activities.ActivityUserProfile;
import com.dryver.Controllers.ElasticSearchController;
import com.dryver.Controllers.UserController;
import com.dryver.Models.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests the finctionality of the RequestList Activity
 * @see com.dryver.Activities.ActivityRequestList
 */

public class ActivityRequestListTests {

    private UserController userController = UserController.getInstance();
    private String testUserName = "TestyMcTesterton";
    private User testUser = new User(testUserName, "fTest", "lTest", "5555555555", "Test@Test.com");

    @Rule
    public IntentsTestRule<ActivityRegistration> OPActivityRule = new IntentsTestRule<ActivityRegistration>(
            ActivityRegistration.class);

    /**
     * Initializes the input strings for the editTexts available during registration
     */
    @Before
    public void addUserToESLogin() {
        ElasticSearchController ES = ElasticSearchController.getInstance();
        ES.addUser(testUser);
        userController.login(testUserName);
    }

    @Test
    public void TestOpenUserProfile(){
        openActionBarOverflowOrOptionsMenu(getTargetContext());
        onView(withText("View Profile")).perform(click());

        intended(hasComponent(new ComponentName(getTargetContext(), ActivityUserProfile.class)));
    }

    @Test
    public void TestNewRequest(){
        //TODO: Implememnt.
    }

}