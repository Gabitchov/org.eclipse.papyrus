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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ComboBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.common.celleditor.configs.AbstractCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.uml.nattable.celleditor.dataprovider.UMLSingleReferenceDataProvider;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLSingleReferenceComboCellEditorConfig extends AbstractCellEditorConfiguration {

	public static final String EDITOR_ID = "UML_Single_Reference_ComboCell";

	public IDisplayConverter getDisplayConvert(final ILabelProvider provider) {//FIXME
		return new DisplayConverter() {

			@Override
			public Object displayToCanonicalValue(Object displayValue) {
				return null;
			}

			@Override
			public Object canonicalToDisplayValue(Object canonicalValue) {
				return provider.getText(canonicalValue);//useful?
			}
		};
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#getCellPainter()
	 * 
	 * @return
	 */
	public ICellPainter getCellPainter() {
		return new ComboBoxPainter();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#getICellEditor(java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider)
	 * 
	 * @param element
	 * @param elementProvider
	 * @return
	 */
	public ICellEditor getICellEditor(final Object element, final ITableAxisElementProvider elementProvider) {
		if(element instanceof EStructuralFeature) {
			return new ComboBoxCellEditor(new UMLSingleReferenceDataProvider((EStructuralFeature)element, elementProvider));
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#getEditedType()
	 * 
	 * @return
	 */
	public Object getEditedType() {
		return UMLPackage.eINSTANCE.getElement();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#getDisplayMode()
	 * 
	 * @return
	 */
	public String getDisplayMode() {
		return DisplayMode.EDIT;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration#isMany()
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
