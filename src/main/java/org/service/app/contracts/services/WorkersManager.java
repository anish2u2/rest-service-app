package org.service.app.contracts.services;

/**
 * 
 * This Interface introduces methods which can be utilized for managing workers.
 * 
 * @author Anish Singh
 *
 */
public interface WorkersManager {

	/**
	 * This method will distribute the work among workers. also assigning is based
	 * on priority of work.
	 * 
	 * @param work
	 */
	void assigneWork(Work work);

}
