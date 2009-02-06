/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.tabbedproperties.core.forms;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.UMLPackage;

public class AdvancedReferencedTable extends ReferencedTable {

	boolean valueSpecification = false;

	private Menu menu;

	private EClass[] allValueSpecification = { UMLPackage.eINSTANCE.getExpression(), UMLPackage.eINSTANCE.getStringExpression(), UMLPackage.eINSTANCE.getInstanceValue(),
			UMLPackage.eINSTANCE.getInterval(), UMLPackage.eINSTANCE.getDurationInterval(), UMLPackage.eINSTANCE.getTimeInterval(), UMLPackage.eINSTANCE.getLiteralBoolean(),
			UMLPackage.eINSTANCE.getLiteralInteger(), UMLPackage.eINSTANCE.getLiteralNull(), UMLPackage.eINSTANCE.getLiteralString(), UMLPackage.eINSTANCE.getLiteralUnlimitedNatural(),
			UMLPackage.eINSTANCE.getOpaqueExpression(), UMLPackage.eINSTANCE.getExpression(), UMLPackage.eINSTANCE.getTimeExpression() };

	public AdvancedReferencedTable(String labeltoDisplay, ViewerFilter filter, BackboneContext backboneContext) {
		super(labeltoDisplay, filter, backboneContext);
		valueSpecification = false;
	}

	public void setValueSpecification(boolean valueSpecification) {
		this.valueSpecification = valueSpecification;
		adaptView();
	}

	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		// if the form has to manage Value spec, menu has to be added
		adaptView();

	}

	/**
	 *{@inheritDoc}
	 */
	public void setBackboneContext(BackboneContext backboneContext) {
		super.setBackboneContext(backboneContext);
		if (menu != null) {
			// because we have the backbone context we can fill each items
			for (int i = 0; i < menu.getItems().length; i++) {
				menu.getItem(i).setText(getLabelProvider().getText(allValueSpecification[i].getName()));
				menu.getItem(i).setImage(getLabelProvider().getImage(allValueSpecification[i].getInstanceClass()));
			}
		}
	}

	protected void adaptView() {
		if (valueSpecification) {

			// create a menu
			menu = new Menu(addButton);
			addButton.setMenu(menu);
			for (int i = 0; i < allValueSpecification.length; i++) {
				MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
				menuItem.addSelectionListener(new fireCreateElement(allValueSpecification[i]));
			}

			addButton.setMenu(menu);
			// change the listener on the button
			addButton.removeMouseListener(addButtonlistener);
			addButton.addMouseListener(new MouseListener() {

				public void mouseDoubleClick(MouseEvent e) {
				}

				public void mouseDown(MouseEvent e) {
					menu.setVisible(true);
				}

				public void mouseUp(MouseEvent e) {
				}
			});
		}

	}

	public class fireCreateElement implements SelectionListener {

		private EClass eclass;

		/**
		 * Create a listener for popmenu item with the eclass to create
		 * 
		 * @param eclass
		 *            the eclass to create when the item is selected
		 */
		public fireCreateElement(EClass eclass) {
			super();
			this.eclass = eclass;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			System.err.println("test widgetDefaultSelected");
		}

		public void widgetSelected(SelectionEvent e) {
			if (createElement != null) {
				createElement.fireCreate(eclass);
			}
		}

		public EClass getEclass() {
			return eclass;
		}
	}
}
