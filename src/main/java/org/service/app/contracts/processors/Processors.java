package org.service.app.contracts.processors;

/**
 * This interface allows methods for processing requests.
 * 
 * @author Anish
 *
 */
public interface Processors {

	/**
	 * Initialize processor.
	 */
	public void init();

	/**
	 * Destroy processor.
	 */
	public void destroy();
}
