package com.ruoyi.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Controller
@RequestMapping("/testController")
public class TestController {


    @RequestMapping("/toIndex")
    @ResponseBody
    public String toIndex(String pathName)  {

        File file = new File(pathName);
        URLClassLoader classloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method add = null;
        try {
            add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
            add.setAccessible(true);
            add.invoke(classloader, new Object[]{file.toURI().toURL()});
            Class c = classloader.loadClass("Test");
            Object o = c.newInstance();
            Method m = c.getDeclaredMethod("getString");
            m.invoke(o, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return "/ueditor";
    }

    @GetMapping("/compile")
    @ResponseBody
    public Integer compile(String javaFile){
        String srcPath="D:\\project\\gsnocOfficeSys\\ruoyi-admin\\src\\main\\java\\com\\ruoyi\\web\\controller\\";
        String destPath="D:\\project\\gsnocOfficeSys\\ruoyi-admin\\target\\classes\\com\\ruoyi\\web\\controller\\";

        JavaCompiler javac;
        System.out.println("66666666666666666666666");
        javac = ToolProvider.getSystemJavaCompiler();

        int compilationResult = javac.run(null,null,null, "-g","-verbose",srcPath+javaFile+".java");
        File srcFile=new File(srcPath+javaFile+".class");
        File destFile=new File(destPath+javaFile+".class");
        try {
            FileUtils.forceDelete(destFile);
            FileUtils.moveFile(srcFile,destFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return compilationResult;
    }
}
