package xyz.nucleoid.plasmid.api.game.config;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import xyz.nucleoid.plasmid.api.registry.PlasmidRegistryKeys;

public final class GameConfigs {
    /**
     * @deprecated Use {@link PlasmidRegistryKeys#GAME_CONFIG} instead.
     */
    @Deprecated
    public static final ResourceKey<Registry<GameConfig<?>>> REGISTRY_KEY = PlasmidRegistryKeys.GAME_CONFIG;
}
