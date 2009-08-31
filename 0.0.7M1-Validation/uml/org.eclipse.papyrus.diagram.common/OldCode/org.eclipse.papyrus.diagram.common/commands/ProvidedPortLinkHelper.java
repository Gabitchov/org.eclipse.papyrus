/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class ProvidedPortLinkHelper {

	private final AdapterFactoryEditingDomain myEditingDomain;

	private final EObject mySource;

	private final EObject myTarget;

	public ProvidedPortLinkHelper(AdapterFactoryEditingDomain editingDomain, EObject source, EObject target) {
		myEditingDomain = editingDomain;
		mySource = source;
		myTarget = target;
	}

	public void create() {
		Port port = getSource();
		Interface targetInterface = getTarget();
		if (port == null || targetInterface == null) {
			return;
		}
		// we can not modify derived Port#getProvideds() directly,
		// so we will mimic the logic from the PortOperations#getProvideds()
		Type portType = port.getType();
		if (portType == null) {
			port.setType(targetInterface);
			return;
		}
		if (portType instanceof Classifier) {
			// then it is new Realization for this classifier
			createRealization(port, targetInterface, (Classifier) portType);
		}
		return;
	}

	private Realization createRealization(Port port, Interface targetInterface, Classifier portType) {
		Package realizationContainer = null;
		for (EObject element = getSource(); element != null; element = element.eContainer()) {
			if (element instanceof Package) {
				realizationContainer = (Package) element;
				break;
			}
		}
		if (realizationContainer == null) {
			return null;
		}
		Realization realization = UMLFactory.eINSTANCE.createInterfaceRealization();
		realizationContainer.getPackagedElements().add(realization);
		realization.getClients().add(portType);
		realization.getSuppliers().add(targetInterface);
		return realization;
	}

	public boolean canCreate() {
		return true;
	}

	private Port getSource() {
		return (Port) mySource;
	}

	private Interface getTarget() {
		return (Interface) myTarget;
	}

}
