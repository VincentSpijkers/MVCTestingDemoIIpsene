import models.Player;
import org.junit.Before;
import org.junit.Test;
import shared.PlayerObservable;
import views.PlayerObserver;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPlayerClass {

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


}
