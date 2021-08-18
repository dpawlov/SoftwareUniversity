package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpaceshipTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        new Spaceship(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        new Spaceship(" ", 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenBelowZero() {
        new Spaceship("Name", -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenCapacityIsFullShouldFail() {
        Spaceship spaceship = new Spaceship("Name", 1);
        spaceship.add(new Astronaut("Astro1", 100));
        spaceship.add(new Astronaut("Astro2", 100));
    }

    @Test
    public void testRemoveAstronautShouldReturnFalseWhenNoSuchAdded() {
        Spaceship spaceship = new Spaceship("Name", 1);
        spaceship.add(new Astronaut("Astro1", 100));
        assertFalse(spaceship.remove("other"));
    }

    @Test
    public void testRemoveAstronautShouldReturnTrueWhenSuchAdded() {
        Spaceship spaceship = new Spaceship("Name", 1);
        spaceship.add(new Astronaut("Astro1", 100));
        assertTrue(spaceship.remove("Astro1"));
    }
}
