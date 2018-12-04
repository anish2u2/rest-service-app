package org.service.app.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.app.annotations.Controller;
import org.service.app.annotations.Get;
import org.service.app.annotations.Inject;
import org.service.app.annotations.Post;
import org.service.app.contracts.services.FileService;
import org.service.app.logger.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploader {

	public static String tempDir = "temp";

	@Inject
	private FileService fileService;

	public FileUploader() {
		checkDirectory();
	}

	private File checkDirectory() {
		try {
			File temp = new File(tempDir);
			if (!temp.exists()) {
				temp.mkdirs();
				fileService.setTempDir(temp);
				Logger.info("Directory created.");
			} else {
				Logger.info("Directory alreday Exists.");
			}
			Logger.info(temp.getAbsolutePath());
			Logger.info(temp.getPath());
			Logger.info(temp.getCanonicalPath());
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Post(value = "/upload.html")
	public String upload(@RequestParam("file") MultipartFile file) {
		Logger.info("File uploading");
		// this.multiPartFile = file;
		fileService.upload(file);
		Logger.info("Uploaded..");
		return "uploadSuccess";
	}

	@Get(value = "/download.html")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response,

			@RequestParam("fileName") String fileName) throws IOException {
		Logger.info("Now downloading file.." + fileName);
		if (fileName != null) {
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", fileName));
			// response.getOutputStream().write(fileService.writeFile(fileName));
			fileService.writeFile(response.getOutputStream(), fileName);
			// response.flushBuffer();
		}
	}

	@Get(value = "/deleteFile.html")
	public void deleteFile() {
		// this.multiPartFile = null;
	}

}
