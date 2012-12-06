/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.databinding;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.MultipleObservableValue;


public class AggregatedPapyrusObservableValue extends MultipleObservableValue {

	private final List<CommandBasedObservableValue> observables = new LinkedList<CommandBasedObservableValue>();

	private final EditingDomain domain;

	public AggregatedPapyrusObservableValue(EditingDomain domain, IObservable... observableValues) {
		this.domain = domain;
		for(IObservable value : observableValues) {
			if(aggregate(value) == null) {
				throw new IllegalArgumentException("The input ObservableValues have an incorrect type"); //$NON-NLS-1$
			}
		}
	}

	@Override
	public AggregatedObservable aggregate(IObservable observable) {
		if(observable instanceof CommandBasedObservableValue) {
			if(!observables.isEmpty()) {
				Object valueType = observables.get(0).getValueType();
				if(((IObservableValue)observable).getValueType() != valueType) {
					return null;
				}
			}

			observables.add((CommandBasedObservableValue)observable);
			super.aggregate(observable);
			return this;
		}

		return null; //TODO : maybe we can support some other types
	}

	@Override
	public void doSetValue(Object value) {
		CompoundCommand command = new CompoundCommand();
		for(CommandBasedObservableValue observableValue : observables) {
			command.append(observableValue.getCommand(value));
		}
		domain.getCommandStack().execute(command);
	}


}
