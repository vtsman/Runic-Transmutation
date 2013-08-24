package vtsman.runicTrans.client;

import vtsman.runicTrans.block.ICloud;
import vtsman.runicTrans.block.modBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class TwoLayerRenderer implements ISimpleBlockRenderingHandler{
int id;
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		int id = block.blockID;
		int meta = metadata;
                //we are on the solid block render pass, lets render the solid diamond block
				renderer.renderBlockAsItem(modBlocks.pulse, 0, 1f);
                //we are on the alpha render pass, draw the ice around the diamond
				if((id == modBlocks.animBlock.blockID  || id == modBlocks.lumin.blockID) && meta == 0){
            	renderer.renderBlockAsItem(modBlocks.hex, 0, 1f);
            }
            else if((id == modBlocks.animBlock.blockID  || id == modBlocks.lumin.blockID) && meta == 5){
            	renderer.renderBlockAsItem(modBlocks.hex, 0, 1f);
            	renderer.renderBlockAsItem(modBlocks.texBlock, meta, 1f);
            }
            else{
        	renderer.renderBlockAsItem(modBlocks.texBlock, meta, 1f);
            }
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		//RenderBlocks.renderItemIn3d(1);
		int id = world.getBlockId(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		if(clientProxy.renderPass == 0)
        {
				ICloud color = (ICloud)Block.blocksList[world.getBlockId(x, y, z)];
				int[] colors = color.getColor(meta, world, x, y, z);
				float r = (float)colors[0] / 255f;
				float g = (float)colors[1] / 255f;
				float b = (float)colors[2] / 255f;
                //we are on the solid block render pass, lets render the solid diamond block
                this.renderStandardBlockWithColorMultiplier(renderer, modBlocks.pulse, x, y, z, r, g, b);
                //renderer.
			//	renderer.renderStandardBlock(modBlocks.pulse, x, y, z); 
        }
        else                    
        {
                //we are on the alpha render pass, draw the ice around the diamond
            if((id == modBlocks.animBlock.blockID  || id == modBlocks.lumin.blockID) && meta == 0){
            	renderer.renderStandardBlock(modBlocks.hex, x, y, z);
            }
            else if((id == modBlocks.animBlock.blockID  || id == modBlocks.lumin.blockID) && meta == 5){
            	renderer.renderStandardBlock(modBlocks.hex, x, y, z);
            	
            	renderer.renderBlockUsingTexture(modBlocks.texBlock, x, y, z, modBlocks.texBlock.getIcon(0, 5));
            }
            else{
        	renderer.renderBlockUsingTexture(modBlocks.texBlock, x, y, z, modBlocks.texBlock.getIcon(0, world.getBlockMetadata(x, y, z)));
            }
            }
        
        return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return clientProxy.twoRenderPass;
	}
	public boolean renderStandardBlockWithColorMultiplier(RenderBlocks r, Block par1Block, int x, int y, int z, float par5, float par6, float par7)
    {
        r.enableAO = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * par5;
        float f8 = f4 * par6;
        float f9 = f4 * par7;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;
        Icon icon;
        icon = modBlocks.pulse.getIcon(0, 0);
        if (par1Block != Block.grass)
        {
            f10 = f3 * par5;
            f11 = f5 * par5;
            f12 = f6 * par5;
            f13 = f3 * par6;
            f14 = f5 * par6;
            f15 = f6 * par6;
            f16 = f3 * par7;
            f17 = f5 * par7;
            f18 = f6 * par7;
        }

        int l = par1Block.getMixedBrightnessForBlock(r.blockAccess, x, y, z);

        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x, y - 1, z, 0))
        {
            tessellator.setBrightness(r.renderMinY > 0.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x, y - 1, z));
            tessellator.setColorRGBA_F(f10, f13, f16, 1f);
            r.renderFaceYNeg(par1Block, (double)x, (double)y, (double)z, icon);
            flag = true;
        }

        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x, y + 1, z, 1))
        {
            tessellator.setBrightness(r.renderMaxY < 1.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x, y + 1, z));
            tessellator.setColorRGBA_F(f7, f8, f9, 1f);
            r.renderFaceYPos(par1Block, (double)x, (double)y, (double)z, icon);
            flag = true;
        }

       
        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x, y, z - 1, 2))
        {
            tessellator.setBrightness(r.renderMinZ > 0.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x, y, z - 1));
            tessellator.setColorRGBA_F(f11, f14, f17, 1f);
            r.renderFaceZNeg(par1Block, (double)x, (double)y, (double)z, icon);

            if (r.fancyGrass && icon.getIconName().equals("grass_side") && !r.hasOverrideBlockTexture())
            {
                tessellator.setColorRGBA_F(f11 * par5, f14 * par6, f17 * par7, 1f);
                r.renderFaceZNeg(par1Block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
            }

            flag = true;
        }

        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x, y, z + 1, 3))
        {
            tessellator.setBrightness(r.renderMaxZ < 1.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x, y, z + 1));
            tessellator.setColorRGBA_F(f11, f14, f17, 1f);
            r.renderFaceZPos(par1Block, (double)x, (double)y, (double)z, icon);

            if (r.fancyGrass && icon.getIconName().equals("grass_side") && !r.hasOverrideBlockTexture())
            {
                tessellator.setColorRGBA_F(f11 * par5, f14 * par6, f17 * par7, 1f);
                r.renderFaceZPos(par1Block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
            }

            flag = true;
        }

        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x - 1, y, z, 4))
        {
            tessellator.setBrightness(r.renderMinX > 0.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x - 1, y, z));
            tessellator.setColorRGBA_F(f12, f15, f18, 1f);
            r.renderFaceXNeg(par1Block, (double)x, (double)y, (double)z, icon);

            if (r.fancyGrass && icon.getIconName().equals("grass_side") && !r.hasOverrideBlockTexture())
            {
                tessellator.setColorRGBA_F(f12 * par5, f15 * par6, f18 * par7, 1f);
                r.renderFaceXNeg(par1Block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
            }

            flag = true;
        }

        if (r.renderAllFaces || par1Block.shouldSideBeRendered(r.blockAccess, x + 1, y, z, 5))
        {
            tessellator.setBrightness(r.renderMaxX < 1.0D ? l : par1Block.getMixedBrightnessForBlock(r.blockAccess, x + 1, y, z));
            tessellator.setColorRGBA_F(f12, f15, f18, 1f);
            r.renderFaceXPos(par1Block, (double)x, (double)y, (double)z, icon);

            if (r.fancyGrass && icon.getIconName().equals("grass_side") && !r.hasOverrideBlockTexture())
            {
                tessellator.setColorRGBA_F(f12 * par5, f15 * par6, f18 * par7, 1f);
                r.renderFaceXPos(par1Block, (double)x, (double)y, (double)z, BlockGrass.getIconSideOverlay());
            }

            flag = true;
        }

        return flag;
    }
}
