/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.papyrus.uml.diagram.wizards.INewModelStorageProvider.ISelectProviderPart;

/**
 * This is the AbstractSelectStorageProviderPart type. Enjoy.
 */
public abstract class AbstractSelectStorageProviderPart
		implements ISelectProviderPart {

	private final CopyOnWriteArrayList<IPartCompleteListener> listeners = new CopyOnWriteArrayList<IPartCompleteListener>();

	private boolean enabled;

	public AbstractSelectStorageProviderPart() {
		super();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

		enableControls(enabled);
	}

	protected abstract void enableControls(boolean enabled);

	public void addPartCompleteListener(IPartCompleteListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removePartCompleteListener(IPartCompleteListener listener) {
		listeners.remove(listener);
	}

	protected void firePartCompleteChanged() {
		for (IPartCompleteListener next : listeners) {
			try {
				next.partCompletenessChanged(this);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in part-complete listener.", e);
			}
		}
	}
}
