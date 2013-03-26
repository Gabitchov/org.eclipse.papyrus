/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.storage.actions.workspace;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.storage.actions.IContextDeleteAction;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

/**
 * An action to delete an existing context. This action cannot be undone.
 * If you simply want to disable an existing context, see {@link ConfigurationManager#disableContext(Context)}
 * 
 * @author Camille Letavernier
 */
public class WorkspaceContextDeleteAction implements IContextDeleteAction {

	public String getToolTip() {
		return Messages.WorkspaceContextDeleteAction_0;
	}

	/**
	 * Deletes the given context.
	 * 
	 * @param context
	 *        The context to delete
	 */
	public void delete(final Context context, IProgressMonitor monitor) throws CoreException {
		final File directory = new File(context.eResource().getURI().toFileString()).getParentFile();

		SubMonitor sub = SubMonitor.convert(monitor, Messages.WorkspaceContextDeleteAction_1 + context.getName(), IProgressMonitor.UNKNOWN);
		try {
			delete(directory);
		} finally {
			sub.done();
		}
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
