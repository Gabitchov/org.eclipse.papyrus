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
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.editor.CheckBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.CheckBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.painter.CustomCheckBoxPainter;
import org.eclipse.papyrus.infra.nattable.common.celleditor.configs.AbstractCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;



public class EMFSingleEBooleanCheckBoxCellEditorConfig extends AbstractCellEditorConfiguration {

	public static final String EDITOR_ID = "EMF_Single_EBoolean_CheckBox"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayConvert(org.eclipse.jface.viewers.ILabelProvider)
	 * 
	 * @param provider
	 * @return
	 */

	public IDisplayConverter getDisplayConvert(final ILabelProvider provider) {
		return new DefaultBooleanDisplayConverter();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getCellPainter()
	 * 
	 * @return
	 */

	public ICellPainter getCellPainter() {
		return new CustomCheckBoxPainter();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getICellEditor(java.lang.Object, ITableAxisElementProvider)
	 * 
	 * @param element
	 * @return
	 */

	public ICellEditor getICellEditor(final Object element, ITableAxisElementProvider elementProvider) {
		return new CheckBoxCellEditor();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getEditedType()
	 * 
	 * @return
	 */

	public Object getEditedType() {
		return EcorePackage.eINSTANCE.getEBoolean();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayMode()
	 * 
	 * @return
	 */

	public String getDisplayMode() {
		return DisplayMode.NORMAL;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#isMany()
	 * 
	 * @return
	 */

	public boolean isMany() {
		return false;
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
