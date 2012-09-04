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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.generic.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler;
import org.eclipse.papyrus.uml.table.efacet.generic.Activator;
import org.eclipse.papyrus.uml.table.efacet.generic.editor.GenericTableEditor;


public class CreateGenericTableEditorHandler extends AbstractCreateTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateGenericTableEditorHandler() {
		super(GenericTableEditor.EDITOR_TYPE, GenericTableEditor.DEFAULT_NAME);
	}


	/**
	 * 
	 * @return
	 *         the uri of the papyrus table configuration to use for the Papyrus Table
	 */
	protected URI getPapyrusTableConfigurationURI() {
		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/uml_generic_table.papyrustableconfiguration", true); //$NON-NLS-1$
		return uri;
	}
}
