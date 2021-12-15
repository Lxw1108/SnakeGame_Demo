package com.game.obj;

import com.game.GameWin;
import com.game.util.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @author Liuxiaowei
 * @date 2021年12月09日1:47
 */
public class HeadObj extends GameObj{
    //方向 up down left right
    private String direction = "right";

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public HeadObj(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
        //鍵盤監聽事件
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changDirection(e);
//                super.keyPressed(e);
            }
        });
    }

    //控制蛇头移动方向   awsd控制方向
    public void changDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A: {
                if (!"right".equals(direction)) {
                    direction = "left";
                    img = GameUtils.leftImg;
                }
                break;
            }
            case KeyEvent.VK_D: {
                if (!"left".equals(direction)) {
                    direction = "right";
                    img = GameUtils.rightImg;
                }
                break;
            }
            case KeyEvent.VK_W: {
                if (!"down".equals(direction)) {
                    direction = "up";
                    img = GameUtils.upImg;
                }
                break;
            }
            case KeyEvent.VK_S: {
                if (!"up".equals(direction)) {
                    direction = "down";
                    img = GameUtils.downImg;
                }
                break;
            }
            default:
                break;
        }
    }

    //蛇的移动
    public void move() {
        //蛇身移动   ----!!!必须写在蛇头移动之前
        List<BodyObj> bodyObjList = this.frame.bodyObjList;
        for (int i = 1; i < bodyObjList.size(); i++) {
            bodyObjList.get(i).x = bodyObjList.get(i - 1).x;
            bodyObjList.get(i).y = bodyObjList.get(i - 1).y;
        }
        bodyObjList.get(0).x = this.x;
        bodyObjList.get(0).y = this.y;

        //蛇头移动
        switch (direction) {
            case "up": {
                y -= height;
                break;
            }
            case "down":{
                y += height;
                break;
            }
            case "left":{
                x -= width;
                break;
            }
            case "right":{
                x += width;
                break;
            }
        }
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //食物  蛇吃食物和食物重新放置位置处理    ！！注意要写在move()移动方法之前
        FoodObj food = this.frame.foodObj;
        if (this.x == food.x && this.y == food.y) {
            // 重新放置食物位置 并且 添加一条蛇身
            this.frame.foodObj = food.getFood();
            this.frame.bodyObjList.add(new BodyObj(GameUtils.bodyImg, 30, 210, this.frame));

        }

        move();
        //越界处理
        if (x < 0) {
            x = 570;
        } else if (x > 570) {
            x = 0;
        } else if (y < 30) {
            y = 570;
        } else if(y>570) {
            y = 30;
        }

    }
}
