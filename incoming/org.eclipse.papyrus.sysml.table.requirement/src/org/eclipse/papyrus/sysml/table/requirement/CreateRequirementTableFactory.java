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
package org.eclipse.papyrus.sysml.table.requirement;

import java.util.Map;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.papyrus.sysml.table.requirement.editor.RequirementTableEditor;
import org.eclipse.papyrus.table.common.editor.AbstractNattableEditor;

public class CreateRequirementTableFactory extends org.eclipse.papyrus.table.common.factory.AbstractNattableEditorFactory {

	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public CreateRequirementTableFactory() {
		super(RequirementTableEditor.class, RequirementTableEditor.EDITOR_TYPE);
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
