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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.celleditor.config;

import org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEIntCellEditorConfig;
import org.eclipse.uml2.types.TypesPackage;


public class UMLSingleIntegerCellEditorConfig extends EMFSingleEIntCellEditorConfig {

	/**
	 * the editor ID
	 */
	public static final String EDITOR_ID = "UML_Single_Integer_Text";

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEBooleanCheckBoxCellEditorConfig#getEditedType()
	 * 
	 * @return
	 */
	@Override
	public Object getEditedType() {
		return TypesPackage.eINSTANCE.getInteger();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEIntCellEditorConfig#getEditorId()
	 *
	 * @return
	 */
	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}
}
