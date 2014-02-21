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
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore.composite;

import java.math.BigInteger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.facet.widgets.celleditors.ecore.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class BigIntegerComposite extends StringComposite<BigInteger> {

	public BigIntegerComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	public BigIntegerComposite(final Composite parent, final int style) {
		super(parent, style);
		getTextField().addListener(SWT.Verify, new Listener() {

			public void handleEvent(final Event event) {

				String input = event.text;
				for (int i = 0; i < input.length(); i++) {
					char ch = input.charAt(i);
					if (!('0' <= ch && ch <= '9')) {
						event.doit = false;
						return;
					}
				}
			}
		});
	}

	@Override
	public IConverter<BigInteger> initConverter() {
		return new IConverter<BigInteger>() {

			public BigInteger toObject(final String string) {
				if (string != null && string.length() > 0) {
					try {
						return new BigInteger(string);
					} catch (Exception e) {
						return null;
					}
				}
				return null;
			}

			public String toString(final BigInteger object) {
				return object.toString();
			}
		};
	}

	@Override
	@SuppressWarnings("unused")
	// The instantiation of the BigInteger is only used to validate this string
	public IStatus validate(final String string) {
		try {
			new BigInteger(string);
		} catch (Exception e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
	}

}
