package vtsman.runicTrans.client.models;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class renderChargeItem implements IItemRenderer {

	private chargeNode Model;

	public renderChargeItem() {

		Model = new chargeNode();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(
				new vtsman.runicTrans.TE.chargeNode(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}