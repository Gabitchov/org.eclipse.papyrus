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
package org.eclipse.papyrus.sysml.table.requirement.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.table.common.editor.AbstractUMLTableEditor;




/**
 * 
 * The requirement table editor
 * 
 */
public class RequirementTableEditor extends AbstractUMLTableEditor {


	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusRequirementTable"; //$NON-NLS-1$

	/** the default name */
	public static final String DEFAULT_NAME = "RequirementTable"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel2
	 * 
	 */
	public RequirementTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTableInstance rawModel) {
		super(servicesRegistry, rawModel);
	}
}
