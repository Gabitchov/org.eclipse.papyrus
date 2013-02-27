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

import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEStringCellEditorConfig;
import org.eclipse.papyrus.uml.nattable.celleditor.validator.UnlimitedNaturalDataValidator;


public class UMLSingleUnlimitedNaturalCellEditorConfig extends EMFSingleEStringCellEditorConfig {

	/**
	 * the editor ID
	 */
	public static final String EDITOR_ID = "UML_Single_UnlimitedNatural_Text";


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.AbstractCellEditorConfiguration#getDataValidator()
	 * 
	 * @return
	 */
	@Override
	public IDataValidator getDataValidator() {
		return new UnlimitedNaturalDataValidator();
	}


	/**
	 * @Override
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.editors.EMFSingleEStringCellEditorConfig#getEditorId()
	 * 
	 * @return
	 */
	public String getEditorId() {
		return EDITOR_ID;
	}

}
