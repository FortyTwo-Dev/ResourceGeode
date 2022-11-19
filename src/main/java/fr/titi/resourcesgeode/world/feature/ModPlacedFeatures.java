package fr.titi.resourcesgeode.world.feature;

import fr.titi.resourcesgeode.ResourceGeode;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ResourceGeode.MOD_ID);



    public static final RegistryObject<PlacedFeature> UNIVERSAL_GEODE_PLACED = PLACED_FEATURES.register("universal_geode_placed",
                () -> new PlacedFeature(ModConfiguredFeatures.UNIVERSAL_GEODE.getHolder().get(), List.of(
                        RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome())));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
