package ru.terrakok.cicerone.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;
import ru.terrakok.cicerone.sample.ui.animations.profile.ProfileFragment;

/**
 * Screen is class for description application screen.
 */
public abstract class BaseScreen implements SupportAppScreen {

    protected String screenKey = getClass().getCanonicalName();

    @Override
    public String getScreenKey() {
        return screenKey;
    }

    @Override
    public Fragment getFragment() {
        return new ProfileFragment();
    }

    @Override
    public Intent getActivityIntent(final Context context) {
        return null;
    }
}
