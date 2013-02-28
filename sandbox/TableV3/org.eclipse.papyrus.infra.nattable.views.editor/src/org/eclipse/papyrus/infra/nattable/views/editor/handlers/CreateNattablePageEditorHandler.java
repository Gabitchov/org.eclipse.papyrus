/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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


package org.eclipse.papyrus.infra.nattable.views.editor.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.nattable.common.handlers.AbstractCreateNattableEditorHandler;
import org.eclipse.papyrus.infra.nattable.views.editor.Activator;
import org.eclipse.papyrus.infra.nattable.views.editor.NattablePageEditor;


public class CreateNattablePageEditorHandler extends AbstractCreateNattableEditorHandler {

	private static final String CONFIGURATION_PATH = "/resources/viewpage.nattableconfiguration";

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNattablePageEditorHandler() {
		super(NattablePageEditor.EDITOR_TYPE, NattablePageEditor.DEFAULT_NAME);
	}

	protected URI getTableEditorConfigurationURI() {
		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + CONFIGURATION_PATH, true); //$NON-NLS-1$
		return uri;
	}
}
