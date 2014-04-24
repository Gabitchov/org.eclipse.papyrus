/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.deployment.providers;

import org.eclipse.papyrus.uml.diagram.deployment.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

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
	public void init_Model_2010(Model instance) {
		try {
			Object value_0 = name_Model_2010(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_2009(Package instance) {
		try {
			Object value_0 = name_Package_2009(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_2005(Constraint instance) {
		try {
			Object value_0 = name_Constraint_2005(instance);
			instance.setName((String)value_0);
			Object value_1 = specification_Constraint_2005(instance);
			instance.setSpecification((ValueSpecification)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_2001(Comment instance) {
		try {
			Object value_0 = body_Comment_2001(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEnvironment_2002(ExecutionEnvironment instance) {
		try {
			Object value_0 = name_ExecutionEnvironment_2002(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Device_2003(Device instance) {
		try {
			Object value_0 = name_Device_2003(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_2006(Artifact instance) {
		try {
			Object value_0 = name_Artifact_2006(instance);
			instance.setName((String)value_0);
			Object value_1 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getArtifact(), null).evaluate(instance);
			instance.setFileName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Node_2008(Node instance) {
		try {
			Object value_0 = name_Node_2008(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Model_49(Model instance) {
		try {
			Object value_0 = name_Model_49(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_36(Package instance) {
		try {
			Object value_0 = name_Package_36(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Device_16(Device instance) {
		try {
			Object value_0 = name_Device_16(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Device_44(Device instance) {
		try {
			Object value_0 = name_Device_44(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEnvironment_21(ExecutionEnvironment instance) {
		try {
			Object value_0 = name_ExecutionEnvironment_21(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExecutionEnvironment_46(ExecutionEnvironment instance) {
		try {
			Object value_0 = name_ExecutionEnvironment_46(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Node_23(Node instance) {
		try {
			Object value_0 = name_Node_23(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Node_42(Node instance) {
		try {
			Object value_0 = name_Node_42(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_25(Artifact instance) {
		try {
			Object value_0 = name_Artifact_25(instance);
			instance.setName((String)value_0);
			Object value_1 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getArtifact(), null).evaluate(instance);
			instance.setFileName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_28(Artifact instance) {
		try {
			Object value_0 = name_Artifact_28(instance);
			instance.setName((String)value_0);
			Object value_1 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getArtifact(), null).evaluate(instance);
			instance.setFileName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Artifact_40(Artifact instance) {
		try {
			Object value_0 = name_Artifact_40(instance);
			instance.setName((String)value_0);
			Object value_1 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getArtifact(), null).evaluate(instance);
			instance.setFileName((String)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_54(Comment instance) {
		try {
			Object value_0 = body_Comment_54(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_56(Constraint instance) {
		try {
			Object value_0 = name_Constraint_56(instance);
			instance.setName((String)value_0);
			Object value_1 = specification_Constraint_56(instance);
			instance.setSpecification((ValueSpecification)value_1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Deployment_4001(Deployment instance) {
		try {
			Object value_0 = name_Deployment_4001(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Manifestation_4002(Manifestation instance) {
		try {
			Object value_0 = name_Manifestation_4002(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4004(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4004(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4010(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4010(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_Model_2010(Model it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Package_2009(Package it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Constraint_2005(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_2005(Constraint it) {
		// Constraint specification init
		LiteralString value = UMLFactory.eINSTANCE.createLiteralString();
		value.setValue("");
		return value;
	}

	/**
	 * @generated
	 */
	private String body_Comment_2001(Comment it) {
		// Comment body init
		return "";
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEnvironment_2002(ExecutionEnvironment it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Device_2003(Device it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_2006(Artifact it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Node_2008(Node it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Model_49(Model it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Package_36(Package it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Device_16(Device it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Device_44(Device it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEnvironment_21(ExecutionEnvironment it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_ExecutionEnvironment_46(ExecutionEnvironment it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Node_23(Node it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Node_42(Node it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_25(Artifact it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_28(Artifact it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Artifact_40(Artifact it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String body_Comment_54(Comment it) {
		// Comment body init
		return "";
	}

	/**
	 * @generated
	 */
	private String name_Constraint_56(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_56(Constraint it) {
		// Constraint specification init
		LiteralString value = UMLFactory.eINSTANCE.createLiteralString();
		value.setValue("");
		return value;
	}

	/**
	 * @generated
	 */
	private String name_Deployment_4001(Deployment it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Manifestation_4002(Manifestation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Dependency_4004(Dependency it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Dependency_4010(Dependency it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
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
}
