package vtsman.runicTrans.client.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class renderChargeTE extends TileEntitySpecialRenderer {
	public void renderTileEntityAt(TileEntity tile, double d, double d1,
			double d2, float f) {

		int rotation = 0;
		if (tile.worldObj != null) {
			rotation = tile.getBlockMetadata();
		}
		// bindTextureByName("/vtsman/mine_modus/client/models/Node Table.png");
		this.bindTexture(new ResourceLocation("runetrans",
				"textures/models/chargeNode.png")); // texture
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		new chargeNode().renderAll();
		GL11.glPopMatrix(); // end
	}

}
