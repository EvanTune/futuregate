package com.evantune.fg.tileentity;

import com.evantune.fg.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

    public int x,y,z,tick;
    boolean initialized = false;

    public QuarryTileEntity(final TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public QuarryTileEntity() {
        this(ModTileEntityTypes.quarry.get());
    }

    @Override
    public void tick() {
        if (!initialized) {
            init();
        }
        tick++;
        if (tick == 40) {
            tick = 0;
            if (y > 2) {
                execute();
            }
        }
    }

    private void init() {

    }

    private void execute() {
        int index = 0;
        Block[] blocksRemoved = new Block[9];
    }
    
    
}
