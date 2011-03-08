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

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;
import org.eclipse.swt.graphics.Image;


public class UMLStyledStructureLabelProvider extends StyledCellLabelProvider implements ILabelProvider {

	private final ILabelProvider myDelegate;

	private final UMLDiffSwitch<StyledString> myDiffLabelSwitch;

	public UMLStyledStructureLabelProvider(ILabelProvider delegate) {
		myDelegate = delegate;
		myDiffLabelSwitch = new StyledDiffLabelSwitch(delegate);
	}

	public Image getImage(Object element) {
		if(element instanceof AbstractDiffExtension) {
			return (Image)((AbstractDiffExtension)element).getImage();
		}
		return myDelegate.getImage(element);
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

	public StyledString getStyledText(Object element) {
		if(element instanceof EObject) {
			StyledString diffElementLabel = myDiffLabelSwitch.doSwitch((EObject)element);
			if(diffElementLabel != null) {
				return diffElementLabel;
			}
		}
		String elementText = myDelegate.getText(element);
		if (elementText != null) {
			StyledString styledString = new StyledString();
			styledString.append(myDelegate.getText(element));
			return styledString;
		}
		return null;
	}


}
