package com.ruoyi.web.controller;

import com.ruoyi.worktask.domain.WorkTask;
import com.ruoyi.worktask.service.IWorkTaskService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jodconverter.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/testController")
public class TestController {
    @Autowired
    private MsgSendService msgSendService;
    @Autowired
    private
    IWorkTaskService workTaskService;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private DocumentConverter converter;



    @RequestMapping("/testMsg")
    @ResponseBody
    public void testMsg() {
        msgSendService.send("12312312", new String[]{"17739916492"});
    }


    @RequestMapping("/selectNoTargetWorkList")
    @ResponseBody
    public  List<WorkTask>  selectNoTargetWorkList() {
        WorkTask workTask = new WorkTask();
        workTask.setTargetMonth(DateFormatUtils.format(new Date(),"MM"));
        List<WorkTask> workTasks = workTaskService.selectNoTargetWorkList(workTask);
        return workTasks;
    }

//    @RequestMapping("/toIndex")
//    @ResponseBody
//    public String toIndex(String pathName)  {
//
//        File file = new File(pathName);
//        URLClassLoader classloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
//        Method add = null;
//        try {
//            add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
//            add.setAccessible(true);
//            add.invoke(classloader, new Object[]{file.toURI().toURL()});
//            Class c = classloader.loadClass("Test");
//            Object o = c.newInstance();
//            Method m = c.getDeclaredMethod("getString");
//            m.invoke(o, null);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        return "/ueditor";
//    }
//
//    @GetMapping("/compile")
//    @ResponseBody
//    public Integer compile(String javaFile){
//        String srcPath="D:\\project\\gsnocOfficeSys\\ruoyi-admin\\src\\main\\java\\com\\ruoyi\\web\\controller\\";
//        String destPath="D:\\project\\gsnocOfficeSys\\ruoyi-admin\\target\\classes\\com\\ruoyi\\web\\controller\\";
//
//        JavaCompiler javac;
//        System.out.println("66666666666666666666666");
//        javac = ToolProvider.getSystemJavaCompiler();
//
//        int compilationResult = javac.run(null,null,null, "-g","-verbose",srcPath+javaFile+".java");
//        File srcFile=new File(srcPath+javaFile+".class");
//        File destFile=new File(destPath+javaFile+".class");
//        try {
//            FileUtils.forceDelete(destFile);
//            FileUtils.moveFile(srcFile,destFile);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return compilationResult;
//    }
//
//    public static void main(String[] args){
//        System.out.println("d是是是");
//    }
//
    @RequestMapping("toPdfFile")
    public String toPdfFile() {
        File file = new File("G:\\智慧校园一卡通PPT1.2.ppt");//需要转换的文件
        try {
            File newFile = new File("G:/obj-pdf");//转换之后文件生成的地址
            if (!newFile.exists()) {
                newFile.mkdirs();
            }
            //文件转化
            converter.convert(file).to(new File("G:/obj-pdf/hello.pdf")).execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "This is to pdf";
    }

}
