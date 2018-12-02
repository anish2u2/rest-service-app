package org.service.app.works;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.service.app.contracts.services.Work;
import org.service.app.logger.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileWriterWork implements Work {

	private String workTitle;

	private AtomicBoolean haltWork = new AtomicBoolean(false);

	private FileOutputStream fileOutputStream;

	private BufferedInputStream fileInputStream;

	private Object lock = new Object();

	private Object signal = new Object();

	private File dir;

	private MultipartFile multipartFile;

	public FileWriterWork(String title) {
		this.workTitle = title;
	}

	public void doWork() {
		File file = new File(getDir(), getMultipartFile().getOriginalFilename());
		Logger.info("File Name:" + file.getName());
		try {
		getMultipartFile().transferTo(getDir());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getWorkTitle() {

		return this.workTitle;
	}

	public int getWorkPriority() {

		return 1;
	}

	public int workStatus() {

		return 0;
	}

	public boolean haltWork() {
		haltWork.set(true);
		return true;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public void waitForWorkCompletion() {
		try {
			synchronized (signal) {
				this.signal.wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void notifyWorkCompletion() {
		synchronized (signal) {
			this.signal.notify();
		}

	}
}
