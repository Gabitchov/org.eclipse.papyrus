/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ClassCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Comment2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ComponentCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Constraint2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DataType2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Enumeration2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.InstanceSpecification2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.InstanceSpecificationCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.InterfaceCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Model2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.Package2CreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.edit.commands.SignalCreateCommandCN;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackagePackageableElementCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.InstanceSpecification_3020 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new InstanceSpecificationCreateCommandCN(req));
		}
		if (UMLElementTypes.Component_3021 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new ComponentCreateCommandCN(req));
		}
		if (UMLElementTypes.Signal_3022 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new SignalCreateCommandCN(req));
		}
		if (UMLElementTypes.Interface_3023 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new InterfaceCreateCommandCN(req));
		}
		if (UMLElementTypes.Model_3024 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new Model2CreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_3025 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new EnumerationCreateCommandCN(req));
		}
		if (UMLElementTypes.Package_3009 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new Package2CreateCommand(req));
		}
		if (UMLElementTypes.Class_3010 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new ClassCreateCommandCN(req));
		}
		if (UMLElementTypes.PrimitiveType_3026 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req));
		}
		if (UMLElementTypes.DataType_3027 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new DataTypeCreateCommandCN(req));
		}
		if (UMLElementTypes.Comment_3028 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getElement_OwnedComment());
			}
			return getGEFWrapper(new Comment2CreateCommand(req));
		}
		if (UMLElementTypes.Constraint_3029 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			}
			return getGEFWrapper(new Constraint2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
