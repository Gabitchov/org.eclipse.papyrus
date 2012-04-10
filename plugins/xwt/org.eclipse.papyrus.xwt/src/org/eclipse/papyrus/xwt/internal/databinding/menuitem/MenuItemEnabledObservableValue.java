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
import org.eclipse.swt.widgets.MenuItem;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class MenuItemEnabledObservableValue extends AbstractMenuItemObservableValue {

	public MenuItemEnabledObservableValue(MenuItem menuItem) {
		super(menuItem);
	}

	public MenuItemEnabledObservableValue(Realm realm, MenuItem menuItem) {
		super(realm, menuItem);
	}

	@Override
	protected Object doGetValue() {
		return getMenuItem().getEnabled();
	}

	public Object getValueType() {
		return Boolean.class;
	}

	protected void doSetValue(Object value) {
		getMenuItem().setEnabled((Boolean)value);
	}
}
