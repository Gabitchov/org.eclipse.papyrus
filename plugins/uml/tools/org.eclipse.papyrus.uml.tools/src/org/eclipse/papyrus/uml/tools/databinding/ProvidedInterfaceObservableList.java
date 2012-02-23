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
package org.eclipse.papyrus.uml.tools.databinding;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An IObservableList to edit the UML Derived feature {@link Port#getProvideds()}
 * 
 * @author Camille Letavernier
 * 
 */
public class ProvidedInterfaceObservableList extends PapyrusObservableList {

	protected Port port;

	public ProvidedInterfaceObservableList(Port source, EditingDomain domain) {
		super(EMFProperties.list(UMLPackage.eINSTANCE.getPort_Provided()).observe(source), domain, source, UMLPackage.eINSTANCE.getPort_Provided());
		this.port = source;
	}

	@Override
	public Command getRemoveCommand(Object value) {
		throw new UnsupportedOperationException("TODO"); //TODO
	}

	@Override
	public Command getRemoveAllCommand(Collection<?> values) {
		throw new UnsupportedOperationException("TODO"); //TODO
	}

	@Override
	public Command getAddCommand(int index, Object value) {
		if(!(value instanceof Interface)) {
			throw new IllegalArgumentException("The value must be an Interface"); //$NON-NLS-1$
		}
		Interface providedInterface = (Interface)value;

		//Pseudo code
		//Use a command
		//Use the Papyrus UML Layer
		//InterfaceRealization realization = createInterfaceRealization(providedInterface);
		//((org.eclipse.uml2.uml.Class)port.getType()).getInterfaceRealizations().add(realization);
		throw new UnsupportedOperationException("TODO"); //TODO
	}

	@Override
	public Command getAddCommand(Object value) {
		throw new UnsupportedOperationException("TODO"); //TODO
	}

	@Override
	public Command getAddAllCommand(Collection<?> values) {
		throw new UnsupportedOperationException("TODO"); //TODO
	}

	@Override
	public Command getAddAllCommand(int index, Collection<?> values) {
		throw new UnsupportedOperationException("TODO"); //TODO
	}

}
