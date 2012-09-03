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
package org.eclipse.papyrus.sysml.table.efacet.requirement.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractSynchronizedTableEditor;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;


public class RequirementTableEditor extends AbstractSynchronizedTableEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusSysMLRequirementTable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "RequirementTable"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public RequirementTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		super(servicesRegistry, rawModel);
	}


}
