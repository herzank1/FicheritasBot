/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.usershandling;

import com.monge.tbotboot.commands.CommandsHandlers;
import com.monge.tbotboot.messenger.Xupdate;
import com.monge.tbotboot.quizes.QuizesControl;
import com.monge.telegram.ficheritasbot.database.DataBase;
import com.monge.telegram.ficheritasbot.objects.User;
import com.monge.telegram.ficheritasbot.objects.AccountType;

/**
 *
 * @author DeliveryExpress
 */
public class UsersHandler implements CommandsHandlers {
    
    @Override
    public void execute(Xupdate xupdate) {
        
        try {
            if (xupdate.isGroupMessage()) {
            } else {
                
                if (QuizesControl.hasQuiz(xupdate.getSenderId())) {
                    QuizesControl.execute(xupdate);
                    return;
                }
                
                User user = DataBase.getUser(xupdate.getSenderId());
                switch (user.getAccountType()) {
                    
                    case AccountType.USER:
                    case AccountType.LADY:
                    case AccountType.CLIENT:
                        
                        UserHandler.execute(user, xupdate);
                        
                        break;
                    
                    case AccountType.MODERATOR:
                        ModeratorHandler.execute(user, xupdate);
                        break;
                    
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
