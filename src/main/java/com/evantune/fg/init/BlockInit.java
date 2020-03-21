package com.evantune.fg.init;

import com.evantune.fg.FutureGate;

import com.evantune.fg.objects.blocks.SpecialBlock;
import com.evantune.fg.objects.items.BlockQuarry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, FutureGate.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK  = BLOCKS.register("example_block", () -> new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(0.7f, 15f).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> SPECIAL_BLOCK  = BLOCKS.register("special_block", () -> new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).lightValue(4).slipperiness(1.2f).speedFactor(0.7f).noDrops()));
    public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", () -> new BlockQuarry(Block.Properties.create(Material.IRON)));

}
