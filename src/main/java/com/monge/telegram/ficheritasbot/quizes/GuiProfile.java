/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.quizes;

import com.monge.tbotboot.gui.GuiElement;
import com.monge.tbotboot.gui.GuiItem;
import com.monge.tbotboot.messenger.MessageMenu;
import com.monge.tbotboot.messenger.Xupdate;
import com.monge.telegram.ficheritasbot.objects.User;

/**
 *
 * @author DeliveryExpress
 */
public class GuiProfile extends GuiItem {

    User user;

    public GuiProfile(User user, GuiElement parent, String text) {
        super(parent, text);
        this.user = user;
    }

    @Override
    public void execute(Xupdate update) {
        
    

        System.out.println("GuiProfile " + update);

    }

   

    @Override
    public MessageMenu getMenu() {
        return new MessageMenu();
    }

    @Override
    public String draw() {

        return user.toTelegramString();

    }

   

}
