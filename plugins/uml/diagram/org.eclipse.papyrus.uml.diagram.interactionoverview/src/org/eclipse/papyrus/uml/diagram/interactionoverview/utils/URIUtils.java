/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.utils;


public class URIUtils {


	private static final String PREFIX = "platform:/resource/";

	private static final String SUFFIX = "/model.notation";

	public static String getTimestampedURI() {
		return PREFIX + System.currentTimeMillis() + SUFFIX;
	}
}
