/*****************************************************************************
 * Copyright (c) 2013 CEA
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Update execution ends to message ends for Sync and Reply message, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class OccurrenceSpecificationHelper {

	/**
	 * Constructor.
	 * 
	 */
	private OccurrenceSpecificationHelper() {
	}

	public static boolean resetExecutionStart(ExecutionSpecification execution, Element newStart) {
		if(!(newStart instanceof OccurrenceSpecification)) {
			return false;
		}
		return resetExecutionEnd(execution, (OccurrenceSpecification)newStart, true);
	}

	public static boolean resetExecutionFinish(ExecutionSpecification execution, Element newFinish) {
		if(!(newFinish instanceof OccurrenceSpecification)) {
			return false;
		}
		return resetExecutionEnd(execution, (OccurrenceSpecification)newFinish, false);
	}

	private static void copyInfo(OccurrenceSpecification fromOS, OccurrenceSpecification toOS) {
		if(fromOS == null || toOS == null) {
			return;
		}
		EList<Lifeline> covereds = fromOS.getCovereds();
		for(Lifeline lifeline : covereds) {
			if(toOS.getCovereds().contains(lifeline)) {
				continue;
			}
			toOS.getCovereds().add(lifeline);
		}
	}

	public static boolean resetExecutionEnd(ExecutionSpecification execution, OccurrenceSpecification newEnd, boolean isStart) {
		if(execution == null || newEnd == null) {
			return false;
		}
		OccurrenceSpecification oldEnd = isStart ? execution.getStart() : execution.getFinish();
		if(newEnd.eContainer() == null) {
			EObject eContainer = oldEnd != null ? oldEnd.eContainer() : execution.eContainer();
			if(eContainer instanceof Interaction) {
				newEnd.setEnclosingInteraction((Interaction)eContainer);
			} else if(eContainer instanceof InteractionOperand) {
				newEnd.setEnclosingOperand((InteractionOperand)eContainer);
			}
		}
		if(newEnd.getName() == null) {
			if(isStart) {
				newEnd.setName(execution.getName() + "Start");
			} else {
				newEnd.setName(execution.getName() + "Finish");
			}
		}
		copyInfo(oldEnd, newEnd);
		if(newEnd instanceof ExecutionOccurrenceSpecification) {
			((ExecutionOccurrenceSpecification)newEnd).setExecution(execution);
		}
		if(isStart) {
			execution.setStart(newEnd);
		} else {
			execution.setFinish(newEnd);
		}
		if(canBeRemoved(oldEnd, newEnd, isStart)) {
			EcoreUtil.delete(oldEnd);
		}
		return true;
	}

	/**
	 * The given <code>Occurrence Specification</code> object can be removed without any references.
	 * 
	 * @param isStart
	 */
	private static boolean canBeRemoved(OccurrenceSpecification os, OccurrenceSpecification copy, boolean isStart) {
		if(os == null || copy == null || os instanceof MessageOccurrenceSpecification) {
			return false;
		}
		Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(os, os.eResource());
		for(Setting setting : usages) {
			Object osValue = setting.get(true);
			if(osValue instanceof List<?> && ((List<?>)osValue).contains(copy)) {
				continue;
			}
			EStructuralFeature feature = setting.getEStructuralFeature();
			if(isStart && UMLPackage.eINSTANCE.getExecutionSpecification_Start() == feature) {
				continue;
			} else if(!isStart && UMLPackage.eINSTANCE.getExecutionSpecification_Finish() == feature) {
				continue;
			}
			System.out.println();
		}
		return true;
	}

	/**
	 * Find an Execution with the given end.
	 */
	public static ExecutionSpecification findExecutionWith(OccurrenceSpecification end, boolean isStart) {
		if(end instanceof ExecutionOccurrenceSpecification) {
			return ((ExecutionOccurrenceSpecification)end).getExecution();
		}
		Collection<Setting> usages = EcoreUtil.UsageCrossReferencer.find(end, end.eResource());
		for(Setting setting : usages) {
			EObject eObject = setting.getEObject();
			EStructuralFeature feature = setting.getEStructuralFeature();
			if(isStart && UMLPackage.eINSTANCE.getExecutionSpecification_Start() == feature) {
				return (ExecutionSpecification)eObject;
			} else if(!isStart && UMLPackage.eINSTANCE.getExecutionSpecification_Finish() == feature) {
				return (ExecutionSpecification)eObject;
			}
		}
		return null;
	}
}
