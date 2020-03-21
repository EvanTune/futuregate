package com.evantune.fg;

import com.evantune.fg.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("fg")
public class FutureGate {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "fg";

    public FutureGate() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static class FGItemGroup extends ItemGroup {

        public static final FGItemGroup instance = new FGItemGroup(ItemGroup.GROUPS.length, "fgtab");

        private FGItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
           return new ItemStack(BlockInit.example_block);
        }
    }

}
