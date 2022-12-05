package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    private GameStore store = new GameStore();

    private Game netologyBattle = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    private Game zuma = store.publishGame("Zuma", "Аркады");
    private Game portal = store.publishGame("Portal", "Аркады");
    private Game streetFighter = store.publishGame("Street Fighter", "Fights");
    private Game injustice = store.publishGame("Injustice", "Fights");
    private Game injustice2 = store.publishGame("Injustice 2", "Fights");
    private Game nfs = store.publishGame("NFS", "Race");
    private Game granTurismo = store.publishGame("Gran Turismo", "Race");
    private Game wow = store.publishGame("World Of Warcraft", "MMORPG");
    private Game aion = store.publishGame("Aion", "MMORPG");


    @Test
    public void shouldSumGenreIfOneGame() {  // cуммирует время проигранное во все игры одного жанра игроком "Петя", если добавлена только одна игра

        Player player = new Player("Petya");
        player.installGame(netologyBattle);
        player.play(netologyBattle, 3);

        int expected = 3;
        int actual = player.sumGenre(netologyBattle.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfFewGames() { // суммирует время проигранное во все игры одного жанра игроком "Петя", если добавлено несколько игр

        Player player = new Player("Petya");
        player.installGame(netologyBattle);
        player.installGame(zuma);
        player.installGame(portal);

        player.play(netologyBattle, 3);
        player.play(zuma, 5);
        player.play(portal, 2);

        int expected = 10;
        int actual = player.sumGenre(netologyBattle.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void determinesHoursTheGamePlayedWhenGameInstalled() { // определяет количество часов, которое играли в игру, когда игра установлена

        Player player = new Player("Petya");
        player.installGame(wow);
        player.play(wow, 8);

        int actual = player.play(wow, 8);
        assertEquals(8, actual);
    }

    @Test
    public void displaysThrowExceptionWhenGameNotInstalled() { // выводит исключение при подсчёте количество часов, которое играли в игру, если она не установлена

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> player.play(wow, 12));
    }

    @Test
    public void mostPlayerByGenreGamePlayed() { // определяем игру, в жанр которой больше всего играли
        Player player = new Player("Petya");
        player.installGame(injustice);
        player.installGame(nfs);
        player.installGame(wow);

        player.play(injustice, 4);
        player.play(nfs, 2);
        player.play(wow, 24);


        Game expected = (wow);
        Game actual = player.mostPlayerByGenre("MMORPG");

        assertEquals(expected, actual);
    }
}