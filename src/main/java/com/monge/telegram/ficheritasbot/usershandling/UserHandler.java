/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.usershandling;

import com.monge.tbotboot.messenger.MessageMenu;
import com.monge.tbotboot.messenger.Response;
import com.monge.tbotboot.messenger.Xupdate;
import com.monge.tbotboot.quizes.QuizesControl;
import com.monge.telegram.ficheritasbot.objects.User;
import com.monge.telegram.ficheritasbot.quizes.GuiUser;
import com.monge.telegram.ficheritasbot.quizes.RegisterQuiz;

/**
 *
 * @author DeliveryExpress
 */
class UserHandler {

    static void execute(User user, Xupdate xupdate) {

        if (user.hasNullFields()) {
            Response.sendMessage(xupdate.getTelegramUser(), "Eres usuario nuevo! nececitas completar tu informacion.", null);
            if (!QuizesControl.hasQuiz(xupdate.getSenderId())) {
                QuizesControl.add(new RegisterQuiz(xupdate.getSenderId()));
                QuizesControl.execute(xupdate);

            }

        }

        switch (xupdate.getCommand().command()) {

            case "/start":
            case "/menu":

                if (!QuizesControl.hasQuiz(xupdate.getSenderId())) {
                    QuizesControl.add(new GuiUser(user, xupdate.getTelegramUser()));
                    QuizesControl.execute(xupdate);

                }
                break;

        }
    }

}
