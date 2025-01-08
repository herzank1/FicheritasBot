/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.objects;

import com.j256.ormlite.field.DatabaseField;
import lombok.Data;

/**
 *
 * @author DeliveryExpress
 */
@Data
public class UserPhoto {

    @DatabaseField(id = true)
    String photoId;
    @DatabaseField
    String userId;
    @DatabaseField
    String telegramFileId;

}
