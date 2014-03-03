/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.providers;

import org.eclipse.papyrus.uml.diagram.clazz.expressions.UMLOCLFactory;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
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
	public void init_AssociationClass_2013(AssociationClass instance) {
		try {
			Object value_0 = name_AssociationClass_2013(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InstanceSpecification_2001(InstanceSpecification instance) {
		try {
			Object value_0 = name_InstanceSpecification_2001(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_2002(Component instance) {
		try {
			Object value_0 = name_Component_2002(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_2003(Signal instance) {
		try {
			Object value_0 = name_Signal_2003(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_2004(Interface instance) {
		try {
			Object value_0 = name_Interface_2004(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Model_2005(Model instance) {
		try {
			Object value_0 = name_Model_2005(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_2006(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_2006(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_2007(Package instance) {
		try {
			Object value_0 = name_Package_2007(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationItem_2099(InformationItem instance) {
		try {
			Object value_0 = name_InformationItem_2099(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_2008(Class instance) {
		try {
			Object value_0 = name_Class_2008(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_2009(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_2009(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_2010(DataType instance) {
		try {
			Object value_0 = name_DataType_2010(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_2011(Constraint instance) {
		try {
			Object value_0 = name_Constraint_2011(instance);
			instance.setName(
					(String) value_0
					);
			Object value_1 = specification_Constraint_2011(instance);
			instance.setSpecification(
					(ValueSpecification) value_1
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_2012(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DurationObservation_2095(DurationObservation instance) {
		try {
			Object value_0 = name_DurationObservation_2095(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_TimeObservation_2096(TimeObservation instance) {
		try {
			Object value_0 = name_TimeObservation_2096(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3012(Property instance) {
		try {
			Object value_0 = name_Property_3012(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3002(Property instance) {
		try {
			Object value_0 = name_Property_3002(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3005(Property instance) {
		try {
			Object value_0 = name_Property_3005(instance);
			instance.setName(
					(String) value_0
					);
			instance.setLower(
					0
					);

			instance.setUpper(
					1
					);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3006(Property instance) {
		try {
			Object value_0 = name_Property_3006(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3041(Property instance) {
		try {
			Object value_0 = name_Property_3041(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Property_3018(Property instance) {
		try {
			Object value_0 = name_Property_3018(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3014(Class instance) {
		try {
			Object value_0 = name_Class_3014(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3004(Class instance) {
		try {
			Object value_0 = name_Class_3004(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3008(Class instance) {
		try {
			Object value_0 = name_Class_3008(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3013(Operation instance) {
		try {
			Object value_0 = name_Operation_3013(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3003(Operation instance) {
		try {
			Object value_0 = name_Operation_3003(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3007(Operation instance) {
		try {
			Object value_0 = name_Operation_3007(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3042(Operation instance) {
		try {
			Object value_0 = name_Operation_3042(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3019(Operation instance) {
		try {
			Object value_0 = name_Operation_3019(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EnumerationLiteral_3017(EnumerationLiteral instance) {
		try {
			Object value_0 = name_EnumerationLiteral_3017(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Reception_3011(Reception instance) {
		try {
			Object value_0 = name_Reception_3011(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Reception_3039(Reception instance) {
		try {
			Object value_0 = name_Reception_3039(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_RedefinableTemplateSignature_3015(RedefinableTemplateSignature instance) {
		try {
			Object value_0 = name_RedefinableTemplateSignature_3015(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InstanceSpecification_3020(InstanceSpecification instance) {
		try {
			Object value_0 = name_InstanceSpecification_3020(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Component_3021(Component instance) {
		try {
			Object value_0 = name_Component_3021(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_3022(Signal instance) {
		try {
			Object value_0 = name_Signal_3022(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3023(Interface instance) {
		try {
			Object value_0 = name_Interface_3023(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Model_3024(Model instance) {
		try {
			Object value_0 = name_Model_3024(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3025(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3025(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_3009(Package instance) {
		try {
			Object value_0 = name_Package_3009(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationItem_3040(InformationItem instance) {
		try {
			Object value_0 = name_InformationItem_3040(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3010(Class instance) {
		try {
			Object value_0 = name_Class_3010(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3026(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3026(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3027(DataType instance) {
		try {
			Object value_0 = name_DataType_3027(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_3028(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression(0, UMLPackage.eINSTANCE.getComment(), null).evaluate(instance);
			instance.setBody(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_3029(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3029(instance);
			instance.setName(
					(String) value_0
					);
			Object value_1 = specification_Constraint_3029(instance);
			instance.setSpecification(
					(ValueSpecification) value_1
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3036(Interface instance) {
		try {
			Object value_0 = name_Interface_3036(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3037(Interface instance) {
		try {
			Object value_0 = name_Interface_3037(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Interface_3038(Interface instance) {
		try {
			Object value_0 = name_Interface_3038(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3052(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3052(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3053(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3053(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Enumeration_3054(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3054(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3047(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3047(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3046(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3046(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_PrimitiveType_3048(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3048(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3044(DataType instance) {
		try {
			Object value_0 = name_DataType_3044(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3045(DataType instance) {
		try {
			Object value_0 = name_DataType_3045(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_DataType_3043(DataType instance) {
		try {
			Object value_0 = name_DataType_3043(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_3050(Signal instance) {
		try {
			Object value_0 = name_Signal_3050(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_3051(Signal instance) {
		try {
			Object value_0 = name_Signal_3051(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Signal_3049(Signal instance) {
		try {
			Object value_0 = name_Signal_3049(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_AssociationClass_4017(AssociationClass instance) {
		try {
			Object value_0 = name_AssociationClass_4017(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Association_4001(Association instance) {
		try {
			Object value_0 = name_Association_4001(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InterfaceRealization_4003(InterfaceRealization instance) {
		try {
			Object value_0 = name_InterfaceRealization_4003(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Substitution_4004(Substitution instance) {
		try {
			Object value_0 = name_Substitution_4004(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Realization_4005(Realization instance) {
		try {
			Object value_0 = name_Realization_4005(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Abstraction_4006(Abstraction instance) {
		try {
			Object value_0 = name_Abstraction_4006(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Usage_4007(Usage instance) {
		try {
			Object value_0 = name_Usage_4007(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4008(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4008(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Dependency_4018(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4018(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ElementImport_4009(ElementImport instance) {
		try {
			Object value_0 = alias_ElementImport_4009(instance);
			instance.setAlias(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_InformationFlow_4026(InformationFlow instance) {
		try {
			Object value_0 = name_InformationFlow_4026(instance);
			instance.setName(
					(String) value_0
					);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_AssociationClass_2013(AssociationClass it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_InstanceSpecification_2001(InstanceSpecification it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Component_2002(Component it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Signal_2003(Signal it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Interface_2004(Interface it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Model_2005(Model it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_2006(Enumeration it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Package_2007(Package it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_InformationItem_2099(InformationItem it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Class_2008(Class it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_2009(PrimitiveType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_DataType_2010(DataType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Constraint_2011(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_2011(Constraint it) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
	}

	/**
	 * @generated
	 */
	private String name_DurationObservation_2095(DurationObservation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_TimeObservation_2096(TimeObservation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3012(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3002(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3005(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3006(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3041(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Property_3018(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Class_3014(Class it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Class_3004(Class it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Class_3008(Class it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3013(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3003(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3007(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3042(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3019(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_EnumerationLiteral_3017(EnumerationLiteral it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Reception_3011(Reception it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Reception_3039(Reception it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_RedefinableTemplateSignature_3015(RedefinableTemplateSignature it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_InstanceSpecification_3020(InstanceSpecification it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Component_3021(Component it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Signal_3022(Signal it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Interface_3023(Interface it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Model_3024(Model it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3025(Enumeration it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Package_3009(Package it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_InformationItem_3040(InformationItem it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Class_3010(Class it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3026(PrimitiveType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3027(DataType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Constraint_3029(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_3029(Constraint it) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
	}

	/**
	 * @generated
	 */
	private String name_Interface_3036(Interface it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Interface_3037(Interface it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Interface_3038(Interface it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3052(Enumeration it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3053(Enumeration it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Enumeration_3054(Enumeration it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3047(PrimitiveType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3046(PrimitiveType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_PrimitiveType_3048(PrimitiveType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3044(DataType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3045(DataType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_DataType_3043(DataType it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Signal_3050(Signal it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Signal_3051(Signal it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Signal_3049(Signal it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_AssociationClass_4017(AssociationClass it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Association_4001(Association it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_InterfaceRealization_4003(InterfaceRealization it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Substitution_4004(Substitution it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Realization_4005(Realization it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Abstraction_4006(Abstraction it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Usage_4007(Usage it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Dependency_4008(Dependency it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Dependency_4018(Dependency it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String alias_ElementImport_4009(ElementImport it) {
		if (it.getImportedElement() != null) {
			return (it.getImportedElement().getLabel());
		}
		return "elementimport";
	}

	/**
	 * @generated
	 */
	private String name_InformationFlow_4026(InformationFlow it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = UMLDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			UMLDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
