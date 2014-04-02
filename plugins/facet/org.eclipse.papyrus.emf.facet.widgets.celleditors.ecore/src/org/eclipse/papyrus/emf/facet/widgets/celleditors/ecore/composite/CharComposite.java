/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *   Nicolas Bros (Mia-Software) - Bug 343655 - CharComposite : magic numbers
 *****************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore.composite;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ecore.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class CharComposite extends StringComposite<Character> {

	public CharComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	public CharComposite(final Composite parent, final int style) {
		super(parent, style);
		getTextField().addListener(SWT.Verify, new Listener() {

			public void handleEvent(final Event event) {
				if (event.keyCode != SWT.BS && event.keyCode != SWT.DEL) {
					if (CharComposite.this.getTextField().getSelectionCount() < 1) {
						if (CharComposite.this.getTextField().getText().length() >= 1) {
							event.doit = false;
							return;
						}
					}
				}
			}
		});
	}

	@Override
	public IConverter<Character> initConverter() {
		return new IConverter<Character>() {

			public Character toObject(final String string) {
				if (string != null && string.length() > 0) {
					try {
						return new Character(string.charAt(0));
					} catch (Exception e) {
						return null;
					}
				}
				return null;
			}

			public String toString(final Character object) {
				return object.toString();
			}
		};
	}

	@Override
	public IStatus validate(final String string) {
		if (string.length() == 1) {
			return new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ""); //$NON-NLS-1$

	}
}
