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
package org.eclipse.papyrus.sysml.table.allocation;

import org.eclipse.papyrus.infra.table.common.factory.AbstractNattableEditorFactory;
import org.eclipse.papyrus.sysml.table.allocation.editor.AllocationTableEditor;

/**
 * the factory for the AllocationTable
 * 
 * 
 * 
 */
public class CreateAllocationTableFactory extends AbstractNattableEditorFactory {

	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public CreateAllocationTableFactory() {
		super(AllocationTableEditor.class, AllocationTableEditor.EDITOR_TYPE);
	}
}
