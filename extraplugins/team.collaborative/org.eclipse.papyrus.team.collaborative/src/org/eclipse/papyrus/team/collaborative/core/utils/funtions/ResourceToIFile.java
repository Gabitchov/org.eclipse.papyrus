/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.utils.funtions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import com.google.common.base.Function;


/**
 * The Class ResourceToIFile.
 * Function used to convert {@link Resource} to {@link IFile}
 */
public class ResourceToIFile implements Function<Resource, IFile> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override
	public IFile apply(Resource from) {
		return WorkspaceSynchronizer.getFile(from);
	}


	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The instance. */
		private static ResourceToIFile INSTANCE = new ResourceToIFile();
	}

	/**
	 * Private constructor.
	 */
	private ResourceToIFile() {
		// TODO auto-generated constructor
	}

	/**
	 * Returns the Singleton instance.
	 * <p>
	 * 
	 * @return The Singleton instance.
	 */
	public static ResourceToIFile getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
