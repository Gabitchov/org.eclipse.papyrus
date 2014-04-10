/*
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.diagram.profile.providers;

import org.eclipse.papyrus.uml.diagram.profile.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
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
	public void init_Stereotype_1026(Stereotype instance) {
		try {
			Object value_0 = name_Stereotype_1026(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_1031(Class instance) {
		try {
			Object value_0 = isAbstract_Class_1031(instance);
			instance.setIsAbstract(((Boolean)value_0).booleanValue());
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_1002(Comment instance) {
		try {
			Object value_0 = body_Comment_1002(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_1014(Constraint instance) {
		try {
			Object value_0 = name_Constraint_1014(instance);
			instance.setName((String)value_0);
			Object value_1 = specification_Constraint_1014(instance);
			instance.setSpecification((ValueSpecification)value_1);
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
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Profile_1030(Profile instance) {
		try {
			Object value_0 = name_Profile_1030(instance);
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EnumerationLiteral_1037(EnumerationLiteral instance) {
		try {
			Object value_0 = name_EnumerationLiteral_1037(instance);
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Operation_3020(Operation instance) {
		try {
			Object value_0 = name_Operation_3020(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Stereotype_1023(Stereotype instance) {
		try {
			Object value_0 = name_Stereotype_1023(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Class_3028(Class instance) {
		try {
			Object value_0 = isAbstract_Class_3028(instance);
			instance.setIsAbstract(((Boolean)value_0).booleanValue());
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Comment_1007(Comment instance) {
		try {
			Object value_0 = body_Comment_1007(instance);
			instance.setBody((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Model_1027(Model instance) {
		try {
			Object value_0 = name_Model_1027(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Profile_1024(Profile instance) {
		try {
			Object value_0 = name_Profile_1024(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Package_1012(Package instance) {
		try {
			Object value_0 = name_Package_1012(instance);
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_Constraint_1028(Constraint instance) {
		try {
			Object value_0 = name_Constraint_1028(instance);
			instance.setName((String)value_0);
			Object value_1 = specification_Constraint_1028(instance);
			instance.setSpecification((ValueSpecification)value_1);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
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
			instance.setName((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_ElementImport_1064(ElementImport instance) {
		try {
			Object value_0 = alias_ElementImport_1064(instance);
			instance.setAlias((String)value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private String name_Stereotype_1026(Stereotype it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private Boolean isAbstract_Class_1031(Class it) {
		//isAbstract = true
		return true;
	}

	/**
	 * @generated
	 */
	private String body_Comment_1002(Comment it) {
		return it.getBody();
	}

	/**
	 * @generated
	 */
	private String name_Constraint_1014(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_1014(Constraint it) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
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
	private String name_Profile_1030(Profile it) {
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
	private String name_Enumeration_2006(Enumeration it) {
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
	private String name_PrimitiveType_3026(PrimitiveType it) {
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
	private String name_EnumerationLiteral_1037(EnumerationLiteral it) {
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
	private String name_Property_3002(Property it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Operation_3020(Operation it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Stereotype_1023(Stereotype it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private Boolean isAbstract_Class_3028(Class it) {
		//isAbstract = true
		return true;
	}

	/**
	 * @generated
	 */
	private String body_Comment_1007(Comment it) {
		return it.getBody();
	}

	/**
	 * @generated
	 */
	private String name_Model_1027(Model it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Profile_1024(Profile it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Package_1012(Package it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private String name_Constraint_1028(Constraint it) {
		return NamedElementUtil.getDefaultNameWithIncrementFromBase(it.eClass().getName(), it.getOwner().eContents());
	}

	/**
	 * @generated
	 */
	private ValueSpecification specification_Constraint_1028(Constraint it) {
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("");
		return literalString;
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
	private String name_DataType_3027(DataType it) {
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
	private String alias_ElementImport_1064(ElementImport it) {
		if(it.getImportedElement() != null) {
			return (it.getImportedElement().getLabel());
		}
		return "elementimport";
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
