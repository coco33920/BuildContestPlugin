package fr.colin.buildcontest;

/**
 * Created by colin on 11/03/2017.
 */
public enum GameState {

    LOBBY,
    INGAME;

    private static GameState currentState = LOBBY;
    public static GameState getCurrentState(){
        return currentState;
    }

    public static void setCurrentState(GameState currentState) {
        GameState.currentState = currentState;
    }
}
