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
package org.eclipse.papyrus.xwt;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.papyrus.xwt.metadata.IProperty;
import org.eclipse.swt.widgets.Event;

public interface IObservableValueListener {

	void registerValue(IProperty property, IObservableValue observableValue);

	IObservableValue getValue(IProperty property);

	void changeValueHandle(Object object, Event event);

	Object getHost();
}
