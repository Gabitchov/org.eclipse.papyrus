/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.databinding.menuitem;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.MenuItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public abstract class AbstractMenuItemObservableValue extends AbstractObservableValue {

	private final MenuItem menuItem;

	/**
	 * Standard constructor for a MenuItem ObservableValue. Makes sure that the observable gets disposed when the MenuItem is disposed.
	 * 
	 * @param widget
	 */
	protected AbstractMenuItemObservableValue(MenuItem menuItem) {
		this(SWTObservables.getRealm(menuItem.getDisplay()), menuItem);
	}

	/**
	 * Constructor that allows for the setting of the realm. Makes sure that the observable gets disposed when the MenuItem is disposed.
	 * 
	 * @param realm
	 * @param widget
	 * @since 1.2
	 */
	protected AbstractMenuItemObservableValue(Realm realm, MenuItem menuItem) {
		super(realm);
		this.menuItem = menuItem;
		menuItem.addDisposeListener(disposeListener);
	}

	private DisposeListener disposeListener = new DisposeListener() {

		public void widgetDisposed(DisposeEvent e) {
			AbstractMenuItemObservableValue.this.dispose();
		}
	};

	/**
	 * @return Returns the MenuItem.
	 */
	public MenuItem getMenuItem() {
		return menuItem;
	}
}
