package vtsman.runicTrans.client.particals;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class TestPartical extends EntityFX {

	protected TestPartical(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void renderParticle(Tessellator tess, float x, float y, float z,
			float xV, float yV, float zV) {
		// System.out.println("here");

	}
}
