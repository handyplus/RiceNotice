package cn.handyplus.rice.notice;

import cn.handyplus.lib.InitApi;
import cn.handyplus.lib.constants.BaseConstants;
import cn.handyplus.lib.util.MessageUtil;
import cn.handyplus.rice.notice.task.NoticeTask;
import cn.handyplus.rice.notice.util.ConfigUtil;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 主类
 *
 * @author handy
 */
public class RiceNotice extends JavaPlugin {
    public static RiceNotice INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        InitApi initApi = InitApi.getInstance(this);
        ConfigUtil.init();

        initApi.initCommand("cn.handyplus.rice.notice.command")
                .initListener("cn.handyplus.rice.notice.listener")
                .checkVersion(ConfigUtil.CONFIG.getBoolean(BaseConstants.IS_CHECK_UPDATE, true));

        // 启动定时任务
        NoticeTask.init();
        MessageUtil.sendConsoleMessage(ChatColor.GREEN + "Author:handy WIKI: https://ricedoc.handyplus.cn/wiki/RiceNotice");
    }

    @Override
    public void onDisable() {
        InitApi.disable();
    }

}