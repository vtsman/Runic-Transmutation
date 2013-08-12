package vtsman.runicTrans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class packetHandler implements IPacketHandler{
	private static int maxDistance = 100;
	public static void sendPacket(TileEntity te){
		World world = te.worldObj;
		int x = te.xCoord;
		int y = te.yCoord;
		int z = te.zCoord;
		NBTTagCompound tag = new NBTTagCompound();
		if(!world.isRemote){
		byte[] out = null;
		te.writeToNBT(tag);
	
		try {
			out = CompressedStreamTools.compress(tag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 ByteArrayOutputStream bos = new ByteArrayOutputStream(out.length);
	 DataOutputStream outputStream = new DataOutputStream(bos);
		Packet250CustomPayload packet = new Packet250CustomPayload();
	    packet.channel = "RuneAlchem TE";
	    try {
			outputStream.writeShort(out.length);
			outputStream.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    packet.data = bos.toByteArray();
	    packet.length = bos.size();
	    if (packet != null) {
			for (int j = 0; j < world.playerEntities.size(); j++) {
				EntityPlayerMP player = null;//
				if(world.playerEntities.get(j) instanceof EntityPlayerMP){
				player = (EntityPlayerMP) world.playerEntities.get(j);
				}
				if(player != null){
				if (Math.abs(player.posX - x) <= maxDistance && Math.abs(player.posY - y) <= maxDistance && Math.abs(player.posZ - y) <= maxDistance) {
					PacketDispatcher.sendPacketToPlayer(packet, (Player) player);
					//player.playerNetServerHandler.sendPacketToPlayer(packet);
				}
				}
			}
		}
		}
	     // We are on the Bukkit server.
	}

	
	
	
	
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player){
	DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
	System.out.println("here");
	World world = ((EntityPlayer)player).worldObj;
	if(payload.channel == "RuneAlchem TE"){
		System.out.println("Packet Recieved");
	NBTTagCompound tag = null;
	short length;
	try {
		length = data.readShort();
		byte[] compressed = new byte[length];
		data.readFully(compressed);
		tag = CompressedStreamTools.decompress(compressed);
		System.out.println("Tag decompressed");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(tag != null){
	if(tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")){
		int x = tag.getInteger("x");
		int y = tag.getInteger("y");
		int z = tag.getInteger("z");
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te != null){
		te.readFromNBT(tag);
		}
	}
	}
	}
	}
}
