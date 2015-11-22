package ml.QuarkTheAwesome.AAP.gui;

import com.mumfrey.liteloader.util.log.LiteLoaderLogger;

import ml.QuarkTheAwesome.AAP.LiteModAAP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiMainScreen extends GuiScreen {
	/**
	 * It's a test button right now, but I'll change it later.
	 */
	private GuiButton btnPrevPage;
	private GuiButton btnNextPage;
	
	private GuiElementOffenceList list;
	
	/**
	 * Constructor. Sets up our button.
	 */
	public GuiMainScreen() {
		LiteLoaderLogger.info("Oh hai! This is GuiMainScreen.");
		list = new GuiElementOffenceList(20, 20, this);
		
		btnPrevPage = new GuiButton(101, 18, list.height + 23, 15, 20, "<");
		btnNextPage = new GuiButton(102, (18 + list.width - 15 /**widthIn**/), list.height + 23, 15, 20, ">");
		
		//TODO: debug items
		list.itemList.add(new GuiElementOffenceListItem("1Steven!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("2Steve1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("3St3ven!", "B3b!", "WOOOAA3AHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("4Stevafen!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("5Stevagfe1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("6Stsgsgs3ven!", "B3b!", "WOOOAA3AHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("7Stevgjhdhen!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("8Stehgjgvhfdhe1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("9Ssfsfdt3ven!", "B3b!", "WOOOAA3AHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("10Sthjgjhgjeven!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("11Stehjhgdve1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("12St3fdhven!", "B3b!", "WOOOAA3AHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("13Stesfdvdhen!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("14Stevsafe1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("15St3ggfhfjdven!", "B3b!", "WOOOAA3AHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("16Stevsfen!", "Bob!", "WOOOAAAAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("17Stesafdve1n!", "Bob1!", "WOOOAA2AAHHHH"));
		list.itemList.add(new GuiElementOffenceListItem("18St3sdfven!", "B3b!", "WOOOAA3AHHHH"));
	}
	
	/**
	 * Add our button and whatnot into the list of stuff to be rendered.
	 */
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(btnPrevPage);
		this.buttonList.add(btnNextPage);
	}
	
	/**
	 * Custom render loop. Useful for lots of things.
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//Fancy things
		this.drawGradientRect(10, 10, this.width - 10, this.height - 10, 0xF2000000, 0x40000001);
		//GUI elements
		btnPrevPage.drawButton(this.mc, mouseX, mouseY);
		this.mc.fontRendererObj.drawString((list.page + 1) + "/" + (list.maxPages + 1), 33, list.height + 23, 0xFFFFFFFF);
		btnNextPage.drawButton(this.mc, mouseX, mouseY);
		list.draw(this.mc, mouseX, mouseY);
	}
	
	/**
	 * Handles button events.
	 * @param btn The GuiButton that was pressed.
	 */
	protected void actionPerformed(GuiButton btn) {
		LiteLoaderLogger.info("Action!");
		LiteLoaderLogger.info("H:" + this.height + " W:" + this.width);
		if (btn == btnPrevPage) {
			if (list.page - 1 >= 0) {
				list.page = list.page - 1;
			}
		} 
		if (btn == btnNextPage) {
			if (list.page + 1 <= list.maxPages) {
				list.page = list.page + 1;	
			}
		}
	}
}
