/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.objects;

import com.j256.ormlite.field.DatabaseField;
import com.monge.telegram.ficheritasbot.contability.Wallet;
import com.monge.telegram.ficheritasbot.database.DataBase;
import com.monge.xsqlite.utils.BaseDao;
import lombok.Data;

/**
 *
 * @author DeliveryExpress
 */
@Data
public class User extends BaseDao {

    @DatabaseField(id = true)
    String telegramId;
    @DatabaseField
    String name;
    @DatabaseField
    String gender;
    @DatabaseField
    String age;
    @DatabaseField
    String country;
   // @DatabaseField
   // String city;
    @DatabaseField
    String accountType;

    public User() {

    }

    public Wallet getWallet() {
        return DataBase.getWallet(this.telegramId);
    }

    public String toTelegramString() {
        StringBuilder sb = new StringBuilder();

        sb.append("🆔 ID: ").append(telegramId != null ? telegramId : "N/A").append("\n");
        sb.append("👤 Name: ").append(name != null ? name : "N/A").append("\n");
        sb.append("⚧ Gender: ").append(gender != null ? gender : "N/A").append("\n");
        sb.append("🎂 Age: ").append(age != null ? age : "N/A").append("\n");
        sb.append("🌍 Country: ").append(country != null ? country : "N/A").append("\n");
       // sb.append("🏙️ City: ").append(city != null ? city : "N/A").append("\n");
        sb.append("💳 Account Type: ").append(accountType != null ? accountType : "N/A").append("\n");

        return sb.toString();
    }

    /**
     * Checks if any field in the class is null.
     *
     * @return true if at least one field is null, false otherwise.
     */
    public boolean hasNullFields() {
        return telegramId == null
                || name == null
                || gender == null
                || age == null
                || country == null
               // || city == null
                || accountType == null;
    }

}
