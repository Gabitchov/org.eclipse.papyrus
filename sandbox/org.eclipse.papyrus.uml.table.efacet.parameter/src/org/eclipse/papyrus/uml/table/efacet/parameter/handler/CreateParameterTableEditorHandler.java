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
package org.eclipse.papyrus.uml.table.efacet.parameter.handler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler;
import org.eclipse.papyrus.uml.table.efacet.parameter.Activator;
import org.eclipse.papyrus.uml.table.efacet.parameter.editor.ParameterTableEditor;
import org.eclipse.uml2.uml.Operation;


public class CreateParameterTableEditorHandler extends AbstractCreateTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateParameterTableEditorHandler() {
		super(ParameterTableEditor.EDITOR_TYPE, ParameterTableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return getTableContext() instanceof Operation;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler#getPapyrusTableConfigurationURI()
	 * 
	 * @return
	 */
	@Override
	protected URI getPapyrusTableConfigurationURI() {
		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/uml_parameter_table.papyrustableconfiguration", true); //$NON-NLS-1$
		return uri;
	}

}
