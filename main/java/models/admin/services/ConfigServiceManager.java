package models.admin.services;

import commons.DB.QueryExecutor;
import models.admin.BoardConfigDao;
import models.admin.validator.ConfigSaveServiceValidator;

public class ConfigServiceManager {
	private static ConfigServiceManager instance;
	
	private ConfigServiceManager() {}
	
	public BoardConfigDao boardConfigDao() {
		return new BoardConfigDao(new QueryExecutor());
	}
	
	public static ConfigServiceManager getInstance() {
		if(instance == null) {
			instance  = new ConfigServiceManager();
		}
		return instance;
	}
	
	public BoardConfigSaveService getboardConfigSaveService() {
		return new BoardConfigSaveService(boardConfigDao(), new ConfigSaveServiceValidator());
	}
	
	
}
