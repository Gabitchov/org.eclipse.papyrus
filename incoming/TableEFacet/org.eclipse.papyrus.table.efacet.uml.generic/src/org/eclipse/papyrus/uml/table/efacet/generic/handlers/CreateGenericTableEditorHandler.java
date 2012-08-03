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
package org.eclipse.papyrus.uml.table.efacet.generic.handlers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration;
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
	 * @see org.eclipse.papyrus.infra.table.common.handlers.AbstractCreateTableEditorHandler#getPapyrusTableConfiguration()
	 * 
	 * @return
	 */
	@Override
	protected PapyrusTableConfiguration getPapyrusTableConfiguration() {
		final ResourceSet resourceSet = getTableContext().eResource().getResourceSet();

		final String symbolicName = Activator.getDefault().getBundle().getSymbolicName();
		final URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/uml_generic_table.papyrustableconfiguration", true); //$NON-NLS-1$
		final Resource resource = resourceSet.getResource(uri, true);

		PapyrusTableConfiguration configuration = null;

		if(resource.getContents().get(0) instanceof PapyrusTableConfiguration) {
			configuration = (PapyrusTableConfiguration)resource.getContents().get(0);
		}
		return configuration;
	}

}
