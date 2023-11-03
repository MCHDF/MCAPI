package moe.mchdf.mcapi.impl;

import moe.mchdf.mcapi.ERROR;
import moe.mchdf.mcapi.EnvData;
import moe.mchdf.mcapi.MCBOT;
import moe.mchdf.mcapi.service.JDAService;
import net.dv8tion.jda.api.entities.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JDAServiceImpl implements JDAService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JDAServiceImpl.class);
    @Override
    public Map<String, Object> getDSUserData(String id) {
        Map<String, Object> userDSData = new HashMap<>();
        if (id == null) {
            LOGGER.warn("id값이 없음 (" + id + ")");
            userDSData.put("error", ERROR.USER_ID_NO_EXIST);
            return userDSData;
        } else {
            LOGGER.info("id값 전달 받음. (" + id + ")");
        }

        if (MCBOT.bot.getGuildById(EnvData.DISCORD_GUILD) == null) {
            LOGGER.warn("길드 인식되지 않음.");
            userDSData.put("error", ERROR.GUILD_ID_NO_EXIST);
            return userDSData;
        } else {
            LOGGER.info("길드 인식됨. (" + EnvData.DISCORD_GUILD + ")");
        }

        if (MCBOT.bot.getGuildById(EnvData.DISCORD_GUILD).getMemberById(id) == null) {
            LOGGER.warn("멤버 인식되지 않음.");
            userDSData.put("error", ERROR.USER_ID_NO_EXIST);
            return userDSData;
        } else {
            LOGGER.info("멤버 인식됨. (" + id + ")");
        }
        Member member = MCBOT.bot.getGuildById(EnvData.DISCORD_GUILD).getMemberById(id);

        userDSData.put("id", id);
        userDSData.put("username", member.getUser().getName());
        userDSData.put("createdTimestamp", member.getTimeCreated());
        userDSData.put("avartarURL", member.getUser().getAvatarUrl() != null ? member.getUser().getAvatarUrl() : "none");
        return userDSData;
    }
}
