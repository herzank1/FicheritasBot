/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.quizes;

import com.monge.tbotboot.gui.GuiMenu;
import com.monge.tbotboot.objects.Receptor;
import com.monge.tbotboot.quizes.QuizGui;
import com.monge.telegram.ficheritasbot.objects.User;

/**
 *
 * @author DeliveryExpress
 */
public class GuiUser  extends QuizGui{
    
    public GuiUser(User user,Receptor receptor) {
        super(receptor,true);
        
        GuiMenu mainMenu = new GuiMenu(null, "Menu Principal");
        
        
         mainMenu.addItem(new GuiProfile(user, null, "👤 ️Mi perfil"));
         mainMenu.addItem(new GuiExplorer(user, null, "❤️ Explorar"));
         mainMenu.addItem(new GuiWallet(user, null, "💵️ Creditos"));
         
//                menu.addButton("👤 ️Mi perfil", "/profile", true);
//        menu.addButton("❤️ Explorar", "/explorer", true);
//        menu.addButton("💵 Recargar Saldo", "/addfounds", true);
//        menu.addButton("🎁 Enviar Regalos", "/sendgift", true);
//        menu.addButton("📝 Reglas", "/rules", true);
//        menu.addButton("❓ Ayuda", "/help", true);
        
        
        super.setMainMenu(mainMenu);
        
    }
    
}
