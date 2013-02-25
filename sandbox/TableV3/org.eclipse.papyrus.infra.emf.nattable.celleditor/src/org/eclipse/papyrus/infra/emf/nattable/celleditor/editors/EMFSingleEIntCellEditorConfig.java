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
package org.eclipse.papyrus.infra.emf.nattable.celleditor.editors;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultIntegerDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.DefaultNumericDataValidator;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;


public class EMFSingleEIntCellEditorConfig extends EMFSingleEStringCellEditorConfig {

	public static final String EDITOR_ID = "EMF_Single_EInt_Text"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayConvert(org.eclipse.jface.viewers.ILabelProvider)
	 * 
	 * @param provider
	 * @return
	 */

	public IDisplayConverter getDisplayConvert(final ILabelProvider provider) {
		return new DefaultIntegerDisplayConverter();
	}





	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getEditedType()
	 * 
	 * @return
	 */

	public Object getEditedType() {
		return EcorePackage.eINSTANCE.getEInt();
	}

	@Override
	public IDataValidator getDataValidator() {
		return new DefaultNumericDataValidator();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#getEditorId()
	 * 
	 * @return
	 */
	public String getEditorId() {
		return EDITOR_ID;
	}

}
