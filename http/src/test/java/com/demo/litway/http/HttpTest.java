package com.demo.litway.http;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.demo.litway.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Litway
 * @version 1.0
 */
@SpringBootTest
public class HttpTest {

    private String url = "http://172.31.151.142/dev-api/system/user/list?pageNum=1&pageSize=10";

    private String kingUrl = "http://10.1.9.43/k3cloud/Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery.common.kdsvc";

    private String webApiLogin = "http://10.1.9.43/k3cloud/Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc";

    private String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2tleSI6ImNlZTg1N2M2LTI5OTktNGY3Zi1hNTg3LTMxNTcwZjY2MTMwYiIsInVzZXJuYW1lIjoiYWRtaW4ifQ.7Z4EhyrqWB-4yobrHoY8LGu0oH9Y4RGfD0aC0XV7vZPNiTrBihZmQMEvkjRJkv_4-7hEIb5yM0gYjWRi9paeoA";

    private String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";

    /**
     * 测试http请求
     */
    @Test
    public void testHttp() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("pageNum", 1);
        query.put("pageSize", 10);

        String body = HttpRequest.get(url)
                .header("Authorization", token)
                .header("User-Agent", ua)
                .execute().body();

        System.out.println(JSONUtil.toJsonPrettyStr(body));
    }

    /**
     * 测试实体类转换json字符串
     */
    @Test
    public void testJson() {
        UserQuery userQuery = new UserQuery();
        userQuery.setPageNum(1);
        userQuery.setPageSize(10);

        String json = JSONUtil.toJsonStr(userQuery);
        System.out.println(json);

        String prettyJson = JSONUtil.toJsonPrettyStr(userQuery);
        System.out.println(prettyJson);

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));

        System.out.println(s);
    }

    /**
     * 测试创建查询对象
     */
    @Test
    public void testQuery() {
        OrderParams orderParams = new OrderParams();
        OrderQuery orderQuery = new OrderQuery();
        orderParams.setFormId("order");

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        orderParams.setFieldKeys(s);

        orderParams.setTopRowCount(10);
        orderParams.setLimit(10);
        orderParams.setStartRow(0);
        orderParams.setFilterString("");
        orderParams.setOrderString("");

        ArrayList<OrderParams> params = new ArrayList<>();
        params.add(orderParams);
        orderQuery.setParameters(params);

        String json = JSONUtil.toJsonPrettyStr(orderQuery);
        System.out.println(json);
    }

    /**
     * 测试登录接口
     */
    @Test
    public void testApi() {
        OrderParams orderParams = new OrderParams();
        orderParams.setFormId("order");

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        orderParams.setFieldKeys(s);

        orderParams.setTopRowCount(10);
        orderParams.setStartRow(0);

        String json = JSONUtil.toJsonStr(orderParams);

        String body = HttpRequest.post(kingUrl)
                .header(Header.ACCEPT_ENCODING, "gzip, deflate, br")
                .header(Header.CONTENT_TYPE, "text/json")
                .header(Header.COOKIE, "ASP.NET_SessionId=edkceb4y0s4cjqcy5jwfry43; Theme=standard; kdservice-sessionid=a3b2f7a5-76c3-4e3b-b6b8-2e329f8ef8c9")
                .header("Csrf-Token", "R0xqSGl5JjNhMWQ1N2MzYzVhMjRlMjUmMTY4NDQ4ODM5MzU3Mg==")
                .header("Kdbiz-Info", "{\"m\":\"MainBarItemClick\",\"t\":\"SAL_SaleOrder\",\"s\":\"ListService\"}")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                .body(json)
                .execute().body();
        System.out.println(body);
    }

    /**
     * 测试查询接口
     */
    @Test
    public void testGet() {
        HashMap<String, Object> paramMap = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("fcusid");
        list.add("fnumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        paramMap.put("FieldKeys", s);

        String s1 = HttpUtil.get(kingUrl, paramMap);
        System.out.println(s1);

    }

    /**
     * 测试登录接口
     */
    @Test
    public void testWebApiLogin() {
        LoginQuery loginQuery = new LoginQuery();
        loginQuery.setAcctId("6466e44dde6a23");
        loginQuery.setUsername("Administrator");
        loginQuery.setPassword("123456Aa!");
        loginQuery.setLcid(2052);

        OrderParams orderParams = new OrderParams();
        OrderQuery orderQuery = new OrderQuery();
        orderParams.setFormId("SAL_SaleOrder");

        ArrayList<String> list = new ArrayList<>();
        list.add("FID");
        list.add("FSaleOrderEntry_FEntryID");
        list.add("FBillNo");
        list.add("FMaterialId.Fnumber");
        list.add("FMaterialName");
        list.add("FCreatorId.FName");
        list.add("FModifierId.FName");
        list.add("FModifyDate");
        list.add("FApproverId.FName");
        list.add("FApproveDate");
        list.add("FBaseUnitId.FNumber");
        String s = list.stream().map(Object::toString).collect(Collectors.joining(","));
        orderParams.setFieldKeys(s);

        orderParams.setTopRowCount(10);
        orderParams.setLimit(10);
        orderParams.setStartRow(0);
        orderParams.setFilterString("");
        orderParams.setOrderString("");

        ArrayList<OrderParams> params = new ArrayList<>();
        params.add(orderParams);
        orderQuery.setParameters(params);

        String orderQueryJson = JSONUtil.toJsonPrettyStr(orderQuery);
        System.out.println(orderQueryJson);

        String loginQueryJson = JSONUtil.toJsonStr(loginQuery);

        /* System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dj-vpn03", "DJ@123456".toCharArray());
            }
        });
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("60.30.84.218", 11443)); */

        HttpResponse loginResponse = HttpRequest.post(webApiLogin).body(loginQueryJson).execute();
        loginResponse.close();
        String post = loginResponse.body();
        System.out.println(post);

        LoginResponse bean = JSONUtil.toBean(post, LoginResponse.class);

        if (bean.getLoginResultType().equals(1)) {
            System.out.println("登陆成功");
            HttpResponse queryResponse = HttpRequest.post(kingUrl)
                    .cookie(loginResponse.getCookies())
                    .body(orderQueryJson)
                    .execute();
            String body = queryResponse.body();
            System.out.println(body);

            String substring = body.substring(1, body.length() - 1);
            String substring1 = substring.substring(1, substring.length() - 1);
            List<String> split = Arrays.asList(substring1.split("],\\["));
            List<List<Object>> collect = split.stream().map(item -> {
                return Convert.convert(new TypeReference<List<Object>>() {}, item);
            }).collect(Collectors.toList());

            List<OrderQueryResponse> orderQueryResponseList = split.stream().map(item -> {
                OrderQueryResponse orderQueryResponse = new OrderQueryResponse();
                orderQueryResponse.setOrderItems(Convert.convert(new TypeReference<List<Object>>() {
                }, item));
                return orderQueryResponse;
            }).collect(Collectors.toList());

            System.out.println(split);
        }

    }

    @Test
    public void testJsonToBean() {
        LoginQuery loginQuery = new LoginQuery();
        loginQuery.setAcctId("6466e44dde6a23");
        loginQuery.setUsername("Administrator");
        loginQuery.setPassword("123456Aa!");
        loginQuery.setLcid(2052);

        String str = JSONUtil.toJsonStr(loginQuery);
        System.out.println(str);

        LoginQuery bean = JSONUtil.toBean(str, LoginQuery.class);
        System.out.println(bean);
    }

    @Test
    public void testSplit() {
        String str = "[[100004],[100004,\"XSDD000001\",\"C01半羊毛-0001\",\"平机半羊毛\",\"周艳姣\",\"周艳姣\",\"2023-05-19T17:10:10.92\",\"周艳姣\",\"2023-05-19T17:12:13.263\",\"m\"],[100005,100005,\"XSDD000002\",\"C01超细-0001\",\"平机超细白\",\"周艳姣\",\"周艳姣\",\"2023-05-26T11:12:41.59\",null,null,\"m\"],[100005,100008,\"XSDD000002\",\"C01半羊毛-0001\",\"平机半羊毛\",\"周艳姣\",\"周艳姣\",\"2023-05-26T11:12:41.59\",null,null,\"m\"],[100006,100006,\"XSDD000003\",\"C01半羊毛-0001\",\"平机半羊毛\",\"周艳姣\",\"周艳姣\",\"2023-05-26T10:50:23.883\",null,null,\"m\"],[100006,100007,\"XSDD000003\",\"C01超细-0001\",\"平机超细白\",\"周艳姣\",\"周艳姣\",\"2023-05-26T10:50:23.883\",null,null,\"m\"]]";
        String substring = str.substring(1, str.length() - 1);
        String substring1 = substring.substring(1, substring.length() - 1);
        List<String> split = Arrays.asList(substring1.split("],\\["));
        System.out.println(split);
    }

    @Test
    public void testConvert() {
        String str = "[100004,100004,\"XSDD000001\",\"C01半羊毛-0001\",\"平机半羊毛\",\"周艳姣\",\"周艳姣\",\"2023-05-19T17:10:10.92\",\"周艳姣\",\"2023-05-19T17:12:13.263\",\"m\"],[100005,100005,\"XSDD000002\",\"C01超细-0001\",\"平机超细白\",\"周艳姣\",\"周艳姣\",\"2023-05-26T11:12:41.59\",null,null,\"m\"],";
        Object[] a = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, a);
        // 从4.1.11开始可以这么用
        List<?> list1 = Convert.toList(a);

        List<String> convert = Convert.convert(new TypeReference<List<String>>() {}, a);
        System.out.println(convert);
    }

}
