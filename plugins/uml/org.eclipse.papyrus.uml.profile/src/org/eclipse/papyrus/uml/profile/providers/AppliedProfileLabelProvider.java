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
package org.eclipse.papyrus.uml.profile.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Profile;

public class AppliedProfileLabelProvider extends StyledCellLabelProvider {

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
		if(columnIndex == 1 && element instanceof Profile) {
			Profile profile = (Profile)element;

			StyledString styledString = new StyledString(profile.getQualifiedName());

			return styledString;
		}

		return new StyledString(getText(element, columnIndex));
	}

	protected String getText(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return umlLabelProvider.getText(element);
		case 1:
			if(element instanceof Profile) {
				return ((Profile)element).getQualifiedName();
			}
		default:
			return "";
		}
	}

	protected Image getImage(Object element, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return umlLabelProvider.getImage(element);
		case 1:
			if(element instanceof Profile) {
				return umlLabelProvider.getImage(element);
			}
		default:
			return null;
		}
	}

}
