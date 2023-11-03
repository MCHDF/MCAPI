package moe.mchdf.mcapi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCBOT extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MCBOT.class);

    public static JDA bot;

    public static void startBOT() {

        JDABuilder builder = JDABuilder.createDefault(EnvData.MCBOT_TOKEN);

        try {
            builder.setAutoReconnect(true);
            builder.enableIntents(
                            GatewayIntent.GUILD_MEMBERS,
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.GUILD_VOICE_STATES,
                            GatewayIntent.MESSAGE_CONTENT,
                            GatewayIntent.AUTO_MODERATION_CONFIGURATION,
                            GatewayIntent.AUTO_MODERATION_EXECUTION,
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                            GatewayIntent.SCHEDULED_EVENTS)
                    .enableCache(
                            CacheFlag.ONLINE_STATUS,
                            CacheFlag.EMOJI,
                            CacheFlag.STICKER,
                            CacheFlag.SCHEDULED_EVENTS,
                            CacheFlag.VOICE_STATE,
                            CacheFlag.MEMBER_OVERRIDES)
                    .setMemberCachePolicy(MemberCachePolicy.ALL);
            builder.setEventPassthrough(true);
            bot = builder.build();
            LOGGER.info("BOT build done.");
            LOGGER.debug(bot.getEventManager().getRegisteredListeners().toString());
            bot.awaitReady();
        } catch (Exception e) {
            LOGGER.warn("봇을 빌드하는 도중에 문제가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}
