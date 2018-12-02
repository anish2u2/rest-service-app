package org.service.app.services.manager;

import java.util.logging.Logger;

import org.service.app.contracts.services.Work;
import org.service.app.contracts.services.WorkersManager;

public abstract class AbstractManager implements WorkersManager {

	protected Logger logger = Logger.getLogger("[Workers-Manager]");

	public void assigneWork(Work work) {
		logger.info("Assigning work : " + work.getWorkTitle());
		int priority = work.getWorkPriority();
		switch (priority) {
		case 5:
			hireWorkers(work, 2);
		case 10:
			hireWorkers(work, 4);
		default:
			hireWorkers(work, 1);
		}
	}

	/**
	 * This method will create new workers on the basis of number of workers to be
	 * created.
	 * 
	 * @param work
	 * @param numberOfWorkers
	 */
	protected abstract void hireWorkers(Work work, int numberOfWorkers);

	protected Runnable getRunnable(final Work work) {
		return new Runnable() {

			public void run() {
				work.doWork();
			}
		};
	}
}
