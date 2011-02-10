/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.structure;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;


public class UMLStyledStructureLabelProvider extends StyledCellLabelProvider implements ILabelProvider {

	UMLModelStructureLabelProvider delegate;

	public UMLStyledStructureLabelProvider() {
		delegate = new UMLModelStructureLabelProvider();
	}

	public Image getImage(Object element) {
		return delegate.getImage(element);
	}

	public String getText(Object element) {
		return getStyledText(element).getString();
	}

	public void update(ViewerCell cell) {
		StyledString string = getStyledText(cell.getElement());
		cell.setText(string.getString());
		cell.setStyleRanges(string.getStyleRanges());
		cell.setImage(getImage(cell.getElement()));
		super.update(cell);
	}

	private StyledString getStyledText(Object element) {
		StyledString styledString = new StyledString();
		styledString.append(delegate.getText(element));
		styledString.append(' ');
		styledString.append('(', StyledString.QUALIFIER_STYLER);
		styledString.append("bla-bla", StyledString.QUALIFIER_STYLER);
		styledString.append(')', StyledString.QUALIFIER_STYLER);
		return styledString;
	}


}
