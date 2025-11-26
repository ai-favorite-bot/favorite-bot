package com.stardust.favoritebot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import com.stardust.favoritebot.bot.EchoBot;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
public class TelegramBotConfig {

    private final EchoBot echoBot;

    public TelegramBotConfig(EchoBot echoBot) {
        this.echoBot = echoBot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(echoBot);
            log.info("Telegram bot successfully registered!");
        } catch (TelegramApiException e) {
            log.error("Error registering telegram bot", e);
        }
    }
}
