import models.Player;
import org.junit.Before;
import org.junit.Test;
import shared.PlayerObservable;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPlayer {

    private Player player;

    @Before
    public void setup(){
        this.player = new Player();
    }

    @Test
    public void Should_BeInstanceOfPlayerObservable(){
        //assert
        assertThat(this.player, instanceOf(PlayerObservable.class));
    }

    @Test
    public void Should_UpdateXAndYPosition_When_RolledDiceIs6AndRangeIs10(){
        // arrange
        int expectedX = 6;
        int expectedY = 0;

        // act
        this.player.updatePosition(6, 10);
        int actualX = this.player.getX();
        int actualY = this.player.getY();

        // assert
        assertThat(actualX, is(expectedX));
        assertThat(actualY, is(expectedY));
    }

    @Test
    public void Should_UpdateXAndYPosition_When_RolledDiceIs6AndRangeIs5(){
        // arrange
        int expectedX = 1;
        int expectedY = 1;

        // act
        this.player.updatePosition(6, 5);
        int actualX = this.player.getX();
        int actualY = this.player.getY();

        // assert
        assertThat(actualX, is(expectedX));
        assertThat(actualY, is(expectedY));
    }


}
