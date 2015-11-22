package ml.QuarkTheAwesome.AAP.gui;

import java.util.ArrayList;
import java.util.List;

import com.mumfrey.liteloader.util.log.LiteLoaderLogger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GuiElementComboBox extends Gui {
	
	public List<GuiElementComboBoxItem> itemList = new ArrayList<GuiElementComboBoxItem>();
	
	private GuiElementComboBoxItem selectedItem;
	private GuiElementComboBoxItem placeholderItem = new GuiElementComboBoxItem("null", "Pick one...");
	
	private Boolean renderDropdown = false;
	
	public static final int BACKGROUND_COLOUR = 0xBF000000;
	
	public static final int HEIGHT = 10;
	public int width_dynamic;
	
	int x;
	int y;
	
	public GuiElementComboBox(Minecraft mc, int x, int y, List<GuiElementComboBoxItem> itemList) {
		this.x = x;
		this.y = y;
		this.selectedItem = this.placeholderItem;
		this.itemList = itemList;
		int longestItem = 0;
		//find our longest description
		for (GuiElementComboBoxItem i : itemList) {
			int tmp = mc.fontRendererObj.getStringWidth(i.name);
			if (tmp > longestItem) {
				longestItem = tmp;
			}
		}
		width_dynamic = longestItem;
		for (GuiElementComboBoxItem i : itemList) {
			i.width_dynamic = width_dynamic;
		}
	}
	
	protected void draw(Minecraft mc, int mouseX, int mouseY) {
		drawRect(x, y, x + width_dynamic + 1, y + HEIGHT, BACKGROUND_COLOUR);
		mc.fontRendererObj.drawString(selectedItem.name, x + 1, y + 1, 0xFFFFFFFF);
		if (renderDropdown) {
			int yOffset = HEIGHT;
			for (GuiElementComboBoxItem i : itemList) {
				i.drawXY(mc, x, y + yOffset, mouseX, mouseY);
				yOffset = yOffset + i.HEIGHT;
			}
		}
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (!renderDropdown) {
			if (mouseX >= x && mouseX <= x + width_dynamic && mouseY >= y && mouseY <= y + HEIGHT) {
				renderDropdown = true;
				LiteLoaderLogger.info("Opening Dropdown!");
			}
		} else {
			int yOffset = HEIGHT;
			for (GuiElementComboBoxItem i : itemList) {
				LiteLoaderLogger.info("Processing dropdown item (click)...");
				if (mouseX >= x && mouseX <= x + width_dynamic && mouseY >= y + yOffset && mouseY <= y + yOffset + i.HEIGHT) {
					LiteLoaderLogger.info("Got one! " + i.name);
					//We got one!
					selectedItem = i;
					//TODO: Add handling to change buttons and things
					renderDropdown = false;
					break;
				}
				yOffset = yOffset + i.HEIGHT;
			}
			renderDropdown = false;
		}
	}
}
