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
        // group��dataIdΪString���ͣ����߽��Ϊdiamond-server�˱������ݵ�Ωһkey
        String group = "DEFAULT_GROUP";
        String dataId = "testkey";

        // ManagerListener �ǿͻ���ע������ݼ����������������н��ܱ仯���������ݣ�
        // Ȼ��ص�receiveConfigInfo()������ִ�пͻ��˴������ݵ��߼���
        // ���Ҫ�������жԱ仯���������ݽ��д�����һ��Ҫע��ManagerListener
        DiamondManager manager = new DefaultDiamondManager(group, dataId,
                new ManagerListener() {

                    public Executor getExecutor() {
                        return null;
                    }
                    public void receiveConfigInfo(String configInfo) {
                        System.out.println("��ȡ������Ϣ:"+ configInfo);
                    }
                });
        // һ��Ļ�ȡ��Ϣ����
        String configInfo = manager.getAvailableConfigureInfomation(1000);
        System.out.println("configInfo:" + configInfo);
    }
}


