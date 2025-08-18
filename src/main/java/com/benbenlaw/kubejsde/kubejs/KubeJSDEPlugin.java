package com.benbenlaw.kubejsde.kubejs;

import com.benbenlaw.kubejsde.kubejs.draconicevolution.FusionRecipeJS;
import com.benbenlaw.kubejsde.kubejs.draconicevolution.IFusionIngredientComponent;
import com.benbenlaw.kubejsde.kubejs.draconicevolution.TechLevelComponent;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeComponentFactoryRegistry;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import net.minecraft.resources.ResourceLocation;

public class KubeJSDEPlugin implements KubeJSPlugin {

    public static EventGroup GROUP = EventGroup.of("KubeJSDraconicEvolutionEvents");

    @Override
    public void registerRecipeSchemas(RecipeSchemaRegistry event) {
        event.register(ResourceLocation.fromNamespaceAndPath("draconicevolution", "fusion_crafting"), FusionRecipeJS.SCHEMA);
    }

    @Override
    public void registerRecipeComponents(RecipeComponentFactoryRegistry registry) {
        registry.register(TechLevelComponent.INSTANCE);
        registry.register(IFusionIngredientComponent.INSTANCE);
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(GROUP);
    }
}