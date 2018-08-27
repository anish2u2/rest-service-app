package org.service.app.contracts.listener;

import org.service.app.contracts.services.AppContext;
import org.service.app.exceptions.AppContextException;

/**
 * This will be implemented when app wants to listen that app context is
 * initialized.
 * 
 * @author Anish
 *
 */
public interface AppContextAware {

	public void setAppContext(AppContext context) throws AppContextException;

}
