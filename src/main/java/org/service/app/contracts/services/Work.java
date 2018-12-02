package org.service.app.contracts.services;

/**
 * This will represent the unit of work.
 * 
 * @author Anish
 *
 */
public interface Work {

	/**
	 * This method will be used to indicate the unit of work and its should be
	 * implemented to do work by workers.
	 */
	void doWork();

	/**
	 * Name of Work.
	 * 
	 * @return
	 */
	String getWorkTitle();

	/**
	 * Returns the priority of work between 0 to 10. 0 is min and 10 is max.
	 * 
	 * @return
	 */
	int getWorkPriority();

	/**
	 * This method will return the status of work done in terms of 10 to 100%.
	 * 
	 * @return
	 */
	int workStatus();

	/**
	 * This method will halt the work and return true else false;
	 * 
	 * @return
	 */
	boolean haltWork();

}
