package vtsman.runicTrans.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class researchGui extends GuiContainer {
	public researchGui(InventoryPlayer inventoryPlayer, TileEntity tileEntity) {
		// the container is instanciated and passed to the superclass for
		// handling
		super(new researchContainer(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		// draw text and stuff here
		// the parameters for drawString are: string, x, y, color
		// not a problem
		fontRenderer.drawString("Research pedestal", 8, 4, 0xFFFFFF);
		// draws "Inventory" or your regional equivalent
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 96, 0xFFFFFF);
	}

	double angle = 0;

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		angle += 1;
		// draw your Gui here, only thing you need to change is the path
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(
				new ResourceLocation("runetrans", "textures/gui/research.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		// double r = Math.pow(Math.pow(100, 2) + Math.pow(32, 2), 1d / 2d);
		// double a2 = Math.toRadians(angle);
		double xOff = x + 112;
		double yOff = y + 44;

		GL11.glTranslated(xOff, yOff, 0);
		GL11.glRotated(angle, 0, 0, 1);
		GL11.glColor4f(1.0F, 1.0F, 0.0F, 1.0F);
		this.drawTexturedModalRect(-12, -12, xSize, 0, 24, 24);
		GL11.glRotated(-angle, 0, 0, 1);
		GL11.glTranslated(-xOff, -yOff, 0);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}
