package vtsman.runicTrans.client;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import vtsman.runicTrans.commonProxy;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.client.models.renderChargeItem;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class clientProxy extends commonProxy {
	public static int renderPass;
	public static int twoRenderPass;
	public static boolean itemPass;

	@Override
	public void registerTEs() {
		super.registerTEs();
	}

	@Override
	public void addVillager() {
		super.addVillager();
		VillagerRegistry.instance().registerVillagerSkin(
				villagerID,
				new ResourceLocation("runetrans",
						"textures/entity/villager.png"));
	}

	@Override
	public void registerRenderInformation() {
		twoRenderPass = RenderingRegistry.getNextAvailableRenderId();
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
		// MinecraftForgeClient.registerItemRenderer(modBlocks.texBlock.blockID,
		// new renderChargeItem());

	}

}