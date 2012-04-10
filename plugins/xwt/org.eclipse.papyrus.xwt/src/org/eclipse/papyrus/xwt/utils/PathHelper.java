/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *  
 * Contributors:                                                               *  
 *     Soyatec - initial API and implementation                                * 
 *******************************************************************************/
package org.eclipse.papyrus.xwt.utils;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @author jliu jin.liu@soyatec.com
 */
public class PathHelper {

	public static final String URL_IDENTIFY_PREFIX = "file:";

	public static final String BACKWARD_SLASH = "\\";

	public static final String FORWARD_SLASH = "/";

	public static final String RELATIVE_PATH_SIG = "../";

	public static final String WHITE_SPACE_ASCII = "%20";

	public static String getRelativePath(String source, String target) {
		if(source == null || target == null) {
			return target;
		}
		File sourceFile = new File(source);
		if(!sourceFile.exists()) {
			return target;
		}
		File targetFile = new File(target);
		if(!targetFile.exists()) {
			return target;
		}
		source = switchToForwardSlashes(source);
		target = switchToForwardSlashes(target);
		int index = target.indexOf(FORWARD_SLASH);
		String container = null;
		while(index != -1) {
			container = target.substring(0, index);
			if(!source.startsWith(container + FORWARD_SLASH)) {
				break;
			}
			source = source.substring(index + 1);
			target = target.substring(index + 1);
			index = target.indexOf(FORWARD_SLASH);
		}
		index = source.indexOf(FORWARD_SLASH);
		while(index != -1) {
			target = RELATIVE_PATH_SIG + target;
			source = source.substring(index + 1);
			index = source.indexOf(FORWARD_SLASH);
		}
		return target;
	}

	/**
	 * Switch to file path slashes
	 */
	public static String switchToForwardSlashes(String path) {
		path = path.replace(File.separatorChar, FORWARD_SLASH.charAt(0));
		path = path.replace(BACKWARD_SLASH.charAt(0), FORWARD_SLASH.charAt(0));
		return path;
	}

	public static String getAbsolutePath(String source, String relative) {
		if(source.indexOf(WHITE_SPACE_ASCII) != -1) {
			source = source.replace(WHITE_SPACE_ASCII, " ");
		}
		if(relative.indexOf(WHITE_SPACE_ASCII) != -1) {
			relative = relative.replace(WHITE_SPACE_ASCII, " ");
		}
		if(source.startsWith(FORWARD_SLASH)) {
			source = source.substring(1);
		}
		String prefix = null;
		if(source.startsWith(URL_IDENTIFY_PREFIX)) {
			prefix = URL_IDENTIFY_PREFIX;
			source = source.substring(URL_IDENTIFY_PREFIX.length());
			if(System.getProperty("os.arch").startsWith("Win")) {
				source = source.substring(1);
			}
		}
		File file = new File(source);
		if(!file.exists()) {
			return relative;
		}
		if(file.isFile()) {
			source = file.getParent();
		}
		source = switchToForwardSlashes(source);
		relative = switchToForwardSlashes(relative);
		if(relative.startsWith(FORWARD_SLASH)) {
			relative = relative.substring(1);
		}
		int index = relative.lastIndexOf(FORWARD_SLASH);
		if(index != -1) {
			String container = relative.substring(0, index);
			int i = source.indexOf(container);
			if(i != -1) {
				source = source.substring(0, i);
			} else {
				int j = relative.indexOf(RELATIVE_PATH_SIG);
				while(j != -1) {
					relative = relative.substring(j + RELATIVE_PATH_SIG.length());
					source = source.substring(0, source.lastIndexOf(FORWARD_SLASH));
					j = relative.indexOf(RELATIVE_PATH_SIG);
				}
			}
		}
		if(System.getProperty("os.arch").startsWith("Win")) {
			source = "/" + source;
		}

		return (prefix != null ? prefix : "") + source + FORWARD_SLASH + relative;
	}

	/**
	 * Convert to relative url based on base
	 */
	public static String convertToRelative(String input, String base) {
		StringTokenizer inputTokenizer = new StringTokenizer(input, FORWARD_SLASH);
		StringTokenizer baseTokenizer = new StringTokenizer(base, FORWARD_SLASH);
		String token1 = "", token2 = "";
		//
		while(true) {
			if(!inputTokenizer.hasMoreTokens() || !baseTokenizer.hasMoreTokens())
				break;
			token1 = baseTokenizer.nextToken();
			token2 = inputTokenizer.nextToken();
			if(!token1.equals(token2))
				break;
		}
		StringBuilder builder = new StringBuilder();
		while(baseTokenizer.hasMoreTokens()) {
			baseTokenizer.nextToken();
			builder.append(RELATIVE_PATH_SIG);
		}
		builder.append(token2);
		while(inputTokenizer.hasMoreTokens()) {
			builder.append(FORWARD_SLASH + inputTokenizer.nextToken());
		}
		return builder.toString();
	}
}
