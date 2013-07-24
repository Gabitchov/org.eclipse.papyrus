/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.menu;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLStereotypePropertyAxisManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.uml2.uml.Property;


/**
 * Menu factory to add/remove easily stereotype property columns
 * 
 * @author VL222926
 * 
 */
public class CreateColumnStereotypePropertyMenuFactory extends AbstractCreateStereotypePropertyMenuFactory {

	/** the label of the menu */
	public static final String MENU_LABEL = "Select Stereotype Properties Columns";

	/**
	 * the path of the icon to use for this menu
	 */
	private static final String ICON_PATH = "/icons/stereotypePropertyColumn.gif";

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateColumnStereotypePropertyMenuFactory() {
		super(MENU_LABEL, ICON_PATH);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.menu.AbstractCreateStereotypePropertyMenuFactory#fillMenu(org.eclipse.swt.widgets.Menu,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Collection, java.util.Map)
	 * 
	 * @param menu
	 * @param tableManager
	 * @param initialSelection
	 * @param nameToPropertyMap
	 */
	protected void fillMenu(final Menu menu, final INattableModelManager tableManager, final Collection<String> initialSelection, final Map<String, Property> nameToPropertyMap) {
		for(final String current : nameToPropertyMap.keySet()) {
			final MenuItem menuItem = new MenuItem(menu, SWT.CHECK);
			menuItem.setText(current); //$NON-NLS-1$
			if(initialSelection.contains(current)) {
				menuItem.setSelection(true);
			}
			menuItem.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					final boolean toAdd = menuItem.getSelection();
					if(toAdd) {
						Collection<Object> toAdds = Collections.singleton((Object)nameToPropertyMap.get(current));
						tableManager.addColumns(toAdds);
					} else {
						Collection<Object> toRemove = Collections.singleton((Object)nameToPropertyMap.get(current));
						tableManager.removeColumns(toRemove);
					}
				}


			});
		}

		boolean enabled = menu.getItemCount() != 0;
		menu.setEnabled(enabled);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.menu.AbstractCreateStereotypePropertyMenuFactory#getStereotypeAxisManager()
	 * 
	 * @return
	 */
	@Override
	protected UMLStereotypePropertyAxisManager getStereotypeAxisManager(final INattableModelManager tableManager) {
		return (UMLStereotypePropertyAxisManager)tableManager.getColumnAxisManager().getAdapter(UMLStereotypePropertyAxisManager.class);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.menu.AbstractCreateStereotypePropertyMenuFactory#getAxisElementList(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Collection<?> getAxisElementList(final INattableModelManager tableManager) {
		return tableManager.getColumnElementsList();
	}
}
