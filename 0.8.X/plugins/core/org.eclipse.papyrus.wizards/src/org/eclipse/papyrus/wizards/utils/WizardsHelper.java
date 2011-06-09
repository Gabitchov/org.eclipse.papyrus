/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class WizardsHelper.
 */
public class WizardsHelper {

	/**
	 * Gets the file name without extension.
	 *
	 * @param path the path of the file
	 * @return the file name without extension
	 */
	public static String getFileNameWithoutExtension(String path) {
		if( path!= null){
			String[] pathParts = path.split("/"); //$NON-NLS-1$
			String fileName= pathParts[pathParts.length - 1];
			int index = fileName.lastIndexOf('.');
			if (index > 0 && index <= fileName.length() - 2) {
				System.out.println("Filename without Extension: "
						+ fileName.substring(0, index));
				return fileName.substring(0, index);
			}
		}
		return null;
	}
}
