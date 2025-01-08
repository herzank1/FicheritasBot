/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.quizes;

import com.monge.tbotboot.messenger.MessageMenu;
import com.monge.tbotboot.messenger.Response;
import com.monge.tbotboot.messenger.Xupdate;
import com.monge.tbotboot.quizes.Quiz;
import com.monge.telegram.ficheritasbot.database.DataBase;
import com.monge.telegram.ficheritasbot.objects.AccountType;
import com.monge.telegram.ficheritasbot.objects.User;
import com.monge.telegram.ficheritasbot.utils.Utils;

/**
 *
 * @author DeliveryExpress
 */
public class RegisterQuiz extends Quiz {

    User user;

    public RegisterQuiz(String userId) {
        super(userId);
        user = DataBase.getUser(userId);
    }

    @Override
    public void execute(Xupdate xupdate) {
        MessageMenu menu;

        switch (super.getStep()) {

            case 0:
                menu = new MessageMenu();
                menu.addButton("👤 Cliente", AccountType.CLIENT, false);
                menu.addButton("🔥 Fichera", AccountType.LADY, false);
                Response.sendMessage(xupdate.getTelegramUser(), "Soy", menu);
                super.next();
                break;

            case 1:
                user.setAccountType(xupdate.getText());
                Response.sendMessage(xupdate.getTelegramUser(), "Ingresa tu Nombre", null);
                super.next();
                break;

            case 2:
                user.setName(xupdate.getText());
                Response.sendMessage(xupdate.getTelegramUser(), "Ingresa edad +18", null);
                super.next();

                break;
            case 3:
                user.setAge(xupdate.getText());
                menu = new MessageMenu();
                menu.addButton("👨‍🦰 Hombre", "MALE", false);
                menu.addButton("👩 Mujer", "FEMALE", true);
                menu.addButton("🏳‍⚧🏳‍🌈 Otro", "OTHER", true);
                Response.sendMessage(xupdate.getTelegramUser(), "Como te identificas?", menu);
                super.next();

                break;
            case 4:
                user.setGender(xupdate.getText());
                Response.sendMessage(xupdate.getTelegramUser(), "Selecciona tu Pais", getSpanishCountries());
  super.next();
                break;

            case 5:
                user.setCountry(xupdate.getText());
                Response.sendMessage(xupdate.getTelegramUser(), "Es correcta tu informacion?\n"
                        + user.toTelegramString(), MessageMenu.yesNo());
                super.next();

                break;
            case 6:
                if (Utils.isPositiveAnswer(xupdate.getText())) {
                    user.update();
                    Response.sendMessage(xupdate.getTelegramUser(), "Guardado!", MessageMenu.okAndDeleteMessage());
                    super.destroy();
                } else {
                    Response.sendMessage(xupdate.getTelegramUser(), "Iniciando de nuevo.", MessageMenu.okAndDeleteMessage());
                    super.destroy();
                }
                break;

        }

    }

    private MessageMenu getSpanishCountries() {
        MessageMenu menu = new MessageMenu();
// Agregando los países de habla hispana
        menu.addButton("🇦🇷 Argentina", "ARGENTINA", true);
        menu.addButton("🇧🇴 Bolivia", "BOLIVIA", true);
        menu.addButton("🇨🇱 Chile", "CHILE", true);
        menu.addButton("🇨🇴 Colombia", "COLOMBIA", true);
        menu.addButton("🇨🇷 Costa Rica", "COSTA_RICA", true);
        menu.addButton("🇨🇺 Cuba", "CUBA", true);
        menu.addButton("🇩🇴 República Dominicana", "DOMINICAN_REPUBLIC", true);
        menu.addButton("🇪🇨 Ecuador", "ECUADOR", true);
        menu.addButton("🇸🇻 El Salvador", "EL_SALVADOR", true);
        menu.addButton("🇪🇸 España", "SPAIN", true);
        menu.addButton("🇬🇹 Guatemala", "GUATEMALA", true);
        menu.addButton("🇭🇳 Honduras", "HONDURAS", true);
        menu.addButton("🇲🇽 México", "MEXICO", true);
        menu.addButton("🇳🇮 Nicaragua", "NICARAGUA", true);
        menu.addButton("🇵🇦 Panamá", "PANAMA", true);
        menu.addButton("🇵🇾 Paraguay", "PARAGUAY", true);
        menu.addButton("🇵🇪 Perú", "PERU", true);
        menu.addButton("🇵🇷 Puerto Rico", "PUERTO_RICO", true);
        menu.addButton("🇺🇸 Estados Unidos", "UNITED_STATES", true);
        menu.addButton("🇺🇾 Uruguay", "URUGUAY", true);
        menu.addButton("🇻🇪 Venezuela", "VENEZUELA", true);
        return menu;

    }

}
