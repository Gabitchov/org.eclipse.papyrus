package org.eclipse.papyrus.acceleo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;

public class Utils {

	/**
	 * Return the absolute file name to a file name given e.g. in the form platform:/plugin/xxx
	 * 
	 * @param fileName
	 *        the file name using eclipse elements such as platform:/plugin
	 * @return the absolute file name
	 */
	public static String getAbsoluteFN(String fileName) {
		try {
			URL absoluteURL = FileLocator.toFileURL(new URL(fileName));
			return absoluteURL.getFile();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return null;
	}
}
