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


package org.eclipse.papyrus.infra.table.efacet.nestededitor.factory;

import org.eclipse.papyrus.infra.table.efacet.common.factory.AbstractTableEditorFactory;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.editor.NestedEditorTableEditor;


/**
 *
 * 
 */
public class NestedEditorTableEditorFactory extends AbstractTableEditorFactory {


	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public NestedEditorTableEditorFactory() {
		super(NestedEditorTableEditor.class, NestedEditorTableEditor.EDITOR_TYPE);
	}


}
