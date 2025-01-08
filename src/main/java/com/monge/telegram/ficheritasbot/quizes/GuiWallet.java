/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.quizes;

import com.monge.tbotboot.gui.GuiBase;
import com.monge.tbotboot.gui.GuiElement;
import com.monge.tbotboot.gui.GuiItem;
import com.monge.tbotboot.messenger.MessageMenu;
import com.monge.tbotboot.messenger.Xupdate;
import com.monge.telegram.ficheritasbot.contability.Wallet;
import com.monge.telegram.ficheritasbot.objects.User;

/**
 *
 * @author DeliveryExpress
 */
public class GuiWallet extends GuiItem {

    User user;
    Wallet wallet;

    public GuiWallet(User user, GuiElement parent, String text) {
        super(parent, text);
        this.user = user;
        wallet = user.getWallet();
    }

    @Override
    public void execute(Xupdate update) {
        return;
    }

    @Override
    public MessageMenu getMenu() {

        MessageMenu menu = new MessageMenu();
        menu.addButton("🔁 Recargar", "--addfounds", true);
        menu.addButton("⤴ Retirar", "--withdraw", true);

        return menu;

    }

    @Override
    public String draw() {

        return wallet.toTelegramString();

    }

}
