import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.GmsCatalogAttr;
import com.service.LoginService;
import com.service.TestService;
import com.util.HttpUtils;
import com.util.ImageUtil;
import com.util.SendCodeUtil;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
 * @author 肖宏武
 * @date 2020/3/20 - 13:26
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService testServiceImpl = context.getBean("TestServiceImpl", TestService.class);
        List<GmsCatalogAttr> attrByCatalogId = testServiceImpl.getAttrByCatalogId(1);

        for (GmsCatalogAttr gmsCatalogAttr : attrByCatalogId) {
            System.out.println(gmsCatalogAttr);
        }
    }

    @Test
    public void sentCode(){
        /*String host = "http://yzxyzm.market.alicloudapi.com";
        String path = "/yzx/verifySms";
        String method = "POST";
        String appcode = "5aae77ff128a48d6b78d44b6471a046f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", "18373329760");
        querys.put("templateId", "TP18040314");
        querys.put("variable", "code:1234");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            *//**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             *//*
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        SendCodeUtil sendCodeUtil = new SendCodeUtil();
        sendCodeUtil.sendCode("18373329760");
    }

    @Test
    public void test2(){
       /* UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-","");
        System.out.println(id);*/

        String js ="{\"uniqueCode\":\"OTTCD015\",\"terminalBrandCode\":\"10\",\"equipmentBrand\":\"夏普\"}";
        JSONObject jsonObj = JSON.parseObject(js);
        System.out.println(jsonObj.get("uniqueCode"));
        String jsonData = "[{'attrId':'1','attrValue':'红色'}{'attrId':'2','attrValue':'130cm'}]";
        JSONArray jsonArray = JSON.parseArray(jsonData);
        for (int i=0;i<jsonArray.size();i++){
            JSONObject obj=jsonArray.getJSONObject(i);
            String attrId = obj.getString("attrId");
            System.out.println(attrId);
        }
    }

    @Test
    public void test3(){
        Calendar cal = Calendar.getInstance();
        LocalDate localDate = LocalDate.now();
        cal.setTime(new Date());
        Month month = localDate.getMonth();
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(localDate.getMonthValue());

    }

    @Test
    public void test4(){
        String date = "2019-01-01 00:00:00";
        Date dt = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            dt =format.parse(date);
            System.out.println(dt.getYear());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        System.out.println(cal.get(Calendar.YEAR));
        cal.setTime(dt);
        System.out.println(cal.get(Calendar.YEAR));
    }
}
