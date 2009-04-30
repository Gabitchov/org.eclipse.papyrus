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
 *  Gabriel Merin (Prodevelop) - name initialization of missing elements
 */
package org.eclipse.papyrus.diagram.activity.providers;

import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.ValuePin;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * @generated
	 */
	public static void init_Activity_1001(Activity instance) {
		try {
			Object value0 = name_Activity_1001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_SendObjectAction_2001(SendObjectAction instance) {
		try {
			Object value0 = name_SendObjectAction_2001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2002(InputPin instance) {
		try {
			Object value0 = name_InputPin_2002(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2003(InputPin instance) {
		try {
			Object value0 = name_InputPin_2003(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ValuePin_2004(ValuePin instance) {
		try {
			Object value0 = name_ValuePin_2004(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_SendSignalAction_2005(SendSignalAction instance) {
		try {
			Object value0 = name_SendSignalAction_2005(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2006(InputPin instance) {
		try {
			Object value0 = name_InputPin_2006(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AcceptEventAction_2007(AcceptEventAction instance) {
		try {
			Object value0 = name_AcceptEventAction_2007(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OutputPin_2008(OutputPin instance) {
		try {
			Object value0 = name_OutputPin_2008(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ActivityFinalNode_2009(ActivityFinalNode instance) {
		try {
			Object value0 = name_ActivityFinalNode_2009(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DecisionNode_2010(DecisionNode instance) {
		try {
			Object value0 = name_DecisionNode_2010(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_MergeNode_2011(MergeNode instance) {
		try {
			Object value0 = name_MergeNode_2011(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InitialNode_2012(InitialNode instance) {
		try {
			Object value0 = name_InitialNode_2012(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataStoreNode_2013(DataStoreNode instance) {
		try {
			Object value0 = name_DataStoreNode_2013(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OpaqueAction_2014(OpaqueAction instance) {
		try {
			Object value0 = name_OpaqueAction_2014(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OutputPin_2015(OutputPin instance) {
		try {
			Object value0 = name_OutputPin_2015(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2016(InputPin instance) {
		try {
			Object value0 = name_InputPin_2016(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ValuePin_2017(ValuePin instance) {
		try {
			Object value0 = name_ValuePin_2017(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_FlowFinalNode_2018(FlowFinalNode instance) {
		try {
			Object value0 = name_FlowFinalNode_2018(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ForkNode_2019(ForkNode instance) {
		try {
			Object value0 = name_ForkNode_2019(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_JoinNode_2020(JoinNode instance) {
		try {
			Object value0 = name_JoinNode_2020(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pin_2021(Pin instance) {
		try {
			Object value0 = name_Pin_2021(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_CreateObjectAction_2022(CreateObjectAction instance) {
		try {
			Object value0 = name_CreateObjectAction_2022(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OutputPin_2023(OutputPin instance) {
		try {
			Object value0 = name_OutputPin_2023(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_CallBehaviorAction_2024(CallBehaviorAction instance) {
		try {
			Object value0 = name_CallBehaviorAction_2024(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OutputPin_2025(OutputPin instance) {
		try {
			Object value0 = name_OutputPin_2025(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2026(InputPin instance) {
		try {
			Object value0 = name_InputPin_2026(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_CallOperationAction_2027(
			CallOperationAction instance) {
		try {
			Object value0 = name_CallOperationAction_2027(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InputPin_2028(InputPin instance) {
		try {
			Object value0 = name_InputPin_2028(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ActivityParameterNode_2029(
			ActivityParameterNode instance) {
		try {
			Object value0 = name_ActivityParameterNode_2029(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ActivityPartition_2030(ActivityPartition instance) {
		try {
			Object value0 = name_ActivityPartition_2030(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ActivityPartition_2031(ActivityPartition instance) {
		try {
			Object value0 = name_ActivityPartition_2031(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_OpaqueAction_2032(OpaqueAction instance) {
		try {
			Object value0 = name_OpaqueAction_2032(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AcceptEventAction_2033(AcceptEventAction instance) {
		try {
			Object value0 = name_AcceptEventAction_2033(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ControlFlow_3001(ControlFlow instance) {
		try {
			Object value0 = name_ControlFlow_3001(instance);
			instance.setName((String) value0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ObjectFlow_3002(ObjectFlow instance) {
		try {
			Object value0 = name_ObjectFlow_3002(instance);
			instance.setName((String) value0);
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
	private static String name_Activity_1001(Activity self) {
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
	private static String name_SendObjectAction_2001(SendObjectAction self) {
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
	private static String name_InputPin_2002(InputPin self) {
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
	private static String name_InputPin_2003(InputPin self) {
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
	private static String name_ValuePin_2004(ValuePin self) {
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
	private static String name_SendSignalAction_2005(SendSignalAction self) {
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
	private static String name_InputPin_2006(InputPin self) {
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
	private static String name_AcceptEventAction_2007(AcceptEventAction self) {
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
	private static String name_OutputPin_2008(OutputPin self) {
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
	private static String name_ActivityFinalNode_2009(ActivityFinalNode self) {
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
	private static String name_DecisionNode_2010(DecisionNode self) {
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
	private static String name_MergeNode_2011(MergeNode self) {
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
	private static String name_InitialNode_2012(InitialNode self) {
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
	private static String name_DataStoreNode_2013(DataStoreNode self) {
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
	private static String name_OpaqueAction_2014(OpaqueAction self) {
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
	private static String name_OutputPin_2015(OutputPin self) {
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
	private static String name_InputPin_2016(InputPin self) {
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
	private static String name_ValuePin_2017(ValuePin self) {
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
	private static String name_FlowFinalNode_2018(FlowFinalNode self) {
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
	private static String name_ForkNode_2019(ForkNode self) {
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
	private static String name_JoinNode_2020(JoinNode self) {
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
	private static String name_Pin_2021(Pin self) {
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
	private static String name_CreateObjectAction_2022(CreateObjectAction self) {
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
	private static String name_OutputPin_2023(OutputPin self) {
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
	private static String name_CallBehaviorAction_2024(CallBehaviorAction self) {
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
	private static String name_OutputPin_2025(OutputPin self) {
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
	private static String name_InputPin_2026(InputPin self) {
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
	private static String name_CallOperationAction_2027(CallOperationAction self) {
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
	private static String name_InputPin_2028(InputPin self) {
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
	private static String name_ActivityParameterNode_2029(
			ActivityParameterNode self) {
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
	private static String name_ActivityPartition_2030(ActivityPartition self) {
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
	private static String name_ActivityPartition_2031(ActivityPartition self) {
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
	private static String name_OpaqueAction_2032(OpaqueAction self) {
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
	private static String name_AcceptEventAction_2033(AcceptEventAction self) {
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
	private static String name_ControlFlow_3001(ControlFlow self) {
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
	private static String name_ObjectFlow_3002(ObjectFlow self) {
		if (self != null && self.eContainer() != null) {
			return LabelHelper.INSTANCE.findName(self.eContainer(), self);
		}
		return "";
	}
}
