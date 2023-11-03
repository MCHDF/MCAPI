package moe.mchdf.mcapi;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvData {

    static Dotenv dotenv = Dotenv.load();

    public static final String MCBOT_TOKEN = dotenv.get("CLIENT_TOKEN");
    public static final String DISCORD_GUILD = dotenv.get("DISCORD_GUILD");
    public static final String KEY = dotenv.get("KEY");
}
