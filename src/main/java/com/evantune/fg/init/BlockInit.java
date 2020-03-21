package com.evantune.fg.init;

import com.evantune.fg.FutureGate;

import com.evantune.fg.objects.blocks.SpecialBlock;
import com.evantune.fg.objects.items.BlockQuarry;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FutureGate.MOD_ID)
@Mod.EventBusSubscriber(modid = FutureGate.MOD_ID, bus = Bus.MOD)
public class BlockInit {

    public static final Block example_block = null;
    public static final Block special_block = null;
    public static final Block quarry = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(0.7f, 15f).sound(SoundType.GLASS)).setRegistryName("example_block"));
        event.getRegistry().register(new SpecialBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).lightValue(4).slipperiness(1.2f).speedFactor(0.7f).noDrops()).setRegistryName("special_block"));
        event.getRegistry().register(new BlockQuarry(Block.Properties.create(Material.IRON)).setRegistryName("quarry"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(3).group(ItemGroup.BREWING)).setRegistryName("example_block"));
        event.getRegistry().register(new BlockItem(special_block, new Item.Properties().group(FutureGate.FGItemGroup.instance)).setRegistryName("special_block"));
        //event.getRegistry().register(new BlockItem(quarry, new Item.Properties().group(FutureGate.FGItemGroup.instance)).setRegistryName("quarry"));
    }


}
