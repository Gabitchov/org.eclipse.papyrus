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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFileEditor;

/**
 * 
 * An abstract class for File Editor
 * 
 */
public abstract class AbstractFileEditor implements IFileEditor {

	/** the Eclipse Project */
	private final IProject project;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 */
	public AbstractFileEditor(final IProject project) {
		this.project = project;
	}

	/**
	 * 
	 * @return
	 *         the eclipse project
	 */
	public IProject getProject() {
		return this.project;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#init()
	 * 
	 *      {@inheritDoc}
	 */
	public void init() {

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	public Set<String> getMissingFiles() {
		return new HashSet<String>();
	}

	/**
	 * 
	 * @param text
	 *        the initial text
	 * @return
	 *         an input stream
	 */
	protected InputStream getInputStream(final String text) {
		if(text == null) {
			Activator.log.warn("Cannot open an input stream for a null text"); //$NON-NLS-1$
			return null;
		}

		final StringReader sr = new StringReader(text);
		InputStream is = new InputStream() {

			@Override
			public int read() throws IOException {
				return sr.read();
			}

		};
		return is;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor.plugin.AbstractEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	public boolean exists() {
		return getMissingFiles().size() == 0;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IFileEditor#create()
	 * 
	 *      {@inheritDoc}
	 */
	public void create() {
		createFiles(getMissingFiles());
		init();
	}
}
