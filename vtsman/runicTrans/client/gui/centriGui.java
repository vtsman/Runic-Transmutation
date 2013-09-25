package vtsman.runicTrans.client.gui;

import org.lwjgl.opengl.GL11;

import vtsman.runicTrans.TE.mortar;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class centriGui extends GuiContainer{
    public centriGui (InventoryPlayer inventoryPlayer,
    		IInventory tileEntity) {
    //the container is instanciated and passed to the superclass for handling
    super(new centriContainer(inventoryPlayer, tileEntity));
}
@Override
protected void drawGuiContainerForegroundLayer(int param1, int param2) {
    //draw text and stuff here
    //the parameters for drawString are: string, x, y, color
//not a problem
    fontRenderer.drawString("Arcane Centrifuge", 8, 6, 0x0000AF);
    //draws "Inventory" or your regional equivalent
    fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8
    		, ySize - 96 + 2, 0x0000AF);
}

@Override
protected void drawGuiContainerBackgroundLayer(float par1, int par2,
            int par3) {
    //draw your Gui here, only thing you need to change is the path
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.func_110434_K().func_110577_a(new ResourceLocation("runetrans",
			"textures/gui/cent.png"));
    int x = (width - xSize) / 2;
    int y = (height - ySize) / 2;
    this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
}


}
