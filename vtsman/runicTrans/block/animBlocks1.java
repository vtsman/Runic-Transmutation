package vtsman.runicTrans.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import vtsman.runicTrans.packetHandler;
import vtsman.runicTrans.TE.colorable;
import vtsman.runicTrans.client.clientProxy;
import vtsman.runicTrans.items.modItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class animBlocks1 extends Block implements ICloud{

        public animBlocks1(int i)
        {
        super(i, Material.rock);
        }
        
        @Override
        public boolean renderAsNormalBlock()
    {
        return false;
    }
        public boolean hasTileEntity(int metadata) {
    		return true;
    	}
        @Override
    	public TileEntity createTileEntity(World world, int meta) {
    		return new colorable();
    	}
        public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
        {
        	par3List.add(new ItemStack(par1, 1, 0));
        	par3List.add(new ItemStack(par1, 1, 1));
        	par3List.add(new ItemStack(par1, 1, 2));
        	par3List.add(new ItemStack(par1, 1, 3));
        	par3List.add(new ItemStack(par1, 1, 4));
        	par3List.add(new ItemStack(par1, 1, 5));
        	par3List.add(new ItemStack(par1, 1, 6));
        	par3List.add(new ItemStack(par1, 1, 7));
        }
        @SideOnly(Side.CLIENT)
    	public int getBlockColor() {
        	return 0xFF0000;
        }
        @Override
        public int getRenderType()
    {
        return clientProxy.twoRenderPass;
    }
        public void registerIcons(IconRegister ir) {
    		this.blockIcon = ir.registerIcon("runetrans:pulsecloud");
    	} 
        @Override
        public boolean isOpaqueCube()
    {
        return false;
    }
        
        @Override
        public int getRenderBlockPass()
    {
                return 1;
    }
        
        @Override
        public boolean canRenderInPass(int pass)
    {
                //Set the static var in the client proxy
                clientProxy.renderPass = pass;
                //the block can render in both passes, so return true always
        return true;
    }
    	public void onBlockClicked(World world, int x, int y, int z,
    			EntityPlayer player) {
    		ItemStack i = player.getHeldItem();
    		colorable c = (colorable) world.getBlockTileEntity(x, y, z);
    		if (i != null) {
    			if (i.itemID == Item.dyePowder.itemID) {
    				if (i.getItemDamage() == 1)
    					c.sub("r", 0x08);
    				if (i.getItemDamage() == 2)
    					c.sub("g", 0x08);
    				if (i.getItemDamage() == 4) {
    					c.sub("b", 0x08);
    				}
    			}
    		}
    		packetHandler.sendPacket(world.getBlockTileEntity(x, y, z));
    		world.markBlockForRenderUpdate(x, y, z);
    	}

    	public boolean onBlockActivated(World world, int x, int y, int z,
    			EntityPlayer player, int par6, float par7, float par8, float par9) {
    		ItemStack i = player.getHeldItem();
    		colorable c = (colorable) world.getBlockTileEntity(x, y, z);
    		System.out.println(c.worldObj.isRemote);
    		if (i != null) {
    			if (i.itemID == Item.dyePowder.itemID) {
    				if (i.getItemDamage() == 1)
    					c.add("r", 0x08);
    				if (i.getItemDamage() == 2)
    					c.add("g", 0x08);
    				if (i.getItemDamage() == 4) {
    					c.add("b", 0x08);
    				}
    	    		packetHandler.sendPacket(world.getBlockTileEntity(x, y, z));
    				world.markBlockForRenderUpdate(x, y, z);
    			}
    		}
    		return false;
    	}
		@Override
		public int[] getColor(int meta, IBlockAccess access, int x, int y, int z) {
			int[] color = new int[3];
			colorable c = (colorable)access.getBlockTileEntity(x, y, z);
			if(c != null){
			color[0] = c.r;
			color[1] = c.g;
			color[2] = c.b;
			}
			return color;
		}
		public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
	    {
	        return true;
	    }
        
}