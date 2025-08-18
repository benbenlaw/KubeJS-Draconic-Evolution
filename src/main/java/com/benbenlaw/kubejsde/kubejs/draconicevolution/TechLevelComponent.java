package com.benbenlaw.kubejsde.kubejs.draconicevolution;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.init.TechProperties;
import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.type.TypeInfo;

public class TechLevelComponent implements RecipeComponent<TechLevel> {

    public static final TechLevelComponent INSTANCE = new TechLevelComponent();

    private TechLevelComponent(){}

    public Codec<TechLevel> codec() {
        return TechLevel.CODEC;
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(TechLevel.class);
    }
}
