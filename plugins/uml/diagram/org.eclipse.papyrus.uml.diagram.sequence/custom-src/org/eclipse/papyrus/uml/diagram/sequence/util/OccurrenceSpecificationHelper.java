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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class OccurrenceSpecificationHelper {

	public static void repairExecutionSpecificationEnds(Edge messageView) {
		if(messageView == null) {
			return;
		}
		EObject element = ViewUtil.resolveSemanticElement(messageView);
		if(!(element instanceof Message)) {
			return;
		}
		Message message = (Message)element;
		MessageEnd sendEvent = message.getSendEvent();
		MessageEnd receiveEvent = message.getReceiveEvent();
		MessageSort messageSort = message.getMessageSort();
		if(receiveEvent instanceof MessageOccurrenceSpecification && MessageSort.SYNCH_CALL_LITERAL == messageSort) {
			View target = messageView.getTarget();
			EObject targetElement = ViewUtil.resolveSemanticElement(target);
			if(targetElement instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)targetElement;
				repairExecutionSpecificationEnds(message, execution);

			}
		} else if(sendEvent instanceof MessageOccurrenceSpecification && MessageSort.REPLY_LITERAL == messageSort) {
			View source = messageView.getSource();
			EObject sourceElement = ViewUtil.resolveSemanticElement(source);
			if(sourceElement instanceof ExecutionSpecification) {
				ExecutionSpecification execution = (ExecutionSpecification)sourceElement;
				repairExecutionSpecificationEnds(message, execution);
			}
		}
	}

	//	private static void repairViewEdges(View oldView, View newView) {
	//		newView.getSourceEdges().addAll(oldView.getSourceEdges());
	//		newView.getTargetEdges().addAll(oldView.getTargetEdges());
	//	}
	//
	//	private static View findChildView(View parent, EObject childElement) {
	//		if(parent == null || childElement == null) {
	//			return null;
	//		}
	//		EList children = parent.getChildren();
	//		for(Object object : children) {
	//			if(object instanceof View && childElement == ViewUtil.resolveSemanticElement((View)object)) {
	//				return (View)object;
	//			}
	//		}
	//		return null;
	//	}

	public static void repairExecutionSpecificationEnds(Message message, ExecutionSpecification execution) {
		if(message == null || execution == null) {
			return;
		}
		MessageEnd sendEvent = message.getSendEvent();
		MessageEnd receiveEvent = message.getReceiveEvent();
		MessageSort messageSort = message.getMessageSort();
		if(receiveEvent instanceof MessageOccurrenceSpecification && MessageSort.SYNCH_CALL_LITERAL == messageSort) {
			OccurrenceSpecification start = execution.getStart();
			if(receiveEvent == start) {
				return;
			}

			if(start instanceof ExecutionOccurrenceSpecification) {
				repairExecutionSpecificationEnd(execution, (OccurrenceSpecification)receiveEvent, true);
				EcoreUtil.delete(start);
			}
		} else if(sendEvent instanceof MessageOccurrenceSpecification && MessageSort.REPLY_LITERAL == messageSort) {
			OccurrenceSpecification finish = execution.getFinish();
			if(finish == sendEvent) {
				return;
			}
			if(finish instanceof ExecutionOccurrenceSpecification) {
				repairExecutionSpecificationEnd(execution, (OccurrenceSpecification)sendEvent, false);
				EcoreUtil.delete(finish);
			}
		}
	}

	public static void repairExecutionSpecificationEnd(ExecutionSpecification execution, OccurrenceSpecification newEnd, boolean start) {
		if(execution == null || newEnd == null || newEnd == execution.getStart() || newEnd == execution.getFinish()) {
			return;
		}
		ExecutionSpecification oldES = SequenceUtil.getExecutionSpecification(newEnd);
		if(oldES != null && oldES != execution) {
			InteractionFragment container = null;
			Element owner = oldES.getOwner();
			if(owner instanceof InteractionFragment) {
				container = (InteractionFragment)owner;
			}
			Lifeline lifeline = null;
			EList<Lifeline> covereds = oldES.getCovereds();
			if(!covereds.isEmpty()) {
				lifeline = covereds.get(0);
			}
			ExecutionOccurrenceSpecification eos = CommandHelper.doCreateExecutionOccurenceSpecification(oldES, container, lifeline);
			if(eos == null) {
				return;
			}
			if(newEnd == oldES.getStart()) {
				ElementInitializers.init_NamedElement(eos, "", oldES.getName(), "Start");
			} else {
				ElementInitializers.init_NamedElement(eos, "", oldES.getName(), "Finish");
			}
			repairExecutionSpecificationEnd(oldES, eos, newEnd == oldES.getStart());
		}
		replaceExecutionSpecificationEnd(execution.eResource(), start ? execution.getStart() : execution.getFinish(), newEnd);
		if(start) {
			execution.setStart(newEnd);
		} else {
			execution.setFinish(newEnd);
		}
	}

	private static void replaceExecutionSpecificationEnd(Resource resource, OccurrenceSpecification oldEnd, OccurrenceSpecification newEnd) {
		if(resource == null || newEnd == null || newEnd == oldEnd || oldEnd == null) {
			return;
		}
		Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(oldEnd, resource);
		for(Setting setting : usages) {
			EObject eObject = setting.getEObject();
			EStructuralFeature feature = setting.getEStructuralFeature();
			if(FeatureMapUtil.isMany(eObject, feature)) {
				@SuppressWarnings("rawtypes")
				List values = (List)eObject.eGet(feature);
				if(values.contains(newEnd)) {
					continue;
				}
			}
			EClassifier eType = feature.getEType();
			if (eType == null || !eType.isInstance(newEnd)){
				continue;
			}
			EcoreUtil.replace(eObject, feature, oldEnd, newEnd);
		}
	}

	public static void rebuildExecutionSpecificationFinish(ExecutionSpecification execution, OccurrenceSpecification newFinish) {
		if(execution == null || newFinish == null || newFinish == execution.getStart() || newFinish == execution.getFinish()) {
			return;
		}
		OccurrenceSpecification oldFinish = execution.getFinish();
		if(oldFinish == null) {
			execution.setFinish(newFinish);
		} else {

		}
	}
}
