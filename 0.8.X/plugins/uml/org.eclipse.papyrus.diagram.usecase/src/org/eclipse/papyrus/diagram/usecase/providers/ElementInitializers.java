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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers;

import java.util.Collection;

import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.usecase.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;

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
	public void init_Actor_2011(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getActor(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Actor_2012(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(1, UMLPackage.eINSTANCE.getActor(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_2013(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(2, UMLPackage.eINSTANCE.getUseCase(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_2014(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(4, UMLPackage.eINSTANCE.getUseCase(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_2015(Component instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getComponent(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_2016(Package instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(9, UMLPackage.eINSTANCE.getPackage(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_2017(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = UMLOCLFactory.getExpression(8, UMLPackage.eINSTANCE.getOpaqueExpression(), null).evaluate(newInstance_0_0);
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
	public void init_Comment_2018(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExtensionPoint_3007(ExtensionPoint instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(3, UMLPackage.eINSTANCE.getExtensionPoint(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ExtensionPoint_3008(ExtensionPoint instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(5, UMLPackage.eINSTANCE.getExtensionPoint(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_3009(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(2, UMLPackage.eINSTANCE.getUseCase(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_3016(Component instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getComponent(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_3015(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(7, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3017(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = UMLOCLFactory.getExpression(8, UMLPackage.eINSTANCE.getOpaqueExpression(), null).evaluate(newInstance_0_0);
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
	public void init_Actor_3018(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getActor(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3010(Constraint instance) {
		try {
			OpaqueExpression newInstance_0_0 = UMLFactory.eINSTANCE.createOpaqueExpression();
			instance.setSpecification(newInstance_0_0);
			Object value_0_0_0 = UMLOCLFactory.getExpression(8, UMLPackage.eINSTANCE.getOpaqueExpression(), null).evaluate(newInstance_0_0);
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
	public void init_Actor_3011(Actor instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getActor(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_UseCase_3012(UseCase instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(2, UMLPackage.eINSTANCE.getUseCase(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_3013(Component instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(6, UMLPackage.eINSTANCE.getComponent(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_3014(Package instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(9, UMLPackage.eINSTANCE.getPackage(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Association_4011(Association instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(13, UMLPackage.eINSTANCE.getAssociation(), null).evaluate(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4013(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4013(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Abstraction_4015(Abstraction instance) {
		try {
			Object value_0 = name_Abstraction_4015(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Usage_4016(Usage instance) {
		try {
			Object value_0 = name_Usage_4016(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Realization_4017(Realization instance) {
		try {
			Object value_0 = name_Realization_4017(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated NOT
	 */
	private static String name_Dependency_4013(Dependency self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Abstraction_4015(Abstraction self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Usage_4016(Usage self) {
		return getName(self);
	}

	/**
	 * @generated NOT
	 */
	private static String name_Realization_4017(Realization self) {
		return getName(self);
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
	 * Custom code.
	 * 
	 * @param self
	 *        the current object
	 * 
	 * @return the element name
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self.getOwner(), self.eClass());

	}

}
