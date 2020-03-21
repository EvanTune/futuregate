package com.evantune.fg.tileentity;

import com.evantune.fg.init.ModTileEntityTypes;
import com.evantune.fg.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

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
        initialized = true;
        x = this.pos.getX() - 1;
        y = this.pos.getY() - 1;
        z = this.pos.getZ() - 1;
        tick = 0;
    }

    private void execute() {
        int index = 0;
        Block[] blocksRemoved = new Block[25];

        for (int x = 0; x < 5; x++) {
            for (int z = 0; z < 5; z++) {
                BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
                blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
                destroyBlock(posToBreak, true, null);
                index++;
            }
        }
        this.y--;

    }

    private boolean destroyBlock(BlockPos pos, boolean dropBlock, Entity entity) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.isAir(world, pos)) {
            return false;
        } else {
            IFluidState iFluidState = world.getFluidState(pos);
            world.playEvent(2001, pos, Block.getStateId(blockState));
            if (dropBlock) {
                TileEntity tileEntity = blockState.hasTileEntity() ? world.getTileEntity(pos) : null;
                Block.spawnDrops(blockState, world, this.pos.add(0,1.5,0), tileEntity, entity, ItemStack.EMPTY);

            }
            return world.setBlockState(pos, iFluidState.getBlockState(), 3);
        }

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initValues = compound.getCompound("initvalues");
        if (initValues != null) {
            this.x = initValues.getInt("x");
            this.y = initValues.getInt("y");
            this.z = initValues.getInt("z");
            this.tick = 0;
            initialized = true;
            return;
        }
        init();
    }
}
