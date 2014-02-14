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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.facet.widgets.celleditors.IValidator;
import org.eclipse.emf.facet.widgets.celleditors.ecore.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class FloatComposite extends StringComposite<Float> {

	public FloatComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	public FloatComposite(final Composite parent, final int style) {
		super(parent, style);

		getTextField().addListener(SWT.Verify, new Listener() {

			public void handleEvent(final Event event) {

				String input = event.text;
				for (int i = 0; i < input.length(); i++) {
					char ch = input.charAt(i);
					if (ch != '-') {
						if (ch == '.') {
							if (FloatComposite.this.getTextField().getText().indexOf('.') != -1) {
								event.doit = false;
								return;
							}
						} else {
							if (!('0' <= ch && ch <= '9')) {
								event.doit = false;
								return;
							}
						}
					} else {
						if (FloatComposite.this.getTextField().getText().indexOf('-') != -1) {
							event.doit = false;
							return;
						}
						// If the '-' caracter is not type at the beginning of
						// the String
						if (event.start != 0) {
							event.doit = false;
							return;
						}
					}
				}
			}

		});
	}

	@Override
	public IValidator getValidator() {
		return new IValidator() {
			public IStatus validate(final Object object) {
				if (getValue() != null) {
					if (Float.MIN_VALUE <= getValue().floatValue()
							&& getValue().floatValue() <= Float.MAX_VALUE) {
						return Status.OK_STATUS;
					}
				}
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
			}
		};
	}

	@Override
	public IConverter<Float> initConverter() {
		return new IConverter<Float>() {

			public Float toObject(final String string) {
				if (string != null && string.length() > 0) {
					try {
						return new Float(string);
					} catch (Exception e) {
						return null;
					}
				}
				return null;
			}

			public String toString(final Float object) {
				return object.toString();
			}
		};
	}

	@Override
	public IStatus validate(final String string) {
		try {
			if (string.length() > 0) {
				Float.parseFloat(string);
			}
		} catch (Exception e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
		}
		return new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
	}
}
