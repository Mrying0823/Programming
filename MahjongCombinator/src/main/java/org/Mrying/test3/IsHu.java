package org.Mrying.test3;

import java.util.ArrayList;

public class IsHu {
    public boolean hu(ArrayList<Integer> tiles,Boolean hasHead) {

        boolean isHu = false;

        // 非空判断
        // 如果 tiles 列表为空，即没有剩余的手牌了
        // 那么可以认为这是一种有效的和牌方式，因此返回 true，表示可以和牌。
        if(tiles.size() == 0) {
            return true;
        }

        // 11
        if(!hasHead) {
            ArrayList<Integer> temp = new ArrayList<>(tiles);

            if(temp.get(0).equals(temp.get(1))) {
                temp.remove(1);
                temp.remove(0);

                // 递归
                if(hu(temp,true)) {
                    isHu = true;
                }
            }
        }

        // 123 顺子
        if(tiles.size() >= 3) {
            ArrayList<Integer> temp = new ArrayList<>(tiles);

            int a = temp.get(0);
            int b = a+1;
            int c = a+2;

            int index_b = tiles.indexOf(b);
            int index_c = tiles.indexOf(c);

            if(index_b > 0 && index_c > 0) {
                temp.remove(index_c);
                temp.remove(index_b);
                temp.remove(0);

                if(hu(temp,hasHead)) {
                    isHu = true;
                }
            }
        }

        // 111 刻子
        if(tiles.size() >= 3) {
            ArrayList<Integer> temp = new ArrayList<>(tiles);

            int a = temp.get(0);
            int b = temp.get(1);
            int c = temp.get(2);

            if(a == b && b == c) {
                temp.remove(2);
                temp.remove(1);
                temp.remove(0);

                if (hu(temp, hasHead)) {
                    isHu = true;
                }
            }
        }

        return isHu;
    }
}
