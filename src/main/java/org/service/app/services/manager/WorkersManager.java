package org.service.app.services.manager;

import org.service.app.annotations.Bean;
import org.service.app.contracts.services.Work;
import org.service.app.logger.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * This class is implementation of {@WorkerManager} interface.
 * 
 * @author Anish
 *
 */
//@Configuration
public class WorkersManager extends AbstractManager {

	private static WorkersManager manager;

	private WorkersManager() {
		Logger.info("Wrokers Manager Created.");
	}

	//@org.springframework.context.annotation.Bean
	public static org.service.app.contracts.services.WorkersManager getWorkerManager() {
		if (manager == null) {
			manager = new WorkersManager();
		}
		return manager;
	}

	@Override
	protected void hireWorkers(Work work, int numberOfWorkers) {
		ThreadGroup threadGroup = new ThreadGroup(work.getWorkTitle());
		for (int counter = 0; counter < numberOfWorkers; counter++) {
			Thread thread = new Thread(threadGroup, getRunnable(work));
			thread.start();
		}
		logger.info("Started........");
	}
}
