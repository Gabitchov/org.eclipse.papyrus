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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContextLinkEditPart;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@contextLink Constraint} edit commands with diagram specific
 * commands in order to remove context link
 * in case a {@context Constraint} is modified.
 * </pre>
 */
public class ConstraintHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterSetCommand(SetRequest request) {

		EObject element = request.getElementToEdit();
		View view = findView(element);
		if(view != null) {

			if(element instanceof Constraint) {
				EStructuralFeature feature = request.getFeature();
				final Object value = request.getValue();
				Edge edgeToDestroy = null;
				Element targetContextElement = null;
				if(UMLPackage.eINSTANCE.getConstraint_Context().equals(feature)) {

					Namespace constraintContext = ((Constraint)element).getContext();

					if(constraintContext == value) {
						// if the new value to set is the already context value
						// then do noting
						return null;
					}

					targetContextElement = constraintContext;

					if(targetContextElement != null) {
						View target = findView(targetContextElement);
						List sourceConnections = ViewUtil.getSourceConnections(view);

						for(Object connector : sourceConnections) {
							if(!(connector instanceof Connector)) {
								continue;
							}
							Edge edge = (Edge)connector;

							if(("" + ContextLinkEditPart.VISUAL_ID).equals(edge.getType())) {
								if(target == edge.getTarget()) {
									edgeToDestroy = edge;
								}
							}
						}
					}

					if(edgeToDestroy != null) {
						TransactionalEditingDomain editingDomain = request.getEditingDomain();
						CompositeCommand command = new CompositeCommand("Clear context links");
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
