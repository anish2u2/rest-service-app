package org.service.app.contracts.services;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public void upload(MultipartFile multipartFile);

	public void writeFile(OutputStream outputStream,String fileName);

	public void cleanFile(String file);

	public void setTempDir(File file );

}
