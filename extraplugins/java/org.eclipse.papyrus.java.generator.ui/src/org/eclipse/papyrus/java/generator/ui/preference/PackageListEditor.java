/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.preference;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.internal.ui.preferences.TypeFilterInputDialog;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * Used to select packages from the dialog.
 * 
 * @author DEBLOCK Nicolas and GILES Manuel
 */
public class PackageListEditor extends ListEditor {

	/**
	 * Constructor.
	 * 
	 * @param name
	 * @param labelText
	 * @param parent
	 */
	PackageListEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
	}

	@Override
	/**
	 * Functionality for New button.
	 * Shows a browser dialog to select a file and returns that file.
	 */
	protected String getNewInputObject() {
		//Dialog p = new JDialog();
		List<String> l = new LinkedList<String>();


		TypeFilterInputDialog d = new TypeFilterInputDialog(getShell(), l);
		d.open();
		Object pack = d.getResult();

		return pack.toString();
	}

	@Override
	protected String createList(String[] items) {
		StringBuffer str = new StringBuffer();
		for(String item : items)
			str.append(item + ";");
		return str.toString();
	}

	/*
	 * (non-Javadoc)
	 * initialize list of items
	 * 
	 * @see org.eclipse.jface.preference.ListEditor#parseString(java.lang.String)
	 */
	@Override
	protected String[] parseString(String stringList) {
		return stringList.split(";");
	}

}
