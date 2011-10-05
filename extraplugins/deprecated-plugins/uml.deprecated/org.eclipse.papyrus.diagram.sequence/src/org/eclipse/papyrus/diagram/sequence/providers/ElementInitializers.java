/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.providers;

import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.sequence.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Interaction_1001(Interaction instance) {
		try {
			Object value0 = name_Interaction_1001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interaction_2001(Interaction instance) {
		try {
			Object value0 = name_Interaction_2001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Lifeline_2002(Lifeline instance) {
		try {
			Object value0 = name_Lifeline_2002(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_BehaviorExecutionSpecification_2003(
			BehaviorExecutionSpecification instance) {
		try {
			Object value0 = name_BehaviorExecutionSpecification_2003(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_CombinedFragment_2004(CombinedFragment instance) {
		try {
			Object value0 = name_CombinedFragment_2004(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3001(Message instance) {
		try {
			Object value0 = name_Message_3001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3002(Message instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"MessageSort::asynchCall",
					UMLPackage.eINSTANCE.getMessage()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getMessageSort());
			instance.setMessageSort((MessageSort) value0);
			Object value1 = name_Message_3002(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3003(Message instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression("MessageSort::reply",
					UMLPackage.eINSTANCE.getMessage()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getMessageSort());
			instance.setMessageSort((MessageSort) value0);
			Object value1 = name_Message_3003(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3004(Message instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"MessageSort::asynchSignal",
					UMLPackage.eINSTANCE.getMessage()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getMessageSort());
			instance.setMessageSort((MessageSort) value0);
			Object value1 = name_Message_3004(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3005(Message instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"MessageSort::createMessage",
					UMLPackage.eINSTANCE.getMessage()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getMessageSort());
			instance.setMessageSort((MessageSort) value0);
			Object value1 = name_Message_3005(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Message_3006(Message instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"MessageSort::deleteMessage",
					UMLPackage.eINSTANCE.getMessage()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getMessageSort());
			instance.setMessageSort((MessageSort) value0);
			Object value1 = name_Message_3006(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Interaction_1001(Interaction self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Interaction_2001(Interaction self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Lifeline_2002(Lifeline self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_BehaviorExecutionSpecification_2003(
			BehaviorExecutionSpecification self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_CombinedFragment_2004(CombinedFragment self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3001(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3002(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3003(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3004(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3005(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * @generated NOT
	 * 
	 *            implementation provided
	 */
	private static String name_Message_3006(Message self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}
}
