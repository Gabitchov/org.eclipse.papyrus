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


package org.eclipse.papyrus.uml.table.efacet.generic.factory;

import org.eclipse.papyrus.infra.table.efacet.common.factory.AbstractTableEditorFactory;
import org.eclipse.papyrus.uml.table.efacet.generic.editor.GenericTableEditor;


/**
 *
 * 
 */
public class GenericTableEditorFactory extends AbstractTableEditorFactory {


	/**
	 * Constructor.
	 * 
	 * @param diagramClass
	 * @param expectedType
	 */
	public GenericTableEditorFactory() {
		super(GenericTableEditor.class, GenericTableEditor.EDITOR_TYPE);
	}


}
