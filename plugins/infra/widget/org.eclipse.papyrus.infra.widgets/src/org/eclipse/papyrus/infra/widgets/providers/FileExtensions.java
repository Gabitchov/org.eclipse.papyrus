package org.eclipse.papyrus.infra.widgets.providers;

import java.util.LinkedHashMap;
import java.util.Map;


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
