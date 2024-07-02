package cn.handyplus.rice.notice.listener;

import cn.handyplus.lib.annotation.HandyListener;
import cn.handyplus.lib.constants.BaseConstants;
import cn.handyplus.lib.util.HandyHttpUtil;
import cn.handyplus.rice.notice.constants.BaseNoticeConstants;
import cn.handyplus.rice.notice.util.ConfigUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * 玩家进入服务器事件.
 *
 * @author handy
 */
@HandyListener
public class PlayerEventListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onOpPlayerJoin(PlayerJoinEvent event) {
        // op登录发送更新提醒
        if (!ConfigUtil.CONFIG.getBoolean(BaseConstants.IS_CHECK_UPDATE_TO_OP_MSG, true)) {
            return;
        }
        HandyHttpUtil.checkVersion(event.getPlayer(), BaseNoticeConstants.PLUGIN_VERSION_URL);
    }

}