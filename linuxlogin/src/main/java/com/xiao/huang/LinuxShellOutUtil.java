/*
package com.xiao.huang;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.migu.springcloud.entities.DataBase;
import java.io.InputStream;
import java.util.HashMap;


*/
/**
 * java 登录linux系统，并读取执行shell命令结果
 *
 * @author zyb
 * 2020-07-06
 *//*

public class LinuxShellOutUtil {     //其他Linux机器执行脚本工具类   需要账号密码等信息

    private static Session session;
public Boolean connectTest(DataBase dataBase){        //连接检测
    try {
        JSch jsch = new JSch();
        session = jsch.getSession(dataBase.getUserName(), dataBase.getUrl(), Integer.parseInt(dataBase.getPort()));
        session.setPassword(dataBase.getPassWord());
        // 设置第一次登陆的时候提示，可选值:(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        // 连接超时
        session.connect(1000 * 10);
        if (session.isConnected()){
            session.disconnect();
        }

          return true;
    } catch (JSchException e) {
        if (session.isConnected()){
            session.disconnect();
        }
        e.printStackTrace();
           return false;

    }

}

public HashMap getData(DataBase dataBase,String sql){  //连接后获取脚本执行结果和数据
    HashMap hashMap=new HashMap();
    try {
        JSch jsch = new JSch();
        session = jsch.getSession(dataBase.getUserName(), dataBase.getUrl(), Integer.parseInt(dataBase.getPort()));
        session.setPassword(dataBase.getPassWord());
        // 设置第一次登陆的时候提示，可选值:(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        // 连接超时
        session.connect(10000 * 10);
        byte[] tmp = new byte[1024];
        // 命令返回的结果
        StringBuffer resultBuffer = new StringBuffer();
        Channel channel = session.openChannel("exec");
        ChannelExec exec = (ChannelExec) channel;
        // 返回结果流（命令执行错误的信息通过getErrStream获取）
        InputStream stdStream = exec.getErrStream();
        exec.setCommand(sql);
        exec.connect();
        try {
            // 开始获得SSH命令的结果
            while (true) {
                while (stdStream.available() > 0) {
                    int i = stdStream.read(tmp, 0, 1024);
                    if (i < 0) break;
                    resultBuffer.append(new String(tmp, 0, i));
                }
                if (exec.isClosed()) {
//					System.out.println(resultBuffer.toString());
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            //关闭连接
            channel.disconnect();
        }
       // return resultBuffer.toString();

        hashMap.put("type", 3);
        hashMap.put("error",resultBuffer.toString());
        hashMap.put("msg", "执行成功");

        return hashMap;
    } catch (Exception e) {
        hashMap.put("type", 3);
        hashMap.put("error",e.toString());
        hashMap.put("msg", "执行失败");
        e.printStackTrace();
        return hashMap;

    }finally {
        if (session.isConnected()){
            session.disconnect();
        }
    }

}


    */
/**
     * 关闭连接
     *//*

    public static void close() {
        if (session.isConnected())
            session.disconnect();
    }

    */
/**
     * 测试
     *
     * @param args
     *//*

    public static void main(String[] args) {

        String ip = "";
        String username = "";
        String password = "";   
        DataBase dataBase=new DataBase();  //  连接数据类
        dataBase.setUserName(username);
        dataBase.setPassWord(password);
        dataBase.setUrl(ip);
        dataBase.setPort("22");
        LinuxShellOutUtil linux = new LinuxShellOutUtil();

        System.out.println(linux.getData(dataBase,"mkdir zx"));

    }
}


*/
