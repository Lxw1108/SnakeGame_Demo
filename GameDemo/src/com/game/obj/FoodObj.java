package com.game.obj;

import com.game.GameWin;
import com.game.util.GameUtils;

import java.awt.*;
import java.security.PublicKey;
import java.util.Random;

/**
 * @author Liuxiaowei
 * @date 2021年12月10日0:45
 */
public class FoodObj extends GameObj {

    //随机函数
    public Random random = new Random();

    public FoodObj() {
        super();
    }

    public FoodObj(Image img, int x, int y, int width, int height, GameWin frame) {
        super(img, x, y, width, height, frame);
    }

    public FoodObj(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }

    //获取随机食物位置
    public FoodObj getFood() {
        //注意食物的x:0-570    y是要在30 - 570之间
        return new FoodObj(GameUtils.foodImg, random.nextInt(20) * 30, ((random.nextInt(19)+1)*30),this.frame);
    }

}
