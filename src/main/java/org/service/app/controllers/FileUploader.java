package org.service.app.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.app.annotations.Controller;
import org.service.app.annotations.Get;
import org.service.app.annotations.Post;
import org.service.app.logger.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploader {
	
	private static MultipartFile multiPartFile;

	@Post(value = "/upload.html")
	public String upload(@RequestParam("file") MultipartFile file) {
		Logger.info("File uploading");
		this.multiPartFile = file;
		Logger.info("Uploaded..");
		return "uploadSuccess";
	}

	@Get(value = "/download.html")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) throws IOException {
		Logger.info("Now downloading file..");
		if (fileName != null) {
			response.setContentType(this.multiPartFile.getContentType());
			response.setHeader("Content-Disposition",
					String.format("attachment; filename=\"%s\"", multiPartFile.getName()));
			response.getOutputStream().write(this.multiPartFile.getBytes());
			response.flushBuffer();
		}
	}

	@Get(value = "/deleteFile.html")
	public void deleteFile() {
		this.multiPartFile = null;
	}

}
