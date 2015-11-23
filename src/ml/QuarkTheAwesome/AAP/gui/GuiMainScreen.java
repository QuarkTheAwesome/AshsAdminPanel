package ml.QuarkTheAwesome.AAP.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.mumfrey.liteloader.util.log.LiteLoaderLogger;

import ml.QuarkTheAwesome.AAP.LiteModAAP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiMainScreen extends GuiScreen {
	
	private GuiButton btnPrevPage;
	private GuiButton btnNextPage;
	private GuiButton btnBan;
	private GuiButton btnMute;
	private GuiButton btnKick;
	private GuiButton btnWarn;
	
	private GuiElementOffenceList list;
	
	private GuiElementComboBox combo;
	
	private GuiTextField searchBar;
	private GuiTextField descriptionBar;
	private GuiTextField timeBar;
	private GuiTextField actionBar;
	private GuiTextField actionArgument1;
	private GuiTextField actionArgument2;
	
	public GuiMainScreen() {}
	
	/**
	 * Sets up all GUI elements. Lots'a magic numbers here.
	 */
	public void initGui() {
		/*SECTION: CONSTRUCTOR STUFF MOVED*/
		Keyboard.enableRepeatEvents(true);
		LiteLoaderLogger.info("Oh hai! This is GuiMainScreen.");
		list = new GuiElementOffenceList(20, 20, this);
		
		btnBan = new GuiButton(103, 20 + list.width + 20, 40, 50, 20, "New Ban");
		btnMute = new GuiButton(103, 20 + list.width + 20 + 50 + 10, 40, 50, 20, "New Mute");
		btnKick = new GuiButton(103, 20 + list.width + 20 + 50 + 10 + 50 + 10, 40, 50, 20, "New Kick");
		btnWarn = new GuiButton(103, 20 + list.width + 20 + 50 + 10 + 50 + 10 + 50 + 10, 40, 50, 20, "New Ban");
		
		searchBar = new GuiTextField(0, this.mc.fontRendererObj, this.width - 18 - 110 /*par5width*/, 18, 110 /*RANDOM GUESS!*/, 14 /*Another random guess*/);
		searchBar.setMaxStringLength(16);
		searchBar.setEnableBackgroundDrawing(true);
		searchBar.setText("");
		
		descriptionBar = new GuiTextField(1, this.mc.fontRendererObj, 20 + list.width + 20, 70, 270, 14);
		descriptionBar.setMaxStringLength(100);
		descriptionBar.setEnableBackgroundDrawing(true);
		descriptionBar.setText("");
		descriptionBar.setEnabled(true);
		
		timeBar = new GuiTextField(2, this.mc.fontRendererObj, 20 + list.width + 20, 90, 270, 14);
		timeBar.setMaxStringLength(50);
		timeBar.setEnableBackgroundDrawing(true);
		timeBar.setText("");
		timeBar.setEnabled(true);
		
		actionBar = new GuiTextField(3, this.mc.fontRendererObj, 20 + list.width + 20, 110, 50, 14);
		actionBar.setMaxStringLength(9);
		actionBar.setEnableBackgroundDrawing(true);
		actionBar.setText("");
		actionBar.setEnabled(true);
		
		actionArgument1 = new GuiTextField(4, this.mc.fontRendererObj, 20 + list.width + 20 + actionBar.getWidth() + 20, 110, 110, 14);
		actionArgument1.setMaxStringLength(16);
		actionArgument1.setEnableBackgroundDrawing(true);
		actionArgument1.setText("");
		actionArgument1.setEnabled(true);
		
		actionArgument2 = new GuiTextField(4, this.mc.fontRendererObj, 20 + list.width + 20 + actionBar.getWidth() + actionArgument1.getWidth() + 40, 110, 105, 14);
		actionArgument2.setMaxStringLength(100);
		actionArgument2.setEnableBackgroundDrawing(true);
		actionArgument2.setText("");
		actionArgument2.setEnabled(true);
		
		//TODO: debug items
		List<GuiElementComboBoxItem> comboItems = new ArrayList<GuiElementComboBoxItem>();
		comboItems.add(new GuiElementComboBoxItem("1", "1st greif"));
		comboItems.add(new GuiElementComboBoxItem("1", "greif > 1000"));
		comboItems.add(new GuiElementComboBoxItem("1", "4th chat abuse"));
		comboItems.add(new GuiElementComboBoxItem("1", "hacked client"));
		
		combo = new GuiElementComboBox(this.mc, 20 + list.width + 20 + mc.fontRendererObj.getStringWidth("Offence:") + 2, 20, comboItems);
		
		btnPrevPage = new GuiButton(101, 18, list.height + 23, 15, 20, "<");
		btnNextPage = new GuiButton(102, (18 + list.width - 15 /*widthIn*/), list.height + 23, 15, 20, ">");
		
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
		
		/*SECTION: ACTUAL initGUI stuff*/
		this.buttonList.clear();
		this.buttonList.add(btnPrevPage);
		this.buttonList.add(btnNextPage);
		this.buttonList.add(btnBan);
		this.buttonList.add(btnKick);
		this.buttonList.add(btnMute);
		this.buttonList.add(btnWarn);
		btnPrevPage.enabled = false;
	}
	
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
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
		
		btnBan.drawButton(mc, mouseX, mouseY);
		btnMute.drawButton(mc, mouseX, mouseY);
		btnKick.drawButton(mc, mouseX, mouseY);
		btnWarn.drawButton(mc, mouseX, mouseY);
		
		searchBar.drawTextBox();
		descriptionBar.drawTextBox();
		timeBar.drawTextBox();
		actionBar.drawTextBox();
		actionArgument1.drawTextBox();
		actionArgument2.drawTextBox();
		
		this.mc.fontRendererObj.drawString("Offence:", 20 + list.width + 20, 21, 0xFFFFFFFF);
		combo.draw(this.mc, mouseX, mouseY);
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
				if (!(list.page - 1 >= 0)) {
					btnPrevPage.enabled = false;
				}
				btnNextPage.enabled = true;
			}
		} 
		if (btn == btnNextPage) {
			if (list.page + 1 <= list.maxPages) {
				list.page = list.page + 1;	
				if (!(list.page + 1 <= list.maxPages)) {
					btnNextPage.enabled = false;
				}
				btnPrevPage.enabled = true;
			}
		}
	}
	
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		list.onClick(this.mc, mouseX, mouseY, mouseButton);
		searchBar.mouseClicked(mouseX, mouseY, mouseButton);
		combo.mouseClicked(mouseX, mouseY, mouseButton);
		descriptionBar.mouseClicked(mouseX, mouseY, mouseButton);
		timeBar.mouseClicked(mouseX, mouseY, mouseButton);
		actionBar.mouseClicked(mouseX, mouseY, mouseButton);
		actionArgument1.mouseClicked(mouseX, mouseY, mouseButton);
		actionArgument2.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	protected void keyTyped(char keyTyped, int keyCode) throws IOException {
		if (keyCode == 1) {
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
		searchBar.textboxKeyTyped(keyTyped, keyCode);
		descriptionBar.textboxKeyTyped(keyTyped, keyCode);
		timeBar.textboxKeyTyped(keyTyped, keyCode);
		actionBar.textboxKeyTyped(keyTyped, keyCode);
		actionArgument1.textboxKeyTyped(keyTyped, keyCode);
		actionArgument2.textboxKeyTyped(keyTyped, keyCode);
	}
}
