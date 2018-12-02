package org.service.app.services.file;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.service.app.annotations.Bean;
import org.service.app.annotations.Inject;
import org.service.app.annotations.Qualifier;
import org.service.app.contracts.services.FileService;
import org.service.app.contracts.services.WorkersManager;
import org.service.app.controllers.FileUploader;
import org.service.app.logger.Logger;
import org.service.app.works.FileWriterWork;
import org.springframework.web.multipart.MultipartFile;

@Bean
public class FilesService implements FileService {

	private File dir;

	// @Inject
	// @org.springframework.beans.factory.annotation.Qualifier("manager")
	private WorkersManager manager = org.service.app.services.manager.WorkersManager.getWorkerManager();

	public void upload(MultipartFile multipartFile) {
		FileWriterWork work = new FileWriterWork("[" + multipartFile.getOriginalFilename() + " reader]");
		work.setMultipartFile(multipartFile);
		dir = new File(FileUploader.tempDir);
		File file = new File(dir, multipartFile.getOriginalFilename());
		if (!dir.exists()) {
			try {
				dir.mkdirs();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		work.setDir(file);
		manager.assigneWork(work);
	}

	public ByteArrayOutputStream writeFile(String fileName) {

		return null;
	}

	public void cleanFile(String file) {

	}

	public void setTempDir(File file) {
		this.dir = file;

	}

}
