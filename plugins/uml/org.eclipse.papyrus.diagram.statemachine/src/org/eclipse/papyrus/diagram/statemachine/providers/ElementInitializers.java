/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLAbstractExpression;
import org.eclipse.papyrus.diagram.statemachine.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_StateMachine_1001(StateMachine instance) {
		try {
			Object value0 = name_StateMachine_1001(instance);
			instance.setName((String) value0);

			Region newInstance200 = UMLFactory.eINSTANCE.createRegion();

			instance.getRegions().add(newInstance200);
			Object value20100 = name_StateMachine_1001(newInstance200);
			newInstance200.setName((String) value20100);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_State_2002(State instance) {
		try {
			Object value0 = name_State_2002(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_State_2003(State instance) {
		try {
			Object value0 = name_State_2003(instance);
			instance.setName((String) value0);

			Region newInstance200 = UMLFactory.eINSTANCE.createRegion();

			instance.getRegions().add(newInstance200);
			Object value20100 = name_State_2003(newInstance200);
			newInstance200.setName((String) value20100);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_State_2005(State instance) {
		try {
			Object value0 = name_State_2005(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ConnectionPointReference_2006(
			ConnectionPointReference instance) {
		try {
			Object value0 = name_ConnectionPointReference_2006(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ConnectionPointReference_2007(
			ConnectionPointReference instance) {
		try {
			Object value0 = name_ConnectionPointReference_2007(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2009(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::initial",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2010(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::shallowHistory",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2011(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::deepHistory",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2012(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::fork",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2013(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::join",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2014(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::junction",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2015(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::choice",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2016(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::terminate",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_State_2017(State instance) {
		try {
			Object value0 = name_State_2017(instance);
			instance.setName((String) value0);

			Region newInstance200 = UMLFactory.eINSTANCE.createRegion();

			instance.getRegions().add(newInstance200);
			Object value20100 = name_State_2017(newInstance200);
			newInstance200.setName((String) value20100);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2018(Pseudostate instance) {
		try {
			Object value0 = name_Pseudostate_2018(instance);
			instance.setName((String) value0);
			Object value1 = UMLOCLFactory.getExpression(
					"PseudostateKind::entryPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value1 = UMLAbstractExpression.performCast(value1,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2019(Pseudostate instance) {
		try {
			Object value0 = name_Pseudostate_2019(instance);
			instance.setName((String) value0);
			Object value1 = UMLOCLFactory.getExpression(
					"PseudostateKind::exitPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value1 = UMLAbstractExpression.performCast(value1,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2020(Pseudostate instance) {
		try {
			Object value0 = name_Pseudostate_2020(instance);
			instance.setName((String) value0);
			Object value1 = UMLOCLFactory.getExpression(
					"PseudostateKind::entryPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value1 = UMLAbstractExpression.performCast(value1,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2021(Pseudostate instance) {
		try {
			Object value0 = name_Pseudostate_2021(instance);
			instance.setName((String) value0);
			Object value1 = UMLOCLFactory.getExpression(
					"PseudostateKind::exitPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value1 = UMLAbstractExpression.performCast(value1,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2022(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::entryPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
			Object value1 = name_Pseudostate_2022(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_2023(Pseudostate instance) {
		try {
			Object value0 = UMLOCLFactory.getExpression(
					"PseudostateKind::exitPoint",
					UMLPackage.eINSTANCE.getPseudostate()).evaluate(instance);

			value0 = UMLAbstractExpression.performCast(value0,
					UMLPackage.eINSTANCE.getPseudostateKind());
			instance.setKind((PseudostateKind) value0);
			Object value1 = name_Pseudostate_2023(instance);
			instance.setName((String) value1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_StateMachine_1001(StateMachine self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_StateMachine_1001(Region self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2002(State self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2003(State self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2003(Region self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2005(State self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_ConnectionPointReference_2006(
			ConnectionPointReference self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_ConnectionPointReference_2007(
			ConnectionPointReference self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2017(State self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_State_2017(Region self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2018(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2019(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2020(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2021(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2022(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}

	/**
	 * Implementation provided
	 * 
	 * @generated NOT
	 */
	private static String name_Pseudostate_2023(Pseudostate self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}
}
