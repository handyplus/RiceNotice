package cn.handyplus.rice.notice.task;

import cn.handyplus.lib.core.CollUtil;
import cn.handyplus.lib.expand.adapter.HandySchedulerUtil;
import cn.handyplus.lib.util.MessageUtil;
import cn.handyplus.rice.notice.constants.BaseNoticeConstants;
import cn.handyplus.rice.notice.util.ConfigUtil;

/**
 * 发送消息定时任务
 *
 * @author handy
 */
public class NoticeTask {

    /**
     * 初始化
     */
    public static void init() {
        int time = ConfigUtil.CONFIG.getInt("time", 600);
        if (time <= 0) {
            return;
        }
        HandySchedulerUtil.runTaskTimerAsynchronously(() -> {
            MessageUtil.sendAllMessage(CollUtil.randomElement(BaseNoticeConstants.NOTICE_LIST));
        }, 20, time * 20L);
    }

}
