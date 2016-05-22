package com.goodjoon.guppy.engine.common.util;

import java.util.UUID;

public class DataUtils {
	
	/**
	 * 128 bit UUID 를 생성하여 문자열로 리턴한다.
	 * @return
	 */
	public static String makeRandomUUIDString() {
		return makeRandomUUIDString(false);
	}
	
	public static String makeRandomUUIDString(boolean removeHyphen){
		if (removeHyphen)
			return UUID.randomUUID().toString().replace("-", "");
		
		return UUID.randomUUID().toString();
	}
	
}
