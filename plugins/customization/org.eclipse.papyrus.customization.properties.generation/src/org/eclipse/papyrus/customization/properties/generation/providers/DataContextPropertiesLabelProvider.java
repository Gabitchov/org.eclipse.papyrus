/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.providers;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.customization.properties.generation.wizard.SelectFieldsPage;
import org.eclipse.papyrus.customization.properties.providers.ContextLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.swt.graphics.Image;

public class DataContextPropertiesLabelProvider extends StyledCellLabelProvider {

	private final SelectFieldsPage selectFieldsPage;

	private final ILabelProvider labelProvider;

	public DataContextPropertiesLabelProvider(SelectFieldsPage selectFieldsPage) {
		this.selectFieldsPage = selectFieldsPage;
		labelProvider = new ContextLabelProvider();
	}

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		int columnIndex = cell.getColumnIndex();

		StyledString styleText = getStyledText(element, columnIndex);

		cell.setText(styleText.getString());
		cell.setStyleRanges(styleText.getStyleRanges());
		cell.setImage(getImage(element, columnIndex));
	}

	protected StyledString getStyledText(Object element, int columnIndex) {
		String text = getText(element, columnIndex);

		if(columnIndex == selectFieldsPage.fieldColumn) {
			EObject eObject = EMFHelper.getEObject(element);
			if(!(eObject instanceof Property)) {
				StyledString styledString = new StyledString(text, StyledString.QUALIFIER_STYLER);

				return styledString;
			}
		}

		//	if(columnIndex == selectFieldsPage.selectionSingleColumn) {
		//		//Nothing
		//	}
		//
		//	if(columnIndex == selectFieldsPage.selectionMultipleColumn) {
		//		//Nothing
		//	}
		//
		//	if(columnIndex == selectFieldsPage.descriptionColumn) {
		//		//Nothing
		//	}

		//Default
		return new StyledString(text);
	}

	protected String getText(Object element, int columnIndex) {
		if(columnIndex == selectFieldsPage.fieldColumn) {
			return labelProvider.getText(element);
		}

		//	if(columnIndex == selectFieldsPage.selectionSingleColumn) {
		//		//Nothing
		//	}
		//
		//	if(columnIndex == selectFieldsPage.selectionMultipleColumn) {
		//		//Nothing
		//	}

		if(columnIndex == selectFieldsPage.descriptionColumn) {
			EObject eObject = EMFHelper.getEObject(element);
			if(eObject instanceof Property) {
				String description = ((Property)element).getDescription();
				if(description != null) {
					return description.replaceAll("[\n\r]+", "\\\\");
				}

				return "";
			}
		}

		//Default
		return "";
	}

	protected Image getImage(Object element, int columnIndex) {
		if(columnIndex == selectFieldsPage.fieldColumn) {
			return labelProvider.getImage(element);
		}

		//	if(columnIndex == selectFieldsPage.selectionSingleColumn) {
		//		//Nothing
		//	}
		//
		//	if(columnIndex == selectFieldsPage.selectionMultipleColumn) {
		//		//Nothing
		//	}
		//
		//	if(columnIndex == selectFieldsPage.descriptionColumn) {
		//		//Nothing
		//	}

		//Default
		return null;
	}

}
