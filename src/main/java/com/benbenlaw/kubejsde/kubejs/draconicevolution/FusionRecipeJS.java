package com.benbenlaw.kubejsde.kubejs.draconicevolution;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.api.crafting.IFusionRecipe;
import com.brandon3055.draconicevolution.api.crafting.StackIngredient;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.ItemStackComponent;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public interface FusionRecipeJS {

    RecipeKey<Ingredient> CATALYST = IngredientComponent.NON_EMPTY_INGREDIENT.inputKey("catalyst");
    RecipeKey<List<IFusionRecipe.IFusionIngredient>> INPUTS = IFusionIngredientComponent.INSTANCE
            .asList()
            .inputKey("ingredients");
    RecipeKey<ItemStack> RESULT = ItemStackComponent.ITEM_STACK.outputKey("result");
    RecipeKey<TechLevel> TECH_LEVEL = TechLevelComponent.INSTANCE.inputKey("techLevel");
    RecipeKey<Integer> ENERGY = NumberComponent.INT.inputKey("totalEnergy");

    RecipeSchema SCHEMA = new RecipeSchema(
            CATALYST,
            INPUTS,
            RESULT,
            TECH_LEVEL,
            ENERGY
    );

}

