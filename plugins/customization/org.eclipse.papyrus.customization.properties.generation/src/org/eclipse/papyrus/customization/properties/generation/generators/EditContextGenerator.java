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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.generators;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * Incubation
 *
 * An implementation of IGenerator used to re-generate a Context from an existing one
 *
 * @author Camille Letavernier
 */
public class EditContextGenerator implements IGenerator {

	public List<Context> generate(List<URI> targetURI) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createControls(Composite parent) {
		// TODO Auto-generated method stub

	}

	public String getDescription() {
		return Messages.EditContextGenerator_generateNewContext;
	}

	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return Messages.EditContextGenerator_importExistingContext;
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

	public List<DataContextElement> getContextElementsFor(Collection<Context> contexts, View view) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void removeListener(Listener listener) {
		// TODO Auto-generated method stub

	}

	public IObservableValue getObservableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getExternalReference() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStrategy(int strategy) {
		// TODO Auto-generated method stub

	}

	public void addCheckElement(Object obj) {
		// TODO Auto-generated method stub

	}

}
