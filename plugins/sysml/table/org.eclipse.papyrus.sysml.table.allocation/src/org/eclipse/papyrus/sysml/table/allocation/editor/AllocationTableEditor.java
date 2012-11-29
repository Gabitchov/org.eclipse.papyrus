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
package org.eclipse.papyrus.sysml.table.allocation.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.table.common.editor.AbstractUMLTableEditor;


/**
 * 
 * The requirement table editor
 * 
 */
public class AllocationTableEditor extends AbstractUMLTableEditor {


	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyrusAllocationTable"; //$NON-NLS-1$

	public static final String DEFAULT_NAME = "AllocationTable"; //$NON-NLS-1$

	/**
	 * @param servicesRegistry
	 * @param rawModel2
	 * 
	 */
	public AllocationTableEditor(ServicesRegistry servicesRegistry, PapyrusTableInstance rawModel) {
		super(servicesRegistry, rawModel);
	}

}
