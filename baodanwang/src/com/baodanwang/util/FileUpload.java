package com.baodanwang.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	private MultipartFile file;
	private String fileName;
	private String filePath;

	public FileUpload(MultipartFile file, String fileName, String filePath) {
		this.file = file;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public String fileUpload() {
		File targetFile = new File(filePath,fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String path = "/upload/" + fileName;
		return path;
	}
}