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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.painter.cell.ComboBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.common.celleditor.configs.AbstractCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;


public class EMFSingleEEnumEditorConfig extends AbstractCellEditorConfiguration {

	public static final String EDITOR_ID = "EMF_Single_EEnum_Combo"; //$NON-NLS-1$

	private Object element;

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayConvert(org.eclipse.jface.viewers.ILabelProvider)
	 * 
	 * @param provider
	 * @return
	 */

	public IDisplayConverter getDisplayConvert(final ILabelProvider provider) {
		return new DisplayConverter() {

			@Override
			public Object displayToCanonicalValue(Object displayValue) {
				return null;
			}

			@Override
			public Object canonicalToDisplayValue(Object canonicalValue) {
				return provider.getText(canonicalValue);
			}
		};

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getCellPainter()
	 * 
	 * @return
	 */

	public ICellPainter getCellPainter() {
		return new ComboBoxPainter();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getICellEditor(java.lang.Object, ITableAxisElementProvider)
	 * 
	 * @param element
	 * @return
	 */

	public ICellEditor getICellEditor(final Object element, final ITableAxisElementProvider elementProvider) {
		assert element instanceof EAttribute;
		assert ((EAttribute)element).eClass() == getEditedType();
		return new ComboBoxCellEditor(new IComboBoxDataProvider() {


			public List<?> getValues(int columnIndex, int rowIndex) {
				Object el = elementProvider.getColumnElement(columnIndex);
//				Object el = elementProvider.getColumnElement(columnIndex);
				List<Object> literals = new ArrayList<Object>();
				for(final EEnumLiteral instances : ((EEnum)((EStructuralFeature)element).getEType()).getELiterals()) {
					literals.add(instances.getInstance());
				}
				return literals;
			}
		});
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getEditedType()
	 * 
	 * @return
	 */

	public Object getEditedType() {
		return EcorePackage.eINSTANCE.getEEnum();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayMode()
	 * 
	 * @return
	 */

	public String getDisplayMode() {
		return DisplayMode.EDIT;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#isMany()
	 * 
	 * @return
	 */

	public boolean isMany() {
		return false;
	}

	public String getEditorId() {
		return EDITOR_ID;
	}

}
