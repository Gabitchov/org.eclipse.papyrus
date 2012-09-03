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
package org.eclipse.papyrus.sysml.table.efacet.requirement.handler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler;
import org.eclipse.papyrus.sysml.table.efacet.requirement.Activator;
import org.eclipse.papyrus.sysml.table.efacet.requirement.editor.RequirementTableEditor;


public class CreateRequirementTableEditorHandler extends AbstractCreateTableEditorHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateRequirementTableEditorHandler() {
		super(RequirementTableEditor.EDITOR_TYPE, RequirementTableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractCreateTableEditorHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		final boolean enabled = super.isEnabled();
		final EObject context = getTableContext();
		//TODO improve the condition
//		if(context instanceof Element) {
//			return enabled && (UMLUtil.getStereotypeApplication((Element)context, Block.class) != null);
//		}
		return true;
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
		final URI uri = URI.createPlatformPluginURI(symbolicName + "/resources/sysml_requirement_table.papyrustableconfiguration", true); //$NON-NLS-1$
		return uri;
	}

}
