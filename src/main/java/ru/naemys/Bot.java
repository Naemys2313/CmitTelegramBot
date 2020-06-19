package ru.naemys;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage())
            return;

        Message message = update.getMessage();
        if (!message.hasText())
            return;

        long chatId = message.getChatId();
        String textMessage = message.getText();

        SendMessage sendMessage = new SendMessage(chatId, textMessage);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "username";
    }

    @Override
    public String getBotToken() {
        return "token";
    }
}
