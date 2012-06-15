/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.importt.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.papyrus.infra.widgets.editors.EnumRadio;
import org.eclipse.papyrus.uml.profile.ui.dialogs.PackageImportTreeSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;

/**
 * An import package dialog, with the option to import a copy of the selected package
 * 
 * @author Camille Letavernier
 */
public class PackageImportDialog extends PackageImportTreeSelectionDialog {

	protected boolean copy = false;

	public PackageImportDialog(Shell parent, Package model) {
		super(parent, model);
	}

	@Override
	public Composite createDialogArea(Composite parent) {
		Composite result = (Composite)super.createDialogArea(parent);

		EnumRadio radio = new EnumRadio(result, SWT.NONE);

		Map<Object, String> objectsToLabelsMap = new LinkedHashMap<Object, String>();
		objectsToLabelsMap.put(Boolean.FALSE, "Import package");
		objectsToLabelsMap.put(Boolean.TRUE, "Copy package");
		radio.setEnumValues(objectsToLabelsMap);

		radio.setModelObservable(new AbstractObservableValue() {

			public Object getValueType() {
				return Boolean.class;
			}

			@Override
			protected Boolean doGetValue() {
				return copy;
			}

			@Override
			protected void doSetValue(Object value) {
				if(value instanceof Boolean) {
					copy = (Boolean)value;
				}
			}

		});

		return result;
	}

	/**
	 * Indicates whether we should make a copy of the selected package, or
	 * import it
	 * 
	 * @return true if the package should be copied
	 */
	public boolean isCopy() {
		return copy;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

}
