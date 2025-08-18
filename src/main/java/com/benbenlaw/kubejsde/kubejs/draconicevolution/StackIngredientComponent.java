package com.benbenlaw.kubejsde.kubejs.draconicevolution;

import com.brandon3055.draconicevolution.api.crafting.IFusionRecipe;
import com.brandon3055.draconicevolution.api.crafting.StackIngredient;
import com.mojang.serialization.Codec;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.rhino.type.TypeInfo;

public class StackIngredientComponent implements RecipeComponent<StackIngredient> {

    public static final StackIngredientComponent INSTANCE = new StackIngredientComponent();

    private StackIngredientComponent() {
    }

    @Override
    public Codec<StackIngredient> codec() {
        return StackIngredient.CODEC.codec();
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(StackIngredient.class);
    }


}
