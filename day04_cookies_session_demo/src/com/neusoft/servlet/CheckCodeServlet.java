package com.neusoft.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author liuboting
 * @date 2020/8/28 16:33
 */
@WebServlet("/checkCodeServlet1")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //验证码图片
        int width = 100;
        int height = 50;
        //创建一个图片验证码对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        Graphics graphics = image.getGraphics(); // 画笔
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);

        //画边框
        graphics.setColor(Color.RED);
        graphics.drawRect(0,0,width-1,height-1);
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";

        //随机选index
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <=4 ; i++) {
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            sb.append(c);
            //写验证码
            graphics.drawString(c+"",width/5*i,height/2);
        }

        //将验证码存入session
        req.getSession().setAttribute("checkCode_session",sb.toString());

        //画干扰线
        graphics.setColor(Color.yellow);
        //随机生成坐标
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //将图片输出到页面中
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
