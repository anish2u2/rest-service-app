package org.service.app.listeners.manager;

import java.util.Map;

import org.service.app.annotations.Bean;
import org.service.app.contracts.listener.AppContextAware;
import org.service.app.contracts.services.AppContext;
import org.service.app.logger.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * This class will be responsible for managing app context listeners.
 * 
 * @author Anish
 *
 */

@Bean("appContextAwareManager")
public class AppContextListernerManager implements ApplicationContextAware {

	private Map<String, AppContextAware> appContextAware;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Logger.info("Initializing App Context Aware Manger..");
		appContextAware = applicationContext.getBeansOfType(AppContextAware.class);
		try {
			initAppContextAwareListeners(applicationContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initAppContextAwareListeners(ApplicationContext context) throws Exception {
		AppContext appContext = new AbstractAppContext(context);
		if (appContextAware != null && !appContextAware.values().isEmpty())
			for (AppContextAware appContextAware : appContextAware.values()) {
				Logger.info("Initializing app context aware..");
				appContextAware.setAppContext(appContext);
			}
	}

	public class AbstractAppContext extends AbstractApplicationContext implements AppContext {

		private ApplicationContext context;

		public AbstractAppContext(ApplicationContext context) {
			super(context);
			this.context = context;
		}

		@Override
		protected void closeBeanFactory() {
			((AbstractApplicationContext) context).close();
		}

		@Override
		public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
			return ((AbstractApplicationContext) this.context).getBeanFactory();
		}

		@Override
		protected void refreshBeanFactory() throws BeansException, IllegalStateException {
			((ConfigurableApplicationContext) this.context).refresh();
		}

		public void setApplicationCntext(ApplicationContext context) {
			this.context = context;
		}

	}

}
