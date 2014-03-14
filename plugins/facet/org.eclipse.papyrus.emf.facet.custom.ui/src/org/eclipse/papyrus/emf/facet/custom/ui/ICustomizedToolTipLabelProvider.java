/**
 *  Copyright (c) 2012 CEA LIST.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.ui;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * This interface provides methods to customize tooltips
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizedToolTipLabelProvider {

	void update(ViewerCell cell);

	String getToolTipText(Object element, ETypedElement eTypedElement);

	Image getToolTipImage(Object element, ETypedElement eTypedElement);

	Font getToolTipFont(Object element, ETypedElement eTypedElement);

	Color getToolTipBackgroundColor(Object element, ETypedElement eTypedElement);

	Color getToolTipForegroundColor(Object element, ETypedElement eTypedElement);

	Image getToolTipTopLeftOverlay(Object element, ETypedElement eTypedElement);

	Image getToolTipTopMiddleOverlay(Object element, ETypedElement eTypedElement);

	Image getToolTipTopRightOverlay(Object element, ETypedElement eTypedElement);

	Image getToolTipBottomLeftOverlay(Object element,
			ETypedElement eTypedElement);

	Image getToolTipBottomMiddleOverlay(Object element,
			ETypedElement eTypedElement);

	Image getToolTipBottomRightOverlay(Object element,
			ETypedElement eTypedElement);

	int getToolTipTimeDisplayed(Object element, ETypedElement eTypedElement);

	int getToolTipDisplayDelayTime(Object element, ETypedElement eTypedElement);

	/**
	 * The style can be : SWT.LEFT, SWT.CENTER, SWT.RIGHT, SWT.SHADOW_IN, SWT.SHADOW_OUT, SWT.SHADOW_NONE.
	 * 
	 * @param element
	 * @return
	 */
	int getToolTipStyle(Object element, ETypedElement eTypedElement);
}
