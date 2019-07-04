package ru.terrakok.cicerone.sample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;

import ru.terrakok.cicerone.sample.ui.animations.ProfileActivity;
import ru.terrakok.cicerone.sample.ui.animations.photos.SelectPhotoFragment;
import ru.terrakok.cicerone.sample.ui.animations.profile.ProfileFragment;
import ru.terrakok.cicerone.sample.ui.bottom.BottomNavigationActivity;
import ru.terrakok.cicerone.sample.ui.bottom.ForwardFragment;
import ru.terrakok.cicerone.sample.ui.bottom.TabContainerFragment;
import ru.terrakok.cicerone.sample.ui.main.MainActivity;
import ru.terrakok.cicerone.sample.ui.main.SampleFragment;
import ru.terrakok.cicerone.sample.ui.start.StartActivity;

/**
 * Created by Konstantin Tckhovrebov (aka @terrakok)
 * on 11.10.16
 */

public class Screens {
    public static final class SampleScreen extends BaseScreen {
        private final int number;

        public SampleScreen(int number) {
            this.number = number;
            this.screenKey = getClass().getSimpleName() + "_" + number;
        }

        @Override
        public Fragment getFragment() {
            return SampleFragment.getNewInstance(number);
        }
    }

    public static final class StartScreen extends BaseScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, StartActivity.class);
        }
    }

    public static final class MainScreen extends BaseScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, MainActivity.class);
        }
    }

    public static final class BottomNavigationScreen extends BaseScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, BottomNavigationActivity.class);
        }
    }

    public static final class TabScreen extends BaseScreen {
        private final String tabName;

        public TabScreen(String tabName) {
            this.tabName = tabName;
        }

        @Override
        public Fragment getFragment() {
            return TabContainerFragment.getNewInstance(tabName);
        }
    }

    public static final class ForwardScreen extends BaseScreen {
        private final String containerName;
        private final int number;

        public ForwardScreen(String containerName, int number) {
            this.containerName = containerName;
            this.number = number;
        }

        @Override
        public Fragment getFragment() {
            return ForwardFragment.getNewInstance(containerName, number);
        }
    }

    public static final class GithubScreen extends BaseScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/terrakok/Cicerone"));
        }
    }

    public static final class ProfileScreen extends BaseScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, ProfileActivity.class);
        }
    }

    public static final class ProfileInfoScreen extends BaseScreen {
        @Override
        public Fragment getFragment() {
            return new ProfileFragment();
        }

        @Override
        public Intent getActivityIntent(final Context context) {
            return null;
        }
    }

    public static final class SelectPhotoScreen extends BaseScreen {
        @Override
        public Fragment getFragment() {
            return new SelectPhotoFragment();
        }
    }
}
