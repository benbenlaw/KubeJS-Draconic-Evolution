package com.benbenlaw.kubejsde.kubejs.draconicevolution;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.init.TechProperties;
import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.resources.ResourceLocation;

public class TechLevelComponent implements RecipeComponent<TechLevel> {

    public static final TechLevelComponent INSTANCE = new TechLevelComponent();
    public static final RecipeComponentType<?> TYPE = RecipeComponentType.unit(ResourceLocation.fromNamespaceAndPath("kubejsde", "tech_level"), INSTANCE);

    @Override
    public RecipeComponentType<?> type() {
        return TYPE;
    }

    public Codec<TechLevel> codec() {
        return TechLevel.CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(TechLevel.class);
    }
}
