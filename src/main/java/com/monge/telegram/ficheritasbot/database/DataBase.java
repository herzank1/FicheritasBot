/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.database;

import com.monge.telegram.ficheritasbot.contability.Transacction;
import com.monge.telegram.ficheritasbot.contability.Wallet;
import com.monge.telegram.ficheritasbot.objects.AccountType;
import com.monge.telegram.ficheritasbot.objects.User;
import com.monge.telegram.ficheritasbot.objects.UserPhoto;
import com.monge.xsqlite.connectors.SqliteConection;
import com.monge.xsqlite.xsqlite.ConnectionPoolManager;

/**
 *
 * @author DeliveryExpress
 */
public class DataBase {

    public static void init() {

        initWithSqlite("database.sqlite");

    }

    public static void initWithSqlite(String dataBaseName) {

        System.out.println("Init Sqlite DataBase...");

        SqliteConection con = new SqliteConection(dataBaseName);

        ConnectionPoolManager.addConnection(con,
                Wallet.class,
                Transacction.class,
                User.class,
                UserPhoto.class
        );

        System.out.println("success!");

    }

    public static User getUser(String senderId) {

        User get = User.read(User.class, senderId);
        if (get == null) {

            get = new User();
            get.setTelegramId(senderId);
            get.setAccountType(AccountType.USER);
            get.create();

        }

        return get;

    }

    public static Wallet getWallet(String telegramId) {

        Wallet read = Wallet.read(Wallet.class, telegramId);
        if (read == null) {
            read = new Wallet();
            read.setUserTelegramId(telegramId);
            read.setBalance(0f);
            read.create();
        }

        return read;

    }

}
