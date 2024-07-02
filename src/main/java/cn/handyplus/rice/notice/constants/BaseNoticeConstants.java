package cn.handyplus.rice.notice.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量
 *
 * @author handy
 */
public abstract class BaseNoticeConstants {

    /**
     * 公告 列表
     */
    public final static List<List<String>> NOTICE_LIST = new ArrayList<>();

    /**
     * 检查更新网址
     */
    public final static String PLUGIN_VERSION_URL = "https://api.github.com/repos/handyplus/RiceNotice/releases/latest";

}