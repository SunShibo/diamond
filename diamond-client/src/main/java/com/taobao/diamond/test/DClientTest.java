package com.taobao.diamond.test;
import java.util.concurrent.Executor;
import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;
/**
 * Created by sunshibo on 2016/1/8.
 */

public class DClientTest {
    public static void main(String[] args) {
        // group和dataId为String类型，二者结合为diamond-server端保存数据的惟一key
        String group = "DEFAULT_GROUP";
        String dataId = "testkey";

        // ManagerListener 是客户端注册的数据监听器，能在运行中接受变化的配置数据，
        // 然后回调receiveConfigInfo()方法，执行客户端处理数据的逻辑。
        // 如果要在运行中对变化的配置数据进行处理，就一定要注册ManagerListener
        DiamondManager manager = new DefaultDiamondManager(group, dataId,
                new ManagerListener() {

                    public Executor getExecutor() {
                        return null;
                    }
                    public void receiveConfigInfo(String configInfo) {
                        System.out.println("获取配置信息:"+ configInfo);
                    }
                });
        // 一般的获取信息方法
        String configInfo = manager.getAvailableConfigureInfomation(1000);
        System.out.println("configInfo:" + configInfo);
    }
}


