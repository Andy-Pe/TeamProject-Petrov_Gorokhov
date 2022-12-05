package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Assertions.assertTrue(store.containsGame(game));
    }

    /*Тест на самого играющего без игроков */
    @Test
    public void shouldMostPlayerTimeWithoutPlayers() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Assertions.assertEquals(store.getMostPlayer(), null);
    }

    /*Тест на самого играющего*/
    @Test
    public void shouldMostPlayerTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Andy", 5);
        store.addPlayTime("Alex", 2);

        Assertions.assertEquals(store.getMostPlayer(), "Andy");
    }

    /*Тест при одинаковом времени игры */
    @Test
    public void shouldMostPlayerTimeAtEqualsValues() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Andy", 5);
        store.addPlayTime("Alex", 5);

        Assertions.assertEquals(store.getMostPlayer(), "Alex");
    }

    /*Тест, если три игрока*/
    @Test
    public void shouldMostPlayerTimeIfThreePlayers() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Andy", 4);
        store.addPlayTime("Alex", 5);
        store.addPlayTime("Misha", 2);

        Assertions.assertEquals(store.getMostPlayer(), "Alex");
    }

    /*Тест на суммирование суммирования времени всех игроков, проведённого за играми этого каталога*/
    @Test
    public void shouldSumPlayedTimeAllPlayers() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Andy", 15);
        store.addPlayTime("Alex", 30);
        store.addPlayTime("Misha", 37);

        Assertions.assertEquals(store.getSumPlayedTime(), 82);
    }
    @Test
    public void shouldSumPlayedTimeWithLastValues(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Andy", 25);
        store.addPlayTime("Andy", 50);

        int expected = 75;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }
}
