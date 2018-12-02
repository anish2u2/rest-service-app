package org.service.app.contracts.services;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public void upload(MultipartFile multipartFile);

	public ByteArrayOutputStream writeFile(String fileName);

	public void cleanFile(String file);

	public void setTempDir(File file );

}
