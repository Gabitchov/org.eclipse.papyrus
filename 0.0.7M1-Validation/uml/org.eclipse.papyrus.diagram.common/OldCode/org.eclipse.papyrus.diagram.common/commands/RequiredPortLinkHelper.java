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
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

public class RequiredPortLinkHelper {

	private final AdapterFactoryEditingDomain myEditingDomain;

	private final EObject mySource;

	private final EObject myTarget;

	public RequiredPortLinkHelper(AdapterFactoryEditingDomain editingDomain, EObject source, EObject target) {
		myEditingDomain = editingDomain;
		mySource = source;
		myTarget = target;
	}

	public void create() {
		if (getSource() == null || getTarget() == null || getSource().getType() == null) {
			return;
		}
		Type type = getSource().getType();
		if (type instanceof Classifier && !(type instanceof Interface)) {
			Classifier classifier = (Classifier) type;
			classifier.createUsage(getTarget());
		}
	}

	public boolean canCreate() {
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		Type type = getSource().getType();
		if (type == null) {
			return false;
		}
		if (false == type instanceof Classifier || (type instanceof Interface)) {
			return false;
		}
		boolean isReadOnly = myEditingDomain.isReadOnly(type.eResource());
		return !isReadOnly;
	}

	private Port getSource() {
		return (Port) mySource;
	}

	private Interface getTarget() {
		return (Interface) myTarget;
	}

}
