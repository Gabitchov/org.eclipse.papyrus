/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.providers;

import org.eclipse.papyrus.diagram.clazz.custom.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.clazz.expressions.UMLOCLFactory;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * @generated
 */
public class ElementInitializers {
	/**
	 * @generated
	 */
	private static String alias_ElementImport_4009(ElementImport self) {
		if (self.getImportedElement() != null) {
			return (self.getImportedElement().getLabel());
		}
		return "elementimport";
	}

	/**
	 * Custom code
	 * 
	 * @param self
	 * @return
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self
				.getOwner(), self.eClass());

	}

	/**
	 * @generated
	 */
	public static void init_Abstraction_4006(Abstraction instance) {
		try {
			Object value_0 = name_Abstraction_4006(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Association_4001(Association instance) {
		try {
			Object value_0 = name_Association_4001(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AssociationClass_2013(AssociationClass instance) {
		try {
			Object value_0 = name_AssociationClass_2013(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_AssociationClass_4017(AssociationClass instance) {
		try {
			Object value_0 = name_AssociationClass_4017(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_2008(Class instance) {
		try {
			Object value_0 = name_Class_2008(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3004(Class instance) {
		try {
			Object value_0 = name_Class_3004(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3008(Class instance) {
		try {
			Object value_0 = name_Class_3008(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3010(Class instance) {
		try {
			Object value_0 = name_Class_3010(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Class_3014(Class instance) {
		try {
			Object value_0 = name_Class_3014(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Comment_2012(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("\' \'",
					UMLPackage.eINSTANCE.getComment()).evaluate(instance);
			instance.setBody((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Comment_3028(Comment instance) {
		try {
			Object value_0 = UMLOCLFactory.getExpression("\' \'",
					UMLPackage.eINSTANCE.getComment()).evaluate(instance);
			instance.setBody((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Component_2002(Component instance) {
		try {
			Object value_0 = name_Component_2002(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Component_3021(Component instance) {
		try {
			Object value_0 = name_Component_3021(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_2011(Constraint instance) {
		try {
			Object value_0 = name_Constraint_2011(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Constraint_3029(Constraint instance) {
		try {
			Object value_0 = name_Constraint_3029(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataType_2010(DataType instance) {
		try {
			Object value_0 = name_DataType_2010(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_DataType_3027(DataType instance) {
		try {
			Object value_0 = name_DataType_3027(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Dependency_4008(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4008(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Dependency_4018(Dependency instance) {
		try {
			Object value_0 = name_Dependency_4018(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_ElementImport_4009(ElementImport instance) {
		try {
			Object value_0 = alias_ElementImport_4009(instance);
			instance.setAlias((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Enumeration_2006(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_2006(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Enumeration_3025(Enumeration instance) {
		try {
			Object value_0 = name_Enumeration_3025(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_EnumerationLiteral_3017(EnumerationLiteral instance) {
		try {
			Object value_0 = name_EnumerationLiteral_3017(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_2001(
			InstanceSpecification instance) {
		try {
			Object value_0 = name_InstanceSpecification_2001(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InstanceSpecification_3020(
			InstanceSpecification instance) {
		try {
			Object value_0 = name_InstanceSpecification_3020(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interface_2004(Interface instance) {
		try {
			Object value_0 = name_Interface_2004(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Interface_3023(Interface instance) {
		try {
			Object value_0 = name_Interface_3023(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_InterfaceRealization_4003(
			InterfaceRealization instance) {
		try {
			Object value_0 = name_InterfaceRealization_4003(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Model_2005(Model instance) {
		try {
			Object value_0 = name_Model_2005(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Model_3024(Model instance) {
		try {
			Object value_0 = name_Model_3024(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3003(Operation instance) {
		try {
			Object value_0 = name_Operation_3003(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3007(Operation instance) {
		try {
			Object value_0 = name_Operation_3007(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3013(Operation instance) {
		try {
			Object value_0 = name_Operation_3013(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Operation_3019(Operation instance) {
		try {
			Object value_0 = name_Operation_3019(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_2007(Package instance) {
		try {
			Object value_0 = name_Package_2007(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Package_3009(Package instance) {
		try {
			Object value_0 = name_Package_3009(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_PrimitiveType_2009(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_2009(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_PrimitiveType_3026(PrimitiveType instance) {
		try {
			Object value_0 = name_PrimitiveType_3026(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3002(Property instance) {
		try {
			Object value_0 = name_Property_3002(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3005(Property instance) {
		try {
			Object value_0 = name_Property_3005(instance);
			instance.setName((String) value_0);
			instance.setLower(0);
			instance.setUpper(1);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3006(Property instance) {
		try {
			Object value_0 = name_Property_3006(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3012(Property instance) {
		try {
			Object value_0 = name_Property_3012(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Property_3018(Property instance) {
		try {
			Object value_0 = name_Property_3018(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Realization_4005(Realization instance) {
		try {
			Object value_0 = name_Realization_4005(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Reception_3011(Reception instance) {
		try {
			Object value_0 = name_Reception_3011(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Signal_2003(Signal instance) {
		try {
			Object value_0 = name_Signal_2003(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Signal_3022(Signal instance) {
		try {
			Object value_0 = name_Signal_3022(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Substitution_4004(Substitution instance) {
		try {
			Object value_0 = name_Substitution_4004(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Usage_4007(Usage instance) {
		try {
			Object value_0 = name_Usage_4007(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private static String name_Abstraction_4006(Abstraction self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Association_4001(Association self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_AssociationClass_2013(AssociationClass self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_AssociationClass_4017(AssociationClass self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Class_2008(Class self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Class_3004(Class self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Class_3008(Class self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Class_3010(Class self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Class_3014(Class self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Component_2002(Component self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Component_3021(Component self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Constraint_2011(Constraint self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Constraint_3029(Constraint self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_DataType_2010(DataType self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_DataType_3027(DataType self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Dependency_4008(Dependency self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Dependency_4018(Dependency self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Enumeration_2006(Enumeration self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Enumeration_3025(Enumeration self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_EnumerationLiteral_3017(EnumerationLiteral self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_InstanceSpecification_2001(
			InstanceSpecification self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_InstanceSpecification_3020(
			InstanceSpecification self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Interface_2004(Interface self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Interface_3023(Interface self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_InterfaceRealization_4003(
			InterfaceRealization self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Model_2005(Model self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Model_3024(Model self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Operation_3003(Operation self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Operation_3007(Operation self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Operation_3013(Operation self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Operation_3019(Operation self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Package_2007(Package self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Package_3009(Package self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_PrimitiveType_2009(PrimitiveType self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_PrimitiveType_3026(PrimitiveType self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Property_3002(Property self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Property_3005(Property self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Property_3006(Property self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Property_3012(Property self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Property_3018(Property self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Realization_4005(Realization self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Reception_3011(Reception self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Signal_2003(Signal self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Signal_3022(Signal self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Substitution_4004(Substitution self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Usage_4007(Usage self) {
		return getName(self);
	}

}
