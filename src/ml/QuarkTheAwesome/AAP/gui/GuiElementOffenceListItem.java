package ml.QuarkTheAwesome.AAP.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class GuiElementOffenceListItem extends Gui {
	private GuiScreen parent;
	
	public String name;
	public String caption;
	public String date;
	
	public Boolean clicked = false;
	
	//TODO: Make these 3 a biiiit more logical
	public static final int WIDTH = 50;
	public static final int HEIGHT = 31;
	public static final int GAP_BETWEEN_STRING_ORIGINS_Y = 10;
	
	public static final int TITLE_TEXT_COLOUR = 0xFFFF0000;
	public static final int CAPTION_TEXT_COLOUR = 0xFFFF0000;
	public static final int DATE_TEXT_COLOUR = 0xFFFF0000;
	public static final int LINE_COLOUR = 0xD9000000;
	public static final int SELECTED_BACKGROUND = 0xFF00FF00;
	
	public GuiElementOffenceListItem(String name, String caption, String date) {
		this.name = name;
		this.caption = caption;
		this.date = date;
	}
	
	public void drawXY(Minecraft mc, int x, int y, int mouseX, int mouseY) {
		if (clicked) {
			drawRect(x, y, x + WIDTH, y + HEIGHT, SELECTED_BACKGROUND); //TODO: Add proper padding to this
		}
		mc.fontRendererObj.drawString(prepareString(name, mc), x, y, TITLE_TEXT_COLOUR);
		mc.fontRendererObj.drawString(prepareString(caption, mc), x, y + GAP_BETWEEN_STRING_ORIGINS_Y, CAPTION_TEXT_COLOUR);
		mc.fontRendererObj.drawString(prepareString(date, mc), x, y + (GAP_BETWEEN_STRING_ORIGINS_Y * 2), DATE_TEXT_COLOUR);
		drawHorizontalLine(x, x + WIDTH, y + (GAP_BETWEEN_STRING_ORIGINS_Y * 3 - 1), LINE_COLOUR);
	}
	
	/**
	 * Gets our string ready for drawing
	 */
	private String prepareString(String str, Minecraft mc) {
		return mc.fontRendererObj.trimStringToWidth(str, WIDTH) + "..";
	}
	protected void onClick(int mouseButton) {
		clicked = true;
	}
}
