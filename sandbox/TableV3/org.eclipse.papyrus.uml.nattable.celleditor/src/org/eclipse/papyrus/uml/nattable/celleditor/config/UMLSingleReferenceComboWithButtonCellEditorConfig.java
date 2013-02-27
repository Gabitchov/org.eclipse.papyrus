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
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.papyrus.infra.nattable.celleditor.ButtonConfiguration;
import org.eclipse.papyrus.infra.nattable.celleditor.ComboBoxWithButtonCellEditor;
import org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.uml.nattable.celleditor.dataprovider.UMLSingleReferenceDataProvider;
import org.eclipse.papyrus.uml.nattable.celleditor.widget.UMLDialogComboAction;


public class UMLSingleReferenceComboWithButtonCellEditorConfig extends UMLSingleReferenceComboCellEditorConfig {

	public static final String EDITOR_ID = "UML_Single_Reference Combo_Editor";

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.config.UMLSingleReferenceComboCellEditorConfig#getICellEditor(java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider)
	 * 
	 * @param element
	 * @param elementProvider
	 * @return
	 */
	@Override
	public ICellEditor getICellEditor(Object element, ITableAxisElementProvider elementProvider) {
		assert element instanceof EStructuralFeature;

		UMLSingleReferenceDataProvider dataProvider = new UMLSingleReferenceDataProvider((EStructuralFeature)element, elementProvider);
		UMLDialogComboAction action = new UMLDialogComboAction((EStructuralFeature)element, dataProvider);
		ButtonConfiguration conf = new ButtonConfiguration();
		//		conf.setImage(Activator.getDefault().getImage("/icons/browse_12x12.gif"));
		conf.setText("...");
		conf.setAction(action);
		conf.setTooltipText("Open a dialog to select the value");

		ICellEditor cellEditor = new ComboBoxWithButtonCellEditor(dataProvider, conf);
		return cellEditor;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.celleditor.config.UMLSingleReferenceComboCellEditorConfig#getEditorId()
	 * 
	 * @return
	 */
	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}


}
