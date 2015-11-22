package ml.QuarkTheAwesome.AAP;

import java.io.File;

import org.lwjgl.input.Keyboard;

import ml.QuarkTheAwesome.AAP.gui.GuiMainScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.core.LiteLoader;

public class LiteModAAP implements Tickable {

	private static KeyBinding guiKeyBinding = new KeyBinding("Open AAP", Keyboard.KEY_F12, "key.categories.litemods");
	public String debugLine = "Hey hey hey! AAP is running!";
	
	@Override
	public String getVersion() {
		return "0.0.0";
	}

	@Override
	public void init(File configPath) {
		LiteLoader.getInput().registerKeyBinding(LiteModAAP.guiKeyBinding);
	}

	@Override
	public void upgradeSettings(String version, File configPath,
			File oldConfigPath) {

	}

	@Override
	public String getName() {
		return "AAP";
	}

	@Override
	public void onTick(Minecraft minecraft, float partialTicks, boolean inGame,
			boolean clock) {
		minecraft.fontRendererObj.drawString(debugLine, 10, 10, 0xFFFF0000);
		if (LiteModAAP.guiKeyBinding.isPressed()) {
			GuiMainScreen main = new GuiMainScreen();
			minecraft.displayGuiScreen(main);
		}
	}
	
}
