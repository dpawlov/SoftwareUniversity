package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void attackedTargetLoosesHealth() {
        // Arrange
        Dummy dummy = new Dummy(10, 10);

        // Act
        dummy.takeAttack(5);

        // Assert
        assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void throwsExceptionIfDummyIsDeadAndThenAttacked() {
        // Arrange
        Dummy dummy = new Dummy(10, 10);

        // Act
        dummy.takeAttack(10);
        dummy.takeAttack(10);
    }

    @Test
    public void deadDummyCanGiveXP() {
        // Arrange
        Dummy dummy = new Dummy(10, 10);

        // Act
        dummy.takeAttack(20);

        // Assert
        assertEquals(10, dummy.giveExperience());
    }

    // Alive Dummy can't give XP

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        // Arrange
        Dummy dummy = new Dummy(10, 10);

        // Act
        dummy.giveExperience();
    }
}