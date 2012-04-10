/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.converters;

import java.util.Set;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.papyrus.xwt.XWT;

/**
 * Set to IObservableCollection converter
 * 
 * @author yyang
 */
public class SetToIObservableCollection implements IConverter {

	public static SetToIObservableCollection instance = new SetToIObservableCollection();

	public Object convert(Object fromObject) {
		Set<?> set = (Set<?>)fromObject;
		return new WritableSet(XWT.getRealm(), (Set<?>)set, Object.class);
	}

	public Object getFromType() {
		return Set.class;
	}

	public Object getToType() {
		return IObservableCollection.class;
	}
}
