package xxrexraptorxx.minetraps.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fluids.FluidAttributes;
import xxrexraptorxx.minetraps.main.ModItems;
import xxrexraptorxx.minetraps.main.References;

import javax.annotation.Nonnull;


public class FluidToxin extends Fluid {

    public FluidToxin() {
        super();
    }

    @Override
    public int getAmount(@Nonnull FluidState fluidState) {
        return 0;
    }

    @Nonnull
    @Override
    public Item getBucket() {
        return ModItems.NAILS.get();
    }

    @Override
    public float getHeight(@Nonnull FluidState fluidState, @Nonnull BlockGetter blockReader, @Nonnull BlockPos blockPos) {
        return 0;
    }

    @Override
    public float getOwnHeight(@Nonnull FluidState fluidState) {
        return 0;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(@Nonnull FluidState fluidState, @Nonnull BlockGetter blockReader, @Nonnull BlockPos blockPos) {
        return Shapes.block();
    }

    @Override
    public int getTickDelay(@Nonnull LevelReader worldReader) {
        return 5;
    }

    @Override
    public boolean isSource(@Nonnull FluidState state) {
        return false;
    }

    @Override
    protected boolean canBeReplacedWith(@Nonnull FluidState fluidState, @Nonnull BlockGetter blockReader, @Nonnull BlockPos blockPos, @Nonnull Fluid fluid, @Nonnull Direction direction) {
        return false;
    }

    @Nonnull
    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(new ResourceLocation(References.MODID, "block/toxin_still"), new ResourceLocation(References.MODID, "block/toxin_flow")).translationKey("fluid.minetraps.toxin").color(0x1db000).density(1300).temperature(309).viscosity(15000).rarity(Rarity.UNCOMMON).build(this);
    }

    @Nonnull
    @Override
    protected BlockState createLegacyBlock(@Nonnull FluidState state) {
        return Blocks.AIR.defaultBlockState();
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Nonnull
    @Override
    protected Vec3 getFlow(@Nonnull BlockGetter blockReader, @Nonnull BlockPos blockPos, @Nonnull FluidState fluidState) {
        return Vec3.ZERO;
    }
}