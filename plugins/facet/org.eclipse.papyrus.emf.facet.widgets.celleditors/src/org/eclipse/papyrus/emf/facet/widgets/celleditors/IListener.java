/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors;

public interface IListener {
	/** Sent when an event that the receiver has registered for occurs. */
	void handleEvent();
}
