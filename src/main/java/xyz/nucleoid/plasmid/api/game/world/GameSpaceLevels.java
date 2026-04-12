package xyz.nucleoid.plasmid.api.game.world;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import xyz.nucleoid.fantasy.RuntimeLevelConfig;
import xyz.nucleoid.plasmid.api.game.GameSpace;

import java.util.Iterator;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;

/**
 * Represents all temporary {@link ServerLevel} instances attached to this {@link GameSpace}.
 */
public interface GameSpaceLevels extends Iterable<ServerLevel> {
    /**
     * Creates and adds a temporary world to be associated with this {@link GameSpace}.
     * When the game is closed, the world will be deleted.
     *
     * @param worldConfig a config describing how the new world should be created
     * @return the created world instance
     * @see RuntimeLevelConfig
     */
    ServerLevel add(RuntimeLevelConfig worldConfig);


    /**
     * Creates (or loads) and adds a persistent world to be associated with this {@link GameSpace}.
     * When the game is closed, the world will be unloaded, with all chunks saved.
     * If world using this id is already loaded, this method will throw an exception.
     *
     * @param worldConfig a config describing how the new world should be created and how it should behave
     * @return the created world instance
     * @see RuntimeLevelConfig
     */
    @ApiStatus.Experimental
    ServerLevel addPersistent(Identifier identifier, RuntimeLevelConfig worldConfig);


    /**
     * Removes and deletes a temporary world that is associated with this {@link GameSpace}.
     * The passed world must have been created through {@link GameSpaceLevels#add(RuntimeLevelConfig)}.
     *
     * @param world the world instance to delete
     * @see GameSpaceLevels#add(RuntimeLevelConfig)
     */
    boolean remove(ServerLevel world);

    @NotNull
    @Override
    Iterator<ServerLevel> iterator();
}
