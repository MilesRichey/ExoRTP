package co.raring.exortp.tool;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.concurrent.ThreadLocalRandom;

public class RandomArea {
    private World world;
    private Location randomLocation;
    public static double maxX, maxZ, minX, minZ;

    /**
     * @param world World to generate random location in.
     */
    //NOTE: ThreadLocalRandom or random instance?
    public RandomArea(World world) {
        this.world = world;
        newLocation();
    }

    /**
     * Generate a new location, if one can't be found after 3 tries give up.
     * @param times Amount of times a new location has been tried
     */
    public void newLocation() {
        this.randomLocation = new Location
                (world, randDouble(minX, maxX), 60, randDouble(minZ, maxZ));
        this.randomLocation.setY(world.getHighestBlockYAt(randomLocation));
    }

    /**
     * @return Randomly generated location in given world.
     */
    public Location getLocation() {
        return this.randomLocation;
    }

    private double randDouble(double min, double max) {
        double randomDouble = min + (max - min) * ThreadLocalRandom.current().nextDouble();
        // Chance of making random coords negative
        if(ThreadLocalRandom.current().nextBoolean()) {
            randomDouble = -randomDouble;
        }
        return randomDouble;
    }
}
