package com.lovoio.util;

import com.github.promeg.pinyinhelper.Pinyin;
import com.intellij.openapi.diagnostic.Logger;

/**
 * @author <a href="https://github.com/bytebeats">bytebeats</a>
 * @since 2020/8/19 16:48
 */
public class PinyinUtils {
    private static final Logger LOG = Logger.getInstance(PinyinUtils.class);

    public static String toPinyin(String input) {
        try {
            String result = toPinyin2(input);
            LOG.debug(input + " toPinyin2: A" + result);
            return result;
        } catch (Throwable e) {
            LOG.error("Error converting to Pinyin: " + e.getMessage() + " exception name:" + e.getClass().getName());
        }
        //System.out.println(input + " toPinyin2: " + result);
        return input;
    }

    /**
     * 支持多音字处理方法
     * @param input
     * @return
     */
    private static String toPinyin2(String input) {

        //https://www.open-open.com/lib/view/open1392087665067.html
        return ChineseToHanYuPY.convertChineseToPinyin(input);
    }

    private static String toPinyin1(String input) {
        StringBuilder pyb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            char[] pys = Pinyin.toPinyin(ch).toLowerCase().toCharArray();
            if (pys.length > 0) {
                pys[0] = Character.toUpperCase(pys[0]);
                pyb.append(pys);
            }
        }
        return pyb.toString();
    }



    public static void main(String[] args) {
        System.out.println(toPinyin("中国人aaaHHJdsK"));
    }

}
