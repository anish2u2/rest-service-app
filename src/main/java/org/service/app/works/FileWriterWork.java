package org.service.app.works;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.service.app.contracts.services.Work;

public class FileWriterWork implements Work {

	private BufferedOutputStream outputStream;
	private FileInputStream inputStream;
	private boolean haltWork;
	private Object lock = new Object();

	public FileWriterWork(OutputStream stream, File file) {
		try {
			outputStream = new BufferedOutputStream(stream);
			inputStream = new FileInputStream(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void doWork() {
		try {
			while (!this.haltWork) {
				synchronized (lock) {
					byte[] data = new byte[1024];
					if (inputStream.read(data) != -1) {
						outputStream.write(data);
					} else {
						this.haltWork = true;
						break;
					}
				}
			}
			// outputStream.flush();
			// outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			synchronized (this) {
				this.notify();
			}
		}
	}

	public String getWorkTitle() {
		return "[File Writer]";
	}

	public int getWorkPriority() {
		return 5;
	}

	public int workStatus() {
		return 0;
	}

	public boolean haltWork() {
		this.haltWork = true;
		return this.haltWork;
	}

	public void isWorkCompleted() {
		try {
			synchronized (this) {
				this.wait();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
