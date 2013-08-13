package vtsman.runicTrans.client;

import vtsman.runicTrans.commonProxy;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.client.models.renderChargeItem;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class clientProxy extends commonProxy {
	public static int renderPass;
	public static int twoRenderPass;
	public static boolean itemPass;
	@Override
    public void registerTEs()
    {
        super.registerTEs();
    }
	@Override
	public void registerRenderInformation() {
		twoRenderPass = RenderingRegistry.getNextAvailableRenderId();
		System.out.println(twoRenderPass);
        RenderingRegistry.registerBlockHandler(new TwoLayerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(
				vtsman.runicTrans.TE.chargeNode.class,
				new vtsman.runicTrans.client.models.renderChargeTE());
		ClientRegistry.bindTileEntitySpecialRenderer(
				vtsman.runicTrans.TE.transRuneTE.class,
				new vtsman.runicTrans.client.models.renderRune());
		ClientRegistry.bindTileEntitySpecialRenderer(
				vtsman.runicTrans.TE.findRune.class,
				new vtsman.runicTrans.client.models.smallTE());
		MinecraftForgeClient.registerItemRenderer(modBlocks.chargeNode.blockID,
				new renderChargeItem());
		//MinecraftForgeClient.registerItemRenderer(modBlocks.texBlock.blockID,
		//		new renderChargeItem());

	}

}