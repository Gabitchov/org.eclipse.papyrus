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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.properties.tabbed.profile.AbstractViewSection;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Image;


/**
 * The Class QualifiedNameAppearanceSection allow users to customize the display of qualified name.
 * 
 */
public class ImageKindSection extends AbstractViewSection {

	/**
	 * The index of the image in the Stereotype
	 */
	private CCombo comboKind;

	/**
	 * Section Label
	 */
	private CLabel label;

	/**
	 * The combo listener.
	 */
	private final SelectionListener selectionListener = new KindSelectionListener();

	/**
	 * Creates the controls.
	 * 
	 * @param tabbedPropertySheetPage
	 *            the tabbed property sheet page
	 * @param parent
	 *            the parent
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		// // Combo creation
		comboKind = getWidgetFactory().createCCombo(composite);
		addComboValues();
		data = new FormData();
		data.left = new FormAttachment(0, 85);
		data.top = new FormAttachment(0, 0);
		comboKind.setLayoutData(data);
		comboKind.addSelectionListener(selectionListener);

		// Label creation
		label = getWidgetFactory().createCLabel(composite, "Kind:");
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(comboKind, 0, SWT.CENTER);
		label.setLayoutData(data);
	}

	/**
	 * Add the possible values of the combo box
	 */
	private void addComboValues() {
		comboKind.add("undefined");
		comboKind.add("icon");
		comboKind.add("shape");
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 *
	 */
	@Override
	public void refresh() {
		if ((!comboKind.isDisposed())) {

			// setSelection
			if ((getElement() != null) && (getElement() instanceof Image)) {

				Image image = (Image) getElement();
				String kind = ImageUtil.getKind(image);

				if ("icon".equals(kind)) {
					comboKind.select(1);
				} else if ("shape".equals(kind)) {
					comboKind.select(2);
				} else { // undefined
					comboKind.select(0);
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 *
	 */
	public void dispose() {
		super.dispose();
		if (comboKind != null && !comboKind.isDisposed())
			comboKind.removeSelectionListener(selectionListener);
	}

	protected class KindSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {

			if ((getElement() != null) && (getElement() instanceof Image)) {

				final TransactionalEditingDomain domain=	EditorUtils.getTransactionalEditingDomain();
				if (domain!=null ) {
					final Runnable runnable = new Runnable() {

						/**
						 * {@inheritDoc}
						 */
						public void run() {
							Image image = (Image) getElement();
							String kind = ImageUtil.getKind(image);
							int newIndex = comboKind.getSelectionIndex();
							if ((newIndex == 1) && !("icon".equals(kind))) {
								ImageUtil.setKind(image, "icon");
							} else if ((newIndex == 2) && !("shape".equals(kind))) {
								ImageUtil.setKind(image, "shape");
							} else {
								ImageUtil.setKind(image, "");
							}
						}
					};
					Command emfCommand = new ChangeCommand(domain, runnable, "Edit " + label);
					domain.getCommandStack().execute(emfCommand);
					EditorUtils.getMultiDiagramEditor().setFocus();
				} else {
					System.err.println( "could not commit changes to the model");
				}
				
				

			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {

		}
	}
}
