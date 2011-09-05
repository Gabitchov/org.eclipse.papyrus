package org.eclipse.papyrus.properties.uml.databinding;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.databinding.MultipleObservableValue;
import org.eclipse.papyrus.widgets.databinding.AggregatedObservable;


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
