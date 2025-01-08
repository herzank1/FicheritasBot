/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.contability;

import com.j256.ormlite.field.DatabaseField;
import lombok.Data;

/**
 *
 * @author DeliveryExpress
 */
@Data
public class Transacction {

    @DatabaseField(id = true)
    String id;
    @DatabaseField
    String from;
    @DatabaseField
    String to;
    @DatabaseField
    float amount;
    @DatabaseField
    String metaData;

}
