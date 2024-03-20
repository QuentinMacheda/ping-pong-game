package pingPongGame.model.components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallModelTest {

    @Test
    void testBallInitialization() {
        BallModel ball = new BallModel();
        assertEquals(0, ball.getPosX());
        assertEquals(0, ball.getPosY());
        assertEquals(14, ball.getRadius());
        assertNotNull(ball.getBounds());
        assertEquals(28, ball.getBallSize());
        assertEquals("normal", ball.getSpeed());
        assertEquals("normal", ball.getSpeedIR());
    }

    @Test
    void testBallMovement() {
        BallModel ball = new BallModel();
        ball.moveBall();
        // Test if the ball moves after calling the move method
        assertNotEquals(0, ball.getPosX());
        assertNotEquals(0, ball.getPosY());
    }
}
