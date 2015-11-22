package ml.QuarkTheAwesome.AAP.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GuiElementComboBoxItem extends Gui {
	public String name;
	public String jsonID;
	
	public static final int HEIGHT = 11;
	public int width_dynamic;
	
	public static final int TEXT_COLOUR = 0xFFFFFFFF;
	public static final int BACKGROUND_COLOUR = 0xD9000000;
	
	public GuiElementComboBoxItem(String jsonID, String name) {
		this.jsonID = jsonID;
		this.name = name;
	}
	
	protected void drawXY(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		drawRect(x, y, x + width_dynamic + 1, y + HEIGHT, BACKGROUND_COLOUR);
		mc.fontRendererObj.drawString(name, x + 1, y + 1, TEXT_COLOUR);
	}
}
