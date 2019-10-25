package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.utils.PDFUtils;
import com.ruoyi.web.controller.SpringUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jodconverter.DocumentConverter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;





public class BinaryUploader {

	public static final State save(HttpServletRequest request,
			Map<String, Object> conf) {
		// FileItemStream fileStream = null;
		// boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

        // ServletFileUpload upload = new ServletFileUpload(
			// 	new DiskFileItemFactory());
        //
        // if ( isAjaxUpload ) {
        //     upload.setHeaderEncoding( "UTF-8" );
        // }

		try {
			// FileItemIterator iterator = upload.getItemIterator(request);
            //
			// while (iterator.hasNext()) {
			// 	fileStream = iterator.next();
            //
			// 	if (!fileStream.isFormField())
			// 		break;
			// 	fileStream = null;
			// }
            //
			// if (fileStream == null) {
			// 	return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			// }
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile multipartFile = multipartRequest.getFile(conf.get("fieldName").toString());
			if(multipartFile==null){
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}

			String savePath = (String) conf.get("savePath");
			String pdfSavePath = (String) conf.get("savePath");
			String markPdfSavePath = (String) conf.get("savePath");
			//String originFileName = fileStream.getName();
			String originFileName = multipartFile.getOriginalFilename();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0,
					originFileName.length() - suffix.length());
			savePath = savePath + suffix;
			pdfSavePath=pdfSavePath+".pdf";
			markPdfSavePath=markPdfSavePath+".pdf";

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			savePath = PathFormat.parse(savePath, originFileName);
			pdfSavePath=PathFormat.parse(pdfSavePath, originFileName);
			markPdfSavePath=PathFormat.parse(markPdfSavePath, originFileName);

			//String physicalPath = (String) conf.get("rootPath") + savePath;
			String basePath=(String) conf.get("basePath");
			String physicalPath = basePath + savePath;
			String pdfPhysicalPath = basePath + pdfSavePath;
			String markPdfPhysicalPath = basePath + markPdfSavePath;
			//InputStream is = fileStream.openStream();
			InputStream is = multipartFile.getInputStream();
			State storageState = StorageManager.saveFileByInputStream(is,
					physicalPath, maxSize);
			is.close();

			File file = new File(physicalPath);//需要转换的文件
			BufferedOutputStream bos;
			try {
				//文件转化
				DocumentConverter documentConverter = (DocumentConverter) SpringUtil.getBean(DocumentConverter.class);
				File pdfFile = new File(pdfPhysicalPath);
				documentConverter.convert(file).to(pdfFile).execute();
				PDFUtils.addWaterMark(pdfPhysicalPath,markPdfPhysicalPath,"wwww.gsnoc.com");
				FileUtils.deleteFile(pdfPhysicalPath);
				FileUtils.deleteFile(physicalPath);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (storageState.isSuccess()) {
				suffix=".pdf";
				storageState.putInfo("url", PathFormat.format(markPdfSavePath));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		// } catch (FileUploadException e) {
		// 	return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}



}
