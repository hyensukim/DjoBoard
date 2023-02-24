package commons.validator;

import models.admin.BoardConfig;

public interface CheckRequiredValidator {
	default void checkRequired(String value, RuntimeException e) {
		if(value == null || value.isBlank()) {
			throw e;
		}
	}
	
	default String checkRequired(String value, String defaultValue) {
		if(value == null || value.isBlank()) {
			return defaultValue;
		}
		return value;
	}
}
