/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

/**
 * Opens new screen.
 */
public class Forward extends ScreenCommand {

    public Forward(final Screen screen) {
        super(screen);
    }
}
