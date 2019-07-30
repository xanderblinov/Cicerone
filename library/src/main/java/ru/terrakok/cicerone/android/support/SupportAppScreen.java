package ru.terrakok.cicerone.android.support;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;

import ru.terrakok.cicerone.Screen;

/**
 * AppScreen is a base interface for description and creation application screen.<br>
 * NOTE: If you have described the creation of Intent then Activity will be started.<br>
 * Recommendation: Use Intents for launch external application.
 */
public interface SupportAppScreen extends Screen {

    public Fragment getFragment();

    public Intent getActivityIntent(Context context);
}
