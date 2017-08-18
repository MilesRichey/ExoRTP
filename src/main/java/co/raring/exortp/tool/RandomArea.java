package co.raring.exortp.tool;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

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
     * Generate a new location
     */
    public void newLocation() {
        this.randomLocation = new Location(world, randDouble(minX, maxX), 60, randDouble(minZ, maxZ));
        this.randomLocation.setY(world.getHighestBlockYAt(randomLocation));
        if(!isSafe(this.randomLocation)) {
            newLocation();
        }
    }
    private boolean isSafe(Location loc) {
        Block block = loc.getBlock();
        Block below = block.getRelative(0,  -1, 0);
        return !block.isLiquid() && !below.isLiquid();
    }
    /**
     * @return Randomly generated location in given world.
     */
    public Location getLocation() {
        return this.randomLocation;
    }

    /**
     * Generates a random double
     * @param min Minimum
     * @param max Maximum
     * @return A random double in the given range.
     */
    private double randDouble(double min, double max) {
        double randomDouble = min + (max - min) * ThreadLocalRandom.current().nextDouble();
        // Chance of making random number negative, if min is negative
        if(min < 0 || max < 0) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                randomDouble = -randomDouble;
            }
        }
        return randomDouble;


    }
}
