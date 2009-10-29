/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.pages.internal;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusPreferencePage;
import org.eclipse.swt.widgets.Composite;

/**
 * The default preference page for the
 * 
 * @author tlandre
 */
public class PapyrusDiagramsPreferencePage extends AbstractPapyrusPreferencePage {

	@Override
	protected void createPageContents(Composite parent) {
		// Do nothing
	}

	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	// @unused
	public static void initDefaults(IPreferenceStore store) {
		// TODO Auto-generated method stub
	}

}
