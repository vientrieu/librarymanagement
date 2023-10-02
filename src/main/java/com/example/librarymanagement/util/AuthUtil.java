package com.example.librarymanagement.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author mangvientrieu
 */
public final class AuthUtil {

	public static String hashPassword(String password) {
		return DigestUtils.sha256Hex(password);
	}

}
