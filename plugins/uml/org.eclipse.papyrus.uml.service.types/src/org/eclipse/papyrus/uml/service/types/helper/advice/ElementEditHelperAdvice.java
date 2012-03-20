/*****************************************************************************
 * Copyright (c) 2012 Atos .
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Arthur daussy - arthur.daussy@atos.net - 374607: [model explorer] moving a model element in another model does not move associated diagrams
 *
 **/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.diagram.common.commands.MoveStereotypeApplicationsCommand;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
/**
 * The edit helper advice for all uml element
 * @author adaussy
 *
 */
public class ElementEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This case will handle moving an element from a resource to another (use case : controled mode. This will move into the new ressource :
	 * -> The stereotype linked to this element
	 * 
	 */
	@Override
	protected ICommand getAfterMoveCommand(MoveRequest request) {
		Map elementsToMove = request.getElementsToMove();
		EObject container = request.getTargetContainer();
		for(Object o : elementsToMove.keySet()) {
			EObject sourceEObject = null;
			if(o instanceof EObject) {
				sourceEObject = (EObject)o;
			} else if(o instanceof IAdaptable) {
				sourceEObject = (EObject)((IAdaptable)o).getAdapter(EObject.class);
			}
			Resource eResource = sourceEObject.eResource();
			Resource containerEResource = container.eResource();
			if(sourceEObject != null && eResource != null && container != null && containerEResource != null) {
				/*
				 * Test if the moving element is going to be in a new resource
				 */
				if(!eResource.equals(containerEResource)) {
					CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(container), "Move related element to new resource");////$NON-NLS-1$
					/*
					 * Iterator of all descednant
					 */
					UnmodifiableIterator<EObject> descendantElementIterator = Iterators.filter(sourceEObject.eAllContents(), new Predicate<EObject>() {

						public boolean apply(EObject input) {
							return input instanceof Element;
						}
					});
					/*
					 * Iterator of the source element
					 */
					UnmodifiableIterator<EObject> elementIterator = Iterators.forArray(sourceEObject);
					/*
					 * unifiedIterator = (elementIterator) U (descendantElementIterator)
					 */
					Iterator<EObject> unifiedIterator = Iterators.concat(elementIterator,descendantElementIterator);
					while (unifiedIterator.hasNext()){
						/*
						 * Move related diagrams
						 */
						EObject next = unifiedIterator.next();
						ICommand modeStereotypeCommand = getMoveStereotypeCommand(container, next);
						if(modeStereotypeCommand != null) {
							cc.compose(modeStereotypeCommand);
						}						
					}
					return cc;
				}
			}
		}
		return super.getAfterMoveCommand(request);
	}
	/**
	 * Move all the stereotype of an element into a new resource
	 * @param container
	 * @param sourceEObject
	 * @return
	 */
	protected ICommand getMoveStereotypeCommand(EObject container, EObject sourceEObject) {
		if(sourceEObject instanceof Element) {
			Element element = (Element)sourceEObject;
			EList<EObject> stereotypeApplications = element.getStereotypeApplications();
			if(stereotypeApplications != null && !stereotypeApplications.isEmpty()) {
				Resource eResource = container.eResource();
				if(eResource != null) {
					if(eResource.isLoaded()){
						MoveStereotypeApplicationsCommand mvSteCommand = new MoveStereotypeApplicationsCommand(getEditingDomain(container), element, eResource);
						return mvSteCommand;
					} else {
						return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The new containing resource is not loaded"));////$NON-NLS-1$
					}
				}
			}
		}
		return null;
	}
	/**
	 * Get the editing domain from an {@link EObject}
	 * @param eObject
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain trEditingDomain = (TransactionalEditingDomain)editingDomain;
			return trEditingDomain;
		}
		throw new RuntimeException("Unable to retreive the transactionnal editin domain");////$NON-NLS-1$
	}
}
