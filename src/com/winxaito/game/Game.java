package com.winxaito.game;

/**
 * Created by: WinXaito (Kevin Vuilleumier)
 */
public interface Game{
    void onStart();
    void onPlay();
    void onSkip();
    void onEnd();
    void onGet();
    void onGetAll();
}
