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
package org.eclipse.papyrus.diagram.common.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class InterfaceLinkFilter<T> {

	protected final boolean ourHideReferencedGenuine;

	protected final boolean ourHideDerived;

	private final Collection<T> myInterfaceLinks = new LinkedList<T>();

	private final List<Classifier> myClassifiersTypingPort = new ArrayList<Classifier>(1);

	public InterfaceLinkFilter(boolean hideDerived, boolean hideReferencedGenuine) {
		ourHideDerived = hideDerived;
		ourHideReferencedGenuine = hideReferencedGenuine;
	}

	public void visit(T link) {
		visitReqiredOrProvidedInterfaceLink(link);
	}

	public Collection<T> getFilteredLinks() {
		return getFilteredLinks(myInterfaceLinks);
	}

	protected Collection<T> getFilteredLinks(Collection<T> links) {
		List<T> result = new ArrayList<T>();
		for (T next : links) {
			if (ourHideDerived && isDerivedLink(next)) {
				continue;
			}
			if (ourHideReferencedGenuine && isGenuineLink(next)) {
				continue;
			}
			result.add(next);
		}
		return result;
	}

	protected void visitReqiredOrProvidedInterfaceLink(T link) {
		if (!isInterfaceLink(link)) {
			return;
		}
		// both required and provided links refer to their types and its parents
		myInterfaceLinks.add(link);
		EObject source = getSource(link);
		if (source instanceof Port) {
			Port port = (Port) source;
			Type type = (Type) port.eGet(UMLPackage.Literals.TYPED_ELEMENT__TYPE, false);
			if (type instanceof Classifier && !(type instanceof Interface)) {
				Classifier classifier = (Classifier) port.getType();
				myClassifiersTypingPort.add(classifier);
				myClassifiersTypingPort.addAll(classifier.allParents());
			}
		}
	}

	/*
	 * We say that Required/Provided Link is Derived if it goes out of port
	 */
	protected boolean isDerivedLink(T link) {
		return (getSource(link) != null && getSource(link) instanceof Port);
	}

	/*
	 * Returns Genuine links for which Port#getRequireds()/getProvideds() derived link exists
	 */
	protected boolean isGenuineLink(T link) {
		EObject source = getSource(link);
		return myClassifiersTypingPort.contains(source);
	}

	protected boolean isInterfaceLink(T link) {
		return false;
	}

	protected abstract EObject getSource(T link);

}
