package insane96mcp.pathtodirt.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemToolShovel;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemToolShovel.class, remap = false)
public class ItemToolShovelMixin {
	@Inject(method = "onUseItemOnBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;getBlockId(III)I", ordinal = 1, shift = At.Shift.AFTER), cancellable = true)
	public void pathtodirt_onUseItemOnBlock(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced, CallbackInfoReturnable<Boolean> cir) {
		int currBlockId = world.getBlockId(x, y, z);
		if ((currBlockId == Block.pathDirt.id || currBlockId == Block.farmlandDirt.id)) {
			world.setBlockWithNotify(x, y, z, Block.pathDirt.id);
			world.playBlockSoundEffect(player, x + 0.5d, y + 0.5d, z + 0.5F, Block.blocksList[currBlockId], EnumBlockSoundEffectType.PLACE);
			if (!world.isClientSide) {
				world.setBlockWithNotify(x, y, z, Block.dirt.id);
				player.getHeldItem().damageItem(1, player);
			}
			cir.setReturnValue(true);
		}
	}
}
