/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.impl.UpdateAttributeImpl;
import org.eclipse.emf.compare.util.AdapterUtils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Tagged Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UpdateTaggedValueImpl extends TaggedValueChangeImpl implements UpdateTaggedValue {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateTaggedValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.UPDATE_TAGGED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getText() {

		final String attributeLabel = AdapterUtils.getItemProviderText(getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(getLeftElement()).getValue(UMLUtil.getStereotype(getLeftElement()), getAttribute().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(getRightElement()).getValue(UMLUtil.getStereotype(getRightElement()), getAttribute().getName());

		String leftValue = leftTaggedValue != null ? leftTaggedValue.toString() : "null";
		String rightValue = rightTaggedValue != null ? rightTaggedValue.toString() : "null";

		final String diffLabel;
		if(isRemote()) {
			diffLabel = String.format("Tagged value %s : remote = %s, local = %s", elementLabel, leftValue, rightValue);
		} else {
			diffLabel = String.format("Tagged value %s: %s -> %s", attributeLabel, rightValue, leftValue);
		}
		return diffLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getImage() {
		AdapterFactoryLabelProvider adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());
		Image labelImage = adapterProvider.getImage(getAttribute());
		return labelImage;
	}

} //UpdateTaggedValueImpl
