package com.evantune.fg.events;

import com.evantune.fg.FutureGate;
import com.evantune.fg.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FutureGate.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvent {

    @SubscribeEvent
    public static void testJumpEvent(LivingEvent.LivingJumpEvent event) {
        FutureGate.LOGGER.info("Entity jumped test");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        world.setBlockState(livingEntity.getPosition().add(0,5,0), BlockInit.EXAMPLE_BLOCK.get().getDefaultState());
        livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 600, 255));
        livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5000, 255));
        livingEntity.setGlowing(true);
    }

}
