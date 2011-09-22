package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.ExtensionEnd;

/**
 * An IObservableValue for handling the UML ExtensionEnd#multiplicity
 * The multiplicity can only be either 1 or 0..1
 * 
 * @author Camille Letavernier
 * 
 */
public class ExtensionEndMultiplicityObservableValue extends MultiplicityObservableValue {

	public ExtensionEndMultiplicityObservableValue(ExtensionEnd source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public Command getCommand(Object value) {
		if(value == ONE || value == OPTIONAL) {
			return super.getCommand(value);
		}
		return UnexecutableCommand.INSTANCE;
	}
}
