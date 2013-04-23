/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Standard file extensions used in Papyrus
 * 
 * @author Camille Letavernier
 * 
 */
public class FileExtensions {

	public static final Map<String, String> umlExtensions = new LinkedHashMap<String, String>();

	public static final Map<String, String> umlProfileExtensions = new LinkedHashMap<String, String>();

	public static final Map<String, String> cssStylesheetsExtension = new LinkedHashMap<String, String>();

	public static final Map<String, String> allFilesExtensions = new LinkedHashMap<String, String>();

	static {
		umlExtensions.put("*.uml", "UML (*.uml)");
		umlExtensions.put("*.profile.uml", "UML Profiles (*.profile.uml)");

		umlProfileExtensions.put("*.profile.uml", "UML Profiles (*.profile.uml)");
		umlProfileExtensions.put("*.uml", "UML (*.uml)");

		cssStylesheetsExtension.put("*.css", "CSS Stylesheets (*.css)");

		allFilesExtensions.put("*", "All (*)");
	}


}
