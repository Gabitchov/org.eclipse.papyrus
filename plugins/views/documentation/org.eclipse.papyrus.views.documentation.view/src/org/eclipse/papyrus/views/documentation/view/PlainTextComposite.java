/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * A SpellingText composite used to edit some documentation in a plain text mode.<br>
 * Creation : 20 August 2008<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class PlainTextComposite extends SpellingTextComposite {


	/**
	 * Menu id for the overview ruler context menu.
	 * 
	 * 
	 * @since 3.4
	 */
	public final static String DEFAULT_OVERVIEW_RULER_CONTEXT_MENU_ID = "#OverviewRulerContext"; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the composite style
	 */
	public PlainTextComposite(Composite parent, int style) 
	{
		super(parent, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP, true);
	}

	/**
	 * Sets the given text into the <code>EAnnotationCommentsComposite</code>
	 * 
	 * @param text
	 *            text to put into the <code>EAnnotationCommentsComposite</code>
	 */
	public void setDocumentationValue(String text) {
		setText(text);
	}

	/**
	 * This method returns the text contained in the
	 * <code>EAnnotationCommentsComposite</code>
	 * 
	 * @return the text contained in the
	 *         <code>EAnnotationCommentsComposite</code>
	 */
	public String getDocumentationValue() {
		return getText();
	}

	/**
	 * @return true if the text area is selected, false else
	 * 
	 * @see org.eclipse.swt.widgets.Composite#setFocus()
	 */
	@Override
	public boolean setFocus() {
		if (document != null && !sourceViewer.getControl().isDisposed()) {
			return sourceViewer.getControl().setFocus();
		}
		return false;
	}

	/**
	 * Enable or disable the text area
	 */
	@Override
	public void setEnabled(boolean enabled) {
		if (!isDisposed())
		{
			super.setEnabled(enabled);
		}
	}

}
