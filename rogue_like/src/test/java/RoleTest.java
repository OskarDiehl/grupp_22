import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {
    private final Element element = new EarthElement(2);
    private final Role role = Role.Tank;
    @Test
    void getWarriorAsRoleName(){                                            // This test check if the role name is correct
        Player player = new Player("Sabina", element, role);
        assertEquals("Tank", player.getRole().getRoleName());
    }

    @Test
    void getCorrectLifeAmountFromRole(){                                    // This test check if the amount of life is correct
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getRole().getHP());
    }

    @Test
    void getCorrectPowerAmountFromRole(){                                   // This test check if the amount of power is correct
        Player player = new Player("Sabina", element, role);
        assertEquals(6, player.getRole().getPower());
    }

    @Test
    void getCorrectSpeedAmountFromRole(){                                   // This test check if the amount of speed is correct
        Player player = new Player("Sabina", element, role);
        assertEquals(4, player.getRole().getSpeed());
    }
}
