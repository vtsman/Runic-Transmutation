package vtsman.runicTrans.research;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class researchFileHelper {
	public static File getFileFromPlayer(EntityPlayer p) {
		if (!p.worldObj.isRemote) {
			String name = p.username;
			String folder = Minecraft.getMinecraft().getIntegratedServer()
					.getFolderName();
			File f = Minecraft.getMinecraft().getIntegratedServer().getFile("");
			String modFile = f.getPath().substring(0, f.getPath().length() - 1)
					.concat("saves/").concat(folder);
			File playerFile = new File(modFile.concat("/").concat(name)
					.concat(".rune"));
			System.out.println(playerFile.getPath());
			try {
				if (splitFile(playerFile).size() == 0) {
					setResearch(playerFile, -1, false);
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return playerFile;
		}
		System.out.println("D:");
		return null;
	}

	public static int findLine(File in, String filter) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			lines = splitFile(in);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int line = -1;
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).startsWith(filter)) {
				line = i;
				break;
			}
			// line =
		}
		return line;
	}

	public static boolean[] getResearch(EntityPlayer p) {
		return getResearch(getFileFromPlayer(p));
	}

	private static boolean[] getResearch(File f) {
		ArrayList<String> lines = null;
		try {
			lines = splitFile(f);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean[] research = new boolean[researchManager.getLength()];
		if (lines.size() == 0) {
			return research;
		}
		for (int i = 0; i < researchManager.getLength(); i++) {
			research[i] = lines.get(0).charAt(i) == '1';
		}
		return research;
	}

	public static void setResearch(EntityPlayer p, int index, boolean b) {
		setResearch(getFileFromPlayer(p), index, b);
	}

	private static void setResearch(File f, int index, boolean b) {
		boolean[] bool = new boolean[researchManager.getLength()];
		if (index != -1) {
			bool = getResearch(f);
			bool[index] = b;
		}
		PrintWriter writer = getWriter(f);
		for (int i = 0; i < bool.length; i++) {
			writer.print(b ? 1 : 0);
		}
		if (index != -1) {
			try {
				ArrayList<String> strings = splitFile(f);
				for (int i = 1; i < strings.size(); i++) {
					writer.println(strings.get(i));
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.close();

	}

	private static PrintWriter getWriter(File f) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(f, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
	}

	@SuppressWarnings("resource")
	private static ArrayList<String> splitFile(File in)
			throws URISyntaxException {
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new FileReader(in));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		ArrayList<String> rows = new ArrayList<String>();
		if (buf != null) {
			try {
				while ((line = buf.readLine()) != null) {
					String[] row = line.split("\t");
					rows.add(row[0]);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return rows;
	}

}
