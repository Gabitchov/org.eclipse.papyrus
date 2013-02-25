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

import org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEBooleanCheckBoxCellEditorConfig;
import org.eclipse.uml2.types.TypesPackage;


public class UMLSingleBooleanCellEditorConfig extends EMFSingleEBooleanCheckBoxCellEditorConfig {

	/**
	 * the editor ID
	 */
	public static final String EDITOR_ID = "UML_Single_Boolean_CheckBox";

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEBooleanCheckBoxCellEditorConfig#getEditedType()
	 * 
	 * @return
	 */
	@Override
	public Object getEditedType() {
		return TypesPackage.eINSTANCE.getBoolean();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEBooleanCheckBoxCellEditorConfig#getEditorId()
	 *
	 * @return
	 */
	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}

}
