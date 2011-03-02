/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.ui;

import java.io.File;

import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;

/**
 * An action to delete an existing context. This action cannot be undone.
 * If you simply want to disable an existing context, see {@link ConfigurationManager#disableContext(Context)}
 * 
 * @author Camille Letavernier
 */
public class RemoveContextAction {

	/**
	 * Deletes the given context.
	 * 
	 * @param sourceContext
	 *        The context to delete
	 */
	public void removeContext(Context sourceContext) {
		//TODO : Close editors for the context being deleted
		File directory = new File(sourceContext.eResource().getURI().toFileString()).getParentFile();
		ConfigurationManager.instance.deleteContext(sourceContext);
		delete(directory);
	}

	/**
	 * Recursively deletes a file or directory
	 * 
	 * @param file
	 *        The file or directory to delete recusively
	 */
	private void delete(File file) {
		if(file.isDirectory()) {
			for(File subFile : file.listFiles()) {
				delete(subFile);
			}
		}
		file.delete();
	}
}
