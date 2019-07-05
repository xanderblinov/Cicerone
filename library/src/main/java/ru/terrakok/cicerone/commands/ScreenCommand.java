package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;

public interface ScreenCommand extends Command {

    public Screen getScreen();
}
