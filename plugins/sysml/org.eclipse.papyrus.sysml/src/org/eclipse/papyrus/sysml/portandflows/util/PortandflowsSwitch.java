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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.portandflows.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.FlowProperty;
import org.eclipse.papyrus.sysml.portandflows.FlowSpecification;
import org.eclipse.papyrus.sysml.portandflows.ItemFlow;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage
 * @generated
 */
public class PortandflowsSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static PortandflowsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public PortandflowsSwitch() {
		if(modelPackage == null) {
			modelPackage = PortandflowsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		/**
		 * ePackage == UMLPackage.eINSTANCE in order to accept UML element
		 */
		return ePackage == modelPackage || ePackage == UMLPackage.eINSTANCE;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowPort(FlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Property</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowProperty(FlowProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowSpecification(FlowSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Flow</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItemFlow(ItemFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Tell if the Port is a FlowPort implementation
	 * 
	 * @param Port
	 * @return
	 * @generated
	 */
	protected Boolean isFlowPortFromPort(Port port_) {
		if(UMLUtil.getStereotypeApplication(port_, FlowPort.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FlowPort</em>' from Port object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FlowPort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortStereotypedByFlowPort(Port port_) {
		return null;
	}

	/**
	 * Tell if the Property is a FlowProperty implementation
	 * 
	 * @param Property
	 * @return
	 * @generated
	 */
	protected Boolean isFlowPropertyFromProperty(Property property_) {
		if(UMLUtil.getStereotypeApplication(property_, FlowProperty.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FlowProperty</em>' from Property object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FlowProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyStereotypedByFlowProperty(Property property_) {
		return null;
	}

	/**
	 * Tell if the Interface is a FlowSpecification implementation
	 * 
	 * @param Interface
	 * @return
	 * @generated
	 */
	protected Boolean isFlowSpecificationFromInterface(Interface interface_) {
		if(UMLUtil.getStereotypeApplication(interface_, FlowSpecification.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FlowSpecification</em>' from Interface object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FlowSpecification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceStereotypedByFlowSpecification(Interface interface_) {
		return null;
	}

	/**
	 * Tell if the InformationFlow is a ItemFlow implementation
	 * 
	 * @param InformationFlow
	 * @return
	 * @generated
	 */
	protected Boolean isItemFlowFromInformationFlow(InformationFlow informationFlow_) {
		if(UMLUtil.getStereotypeApplication(informationFlow_, ItemFlow.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ItemFlow</em>' from InformationFlow object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ItemFlow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInformationFlowStereotypedByItemFlow(InformationFlow informationFlow_) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		if(theEObject.eClass().getEPackage() == UMLPackage.eINSTANCE) {
			switch(classifierID) {





			case UMLPackage.INFORMATION_FLOW:
			{
				InformationFlow umlElement = (InformationFlow)theEObject;
				T result;

				result = caseInformationFlowStereotypedByItemFlow(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.INTERFACE:
			{
				Interface umlElement = (Interface)theEObject;
				T result;

				result = caseInterfaceStereotypedByFlowSpecification(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.PORT:
			{
				Port umlElement = (Port)theEObject;
				T result;

				result = casePortStereotypedByFlowPort(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.PROPERTY:
			{
				Property umlElement = (Property)theEObject;
				T result;

				result = casePropertyStereotypedByFlowProperty(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}




			default:
				return defaultCase(theEObject);
			}




		} else {
			switch(classifierID) {

			case PortandflowsPackage.FLOW_PORT:
			{
				FlowPort flowPort = (FlowPort)theEObject;
				T result = caseFlowPort(flowPort);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case PortandflowsPackage.FLOW_PROPERTY:
			{
				FlowProperty flowProperty = (FlowProperty)theEObject;
				T result = caseFlowProperty(flowProperty);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case PortandflowsPackage.FLOW_SPECIFICATION:
			{
				FlowSpecification flowSpecification = (FlowSpecification)theEObject;
				T result = caseFlowSpecification(flowSpecification);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case PortandflowsPackage.ITEM_FLOW:
			{
				ItemFlow itemFlow = (ItemFlow)theEObject;
				T result = caseItemFlow(itemFlow);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}

			default:
				return defaultCase(theEObject);
			}
		}
	}

} // PortandflowsSwitch
