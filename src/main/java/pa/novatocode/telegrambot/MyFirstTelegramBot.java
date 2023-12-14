package pa.novatocode.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static pa.novatocode.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "NovatoCode_Bot";
    public static final String TOKEN = "6877931870:AAHHi8p75Ri1DgNmUt3VQ5O_WEEcBnQUYC4";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        String mensaje = getMessageText();
        String boton = getCallbackQueryButtonKey();

        if (mensaje.equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la Nevera", "step_1_btn"));
        }

        if (boton.equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchica! +20 de  fama", "step_2_btn",
                            "¡Tomar un pescado! +20 de  fama", "step_2_btn",
                            "¡Tirar una lata de pepinillo! +20 de  fama", "step_2_btn"));
        }

        if (boton.equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora", "step_3_btn"));
        }

        if (boton.equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora por comida +30 de fama", "step_4_btn",
                            "Dar un peseo en el robot aspiradora +30 de  fama", "step_4_btn",
                            "¡Huir del robot aspiradora! +30 de  fama", "step_4_btn"));
        }

        if (boton.equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Colocate la GoPro en el lomo", "step_5_btn"));
        }

        if (boton.equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Graba una pelea de gato en el techo +40 de fama", "step_6_btn",
                            "Graba a un perro amarrado +40 de  fama", "step_6_btn",
                            "¡Sal a trotar y graba tu camino! +40 de  fama", "step_6_btn"));
        }

        if (boton.equals("step_6_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackea la contraseña de la computadora +50 de fama", "step_7_btn"));
        }

        if (boton.equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("ver video de gatos durmiendo", "step_8_btn",
                            "dormir un rato", "step_8_btn",
                            "celebrar la victoria", "step_8_btn"));
        }

        if (boton.equals("step_8_btn")){
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}