/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.requirements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * RequirementContainer represents a larger unit or module of specification information. It is used to share several Requirements which are
 * semantically related to each other. Also, a RequirementContainer structure will be used for structuring requirement specification objects
 * (Requirements, Rationals etc.). Thus, to preserve the ordering of requirement specification objects the ordering of child containers is very
 * important here.
 * 
 * In addition to sharing related Requirements, the RequirementContainer allows to define relations between its contained Requirements and also a
 * grouping of them.
 * 
 * Furthermore, the RequirementContainer allows introducing additional user attribute definitions by way of UserAttributeElementTypes or
 * UserAttributeTemplates which are valid only locally inside this RequirementContainer. These are additional in that they are used in addition to the
 * user attribute definitions which are provided globally for the entire EAST-ADL2 repository.
 * 
 * An EAST-ADL2 system model may contain a forest of RequirementContainer (see parent child relationship). Only non root RequirementContainer which
 * have a parentContainer are allowed to reference a RequirementSpecificationObject.
 * The RequirementContainer with its parent child containment relationship and the reference to RequirementSpecificationObject is the basis element
 * for structuring requirement information into a forest structure.
 * 
 * Constraints:
 * [1] Only non root RequirementContainer (parentContainer must be set) which have a parentContainer are allowed to reference a
 * RequirementSpecificationObject.
 * 
 * Notation:
 * RequirementContainer is shown as a solid-outline rectangle containing the name. Contained entities may also be shown inside (White-box view)
 * 
 * Extension: Package
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getChildContainer <em>Child Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer <em>Parent Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getContainedReqSpecObject <em>Contained Req Spec Object</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer()
 * @model
 * @generated
 */
public interface RequirementsContainer extends TraceableSpecification {

	/**
	 * Returns the value of the '<em><b>Child Container</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer
	 * <em>Parent Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sub containers of a requirement container. Sub containers may have references (each time max. 1) to requirement specification objects. To
	 * preserve the original ordering of requirement specifiaction objects, the ordering of Sub containers is very important here.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Child Container</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer_ChildContainer()
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer
	 * @model opposite="parentContainer"
	 * @generated
	 */
	EList<RequirementsContainer> getChildContainer();

	/**
	 * Returns the value of the '<em><b>Contained Req Spec Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Req Spec Object</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contained Req Spec Object</em>' reference.
	 * @see #setContainedReqSpecObject(RequirementSpecificationObject)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer_ContainedReqSpecObject()
	 * @model ordered="false"
	 * @generated
	 */
	RequirementSpecificationObject getContainedReqSpecObject();

	/**
	 * Returns the value of the '<em><b>Parent Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getChildContainer
	 * <em>Child Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Parent container of a container. If there is no parent, the container is a root container and thus cannot have a reference to a requirement
	 * specification object.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Parent Container</em>' reference.
	 * @see #setParentContainer(RequirementsContainer)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer_ParentContainer()
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getChildContainer
	 * @model opposite="childContainer" ordered="false"
	 * @generated
	 */
	RequirementsContainer getParentContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getContainedReqSpecObject
	 * <em>Contained Req Spec Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Contained Req Spec Object</em>' reference.
	 * @see #getContainedReqSpecObject()
	 * @generated
	 */
	void setContainedReqSpecObject(RequirementSpecificationObject value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getParentContainer <em>Parent Container</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Parent Container</em>' reference.
	 * @see #getParentContainer()
	 * @generated
	 */
	void setParentContainer(RequirementsContainer value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.eastadl.requirements.RequirementsPackage#getRequirementsContainer_Base_Package()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.RequirementsContainer#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // RequirementsContainer
