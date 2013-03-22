/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.uml.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_Interaction_2001(Interaction instance) {
		try {
			Object value_0 = name_Interaction_2001(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ConsiderIgnoreFragment_3007(ConsiderIgnoreFragment instance) {
		try {
			Object value_0 = name_ConsiderIgnoreFragment_3007(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CombinedFragment_3004(CombinedFragment instance) {
		try {
			Object value_0 = name_CombinedFragment_3004(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InteractionUse_3002(InteractionUse instance) {
		try {
			Object value_0 = name_InteractionUse_3002(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Continuation_3016(Continuation instance) {
		try {
			Object value_0 = name_Continuation_3016(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Lifeline_3001(Lifeline instance) {
		try {
			Object value_0 = name_Lifeline_3001(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_StateInvariant_3017(StateInvariant instance) {
		try {
			Object value_0 = name_StateInvariant_3017(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_CombinedFragment_3018(CombinedFragment instance) {
		try {
			Object value_0 = name_CombinedFragment_3018(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT init Time Interval
	 */
	public void init_TimeConstraint_3019(TimeConstraint instance) {
		try {
			TimeInterval newInstance_0_0 = UMLFactory.eINSTANCE.createTimeInterval();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = name_specification_TimeConstraint_3019(newInstance_0_0);
			newInstance_0_0.setName((String)value_0_0_0);
			// init Time Interval
			init_TimeInterval(newInstance_0_0);
			Object value_1 = name_TimeConstraint_3019(instance);
			instance.setName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeObservation_3020(TimeObservation instance) {
		try {
			Object value_0 = name_TimeObservation_3020(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT init Duration Interval
	 */
	public void init_DurationConstraint_3021(DurationConstraint instance) {
		try {
			DurationInterval newInstance_0_0 = UMLFactory.eINSTANCE.createDurationInterval();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = name_specification_DurationConstraint_3021(newInstance_0_0);
			newInstance_0_0.setName((String)value_0_0_0);
			// init Duration Interval
			init_DurationInterval(newInstance_0_0);
			Object value_1 = name_DurationConstraint_3021(instance);
			instance.setName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DestructionOccurrenceSpecification_3022(DestructionOccurrenceSpecification instance) {
		try {
			Object value_0 = name_DestructionOccurrenceSpecification_3022(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * Initialize a time interval
	 * 
	 * @param instance
	 *        instance to initialize
	 */
	private void init_TimeInterval(TimeInterval instance) {
		// time interval
		TimeInterval timeInterval = instance;
		// create, add and set the min and max duration of the duration interval
		org.eclipse.uml2.uml.Package package_ = timeInterval.getNearestPackage();
		TimeExpression minTimeExpression = UMLFactory.eINSTANCE.createTimeExpression();
		TimeExpression maxTimeExpression = UMLFactory.eINSTANCE.createTimeExpression();
		package_.getPackagedElements().add(minTimeExpression);
		package_.getPackagedElements().add(maxTimeExpression);
		ElementInitializers.init_NamedElement(minTimeExpression, "", timeInterval.eClass().getName(), "Min");
		ElementInitializers.init_NamedElement(maxTimeExpression, "", timeInterval.eClass().getName(), "Max");
		timeInterval.setMin(minTimeExpression);
		timeInterval.setMax(maxTimeExpression);
		minTimeExpression.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
		maxTimeExpression.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
	}

	/**
	 * Initialize a duration interval
	 * 
	 * @param instance
	 *        instance to initialize
	 */
	private void init_DurationInterval(DurationInterval instance) {
		// duration interval
		DurationInterval durationInterval = instance;
		// create, add and set the min and max duration of the duration interval
		org.eclipse.uml2.uml.Package package_ = durationInterval.getNearestPackage();
		Duration minDuration = UMLFactory.eINSTANCE.createDuration();
		Duration maxDuration = UMLFactory.eINSTANCE.createDuration();
		package_.getPackagedElements().add(minDuration);
		package_.getPackagedElements().add(maxDuration);
		ElementInitializers.init_NamedElement(minDuration, "", durationInterval.eClass().getName(), "Min");
		ElementInitializers.init_NamedElement(maxDuration, "", durationInterval.eClass().getName(), "Max");
		durationInterval.setMin(minDuration);
		durationInterval.setMax(maxDuration);
		minDuration.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
		maxDuration.setExpr(UMLFactory.eINSTANCE.createLiteralInteger());
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3008(Constraint instance) {
		try {
			LiteralString newInstance_0_0 = UMLFactory.eINSTANCE.createLiteralString();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = value_specification_Constraint_3008(newInstance_0_0);
			newInstance_0_0.setValue((String)value_0_0_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_3009(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT init Duration Interval
	 */
	public void init_DurationConstraint_3023(DurationConstraint instance) {
		try {
			DurationInterval newInstance_0_0 = UMLFactory.eINSTANCE.createDurationInterval();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = name_specification_DurationConstraint_3023(newInstance_0_0);
			newInstance_0_0.setName((String)value_0_0_0);
			// init Duration Interval
			init_DurationInterval(newInstance_0_0);
			Object value_1 = name_DurationConstraint_3023(instance);
			instance.setName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationObservation_3024(DurationObservation instance) {
		try {
			Object value_0 = name_DurationObservation_3024(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_GeneralOrdering_4012(GeneralOrdering instance) {
		try {
			Object value_0 = name_GeneralOrdering_4012(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_Interaction_2001(Interaction self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_ConsiderIgnoreFragment_3007(ConsiderIgnoreFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_CombinedFragment_3004(CombinedFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_InteractionUse_3002(InteractionUse self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_Continuation_3016(Continuation self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_Lifeline_3001(Lifeline self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_StateInvariant_3017(StateInvariant self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_CombinedFragment_3018(CombinedFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_TimeConstraint_3019(TimeConstraint self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_specification_TimeConstraint_3019(TimeInterval self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_TimeObservation_3020(TimeObservation self) {
		return getNamedElement(self, "", "t", "");
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_3021(DurationConstraint self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_specification_DurationConstraint_3021(DurationInterval self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_DestructionOccurrenceSpecification_3022(DestructionOccurrenceSpecification self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String value_specification_Constraint_3008(LiteralString self) {
		return "";
	}

	/**
	 * @generated
	 */
	private String name_DurationConstraint_3023(DurationConstraint self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_specification_DurationConstraint_3023(DurationInterval self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private String name_DurationObservation_3024(DurationObservation self) {
		return getNamedElement(self, "", "d", "");
	}

	/**
	 * @generated
	 */
	private String name_GeneralOrdering_4012(GeneralOrdering self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = UMLDiagramEditorPlugin.getInstance().getElementInitializers();
		if(cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement
	 * 
	 * @param namedElement
	 *        the namedElement
	 */
	public static void init_NamedElement(NamedElement namedElement) {
		init_NamedElement(namedElement, ""); //$NON-NLS-1$
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given prefix
	 * 
	 * @param namedElement
	 *        the namedElement
	 * @param prefix
	 *        a prefix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix) {
		init_NamedElement(namedElement, prefix, namedElement.eClass().getName(), "");
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given suffix
	 * 
	 * @param namedElement
	 *        the namedElement
	 * @param prefix
	 *        the prefix for the name
	 * @param suffix
	 *        a suffix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix, String suffix) {
		init_NamedElement(namedElement, prefix, namedElement.eClass().getName(), suffix);
	}

	/**
	 * @generated NOT
	 *            Initialize the name of a namedElement with a given suffix
	 * 
	 * @param namedElement
	 *        the namedElement
	 * @param prefix
	 *        the prefix for the name
	 * @param body
	 *        the body used for the name
	 * @param suffix
	 *        a suffix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		try {
			namedElement.setName(getNamedElement(namedElement, prefix, body, suffix));
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 * 
	 */
	private static String getNamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		String base = prefix + body + suffix;
		Namespace namespace = namedElement.getNamespace();
		if(namespace != null) {
			Set<NamedElement> members = new HashSet<NamedElement>();
			members.addAll(namespace.getMembers());
			// add general orderings which are not in initial selection
			if(namespace instanceof Interaction) {
				members.addAll(((Interaction)namespace).getGeneralOrderings());
			}
			return getNextNumberedName(members, base);
		}
		return base;
	}

	@SuppressWarnings("rawtypes")
	public static String getNextNumberedName(Collection currentElements, String base) {
		int nextNumber = -1;
		Set<String> elementNames = new HashSet<String>();
		for(Object o : currentElements) {
			if(o instanceof NamedElement) {
				String name = ((NamedElement)o).getName();
				if(name != null && name.startsWith(base)) {
					elementNames.add(name);
					String end = name.substring(base.length());
					int nextNumberTmp = -1;
					if(end.trim().equals("")) {
						nextNumberTmp = 0;
					} else {
						try {
							nextNumberTmp = Integer.parseInt(end) + 1;
						} catch (NumberFormatException ex) {
							nextNumberTmp = -1;
						}
					}
					if(nextNumberTmp > nextNumber) {
						nextNumber = nextNumberTmp;
					}
				}
			}
		}
		if(nextNumber == -1) {
			return generateUniqueName(base, elementNames, base, nextNumber);
		} else {
			return generateUniqueName(base + nextNumber, elementNames, base, nextNumber);
		}
	}

	private static String generateUniqueName(String name, Set<String> elementNames, String base, int nextNumber) {
		while(elementNames.contains(name)) {
			nextNumber++;
			name = base + nextNumber;
		}
		return name;
	}
}
