package ml.QuarkTheAwesome.AAP.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class GuiElementOffenceList extends Gui {
	GuiScreen parent;
	/**
	 * List of items to draw
	 */
	public List<GuiElementOffenceListItem> itemList = new ArrayList<GuiElementOffenceListItem>();
	
	private GuiElementOffenceListItem clickedItem;
	
	/**
	 * Items to fit on a page. Zero-based.
	 */
	static final int ITEMS_PER_PAGE = 5;
	
	public static final int PADDING = 2;
	
	int page = 0;
	int maxPages = 0;
	
	int x;
	int y;
	int height;
	int width;
	
	public GuiElementOffenceList(int x, int y, GuiScreen parent) {
		this.x = x;
		this.y = y;
		this.height = GuiElementOffenceListItem.HEIGHT * (ITEMS_PER_PAGE + 1);
		this.width = GuiElementOffenceListItem.WIDTH + (PADDING * 2);
		this.parent = parent;
	}
	public void draw(Minecraft mc, int mouseX, int mouseY) {
		maxPages = (int)itemList.size() / (int)ITEMS_PER_PAGE; //We really want integer division here, truncated.
		
		parent.drawRect(x - PADDING, y - PADDING, x + GuiElementOffenceListItem.WIDTH + PADDING, y + (GuiElementOffenceListItem.HEIGHT * (ITEMS_PER_PAGE + 1 /** Zero-based integers ;3 **/)) + PADDING, 0xBF000000);
		int itemsDrawn = 0;
		int yOffset = 0;
		for (int i = (page * ITEMS_PER_PAGE); i < itemList.size(); i++) {
			
			if (itemsDrawn <= ITEMS_PER_PAGE && i < itemList.size()) {
				itemList.get(i).drawXY(mc, x, y + yOffset, mouseX, mouseY);
				itemsDrawn++;
			} else {
				//If we get to here we've drawn ITEMS_PER_PAGE, so we're all good to stop now
				break;
			}
			//Flexibility! Too bad it's basically made useless by the ITEMS_PER_PAGE var.
			//Unless I make a class extending GuiElementOffenceListItem... Ooh.
			yOffset = yOffset + GuiElementOffenceListItem.HEIGHT;
		}
	}
	protected void onClick(Minecraft mc, int mouseX, int mouseY, int mouseButton) {
		int itemsChecked = 0;
		int yOffset = 0;
		for (int i = (page * ITEMS_PER_PAGE); i < itemList.size(); i++) {
			if (itemsChecked <= ITEMS_PER_PAGE) { //check this item
				if (mouseX >= x && mouseX <= x + itemList.get(i).WIDTH && mouseY >= y + yOffset && mouseY <= y + yOffset + itemList.get(i).HEIGHT) {
					//That's a click on this item!!!
					if (clickedItem != null) {
						clickedItem.clicked = false;
					}
					clickedItem = itemList.get(i);
					clickedItem.onClick(mouseButton);
					break;
				}
				itemsChecked++;
				yOffset = yOffset + itemList.get(i).HEIGHT;
			} else {
				break; //Not a click on us (we really should check for this earlier, but oh well
			}
		}
	}
}
