/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UMLViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Class view descriptor
	 */
	public static class Class_ {

		public static String name = "UML::Class::name";

		public static String visibility = "UML::Class::visibility";

		public static String isAbstract = "UML::Class::isAbstract";

		public static String isLeaf = "UML::Class::isLeaf";

		public static String isActive = "UML::Class::isActive";



		public static String ownedAttribute = "UML::Class::ownedAttribute";

		public static String ownedOperation = "UML::Class::ownedOperation";

		public static String nestedClassifier = "UML::Class::nestedClassifier";



		public static String generalization = "UML::Class::generalization";

		public static String interfaceRealization = "UML::Class::interfaceRealization";

		public static String redefinedClassifier = "UML::Class::redefinedClassifier";



		public static String templateBinding = "UML::Class::templateBinding";

		public static String elementImport = "UML::Class::elementImport";

		public static String packageImport = "UML::Class::packageImport";

		public static String useCase = "UML::Class::useCase";

		public static String ownedUseCase = "UML::Class::ownedUseCase";

		public static String collaborationUse = "UML::Class::collaborationUse";

		public static String ownedReception = "UML::Class::ownedReception";

		public static String ownedTrigger = "UML::Class::ownedTrigger";

		public static String ownedConnector = "UML::Class::ownedConnector";

		public static String ownedBehavior = "UML::Class::ownedBehavior";

		public static String substitution = "UML::Class::substitution";

		public static String ownedRule = "UML::Class::ownedRule";

		public static String powertypeExtent = "UML::Class::powertypeExtent";



	}

	/**
	 * AssociationClass view descriptor
	 */
	public static class AssociationClass {

		public static String name = "UML::AssociationClass::name";

		public static String visibility = "UML::AssociationClass::visibility";

		public static String isLeaf = "UML::AssociationClass::isLeaf";

		public static String isAbstract = "UML::AssociationClass::isAbstract";

		public static String isActive = "UML::AssociationClass::isActive";

		public static String isDerived = "UML::AssociationClass::isDerived";


		public static String ownedEnd = "UML::AssociationClass::ownedEnd";

		public static String memberEnd = "UML::AssociationClass::memberEnd";

		public static String navigableOwnedEnd = "UML::AssociationClass::navigableOwnedEnd";



		public static String ownedReception = "UML::AssociationClass::ownedReception";

		public static String interfaceRealization = "UML::AssociationClass::interfaceRealization";

		public static String ownedOperation = "UML::AssociationClass::ownedOperation";

		public static String nestedClassifier = "UML::AssociationClass::nestedClassifier";

		public static String ownedTrigger = "UML::AssociationClass::ownedTrigger";

		public static String ownedBehavior = "UML::AssociationClass::ownedBehavior";

		public static String ownedConnector = "UML::AssociationClass::ownedConnector";

		public static String ownedAttribute = "UML::AssociationClass::ownedAttribute";

		public static String useCase = "UML::AssociationClass::useCase";

		public static String ownedUseCase = "UML::AssociationClass::ownedUseCase";

		public static String collaborationUse = "UML::AssociationClass::collaborationUse";

		public static String redefinedClassifier = "UML::AssociationClass::redefinedClassifier";

		public static String generalization = "UML::AssociationClass::generalization";

		public static String templateBinding = "UML::AssociationClass::templateBinding";

		public static String substitution = "UML::AssociationClass::substitution";

		public static String packageImport = "UML::AssociationClass::packageImport";

		public static String elementImport = "UML::AssociationClass::elementImport";

		public static String powertypeExtent = "UML::AssociationClass::powertypeExtent";

		public static String ownedRule = "UML::AssociationClass::ownedRule";



	}

	/**
	 * LiteralUnlimitedNatural view descriptor
	 */
	public static class LiteralUnlimitedNatural {

		public static String ownedComment = "UML::LiteralUnlimitedNatural::ownedComment";

		public static String name = "UML::LiteralUnlimitedNatural::name";

		public static String visibility = "UML::LiteralUnlimitedNatural::visibility";

		public static String clientDependency = "UML::LiteralUnlimitedNatural::clientDependency";

		public static String value = "UML::LiteralUnlimitedNatural::value";


	}

	/**
	 * InstanceValue view descriptor
	 */
	public static class InstanceValue {

		public static String ownedComment = "UML::InstanceValue::ownedComment";

		public static String name = "UML::InstanceValue::name";

		public static String visibility = "UML::InstanceValue::visibility";

		public static String clientDependency = "UML::InstanceValue::clientDependency";


	}

	/**
	 * LiteralNull view descriptor
	 */
	public static class LiteralNull {

		public static String ownedComment = "UML::LiteralNull::ownedComment";

		public static String name = "UML::LiteralNull::name";

		public static String visibility = "UML::LiteralNull::visibility";

		public static String clientDependency = "UML::LiteralNull::clientDependency";


	}

	/**
	 * LiteralBoolean view descriptor
	 */
	public static class LiteralBoolean {

		public static String ownedComment = "UML::LiteralBoolean::ownedComment";

		public static String name = "UML::LiteralBoolean::name";

		public static String visibility = "UML::LiteralBoolean::visibility";

		public static String clientDependency = "UML::LiteralBoolean::clientDependency";

		public static String value = "UML::LiteralBoolean::value";


	}

	/**
	 * LiteralString view descriptor
	 */
	public static class LiteralString {

		public static String ownedComment = "UML::LiteralString::ownedComment";

		public static String name = "UML::LiteralString::name";

		public static String visibility = "UML::LiteralString::visibility";

		public static String clientDependency = "UML::LiteralString::clientDependency";

		public static String value = "UML::LiteralString::value";


	}

	/**
	 * LiteralInteger view descriptor
	 */
	public static class LiteralInteger {

		public static String ownedComment = "UML::LiteralInteger::ownedComment";

		public static String name = "UML::LiteralInteger::name";

		public static String visibility = "UML::LiteralInteger::visibility";

		public static String clientDependency = "UML::LiteralInteger::clientDependency";

		public static String value = "UML::LiteralInteger::value";


	}

	/**
	 * PrimitiveType view descriptor
	 */
	public static class PrimitiveType {

		public static String name = "UML::PrimitiveType::name";

		public static String visibility = "UML::PrimitiveType::visibility";

		public static String isAbstract = "UML::PrimitiveType::isAbstract";

		public static String isLeaf = "UML::PrimitiveType::isLeaf";



		public static String redefinedClassifier = "UML::PrimitiveType::redefinedClassifier";

		public static String ownedOperation = "UML::PrimitiveType::ownedOperation";

		public static String ownedAttribute = "UML::PrimitiveType::ownedAttribute";

		public static String useCase = "UML::PrimitiveType::useCase";

		public static String ownedUseCase = "UML::PrimitiveType::ownedUseCase";

		public static String collaborationUse = "UML::PrimitiveType::collaborationUse";

		public static String substitution = "UML::PrimitiveType::substitution";

		public static String powertypeExtent = "UML::PrimitiveType::powertypeExtent";

		public static String generalization = "UML::PrimitiveType::generalization";

		public static String templateBinding = "UML::PrimitiveType::templateBinding";

		public static String elementImport = "UML::PrimitiveType::elementImport";

		public static String packageImport = "UML::PrimitiveType::packageImport";

		public static String ownedRule = "UML::PrimitiveType::ownedRule";



	}

	/**
	 * Slot view descriptor
	 */
	public static class Slot {

		public static String value = "UML::Slot::value";


	}

	/**
	 * InstanceSpecification view descriptor
	 */
	public static class InstanceSpecification {

		public static String name = "UML::InstanceSpecification::name";

		public static String visibility = "UML::InstanceSpecification::visibility";

		public static String slot = "UML::InstanceSpecification::slot";

		public static String classifier = "UML::InstanceSpecification::classifier";

		public static String deployment = "UML::InstanceSpecification::deployment";



	}

	/**
	 * EnumerationLiteral view descriptor
	 */
	public static class EnumerationLiteral {

		public static String name = "UML::EnumerationLiteral::name";

		public static String visibility = "UML::EnumerationLiteral::visibility";

		public static String deployment = "UML::EnumerationLiteral::deployment";

		public static String slot = "UML::EnumerationLiteral::slot";

		public static String classifier = "UML::EnumerationLiteral::classifier";



	}

	/**
	 * Enumeration view descriptor
	 */
	public static class Enumeration {

		public static String name = "UML::Enumeration::name";

		public static String visibility = "UML::Enumeration::visibility";

		public static String isAbstract = "UML::Enumeration::isAbstract";

		public static String isLeaf = "UML::Enumeration::isLeaf";



		public static String generalization = "UML::Enumeration::generalization";

		public static String templateBinding = "UML::Enumeration::templateBinding";

		public static String elementImport = "UML::Enumeration::elementImport";

		public static String packageImport = "UML::Enumeration::packageImport";

		public static String ownedRule = "UML::Enumeration::ownedRule";

		public static String powertypeExtent = "UML::Enumeration::powertypeExtent";

		public static String ownedAttribute = "UML::Enumeration::ownedAttribute";

		public static String ownedOperation = "UML::Enumeration::ownedOperation";

		public static String ownedLiteral = "UML::Enumeration::ownedLiteral";

		public static String useCase = "UML::Enumeration::useCase";

		public static String ownedUseCase = "UML::Enumeration::ownedUseCase";

		public static String collaborationUse = "UML::Enumeration::collaborationUse";

		public static String substitution = "UML::Enumeration::substitution";

		public static String redefinedClassifier = "UML::Enumeration::redefinedClassifier";



	}

	/**
	 * PackageMerge view descriptor
	 */
	public static class PackageMerge {

	}

	/**
	 * Usage view descriptor
	 */
	public static class Usage {

		public static String name = "UML::Usage::name";

		public static String visibility = "UML::Usage::visibility";

		public static String client = "UML::Usage::client";

		public static String supplier = "UML::Usage::supplier";



	}

	/**
	 * Expression view descriptor
	 */
	public static class Expression {

		public static String ownedComment = "UML::Expression::ownedComment";

		public static String name = "UML::Expression::name";

		public static String visibility = "UML::Expression::visibility";

		public static String clientDependency = "UML::Expression::clientDependency";

		public static String symbol = "UML::Expression::symbol";

		public static String operand = "UML::Expression::operand";


	}

	/**
	 * DataType view descriptor
	 */
	public static class DataType {

		public static String name = "UML::DataType::name";

		public static String visibility = "UML::DataType::visibility";

		public static String isAbstract = "UML::DataType::isAbstract";

		public static String isLeaf = "UML::DataType::isLeaf";


		public static String ownedAttribute = "UML::DataType::ownedAttribute";

		public static String ownedOperation = "UML::DataType::ownedOperation";



		public static String useCase = "UML::DataType::useCase";

		public static String ownedUseCase = "UML::DataType::ownedUseCase";

		public static String collaborationUse = "UML::DataType::collaborationUse";

		public static String redefinedClassifier = "UML::DataType::redefinedClassifier";

		public static String substitution = "UML::DataType::substitution";

		public static String powertypeExtent = "UML::DataType::powertypeExtent";

		public static String generalization = "UML::DataType::generalization";

		public static String templateBinding = "UML::DataType::templateBinding";

		public static String ownedRule = "UML::DataType::ownedRule";

		public static String elementImport = "UML::DataType::elementImport";

		public static String packageImport = "UML::DataType::packageImport";



	}

	/**
	 * InterfaceRealization view descriptor
	 */
	public static class InterfaceRealization {

		public static String name = "UML::InterfaceRealization::name";

		public static String visibility = "UML::InterfaceRealization::visibility";

		public static String client = "UML::InterfaceRealization::client";

		public static String supplier = "UML::InterfaceRealization::supplier";



	}

	/**
	 * Operation view descriptor
	 */
	public static class Operation {

		public static String name = "UML::Operation::name";

		public static String visibility = "UML::Operation::visibility";

		public static String concurrency = "UML::Operation::concurrency";

		public static String isAbstract = "UML::Operation::isAbstract";

		public static String isStatic = "UML::Operation::isStatic";

		public static String isLeaf = "UML::Operation::isLeaf";

		public static String isQuery = "UML::Operation::isQuery";


		public static String ownedParameter = "UML::Operation::ownedParameter";

		public static String raisedException = "UML::Operation::raisedException";



		public static String method = "UML::Operation::method";

		public static String templateBinding = "UML::Operation::templateBinding";

		public static String ownedParameterSet = "UML::Operation::ownedParameterSet";

		public static String precondition = "UML::Operation::precondition";

		public static String postcondition = "UML::Operation::postcondition";

		public static String redefinedOperation = "UML::Operation::redefinedOperation";

		public static String ownedRule = "UML::Operation::ownedRule";

		public static String packageImport = "UML::Operation::packageImport";

		public static String elementImport = "UML::Operation::elementImport";



	}

	/**
	 * Property view descriptor
	 */
	public static class Property {

		public static String name = "UML::Property::name";

		public static String visibility = "UML::Property::visibility";

		public static String aggregation = "UML::Property::aggregation";

		public static String type = "UML::Property::type";

		public static String isOrdered = "UML::Property::isOrdered";

		public static String isUnique = "UML::Property::isUnique";

		public static String isStatic = "UML::Property::isStatic";

		public static String isReadOnly = "UML::Property::isReadOnly";

		public static String isLeaf = "UML::Property::isLeaf";

		public static String isDerived = "UML::Property::isDerived";

		public static String isDerivedUnion = "UML::Property::isDerivedUnion";


		public static String lower = "UML::Property::lower";

		public static String upper = "UML::Property::upper";



		public static String qualifier = "UML::Property::qualifier";

		public static String deployment = "UML::Property::deployment";


		public static String redefinedProperty = "UML::Property::redefinedProperty";

		public static String subsettedProperty = "UML::Property::subsettedProperty";



	}

	/**
	 * Parameter view descriptor
	 */
	public static class Parameter {

		public static String name = "UML::Parameter::name";

		public static String visibility = "UML::Parameter::visibility";

		public static String type = "UML::Parameter::type";

		public static String direction = "UML::Parameter::direction";

		public static String effect = "UML::Parameter::effect";

		public static String isOrdered = "UML::Parameter::isOrdered";

		public static String isUnique = "UML::Parameter::isUnique";

		public static String isException = "UML::Parameter::isException";

		public static String isStream = "UML::Parameter::isStream";


		public static String lower = "UML::Parameter::lower";

		public static String upper = "UML::Parameter::upper";


		public static String parameterSet = "UML::Parameter::parameterSet";


	}

	/**
	 * OpaqueExpression view descriptor
	 */
	public static class OpaqueExpression {

		public static String ownedComment = "UML::OpaqueExpression::ownedComment";

		public static String name = "UML::OpaqueExpression::name";

		public static String visibility = "UML::OpaqueExpression::visibility";

		public static String clientDependency = "UML::OpaqueExpression::clientDependency";

		public static String body = "UML::OpaqueExpression::body";

		public static String language = "UML::OpaqueExpression::language";


	}

	/**
	 * Abstraction view descriptor
	 */
	public static class Abstraction {

		public static String name = "UML::Abstraction::name";

		public static String visibility = "UML::Abstraction::visibility";

		public static String client = "UML::Abstraction::client";

		public static String supplier = "UML::Abstraction::supplier";



	}

	/**
	 * Realization view descriptor
	 */
	public static class Realization {

		public static String name = "UML::Realization::name";

		public static String visibility = "UML::Realization::visibility";

		public static String client = "UML::Realization::client";

		public static String supplier = "UML::Realization::supplier";



	}

	/**
	 * Substitution view descriptor
	 */
	public static class Substitution {

		public static String name = "UML::Substitution::name";

		public static String visibility = "UML::Substitution::visibility";

		public static String client = "UML::Substitution::client";

		public static String supplier = "UML::Substitution::supplier";



	}

	/**
	 * GeneralizationSet view descriptor
	 */
	public static class GeneralizationSet {

		public static String ownedComment = "UML::GeneralizationSet::ownedComment";

		public static String name = "UML::GeneralizationSet::name";

		public static String visibility = "UML::GeneralizationSet::visibility";

		public static String clientDependency = "UML::GeneralizationSet::clientDependency";

		public static String isCovering = "UML::GeneralizationSet::isCovering";

		public static String isDisjoint = "UML::GeneralizationSet::isDisjoint";

		public static String generalization = "UML::GeneralizationSet::generalization";


	}

	/**
	 * Generalization view descriptor
	 */
	public static class Generalization {

		public static String isSubstitutable = "UML::Generalization::isSubstitutable";

		public static String generalizationSet = "UML::Generalization::generalizationSet";


	}

	/**
	 * Association view descriptor
	 */
	public static class Association {

		public static String name = "UML::Association::name";

		public static String visibility = "UML::Association::visibility";

		public static String isDerived = "UML::Association::isDerived";

		public static String isAbstract = "UML::Association::isAbstract";

		public static String isLeaf = "UML::Association::isLeaf";


		public static String ownedEnd = "UML::Association::ownedEnd";

		public static String memberEnd = "UML::Association::memberEnd";

		public static String navigableOwnedEnd = "UML::Association::navigableOwnedEnd";



		public static String templateBinding = "UML::Association::templateBinding";

		public static String useCase = "UML::Association::useCase";

		public static String ownedUseCase = "UML::Association::ownedUseCase";

		public static String collaborationUse = "UML::Association::collaborationUse";

		public static String substitution = "UML::Association::substitution";

		public static String redefinedClassifier = "UML::Association::redefinedClassifier";

		public static String generalization = "UML::Association::generalization";

		public static String powertypeExtent = "UML::Association::powertypeExtent";

		public static String elementImport = "UML::Association::elementImport";

		public static String packageImport = "UML::Association::packageImport";

		public static String ownedRule = "UML::Association::ownedRule";



	}

	/**
	 * Constraint view descriptor
	 */
	public static class Constraint {

		public static String ownedComment = "UML::Constraint::ownedComment";

		public static String name = "UML::Constraint::name";

		public static String visibility = "UML::Constraint::visibility";

		public static String clientDependency = "UML::Constraint::clientDependency";

		public static String constrainedElement = "UML::Constraint::constrainedElement";


	}

	/**
	 * Comment view descriptor
	 */
	public static class Comment {

		public static String body = "UML::Comment::body";

		public static String annotatedElement = "UML::Comment::annotatedElement";


	}

	/**
	 * Package view descriptor
	 */
	public static class Package_ {

		public static String name = "UML::Package::name";

		public static String visibility = "UML::Package::visibility";


		public static String templateBinding = "UML::Package::templateBinding";

		public static String packageImport = "UML::Package::packageImport";

		public static String elementImport = "UML::Package::elementImport";

		public static String packageMerge = "UML::Package::packageMerge";

		public static String packagedElement = "UML::Package::packagedElement";

		public static String ownedRule = "UML::Package::ownedRule";



	}

	/**
	 * PackageImport view descriptor
	 */
	public static class PackageImport {

		public static String visibility = "UML::PackageImport::visibility";


	}

	/**
	 * Dependency view descriptor
	 */
	public static class Dependency {

		public static String name = "UML::Dependency::name";

		public static String visibility = "UML::Dependency::visibility";

		public static String client = "UML::Dependency::client";

		public static String supplier = "UML::Dependency::supplier";



	}

	/**
	 * ElementImport view descriptor
	 */
	public static class ElementImport {

		public static String visibility = "UML::ElementImport::visibility";

		public static String alias = "UML::ElementImport::alias";


	}

	/**
	 * Component view descriptor
	 */
	public static class Component {

		public static String name = "UML::Component::name";

		public static String visibility = "UML::Component::visibility";

		public static String isActive = "UML::Component::isActive";

		public static String isIndirectlyInstantiated = "UML::Component::isIndirectlyInstantiated";

		public static String isAbstract = "UML::Component::isAbstract";

		public static String isLeaf = "UML::Component::isLeaf";



		public static String ownedAttribute = "UML::Component::ownedAttribute";

		public static String ownedOperation = "UML::Component::ownedOperation";

		public static String nestedClassifier = "UML::Component::nestedClassifier";



		public static String realization = "UML::Component::realization";

		public static String interfaceRealization = "UML::Component::interfaceRealization";

		public static String generalization = "UML::Component::generalization";



		public static String elementImport = "UML::Component::elementImport";

		public static String ownedUseCase = "UML::Component::ownedUseCase";

		public static String packagedElement = "UML::Component::packagedElement";

		public static String ownedReception = "UML::Component::ownedReception";

		public static String ownedTrigger = "UML::Component::ownedTrigger";

		public static String ownedBehavior = "UML::Component::ownedBehavior";

		public static String ownedConnector = "UML::Component::ownedConnector";

		public static String collaborationUse = "UML::Component::collaborationUse";

		public static String useCase = "UML::Component::useCase";

		public static String substitution = "UML::Component::substitution";

		public static String powertypeExtent = "UML::Component::powertypeExtent";

		public static String redefinedClassifier = "UML::Component::redefinedClassifier";

		public static String templateBinding = "UML::Component::templateBinding";

		public static String ownedRule = "UML::Component::ownedRule";

		public static String packageImport = "UML::Component::packageImport";



	}

	/**
	 * ComponentRealization view descriptor
	 */
	public static class ComponentRealization {

		public static String ownedComment = "UML::ComponentRealization::ownedComment";

		public static String name = "UML::ComponentRealization::name";

		public static String visibility = "UML::ComponentRealization::visibility";

		public static String clientDependency = "UML::ComponentRealization::clientDependency";

		public static String supplier = "UML::ComponentRealization::supplier";

		public static String client = "UML::ComponentRealization::client";


	}

	/**
	 * Connector view descriptor
	 */
	public static class Connector {

		public static String ownedComment = "UML::Connector::ownedComment";

		public static String name = "UML::Connector::name";

		public static String visibility = "UML::Connector::visibility";

		public static String clientDependency = "UML::Connector::clientDependency";

		public static String isLeaf = "UML::Connector::isLeaf";

		public static String isStatic = "UML::Connector::isStatic";

		public static String redefinedConnector = "UML::Connector::redefinedConnector";

		public static String end = "UML::Connector::end";

		public static String kind = "UML::Connector::kind";

		public static String contract = "UML::Connector::contract";


	}

	/**
	 * Collaboration view descriptor
	 */
	public static class Collaboration {

		public static String ownedComment = "UML::Collaboration::ownedComment";

		public static String name = "UML::Collaboration::name";

		public static String visibility = "UML::Collaboration::visibility";

		public static String clientDependency = "UML::Collaboration::clientDependency";

		public static String elementImport = "UML::Collaboration::elementImport";

		public static String packageImport = "UML::Collaboration::packageImport";

		public static String ownedRule = "UML::Collaboration::ownedRule";

		public static String isLeaf = "UML::Collaboration::isLeaf";

		public static String templateBinding = "UML::Collaboration::templateBinding";

		public static String isAbstract = "UML::Collaboration::isAbstract";

		public static String generalization = "UML::Collaboration::generalization";

		public static String powertypeExtent = "UML::Collaboration::powertypeExtent";

		public static String redefinedClassifier = "UML::Collaboration::redefinedClassifier";

		public static String substitution = "UML::Collaboration::substitution";

		public static String collaborationUse = "UML::Collaboration::collaborationUse";

		public static String ownedUseCase = "UML::Collaboration::ownedUseCase";

		public static String useCase = "UML::Collaboration::useCase";

		public static String ownedBehavior = "UML::Collaboration::ownedBehavior";

		public static String interfaceRealization = "UML::Collaboration::interfaceRealization";

		public static String ownedTrigger = "UML::Collaboration::ownedTrigger";

		public static String ownedAttribute = "UML::Collaboration::ownedAttribute";

		public static String ownedConnector = "UML::Collaboration::ownedConnector";

		public static String collaborationRole = "UML::Collaboration::collaborationRole";


	}

	/**
	 * CollaborationUse view descriptor
	 */
	public static class CollaborationUse {

		public static String ownedComment = "UML::CollaborationUse::ownedComment";

		public static String name = "UML::CollaborationUse::name";

		public static String visibility = "UML::CollaborationUse::visibility";

		public static String clientDependency = "UML::CollaborationUse::clientDependency";

		public static String roleBinding = "UML::CollaborationUse::roleBinding";


	}

	/**
	 * Port view descriptor
	 */
	public static class Port {

		public static String ownedComment = "UML::Port::ownedComment";

		public static String name = "UML::Port::name";

		public static String visibility = "UML::Port::visibility";

		public static String clientDependency = "UML::Port::clientDependency";

		public static String isLeaf = "UML::Port::isLeaf";

		public static String isStatic = "UML::Port::isStatic";

		public static String isOrdered = "UML::Port::isOrdered";

		public static String isUnique = "UML::Port::isUnique";

		public static String isReadOnly = "UML::Port::isReadOnly";

		public static String deployment = "UML::Port::deployment";

		public static String isDerived = "UML::Port::isDerived";

		public static String isDerivedUnion = "UML::Port::isDerivedUnion";

		public static String aggregation = "UML::Port::aggregation";

		public static String redefinedProperty = "UML::Port::redefinedProperty";

		public static String subsettedProperty = "UML::Port::subsettedProperty";

		public static String qualifier = "UML::Port::qualifier";

		public static String isBehavior = "UML::Port::isBehavior";

		public static String isService = "UML::Port::isService";

		public static String redefinedPort = "UML::Port::redefinedPort";


	}

	/**
	 * Trigger view descriptor
	 */
	public static class Trigger {

		public static String ownedComment = "UML::Trigger::ownedComment";

		public static String name = "UML::Trigger::name";

		public static String visibility = "UML::Trigger::visibility";

		public static String clientDependency = "UML::Trigger::clientDependency";

		public static String port = "UML::Trigger::port";


	}

	/**
	 * ConnectorEnd view descriptor
	 */
	public static class ConnectorEnd {

		public static String ownedComment = "UML::ConnectorEnd::ownedComment";

		public static String isOrdered = "UML::ConnectorEnd::isOrdered";

		public static String isUnique = "UML::ConnectorEnd::isUnique";


	}

	/**
	 * ExecutionEnvironment view descriptor
	 */
	public static class ExecutionEnvironment {

		public static String ownedComment = "UML::ExecutionEnvironment::ownedComment";

		public static String name = "UML::ExecutionEnvironment::name";

		public static String visibility = "UML::ExecutionEnvironment::visibility";

		public static String clientDependency = "UML::ExecutionEnvironment::clientDependency";

		public static String elementImport = "UML::ExecutionEnvironment::elementImport";

		public static String packageImport = "UML::ExecutionEnvironment::packageImport";

		public static String ownedRule = "UML::ExecutionEnvironment::ownedRule";

		public static String isLeaf = "UML::ExecutionEnvironment::isLeaf";

		public static String templateBinding = "UML::ExecutionEnvironment::templateBinding";

		public static String isAbstract = "UML::ExecutionEnvironment::isAbstract";

		public static String generalization = "UML::ExecutionEnvironment::generalization";

		public static String powertypeExtent = "UML::ExecutionEnvironment::powertypeExtent";

		public static String redefinedClassifier = "UML::ExecutionEnvironment::redefinedClassifier";

		public static String substitution = "UML::ExecutionEnvironment::substitution";

		public static String collaborationUse = "UML::ExecutionEnvironment::collaborationUse";

		public static String ownedUseCase = "UML::ExecutionEnvironment::ownedUseCase";

		public static String useCase = "UML::ExecutionEnvironment::useCase";

		public static String ownedAttribute = "UML::ExecutionEnvironment::ownedAttribute";

		public static String ownedConnector = "UML::ExecutionEnvironment::ownedConnector";

		public static String ownedBehavior = "UML::ExecutionEnvironment::ownedBehavior";

		public static String interfaceRealization = "UML::ExecutionEnvironment::interfaceRealization";

		public static String ownedTrigger = "UML::ExecutionEnvironment::ownedTrigger";

		public static String nestedClassifier = "UML::ExecutionEnvironment::nestedClassifier";

		public static String ownedOperation = "UML::ExecutionEnvironment::ownedOperation";

		public static String isActive = "UML::ExecutionEnvironment::isActive";

		public static String ownedReception = "UML::ExecutionEnvironment::ownedReception";

		public static String deployment = "UML::ExecutionEnvironment::deployment";

		public static String nestedNode = "UML::ExecutionEnvironment::nestedNode";


	}

	/**
	 * Device view descriptor
	 */
	public static class Device {

		public static String ownedComment = "UML::Device::ownedComment";

		public static String name = "UML::Device::name";

		public static String visibility = "UML::Device::visibility";

		public static String clientDependency = "UML::Device::clientDependency";

		public static String elementImport = "UML::Device::elementImport";

		public static String packageImport = "UML::Device::packageImport";

		public static String ownedRule = "UML::Device::ownedRule";

		public static String isLeaf = "UML::Device::isLeaf";

		public static String templateBinding = "UML::Device::templateBinding";

		public static String isAbstract = "UML::Device::isAbstract";

		public static String generalization = "UML::Device::generalization";

		public static String powertypeExtent = "UML::Device::powertypeExtent";

		public static String redefinedClassifier = "UML::Device::redefinedClassifier";

		public static String substitution = "UML::Device::substitution";

		public static String collaborationUse = "UML::Device::collaborationUse";

		public static String ownedUseCase = "UML::Device::ownedUseCase";

		public static String useCase = "UML::Device::useCase";

		public static String ownedAttribute = "UML::Device::ownedAttribute";

		public static String ownedConnector = "UML::Device::ownedConnector";

		public static String ownedBehavior = "UML::Device::ownedBehavior";

		public static String interfaceRealization = "UML::Device::interfaceRealization";

		public static String ownedTrigger = "UML::Device::ownedTrigger";

		public static String nestedClassifier = "UML::Device::nestedClassifier";

		public static String ownedOperation = "UML::Device::ownedOperation";

		public static String isActive = "UML::Device::isActive";

		public static String ownedReception = "UML::Device::ownedReception";

		public static String deployment = "UML::Device::deployment";

		public static String nestedNode = "UML::Device::nestedNode";


	}

	/**
	 * CommunicationPath view descriptor
	 */
	public static class CommunicationPath {

		public static String ownedComment = "UML::CommunicationPath::ownedComment";

		public static String name = "UML::CommunicationPath::name";

		public static String visibility = "UML::CommunicationPath::visibility";

		public static String clientDependency = "UML::CommunicationPath::clientDependency";

		public static String elementImport = "UML::CommunicationPath::elementImport";

		public static String packageImport = "UML::CommunicationPath::packageImport";

		public static String ownedRule = "UML::CommunicationPath::ownedRule";

		public static String isLeaf = "UML::CommunicationPath::isLeaf";

		public static String templateBinding = "UML::CommunicationPath::templateBinding";

		public static String isAbstract = "UML::CommunicationPath::isAbstract";

		public static String generalization = "UML::CommunicationPath::generalization";

		public static String powertypeExtent = "UML::CommunicationPath::powertypeExtent";

		public static String redefinedClassifier = "UML::CommunicationPath::redefinedClassifier";

		public static String substitution = "UML::CommunicationPath::substitution";

		public static String collaborationUse = "UML::CommunicationPath::collaborationUse";

		public static String ownedUseCase = "UML::CommunicationPath::ownedUseCase";

		public static String useCase = "UML::CommunicationPath::useCase";

		public static String ownedEnd = "UML::CommunicationPath::ownedEnd";

		public static String memberEnd = "UML::CommunicationPath::memberEnd";

		public static String isDerived = "UML::CommunicationPath::isDerived";

		public static String navigableOwnedEnd = "UML::CommunicationPath::navigableOwnedEnd";


	}

	/**
	 * Node view descriptor
	 */
	public static class Node {

		public static String ownedComment = "UML::Node::ownedComment";

		public static String name = "UML::Node::name";

		public static String visibility = "UML::Node::visibility";

		public static String clientDependency = "UML::Node::clientDependency";

		public static String elementImport = "UML::Node::elementImport";

		public static String packageImport = "UML::Node::packageImport";

		public static String ownedRule = "UML::Node::ownedRule";

		public static String isLeaf = "UML::Node::isLeaf";

		public static String templateBinding = "UML::Node::templateBinding";

		public static String isAbstract = "UML::Node::isAbstract";

		public static String generalization = "UML::Node::generalization";

		public static String powertypeExtent = "UML::Node::powertypeExtent";

		public static String redefinedClassifier = "UML::Node::redefinedClassifier";

		public static String substitution = "UML::Node::substitution";

		public static String collaborationUse = "UML::Node::collaborationUse";

		public static String ownedUseCase = "UML::Node::ownedUseCase";

		public static String useCase = "UML::Node::useCase";

		public static String ownedAttribute = "UML::Node::ownedAttribute";

		public static String ownedConnector = "UML::Node::ownedConnector";

		public static String ownedBehavior = "UML::Node::ownedBehavior";

		public static String interfaceRealization = "UML::Node::interfaceRealization";

		public static String ownedTrigger = "UML::Node::ownedTrigger";

		public static String nestedClassifier = "UML::Node::nestedClassifier";

		public static String ownedOperation = "UML::Node::ownedOperation";

		public static String isActive = "UML::Node::isActive";

		public static String ownedReception = "UML::Node::ownedReception";

		public static String deployment = "UML::Node::deployment";

		public static String nestedNode = "UML::Node::nestedNode";


	}

	/**
	 * Manifestation view descriptor
	 */
	public static class Manifestation {

		public static String ownedComment = "UML::Manifestation::ownedComment";

		public static String name = "UML::Manifestation::name";

		public static String visibility = "UML::Manifestation::visibility";

		public static String clientDependency = "UML::Manifestation::clientDependency";

		public static String supplier = "UML::Manifestation::supplier";

		public static String client = "UML::Manifestation::client";


	}

	/**
	 * Artifact view descriptor
	 */
	public static class Artifact {

		public static String ownedComment = "UML::Artifact::ownedComment";

		public static String name = "UML::Artifact::name";

		public static String visibility = "UML::Artifact::visibility";

		public static String clientDependency = "UML::Artifact::clientDependency";

		public static String elementImport = "UML::Artifact::elementImport";

		public static String packageImport = "UML::Artifact::packageImport";

		public static String ownedRule = "UML::Artifact::ownedRule";

		public static String isLeaf = "UML::Artifact::isLeaf";

		public static String templateBinding = "UML::Artifact::templateBinding";

		public static String isAbstract = "UML::Artifact::isAbstract";

		public static String generalization = "UML::Artifact::generalization";

		public static String powertypeExtent = "UML::Artifact::powertypeExtent";

		public static String redefinedClassifier = "UML::Artifact::redefinedClassifier";

		public static String substitution = "UML::Artifact::substitution";

		public static String collaborationUse = "UML::Artifact::collaborationUse";

		public static String ownedUseCase = "UML::Artifact::ownedUseCase";

		public static String useCase = "UML::Artifact::useCase";

		public static String fileName = "UML::Artifact::fileName";

		public static String nestedArtifact = "UML::Artifact::nestedArtifact";

		public static String manifestation = "UML::Artifact::manifestation";

		public static String ownedOperation = "UML::Artifact::ownedOperation";

		public static String ownedAttribute = "UML::Artifact::ownedAttribute";


	}

	/**
	 * DeploymentSpecification view descriptor
	 */
	public static class DeploymentSpecification {

		public static String ownedComment = "UML::DeploymentSpecification::ownedComment";

		public static String name = "UML::DeploymentSpecification::name";

		public static String visibility = "UML::DeploymentSpecification::visibility";

		public static String clientDependency = "UML::DeploymentSpecification::clientDependency";

		public static String elementImport = "UML::DeploymentSpecification::elementImport";

		public static String packageImport = "UML::DeploymentSpecification::packageImport";

		public static String ownedRule = "UML::DeploymentSpecification::ownedRule";

		public static String isLeaf = "UML::DeploymentSpecification::isLeaf";

		public static String templateBinding = "UML::DeploymentSpecification::templateBinding";

		public static String isAbstract = "UML::DeploymentSpecification::isAbstract";

		public static String generalization = "UML::DeploymentSpecification::generalization";

		public static String powertypeExtent = "UML::DeploymentSpecification::powertypeExtent";

		public static String redefinedClassifier = "UML::DeploymentSpecification::redefinedClassifier";

		public static String substitution = "UML::DeploymentSpecification::substitution";

		public static String collaborationUse = "UML::DeploymentSpecification::collaborationUse";

		public static String ownedUseCase = "UML::DeploymentSpecification::ownedUseCase";

		public static String useCase = "UML::DeploymentSpecification::useCase";

		public static String fileName = "UML::DeploymentSpecification::fileName";

		public static String nestedArtifact = "UML::DeploymentSpecification::nestedArtifact";

		public static String manifestation = "UML::DeploymentSpecification::manifestation";

		public static String ownedOperation = "UML::DeploymentSpecification::ownedOperation";

		public static String ownedAttribute = "UML::DeploymentSpecification::ownedAttribute";

		public static String deploymentLocation = "UML::DeploymentSpecification::deploymentLocation";

		public static String executionLocation = "UML::DeploymentSpecification::executionLocation";


	}

	/**
	 * Deployment view descriptor
	 */
	public static class Deployment {

		public static String ownedComment = "UML::Deployment::ownedComment";

		public static String name = "UML::Deployment::name";

		public static String visibility = "UML::Deployment::visibility";

		public static String clientDependency = "UML::Deployment::clientDependency";

		public static String supplier = "UML::Deployment::supplier";

		public static String client = "UML::Deployment::client";

		public static String deployedArtifact = "UML::Deployment::deployedArtifact";

		public static String configuration = "UML::Deployment::configuration";


	}

	/**
	 * ReduceAction view descriptor
	 */
	public static class ReduceAction {

		public static String ownedComment = "UML::ReduceAction::ownedComment";

		public static String name = "UML::ReduceAction::name";

		public static String visibility = "UML::ReduceAction::visibility";

		public static String clientDependency = "UML::ReduceAction::clientDependency";

		public static String isLeaf = "UML::ReduceAction::isLeaf";

		public static String outgoing = "UML::ReduceAction::outgoing";

		public static String incoming = "UML::ReduceAction::incoming";

		public static String inPartition = "UML::ReduceAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReduceAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReduceAction::redefinedNode";

		public static String handler = "UML::ReduceAction::handler";

		public static String localPrecondition = "UML::ReduceAction::localPrecondition";

		public static String localPostcondition = "UML::ReduceAction::localPostcondition";

		public static String isOrdered = "UML::ReduceAction::isOrdered";


	}

	/**
	 * ReplyAction view descriptor
	 */
	public static class ReplyAction {

		public static String ownedComment = "UML::ReplyAction::ownedComment";

		public static String name = "UML::ReplyAction::name";

		public static String visibility = "UML::ReplyAction::visibility";

		public static String clientDependency = "UML::ReplyAction::clientDependency";

		public static String isLeaf = "UML::ReplyAction::isLeaf";

		public static String outgoing = "UML::ReplyAction::outgoing";

		public static String incoming = "UML::ReplyAction::incoming";

		public static String inPartition = "UML::ReplyAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReplyAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReplyAction::redefinedNode";

		public static String handler = "UML::ReplyAction::handler";

		public static String localPrecondition = "UML::ReplyAction::localPrecondition";

		public static String localPostcondition = "UML::ReplyAction::localPostcondition";

		public static String replyValue = "UML::ReplyAction::replyValue";


	}

	/**
	 * AcceptCallAction view descriptor
	 */
	public static class AcceptCallAction {

		public static String ownedComment = "UML::AcceptCallAction::ownedComment";

		public static String name = "UML::AcceptCallAction::name";

		public static String visibility = "UML::AcceptCallAction::visibility";

		public static String clientDependency = "UML::AcceptCallAction::clientDependency";

		public static String isLeaf = "UML::AcceptCallAction::isLeaf";

		public static String outgoing = "UML::AcceptCallAction::outgoing";

		public static String incoming = "UML::AcceptCallAction::incoming";

		public static String inPartition = "UML::AcceptCallAction::inPartition";

		public static String inInterruptibleRegion = "UML::AcceptCallAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::AcceptCallAction::redefinedNode";

		public static String handler = "UML::AcceptCallAction::handler";

		public static String localPrecondition = "UML::AcceptCallAction::localPrecondition";

		public static String localPostcondition = "UML::AcceptCallAction::localPostcondition";

		public static String isUnmarshall = "UML::AcceptCallAction::isUnmarshall";

		public static String result = "UML::AcceptCallAction::result";

		public static String trigger = "UML::AcceptCallAction::trigger";


	}

	/**
	 * AcceptEventAction view descriptor
	 */
	public static class AcceptEventAction {

		public static String ownedComment = "UML::AcceptEventAction::ownedComment";

		public static String name = "UML::AcceptEventAction::name";

		public static String visibility = "UML::AcceptEventAction::visibility";

		public static String clientDependency = "UML::AcceptEventAction::clientDependency";

		public static String isLeaf = "UML::AcceptEventAction::isLeaf";

		public static String outgoing = "UML::AcceptEventAction::outgoing";

		public static String incoming = "UML::AcceptEventAction::incoming";

		public static String inPartition = "UML::AcceptEventAction::inPartition";

		public static String inInterruptibleRegion = "UML::AcceptEventAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::AcceptEventAction::redefinedNode";

		public static String handler = "UML::AcceptEventAction::handler";

		public static String localPrecondition = "UML::AcceptEventAction::localPrecondition";

		public static String localPostcondition = "UML::AcceptEventAction::localPostcondition";

		public static String isUnmarshall = "UML::AcceptEventAction::isUnmarshall";

		public static String result = "UML::AcceptEventAction::result";

		public static String trigger = "UML::AcceptEventAction::trigger";


	}

	/**
	 * CreateLinkObjectAction view descriptor
	 */
	public static class CreateLinkObjectAction {

		public static String ownedComment = "UML::CreateLinkObjectAction::ownedComment";

		public static String name = "UML::CreateLinkObjectAction::name";

		public static String visibility = "UML::CreateLinkObjectAction::visibility";

		public static String clientDependency = "UML::CreateLinkObjectAction::clientDependency";

		public static String isLeaf = "UML::CreateLinkObjectAction::isLeaf";

		public static String outgoing = "UML::CreateLinkObjectAction::outgoing";

		public static String incoming = "UML::CreateLinkObjectAction::incoming";

		public static String inPartition = "UML::CreateLinkObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::CreateLinkObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::CreateLinkObjectAction::redefinedNode";

		public static String handler = "UML::CreateLinkObjectAction::handler";

		public static String localPrecondition = "UML::CreateLinkObjectAction::localPrecondition";

		public static String localPostcondition = "UML::CreateLinkObjectAction::localPostcondition";

		public static String endData = "UML::CreateLinkObjectAction::endData";

		public static String inputValue = "UML::CreateLinkObjectAction::inputValue";


	}

	/**
	 * ReadLinkObjectEndQualifierAction view descriptor
	 */
	public static class ReadLinkObjectEndQualifierAction {

		public static String ownedComment = "UML::ReadLinkObjectEndQualifierAction::ownedComment";

		public static String name = "UML::ReadLinkObjectEndQualifierAction::name";

		public static String visibility = "UML::ReadLinkObjectEndQualifierAction::visibility";

		public static String clientDependency = "UML::ReadLinkObjectEndQualifierAction::clientDependency";

		public static String isLeaf = "UML::ReadLinkObjectEndQualifierAction::isLeaf";

		public static String outgoing = "UML::ReadLinkObjectEndQualifierAction::outgoing";

		public static String incoming = "UML::ReadLinkObjectEndQualifierAction::incoming";

		public static String inPartition = "UML::ReadLinkObjectEndQualifierAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadLinkObjectEndQualifierAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadLinkObjectEndQualifierAction::redefinedNode";

		public static String handler = "UML::ReadLinkObjectEndQualifierAction::handler";

		public static String localPrecondition = "UML::ReadLinkObjectEndQualifierAction::localPrecondition";

		public static String localPostcondition = "UML::ReadLinkObjectEndQualifierAction::localPostcondition";


	}

	/**
	 * ReadLinkObjectEndAction view descriptor
	 */
	public static class ReadLinkObjectEndAction {

		public static String ownedComment = "UML::ReadLinkObjectEndAction::ownedComment";

		public static String name = "UML::ReadLinkObjectEndAction::name";

		public static String visibility = "UML::ReadLinkObjectEndAction::visibility";

		public static String clientDependency = "UML::ReadLinkObjectEndAction::clientDependency";

		public static String isLeaf = "UML::ReadLinkObjectEndAction::isLeaf";

		public static String outgoing = "UML::ReadLinkObjectEndAction::outgoing";

		public static String incoming = "UML::ReadLinkObjectEndAction::incoming";

		public static String inPartition = "UML::ReadLinkObjectEndAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadLinkObjectEndAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadLinkObjectEndAction::redefinedNode";

		public static String handler = "UML::ReadLinkObjectEndAction::handler";

		public static String localPrecondition = "UML::ReadLinkObjectEndAction::localPrecondition";

		public static String localPostcondition = "UML::ReadLinkObjectEndAction::localPostcondition";


	}

	/**
	 * StartClassifierBehaviorAction view descriptor
	 */
	public static class StartClassifierBehaviorAction {

		public static String ownedComment = "UML::StartClassifierBehaviorAction::ownedComment";

		public static String name = "UML::StartClassifierBehaviorAction::name";

		public static String visibility = "UML::StartClassifierBehaviorAction::visibility";

		public static String clientDependency = "UML::StartClassifierBehaviorAction::clientDependency";

		public static String isLeaf = "UML::StartClassifierBehaviorAction::isLeaf";

		public static String outgoing = "UML::StartClassifierBehaviorAction::outgoing";

		public static String incoming = "UML::StartClassifierBehaviorAction::incoming";

		public static String inPartition = "UML::StartClassifierBehaviorAction::inPartition";

		public static String inInterruptibleRegion = "UML::StartClassifierBehaviorAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::StartClassifierBehaviorAction::redefinedNode";

		public static String handler = "UML::StartClassifierBehaviorAction::handler";

		public static String localPrecondition = "UML::StartClassifierBehaviorAction::localPrecondition";

		public static String localPostcondition = "UML::StartClassifierBehaviorAction::localPostcondition";


	}

	/**
	 * ReadIsClassifiedObjectAction view descriptor
	 */
	public static class ReadIsClassifiedObjectAction {

		public static String ownedComment = "UML::ReadIsClassifiedObjectAction::ownedComment";

		public static String name = "UML::ReadIsClassifiedObjectAction::name";

		public static String visibility = "UML::ReadIsClassifiedObjectAction::visibility";

		public static String clientDependency = "UML::ReadIsClassifiedObjectAction::clientDependency";

		public static String isLeaf = "UML::ReadIsClassifiedObjectAction::isLeaf";

		public static String outgoing = "UML::ReadIsClassifiedObjectAction::outgoing";

		public static String incoming = "UML::ReadIsClassifiedObjectAction::incoming";

		public static String inPartition = "UML::ReadIsClassifiedObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadIsClassifiedObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadIsClassifiedObjectAction::redefinedNode";

		public static String handler = "UML::ReadIsClassifiedObjectAction::handler";

		public static String localPrecondition = "UML::ReadIsClassifiedObjectAction::localPrecondition";

		public static String localPostcondition = "UML::ReadIsClassifiedObjectAction::localPostcondition";

		public static String isDirect = "UML::ReadIsClassifiedObjectAction::isDirect";


	}

	/**
	 * ReclassifyObjectAction view descriptor
	 */
	public static class ReclassifyObjectAction {

		public static String ownedComment = "UML::ReclassifyObjectAction::ownedComment";

		public static String name = "UML::ReclassifyObjectAction::name";

		public static String visibility = "UML::ReclassifyObjectAction::visibility";

		public static String clientDependency = "UML::ReclassifyObjectAction::clientDependency";

		public static String isLeaf = "UML::ReclassifyObjectAction::isLeaf";

		public static String outgoing = "UML::ReclassifyObjectAction::outgoing";

		public static String incoming = "UML::ReclassifyObjectAction::incoming";

		public static String inPartition = "UML::ReclassifyObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReclassifyObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReclassifyObjectAction::redefinedNode";

		public static String handler = "UML::ReclassifyObjectAction::handler";

		public static String localPrecondition = "UML::ReclassifyObjectAction::localPrecondition";

		public static String localPostcondition = "UML::ReclassifyObjectAction::localPostcondition";

		public static String isReplaceAll = "UML::ReclassifyObjectAction::isReplaceAll";

		public static String oldClassifier = "UML::ReclassifyObjectAction::oldClassifier";

		public static String newClassifier = "UML::ReclassifyObjectAction::newClassifier";


	}

	/**
	 * ReadExtentAction view descriptor
	 */
	public static class ReadExtentAction {

		public static String ownedComment = "UML::ReadExtentAction::ownedComment";

		public static String name = "UML::ReadExtentAction::name";

		public static String visibility = "UML::ReadExtentAction::visibility";

		public static String clientDependency = "UML::ReadExtentAction::clientDependency";

		public static String isLeaf = "UML::ReadExtentAction::isLeaf";

		public static String outgoing = "UML::ReadExtentAction::outgoing";

		public static String incoming = "UML::ReadExtentAction::incoming";

		public static String inPartition = "UML::ReadExtentAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadExtentAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadExtentAction::redefinedNode";

		public static String handler = "UML::ReadExtentAction::handler";

		public static String localPrecondition = "UML::ReadExtentAction::localPrecondition";

		public static String localPostcondition = "UML::ReadExtentAction::localPostcondition";


	}

	/**
	 * RaiseExceptionAction view descriptor
	 */
	public static class RaiseExceptionAction {

		public static String ownedComment = "UML::RaiseExceptionAction::ownedComment";

		public static String name = "UML::RaiseExceptionAction::name";

		public static String visibility = "UML::RaiseExceptionAction::visibility";

		public static String clientDependency = "UML::RaiseExceptionAction::clientDependency";

		public static String isLeaf = "UML::RaiseExceptionAction::isLeaf";

		public static String outgoing = "UML::RaiseExceptionAction::outgoing";

		public static String incoming = "UML::RaiseExceptionAction::incoming";

		public static String inPartition = "UML::RaiseExceptionAction::inPartition";

		public static String inInterruptibleRegion = "UML::RaiseExceptionAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::RaiseExceptionAction::redefinedNode";

		public static String handler = "UML::RaiseExceptionAction::handler";

		public static String localPrecondition = "UML::RaiseExceptionAction::localPrecondition";

		public static String localPostcondition = "UML::RaiseExceptionAction::localPostcondition";


	}

	/**
	 * RemoveVariableValueAction view descriptor
	 */
	public static class RemoveVariableValueAction {

		public static String ownedComment = "UML::RemoveVariableValueAction::ownedComment";

		public static String name = "UML::RemoveVariableValueAction::name";

		public static String visibility = "UML::RemoveVariableValueAction::visibility";

		public static String clientDependency = "UML::RemoveVariableValueAction::clientDependency";

		public static String isLeaf = "UML::RemoveVariableValueAction::isLeaf";

		public static String outgoing = "UML::RemoveVariableValueAction::outgoing";

		public static String incoming = "UML::RemoveVariableValueAction::incoming";

		public static String inPartition = "UML::RemoveVariableValueAction::inPartition";

		public static String inInterruptibleRegion = "UML::RemoveVariableValueAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::RemoveVariableValueAction::redefinedNode";

		public static String handler = "UML::RemoveVariableValueAction::handler";

		public static String localPrecondition = "UML::RemoveVariableValueAction::localPrecondition";

		public static String localPostcondition = "UML::RemoveVariableValueAction::localPostcondition";

		public static String isRemoveDuplicates = "UML::RemoveVariableValueAction::isRemoveDuplicates";


	}

	/**
	 * ClearVariableAction view descriptor
	 */
	public static class ClearVariableAction {

		public static String ownedComment = "UML::ClearVariableAction::ownedComment";

		public static String name = "UML::ClearVariableAction::name";

		public static String visibility = "UML::ClearVariableAction::visibility";

		public static String clientDependency = "UML::ClearVariableAction::clientDependency";

		public static String isLeaf = "UML::ClearVariableAction::isLeaf";

		public static String outgoing = "UML::ClearVariableAction::outgoing";

		public static String incoming = "UML::ClearVariableAction::incoming";

		public static String inPartition = "UML::ClearVariableAction::inPartition";

		public static String inInterruptibleRegion = "UML::ClearVariableAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ClearVariableAction::redefinedNode";

		public static String handler = "UML::ClearVariableAction::handler";

		public static String localPrecondition = "UML::ClearVariableAction::localPrecondition";

		public static String localPostcondition = "UML::ClearVariableAction::localPostcondition";


	}

	/**
	 * AddVariableValueAction view descriptor
	 */
	public static class AddVariableValueAction {

		public static String ownedComment = "UML::AddVariableValueAction::ownedComment";

		public static String name = "UML::AddVariableValueAction::name";

		public static String visibility = "UML::AddVariableValueAction::visibility";

		public static String clientDependency = "UML::AddVariableValueAction::clientDependency";

		public static String isLeaf = "UML::AddVariableValueAction::isLeaf";

		public static String outgoing = "UML::AddVariableValueAction::outgoing";

		public static String incoming = "UML::AddVariableValueAction::incoming";

		public static String inPartition = "UML::AddVariableValueAction::inPartition";

		public static String inInterruptibleRegion = "UML::AddVariableValueAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::AddVariableValueAction::redefinedNode";

		public static String handler = "UML::AddVariableValueAction::handler";

		public static String localPrecondition = "UML::AddVariableValueAction::localPrecondition";

		public static String localPostcondition = "UML::AddVariableValueAction::localPostcondition";

		public static String isReplaceAll = "UML::AddVariableValueAction::isReplaceAll";


	}

	/**
	 * ReadVariableAction view descriptor
	 */
	public static class ReadVariableAction {

		public static String ownedComment = "UML::ReadVariableAction::ownedComment";

		public static String name = "UML::ReadVariableAction::name";

		public static String visibility = "UML::ReadVariableAction::visibility";

		public static String clientDependency = "UML::ReadVariableAction::clientDependency";

		public static String isLeaf = "UML::ReadVariableAction::isLeaf";

		public static String outgoing = "UML::ReadVariableAction::outgoing";

		public static String incoming = "UML::ReadVariableAction::incoming";

		public static String inPartition = "UML::ReadVariableAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadVariableAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadVariableAction::redefinedNode";

		public static String handler = "UML::ReadVariableAction::handler";

		public static String localPrecondition = "UML::ReadVariableAction::localPrecondition";

		public static String localPostcondition = "UML::ReadVariableAction::localPostcondition";


	}

	/**
	 * ValueSpecificationAction view descriptor
	 */
	public static class ValueSpecificationAction {

		public static String ownedComment = "UML::ValueSpecificationAction::ownedComment";

		public static String name = "UML::ValueSpecificationAction::name";

		public static String visibility = "UML::ValueSpecificationAction::visibility";

		public static String clientDependency = "UML::ValueSpecificationAction::clientDependency";

		public static String isLeaf = "UML::ValueSpecificationAction::isLeaf";

		public static String outgoing = "UML::ValueSpecificationAction::outgoing";

		public static String incoming = "UML::ValueSpecificationAction::incoming";

		public static String inPartition = "UML::ValueSpecificationAction::inPartition";

		public static String inInterruptibleRegion = "UML::ValueSpecificationAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ValueSpecificationAction::redefinedNode";

		public static String handler = "UML::ValueSpecificationAction::handler";

		public static String localPrecondition = "UML::ValueSpecificationAction::localPrecondition";

		public static String localPostcondition = "UML::ValueSpecificationAction::localPostcondition";


	}

	/**
	 * SendObjectAction view descriptor
	 */
	public static class SendObjectAction {

		public static String ownedComment = "UML::SendObjectAction::ownedComment";

		public static String name = "UML::SendObjectAction::name";

		public static String visibility = "UML::SendObjectAction::visibility";

		public static String clientDependency = "UML::SendObjectAction::clientDependency";

		public static String isLeaf = "UML::SendObjectAction::isLeaf";

		public static String outgoing = "UML::SendObjectAction::outgoing";

		public static String incoming = "UML::SendObjectAction::incoming";

		public static String inPartition = "UML::SendObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::SendObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::SendObjectAction::redefinedNode";

		public static String handler = "UML::SendObjectAction::handler";

		public static String localPrecondition = "UML::SendObjectAction::localPrecondition";

		public static String localPostcondition = "UML::SendObjectAction::localPostcondition";

		public static String argument = "UML::SendObjectAction::argument";


	}

	/**
	 * BroadcastSignalAction view descriptor
	 */
	public static class BroadcastSignalAction {

		public static String ownedComment = "UML::BroadcastSignalAction::ownedComment";

		public static String name = "UML::BroadcastSignalAction::name";

		public static String visibility = "UML::BroadcastSignalAction::visibility";

		public static String clientDependency = "UML::BroadcastSignalAction::clientDependency";

		public static String isLeaf = "UML::BroadcastSignalAction::isLeaf";

		public static String outgoing = "UML::BroadcastSignalAction::outgoing";

		public static String incoming = "UML::BroadcastSignalAction::incoming";

		public static String inPartition = "UML::BroadcastSignalAction::inPartition";

		public static String inInterruptibleRegion = "UML::BroadcastSignalAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::BroadcastSignalAction::redefinedNode";

		public static String handler = "UML::BroadcastSignalAction::handler";

		public static String localPrecondition = "UML::BroadcastSignalAction::localPrecondition";

		public static String localPostcondition = "UML::BroadcastSignalAction::localPostcondition";

		public static String argument = "UML::BroadcastSignalAction::argument";


	}

	/**
	 * ClearAssociationAction view descriptor
	 */
	public static class ClearAssociationAction {

		public static String ownedComment = "UML::ClearAssociationAction::ownedComment";

		public static String name = "UML::ClearAssociationAction::name";

		public static String visibility = "UML::ClearAssociationAction::visibility";

		public static String clientDependency = "UML::ClearAssociationAction::clientDependency";

		public static String isLeaf = "UML::ClearAssociationAction::isLeaf";

		public static String outgoing = "UML::ClearAssociationAction::outgoing";

		public static String incoming = "UML::ClearAssociationAction::incoming";

		public static String inPartition = "UML::ClearAssociationAction::inPartition";

		public static String inInterruptibleRegion = "UML::ClearAssociationAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ClearAssociationAction::redefinedNode";

		public static String handler = "UML::ClearAssociationAction::handler";

		public static String localPrecondition = "UML::ClearAssociationAction::localPrecondition";

		public static String localPostcondition = "UML::ClearAssociationAction::localPostcondition";


	}

	/**
	 * LinkEndDestructionData view descriptor
	 */
	public static class LinkEndDestructionData {

		public static String ownedComment = "UML::LinkEndDestructionData::ownedComment";

		public static String qualifier = "UML::LinkEndDestructionData::qualifier";

		public static String isDestroyDuplicates = "UML::LinkEndDestructionData::isDestroyDuplicates";


	}

	/**
	 * DestroyLinkAction view descriptor
	 */
	public static class DestroyLinkAction {

		public static String ownedComment = "UML::DestroyLinkAction::ownedComment";

		public static String name = "UML::DestroyLinkAction::name";

		public static String visibility = "UML::DestroyLinkAction::visibility";

		public static String clientDependency = "UML::DestroyLinkAction::clientDependency";

		public static String isLeaf = "UML::DestroyLinkAction::isLeaf";

		public static String outgoing = "UML::DestroyLinkAction::outgoing";

		public static String incoming = "UML::DestroyLinkAction::incoming";

		public static String inPartition = "UML::DestroyLinkAction::inPartition";

		public static String inInterruptibleRegion = "UML::DestroyLinkAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::DestroyLinkAction::redefinedNode";

		public static String handler = "UML::DestroyLinkAction::handler";

		public static String localPrecondition = "UML::DestroyLinkAction::localPrecondition";

		public static String localPostcondition = "UML::DestroyLinkAction::localPostcondition";

		public static String endData = "UML::DestroyLinkAction::endData";

		public static String inputValue = "UML::DestroyLinkAction::inputValue";


	}

	/**
	 * CreateLinkAction view descriptor
	 */
	public static class CreateLinkAction {

		public static String ownedComment = "UML::CreateLinkAction::ownedComment";

		public static String name = "UML::CreateLinkAction::name";

		public static String visibility = "UML::CreateLinkAction::visibility";

		public static String clientDependency = "UML::CreateLinkAction::clientDependency";

		public static String isLeaf = "UML::CreateLinkAction::isLeaf";

		public static String outgoing = "UML::CreateLinkAction::outgoing";

		public static String incoming = "UML::CreateLinkAction::incoming";

		public static String inPartition = "UML::CreateLinkAction::inPartition";

		public static String inInterruptibleRegion = "UML::CreateLinkAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::CreateLinkAction::redefinedNode";

		public static String handler = "UML::CreateLinkAction::handler";

		public static String localPrecondition = "UML::CreateLinkAction::localPrecondition";

		public static String localPostcondition = "UML::CreateLinkAction::localPostcondition";

		public static String endData = "UML::CreateLinkAction::endData";

		public static String inputValue = "UML::CreateLinkAction::inputValue";


	}

	/**
	 * ReadLinkAction view descriptor
	 */
	public static class ReadLinkAction {

		public static String ownedComment = "UML::ReadLinkAction::ownedComment";

		public static String name = "UML::ReadLinkAction::name";

		public static String visibility = "UML::ReadLinkAction::visibility";

		public static String clientDependency = "UML::ReadLinkAction::clientDependency";

		public static String isLeaf = "UML::ReadLinkAction::isLeaf";

		public static String outgoing = "UML::ReadLinkAction::outgoing";

		public static String incoming = "UML::ReadLinkAction::incoming";

		public static String inPartition = "UML::ReadLinkAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadLinkAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadLinkAction::redefinedNode";

		public static String handler = "UML::ReadLinkAction::handler";

		public static String localPrecondition = "UML::ReadLinkAction::localPrecondition";

		public static String localPostcondition = "UML::ReadLinkAction::localPostcondition";

		public static String endData = "UML::ReadLinkAction::endData";

		public static String inputValue = "UML::ReadLinkAction::inputValue";


	}

	/**
	 * LinkEndCreationData view descriptor
	 */
	public static class LinkEndCreationData {

		public static String ownedComment = "UML::LinkEndCreationData::ownedComment";

		public static String qualifier = "UML::LinkEndCreationData::qualifier";

		public static String isReplaceAll = "UML::LinkEndCreationData::isReplaceAll";


	}

	/**
	 * AddStructuralFeatureValueAction view descriptor
	 */
	public static class AddStructuralFeatureValueAction {

		public static String ownedComment = "UML::AddStructuralFeatureValueAction::ownedComment";

		public static String name = "UML::AddStructuralFeatureValueAction::name";

		public static String visibility = "UML::AddStructuralFeatureValueAction::visibility";

		public static String clientDependency = "UML::AddStructuralFeatureValueAction::clientDependency";

		public static String isLeaf = "UML::AddStructuralFeatureValueAction::isLeaf";

		public static String outgoing = "UML::AddStructuralFeatureValueAction::outgoing";

		public static String incoming = "UML::AddStructuralFeatureValueAction::incoming";

		public static String inPartition = "UML::AddStructuralFeatureValueAction::inPartition";

		public static String inInterruptibleRegion = "UML::AddStructuralFeatureValueAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::AddStructuralFeatureValueAction::redefinedNode";

		public static String handler = "UML::AddStructuralFeatureValueAction::handler";

		public static String localPrecondition = "UML::AddStructuralFeatureValueAction::localPrecondition";

		public static String localPostcondition = "UML::AddStructuralFeatureValueAction::localPostcondition";

		public static String isReplaceAll = "UML::AddStructuralFeatureValueAction::isReplaceAll";


	}

	/**
	 * RemoveStructuralFeatureValueAction view descriptor
	 */
	public static class RemoveStructuralFeatureValueAction {

		public static String ownedComment = "UML::RemoveStructuralFeatureValueAction::ownedComment";

		public static String name = "UML::RemoveStructuralFeatureValueAction::name";

		public static String visibility = "UML::RemoveStructuralFeatureValueAction::visibility";

		public static String clientDependency = "UML::RemoveStructuralFeatureValueAction::clientDependency";

		public static String isLeaf = "UML::RemoveStructuralFeatureValueAction::isLeaf";

		public static String outgoing = "UML::RemoveStructuralFeatureValueAction::outgoing";

		public static String incoming = "UML::RemoveStructuralFeatureValueAction::incoming";

		public static String inPartition = "UML::RemoveStructuralFeatureValueAction::inPartition";

		public static String inInterruptibleRegion = "UML::RemoveStructuralFeatureValueAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::RemoveStructuralFeatureValueAction::redefinedNode";

		public static String handler = "UML::RemoveStructuralFeatureValueAction::handler";

		public static String localPrecondition = "UML::RemoveStructuralFeatureValueAction::localPrecondition";

		public static String localPostcondition = "UML::RemoveStructuralFeatureValueAction::localPostcondition";

		public static String isRemoveDuplicates = "UML::RemoveStructuralFeatureValueAction::isRemoveDuplicates";


	}

	/**
	 * ClearStructuralFeatureAction view descriptor
	 */
	public static class ClearStructuralFeatureAction {

		public static String ownedComment = "UML::ClearStructuralFeatureAction::ownedComment";

		public static String name = "UML::ClearStructuralFeatureAction::name";

		public static String visibility = "UML::ClearStructuralFeatureAction::visibility";

		public static String clientDependency = "UML::ClearStructuralFeatureAction::clientDependency";

		public static String isLeaf = "UML::ClearStructuralFeatureAction::isLeaf";

		public static String outgoing = "UML::ClearStructuralFeatureAction::outgoing";

		public static String incoming = "UML::ClearStructuralFeatureAction::incoming";

		public static String inPartition = "UML::ClearStructuralFeatureAction::inPartition";

		public static String inInterruptibleRegion = "UML::ClearStructuralFeatureAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ClearStructuralFeatureAction::redefinedNode";

		public static String handler = "UML::ClearStructuralFeatureAction::handler";

		public static String localPrecondition = "UML::ClearStructuralFeatureAction::localPrecondition";

		public static String localPostcondition = "UML::ClearStructuralFeatureAction::localPostcondition";


	}

	/**
	 * ReadStructuralFeatureAction view descriptor
	 */
	public static class ReadStructuralFeatureAction {

		public static String ownedComment = "UML::ReadStructuralFeatureAction::ownedComment";

		public static String name = "UML::ReadStructuralFeatureAction::name";

		public static String visibility = "UML::ReadStructuralFeatureAction::visibility";

		public static String clientDependency = "UML::ReadStructuralFeatureAction::clientDependency";

		public static String isLeaf = "UML::ReadStructuralFeatureAction::isLeaf";

		public static String outgoing = "UML::ReadStructuralFeatureAction::outgoing";

		public static String incoming = "UML::ReadStructuralFeatureAction::incoming";

		public static String inPartition = "UML::ReadStructuralFeatureAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadStructuralFeatureAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadStructuralFeatureAction::redefinedNode";

		public static String handler = "UML::ReadStructuralFeatureAction::handler";

		public static String localPrecondition = "UML::ReadStructuralFeatureAction::localPrecondition";

		public static String localPostcondition = "UML::ReadStructuralFeatureAction::localPostcondition";


	}

	/**
	 * ReadSelfAction view descriptor
	 */
	public static class ReadSelfAction {

		public static String ownedComment = "UML::ReadSelfAction::ownedComment";

		public static String name = "UML::ReadSelfAction::name";

		public static String visibility = "UML::ReadSelfAction::visibility";

		public static String clientDependency = "UML::ReadSelfAction::clientDependency";

		public static String isLeaf = "UML::ReadSelfAction::isLeaf";

		public static String outgoing = "UML::ReadSelfAction::outgoing";

		public static String incoming = "UML::ReadSelfAction::incoming";

		public static String inPartition = "UML::ReadSelfAction::inPartition";

		public static String inInterruptibleRegion = "UML::ReadSelfAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::ReadSelfAction::redefinedNode";

		public static String handler = "UML::ReadSelfAction::handler";

		public static String localPrecondition = "UML::ReadSelfAction::localPrecondition";

		public static String localPostcondition = "UML::ReadSelfAction::localPostcondition";


	}

	/**
	 * TestIdentityAction view descriptor
	 */
	public static class TestIdentityAction {

		public static String ownedComment = "UML::TestIdentityAction::ownedComment";

		public static String name = "UML::TestIdentityAction::name";

		public static String visibility = "UML::TestIdentityAction::visibility";

		public static String clientDependency = "UML::TestIdentityAction::clientDependency";

		public static String isLeaf = "UML::TestIdentityAction::isLeaf";

		public static String outgoing = "UML::TestIdentityAction::outgoing";

		public static String incoming = "UML::TestIdentityAction::incoming";

		public static String inPartition = "UML::TestIdentityAction::inPartition";

		public static String inInterruptibleRegion = "UML::TestIdentityAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::TestIdentityAction::redefinedNode";

		public static String handler = "UML::TestIdentityAction::handler";

		public static String localPrecondition = "UML::TestIdentityAction::localPrecondition";

		public static String localPostcondition = "UML::TestIdentityAction::localPostcondition";


	}

	/**
	 * DestroyObjectAction view descriptor
	 */
	public static class DestroyObjectAction {

		public static String ownedComment = "UML::DestroyObjectAction::ownedComment";

		public static String name = "UML::DestroyObjectAction::name";

		public static String visibility = "UML::DestroyObjectAction::visibility";

		public static String clientDependency = "UML::DestroyObjectAction::clientDependency";

		public static String isLeaf = "UML::DestroyObjectAction::isLeaf";

		public static String outgoing = "UML::DestroyObjectAction::outgoing";

		public static String incoming = "UML::DestroyObjectAction::incoming";

		public static String inPartition = "UML::DestroyObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::DestroyObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::DestroyObjectAction::redefinedNode";

		public static String handler = "UML::DestroyObjectAction::handler";

		public static String localPrecondition = "UML::DestroyObjectAction::localPrecondition";

		public static String localPostcondition = "UML::DestroyObjectAction::localPostcondition";

		public static String isDestroyLinks = "UML::DestroyObjectAction::isDestroyLinks";

		public static String isDestroyOwnedObjects = "UML::DestroyObjectAction::isDestroyOwnedObjects";


	}

	/**
	 * CreateObjectAction view descriptor
	 */
	public static class CreateObjectAction {

		public static String ownedComment = "UML::CreateObjectAction::ownedComment";

		public static String name = "UML::CreateObjectAction::name";

		public static String visibility = "UML::CreateObjectAction::visibility";

		public static String clientDependency = "UML::CreateObjectAction::clientDependency";

		public static String isLeaf = "UML::CreateObjectAction::isLeaf";

		public static String outgoing = "UML::CreateObjectAction::outgoing";

		public static String incoming = "UML::CreateObjectAction::incoming";

		public static String inPartition = "UML::CreateObjectAction::inPartition";

		public static String inInterruptibleRegion = "UML::CreateObjectAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::CreateObjectAction::redefinedNode";

		public static String handler = "UML::CreateObjectAction::handler";

		public static String localPrecondition = "UML::CreateObjectAction::localPrecondition";

		public static String localPostcondition = "UML::CreateObjectAction::localPostcondition";


	}

	/**
	 * QualifierValue view descriptor
	 */
	public static class QualifierValue {

		public static String ownedComment = "UML::QualifierValue::ownedComment";


	}

	/**
	 * LinkEndData view descriptor
	 */
	public static class LinkEndData {

		public static String ownedComment = "UML::LinkEndData::ownedComment";

		public static String qualifier = "UML::LinkEndData::qualifier";


	}

	/**
	 * ValuePin view descriptor
	 */
	public static class ValuePin {

		public static String ownedComment = "UML::ValuePin::ownedComment";

		public static String name = "UML::ValuePin::name";

		public static String visibility = "UML::ValuePin::visibility";

		public static String clientDependency = "UML::ValuePin::clientDependency";

		public static String isLeaf = "UML::ValuePin::isLeaf";

		public static String outgoing = "UML::ValuePin::outgoing";

		public static String incoming = "UML::ValuePin::incoming";

		public static String inPartition = "UML::ValuePin::inPartition";

		public static String inInterruptibleRegion = "UML::ValuePin::inInterruptibleRegion";

		public static String redefinedNode = "UML::ValuePin::redefinedNode";

		public static String ordering = "UML::ValuePin::ordering";

		public static String isControlType = "UML::ValuePin::isControlType";

		public static String inState = "UML::ValuePin::inState";

		public static String isOrdered = "UML::ValuePin::isOrdered";

		public static String isUnique = "UML::ValuePin::isUnique";

		public static String isControl = "UML::ValuePin::isControl";


	}

	/**
	 * OpaqueAction view descriptor
	 */
	public static class OpaqueAction {

		public static String ownedComment = "UML::OpaqueAction::ownedComment";

		public static String name = "UML::OpaqueAction::name";

		public static String visibility = "UML::OpaqueAction::visibility";

		public static String clientDependency = "UML::OpaqueAction::clientDependency";

		public static String isLeaf = "UML::OpaqueAction::isLeaf";

		public static String outgoing = "UML::OpaqueAction::outgoing";

		public static String incoming = "UML::OpaqueAction::incoming";

		public static String inPartition = "UML::OpaqueAction::inPartition";

		public static String inInterruptibleRegion = "UML::OpaqueAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::OpaqueAction::redefinedNode";

		public static String handler = "UML::OpaqueAction::handler";

		public static String localPrecondition = "UML::OpaqueAction::localPrecondition";

		public static String localPostcondition = "UML::OpaqueAction::localPostcondition";

		public static String body = "UML::OpaqueAction::body";

		public static String language = "UML::OpaqueAction::language";

		public static String inputValue = "UML::OpaqueAction::inputValue";

		public static String outputValue = "UML::OpaqueAction::outputValue";


	}

	/**
	 * ExpansionRegion view descriptor
	 */
	public static class ExpansionRegion {

		public static String ownedComment = "UML::ExpansionRegion::ownedComment";

		public static String name = "UML::ExpansionRegion::name";

		public static String visibility = "UML::ExpansionRegion::visibility";

		public static String clientDependency = "UML::ExpansionRegion::clientDependency";

		public static String isLeaf = "UML::ExpansionRegion::isLeaf";

		public static String outgoing = "UML::ExpansionRegion::outgoing";

		public static String incoming = "UML::ExpansionRegion::incoming";

		public static String inPartition = "UML::ExpansionRegion::inPartition";

		public static String inInterruptibleRegion = "UML::ExpansionRegion::inInterruptibleRegion";

		public static String redefinedNode = "UML::ExpansionRegion::redefinedNode";

		public static String handler = "UML::ExpansionRegion::handler";

		public static String localPrecondition = "UML::ExpansionRegion::localPrecondition";

		public static String localPostcondition = "UML::ExpansionRegion::localPostcondition";

		public static String elementImport = "UML::ExpansionRegion::elementImport";

		public static String packageImport = "UML::ExpansionRegion::packageImport";

		public static String ownedRule = "UML::ExpansionRegion::ownedRule";

		public static String variable = "UML::ExpansionRegion::variable";

		public static String edge = "UML::ExpansionRegion::edge";

		public static String mustIsolate = "UML::ExpansionRegion::mustIsolate";

		public static String node = "UML::ExpansionRegion::node";

		public static String mode = "UML::ExpansionRegion::mode";

		public static String inputElement = "UML::ExpansionRegion::inputElement";

		public static String outputElement = "UML::ExpansionRegion::outputElement";


	}

	/**
	 * ExpansionNode view descriptor
	 */
	public static class ExpansionNode {

		public static String ownedComment = "UML::ExpansionNode::ownedComment";

		public static String name = "UML::ExpansionNode::name";

		public static String visibility = "UML::ExpansionNode::visibility";

		public static String clientDependency = "UML::ExpansionNode::clientDependency";

		public static String isLeaf = "UML::ExpansionNode::isLeaf";

		public static String outgoing = "UML::ExpansionNode::outgoing";

		public static String incoming = "UML::ExpansionNode::incoming";

		public static String inPartition = "UML::ExpansionNode::inPartition";

		public static String inInterruptibleRegion = "UML::ExpansionNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::ExpansionNode::redefinedNode";

		public static String ordering = "UML::ExpansionNode::ordering";

		public static String isControlType = "UML::ExpansionNode::isControlType";

		public static String inState = "UML::ExpansionNode::inState";


	}

	/**
	 * Clause view descriptor
	 */
	public static class Clause {

		public static String ownedComment = "UML::Clause::ownedComment";

		public static String test = "UML::Clause::test";

		public static String body = "UML::Clause::body";

		public static String predecessorClause = "UML::Clause::predecessorClause";

		public static String successorClause = "UML::Clause::successorClause";

		public static String bodyOutput = "UML::Clause::bodyOutput";


	}

	/**
	 * LoopNode view descriptor
	 */
	public static class LoopNode {

		public static String ownedComment = "UML::LoopNode::ownedComment";

		public static String name = "UML::LoopNode::name";

		public static String visibility = "UML::LoopNode::visibility";

		public static String clientDependency = "UML::LoopNode::clientDependency";

		public static String isLeaf = "UML::LoopNode::isLeaf";

		public static String outgoing = "UML::LoopNode::outgoing";

		public static String incoming = "UML::LoopNode::incoming";

		public static String inPartition = "UML::LoopNode::inPartition";

		public static String inInterruptibleRegion = "UML::LoopNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::LoopNode::redefinedNode";

		public static String handler = "UML::LoopNode::handler";

		public static String localPrecondition = "UML::LoopNode::localPrecondition";

		public static String localPostcondition = "UML::LoopNode::localPostcondition";

		public static String elementImport = "UML::LoopNode::elementImport";

		public static String packageImport = "UML::LoopNode::packageImport";

		public static String ownedRule = "UML::LoopNode::ownedRule";

		public static String variable = "UML::LoopNode::variable";

		public static String edge = "UML::LoopNode::edge";

		public static String mustIsolate = "UML::LoopNode::mustIsolate";

		public static String node = "UML::LoopNode::node";

		public static String isTestedFirst = "UML::LoopNode::isTestedFirst";

		public static String bodyPart = "UML::LoopNode::bodyPart";

		public static String setupPart = "UML::LoopNode::setupPart";

		public static String test = "UML::LoopNode::test";

		public static String result = "UML::LoopNode::result";

		public static String loopVariable = "UML::LoopNode::loopVariable";

		public static String bodyOutput = "UML::LoopNode::bodyOutput";

		public static String loopVariableInput = "UML::LoopNode::loopVariableInput";


	}

	/**
	 * ConditionalNode view descriptor
	 */
	public static class ConditionalNode {

		public static String ownedComment = "UML::ConditionalNode::ownedComment";

		public static String name = "UML::ConditionalNode::name";

		public static String visibility = "UML::ConditionalNode::visibility";

		public static String clientDependency = "UML::ConditionalNode::clientDependency";

		public static String isLeaf = "UML::ConditionalNode::isLeaf";

		public static String outgoing = "UML::ConditionalNode::outgoing";

		public static String incoming = "UML::ConditionalNode::incoming";

		public static String inPartition = "UML::ConditionalNode::inPartition";

		public static String inInterruptibleRegion = "UML::ConditionalNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::ConditionalNode::redefinedNode";

		public static String handler = "UML::ConditionalNode::handler";

		public static String localPrecondition = "UML::ConditionalNode::localPrecondition";

		public static String localPostcondition = "UML::ConditionalNode::localPostcondition";

		public static String elementImport = "UML::ConditionalNode::elementImport";

		public static String packageImport = "UML::ConditionalNode::packageImport";

		public static String ownedRule = "UML::ConditionalNode::ownedRule";

		public static String variable = "UML::ConditionalNode::variable";

		public static String edge = "UML::ConditionalNode::edge";

		public static String mustIsolate = "UML::ConditionalNode::mustIsolate";

		public static String node = "UML::ConditionalNode::node";

		public static String isDeterminate = "UML::ConditionalNode::isDeterminate";

		public static String isAssured = "UML::ConditionalNode::isAssured";

		public static String clause = "UML::ConditionalNode::clause";

		public static String result = "UML::ConditionalNode::result";


	}

	/**
	 * ObjectFlow view descriptor
	 */
	public static class ObjectFlow {

		public static String ownedComment = "UML::ObjectFlow::ownedComment";

		public static String name = "UML::ObjectFlow::name";

		public static String visibility = "UML::ObjectFlow::visibility";

		public static String clientDependency = "UML::ObjectFlow::clientDependency";

		public static String isLeaf = "UML::ObjectFlow::isLeaf";

		public static String redefinedEdge = "UML::ObjectFlow::redefinedEdge";

		public static String inPartition = "UML::ObjectFlow::inPartition";

		public static String isMulticast = "UML::ObjectFlow::isMulticast";

		public static String isMultireceive = "UML::ObjectFlow::isMultireceive";


	}

	/**
	 * DataStoreNode view descriptor
	 */
	public static class DataStoreNode {

		public static String ownedComment = "UML::DataStoreNode::ownedComment";

		public static String name = "UML::DataStoreNode::name";

		public static String visibility = "UML::DataStoreNode::visibility";

		public static String clientDependency = "UML::DataStoreNode::clientDependency";

		public static String isLeaf = "UML::DataStoreNode::isLeaf";

		public static String outgoing = "UML::DataStoreNode::outgoing";

		public static String incoming = "UML::DataStoreNode::incoming";

		public static String inPartition = "UML::DataStoreNode::inPartition";

		public static String inInterruptibleRegion = "UML::DataStoreNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::DataStoreNode::redefinedNode";

		public static String ordering = "UML::DataStoreNode::ordering";

		public static String isControlType = "UML::DataStoreNode::isControlType";

		public static String inState = "UML::DataStoreNode::inState";


	}

	/**
	 * JoinNode view descriptor
	 */
	public static class JoinNode {

		public static String ownedComment = "UML::JoinNode::ownedComment";

		public static String name = "UML::JoinNode::name";

		public static String visibility = "UML::JoinNode::visibility";

		public static String clientDependency = "UML::JoinNode::clientDependency";

		public static String isLeaf = "UML::JoinNode::isLeaf";

		public static String outgoing = "UML::JoinNode::outgoing";

		public static String incoming = "UML::JoinNode::incoming";

		public static String inPartition = "UML::JoinNode::inPartition";

		public static String inInterruptibleRegion = "UML::JoinNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::JoinNode::redefinedNode";

		public static String isCombineDuplicate = "UML::JoinNode::isCombineDuplicate";


	}

	/**
	 * UnmarshallAction view descriptor
	 */
	public static class UnmarshallAction {

		public static String ownedComment = "UML::UnmarshallAction::ownedComment";

		public static String name = "UML::UnmarshallAction::name";

		public static String visibility = "UML::UnmarshallAction::visibility";

		public static String clientDependency = "UML::UnmarshallAction::clientDependency";

		public static String isLeaf = "UML::UnmarshallAction::isLeaf";

		public static String outgoing = "UML::UnmarshallAction::outgoing";

		public static String incoming = "UML::UnmarshallAction::incoming";

		public static String inPartition = "UML::UnmarshallAction::inPartition";

		public static String inInterruptibleRegion = "UML::UnmarshallAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::UnmarshallAction::redefinedNode";

		public static String handler = "UML::UnmarshallAction::handler";

		public static String localPrecondition = "UML::UnmarshallAction::localPrecondition";

		public static String localPostcondition = "UML::UnmarshallAction::localPostcondition";

		public static String result = "UML::UnmarshallAction::result";


	}

	/**
	 * ActionInputPin view descriptor
	 */
	public static class ActionInputPin {

		public static String ownedComment = "UML::ActionInputPin::ownedComment";

		public static String name = "UML::ActionInputPin::name";

		public static String visibility = "UML::ActionInputPin::visibility";

		public static String clientDependency = "UML::ActionInputPin::clientDependency";

		public static String isLeaf = "UML::ActionInputPin::isLeaf";

		public static String outgoing = "UML::ActionInputPin::outgoing";

		public static String incoming = "UML::ActionInputPin::incoming";

		public static String inPartition = "UML::ActionInputPin::inPartition";

		public static String inInterruptibleRegion = "UML::ActionInputPin::inInterruptibleRegion";

		public static String redefinedNode = "UML::ActionInputPin::redefinedNode";

		public static String ordering = "UML::ActionInputPin::ordering";

		public static String isControlType = "UML::ActionInputPin::isControlType";

		public static String inState = "UML::ActionInputPin::inState";

		public static String isOrdered = "UML::ActionInputPin::isOrdered";

		public static String isUnique = "UML::ActionInputPin::isUnique";

		public static String isControl = "UML::ActionInputPin::isControl";


	}

	/**
	 * ActivityFinalNode view descriptor
	 */
	public static class ActivityFinalNode {

		public static String ownedComment = "UML::ActivityFinalNode::ownedComment";

		public static String name = "UML::ActivityFinalNode::name";

		public static String visibility = "UML::ActivityFinalNode::visibility";

		public static String clientDependency = "UML::ActivityFinalNode::clientDependency";

		public static String isLeaf = "UML::ActivityFinalNode::isLeaf";

		public static String outgoing = "UML::ActivityFinalNode::outgoing";

		public static String incoming = "UML::ActivityFinalNode::incoming";

		public static String inPartition = "UML::ActivityFinalNode::inPartition";

		public static String inInterruptibleRegion = "UML::ActivityFinalNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::ActivityFinalNode::redefinedNode";


	}

	/**
	 * DecisionNode view descriptor
	 */
	public static class DecisionNode {

		public static String ownedComment = "UML::DecisionNode::ownedComment";

		public static String name = "UML::DecisionNode::name";

		public static String visibility = "UML::DecisionNode::visibility";

		public static String clientDependency = "UML::DecisionNode::clientDependency";

		public static String isLeaf = "UML::DecisionNode::isLeaf";

		public static String outgoing = "UML::DecisionNode::outgoing";

		public static String incoming = "UML::DecisionNode::incoming";

		public static String inPartition = "UML::DecisionNode::inPartition";

		public static String inInterruptibleRegion = "UML::DecisionNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::DecisionNode::redefinedNode";


	}

	/**
	 * MergeNode view descriptor
	 */
	public static class MergeNode {

		public static String ownedComment = "UML::MergeNode::ownedComment";

		public static String name = "UML::MergeNode::name";

		public static String visibility = "UML::MergeNode::visibility";

		public static String clientDependency = "UML::MergeNode::clientDependency";

		public static String isLeaf = "UML::MergeNode::isLeaf";

		public static String outgoing = "UML::MergeNode::outgoing";

		public static String incoming = "UML::MergeNode::incoming";

		public static String inPartition = "UML::MergeNode::inPartition";

		public static String inInterruptibleRegion = "UML::MergeNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::MergeNode::redefinedNode";


	}

	/**
	 * CentralBufferNode view descriptor
	 */
	public static class CentralBufferNode {

		public static String ownedComment = "UML::CentralBufferNode::ownedComment";

		public static String name = "UML::CentralBufferNode::name";

		public static String visibility = "UML::CentralBufferNode::visibility";

		public static String clientDependency = "UML::CentralBufferNode::clientDependency";

		public static String isLeaf = "UML::CentralBufferNode::isLeaf";

		public static String outgoing = "UML::CentralBufferNode::outgoing";

		public static String incoming = "UML::CentralBufferNode::incoming";

		public static String inPartition = "UML::CentralBufferNode::inPartition";

		public static String inInterruptibleRegion = "UML::CentralBufferNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::CentralBufferNode::redefinedNode";

		public static String ordering = "UML::CentralBufferNode::ordering";

		public static String isControlType = "UML::CentralBufferNode::isControlType";

		public static String inState = "UML::CentralBufferNode::inState";


	}

	/**
	 * FlowFinalNode view descriptor
	 */
	public static class FlowFinalNode {

		public static String ownedComment = "UML::FlowFinalNode::ownedComment";

		public static String name = "UML::FlowFinalNode::name";

		public static String visibility = "UML::FlowFinalNode::visibility";

		public static String clientDependency = "UML::FlowFinalNode::clientDependency";

		public static String isLeaf = "UML::FlowFinalNode::isLeaf";

		public static String outgoing = "UML::FlowFinalNode::outgoing";

		public static String incoming = "UML::FlowFinalNode::incoming";

		public static String inPartition = "UML::FlowFinalNode::inPartition";

		public static String inInterruptibleRegion = "UML::FlowFinalNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::FlowFinalNode::redefinedNode";


	}

	/**
	 * ForkNode view descriptor
	 */
	public static class ForkNode {

		public static String ownedComment = "UML::ForkNode::ownedComment";

		public static String name = "UML::ForkNode::name";

		public static String visibility = "UML::ForkNode::visibility";

		public static String clientDependency = "UML::ForkNode::clientDependency";

		public static String isLeaf = "UML::ForkNode::isLeaf";

		public static String outgoing = "UML::ForkNode::outgoing";

		public static String incoming = "UML::ForkNode::incoming";

		public static String inPartition = "UML::ForkNode::inPartition";

		public static String inInterruptibleRegion = "UML::ForkNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::ForkNode::redefinedNode";


	}

	/**
	 * AnyReceiveEvent view descriptor
	 */
	public static class AnyReceiveEvent {

		public static String ownedComment = "UML::AnyReceiveEvent::ownedComment";

		public static String name = "UML::AnyReceiveEvent::name";

		public static String visibility = "UML::AnyReceiveEvent::visibility";

		public static String clientDependency = "UML::AnyReceiveEvent::clientDependency";


	}

	/**
	 * ActivityParameterNode view descriptor
	 */
	public static class ActivityParameterNode {

		public static String ownedComment = "UML::ActivityParameterNode::ownedComment";

		public static String name = "UML::ActivityParameterNode::name";

		public static String visibility = "UML::ActivityParameterNode::visibility";

		public static String clientDependency = "UML::ActivityParameterNode::clientDependency";

		public static String isLeaf = "UML::ActivityParameterNode::isLeaf";

		public static String outgoing = "UML::ActivityParameterNode::outgoing";

		public static String incoming = "UML::ActivityParameterNode::incoming";

		public static String inPartition = "UML::ActivityParameterNode::inPartition";

		public static String inInterruptibleRegion = "UML::ActivityParameterNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::ActivityParameterNode::redefinedNode";

		public static String ordering = "UML::ActivityParameterNode::ordering";

		public static String isControlType = "UML::ActivityParameterNode::isControlType";

		public static String inState = "UML::ActivityParameterNode::inState";


	}

	/**
	 * InitialNode view descriptor
	 */
	public static class InitialNode {

		public static String ownedComment = "UML::InitialNode::ownedComment";

		public static String name = "UML::InitialNode::name";

		public static String visibility = "UML::InitialNode::visibility";

		public static String clientDependency = "UML::InitialNode::clientDependency";

		public static String isLeaf = "UML::InitialNode::isLeaf";

		public static String outgoing = "UML::InitialNode::outgoing";

		public static String incoming = "UML::InitialNode::incoming";

		public static String inPartition = "UML::InitialNode::inPartition";

		public static String inInterruptibleRegion = "UML::InitialNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::InitialNode::redefinedNode";


	}

	/**
	 * ControlFlow view descriptor
	 */
	public static class ControlFlow {

		public static String ownedComment = "UML::ControlFlow::ownedComment";

		public static String name = "UML::ControlFlow::name";

		public static String visibility = "UML::ControlFlow::visibility";

		public static String clientDependency = "UML::ControlFlow::clientDependency";

		public static String isLeaf = "UML::ControlFlow::isLeaf";

		public static String redefinedEdge = "UML::ControlFlow::redefinedEdge";

		public static String inPartition = "UML::ControlFlow::inPartition";


	}

	/**
	 * SequenceNode view descriptor
	 */
	public static class SequenceNode {

		public static String ownedComment = "UML::SequenceNode::ownedComment";

		public static String name = "UML::SequenceNode::name";

		public static String visibility = "UML::SequenceNode::visibility";

		public static String clientDependency = "UML::SequenceNode::clientDependency";

		public static String isLeaf = "UML::SequenceNode::isLeaf";

		public static String outgoing = "UML::SequenceNode::outgoing";

		public static String incoming = "UML::SequenceNode::incoming";

		public static String inPartition = "UML::SequenceNode::inPartition";

		public static String inInterruptibleRegion = "UML::SequenceNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::SequenceNode::redefinedNode";

		public static String handler = "UML::SequenceNode::handler";

		public static String localPrecondition = "UML::SequenceNode::localPrecondition";

		public static String localPostcondition = "UML::SequenceNode::localPostcondition";

		public static String elementImport = "UML::SequenceNode::elementImport";

		public static String packageImport = "UML::SequenceNode::packageImport";

		public static String ownedRule = "UML::SequenceNode::ownedRule";

		public static String variable = "UML::SequenceNode::variable";

		public static String edge = "UML::SequenceNode::edge";

		public static String mustIsolate = "UML::SequenceNode::mustIsolate";

		public static String node = "UML::SequenceNode::node";

		public static String executableNode = "UML::SequenceNode::executableNode";


	}

	/**
	 * CallBehaviorAction view descriptor
	 */
	public static class CallBehaviorAction {

		public static String ownedComment = "UML::CallBehaviorAction::ownedComment";

		public static String name = "UML::CallBehaviorAction::name";

		public static String visibility = "UML::CallBehaviorAction::visibility";

		public static String clientDependency = "UML::CallBehaviorAction::clientDependency";

		public static String isLeaf = "UML::CallBehaviorAction::isLeaf";

		public static String outgoing = "UML::CallBehaviorAction::outgoing";

		public static String incoming = "UML::CallBehaviorAction::incoming";

		public static String inPartition = "UML::CallBehaviorAction::inPartition";

		public static String inInterruptibleRegion = "UML::CallBehaviorAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::CallBehaviorAction::redefinedNode";

		public static String handler = "UML::CallBehaviorAction::handler";

		public static String localPrecondition = "UML::CallBehaviorAction::localPrecondition";

		public static String localPostcondition = "UML::CallBehaviorAction::localPostcondition";

		public static String argument = "UML::CallBehaviorAction::argument";

		public static String isSynchronous = "UML::CallBehaviorAction::isSynchronous";

		public static String result = "UML::CallBehaviorAction::result";


	}

	/**
	 * CallOperationAction view descriptor
	 */
	public static class CallOperationAction {

		public static String ownedComment = "UML::CallOperationAction::ownedComment";

		public static String name = "UML::CallOperationAction::name";

		public static String visibility = "UML::CallOperationAction::visibility";

		public static String clientDependency = "UML::CallOperationAction::clientDependency";

		public static String isLeaf = "UML::CallOperationAction::isLeaf";

		public static String outgoing = "UML::CallOperationAction::outgoing";

		public static String incoming = "UML::CallOperationAction::incoming";

		public static String inPartition = "UML::CallOperationAction::inPartition";

		public static String inInterruptibleRegion = "UML::CallOperationAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::CallOperationAction::redefinedNode";

		public static String handler = "UML::CallOperationAction::handler";

		public static String localPrecondition = "UML::CallOperationAction::localPrecondition";

		public static String localPostcondition = "UML::CallOperationAction::localPostcondition";

		public static String argument = "UML::CallOperationAction::argument";

		public static String isSynchronous = "UML::CallOperationAction::isSynchronous";

		public static String result = "UML::CallOperationAction::result";


	}

	/**
	 * SendSignalAction view descriptor
	 */
	public static class SendSignalAction {

		public static String ownedComment = "UML::SendSignalAction::ownedComment";

		public static String name = "UML::SendSignalAction::name";

		public static String visibility = "UML::SendSignalAction::visibility";

		public static String clientDependency = "UML::SendSignalAction::clientDependency";

		public static String isLeaf = "UML::SendSignalAction::isLeaf";

		public static String outgoing = "UML::SendSignalAction::outgoing";

		public static String incoming = "UML::SendSignalAction::incoming";

		public static String inPartition = "UML::SendSignalAction::inPartition";

		public static String inInterruptibleRegion = "UML::SendSignalAction::inInterruptibleRegion";

		public static String redefinedNode = "UML::SendSignalAction::redefinedNode";

		public static String handler = "UML::SendSignalAction::handler";

		public static String localPrecondition = "UML::SendSignalAction::localPrecondition";

		public static String localPostcondition = "UML::SendSignalAction::localPostcondition";

		public static String argument = "UML::SendSignalAction::argument";


	}

	/**
	 * InputPin view descriptor
	 */
	public static class InputPin {

		public static String ownedComment = "UML::InputPin::ownedComment";

		public static String name = "UML::InputPin::name";

		public static String visibility = "UML::InputPin::visibility";

		public static String clientDependency = "UML::InputPin::clientDependency";

		public static String isLeaf = "UML::InputPin::isLeaf";

		public static String outgoing = "UML::InputPin::outgoing";

		public static String incoming = "UML::InputPin::incoming";

		public static String inPartition = "UML::InputPin::inPartition";

		public static String inInterruptibleRegion = "UML::InputPin::inInterruptibleRegion";

		public static String redefinedNode = "UML::InputPin::redefinedNode";

		public static String ordering = "UML::InputPin::ordering";

		public static String isControlType = "UML::InputPin::isControlType";

		public static String inState = "UML::InputPin::inState";

		public static String isOrdered = "UML::InputPin::isOrdered";

		public static String isUnique = "UML::InputPin::isUnique";

		public static String isControl = "UML::InputPin::isControl";


	}

	/**
	 * Pin view descriptor
	 */
	public static class Pin {

		public static String ownedComment = "UML::Pin::ownedComment";

		public static String name = "UML::Pin::name";

		public static String visibility = "UML::Pin::visibility";

		public static String clientDependency = "UML::Pin::clientDependency";

		public static String isLeaf = "UML::Pin::isLeaf";

		public static String outgoing = "UML::Pin::outgoing";

		public static String incoming = "UML::Pin::incoming";

		public static String inPartition = "UML::Pin::inPartition";

		public static String inInterruptibleRegion = "UML::Pin::inInterruptibleRegion";

		public static String redefinedNode = "UML::Pin::redefinedNode";

		public static String ordering = "UML::Pin::ordering";

		public static String isControlType = "UML::Pin::isControlType";

		public static String inState = "UML::Pin::inState";

		public static String isOrdered = "UML::Pin::isOrdered";

		public static String isUnique = "UML::Pin::isUnique";

		public static String isControl = "UML::Pin::isControl";


	}

	/**
	 * OutputPin view descriptor
	 */
	public static class OutputPin {

		public static String ownedComment = "UML::OutputPin::ownedComment";

		public static String name = "UML::OutputPin::name";

		public static String visibility = "UML::OutputPin::visibility";

		public static String clientDependency = "UML::OutputPin::clientDependency";

		public static String isLeaf = "UML::OutputPin::isLeaf";

		public static String outgoing = "UML::OutputPin::outgoing";

		public static String incoming = "UML::OutputPin::incoming";

		public static String inPartition = "UML::OutputPin::inPartition";

		public static String inInterruptibleRegion = "UML::OutputPin::inInterruptibleRegion";

		public static String redefinedNode = "UML::OutputPin::redefinedNode";

		public static String ordering = "UML::OutputPin::ordering";

		public static String isControlType = "UML::OutputPin::isControlType";

		public static String inState = "UML::OutputPin::inState";

		public static String isOrdered = "UML::OutputPin::isOrdered";

		public static String isUnique = "UML::OutputPin::isUnique";

		public static String isControl = "UML::OutputPin::isControl";


	}

	/**
	 * ExceptionHandler view descriptor
	 */
	public static class ExceptionHandler {

		public static String ownedComment = "UML::ExceptionHandler::ownedComment";

		public static String exceptionType = "UML::ExceptionHandler::exceptionType";


	}

	/**
	 * InterruptibleActivityRegion view descriptor
	 */
	public static class InterruptibleActivityRegion {

		public static String ownedComment = "UML::InterruptibleActivityRegion::ownedComment";

		public static String node = "UML::InterruptibleActivityRegion::node";

		public static String interruptingEdge = "UML::InterruptibleActivityRegion::interruptingEdge";


	}

	/**
	 * ActivityPartition view descriptor
	 */
	public static class ActivityPartition {

		public static String ownedComment = "UML::ActivityPartition::ownedComment";

		public static String name = "UML::ActivityPartition::name";

		public static String visibility = "UML::ActivityPartition::visibility";

		public static String clientDependency = "UML::ActivityPartition::clientDependency";

		public static String isDimension = "UML::ActivityPartition::isDimension";

		public static String isExternal = "UML::ActivityPartition::isExternal";

		public static String node = "UML::ActivityPartition::node";

		public static String subpartition = "UML::ActivityPartition::subpartition";

		public static String edge = "UML::ActivityPartition::edge";


	}

	/**
	 * Variable view descriptor
	 */
	public static class Variable {

		public static String ownedComment = "UML::Variable::ownedComment";

		public static String name = "UML::Variable::name";

		public static String visibility = "UML::Variable::visibility";

		public static String clientDependency = "UML::Variable::clientDependency";

		public static String isOrdered = "UML::Variable::isOrdered";

		public static String isUnique = "UML::Variable::isUnique";


	}

	/**
	 * Activity view descriptor
	 */
	public static class Activity {

		public static String ownedComment = "UML::Activity::ownedComment";

		public static String name = "UML::Activity::name";

		public static String visibility = "UML::Activity::visibility";

		public static String clientDependency = "UML::Activity::clientDependency";

		public static String elementImport = "UML::Activity::elementImport";

		public static String packageImport = "UML::Activity::packageImport";

		public static String ownedRule = "UML::Activity::ownedRule";

		public static String isLeaf = "UML::Activity::isLeaf";

		public static String templateBinding = "UML::Activity::templateBinding";

		public static String isAbstract = "UML::Activity::isAbstract";

		public static String generalization = "UML::Activity::generalization";

		public static String powertypeExtent = "UML::Activity::powertypeExtent";

		public static String redefinedClassifier = "UML::Activity::redefinedClassifier";

		public static String substitution = "UML::Activity::substitution";

		public static String collaborationUse = "UML::Activity::collaborationUse";

		public static String ownedUseCase = "UML::Activity::ownedUseCase";

		public static String useCase = "UML::Activity::useCase";

		public static String ownedAttribute = "UML::Activity::ownedAttribute";

		public static String ownedConnector = "UML::Activity::ownedConnector";

		public static String ownedBehavior = "UML::Activity::ownedBehavior";

		public static String interfaceRealization = "UML::Activity::interfaceRealization";

		public static String ownedTrigger = "UML::Activity::ownedTrigger";

		public static String nestedClassifier = "UML::Activity::nestedClassifier";

		public static String ownedOperation = "UML::Activity::ownedOperation";

		public static String isActive = "UML::Activity::isActive";

		public static String ownedReception = "UML::Activity::ownedReception";

		public static String isReentrant = "UML::Activity::isReentrant";

		public static String redefinedBehavior = "UML::Activity::redefinedBehavior";

		public static String ownedParameter = "UML::Activity::ownedParameter";

		public static String precondition = "UML::Activity::precondition";

		public static String postcondition = "UML::Activity::postcondition";

		public static String ownedParameterSet = "UML::Activity::ownedParameterSet";

		public static String variable = "UML::Activity::variable";

		public static String node = "UML::Activity::node";

		public static String isReadOnly = "UML::Activity::isReadOnly";

		public static String edge = "UML::Activity::edge";

		public static String partition = "UML::Activity::partition";

		public static String isSingleExecution = "UML::Activity::isSingleExecution";

		public static String group = "UML::Activity::group";


	}

	/**
	 * StructuredActivityNode view descriptor
	 */
	public static class StructuredActivityNode {

		public static String ownedComment = "UML::StructuredActivityNode::ownedComment";

		public static String name = "UML::StructuredActivityNode::name";

		public static String visibility = "UML::StructuredActivityNode::visibility";

		public static String clientDependency = "UML::StructuredActivityNode::clientDependency";

		public static String isLeaf = "UML::StructuredActivityNode::isLeaf";

		public static String outgoing = "UML::StructuredActivityNode::outgoing";

		public static String incoming = "UML::StructuredActivityNode::incoming";

		public static String inPartition = "UML::StructuredActivityNode::inPartition";

		public static String inInterruptibleRegion = "UML::StructuredActivityNode::inInterruptibleRegion";

		public static String redefinedNode = "UML::StructuredActivityNode::redefinedNode";

		public static String handler = "UML::StructuredActivityNode::handler";

		public static String localPrecondition = "UML::StructuredActivityNode::localPrecondition";

		public static String localPostcondition = "UML::StructuredActivityNode::localPostcondition";

		public static String elementImport = "UML::StructuredActivityNode::elementImport";

		public static String packageImport = "UML::StructuredActivityNode::packageImport";

		public static String ownedRule = "UML::StructuredActivityNode::ownedRule";

		public static String variable = "UML::StructuredActivityNode::variable";

		public static String edge = "UML::StructuredActivityNode::edge";

		public static String mustIsolate = "UML::StructuredActivityNode::mustIsolate";

		public static String node = "UML::StructuredActivityNode::node";


	}

	/**
	 * ParameterSet view descriptor
	 */
	public static class ParameterSet {

		public static String ownedComment = "UML::ParameterSet::ownedComment";

		public static String name = "UML::ParameterSet::name";

		public static String visibility = "UML::ParameterSet::visibility";

		public static String clientDependency = "UML::ParameterSet::clientDependency";

		public static String parameter = "UML::ParameterSet::parameter";

		public static String condition = "UML::ParameterSet::condition";


	}

	/**
	 * DurationObservation view descriptor
	 */
	public static class DurationObservation {

		public static String ownedComment = "UML::DurationObservation::ownedComment";

		public static String name = "UML::DurationObservation::name";

		public static String visibility = "UML::DurationObservation::visibility";

		public static String clientDependency = "UML::DurationObservation::clientDependency";

		public static String firstEvent = "UML::DurationObservation::firstEvent";


	}

	/**
	 * TimeObservation view descriptor
	 */
	public static class TimeObservation {

		public static String ownedComment = "UML::TimeObservation::ownedComment";

		public static String name = "UML::TimeObservation::name";

		public static String visibility = "UML::TimeObservation::visibility";

		public static String clientDependency = "UML::TimeObservation::clientDependency";

		public static String firstEvent = "UML::TimeObservation::firstEvent";


	}

	/**
	 * TimeInterval view descriptor
	 */
	public static class TimeInterval {

		public static String ownedComment = "UML::TimeInterval::ownedComment";

		public static String name = "UML::TimeInterval::name";

		public static String visibility = "UML::TimeInterval::visibility";

		public static String clientDependency = "UML::TimeInterval::clientDependency";


	}

	/**
	 * DurationConstraint view descriptor
	 */
	public static class DurationConstraint {

		public static String ownedComment = "UML::DurationConstraint::ownedComment";

		public static String name = "UML::DurationConstraint::name";

		public static String visibility = "UML::DurationConstraint::visibility";

		public static String clientDependency = "UML::DurationConstraint::clientDependency";

		public static String constrainedElement = "UML::DurationConstraint::constrainedElement";

		public static String firstEvent = "UML::DurationConstraint::firstEvent";


	}

	/**
	 * IntervalConstraint view descriptor
	 */
	public static class IntervalConstraint {

		public static String ownedComment = "UML::IntervalConstraint::ownedComment";

		public static String name = "UML::IntervalConstraint::name";

		public static String visibility = "UML::IntervalConstraint::visibility";

		public static String clientDependency = "UML::IntervalConstraint::clientDependency";

		public static String constrainedElement = "UML::IntervalConstraint::constrainedElement";


	}

	/**
	 * TimeConstraint view descriptor
	 */
	public static class TimeConstraint {

		public static String ownedComment = "UML::TimeConstraint::ownedComment";

		public static String name = "UML::TimeConstraint::name";

		public static String visibility = "UML::TimeConstraint::visibility";

		public static String clientDependency = "UML::TimeConstraint::clientDependency";

		public static String constrainedElement = "UML::TimeConstraint::constrainedElement";

		public static String firstEvent = "UML::TimeConstraint::firstEvent";


	}

	/**
	 * DurationInterval view descriptor
	 */
	public static class DurationInterval {

		public static String ownedComment = "UML::DurationInterval::ownedComment";

		public static String name = "UML::DurationInterval::name";

		public static String visibility = "UML::DurationInterval::visibility";

		public static String clientDependency = "UML::DurationInterval::clientDependency";


	}

	/**
	 * Duration view descriptor
	 */
	public static class Duration {

		public static String ownedComment = "UML::Duration::ownedComment";

		public static String name = "UML::Duration::name";

		public static String visibility = "UML::Duration::visibility";

		public static String clientDependency = "UML::Duration::clientDependency";

		public static String observation = "UML::Duration::observation";


	}

	/**
	 * Interval view descriptor
	 */
	public static class Interval {

		public static String ownedComment = "UML::Interval::ownedComment";

		public static String name = "UML::Interval::name";

		public static String visibility = "UML::Interval::visibility";

		public static String clientDependency = "UML::Interval::clientDependency";


	}

	/**
	 * TimeExpression view descriptor
	 */
	public static class TimeExpression {

		public static String ownedComment = "UML::TimeExpression::ownedComment";

		public static String name = "UML::TimeExpression::name";

		public static String visibility = "UML::TimeExpression::visibility";

		public static String clientDependency = "UML::TimeExpression::clientDependency";

		public static String observation = "UML::TimeExpression::observation";


	}

	/**
	 * SignalEvent view descriptor
	 */
	public static class SignalEvent {

		public static String ownedComment = "UML::SignalEvent::ownedComment";

		public static String name = "UML::SignalEvent::name";

		public static String visibility = "UML::SignalEvent::visibility";

		public static String clientDependency = "UML::SignalEvent::clientDependency";


	}

	/**
	 * ChangeEvent view descriptor
	 */
	public static class ChangeEvent {

		public static String ownedComment = "UML::ChangeEvent::ownedComment";

		public static String name = "UML::ChangeEvent::name";

		public static String visibility = "UML::ChangeEvent::visibility";

		public static String clientDependency = "UML::ChangeEvent::clientDependency";


	}

	/**
	 * CallEvent view descriptor
	 */
	public static class CallEvent {

		public static String ownedComment = "UML::CallEvent::ownedComment";

		public static String name = "UML::CallEvent::name";

		public static String visibility = "UML::CallEvent::visibility";

		public static String clientDependency = "UML::CallEvent::clientDependency";


	}

	/**
	 * FunctionBehavior view descriptor
	 */
	public static class FunctionBehavior {

		public static String ownedComment = "UML::FunctionBehavior::ownedComment";

		public static String name = "UML::FunctionBehavior::name";

		public static String visibility = "UML::FunctionBehavior::visibility";

		public static String clientDependency = "UML::FunctionBehavior::clientDependency";

		public static String elementImport = "UML::FunctionBehavior::elementImport";

		public static String packageImport = "UML::FunctionBehavior::packageImport";

		public static String ownedRule = "UML::FunctionBehavior::ownedRule";

		public static String isLeaf = "UML::FunctionBehavior::isLeaf";

		public static String templateBinding = "UML::FunctionBehavior::templateBinding";

		public static String isAbstract = "UML::FunctionBehavior::isAbstract";

		public static String generalization = "UML::FunctionBehavior::generalization";

		public static String powertypeExtent = "UML::FunctionBehavior::powertypeExtent";

		public static String redefinedClassifier = "UML::FunctionBehavior::redefinedClassifier";

		public static String substitution = "UML::FunctionBehavior::substitution";

		public static String collaborationUse = "UML::FunctionBehavior::collaborationUse";

		public static String ownedUseCase = "UML::FunctionBehavior::ownedUseCase";

		public static String useCase = "UML::FunctionBehavior::useCase";

		public static String ownedAttribute = "UML::FunctionBehavior::ownedAttribute";

		public static String ownedConnector = "UML::FunctionBehavior::ownedConnector";

		public static String ownedBehavior = "UML::FunctionBehavior::ownedBehavior";

		public static String interfaceRealization = "UML::FunctionBehavior::interfaceRealization";

		public static String ownedTrigger = "UML::FunctionBehavior::ownedTrigger";

		public static String nestedClassifier = "UML::FunctionBehavior::nestedClassifier";

		public static String ownedOperation = "UML::FunctionBehavior::ownedOperation";

		public static String isActive = "UML::FunctionBehavior::isActive";

		public static String ownedReception = "UML::FunctionBehavior::ownedReception";

		public static String isReentrant = "UML::FunctionBehavior::isReentrant";

		public static String redefinedBehavior = "UML::FunctionBehavior::redefinedBehavior";

		public static String ownedParameter = "UML::FunctionBehavior::ownedParameter";

		public static String precondition = "UML::FunctionBehavior::precondition";

		public static String postcondition = "UML::FunctionBehavior::postcondition";

		public static String ownedParameterSet = "UML::FunctionBehavior::ownedParameterSet";

		public static String body = "UML::FunctionBehavior::body";

		public static String language = "UML::FunctionBehavior::language";


	}

	/**
	 * OpaqueBehavior view descriptor
	 */
	public static class OpaqueBehavior {

		public static String ownedComment = "UML::OpaqueBehavior::ownedComment";

		public static String name = "UML::OpaqueBehavior::name";

		public static String visibility = "UML::OpaqueBehavior::visibility";

		public static String clientDependency = "UML::OpaqueBehavior::clientDependency";

		public static String elementImport = "UML::OpaqueBehavior::elementImport";

		public static String packageImport = "UML::OpaqueBehavior::packageImport";

		public static String ownedRule = "UML::OpaqueBehavior::ownedRule";

		public static String isLeaf = "UML::OpaqueBehavior::isLeaf";

		public static String templateBinding = "UML::OpaqueBehavior::templateBinding";

		public static String isAbstract = "UML::OpaqueBehavior::isAbstract";

		public static String generalization = "UML::OpaqueBehavior::generalization";

		public static String powertypeExtent = "UML::OpaqueBehavior::powertypeExtent";

		public static String redefinedClassifier = "UML::OpaqueBehavior::redefinedClassifier";

		public static String substitution = "UML::OpaqueBehavior::substitution";

		public static String collaborationUse = "UML::OpaqueBehavior::collaborationUse";

		public static String ownedUseCase = "UML::OpaqueBehavior::ownedUseCase";

		public static String useCase = "UML::OpaqueBehavior::useCase";

		public static String ownedAttribute = "UML::OpaqueBehavior::ownedAttribute";

		public static String ownedConnector = "UML::OpaqueBehavior::ownedConnector";

		public static String ownedBehavior = "UML::OpaqueBehavior::ownedBehavior";

		public static String interfaceRealization = "UML::OpaqueBehavior::interfaceRealization";

		public static String ownedTrigger = "UML::OpaqueBehavior::ownedTrigger";

		public static String nestedClassifier = "UML::OpaqueBehavior::nestedClassifier";

		public static String ownedOperation = "UML::OpaqueBehavior::ownedOperation";

		public static String isActive = "UML::OpaqueBehavior::isActive";

		public static String ownedReception = "UML::OpaqueBehavior::ownedReception";

		public static String isReentrant = "UML::OpaqueBehavior::isReentrant";

		public static String redefinedBehavior = "UML::OpaqueBehavior::redefinedBehavior";

		public static String ownedParameter = "UML::OpaqueBehavior::ownedParameter";

		public static String precondition = "UML::OpaqueBehavior::precondition";

		public static String postcondition = "UML::OpaqueBehavior::postcondition";

		public static String ownedParameterSet = "UML::OpaqueBehavior::ownedParameterSet";

		public static String body = "UML::OpaqueBehavior::body";

		public static String language = "UML::OpaqueBehavior::language";


	}

	/**
	 * Signal view descriptor
	 */
	public static class Signal {

		public static String name = "UML::Signal::name";

		public static String visibility = "UML::Signal::visibility";

		public static String isAbstract = "UML::Signal::isAbstract";

		public static String isLeaf = "UML::Signal::isLeaf";



		public static String ownedAttribute = "UML::Signal::ownedAttribute";

		public static String useCase = "UML::Signal::useCase";

		public static String ownedUseCase = "UML::Signal::ownedUseCase";

		public static String collaborationUse = "UML::Signal::collaborationUse";

		public static String substitution = "UML::Signal::substitution";

		public static String redefinedClassifier = "UML::Signal::redefinedClassifier";

		public static String powertypeExtent = "UML::Signal::powertypeExtent";

		public static String templateBinding = "UML::Signal::templateBinding";

		public static String generalization = "UML::Signal::generalization";

		public static String ownedRule = "UML::Signal::ownedRule";

		public static String packageImport = "UML::Signal::packageImport";

		public static String elementImport = "UML::Signal::elementImport";



	}

	/**
	 * Reception view descriptor
	 */
	public static class Reception {

		public static String name = "UML::Reception::name";

		public static String visibility = "UML::Reception::visibility";

		public static String concurrency = "UML::Reception::concurrency";

		public static String isAbstract = "UML::Reception::isAbstract";

		public static String isLeaf = "UML::Reception::isLeaf";

		public static String isStatic = "UML::Reception::isStatic";


		public static String method = "UML::Reception::method";

		public static String raisedException = "UML::Reception::raisedException";

		public static String ownedParameter = "UML::Reception::ownedParameter";



		public static String ownedParameterSet = "UML::Reception::ownedParameterSet";

		public static String packageImport = "UML::Reception::packageImport";

		public static String elementImport = "UML::Reception::elementImport";

		public static String ownedRule = "UML::Reception::ownedRule";



	}

	/**
	 * Interface view descriptor
	 */
	public static class Interface_ {

		public static String name = "UML::Interface::name";

		public static String visibility = "UML::Interface::visibility";

		public static String isAbstract = "UML::Interface::isAbstract";

		public static String isLeaf = "UML::Interface::isLeaf";



		public static String ownedAttribute = "UML::Interface::ownedAttribute";

		public static String ownedOperation = "UML::Interface::ownedOperation";

		public static String nestedClassifier = "UML::Interface::nestedClassifier";



		public static String generalization = "UML::Interface::generalization";

		public static String redefinedClassifier = "UML::Interface::redefinedClassifier";

		public static String redefinedInterface = "UML::Interface::redefinedInterface";



		public static String templateBinding = "UML::Interface::templateBinding";

		public static String elementImport = "UML::Interface::elementImport";

		public static String packageImport = "UML::Interface::packageImport";

		public static String ownedRule = "UML::Interface::ownedRule";

		public static String powertypeExtent = "UML::Interface::powertypeExtent";

		public static String useCase = "UML::Interface::useCase";

		public static String ownedUseCase = "UML::Interface::ownedUseCase";

		public static String collaborationUse = "UML::Interface::collaborationUse";

		public static String substitution = "UML::Interface::substitution";

		public static String ownedReception = "UML::Interface::ownedReception";



	}

	/**
	 * ConsiderIgnoreFragment view descriptor
	 */
	public static class ConsiderIgnoreFragment {

		public static String ownedComment = "UML::ConsiderIgnoreFragment::ownedComment";

		public static String name = "UML::ConsiderIgnoreFragment::name";

		public static String visibility = "UML::ConsiderIgnoreFragment::visibility";

		public static String clientDependency = "UML::ConsiderIgnoreFragment::clientDependency";

		public static String covered = "UML::ConsiderIgnoreFragment::covered";

		public static String generalOrdering = "UML::ConsiderIgnoreFragment::generalOrdering";

		public static String interactionOperator = "UML::ConsiderIgnoreFragment::interactionOperator";

		public static String operand = "UML::ConsiderIgnoreFragment::operand";

		public static String cfragmentGate = "UML::ConsiderIgnoreFragment::cfragmentGate";

		public static String message = "UML::ConsiderIgnoreFragment::message";


	}

	/**
	 * Continuation view descriptor
	 */
	public static class Continuation {

		public static String ownedComment = "UML::Continuation::ownedComment";

		public static String name = "UML::Continuation::name";

		public static String visibility = "UML::Continuation::visibility";

		public static String clientDependency = "UML::Continuation::clientDependency";

		public static String covered = "UML::Continuation::covered";

		public static String generalOrdering = "UML::Continuation::generalOrdering";

		public static String setting = "UML::Continuation::setting";


	}

	/**
	 * CombinedFragment view descriptor
	 */
	public static class CombinedFragment {

		public static String ownedComment = "UML::CombinedFragment::ownedComment";

		public static String name = "UML::CombinedFragment::name";

		public static String visibility = "UML::CombinedFragment::visibility";

		public static String clientDependency = "UML::CombinedFragment::clientDependency";

		public static String covered = "UML::CombinedFragment::covered";

		public static String generalOrdering = "UML::CombinedFragment::generalOrdering";

		public static String interactionOperator = "UML::CombinedFragment::interactionOperator";

		public static String operand = "UML::CombinedFragment::operand";

		public static String cfragmentGate = "UML::CombinedFragment::cfragmentGate";


	}

	/**
	 * ReceiveSignalEvent view descriptor
	 */
	public static class ReceiveSignalEvent {

		public static String ownedComment = "UML::ReceiveSignalEvent::ownedComment";

		public static String name = "UML::ReceiveSignalEvent::name";

		public static String visibility = "UML::ReceiveSignalEvent::visibility";

		public static String clientDependency = "UML::ReceiveSignalEvent::clientDependency";


	}

	/**
	 * ReceiveOperationEvent view descriptor
	 */
	public static class ReceiveOperationEvent {

		public static String ownedComment = "UML::ReceiveOperationEvent::ownedComment";

		public static String name = "UML::ReceiveOperationEvent::name";

		public static String visibility = "UML::ReceiveOperationEvent::visibility";

		public static String clientDependency = "UML::ReceiveOperationEvent::clientDependency";


	}

	/**
	 * ExecutionOccurrenceSpecification view descriptor
	 */
	public static class ExecutionOccurrenceSpecification {

		public static String ownedComment = "UML::ExecutionOccurrenceSpecification::ownedComment";

		public static String name = "UML::ExecutionOccurrenceSpecification::name";

		public static String visibility = "UML::ExecutionOccurrenceSpecification::visibility";

		public static String clientDependency = "UML::ExecutionOccurrenceSpecification::clientDependency";

		public static String covered = "UML::ExecutionOccurrenceSpecification::covered";

		public static String generalOrdering = "UML::ExecutionOccurrenceSpecification::generalOrdering";

		public static String toBefore = "UML::ExecutionOccurrenceSpecification::toBefore";

		public static String toAfter = "UML::ExecutionOccurrenceSpecification::toAfter";


	}

	/**
	 * MessageOccurrenceSpecification view descriptor
	 */
	public static class MessageOccurrenceSpecification {

		public static String ownedComment = "UML::MessageOccurrenceSpecification::ownedComment";

		public static String name = "UML::MessageOccurrenceSpecification::name";

		public static String visibility = "UML::MessageOccurrenceSpecification::visibility";

		public static String clientDependency = "UML::MessageOccurrenceSpecification::clientDependency";

		public static String covered = "UML::MessageOccurrenceSpecification::covered";

		public static String generalOrdering = "UML::MessageOccurrenceSpecification::generalOrdering";

		public static String toBefore = "UML::MessageOccurrenceSpecification::toBefore";

		public static String toAfter = "UML::MessageOccurrenceSpecification::toAfter";


	}

	/**
	 * SendSignalEvent view descriptor
	 */
	public static class SendSignalEvent {

		public static String ownedComment = "UML::SendSignalEvent::ownedComment";

		public static String name = "UML::SendSignalEvent::name";

		public static String visibility = "UML::SendSignalEvent::visibility";

		public static String clientDependency = "UML::SendSignalEvent::clientDependency";


	}

	/**
	 * SendOperationEvent view descriptor
	 */
	public static class SendOperationEvent {

		public static String ownedComment = "UML::SendOperationEvent::ownedComment";

		public static String name = "UML::SendOperationEvent::name";

		public static String visibility = "UML::SendOperationEvent::visibility";

		public static String clientDependency = "UML::SendOperationEvent::clientDependency";


	}

	/**
	 * DestructionEvent view descriptor
	 */
	public static class DestructionEvent {

		public static String ownedComment = "UML::DestructionEvent::ownedComment";

		public static String name = "UML::DestructionEvent::name";

		public static String visibility = "UML::DestructionEvent::visibility";

		public static String clientDependency = "UML::DestructionEvent::clientDependency";


	}

	/**
	 * CreationEvent view descriptor
	 */
	public static class CreationEvent {

		public static String ownedComment = "UML::CreationEvent::ownedComment";

		public static String name = "UML::CreationEvent::name";

		public static String visibility = "UML::CreationEvent::visibility";

		public static String clientDependency = "UML::CreationEvent::clientDependency";


	}

	/**
	 * ExecutionEvent view descriptor
	 */
	public static class ExecutionEvent {

		public static String ownedComment = "UML::ExecutionEvent::ownedComment";

		public static String name = "UML::ExecutionEvent::name";

		public static String visibility = "UML::ExecutionEvent::visibility";

		public static String clientDependency = "UML::ExecutionEvent::clientDependency";


	}

	/**
	 * BehaviorExecutionSpecification view descriptor
	 */
	public static class BehaviorExecutionSpecification {

		public static String ownedComment = "UML::BehaviorExecutionSpecification::ownedComment";

		public static String name = "UML::BehaviorExecutionSpecification::name";

		public static String visibility = "UML::BehaviorExecutionSpecification::visibility";

		public static String clientDependency = "UML::BehaviorExecutionSpecification::clientDependency";

		public static String covered = "UML::BehaviorExecutionSpecification::covered";

		public static String generalOrdering = "UML::BehaviorExecutionSpecification::generalOrdering";


	}

	/**
	 * ActionExecutionSpecification view descriptor
	 */
	public static class ActionExecutionSpecification {

		public static String ownedComment = "UML::ActionExecutionSpecification::ownedComment";

		public static String name = "UML::ActionExecutionSpecification::name";

		public static String visibility = "UML::ActionExecutionSpecification::visibility";

		public static String clientDependency = "UML::ActionExecutionSpecification::clientDependency";

		public static String covered = "UML::ActionExecutionSpecification::covered";

		public static String generalOrdering = "UML::ActionExecutionSpecification::generalOrdering";


	}

	/**
	 * StateInvariant view descriptor
	 */
	public static class StateInvariant {

		public static String ownedComment = "UML::StateInvariant::ownedComment";

		public static String name = "UML::StateInvariant::name";

		public static String visibility = "UML::StateInvariant::visibility";

		public static String clientDependency = "UML::StateInvariant::clientDependency";

		public static String covered = "UML::StateInvariant::covered";

		public static String generalOrdering = "UML::StateInvariant::generalOrdering";


	}

	/**
	 * InteractionConstraint view descriptor
	 */
	public static class InteractionConstraint {

		public static String ownedComment = "UML::InteractionConstraint::ownedComment";

		public static String name = "UML::InteractionConstraint::name";

		public static String visibility = "UML::InteractionConstraint::visibility";

		public static String clientDependency = "UML::InteractionConstraint::clientDependency";

		public static String constrainedElement = "UML::InteractionConstraint::constrainedElement";


	}

	/**
	 * InteractionOperand view descriptor
	 */
	public static class InteractionOperand {

		public static String ownedComment = "UML::InteractionOperand::ownedComment";

		public static String name = "UML::InteractionOperand::name";

		public static String visibility = "UML::InteractionOperand::visibility";

		public static String clientDependency = "UML::InteractionOperand::clientDependency";

		public static String elementImport = "UML::InteractionOperand::elementImport";

		public static String packageImport = "UML::InteractionOperand::packageImport";

		public static String ownedRule = "UML::InteractionOperand::ownedRule";

		public static String covered = "UML::InteractionOperand::covered";

		public static String generalOrdering = "UML::InteractionOperand::generalOrdering";

		public static String fragment = "UML::InteractionOperand::fragment";


	}

	/**
	 * OccurrenceSpecification view descriptor
	 */
	public static class OccurrenceSpecification {

		public static String ownedComment = "UML::OccurrenceSpecification::ownedComment";

		public static String name = "UML::OccurrenceSpecification::name";

		public static String visibility = "UML::OccurrenceSpecification::visibility";

		public static String clientDependency = "UML::OccurrenceSpecification::clientDependency";

		public static String covered = "UML::OccurrenceSpecification::covered";

		public static String generalOrdering = "UML::OccurrenceSpecification::generalOrdering";

		public static String toBefore = "UML::OccurrenceSpecification::toBefore";

		public static String toAfter = "UML::OccurrenceSpecification::toAfter";


	}

	/**
	 * GeneralOrdering view descriptor
	 */
	public static class GeneralOrdering {

		public static String ownedComment = "UML::GeneralOrdering::ownedComment";

		public static String name = "UML::GeneralOrdering::name";

		public static String visibility = "UML::GeneralOrdering::visibility";

		public static String clientDependency = "UML::GeneralOrdering::clientDependency";


	}

	/**
	 * Gate view descriptor
	 */
	public static class Gate {

		public static String ownedComment = "UML::Gate::ownedComment";

		public static String name = "UML::Gate::name";

		public static String visibility = "UML::Gate::visibility";

		public static String clientDependency = "UML::Gate::clientDependency";


	}

	/**
	 * InteractionUse view descriptor
	 */
	public static class InteractionUse {

		public static String ownedComment = "UML::InteractionUse::ownedComment";

		public static String name = "UML::InteractionUse::name";

		public static String visibility = "UML::InteractionUse::visibility";

		public static String clientDependency = "UML::InteractionUse::clientDependency";

		public static String covered = "UML::InteractionUse::covered";

		public static String generalOrdering = "UML::InteractionUse::generalOrdering";

		public static String actualGate = "UML::InteractionUse::actualGate";

		public static String argument = "UML::InteractionUse::argument";


	}

	/**
	 * PartDecomposition view descriptor
	 */
	public static class PartDecomposition {

		public static String ownedComment = "UML::PartDecomposition::ownedComment";

		public static String name = "UML::PartDecomposition::name";

		public static String visibility = "UML::PartDecomposition::visibility";

		public static String clientDependency = "UML::PartDecomposition::clientDependency";

		public static String covered = "UML::PartDecomposition::covered";

		public static String generalOrdering = "UML::PartDecomposition::generalOrdering";

		public static String actualGate = "UML::PartDecomposition::actualGate";

		public static String argument = "UML::PartDecomposition::argument";


	}

	/**
	 * Lifeline view descriptor
	 */
	public static class Lifeline {

		public static String ownedComment = "UML::Lifeline::ownedComment";

		public static String name = "UML::Lifeline::name";

		public static String visibility = "UML::Lifeline::visibility";

		public static String clientDependency = "UML::Lifeline::clientDependency";

		public static String coveredBy = "UML::Lifeline::coveredBy";


	}

	/**
	 * Interaction view descriptor
	 */
	public static class Interaction {

		public static String ownedComment = "UML::Interaction::ownedComment";

		public static String name = "UML::Interaction::name";

		public static String visibility = "UML::Interaction::visibility";

		public static String clientDependency = "UML::Interaction::clientDependency";

		public static String elementImport = "UML::Interaction::elementImport";

		public static String packageImport = "UML::Interaction::packageImport";

		public static String ownedRule = "UML::Interaction::ownedRule";

		public static String isLeaf = "UML::Interaction::isLeaf";

		public static String templateBinding = "UML::Interaction::templateBinding";

		public static String isAbstract = "UML::Interaction::isAbstract";

		public static String generalization = "UML::Interaction::generalization";

		public static String powertypeExtent = "UML::Interaction::powertypeExtent";

		public static String redefinedClassifier = "UML::Interaction::redefinedClassifier";

		public static String substitution = "UML::Interaction::substitution";

		public static String collaborationUse = "UML::Interaction::collaborationUse";

		public static String ownedUseCase = "UML::Interaction::ownedUseCase";

		public static String useCase = "UML::Interaction::useCase";

		public static String ownedAttribute = "UML::Interaction::ownedAttribute";

		public static String ownedConnector = "UML::Interaction::ownedConnector";

		public static String ownedBehavior = "UML::Interaction::ownedBehavior";

		public static String interfaceRealization = "UML::Interaction::interfaceRealization";

		public static String ownedTrigger = "UML::Interaction::ownedTrigger";

		public static String nestedClassifier = "UML::Interaction::nestedClassifier";

		public static String ownedOperation = "UML::Interaction::ownedOperation";

		public static String isActive = "UML::Interaction::isActive";

		public static String ownedReception = "UML::Interaction::ownedReception";

		public static String isReentrant = "UML::Interaction::isReentrant";

		public static String redefinedBehavior = "UML::Interaction::redefinedBehavior";

		public static String ownedParameter = "UML::Interaction::ownedParameter";

		public static String precondition = "UML::Interaction::precondition";

		public static String postcondition = "UML::Interaction::postcondition";

		public static String ownedParameterSet = "UML::Interaction::ownedParameterSet";

		public static String covered = "UML::Interaction::covered";

		public static String generalOrdering = "UML::Interaction::generalOrdering";

		public static String lifeline = "UML::Interaction::lifeline";

		public static String fragment = "UML::Interaction::fragment";

		public static String action = "UML::Interaction::action";

		public static String formalGate = "UML::Interaction::formalGate";

		public static String message = "UML::Interaction::message";


	}

	/**
	 * Message view descriptor
	 */
	public static class Message {

		public static String ownedComment = "UML::Message::ownedComment";

		public static String name = "UML::Message::name";

		public static String visibility = "UML::Message::visibility";

		public static String clientDependency = "UML::Message::clientDependency";

		public static String messageSort = "UML::Message::messageSort";

		public static String argument = "UML::Message::argument";


	}

	/**
	 * ProtocolTransition view descriptor
	 */
	public static class ProtocolTransition {

		public static String ownedComment = "UML::ProtocolTransition::ownedComment";

		public static String name = "UML::ProtocolTransition::name";

		public static String visibility = "UML::ProtocolTransition::visibility";

		public static String clientDependency = "UML::ProtocolTransition::clientDependency";

		public static String elementImport = "UML::ProtocolTransition::elementImport";

		public static String packageImport = "UML::ProtocolTransition::packageImport";

		public static String ownedRule = "UML::ProtocolTransition::ownedRule";

		public static String isLeaf = "UML::ProtocolTransition::isLeaf";

		public static String kind = "UML::ProtocolTransition::kind";

		public static String trigger = "UML::ProtocolTransition::trigger";


	}

	/**
	 * TimeEvent view descriptor
	 */
	public static class TimeEvent {

		public static String ownedComment = "UML::TimeEvent::ownedComment";

		public static String name = "UML::TimeEvent::name";

		public static String visibility = "UML::TimeEvent::visibility";

		public static String clientDependency = "UML::TimeEvent::clientDependency";

		public static String isRelative = "UML::TimeEvent::isRelative";


	}

	/**
	 * FinalState view descriptor
	 */
	public static class FinalState {

		public static String ownedComment = "UML::FinalState::ownedComment";

		public static String name = "UML::FinalState::name";

		public static String visibility = "UML::FinalState::visibility";

		public static String clientDependency = "UML::FinalState::clientDependency";

		public static String elementImport = "UML::FinalState::elementImport";

		public static String packageImport = "UML::FinalState::packageImport";

		public static String ownedRule = "UML::FinalState::ownedRule";

		public static String isLeaf = "UML::FinalState::isLeaf";

		public static String connection = "UML::FinalState::connection";

		public static String connectionPoint = "UML::FinalState::connectionPoint";

		public static String deferrableTrigger = "UML::FinalState::deferrableTrigger";

		public static String region = "UML::FinalState::region";


	}

	/**
	 * ProtocolConformance view descriptor
	 */
	public static class ProtocolConformance {

		public static String ownedComment = "UML::ProtocolConformance::ownedComment";


	}

	/**
	 * Pseudostate view descriptor
	 */
	public static class Pseudostate {

		public static String ownedComment = "UML::Pseudostate::ownedComment";

		public static String name = "UML::Pseudostate::name";

		public static String visibility = "UML::Pseudostate::visibility";

		public static String clientDependency = "UML::Pseudostate::clientDependency";

		public static String kind = "UML::Pseudostate::kind";


	}

	/**
	 * ConnectionPointReference view descriptor
	 */
	public static class ConnectionPointReference {

		public static String ownedComment = "UML::ConnectionPointReference::ownedComment";

		public static String name = "UML::ConnectionPointReference::name";

		public static String visibility = "UML::ConnectionPointReference::visibility";

		public static String clientDependency = "UML::ConnectionPointReference::clientDependency";

		public static String entry = "UML::ConnectionPointReference::entry";

		public static String exit = "UML::ConnectionPointReference::exit";


	}

	/**
	 * State view descriptor
	 */
	public static class State {

		public static String ownedComment = "UML::State::ownedComment";

		public static String name = "UML::State::name";

		public static String visibility = "UML::State::visibility";

		public static String clientDependency = "UML::State::clientDependency";

		public static String elementImport = "UML::State::elementImport";

		public static String packageImport = "UML::State::packageImport";

		public static String ownedRule = "UML::State::ownedRule";

		public static String isLeaf = "UML::State::isLeaf";

		public static String connection = "UML::State::connection";

		public static String connectionPoint = "UML::State::connectionPoint";

		public static String deferrableTrigger = "UML::State::deferrableTrigger";

		public static String region = "UML::State::region";


	}

	/**
	 * Transition view descriptor
	 */
	public static class Transition {

		public static String ownedComment = "UML::Transition::ownedComment";

		public static String name = "UML::Transition::name";

		public static String visibility = "UML::Transition::visibility";

		public static String clientDependency = "UML::Transition::clientDependency";

		public static String elementImport = "UML::Transition::elementImport";

		public static String packageImport = "UML::Transition::packageImport";

		public static String ownedRule = "UML::Transition::ownedRule";

		public static String isLeaf = "UML::Transition::isLeaf";

		public static String kind = "UML::Transition::kind";

		public static String trigger = "UML::Transition::trigger";


	}

	/**
	 * Region view descriptor
	 */
	public static class Region {

		public static String ownedComment = "UML::Region::ownedComment";

		public static String name = "UML::Region::name";

		public static String visibility = "UML::Region::visibility";

		public static String clientDependency = "UML::Region::clientDependency";

		public static String elementImport = "UML::Region::elementImport";

		public static String packageImport = "UML::Region::packageImport";

		public static String ownedRule = "UML::Region::ownedRule";

		public static String isLeaf = "UML::Region::isLeaf";

		public static String subvertex = "UML::Region::subvertex";

		public static String transition = "UML::Region::transition";


	}

	/**
	 * StateMachine view descriptor
	 */
	public static class StateMachine {

		public static String ownedComment = "UML::StateMachine::ownedComment";

		public static String name = "UML::StateMachine::name";

		public static String visibility = "UML::StateMachine::visibility";

		public static String clientDependency = "UML::StateMachine::clientDependency";

		public static String elementImport = "UML::StateMachine::elementImport";

		public static String packageImport = "UML::StateMachine::packageImport";

		public static String ownedRule = "UML::StateMachine::ownedRule";

		public static String isLeaf = "UML::StateMachine::isLeaf";

		public static String templateBinding = "UML::StateMachine::templateBinding";

		public static String isAbstract = "UML::StateMachine::isAbstract";

		public static String generalization = "UML::StateMachine::generalization";

		public static String powertypeExtent = "UML::StateMachine::powertypeExtent";

		public static String redefinedClassifier = "UML::StateMachine::redefinedClassifier";

		public static String substitution = "UML::StateMachine::substitution";

		public static String collaborationUse = "UML::StateMachine::collaborationUse";

		public static String ownedUseCase = "UML::StateMachine::ownedUseCase";

		public static String useCase = "UML::StateMachine::useCase";

		public static String ownedAttribute = "UML::StateMachine::ownedAttribute";

		public static String ownedConnector = "UML::StateMachine::ownedConnector";

		public static String ownedBehavior = "UML::StateMachine::ownedBehavior";

		public static String interfaceRealization = "UML::StateMachine::interfaceRealization";

		public static String ownedTrigger = "UML::StateMachine::ownedTrigger";

		public static String nestedClassifier = "UML::StateMachine::nestedClassifier";

		public static String ownedOperation = "UML::StateMachine::ownedOperation";

		public static String isActive = "UML::StateMachine::isActive";

		public static String ownedReception = "UML::StateMachine::ownedReception";

		public static String isReentrant = "UML::StateMachine::isReentrant";

		public static String redefinedBehavior = "UML::StateMachine::redefinedBehavior";

		public static String ownedParameter = "UML::StateMachine::ownedParameter";

		public static String precondition = "UML::StateMachine::precondition";

		public static String postcondition = "UML::StateMachine::postcondition";

		public static String ownedParameterSet = "UML::StateMachine::ownedParameterSet";

		public static String region = "UML::StateMachine::region";

		public static String submachineState = "UML::StateMachine::submachineState";

		public static String connectionPoint = "UML::StateMachine::connectionPoint";

		public static String extendedStateMachine = "UML::StateMachine::extendedStateMachine";


	}

	/**
	 * ProtocolStateMachine view descriptor
	 */
	public static class ProtocolStateMachine {

		public static String ownedComment = "UML::ProtocolStateMachine::ownedComment";

		public static String name = "UML::ProtocolStateMachine::name";

		public static String visibility = "UML::ProtocolStateMachine::visibility";

		public static String clientDependency = "UML::ProtocolStateMachine::clientDependency";

		public static String elementImport = "UML::ProtocolStateMachine::elementImport";

		public static String packageImport = "UML::ProtocolStateMachine::packageImport";

		public static String ownedRule = "UML::ProtocolStateMachine::ownedRule";

		public static String isLeaf = "UML::ProtocolStateMachine::isLeaf";

		public static String templateBinding = "UML::ProtocolStateMachine::templateBinding";

		public static String isAbstract = "UML::ProtocolStateMachine::isAbstract";

		public static String generalization = "UML::ProtocolStateMachine::generalization";

		public static String powertypeExtent = "UML::ProtocolStateMachine::powertypeExtent";

		public static String redefinedClassifier = "UML::ProtocolStateMachine::redefinedClassifier";

		public static String substitution = "UML::ProtocolStateMachine::substitution";

		public static String collaborationUse = "UML::ProtocolStateMachine::collaborationUse";

		public static String ownedUseCase = "UML::ProtocolStateMachine::ownedUseCase";

		public static String useCase = "UML::ProtocolStateMachine::useCase";

		public static String ownedAttribute = "UML::ProtocolStateMachine::ownedAttribute";

		public static String ownedConnector = "UML::ProtocolStateMachine::ownedConnector";

		public static String ownedBehavior = "UML::ProtocolStateMachine::ownedBehavior";

		public static String interfaceRealization = "UML::ProtocolStateMachine::interfaceRealization";

		public static String ownedTrigger = "UML::ProtocolStateMachine::ownedTrigger";

		public static String nestedClassifier = "UML::ProtocolStateMachine::nestedClassifier";

		public static String ownedOperation = "UML::ProtocolStateMachine::ownedOperation";

		public static String isActive = "UML::ProtocolStateMachine::isActive";

		public static String ownedReception = "UML::ProtocolStateMachine::ownedReception";

		public static String isReentrant = "UML::ProtocolStateMachine::isReentrant";

		public static String redefinedBehavior = "UML::ProtocolStateMachine::redefinedBehavior";

		public static String ownedParameter = "UML::ProtocolStateMachine::ownedParameter";

		public static String precondition = "UML::ProtocolStateMachine::precondition";

		public static String postcondition = "UML::ProtocolStateMachine::postcondition";

		public static String ownedParameterSet = "UML::ProtocolStateMachine::ownedParameterSet";

		public static String region = "UML::ProtocolStateMachine::region";

		public static String submachineState = "UML::ProtocolStateMachine::submachineState";

		public static String connectionPoint = "UML::ProtocolStateMachine::connectionPoint";

		public static String extendedStateMachine = "UML::ProtocolStateMachine::extendedStateMachine";

		public static String conformance = "UML::ProtocolStateMachine::conformance";


	}

	/**
	 * Actor view descriptor
	 */
	public static class Actor {

		public static String ownedComment = "UML::Actor::ownedComment";

		public static String name = "UML::Actor::name";

		public static String visibility = "UML::Actor::visibility";

		public static String clientDependency = "UML::Actor::clientDependency";

		public static String elementImport = "UML::Actor::elementImport";

		public static String packageImport = "UML::Actor::packageImport";

		public static String ownedRule = "UML::Actor::ownedRule";

		public static String isLeaf = "UML::Actor::isLeaf";

		public static String templateBinding = "UML::Actor::templateBinding";

		public static String isAbstract = "UML::Actor::isAbstract";

		public static String generalization = "UML::Actor::generalization";

		public static String powertypeExtent = "UML::Actor::powertypeExtent";

		public static String redefinedClassifier = "UML::Actor::redefinedClassifier";

		public static String substitution = "UML::Actor::substitution";

		public static String collaborationUse = "UML::Actor::collaborationUse";

		public static String ownedUseCase = "UML::Actor::ownedUseCase";

		public static String useCase = "UML::Actor::useCase";

		public static String ownedBehavior = "UML::Actor::ownedBehavior";

		public static String interfaceRealization = "UML::Actor::interfaceRealization";

		public static String ownedTrigger = "UML::Actor::ownedTrigger";


	}

	/**
	 * ExtensionPoint view descriptor
	 */
	public static class ExtensionPoint {

		public static String ownedComment = "UML::ExtensionPoint::ownedComment";

		public static String name = "UML::ExtensionPoint::name";

		public static String visibility = "UML::ExtensionPoint::visibility";

		public static String clientDependency = "UML::ExtensionPoint::clientDependency";

		public static String isLeaf = "UML::ExtensionPoint::isLeaf";


	}

	/**
	 * Extend view descriptor
	 */
	public static class Extend {

		public static String ownedComment = "UML::Extend::ownedComment";

		public static String name = "UML::Extend::name";

		public static String visibility = "UML::Extend::visibility";

		public static String clientDependency = "UML::Extend::clientDependency";

		public static String extensionLocation = "UML::Extend::extensionLocation";


	}

	/**
	 * Include view descriptor
	 */
	public static class Include {

		public static String ownedComment = "UML::Include::ownedComment";

		public static String name = "UML::Include::name";

		public static String visibility = "UML::Include::visibility";

		public static String clientDependency = "UML::Include::clientDependency";


	}

	/**
	 * UseCase view descriptor
	 */
	public static class UseCase {

		public static String ownedComment = "UML::UseCase::ownedComment";

		public static String name = "UML::UseCase::name";

		public static String visibility = "UML::UseCase::visibility";

		public static String clientDependency = "UML::UseCase::clientDependency";

		public static String elementImport = "UML::UseCase::elementImport";

		public static String packageImport = "UML::UseCase::packageImport";

		public static String ownedRule = "UML::UseCase::ownedRule";

		public static String isLeaf = "UML::UseCase::isLeaf";

		public static String templateBinding = "UML::UseCase::templateBinding";

		public static String isAbstract = "UML::UseCase::isAbstract";

		public static String generalization = "UML::UseCase::generalization";

		public static String powertypeExtent = "UML::UseCase::powertypeExtent";

		public static String redefinedClassifier = "UML::UseCase::redefinedClassifier";

		public static String substitution = "UML::UseCase::substitution";

		public static String collaborationUse = "UML::UseCase::collaborationUse";

		public static String ownedUseCase = "UML::UseCase::ownedUseCase";

		public static String useCase = "UML::UseCase::useCase";

		public static String ownedBehavior = "UML::UseCase::ownedBehavior";

		public static String interfaceRealization = "UML::UseCase::interfaceRealization";

		public static String ownedTrigger = "UML::UseCase::ownedTrigger";

		public static String include = "UML::UseCase::include";

		public static String extend = "UML::UseCase::extend";

		public static String extensionPoint = "UML::UseCase::extensionPoint";

		public static String subject = "UML::UseCase::subject";


	}

	/**
	 * InformationFlow view descriptor
	 */
	public static class InformationFlow {

		public static String ownedComment = "UML::InformationFlow::ownedComment";

		public static String name = "UML::InformationFlow::name";

		public static String visibility = "UML::InformationFlow::visibility";

		public static String clientDependency = "UML::InformationFlow::clientDependency";

		public static String realization = "UML::InformationFlow::realization";

		public static String conveyed = "UML::InformationFlow::conveyed";

		public static String informationSource = "UML::InformationFlow::informationSource";

		public static String informationTarget = "UML::InformationFlow::informationTarget";

		public static String realizingActivityEdge = "UML::InformationFlow::realizingActivityEdge";

		public static String realizingConnector = "UML::InformationFlow::realizingConnector";

		public static String realizingMessage = "UML::InformationFlow::realizingMessage";


	}

	/**
	 * InformationItem view descriptor
	 */
	public static class InformationItem {

		public static String ownedComment = "UML::InformationItem::ownedComment";

		public static String name = "UML::InformationItem::name";

		public static String visibility = "UML::InformationItem::visibility";

		public static String clientDependency = "UML::InformationItem::clientDependency";

		public static String elementImport = "UML::InformationItem::elementImport";

		public static String packageImport = "UML::InformationItem::packageImport";

		public static String ownedRule = "UML::InformationItem::ownedRule";

		public static String isLeaf = "UML::InformationItem::isLeaf";

		public static String templateBinding = "UML::InformationItem::templateBinding";

		public static String isAbstract = "UML::InformationItem::isAbstract";

		public static String generalization = "UML::InformationItem::generalization";

		public static String powertypeExtent = "UML::InformationItem::powertypeExtent";

		public static String redefinedClassifier = "UML::InformationItem::redefinedClassifier";

		public static String substitution = "UML::InformationItem::substitution";

		public static String collaborationUse = "UML::InformationItem::collaborationUse";

		public static String ownedUseCase = "UML::InformationItem::ownedUseCase";

		public static String useCase = "UML::InformationItem::useCase";

		public static String represented = "UML::InformationItem::represented";


	}

	/**
	 * StringExpression view descriptor
	 */
	public static class StringExpression {

		public static String ownedComment = "UML::StringExpression::ownedComment";

		public static String name = "UML::StringExpression::name";

		public static String visibility = "UML::StringExpression::visibility";

		public static String clientDependency = "UML::StringExpression::clientDependency";

		public static String symbol = "UML::StringExpression::symbol";

		public static String operand = "UML::StringExpression::operand";

		public static String templateBinding = "UML::StringExpression::templateBinding";

		public static String subExpression = "UML::StringExpression::subExpression";


	}

	/**
	 * ClassifierTemplateParameter view descriptor
	 */
	public static class ClassifierTemplateParameter {

		public static String ownedComment = "UML::ClassifierTemplateParameter::ownedComment";

		public static String allowSubstitutable = "UML::ClassifierTemplateParameter::allowSubstitutable";


	}

	/**
	 * RedefinableTemplateSignature view descriptor
	 */
	public static class RedefinableTemplateSignature {

		public static String name = "UML::RedefinableTemplateSignature::name";

		public static String visibility = "UML::RedefinableTemplateSignature::visibility";

		public static String isLeaf = "UML::RedefinableTemplateSignature::isLeaf";

		public static String parameter = "UML::RedefinableTemplateSignature::parameter";

		public static String ownedParameter = "UML::RedefinableTemplateSignature::ownedParameter";

		public static String extendedSignature = "UML::RedefinableTemplateSignature::extendedSignature";



	}

	/**
	 * OperationTemplateParameter view descriptor
	 */
	public static class OperationTemplateParameter {

		public static String ownedComment = "UML::OperationTemplateParameter::ownedComment";


	}

	/**
	 * Model view descriptor
	 */
	public static class Model {

		public static String name = "UML::Model::name";

		public static String visibility = "UML::Model::visibility";

		public static String viewpoint = "UML::Model::viewpoint";


		public static String templateBinding = "UML::Model::templateBinding";

		public static String packageMerge = "UML::Model::packageMerge";

		public static String packagedElement = "UML::Model::packagedElement";

		public static String elementImport = "UML::Model::elementImport";

		public static String packageImport = "UML::Model::packageImport";

		public static String ownedRule = "UML::Model::ownedRule";



	}

	/**
	 * ConnectableElementTemplateParameter view descriptor
	 */
	public static class ConnectableElementTemplateParameter {

		public static String ownedComment = "UML::ConnectableElementTemplateParameter::ownedComment";


	}

	/**
	 * TemplateParameterSubstitution view descriptor
	 */
	public static class TemplateParameterSubstitution {

		public static String ownedComment = "UML::TemplateParameterSubstitution::ownedComment";

		public static String actual = "UML::TemplateParameterSubstitution::actual";

		public static String ownedActual = "UML::TemplateParameterSubstitution::ownedActual";


	}

	/**
	 * TemplateParameter view descriptor
	 */
	public static class TemplateParameter {

	}

	/**
	 * TemplateSignature view descriptor
	 */
	public static class TemplateSignature {

		public static String ownedComment = "UML::TemplateSignature::ownedComment";

		public static String parameter = "UML::TemplateSignature::parameter";

		public static String ownedParameter = "UML::TemplateSignature::ownedParameter";


	}

	/**
	 * TemplateBinding view descriptor
	 */
	public static class TemplateBinding {

		public static String parameterSubstitution = "UML::TemplateBinding::parameterSubstitution";


	}

	/**
	 * ProfileApplication view descriptor
	 */
	public static class ProfileApplication {

		public static String ownedComment = "UML::ProfileApplication::ownedComment";

		public static String isStrict = "UML::ProfileApplication::isStrict";


	}

	/**
	 * Profile view descriptor
	 */
	public static class Profile {

		public static String ownedComment = "UML::Profile::ownedComment";

		public static String name = "UML::Profile::name";

		public static String visibility = "UML::Profile::visibility";

		public static String clientDependency = "UML::Profile::clientDependency";

		public static String elementImport = "UML::Profile::elementImport";

		public static String packageImport = "UML::Profile::packageImport";

		public static String ownedRule = "UML::Profile::ownedRule";

		public static String templateBinding = "UML::Profile::templateBinding";

		public static String packageMerge = "UML::Profile::packageMerge";

		public static String packagedElement = "UML::Profile::packagedElement";

		public static String profileApplication = "UML::Profile::profileApplication";

		public static String metaclassReference = "UML::Profile::metaclassReference";

		public static String metamodelReference = "UML::Profile::metamodelReference";


	}

	/**
	 * Image view descriptor
	 */
	public static class Image {

		public static String ownedComment = "UML::Image::ownedComment";

		public static String content = "UML::Image::content";

		public static String location = "UML::Image::location";

		public static String format = "UML::Image::format";


	}

	/**
	 * Stereotype view descriptor
	 */
	public static class Stereotype {

		public static String ownedComment = "UML::Stereotype::ownedComment";

		public static String name = "UML::Stereotype::name";

		public static String visibility = "UML::Stereotype::visibility";

		public static String clientDependency = "UML::Stereotype::clientDependency";

		public static String elementImport = "UML::Stereotype::elementImport";

		public static String packageImport = "UML::Stereotype::packageImport";

		public static String ownedRule = "UML::Stereotype::ownedRule";

		public static String isLeaf = "UML::Stereotype::isLeaf";

		public static String templateBinding = "UML::Stereotype::templateBinding";

		public static String isAbstract = "UML::Stereotype::isAbstract";

		public static String generalization = "UML::Stereotype::generalization";

		public static String powertypeExtent = "UML::Stereotype::powertypeExtent";

		public static String redefinedClassifier = "UML::Stereotype::redefinedClassifier";

		public static String substitution = "UML::Stereotype::substitution";

		public static String collaborationUse = "UML::Stereotype::collaborationUse";

		public static String ownedUseCase = "UML::Stereotype::ownedUseCase";

		public static String useCase = "UML::Stereotype::useCase";

		public static String ownedAttribute = "UML::Stereotype::ownedAttribute";

		public static String ownedConnector = "UML::Stereotype::ownedConnector";

		public static String ownedBehavior = "UML::Stereotype::ownedBehavior";

		public static String interfaceRealization = "UML::Stereotype::interfaceRealization";

		public static String ownedTrigger = "UML::Stereotype::ownedTrigger";

		public static String nestedClassifier = "UML::Stereotype::nestedClassifier";

		public static String ownedOperation = "UML::Stereotype::ownedOperation";

		public static String isActive = "UML::Stereotype::isActive";

		public static String ownedReception = "UML::Stereotype::ownedReception";

		public static String icon = "UML::Stereotype::icon";


	}

	/**
	 * ExtensionEnd view descriptor
	 */
	public static class ExtensionEnd {

		public static String ownedComment = "UML::ExtensionEnd::ownedComment";

		public static String name = "UML::ExtensionEnd::name";

		public static String visibility = "UML::ExtensionEnd::visibility";

		public static String clientDependency = "UML::ExtensionEnd::clientDependency";

		public static String isLeaf = "UML::ExtensionEnd::isLeaf";

		public static String isStatic = "UML::ExtensionEnd::isStatic";

		public static String isOrdered = "UML::ExtensionEnd::isOrdered";

		public static String isUnique = "UML::ExtensionEnd::isUnique";

		public static String isReadOnly = "UML::ExtensionEnd::isReadOnly";

		public static String deployment = "UML::ExtensionEnd::deployment";

		public static String isDerived = "UML::ExtensionEnd::isDerived";

		public static String isDerivedUnion = "UML::ExtensionEnd::isDerivedUnion";

		public static String aggregation = "UML::ExtensionEnd::aggregation";

		public static String redefinedProperty = "UML::ExtensionEnd::redefinedProperty";

		public static String subsettedProperty = "UML::ExtensionEnd::subsettedProperty";

		public static String qualifier = "UML::ExtensionEnd::qualifier";


	}

	/**
	 * Extension view descriptor
	 */
	public static class Extension {

		public static String ownedComment = "UML::Extension::ownedComment";

		public static String name = "UML::Extension::name";

		public static String visibility = "UML::Extension::visibility";

		public static String clientDependency = "UML::Extension::clientDependency";

		public static String elementImport = "UML::Extension::elementImport";

		public static String packageImport = "UML::Extension::packageImport";

		public static String ownedRule = "UML::Extension::ownedRule";

		public static String isLeaf = "UML::Extension::isLeaf";

		public static String templateBinding = "UML::Extension::templateBinding";

		public static String isAbstract = "UML::Extension::isAbstract";

		public static String generalization = "UML::Extension::generalization";

		public static String powertypeExtent = "UML::Extension::powertypeExtent";

		public static String redefinedClassifier = "UML::Extension::redefinedClassifier";

		public static String substitution = "UML::Extension::substitution";

		public static String collaborationUse = "UML::Extension::collaborationUse";

		public static String ownedUseCase = "UML::Extension::ownedUseCase";

		public static String useCase = "UML::Extension::useCase";

		public static String ownedEnd = "UML::Extension::ownedEnd";

		public static String memberEnd = "UML::Extension::memberEnd";

		public static String isDerived = "UML::Extension::isDerived";

		public static String navigableOwnedEnd = "UML::Extension::navigableOwnedEnd";


	}

	/**
	 * Comments view descriptor
	 */
	public static class Comments {

		public static String ownedComment = "UML::Comments::ownedComment";


	}

}
