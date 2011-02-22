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

import java.util.Map;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.sysml.table.allocation.editor.AllocationTableEditor;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;
import org.eclipse.papyrus.table.common.factory.AbstractNattableEditorFactory;

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

	/**
	 * @see org.eclipse.papyrus.core.editorsfactory.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	@Override
	public boolean isPageModelFactoryFor(Object pageIdentifier) {
		if(pageIdentifier instanceof TableInstance) {
			Object parameter = ((TableInstance)pageIdentifier).getParameter();
			if(parameter instanceof Map<?, ?>) {
				return getExpectedType().equals(((Map<?, ?>)parameter).get(AbstractNattableEditor.TYPE_KEY));
			}
		}

		return false;
	}

}
