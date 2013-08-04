package vtsman.runicTrans.client.models;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class smallTE extends TileEntitySpecialRenderer {
	int rotation = 0;
	boolean coolDown;
	public void renderTileEntityAt(TileEntity tile, double d, double d1,
			double d2, float f) {

		
		int meta = 0;
		if (tile.worldObj != null) {
			meta = tile.getBlockMetadata();
		}
		coolDown = !coolDown;
		if(coolDown)
		rotation++;
		if(rotation == 360)rotation = 0;
		// bindTextureByName("/vtsman/mine_modus/client/models/Node Table.png");
		this.func_110628_a(new ResourceLocation("runetrans",
				"textures/models/smallRune.png")); // texture
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
		new smallRune().renderAll();
		GL11.glPopMatrix(); // end
	}

}