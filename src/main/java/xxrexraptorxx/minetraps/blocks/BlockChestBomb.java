package xxrexraptorxx.minetraps.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;


public class BlockChestBomb extends Block {

	protected static final VoxelShape CUSTOM_SHAPE = Block.box(	1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);


	public BlockChestBomb() {
		super(Properties.of(Material.WOOD)
				.requiresCorrectToolForDrops()
				.strength(2.5F, 0.0F)
				.sound(SoundType.WOOD)
				.color(MaterialColor.WOOD)
		);
	}


	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return CUSTOM_SHAPE;
	}


	@Override
	public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
		AreaEffectCloud dummy = new AreaEffectCloud(level, pos.getX(), pos.getY(), pos.getZ());
		level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);

		if(!level.isClientSide) {
			level.explode(dummy, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true, Explosion.BlockInteraction.BREAK);
		}	}


	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		AreaEffectCloud dummy = new AreaEffectCloud(level, pos.getX(), pos.getY(), pos.getZ());
		level.playSound((Player) null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.STONE_BUTTON_CLICK_ON, SoundSource.BLOCKS, 1.0F, 3);
		level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);

		if(!level.isClientSide) {
			level.explode(dummy, pos.getX(), pos.getY(), pos.getZ(), 3.0F, true, Explosion.BlockInteraction.BREAK);
		}

		return InteractionResult.SUCCESS;
	}


	//Facing

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.FACING);
	}


	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(BlockStateProperties.FACING, context.getHorizontalDirection().getOpposite());
	}
}