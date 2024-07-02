package cn.handyplus.rice.notice.util;

import cn.handyplus.lib.util.HandyConfigUtil;
import cn.handyplus.rice.notice.constants.BaseNoticeConstants;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Map;

/**
 * 配置
 *
 * @author handy
 */
public class ConfigUtil {

    public static FileConfiguration CONFIG;

    /**
     * 加载全部配置
     */
    public static void init() {
        CONFIG = HandyConfigUtil.loadConfig();
        // 缓存数据
        Map<String, String> noticeMap = HandyConfigUtil.getStringMapChild(CONFIG, "notice");
        if (noticeMap.isEmpty()) {
            return;
        }
        BaseNoticeConstants.NOTICE_LIST.clear();
        for (String key : noticeMap.keySet()) {
            List<String> noticeList = CONFIG.getStringList("notice." + key);
            BaseNoticeConstants.NOTICE_LIST.add(noticeList);
        }
    }

}