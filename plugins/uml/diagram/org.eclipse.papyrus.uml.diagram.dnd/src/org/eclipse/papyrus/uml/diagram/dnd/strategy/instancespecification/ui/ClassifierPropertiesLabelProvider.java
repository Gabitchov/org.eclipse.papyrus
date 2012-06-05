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
package org.eclipse.papyrus.uml.diagram.dnd.strategy.instancespecification.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;

/**
 * A LabelProvider for the Classifiers' properties
 * 
 * @author Camille Letavernier
 */
public class ClassifierPropertiesLabelProvider extends StyledCellLabelProvider {

	private final ILabelProvider umlLabelProvider = new UMLLabelProvider();

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		int columnIndex = cell.getColumnIndex();

		StyledString styledText = getStyledText(element, columnIndex);

		cell.setText(styledText.getString());
		cell.setStyleRanges(styledText.getStyleRanges());
		cell.setImage(getImage(element, columnIndex));
	}

	protected StyledString getStyledText(Object element, int columnIndex) {
		//		if(columnIndex == 1 && element instanceof Property) {
		//			Property property = (Property)element;
		//			String classifierLabel = umlLabelProvider.getText(property.getOwner());
		//			String qualifiedName = " (" + ((Classifier)property.getOwner()).getQualifiedName() + ")";
		//
		//			StyledString styledString = new StyledString(classifierLabel);
		//			styledString.append(qualifiedName, StyledString.QUALIFIER_STYLER);
		//
		//			return styledString;
		//		}

		if(columnIndex == 1 && element instanceof Classifier) {
			Classifier classifier = (Classifier)element;

			StyledString styledString = new StyledString(classifier.getQualifiedName(), StyledString.QUALIFIER_STYLER);

			return styledString;
		}

		return new StyledString(getText(element, columnIndex));
	}

	protected String getText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return umlLabelProvider.getText(element);
		default:
			return "";
		}
	}

	protected Image getImage(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return umlLabelProvider.getImage(element);
		case 1:
			//			if(element instanceof Property) {
			//				return umlLabelProvider.getImage(((Property)element).getOwner());
			//			}
			if(element instanceof Classifier) {
				return umlLabelProvider.getImage(element);
			}
		default:
			return null;
		}
	}
}
