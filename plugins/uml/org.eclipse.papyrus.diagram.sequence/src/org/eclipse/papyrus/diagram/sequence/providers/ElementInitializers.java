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
package org.eclipse.papyrus.diagram.sequence.providers;

import java.util.Collection;

import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Interaction_2001(Interaction instance) {
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
	public static void init_Lifeline_3001(Lifeline instance) {
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
	public static void init_StateInvariant_3017(StateInvariant instance) {
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
	public static void init_CombinedFragment_3018(CombinedFragment instance) {
		try {
			Object value_0 = name_CombinedFragment_3018(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_TimeConstraint_3019(TimeConstraint instance) {
		try {
			TimeInterval newInstance_0_0 = UMLFactory.eINSTANCE.createTimeInterval();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = name_specification_TimeConstraint_3019(newInstance_0_0);
			newInstance_0_0.setName((String)value_0_0_0);

			Object value_1 = name_TimeConstraint_3019(instance);
			instance.setName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_TimeObservation_3020(TimeObservation instance) {
		try {
			Object value_0 = name_TimeObservation_3020(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DurationConstraint_3021(DurationConstraint instance) {
		try {
			DurationInterval newInstance_0_0 = UMLFactory.eINSTANCE.createDurationInterval();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = name_specification_DurationConstraint_3021(newInstance_0_0);
			newInstance_0_0.setName((String)value_0_0_0);

			Object value_1 = name_DurationConstraint_3021(instance);
			instance.setName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InteractionUse_3002(InteractionUse instance) {
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
	public static void init_CombinedFragment_3004(CombinedFragment instance) {
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
	public static void init_Continuation_3016(Continuation instance) {
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
	public static void init_Constraint_3008(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = UMLOCLFactory.getExpression("\'OpaqueExpression\'", UMLPackage.eINSTANCE.getOpaqueExpression()).evaluate(newInstance_0_0);
			if(value_0_0_0 instanceof Collection) {
				newInstance_0_0.getBodies().clear();
				newInstance_0_0.getBodies().addAll(((Collection)value_0_0_0));
			} else {
				newInstance_0_0.getBodies().add((String)value_0_0_0);
			}

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Comment_3009(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("\' \'", UMLPackage.eINSTANCE.getComment()).evaluate(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private static String name_Interaction_2001(Interaction self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_Lifeline_3001(Lifeline self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_StateInvariant_3017(StateInvariant self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_CombinedFragment_3018(CombinedFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_TimeConstraint_3019(TimeConstraint self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_specification_TimeConstraint_3019(TimeInterval self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_TimeObservation_3020(TimeObservation self) {
		return getNamedElement(self, "", "t", "");
	}

	/**
	 * @generated
	 */
	private static String name_DurationConstraint_3021(DurationConstraint self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_specification_DurationConstraint_3021(DurationInterval self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_InteractionUse_3002(InteractionUse self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_ConsiderIgnoreFragment_3007(ConsiderIgnoreFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_CombinedFragment_3004(CombinedFragment self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	private static String name_Continuation_3016(Continuation self) {
		return getNamedElement(self, "", self.eClass().getName(), "");
	}

	/**
	 * @generated
	 */
	public static void init_ConsiderIgnoreFragment_3007(ConsiderIgnoreFragment instance) {
		try {
			Object value_0 = name_ConsiderIgnoreFragment_3007(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * Initialize the name of a namedElement
	 * 
	 * @param namedElement
	 *        the namedElement
	 */
	public static void init_NamedElement(NamedElement namedElement) {
		init_NamedElement(namedElement, ""); //$NON-NLS-1$
	}

	/**
	 * Initialize the name of a namedElement with a given prefix
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
	 * Initialize the name of a namedElement with a given suffix
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
	 * Initialize the name of a namedElement with a given suffix
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

	private static String getNamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		StringBuffer sb = new StringBuffer();
		sb.append("let base : String = \'"); //$NON-NLS-1$
		sb.append(prefix);
		sb.append(body);
		sb.append(suffix);
		sb.append("\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif "); //$NON-NLS-1$

		Object name = UMLOCLFactory.getExpression(sb.toString(), namedElement.eClass()).evaluate(namedElement);
		return (String)name;
	}

}
