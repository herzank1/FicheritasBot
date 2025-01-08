/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.monge.telegram.ficheritasbot;

import com.monge.tbotboot.messenger.Bot;
import com.monge.tbotboot.messenger.BotsHandler;
import com.monge.telegram.ficheritasbot.database.DataBase;
import com.monge.telegram.ficheritasbot.usershandling.UsersHandler;

/**
 *
 * @author DeliveryExpress
 */
public class FicheritasBot {

    public static void main(String[] args) {
        /*Iniciamos base de datos*/
        DataBase.init();
        /*Iniciamos el bot y el handler*/
        BotsHandler.init(new UsersHandler(), new Bot("@FicheritasBot","7943700658:AAHl6vPSh3PL2fZqUwWX_N_ILoKbxcah4ek"));
    }
}
