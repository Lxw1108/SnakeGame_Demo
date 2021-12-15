package com.game.obj;

import com.game.GameWin;

import java.awt.*;

/**
 * @author Liuxiaowei
 * @date 2021年12月10日0:16
 */
public class BodyObj extends GameObj {

    public BodyObj(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
    }

    public BodyObj(Image img, int x, int y, int width, int height, GameWin frame) {
        super(img, x, y, width, height, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}
