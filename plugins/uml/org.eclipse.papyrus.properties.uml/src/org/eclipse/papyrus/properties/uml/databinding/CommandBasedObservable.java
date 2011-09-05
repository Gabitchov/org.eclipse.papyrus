package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.common.command.Command;


public interface CommandBasedObservable extends IObservable {

	/**
	 * Returns the EMF Command for modifying this Observable's value
	 * 
	 * @param value
	 * @return
	 */
	public Command getCommand(Object value);
}
