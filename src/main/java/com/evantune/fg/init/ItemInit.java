package com.evantune.fg.init;

import com.evantune.fg.FutureGate;
import com.evantune.fg.objects.items.SpecialItem;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, FutureGate.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE_SWORD  = ITEMS.register("example_sword", () -> new SwordItem(ModItemTier.EXAMPLE, 7, 5.0f, new Item.Properties().group(FutureGate.FGItemGroup.instance)));
    public static final RegistryObject<Item> EXAMPLE_PICKAXE  = ITEMS.register("example_pickaxe", () -> new PickaxeItem(ModItemTier.EXAMPLE, 4, 5.0f, new Item.Properties().group(FutureGate.FGItemGroup.instance)));
    public static final RegistryObject<Item> EXAMPLE_RUBY = ITEMS.register("example_ruby", () -> new Item(new Item.Properties().group(FutureGate.FGItemGroup.instance).food(new Food.Builder().hunger(3).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));

    public static final RegistryObject<Item> SPECIAL_ITEM = ITEMS.register("special_item", () -> new SpecialItem(new Item.Properties().group(FutureGate.FGItemGroup.instance)));

    public enum ModItemTier implements IItemTier {
        EXAMPLE(4, 1500, 15.0f, 7.0f, 250, () -> {
            return Ingredient.fromItems(ItemInit.EXAMPLE_RUBY.get());
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }

}
