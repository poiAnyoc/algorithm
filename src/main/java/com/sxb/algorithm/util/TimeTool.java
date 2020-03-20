package com.sxb.algorithm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间复杂度 时间打印工具
 * @desc:
 * @author: poi
 * @date: 2020/3/12 0:36
 * @version: v1.0
 */
public class TimeTool {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task{
        void execute();
    }

    public static void check(String title, Task task){
        if(null == task){
            return;
        }
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + fmt.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + fmt.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
}
