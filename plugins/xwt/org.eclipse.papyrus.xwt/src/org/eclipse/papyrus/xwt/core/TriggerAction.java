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
package org.eclipse.papyrus.xwt.core;

import org.eclipse.swt.widgets.Event;

public abstract class TriggerAction {

	public static final TriggerAction[] EMPTY_ARRAY = new TriggerAction[0];

	public abstract void run(Event event, Object target, Runnable stateChangedRunnable);

	public abstract void initialize(Object target);

	public abstract void endFinalize(Object target);
}
