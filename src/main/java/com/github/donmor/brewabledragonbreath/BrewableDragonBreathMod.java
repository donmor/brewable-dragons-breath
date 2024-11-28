package com.github.donmor.brewabledragonbreath;

import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

import com.github.donmor.brewabledragonbreath.BrewableDragonBreathMod;

@Mod(BrewableDragonBreathMod.MOD_ID)
public final class BrewableDragonBreathMod {
    public static final String MOD_ID = "brewable_dragons_breath";

    public BrewableDragonBreathMod() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like registries and resources) may still be uninitialized.
        // Proceed with mild caution.

        class DragonBreathBrewingRecipe implements IBrewingRecipe {

            @Override
            public boolean isInput(@Nonnull ItemStack input) {
                return (input.getItem() == Items.POTION || input.getItem() == Items.SPLASH_POTION
                        || input.getItem() == Items.LINGERING_POTION) && PotionUtils.getPotion(input) == Potions.THICK;
            }

            @Override
            public boolean isIngredient(@Nonnull ItemStack ingredient) {
                return ingredient.getItem() == Items.CHORUS_FRUIT;
            }

            @Override
            public ItemStack getOutput(@Nonnull ItemStack input, @Nonnull ItemStack ingredient) {
                return isInput(input) && isIngredient(ingredient) ? new ItemStack(Items.DRAGON_BREATH) : ItemStack.EMPTY;
            }
        }
        BrewingRecipeRegistry.addRecipe(new DragonBreathBrewingRecipe());
    }
}
