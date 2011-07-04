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
package org.eclipse.papyrus.properties.uml.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEvent;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.Signal;

public class SignatureContentProvider extends AbstractStaticContentProvider {

	private Message message;

	private MessageEvent sourceEvent;

	public SignatureContentProvider(EObject source) {
		if(source instanceof Message) {
			this.message = (Message)source;
		} else if(source instanceof ReceiveOperationEvent || source instanceof SendOperationEvent) {

			sourceEvent = (MessageEvent)source;

		} else {
			throw new IllegalArgumentException("The source EObject is not a valid element"); //$NON-NLS-1$
		}

	}

	public Object[] getElements() {
		if(message != null) {
			return getElementsFromMessage();
		} else if(sourceEvent != null) {
			return getElementsFromEvent();
		}

		return new Object[0]; //Should never happen, as either message or sourceEvent should be set
	}

	protected Object[] getElementsFromMessage() {
		org.eclipse.uml2.uml.Class clazz = UMLUtil.getContextClassForMessage(message);
		return getElementsFromContext(clazz);
	}

	protected Object[] getElementsFromEvent() {
		org.eclipse.uml2.uml.Class clazz = UMLUtil.getContextClassForMessageEvent(sourceEvent);
		if(clazz == null) {
			return new Object[0];
		}
		return getElementsFromContext(clazz);
	}

	protected Object[] getElementsFromContext(org.eclipse.uml2.uml.Class clazz) {
		List<EObject> result = new LinkedList<EObject>();
		result.addAll(clazz.getOwnedOperations());
		if(message != null && (message.getMessageSort() == MessageSort.ASYNCH_CALL_LITERAL || message.getMessageSort() == MessageSort.ASYNCH_SIGNAL_LITERAL)) {
			result.addAll(getAllSignals(clazz));
		}
		return result.toArray();
	}

	protected List<Signal> getAllSignals(Element element) {
		List<Signal> result = new LinkedList<Signal>();
		Set<Package> browsedPackages = new HashSet<Package>();
		org.eclipse.uml2.uml.Package rootPackage = PackageUtil.getRootPackage(element);
		fillSignals(result, rootPackage, browsedPackages);
		return result;
	}

	/**
	 * Recursively fills the result collection with all signals found from the given rootPackage
	 * 
	 * @param result
	 * @param rootPackage
	 * @param browsedPackages
	 */
	protected void fillSignals(Collection<Signal> result, Package rootPackage, Set<Package> browsedPackages) {
		if(browsedPackages.contains(rootPackage)) {
			return;
		}

		browsedPackages.add(rootPackage);

		Iterator<EObject> iterator = EcoreUtil.getAllContents(rootPackage, true);
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			if(eObject instanceof Signal) {
				result.add((Signal)eObject);
			} else if(eObject instanceof PackageImport) {
				PackageImport packageImport = (PackageImport)eObject;
				Package importedPackage = packageImport.getImportedPackage();
				fillSignals(result, importedPackage, browsedPackages);
			}
		}
	}

}
