/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.contability;

import com.j256.ormlite.field.DatabaseField;
import com.monge.xsqlite.utils.BaseDao;
import lombok.Data;

/**
 *
 * @author DeliveryExpress
 */
@Data
public class Wallet extends BaseDao {

    @DatabaseField(id = true)
    String userTelegramId;
    @DatabaseField
    float balance;

    public String toTelegramString() {
        StringBuilder sb = new StringBuilder();

        sb.append("🆔 ID: ").append(userTelegramId != null ? userTelegramId : "N/A").append("\n");
        sb.append("💵 Creditos: ").append(balance).append("\n");

        return sb.toString();
    }

}
