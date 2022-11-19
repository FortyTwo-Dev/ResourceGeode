package fr.titi.resourcesgeode.geode;

import fr.titi.resourcesgeode.ResourceGeode;
import fr.titi.resourcesgeode.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class GeodeLoaderPlaced {

    private String geodeName;
    private int geodeOnAverageOnceEvery;
    private int geodeAboveBottom;
    private int geodeAbsolute;

    //public GeodeLoaderPlaced() {
    //    this.codeName = OOO;
    //    this.geodeName = "Universal_geode";
    //    this.geodeOnAverageOnceEvery = 50;
    //    this.geodeAboveBottom = 6;
    //    this.geodeAbsolute = 50;
    //}

    public GeodeLoaderPlaced(String name, int onAverageOnceEvery, int aboveBottom, int absolute) {
        this.geodeName = name;
        this.geodeOnAverageOnceEvery = onAverageOnceEvery;
        this.geodeAboveBottom = aboveBottom;
        this.geodeAbsolute = absolute;

        final DeferredRegister<PlacedFeature> PLACED_FEATURES =
                DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ResourceGeode.MOD_ID);

        final RegistryObject<PlacedFeature> UNIVERSAL_GEODE_PLACED = PLACED_FEATURES.register(geodeName,
                () -> new PlacedFeature(ModConfiguredFeatures.UNIVERSAL_GEODE.getHolder().get(), List.of(
                        RarityFilter.onAverageOnceEvery(geodeOnAverageOnceEvery), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(geodeAboveBottom), VerticalAnchor.absolute(geodeAbsolute)),
                        BiomeFilter.biome())));
    }
}