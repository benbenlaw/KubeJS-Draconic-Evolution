package com.benbenlaw.kubejsde.kubejs.draconicevolution;

import com.brandon3055.draconicevolution.api.crafting.IFusionRecipe;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.latvian.mods.kubejs.recipe.KubeRecipe;
import dev.latvian.mods.kubejs.recipe.RecipeScriptContext;
import dev.latvian.mods.kubejs.recipe.component.IngredientComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentType;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentValue;
import dev.latvian.mods.rhino.Context;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class IFusionIngredientComponent implements RecipeComponent<IFusionRecipe.IFusionIngredient> {

    public static final IFusionIngredientComponent INSTANCE = new IFusionIngredientComponent();

    public static final RecipeComponentType<?> TYPE = RecipeComponentType.unit(ResourceLocation.fromNamespaceAndPath("kubejsde", "fusion_ingredient"), INSTANCE);

    public record SimpleFusionIngredient(Ingredient ingredient, boolean consume)
            implements IFusionRecipe.IFusionIngredient {
        @Override
        public Ingredient get() {
            return ingredient;
        }

        @Override
        public boolean consume() {
            return consume;
        }
    }


    @Override
    public RecipeComponentType<?> type() {
        return TYPE;
    }

    @Override
    public Codec<IFusionRecipe.IFusionIngredient> codec() {
        return RecordCodecBuilder.create(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(IFusionRecipe.IFusionIngredient::get),
                Codec.BOOL.fieldOf("consume").forGetter(IFusionRecipe.IFusionIngredient::consume)
        ).apply(instance, SimpleFusionIngredient::new));
    }

    @Override
    public TypeInfo typeInfo() {
        return TypeInfo.of(IFusionRecipe.IFusionIngredient.class);
    }

    @Override
    public void readFromJson(KubeRecipe recipe, RecipeComponentValue<IFusionRecipe.IFusionIngredient> cv, JsonObject json) {
        RecipeComponent.super.readFromJson(recipe, cv, json);
    }

    @Override
    public IFusionRecipe.IFusionIngredient wrap(RecipeScriptContext cx, Object from) {

        if (from instanceof List<?> list && list.size() >= 1) {
            String itemId = list.get(0).toString();
            boolean consume = list.size() > 1 && Boolean.parseBoolean(list.get(1).toString());
            Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemId));
            Ingredient ingredient = Ingredient.of(item);
            return new SimpleFusionIngredient(ingredient, consume);
        }

        if (from instanceof String str) {
            Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(str));
            return new SimpleFusionIngredient(Ingredient.of(item), true);
        }

        return RecipeComponent.super.wrap(cx, from);
    }
}