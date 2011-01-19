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

import org.eclipse.emf.compare.diff.metamodel.impl.AttributeChangeImpl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class TaggedValueChangeImpl extends AttributeChangeImpl implements TaggedValueChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedValueChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.TAGGED_VALUE_CHANGE;
	}

} //TaggedValueChangeImpl
