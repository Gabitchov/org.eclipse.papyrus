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
package org.eclipse.papyrus.infra.table.efacet.nestededitor.handler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.Activator;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.editor.NestedEditorTableEditor;

public class CreateNestedEditorTableEditorHandler extends AbstractCreateTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateNestedEditorTableEditorHandler() {
		super(NestedEditorTableEditor.EDITOR_TYPE, NestedEditorTableEditor.DEFAULT_NAME);
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
		final URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/nested_editor_table.papyrustableconfiguration", true); //$NON-NLS-1$
		return uri;
	}

}
