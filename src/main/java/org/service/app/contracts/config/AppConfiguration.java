package org.service.app.contracts.config;

public interface AppConfiguration {

	public void setConfig(String configFileName);

	public void load();

	public void stop();

	public void clean();

}
