package com.ruoyi.utils;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.*;

import java.awt.*;
import java.io.FileOutputStream;

public class PDFUtils {


    /**
     * 【功能描述：添加图片和文字水印】 【功能详细描述：功能详细描述】
     *
     * @param srcFile    待加水印文件
     * @param destFile   加水印后存放地址
     * @param text       加水印的文本内容
     * @throws Exception
     */
    public static void addWaterMark(String srcFile, String destFile, String text) throws Exception {
        // 待加水印的文件
        PdfReader reader = new PdfReader(srcFile);
        // 加完水印的文件
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                destFile));
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
        // 设置字体
        BaseFont font = BaseFont.createFont();
        // 设置水印透明度
        PdfGState gs = new PdfGState();
        // 设置填充字体不透明度为0.4f
        gs.setFillOpacity(0.4f);
        stamper.setEncryption(null, null,
                PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        // 循环对每页插入水印
        for (int i = 1; i < total; i++) {
            // 水印的起始
            content = stamper.getUnderContent(i);
            // 开始
            content.beginText();
            // 设置水印字体参数及大小                                  (字体参数，字体编码格式，是否将字体信息嵌入到pdf中（一般不需要嵌入），字体大小)
            content.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 60);
            // 设置透明度
            content.setGState(gs);
            // 设置字体及字号
            content.setFontAndSize(font, 38);
            // 设置水印对齐方式 水印内容 X坐标 Y坐标 旋转角度
            content.showTextAligned(Element.ALIGN_CENTER, text , 300, 430, 45);
            // 设置水印颜色
            content.setColorFill(Color.LIGHT_GRAY);
            //结束设置
            content.endText();
            content.stroke();
        }
        stamper.close();
    }
}
