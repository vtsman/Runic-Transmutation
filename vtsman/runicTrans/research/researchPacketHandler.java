package vtsman.runicTrans.research;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class researchPacketHandler {

	public static void sendPacket(EntityPlayer p) {
		NBTTagCompound tag = new NBTTagCompound();
		boolean[] bool = researchFileHelper.getResearch(p);
		for (int i = 0; i < researchManager.getLength(); i++) {
			tag.setBoolean(Integer.toString(i), bool[i]);
		}
		byte[] out = null;

		try {
			out = CompressedStreamTools.compress(tag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream(out.length);
		DataOutputStream outputStream = new DataOutputStream(bos);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "RuneAlchem RE";
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
			if (p != null) {
				PacketDispatcher.sendPacketToPlayer(packet, (Player) p);
			}
		}
	}

	public static void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(
				packet.data));
		World world = ((EntityPlayer) player).worldObj;
		if (packet.channel == "RuneAlchem RE") {
			NBTTagCompound tag = null;
			short length;
			try {
				length = data.readShort();
				byte[] compressed = new byte[length];
				data.readFully(compressed);
				tag = CompressedStreamTools.decompress(compressed);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean[] bool = new boolean[researchManager.getLength()];
			if (tag != null) {
				for (int i = 0; i < researchManager.getLength(); i++) {
					if (tag.hasKey(Integer.toString(i))) {
						bool[i] = tag.getBoolean(Integer.toString(i));
					}
				}
				researchManager.playerResearches.put((EntityPlayer) player,
						bool);
			}
		}
	}

}
