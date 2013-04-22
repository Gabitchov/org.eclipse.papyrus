/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class SequenceViewDependentsAdvice extends AbstractEditHelperAdvice {

	@SuppressWarnings("rawtypes")
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		EObject element = request.getElementToEdit();
		View view = findView(element);
		if(view != null) {
			//Clear edge's when the UML model has been changed.
			EStructuralFeature feature = request.getFeature();
			Object value = request.getValue();
			if(!(value instanceof List<?>)) {
				return null;
			}
			List<Edge> destroyEdges = new ArrayList<Edge>();
			List<Element> targetObjects = new ArrayList<Element>();
			if(element instanceof Comment && UMLPackage.Literals.COMMENT__ANNOTATED_ELEMENT == feature) {
				targetObjects.addAll(((Comment)element).getAnnotatedElements());
			} else if(element instanceof DurationObservation && UMLPackage.Literals.DURATION_OBSERVATION__EVENT == feature) {
				targetObjects.addAll(((DurationObservation)element).getEvents());
			} else if(element instanceof TimeObservation && UMLPackage.Literals.TIME_OBSERVATION__EVENT == feature) {
				targetObjects.add(((TimeObservation)element).getEvent());
			} else if(element instanceof Constraint && UMLPackage.Literals.CONSTRAINT__CONSTRAINED_ELEMENT == feature) {
				targetObjects.addAll(((Constraint)element).getConstrainedElements());
			}
			for(Element object : targetObjects) {
				if(value instanceof List && ((List)value).contains(object)) {
					continue;
				}
				View target = findView(object);
				List sourceConnections = ViewUtil.getSourceConnections(view);
				for(Object connector : sourceConnections) {
					if(!(connector instanceof Edge)) {
						continue;
					}
					Edge edge = (Edge)connector;
					if(target == edge.getTarget()) {
						destroyEdges.add(edge);
					}
				}
			}
			if(!destroyEdges.isEmpty()) {
				TransactionalEditingDomain editingDomain = request.getEditingDomain();
				CompositeCommand command = new CompositeCommand("Clear Connectors");
				for(Edge edge : destroyEdges) {
					DestroyElementRequest destroy = new DestroyElementRequest(editingDomain, edge, false);
					Object eHelperContext = destroy.getEditHelperContext();
					IElementType context = ElementTypeRegistry.getInstance().getElementType(eHelperContext);
					if(context != null) {
						ICommand result = context.getEditCommand(destroy);
						if(result != null) {
							command.add(result);
						}
					}
				}
				return command;
			}
		}
		return super.getBeforeSetCommand(request);
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
