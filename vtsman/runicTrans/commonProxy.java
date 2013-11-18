package vtsman.runicTrans;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.centriTE;
import vtsman.runicTrans.TE.colorable;
import vtsman.runicTrans.TE.findRune;
import vtsman.runicTrans.TE.mortar;
import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.worldGen.tradeHandler;
import vtsman.runicTrans.worldGen.villageHouse;
import vtsman.runicTrans.worldGen.villagerHouse;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class commonProxy {
	public static int villagerID = 100;

	public void addVillager() {

		VillagerRegistry.instance().registerVillagerId(villagerID);
		VillagerRegistry.instance().registerVillageTradeHandler(villagerID,
				new tradeHandler());

		VillagerRegistry.instance().registerVillageCreationHandler(
				new villagerHouse());
		MapGenStructureIO.func_143031_a(villageHouse.class, "RuneTrans");

	}

	public void registerTEs() {
		System.out.println("Registering Tile Entities");
		GameRegistry.registerTileEntity(capacitorTE.class,
				"runeTrans.RunicCapacitor");
		GameRegistry.registerTileEntity(mortar.class, "runeTrans.morter");
		GameRegistry.registerTileEntity(colorable.class, "runeTrans.Colorable");
		GameRegistry.registerTileEntity(centriTE.class, "runeTrans.Centrifuge");
		GameRegistry.registerTileEntity(findRune.class,
				"runeTrans.enlightenedrune");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.chargeNode.class,
				"runeTrans.ChargeNode");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.relay.class,
				"runeTrans.relay");
		GameRegistry.registerTileEntity(transRuneTE.class,
				"runeTrans.TransmutationRune");
	}

	public void registerRenderInformation() {
	}
}