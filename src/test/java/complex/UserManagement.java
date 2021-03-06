package complex;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class UserManagement {

   WebDriverUtil driverUtil = new WebDriverUtil(null);


    String userManagenment = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div/li[2]/div/span";
    String agentList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div/li[2]/ul/li[3]/span";


     /** 1.进入代理列表，2.获取代理会员数，3.点击跳转会员列表，4.获取会员数
      *
      * */

    String agentListVipNumber = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/section/a/span";
    String agentListVipNumberPage = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("代理列表")
    @Title("验证代理列表会员数数量")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入代理列表，2.获取代理会员数，3.点击跳转会员列表，4.获取会员数")
    @Description("测试代理会员数是否等于会员列表该会员数量")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=17&version=1")
    @Test(priority = 3)
        public void agentVipNumber() throws InterruptedException {
            driverUtil.xpathClick(userManagenment);
            driverUtil.xpathClick(agentList);
            Thread.sleep(1000);
            String getAgentListVipNumber = driverUtil.getTextByXpath(agentListVipNumber);
            System.out.println("验证代理列表会员数数量");
            System.out.println("代理列表会员数："+getAgentListVipNumber);


            driverUtil.xpathClick(agentListVipNumber);
            Thread.sleep(2000);
            String getAgentListVipNumberPage = driverUtil.getTextByXpath(agentListVipNumberPage);
            String agentListVipNumberPage1 = getAgentListVipNumberPage.substring(1,getAgentListVipNumberPage.indexOf("条"));
            System.out.println("点击跳转代理列表会员数："+agentListVipNumberPage1);


            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentListVipNumber, agentListVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /** 1.进入用户管理，2.在线玩家点击提出，3.判断是否提出成功
         *
         * */

    String clickOnlinePlayer = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[4]/a/li/span";
    String shot = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div/section/button/span";
    String sure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String success = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线玩家")
    @Title("验证在线玩家踢出功能")
    @Severity(SeverityLevel.BLOCKER)
    @Step("1.进入用户管理，2.在线玩家点击提出，3.判断是否提出成功")
    @Description("测试踢出玩家功能")
    @Issue("http://10.1.101.66:890/index.php?m=testcase&f=view&caseID=18&version=1")
    @Test(priority = 4)
        public void onlinePlayer() throws InterruptedException {
            driverUtil.switchToParentFrame();//切换表格
            driverUtil.xpathClick(clickOnlinePlayer);
            Thread.sleep(2000);

            driverUtil.xpathClick(shot);
            driverUtil.xpathClick(sure);
            driverUtil.waitForElement(success,5);

            String getSuccess = driverUtil.getTextByXpath(success);
            System.out.println(getSuccess);
            System.out.println("验证在线玩家踢出功能");
            System.out.println("踢出信息："+getSuccess);

            //判断踢出后弹窗文本是否一致
            Assertion.setFlag(true);
            Assertion.verifyEquals(getSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());
        }






}