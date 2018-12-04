package org.service.app.services.file;

import java.io.File;
import java.io.OutputStream;

import org.service.app.annotations.Bean;
import org.service.app.contracts.services.FileService;
import org.service.app.contracts.services.WorkersManager;
import org.service.app.controllers.FileUploader;
import org.service.app.works.FileReaderWork;
import org.service.app.works.FileWriterWork;
import org.springframework.web.multipart.MultipartFile;

@Bean
public class FilesService implements FileService {

	private File dir;

	// @Inject
	// @org.springframework.beans.factory.annotation.Qualifier("manager")
	private WorkersManager manager = org.service.app.services.manager.WorkersManager.getWorkerManager();

	public void upload(MultipartFile multipartFile) {
		FileReaderWork work = new FileReaderWork("[" + multipartFile.getOriginalFilename() + " reader]");
		work.setMultipartFile(multipartFile);

		work.setDir(createFile(multipartFile.getOriginalFilename()));
		manager.assigneWork(work);
	}

	public void writeFile(OutputStream outputStream, String fileName) {
		File file = getFile(fileName);
		if (file != null) {
			FileWriterWork work = new FileWriterWork(outputStream, file);
			org.service.app.services.manager.WorkersManager.getWorkerManager().assigneWork(work);
			work.isWorkCompleted();
		}
	}

	public void cleanFile(String file) {

	}

	public void setTempDir(File file) {
		this.dir = file;

	}

	public File getFile(String fileName) {
		dir = new File(FileUploader.tempDir);
		File file = new File(dir, fileName);
		if (!dir.exists()) {
			try {
				dir.mkdirs();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (file.exists()) {
			return file;
		}
		return null;
	}

	public File createFile(String fileName) {
		dir = new File(FileUploader.tempDir);
		File file = new File(dir, fileName);
		if (!dir.exists()) {
			try {
				dir.mkdirs();

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		if (!file.exists()) {
			try {
				file.createNewFile();
				return file;
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return null;

	}
}
