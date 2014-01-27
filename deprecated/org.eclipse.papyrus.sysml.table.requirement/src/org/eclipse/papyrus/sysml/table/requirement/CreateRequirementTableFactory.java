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

import org.eclipse.papyrus.sysml.table.requirement.editor.RequirementTableEditor;

public class CreateRequirementTableFactory extends org.eclipse.papyrus.infra.table.common.factory.AbstractNattableEditorFactory {

	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public CreateRequirementTableFactory() {
		super(RequirementTableEditor.class, RequirementTableEditor.EDITOR_TYPE);
	}
}
