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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Stereotype;


/**
 * The Class QualifiedNameAppearanceSection allow users to customize the display of qualified name.
 * 
 */
public class ImageIndexSection extends AbstractViewSection {

	/**
	 * The index of the image in the Stereotype
	 */
	private CCombo comboIndex;

	/**
	 * Section Label
	 */
	private CLabel label;

	/**
	 * The combo listener.
	 */
	private final SelectionListener indexSelectionListener = new IndexSelectionListener();

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
		comboIndex = getWidgetFactory().createCCombo(composite);
		refreshComboValues();
		data = new FormData();
		data.left = new FormAttachment(0, 85);
		data.top = new FormAttachment(0, 0);
		comboIndex.setLayoutData(data);
		comboIndex.addSelectionListener(indexSelectionListener);

		// Label creation
		label = getWidgetFactory().createCLabel(composite, "Index:");
		data = new FormData();
		data.left = new FormAttachment(0, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(comboIndex, 0, SWT.CENTER);
		label.setLayoutData(data);
	}

	/**
	 * Refresh the possible values of the combo box
	 */
	private void refreshComboValues() {
		comboIndex.removeAll();

		if ((getElement() != null) && (getElement() instanceof Image)) {

			Image image = (Image) getElement();

			// Retrieve parent Stereotype
			Element owner = image.getOwner();
			if ((owner != null) && (owner instanceof Stereotype)) {
				Stereotype stOwner = ((Stereotype) owner);

				for (int i = 0; i < stOwner.getIcons().size(); i++) {
					comboIndex.add("" + i);
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 *
	 */
	@Override
	public void refresh() {
		if ((!comboIndex.isDisposed())) {

			comboIndex.removeSelectionListener(indexSelectionListener);

			refreshComboValues();

			// setSelection
			if ((getElement() != null) && (getElement() instanceof Image)) {

				Image image = (Image) getElement();

				// Retrieve parent Stereotype
				Element owner = image.getOwner();
				if ((owner != null) && (owner instanceof Stereotype)) {
					Stereotype stOwner = ((Stereotype) owner);

					int currentIndex = stOwner.getIcons().indexOf(image);
					comboIndex.select(currentIndex);
				}
			}

			// Add the listener back
			comboIndex.addSelectionListener(indexSelectionListener);
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 *
	 */
	public void dispose() {
		super.dispose();
		if (comboIndex != null && !comboIndex.isDisposed())
			comboIndex.removeSelectionListener(indexSelectionListener);
	}

	protected class IndexSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {







			final TransactionalEditingDomain domain=	EditorUtils.getTransactionalEditingDomain();
			if (domain!=null ) {
				final Runnable runnable = new Runnable() {

					/**
					 * {@inheritDoc}
					 */
					public void run() {
						if ((getElement() != null) && (getElement() instanceof Image)) {

							Image image = (Image) getElement();

							// Retrieve parent Stereotype
							Element owner = image.getOwner();
							if ((owner != null) && (owner instanceof Stereotype)) {
								Stereotype stOwner = ((Stereotype) owner);
								int currentIndex = stOwner.getIcons().indexOf(image);
								int newIndex = comboIndex.getSelectionIndex();
								if (currentIndex != newIndex) {
									stOwner.getIcons().move(newIndex, image);
								}
							}
						}}};
						Command emfCommand = new ChangeCommand(domain, runnable, "Edit " + label);
						domain.getCommandStack().execute(emfCommand);
						EditorUtils.getMultiDiagramEditor().setFocus();
			}

			else {
				System.err.println( "could not commit changes to the model");
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {

		}
	}
}
