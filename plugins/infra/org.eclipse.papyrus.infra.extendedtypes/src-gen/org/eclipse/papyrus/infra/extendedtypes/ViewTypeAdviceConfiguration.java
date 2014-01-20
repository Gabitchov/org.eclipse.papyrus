/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Type Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * Configuration for edit helper advices dedicated to the creation of new elements only.
 * 
 * This kind of helpers should be used in the palette extensions, modeling assistants, model explorer, property views.
 * Once the element has been created, it is managed by the edit helper and the advices of the specialized ElementType.
 * 
 * <!-- end-model-doc -->
 * 
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getViewTypeAdviceConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface ViewTypeAdviceConfiguration extends ElementTypeAdviceConfiguration {
} // ViewTypeAdviceConfiguration
