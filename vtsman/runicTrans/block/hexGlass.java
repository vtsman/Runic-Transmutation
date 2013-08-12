package vtsman.runicTrans.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.UP;

import java.util.HashMap;
import java.util.List;

import vtsman.runicTrans.TE.colorable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockPoweredOre;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class hexGlass extends BlockBreakable {
	int iColor = 0xFFFFFF;
	int color = 25500;
	HashMap<String, Icon> icons = new HashMap<String, Icon>();

	public hexGlass(int par1, Material par2Material) {
		super(par1, "idk", par2Material, false);

		// TODO Auto-generated constructor stub
	}
	public Icon getIcon(int par1, int par2)
    {
		if(par2 == 1)
			return this.icons.get("fnnnn");
        return this.icons.get("nnnn");
    }
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
    }
	public int getRenderBlockPass()
    {
        return 1;
    }
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z,
			int side) {
		// int tex = 0;
		// boolean[] b = new boolean[]{true, true, false, true, true, false,
		// false, false, false};
		int bid = world.getBlockId(x, y, z);
		boolean[] b = new boolean[9];
		int meta = world.getBlockMetadata(x, y, z);
		boolean[] sides = new boolean[4];
		boolean[] corner = new boolean[4];
		if (side == 0) {
			sides[0] = world.getBlockId(x - 1, y, z) == bid && world.getBlockMetadata(x - 1, y, z) == meta;
			sides[1] = world.getBlockId(x, y, z - 1) == bid && world.getBlockMetadata(x, y, z - 1) == meta;
			sides[2] = world.getBlockId(x + 1, y, z) == bid && world.getBlockMetadata(x + 1, y, z) == meta;
			sides[3] = world.getBlockId(x, y, z + 1) == bid && world.getBlockMetadata(x, y, z + 1) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x - 1, y, z - 1) == bid && world.getBlockMetadata(x - 1, y, z - 1) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x + 1, y, z - 1) == bid && world.getBlockMetadata(x + 1, y, z - 1) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x + 1, y, z + 1) == bid && world.getBlockMetadata(x + 1, y, z + 1) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x - 1, y, z + 1) == bid && world.getBlockMetadata(x - 1, y, z + 1) == meta;
		}
		if (side == 1) {
			sides[0] = world.getBlockId(x - 1, y, z) == bid && world.getBlockMetadata(x - 1, y, z) == meta;
			sides[1] = world.getBlockId(x, y, z - 1) == bid && world.getBlockMetadata(x, y, z - 1) == meta;
			sides[2] = world.getBlockId(x + 1, y, z) == bid && world.getBlockMetadata(x + 1, y, z) == meta;
			sides[3] = world.getBlockId(x, y, z + 1) == bid && world.getBlockMetadata(x, y, z + 1) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x - 1, y, z - 1) == bid && world.getBlockMetadata(x - 1, y, z - 1) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x + 1, y, z - 1) == bid && world.getBlockMetadata(x + 1, y, z - 1) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x + 1, y, z + 1) == bid && world.getBlockMetadata(x + 1, y, z + 1) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x - 1, y, z + 1) == bid && world.getBlockMetadata(x - 1, y, z + 1) == meta;
		}
		if (side == 2) {
			sides[0] = world.getBlockId(x + 1, y, z) == bid && world.getBlockMetadata(x + 1, y, z) == meta;
			sides[1] = world.getBlockId(x, y + 1, z) == bid && world.getBlockMetadata(x, y + 1, z) == meta;
			sides[2] = world.getBlockId(x - 1, y, z) == bid && world.getBlockMetadata(x - 1, y, z) == meta;
			sides[3] = world.getBlockId(x, y - 1, z) == bid && world.getBlockMetadata(x, y - 1, z) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x + 1, y + 1, z) == bid && world.getBlockMetadata(x + 1, y + 1, z) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x - 1, y + 1, z) == bid && world.getBlockMetadata(x - 1, y + 1, z) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x - 1, y - 1, z) == bid && world.getBlockMetadata(x - 1, y - 1, z) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x + 1, y - 1, z) == bid && world.getBlockMetadata(x + 1, y - 1, z) == meta;
		}
		if (side == 3) {
			sides[0] = world.getBlockId(x - 1, y, z) == bid && world.getBlockMetadata(x - 1, y, z) == meta;
			sides[1] = world.getBlockId(x, y + 1, z) == bid && world.getBlockMetadata(x, y + 1, z) == meta;
			sides[2] = world.getBlockId(x + 1, y, z) == bid && world.getBlockMetadata(x + 1, y, z) == meta;
			sides[3] = world.getBlockId(x, y - 1, z) == bid && world.getBlockMetadata(x, y - 1, z) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x - 1, y + 1, z) == bid && world.getBlockMetadata(x - 1, y + 1, z) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x + 1, y + 1, z) == bid && world.getBlockMetadata(x + 1, y + 1, z) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x + 1, y - 1, z) == bid && world.getBlockMetadata(x + 1, y - 1, z) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x - 1, y - 1, z) == bid && world.getBlockMetadata(x - 1, y - 1, z) == meta;
		}
		if (side == 4) {
			sides[0] = world.getBlockId(x, y, z - 1) == bid && world.getBlockMetadata(x, y, z - 1) == meta;
			sides[1] = world.getBlockId(x, y + 1, z) == bid && world.getBlockMetadata(x, y + 1, z) == meta;
			sides[2] = world.getBlockId(x, y, z + 1) == bid && world.getBlockMetadata(x, y, z + 1) == meta;
			sides[3] = world.getBlockId(x, y - 1, z) == bid && world.getBlockMetadata(x, y - 1, z) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x, y + 1, z - 1) == bid && world.getBlockMetadata(x, y + 1, z - 1) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x, y + 1, z + 1) == bid && world.getBlockMetadata(x, y + 1, z + 1) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x, y - 1, z + 1) == bid && world.getBlockMetadata(x, y - 1, z + 1) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x, y - 1, z - 1) == bid && world.getBlockMetadata(x, y - 1, z - 1) == meta;
		}
		if (side == 5) {
			sides[0] = world.getBlockId(x, y, z + 1) == bid && world.getBlockMetadata(x, y, z + 1) == meta;
			sides[1] = world.getBlockId(x, y + 1, z) == bid && world.getBlockMetadata(x, y + 1, z) == meta;
			sides[2] = world.getBlockId(x, y, z - 1) == bid && world.getBlockMetadata(x, y, z - 1) == meta;
			sides[3] = world.getBlockId(x, y - 1, z) == bid && world.getBlockMetadata(x, y - 1, z) == meta;
			corner[0] = sides[0] && sides[1]
					&& world.getBlockId(x, y + 1, z + 1) == bid && world.getBlockMetadata(x, y + 1, z + 1) == meta;
			corner[1] = sides[1] && sides[2]
					&& world.getBlockId(x, y + 1, z - 1) == bid && world.getBlockMetadata(x, y + 1, z - 1) == meta;
			corner[2] = sides[2] && sides[3]
					&& world.getBlockId(x, y - 1, z - 1) == bid && world.getBlockMetadata(x, y - 1, z - 1) == meta;
			corner[3] = sides[3] && sides[0]
					&& world.getBlockId(x, y - 1, z + 1) == bid && world.getBlockMetadata(x, y - 1, z + 1) == meta;
		}
		String texture = "";
		if(world.getBlockMetadata(x, y, z) == 1)
			texture = texture + "f";
		for (int i = 0; i < 4; i++) {
			if (sides[i])
				texture = texture + "s";
			else
				texture = texture + "n";
			if (corner[i])
				texture = texture + "c";
		}
		/*
		 * System.out.println(side); for(int i = 0; i < 9; i++){
		 * System.out.print(b[i]); System.out.println(); }
		 * System.out.println(texture);
		 */
		return icons.get(texture);
	}

	public void onBlockClicked(World world, int x, int y, int z,
			EntityPlayer player) {
		int id = world.getBlockId(x, y, z);
		if(id == modBlocks.hex.blockID){
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
		world.markBlockForRenderUpdate(x, y, z);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9) {
		int id = world.getBlockId(x, y, z);
		if(id == modBlocks.hex.blockID){
		ItemStack i = player.getHeldItem();
		colorable c = (colorable) world.getBlockTileEntity(x, y, z);
		if (i != null) {
			if (i.itemID == Item.dyePowder.itemID) {
				if (i.getItemDamage() == 1)
					c.add("r", 0x08);
				if (i.getItemDamage() == 2)
					c.add("g", 0x08);
				if (i.getItemDamage() == 4) {
					c.add("b", 0x08);
				}
				world.markBlockForRenderUpdate(x, y, z);
			}
		}
		}
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean hasTileEntity(int metadata) {
		return true;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		return iColor;
	}

	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon("runetrans:nnnn");
		addI(ir, "nnnn");
		addI(ir, "nnns");
		addI(ir, "nnscs");
		addI(ir, "nnsn");
		addI(ir, "nnss");
		addI(ir, "nscscs");
		addI(ir, "nscsn");
		addI(ir, "nscss");
		addI(ir, "nsnn");
		addI(ir, "nsns");
		addI(ir, "nsscs");
		addI(ir, "nssn");
		addI(ir, "nsss");
		addI(ir, "scscscs");
		addI(ir, "scscscsc");
		addI(ir, "scscsn");
		addI(ir, "scscss");
		addI(ir, "scscssc");
		addI(ir, "scsnn");
		addI(ir, "scsns");
		addI(ir, "scsnsc");
		addI(ir, "scsscsc");
		addI(ir, "scssn");
		addI(ir, "scsss");
		addI(ir, "scsssc");
		addI(ir, "snnn");
		addI(ir, "snns");
		addI(ir, "snnsc");
		addI(ir, "snscs");
		addI(ir, "snscsc");
		addI(ir, "snsn");
		addI(ir, "snss");
		addI(ir, "snssc");
		addI(ir, "sscscs");
		addI(ir, "sscscsc");
		addI(ir, "sscsn");
		addI(ir, "sscss");
		addI(ir, "ssnn");
		addI(ir, "ssns");
		addI(ir, "ssnsc");
		addI(ir, "ssscs");
		addI(ir, "sssn");
		addI(ir, "ssss");
		addI(ir, "ssssc");
		addI(ir, "nnnn");
		addI(ir, "ssscsc");
		
		addI(ir, "fnnnn");
		addI(ir, "fnnns");
		addI(ir, "fnnscs");
		addI(ir, "fnnsn");
		addI(ir, "fnnss");
		addI(ir, "fnscscs");
		addI(ir, "fnscsn");
		addI(ir, "fnscss");
		addI(ir, "fnsnn");
		addI(ir, "fnsns");
		addI(ir, "fnsscs");
		addI(ir, "fnssn");
		addI(ir, "fnsss");
		addI(ir, "fscscscs");
		addI(ir, "fscscscsc");
		addI(ir, "fscscsn");
		addI(ir, "fscscss");
		addI(ir, "fscscssc");
		addI(ir, "fscsnn");
		addI(ir, "fscsns");
		addI(ir, "fscsnsc");
		addI(ir, "fscsscsc");
		addI(ir, "fscssn");
		addI(ir, "fscsss");
		addI(ir, "fscsssc");
		addI(ir, "fsnnn");
		addI(ir, "fsnns");
		addI(ir, "fsnnsc");
		addI(ir, "fsnscs");
		addI(ir, "fsnscsc");
		addI(ir, "fsnsn");
		addI(ir, "fsnss");
		addI(ir, "fsnssc");
		addI(ir, "fsscscs");
		addI(ir, "fsscscsc");
		addI(ir, "fsscsn");
		addI(ir, "fsscss");
		addI(ir, "fssnn");
		addI(ir, "fssns");
		addI(ir, "fssnsc");
		addI(ir, "fssscs");
		addI(ir, "fsssn");
		addI(ir, "fssss");
		addI(ir, "fssssc");
		addI(ir, "fnnnn");
		addI(ir, "fssscsc");
	}

	public void addI(IconRegister ir, String s) {
		this.icons.put(s, ir.registerIcon("runetrans:" + s));
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	public int getRenderColor(int par1) {
		return iColor;
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new colorable();
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */
	public int colorMultiplier(IBlockAccess access, int x, int y, int z) {
		if(access.getBlockTileEntity(x, y, z) != null){
		colorable c = (colorable) access.getBlockTileEntity(x, y, z);
		return c.color;
		}
		return 0x000000;
	}
	 public int damageDropped(int par1)
	    {
	        return par1;
	    }
	 public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side)
	    {
	        return true;
	    }
}
