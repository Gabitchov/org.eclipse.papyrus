/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper.advice;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@ownedRule Namespace} edit commands with diagram specific
 * commands in order to remove context link
 * in case a {@ownedRule Namespace} is modified.
 * </pre>
 */
public class NamespaceHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterMoveCommand(MoveRequest request) {
		EObject element = request.getTargetContainer();
		if(element instanceof Namespace) {
			// EStructuralFeature feature = request.getTargetFeature(element);
			Map elemsToMove = request.getElementsToMove();
			Edge edgeToDestroy = null;
			for(Iterator value = elemsToMove.keySet().iterator(); value.hasNext();) {
				Object object = (Object)value.next();
				if(object instanceof Constraint) {
					if(UMLPackage.eINSTANCE.getNamespace_OwnedRule().equals(elemsToMove.get(object))) {
						View viewConstraint = findView((Constraint)object);
						List sourceConnections = ViewUtil.getSourceConnections(viewConstraint);
						for(Object connector : sourceConnections) {
							if(!(connector instanceof Edge)) {
								continue;
							}
							Edge edge = (Edge)connector;
							EObject targetElem = edge.getTarget().getElement();
							if(targetElem instanceof Namespace) {
								if(((Namespace)targetElem).getOwnedRules().contains((Constraint)object)) {
									edgeToDestroy = edge;
									break;
								}
							}
						}
					}
				}
			}
			if(edgeToDestroy != null) {
				TransactionalEditingDomain editingDomain = request.getEditingDomain();
				CompositeCommand command = new CompositeCommand("Clear owned rule link");
				DestroyElementRequest destroy = new DestroyElementRequest(editingDomain, edgeToDestroy, false);
				Object eHelperContext = destroy.getEditHelperContext();
				IElementType context = ElementTypeRegistry.getInstance().getElementType(eHelperContext);
				if(context != null) {
					ICommand result = context.getEditCommand(destroy);
					if(result != null) {
						command.add(result);
					}
				}
				return command;
			}
		}
		return null;
	}

	private View findView(EObject element) {
		if(element == null) {
			return null;
		}
		Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(element);
		for(Setting ref : settings) {
			if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
				View view = (View)ref.getEObject();
				if(view != null) {
					return view;
				}
			}
		}
		return null;
	}
}
