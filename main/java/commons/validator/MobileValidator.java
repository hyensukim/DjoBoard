package commons.validator;

public interface MobileValidator {

	/**
	 * 휴대전화번호 유효성 검사
	 * 
	 * @param mobile
	 * @return
	 */
	default boolean mobileCheck(String mobile) {
		
		/**
		 * 1. 휴대전화번호는 숫자를 제외한 문자는 제거한다.
		 * 2. 패턴 만들기 (010,011,016)(3~4자리)(4자리) 
		 */
		mobile = mobile.replaceAll("\\D", "");

		String pattern = "01[016]\\d{3,4}\\d{4}";

		return mobile.matches(pattern);

	}

}
