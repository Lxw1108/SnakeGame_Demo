package com.game;

import com.game.obj.BodyObj;
import com.game.obj.FoodObj;
import com.game.obj.HeadObj;
import com.game.util.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuxiaowei
 * @date 2021年12月08日21:02
 * <p>
 * extends : 可以监听鼠标事件
 */
public class GameWin extends JFrame {

    //蛇头对象
    public HeadObj headObj = new HeadObj(GameUtils.rightImg, 90, 210, this);

    //蛇身的集合
    public List<BodyObj> bodyObjList = new ArrayList<BodyObj>();

    //食物
    public FoodObj foodObj = new FoodObj().getFood();



    //启动配置
    public void launch() {
        //设置窗口是否可见   默认不可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(600, 600);
        //设置窗口的位置在屏幕的中心
        this.setLocationRelativeTo(null);
        //设置窗口的标题
        this.setTitle("小游戏Demo-贪吃蛇");

        //蛇身初始化
        bodyObjList.add(new BodyObj(GameUtils.bodyImg, 60, 210, this));
        bodyObjList.add(new BodyObj(GameUtils.bodyImg, 30, 210, this));


        //一直运动
        while (true) {
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * paint 描绘窗口方法，设置颜色
     * @author Liuxiaowei
     * @date 2021/12/8 21:12
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        //灰色背景
        g.setColor(Color.gray);
        //填充矩形     绘制网格线
        g.fillRect(0, 0, 600, 600);
        //绘制网格线
        g.setColor(Color.black);
        Integer x = 20;
        Integer y = 20;
        //绘制横竖线
        for (int i = 0; i <= x; i++) {
            g.drawLine(0, i * 30, 600, i * 30);
            g.drawLine(i * 30, 0, i * 30, 600);
        }

        //绘制蛇身体
        for (int i = bodyObjList.size()-1; i >= 0; i--) {
            bodyObjList.get(i).paintSelf(g);
        }

        //绘制蛇头
        headObj.paintSelf(g);

        //绘制食物
        foodObj.paintSelf(g);

//        super.paint(g);
    }

    //启动游戏
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }


}
