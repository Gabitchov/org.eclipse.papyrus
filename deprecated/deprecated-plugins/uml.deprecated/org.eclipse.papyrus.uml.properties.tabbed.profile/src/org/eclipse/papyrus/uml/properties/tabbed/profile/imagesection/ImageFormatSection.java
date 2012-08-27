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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbed.profile.imagesection;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.uml.properties.tabbed.profile.AbstractViewSection;
import org.eclipse.papyrus.uml.properties.tabbed.profile.composite.TextCompositeWithModelAccessor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The Image Format section on the element tab.
 */
public class ImageFormatSection extends AbstractViewSection {

	/**
	 * 
	 */
	private TextCompositeWithModelAccessor formatComposite;

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 *
	 * @param parent
	 * @param tabbedPropertySheetPage
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		formatComposite = new TextCompositeWithModelAccessor("Format:", UMLPackage.IMAGE__FORMAT);
		formatComposite.createContent(parent, tabbedPropertySheetPage.getWidgetFactory());
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 *
	 */
	public void refresh() {
		formatComposite.refresh();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.properties.tabbed.profile.AbstractViewSection#setInput(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 *
	 * @param part
	 * @param selection
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (getElement()!=null) {
			formatComposite.setElement(getElement());
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 *
	 */

	public void dispose() {
		 super.dispose();
		 if (formatComposite != null) {
			 formatComposite.dispose();
		 }
	 }
}