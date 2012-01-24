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
package org.eclipse.papyrus.sysml.blocks.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.sysml.blocks.BindingConnector;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.ConnectorProperty;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.papyrus.sysml.blocks.DistributedProperty;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.blocks.ParticipantProperty;
import org.eclipse.papyrus.sysml.blocks.PropertySpecificType;
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.papyrus.sysml.blocks.ValueType;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
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
 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage
 * @generated
 */
public class BlocksSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static BlocksPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public BlocksSwitch() {
		if(modelPackage == null) {
			modelPackage = BlocksPackage.eINSTANCE;
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
	 * Returns the result of interpreting the object as an instance of '<em>Binding Connector</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindingConnector(BindingConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Property</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorProperty(ConnectorProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDimension(Dimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distributed Property</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distributed Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistributedProperty(DistributedProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Connector End</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Connector End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedConnectorEnd(NestedConnectorEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant Property</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipantProperty(ParticipantProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Specific Type</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Specific Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySpecificType(PropertySpecificType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Unit</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueType(ValueType object) {
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
	 * Tell if the Class is a Block implementation
	 * 
	 * @param Class
	 * @return
	 * @generated
	 */
	protected Boolean isBlockFromClass(Class class_) {
		if(UMLUtil.getStereotypeApplication(class_, Block.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>' from Class object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassStereotypedByBlock(Class class_) {
		return null;
	}

	/**
	 * Tell if the Property is a DistributedProperty implementation
	 * 
	 * @param Property
	 * @return
	 * @generated
	 */
	protected Boolean isDistributedPropertyFromProperty(Property property_) {
		if(UMLUtil.getStereotypeApplication(property_, DistributedProperty.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DistributedProperty</em>' from Property object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DistributedProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyStereotypedByDistributedProperty(Property property_) {
		return null;
	}

	/**
	 * Tell if the InstanceSpecification is a Dimension implementation
	 * 
	 * @param InstanceSpecification
	 * @return
	 * @generated
	 */
	protected Boolean isDimensionFromInstanceSpecification(InstanceSpecification instanceSpecification_) {
		if(UMLUtil.getStereotypeApplication(instanceSpecification_, Dimension.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dimension</em>' from InstanceSpecification object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSpecificationStereotypedByDimension(InstanceSpecification instanceSpecification_) {
		return null;
	}

	/**
	 * Tell if the InstanceSpecification is a Unit implementation
	 * 
	 * @param InstanceSpecification
	 * @return
	 * @generated
	 */
	protected Boolean isUnitFromInstanceSpecification(InstanceSpecification instanceSpecification_) {
		if(UMLUtil.getStereotypeApplication(instanceSpecification_, Unit.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>' from InstanceSpecification object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSpecificationStereotypedByUnit(InstanceSpecification instanceSpecification_) {
		return null;
	}

	/**
	 * Tell if the DataType is a ValueType implementation
	 * 
	 * @param DataType
	 * @return
	 * @generated
	 */
	protected Boolean isValueTypeFromDataType(DataType dataType_) {
		if(UMLUtil.getStereotypeApplication(dataType_, ValueType.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ValueType</em>' from DataType object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ValueType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeStereotypedByValueType(DataType dataType_) {
		return null;
	}

	/**
	 * Tell if the ConnectorEnd is a NestedConnectorEnd implementation
	 * 
	 * @param ConnectorEnd
	 * @return
	 * @generated
	 */
	protected Boolean isNestedConnectorEndFromConnectorEnd(ConnectorEnd connectorEnd_) {
		if(UMLUtil.getStereotypeApplication(connectorEnd_, NestedConnectorEnd.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NestedConnectorEnd</em>' from ConnectorEnd object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NestedConnectorEnd</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorEndStereotypedByNestedConnectorEnd(ConnectorEnd connectorEnd_) {
		return null;
	}

	/**
	 * Tell if the Property is a ParticipantProperty implementation
	 * 
	 * @param Property
	 * @return
	 * @generated
	 */
	protected Boolean isParticipantPropertyFromProperty(Property property_) {
		if(UMLUtil.getStereotypeApplication(property_, ParticipantProperty.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ParticipantProperty</em>' from Property object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ParticipantProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyStereotypedByParticipantProperty(Property property_) {
		return null;
	}

	/**
	 * Tell if the Property is a ConnectorProperty implementation
	 * 
	 * @param Property
	 * @return
	 * @generated
	 */
	protected Boolean isConnectorPropertyFromProperty(Property property_) {
		if(UMLUtil.getStereotypeApplication(property_, ConnectorProperty.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ConnectorProperty</em>' from Property object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ConnectorProperty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyStereotypedByConnectorProperty(Property property_) {
		return null;
	}

	/**
	 * Tell if the Connector is a BindingConnector implementation
	 * 
	 * @param Connector
	 * @return
	 * @generated
	 */
	protected Boolean isBindingConnectorFromConnector(Connector connector_) {
		if(UMLUtil.getStereotypeApplication(connector_, BindingConnector.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>BindingConnector</em>' from Connector object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>BindingConnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorStereotypedByBindingConnector(Connector connector_) {
		return null;
	}

	/**
	 * Tell if the Classifier is a PropertySpecificType implementation
	 * 
	 * @param Classifier
	 * @return
	 * @generated
	 */
	protected Boolean isPropertySpecificTypeFromClassifier(Classifier classifier_) {
		if(UMLUtil.getStereotypeApplication(classifier_, PropertySpecificType.class) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PropertySpecificType</em>' from Classifier object. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PropertySpecificType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierStereotypedByPropertySpecificType(Classifier classifier_) {
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





			case UMLPackage.CLASS:
			{
				Class umlElement = (Class)theEObject;
				T result;

				result = caseClassStereotypedByBlock(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.CLASSIFIER:
			{
				Classifier umlElement = (Classifier)theEObject;
				T result;

				result = caseClassifierStereotypedByPropertySpecificType(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.CONNECTOR:
			{
				Connector umlElement = (Connector)theEObject;
				T result;

				result = caseConnectorStereotypedByBindingConnector(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.CONNECTOR_END:
			{
				ConnectorEnd umlElement = (ConnectorEnd)theEObject;
				T result;

				result = caseConnectorEndStereotypedByNestedConnectorEnd(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.DATA_TYPE:
			{
				DataType umlElement = (DataType)theEObject;
				T result;

				result = caseDataTypeStereotypedByValueType(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.INSTANCE_SPECIFICATION:
			{
				InstanceSpecification umlElement = (InstanceSpecification)theEObject;
				T result;

				result = caseInstanceSpecificationStereotypedByDimension(umlElement);
				if(result != null) {
					return result;
				}




				result = caseInstanceSpecificationStereotypedByUnit(umlElement);
				if(result != null) {
					return result;
				}

				return null;
			}





			case UMLPackage.PROPERTY:
			{
				Property umlElement = (Property)theEObject;
				T result;

				result = casePropertyStereotypedByDistributedProperty(umlElement);
				if(result != null) {
					return result;
				}




				result = casePropertyStereotypedByParticipantProperty(umlElement);
				if(result != null) {
					return result;
				}




				result = casePropertyStereotypedByConnectorProperty(umlElement);
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

			case BlocksPackage.BLOCK:
			{
				Block block = (Block)theEObject;
				T result = caseBlock(block);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.DISTRIBUTED_PROPERTY:
			{
				DistributedProperty distributedProperty = (DistributedProperty)theEObject;
				T result = caseDistributedProperty(distributedProperty);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.DIMENSION:
			{
				Dimension dimension = (Dimension)theEObject;
				T result = caseDimension(dimension);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.UNIT:
			{
				Unit unit = (Unit)theEObject;
				T result = caseUnit(unit);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.VALUE_TYPE:
			{
				ValueType valueType = (ValueType)theEObject;
				T result = caseValueType(valueType);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.NESTED_CONNECTOR_END:
			{
				NestedConnectorEnd nestedConnectorEnd = (NestedConnectorEnd)theEObject;
				T result = caseNestedConnectorEnd(nestedConnectorEnd);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.PARTICIPANT_PROPERTY:
			{
				ParticipantProperty participantProperty = (ParticipantProperty)theEObject;
				T result = caseParticipantProperty(participantProperty);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.CONNECTOR_PROPERTY:
			{
				ConnectorProperty connectorProperty = (ConnectorProperty)theEObject;
				T result = caseConnectorProperty(connectorProperty);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.BINDING_CONNECTOR:
			{
				BindingConnector bindingConnector = (BindingConnector)theEObject;
				T result = caseBindingConnector(bindingConnector);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}


			case BlocksPackage.PROPERTY_SPECIFIC_TYPE:
			{
				PropertySpecificType propertySpecificType = (PropertySpecificType)theEObject;
				T result = casePropertySpecificType(propertySpecificType);

				if(result == null)
					result = defaultCase(theEObject);
				return result;
			}

			default:
				return defaultCase(theEObject);
			}
		}
	}

} // BlocksSwitch
