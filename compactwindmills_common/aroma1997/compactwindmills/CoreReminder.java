package aroma1997.compactwindmills;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.registry.GameRegistry;


public class CoreReminder implements IPlayerTracker {
	
	private static String modName;
	private static final String updateURL = "http://tinyurl.com/aroma1997";

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		
		if (!(net.minecraft.client.Minecraft.getMinecraft().thePlayer == null || net.minecraft.client.Minecraft.getMinecraft().thePlayer.username == null)) {
			if (!player.username.equals(net.minecraft.client.Minecraft.getMinecraft().thePlayer.username)) return;
		}
		if (!ModLoader.isModLoaded("Aroma1997Core")) {
			player.addChatMessage("You are running " + modName + " without Aroma1997Core!");
			player.addChatMessage("Aroma1997Core is not required, but recommended.");
			player.addChatMessage("Get Aroma1997Core from here: " + updateURL);
		}
		
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		
	}
	
	public static void init(String mod) {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			GameRegistry.registerPlayerTracker(new CoreReminder());
			modName = mod;
		}
	}
	
}
