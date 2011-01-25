/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.generators;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;


public class EditContextGenerator implements IGenerator {

	public Context generate(URI targetURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createControls(Composite parent) {
		// TODO Auto-generated method stub

	}

	public String getDescription() {
		return "Generates a new context from an existing one";
	}

	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return "Import existing context";
	}

	public boolean isSelectedSingle(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSelectedMultiple(Property property) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSelectedSingle(Property property, DataContextElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSelectedMultiple(Property property, DataContextElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addListener(Listener listener) {
		// TODO Auto-generated method stub

	}

}
