package org.Mrying.test;

/**
 * @author 邓和颖
 */
public class ValidatingString {

    private String delete(String str,int i) {
        // 先截取 AA，再截取 B
        // 两个参数截取的结果,不包括结束位置的字符
        // 一个参数从起始位置至字符串末尾的字符串
        return str.substring(0,i) + str.substring(i+1);
    }

    public String validate(String str) {

        // 如果字符串为空或者长度小于等于 2（至少为 3 个字符）无需校验
        if(str == null || str.length() <= 2) {
            return str;
        }

        for(int i = 0;i < str.length()-3;i++) {
            // 长度减 3 是为了防止字符串长度越界

            // AABB 式
            if (str.charAt(i) == str.charAt(i+1) && str.charAt(i+2) == str.charAt(i+3)) {
                // 截取为 AAB 式
                str = delete(str,i+2);
                i--;
            }else if (str.charAt(i) == str.charAt(i+1) && str.charAt(i+1) == str.charAt(i+2)) {
                str = delete(str,i+2);
                i--;
            }
        }

        int l = str.length();

        // 对于结尾可能有 AAA 形式的情况
        if(str.charAt(l-1) == str.charAt(l-2) && str.charAt(l-2) == str.charAt(l-3)) {
            str = delete(str,l-1);
        }

        return str;
    }
}
