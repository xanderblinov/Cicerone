package ru.terrakok.cicerone.android.pure;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

import ru.terrakok.cicerone.Screen;

/**
 * AppScreen is base interface for description and creation application screen.<br> NOTE: If you have described the
 * creation
 * of Intent then Activity will be started.<br> Recommendation: Use Intents for launch external application.
 */
public interface AppScreen extends Screen {

    Fragment getFragment();

    Intent getActivityIntent(Context context);
}
