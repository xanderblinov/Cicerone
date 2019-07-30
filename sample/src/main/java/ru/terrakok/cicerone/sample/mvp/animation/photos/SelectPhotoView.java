package ru.terrakok.cicerone.sample.mvp.animation.photos;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

/**
 * Created by Konstantin Tskhovrebov (aka @terrakok) on 14.07.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SelectPhotoView extends MvpView {
    void showPhotos(int[] resurceIds);
}
