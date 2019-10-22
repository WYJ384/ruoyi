package com.ruoyi.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

@Controller
@RequestMapping("/simpleJsonController")
public class SimpleJsonController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Map ReturnTest(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Origin", "*");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "200 ok");
        return map;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List Search(HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<String> result = new ArrayList<String>();

        return result;
    }
    //查询
    @RequestMapping("/query")
    @ResponseBody
    public List query(@RequestBody Map<String,Object>  params, HttpServletRequest request, HttpServletResponse response)  {
        List<Map> targetList = (List) params.get("targets");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.ENGLISH);//输入的被转化的时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//需要转化成的时间格式
        LinkedHashMap rangeList = (LinkedHashMap) params.get("range");
        String from ="";
        String to = "";
        try {
            Date fromDate = simpleDateFormat.parse((String) rangeList.get("from"));
            from = df1.format(fromDate);
            Date toDate = simpleDateFormat.parse((String)  rangeList.get("to"));
            to = df1.format(toDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql="";
        for (Map targetMap : targetList){
            sql = (String)targetMap.get("target");
        }

        if(sql.indexOf("${from}")!=-1){
            sql=sql.replace("${from}","'"+from+"'");
        }
        if(sql.indexOf("${to}")!=-1){
            sql=sql.replace("${to}","'"+to+"'");
        }
        List list=new ArrayList();
        Map columnsMap=new HashMap();
        list.add(columnsMap);
        List columnsList=new ArrayList();
        List rowsList=querySql(sql,columnsList);
        columnsMap.put("columns",columnsList);
        columnsMap.put("rows",rowsList);
        columnsMap.put("type","table");
        response.setHeader("Access-Control-Allow-Headers", "accept, content-type");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Accept", "application/json");
        response.setHeader("Content-Type", "application/json");
        return list;
    }

    @Resource
    DataSource dataSource;

    public List querySql(String sql,List columnsList){
        List rowsList=new ArrayList();
        Connection conn=null;
        SybaseConnection sybaseConnection = new SybaseConnection();
        conn = sybaseConnection.getConn();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();// 得到记录集，元素对象。
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                String col_name = rsmd.getColumnName(i + 1);// 获取列名
                Map txtMap1=new HashMap();
                txtMap1.put("text",col_name);
                columnsList.add(txtMap1);
            }

            while (resultSet.next()) {
                List rowsList1=new ArrayList();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String col_name = rsmd.getColumnName(i + 1);// 获取列名
                    if(col_name.toLowerCase().equals("datetime_id")){
                        String date = resultSet.getObject(col_name).toString().replace("T", " ").replace(".000+0000", "");
                        date=date.replace("00.0","00");
                        rowsList1.add(date);
                    }else{
                        rowsList1.add(resultSet.getObject(col_name));
                    }

                }
                rowsList.add(rowsList1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sybaseConnection.close(conn,statement,resultSet);
        }
        return rowsList;
    }

    @RequestMapping("/queryTest")
    @ResponseBody
    public List queryTest() {

        List list=new ArrayList();
        Map columnsMap=new HashMap();
        list.add(columnsMap);
        List columnsList=new ArrayList();
        Map txtMap1=new HashMap();
        txtMap1.put("text","Time");
        txtMap1.put("type","time");
        columnsList.add(txtMap1);

        Map txtMap2=new HashMap();
        txtMap2.put("text","Country");
        txtMap2.put("type","string");
        columnsList.add(txtMap2);

        Map txtMap3=new HashMap();
        txtMap3.put("text","Number");
        txtMap3.put("type","number");
        columnsList.add(txtMap3);
        columnsMap.put("columns",columnsList);


        List rowsList=new ArrayList();
        List rowsList1=new ArrayList();
        rowsList1.add("1234567");
        rowsList1.add("SE");
        rowsList1.add("123");
        rowsList.add(rowsList1);
        List rowsList2=new ArrayList();
        rowsList2.add("1234567");
        rowsList2.add("SE");
        rowsList2.add("123");
        rowsList.add(rowsList2);
        List rowsList3=new ArrayList();
        rowsList3.add("1234567");
        rowsList3.add("SE");
        rowsList3.add("123");
        rowsList.add(rowsList3);
        columnsMap.put("rows",rowsList);


        columnsMap.put("type","table");
        return list;
    }

    public static void main(String[] args) throws ParseException {



        String dateStr = "2019-10-10T06:53:54.134Z";
        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.ENGLISH);//输入的被转化的时间格式
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//需要转化成的时间格式
        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date1 = dff.parse(dateStr);
        String str1 = df1.format(date1);
        String str2 = df2.format(date1);
        System.out.println("str1 is "+str1);
        System.out.println("str2 is "+str2);


    }

        @RequestMapping(value = "/annotations", method = RequestMethod.POST)
    @ResponseBody
    public Map Annotations() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", "200 ok");
        return map;
    }

    private Map<String, Object> strjson() {
        //String str = "{\"A\":{\"tables\":[{\"columns\":[{\"text\":\"序列\",\"sort\":true,\"desc\":true,\"title\":\"序列\",\"style\":{\"alias\":\"\",\"colorMode\":null,\"colors\":[\"rgba(245, 54, 54, 0.9)\",\"rgba(237, 129, 40, 0.89)\",\"rgba(50, 172, 45, 0.97)\"],\"decimals\":2,\"pattern\":\"/.*/\",\"thresholds\":[],\"type\":\"number\",\"unit\":\"short\"},\"hidden\":false,\"$$hashKey\":\"object:644\"},{\"text\":\"水果名称12\",\"title\":\"水果名称12\",\"style\":{\"alias\":\"\",\"colorMode\":null,\"colors\":[\"rgba(245, 54, 54, 0.9)\",\"rgba(237, 129, 40, 0.89)\",\"rgba(50, 172, 45, 0.97)\"],\"decimals\":2,\"pattern\":\"/.*/\",\"thresholds\":[],\"type\":\"number\",\"unit\":\"short\"},\"hidden\":false,\"$$hashKey\":\"object:645\"},{\"text\":\"价钱\",\"title\":\"价钱\",\"style\":{\"alias\":\"\",\"colorMode\":null,\"colors\":[\"rgba(245, 54, 54, 0.9)\",\"rgba(237, 129, 40, 0.89)\",\"rgba(50, 172, 45, 0.97)\"],\"decimals\":2,\"pattern\":\"/.*/\",\"thresholds\":[],\"type\":\"number\",\"unit\":\"short\"},\"hidden\":false,\"$$hashKey\":\"object:646\"},{\"text\":\"重量（kg）\",\"title\":\"重量（kg）\",\"style\":{\"alias\":\"\",\"colorMode\":null,\"colors\":[\"rgba(245, 54, 54, 0.9)\",\"rgba(237, 129, 40, 0.89)\",\"rgba(50, 172, 45, 0.97)\"],\"decimals\":2,\"pattern\":\"/.*/\",\"thresholds\":[],\"type\":\"number\",\"unit\":\"short\"},\"hidden\":false,\"$$hashKey\":\"object:647\"},{\"text\":\"总价钱\",\"title\":\"总价钱\",\"style\":{\"alias\":\"\",\"colorMode\":null,\"colors\":[\"rgba(245, 54, 54, 0.9)\",\"rgba(237, 129, 40, 0.89)\",\"rgba(50, 172, 45, 0.97)\"],\"decimals\":2,\"pattern\":\"/.*/\",\"thresholds\":[],\"type\":\"number\",\"unit\":\"short\"},\"hidden\":false,\"$$hashKey\":\"object:648\"}],\"rows\":[[1,\"水果01\",4,2,8],[2,\"水果02\",5,2,10],[3,\"水果03\",6,2,12],[4,\"水果04\",7,2,14],[5,\"水果05\",8,2,16]]}]}}";
        Map<String, Object> map = new HashMap<>();
        JSONArray ja = new JSONArray();
        for (int i = 0; i < 10; i++) {
            JSONObject jb = new JSONObject();
            jb.put("num", 10*i);
            jb.put("createTime", "2019-05-09T"+(11+i)+":01:01");
            ja.add(jb);
        }
        map.put("results", ja);
        return map;
    }
}
