/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *  Christian W. Damus (CEA) - 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.databinding;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.uml.tools.Activator;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.Extension;

/**
 * An ObservableValue to edit the derived "isRequired" property for a Stereotype Extension
 * The isRequired property is reverse derived to retrieve the lower bound of the extensionEnd
 * 
 * @author Camille Letavernier
 * 
 */
public class ExtensionRequiredObservableValue extends AbstractObservableValue implements IChangeListener, IObserving {

	private Extension extension;

	private MultiplicityObservableValue observable;

	private boolean currentValue;

	public ExtensionRequiredObservableValue(Extension extension, EditingDomain domain) {
		this.extension = extension;
		if(!this.extension.getOwnedEnds().isEmpty()) {
			observable = new MultiplicityObservableValue(this.extension.getOwnedEnds().get(0), domain);
			observable.addChangeListener(this);
		}
		currentValue = extension.isRequired();
	}

	public Object getValueType() {
		return Boolean.class;
	}

	@Override
	protected Boolean doGetValue() {
		return extension.isRequired();
	}

	@Override
	protected void doSetValue(Object value) {
		if(!(value instanceof Boolean)) {
			return;
		}

		Boolean required = (Boolean)value;

		if(extension.getOwnedEnds().isEmpty()) {
			Activator.log.warn("Unable to change the extension \"isRequired\" property");
		}

		observable.setValue(required ? MultiplicityParser.ONE : MultiplicityParser.OPTIONAL);
		currentValue = required;
	}
	
	public Object getObserved() {
		return extension;
	}

	@Override
	public void dispose() {
		observable.removeChangeListener(this);
		observable.dispose();
		observable = null;
		super.dispose();
	}

	public void handleChange(ChangeEvent event) {
		final boolean oldValue = currentValue;
		final boolean newValue = doGetValue();
		currentValue = newValue;
		fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return newValue;
			}
		});
	}

}
