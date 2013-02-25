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
package org.eclipse.papyrus.uml.nattable.celleditor.widget;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.papyrus.infra.nattable.common.celleditor.AbstractComboAction;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.nattable.celleditor.dataprovider.UMLSingleReferenceDataProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;


public class UMLDialogComboAction extends AbstractComboAction {

	private EStructuralFeature feature;



	public UMLDialogComboAction(final EStructuralFeature feature, IComboBoxDataProvider dataProvider) {
		super(dataProvider);
		this.feature = feature;
	}

	@Override
	public void run() {

		if(dataProvider instanceof UMLSingleReferenceDataProvider) {
			TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
			dialog.setTitle(feature.getEType().getName());//FIXME à vérifier
			dialog.setLabelProvider(new UMLLabelProvider());
			int currentIndex = combo.getSelectionIndex();
			List<?> values = dataProvider.getValues(columnIndex, rowIndex);
			Object initialSelection = null;
			if(currentIndex != -1) {
				initialSelection = values.get(currentIndex);
			}
			//			int rowIndex = getRowIndex();
			//			int columnIndex = getColumnIndex();
			EObject source = ((UMLSingleReferenceDataProvider)dataProvider).getEditedEObject(columnIndex, rowIndex);
			((UMLSingleReferenceDataProvider)dataProvider).getEditedFeature(columnIndex, rowIndex);
			final ITreeContentProvider provider = new UMLContentProvider(source, feature, null, source.eResource().getResourceSet());
			dialog.setContentProvider(provider);
			if(initialSelection != null) {
				dialog.setInitialElementSelections(Collections.singletonList(initialSelection));
			}
			int res = dialog.open();
			if(res == Window.OK) {
				//				setSel
				final Object[] result = dialog.getResult();
//				selection = result;
				//				final String convertedString = (String)converter.canonicalToDisplayValue(result);
				int index = values.indexOf(result[0]);
				combo.select(index);
			}

		}
	}


}
