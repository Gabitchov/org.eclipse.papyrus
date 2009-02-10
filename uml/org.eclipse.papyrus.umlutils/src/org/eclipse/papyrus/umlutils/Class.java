/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

//FIXME How to manage circular inclusions?
/**
 * 
 * 
 * 
 * 
 * This class represents a class and encapsulates an org.eclipse.uml2.uml.Class object
 */
public class Class extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Class uml2Class;

	/**
	 * 
	 * 
	 * @param uml2Class
	 */
	public Class(org.eclipse.uml2.uml.Class uml2Class) {
		super(uml2Class);
		this.uml2Class = uml2Class;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Class.
	 */
	public org.eclipse.uml2.uml.Class getUml2Class() {
		return uml2Class;
	}

	/**
	 * Gives the Class full name. The full name is the class name prefixed by the package name if needed
	 * 
	 * @return The class full name
	 */
	@Override
	public String getFullName() {
		String fullName = getName();
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			if (parentPackage.namespace()) {
				fullName = parentPackage.getFullName() + "_" + fullName;
			}
		}
		return fullName;
	}

	/**
	 * Get the package that owns the class.
	 * 
	 * @return the package taht owns the class (null if none)
	 */
	public Package getPackage() {
		Package parent = null;
		org.eclipse.uml2.uml.Package u2parent = uml2Class.getPackage();
		if (u2parent != null) {
			if (!(u2parent instanceof org.eclipse.uml2.uml.Model)) {
				parent = new Package(u2parent);
			}
		}
		return parent;
	}

	/**
	 * Creates an owned operation, given specific parameters.
	 * 
	 * @param type
	 *            the type
	 * @param visibilityValue
	 * @param name
	 *            name of the operation
	 * 
	 * @return the created property
	 */
	public org.eclipse.papyrus.umlutils.Property createOwnedProperty(String name, org.eclipse.uml2.uml.Type type, int visibilityValue) {

		org.eclipse.uml2.uml.Property attribute = getUml2Class().createOwnedAttribute(name, type, UMLPackage.eINSTANCE.getProperty());
		attribute.setVisibility(VisibilityKind.get(visibilityValue));

		return new org.eclipse.papyrus.umlutils.Property(attribute);
	}

	/**
	 * Creates an owned operation, given specific parameters.
	 * 
	 * @param newProperty
	 * @param type
	 *            the type
	 * @param name
	 *            name of the operation
	 * 
	 * @return the created property
	 */
	public org.eclipse.papyrus.umlutils.Property createOwnedProperty(final org.eclipse.uml2.uml.Property newProperty) {

		org.eclipse.uml2.uml.Property property = (org.eclipse.uml2.uml.Property) EcoreUtil.copy(newProperty);
		getUml2Class().getOwnedAttributes().add(property);

		return (new org.eclipse.papyrus.umlutils.Property(property));
	}

	/**
	 * create an owned Enumeration in this class TODO doesn't work... pb to allocate the enumeration
	 * 
	 * @param visibilityValue
	 * @param visbility
	 *            the visibility kind
	 * @param name
	 *            the enumeration name
	 * 
	 * @return the created enumeration
	 */
	public org.eclipse.papyrus.umlutils.Enumeration createOwnedEnumeration(String name, int visibilityValue) {

		org.eclipse.uml2.uml.Enumeration uml2enumeration = UMLFactory.eINSTANCE.createEnumeration();
		// Set name of new enum
		uml2enumeration.setName(name);
		uml2enumeration.setVisibility(VisibilityKind.get(visibilityValue));
		// Add enum to current class
		getUml2Class().getNestedClassifiers().add(uml2enumeration);

		return new org.eclipse.papyrus.umlutils.Enumeration(uml2enumeration);
	}

	/**
	 * Creates an owned operation, given specific parameters.
	 * 
	 * @param returnType
	 *            , type of the return value. If null, no return value is assigned
	 * @param visibilityValue
	 *            the kind of visibility
	 * @param returnType
	 * @param name
	 *            name of the operation
	 * 
	 * @return the created operation
	 */
	public org.eclipse.papyrus.umlutils.Operation createOwnedOperation(String name, int visibilityValue, org.eclipse.uml2.uml.Type returnType) {
		org.eclipse.uml2.uml.Operation operation = getUml2Class().createOwnedOperation(name, null, null, returnType);
		operation.setName(name);
		operation.setVisibility(VisibilityKind.get(visibilityValue));

		if (operation.getReturnResult() != null) {
			operation.getReturnResult().setName("returnParameter");
		}

		return new org.eclipse.papyrus.umlutils.Operation(operation);
	}

	/**
	 * Creates an owned operation, given specific parameters.
	 * 
	 * @param newOperation
	 *            the operation to copy
	 * 
	 * @return the created operation
	 */
	public org.eclipse.papyrus.umlutils.Operation createOwnedOperation(final org.eclipse.uml2.uml.Operation newOperation) {

		org.eclipse.uml2.uml.Operation operation = (org.eclipse.uml2.uml.Operation) EcoreUtil.copy(newOperation);
		getUml2Class().getOwnedOperations().add(operation);

		return (new org.eclipse.papyrus.umlutils.Operation(operation));
	}

	/**
	 * Creates an owned attribute by copy of a given attribute copies the name, type, visibility, and qualifier (static).
	 * 
	 * @param attributeSource
	 * 
	 * @return the created property
	 */
	public org.eclipse.papyrus.umlutils.Property createOwnedAttributeFrom(org.eclipse.uml2.uml.Property attributeSource) {

		org.eclipse.uml2.uml.Property attribute = getUml2Class().createOwnedAttribute(attributeSource.getName(), attributeSource.getType());
		attribute.setIsStatic(attributeSource.isStatic());
		attribute.setVisibility(attributeSource.getVisibility());

		return new org.eclipse.papyrus.umlutils.Property(attribute);
	}

	/**
	 * Creates an owned attribute with.
	 * 
	 * @param isStatic
	 * @param type
	 * @param visibilityKind
	 * @param name
	 * 
	 * @return the created property
	 */
	public org.eclipse.papyrus.umlutils.Property createOwnedAttribute(String name, org.eclipse.uml2.uml.Type type, org.eclipse.uml2.uml.VisibilityKind visibilityKind, boolean isStatic) {

		org.eclipse.uml2.uml.Property attribute = getUml2Class().createOwnedAttribute(name, type);
		attribute.setIsStatic(isStatic);
		attribute.setVisibility(visibilityKind);

		return new org.eclipse.papyrus.umlutils.Property(attribute);
	}

	/**
	 * Check what header are needed by the class. Provides a set of String, each string is the full path of the needed header. Used by C code generator
	 * 
	 * @return A set of String.
	 */
	public Set<String> getNeededHeaders() {
		Set<String> includes = new HashSet<String>();
		// Browse through the attributes
		Iterator attributesIterator = getAttributes(null, null, null, false).iterator();
		// Property currentProperty;
		Property currentAttribute;
		Type currentType;
		Class usedClass;
		Interface usedInterface;

		while (attributesIterator.hasNext()) {
			currentAttribute = (Property) attributesIterator.next();
			currentType = currentAttribute.getType();
			if (currentType != null) {

				if (currentType.isClass()) {
					usedClass = currentType.getTypeClass();
					includes.add(usedClass.getHeaderPath());
				}

				if (currentType.isInterface()) {
					usedInterface = currentType.getTypeInterface();
					includes.add(usedInterface.getHeaderPath());
				}
			}
		}

		// Browse through the operation parameters
		Iterator operationsIterator = getOperations(null, null, null, null, true).iterator();
		Operation currentOperation;

		// Browse through operations
		while (operationsIterator.hasNext()) {
			currentOperation = (Operation) operationsIterator.next();
			Iterator parametersIteretor = currentOperation.getParameters().iterator();
			Parameter currentParameter;

			// Browse through parameters
			while (parametersIteretor.hasNext()) {
				currentParameter = (Parameter) parametersIteretor.next();
				currentType = currentParameter.getType();

				if (currentType != null) {

					if (currentType.isClass()) {
						usedClass = currentParameter.getType().getTypeClass();
						includes.add(usedClass.getHeaderPath());
					}
				}
			}
		}

		// Get includes from bounded templates
		if (isTemplateBoundElement()) {
			EList tb = uml2Class.getTemplateBindings();

			if ((tb != null) && !tb.isEmpty()) {
				Iterator itb = tb.iterator();
				TemplateBinding currentTb;
				// For each binding add all the attributes of the template to the
				// attribute list and add the source(unparametred) and
				// destination (parametred) types to their lists.

				while (itb.hasNext()) {
					currentTb = (TemplateBinding) itb.next();
					// Template from template binding
					EList templates = currentTb.getTargets();
					Class templateClass = new Class((org.eclipse.uml2.uml.Class) ((TemplateSignature) templates.get(0)).getOwner());

					includes.add(templateClass.getHeaderPath());
				}
			}
		}

		return includes;
	}

	/**
	 * Provide the includes to get visibility on this class. Provides the full path of the .h file from the source directory. So the source directory has to be a default include directory (see
	 * compiler configuration).
	 * 
	 * @return the full path of the .h file.
	 */
	public String getHeaderPath() {
		String include = getFullName();
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			if (!parentPackage.hasStereotype("cRoot")) {
				include = parentPackage.getName() + "/" + include;
			}
		}
		return include + ".h";
	}

	/**
	 * Gives the full path of the Package this class belongs to.
	 * 
	 * @return A String representing the full path to the package from the root folder of the project.
	 */
	public String getPackagePath() {
		String path = "";
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			path = parentPackage.getPath();
		}
		return path;
	}

	/**
	 * Gives all the attributes of the class matching the given criterions. If a criterion is null, then don't care about this value.
	 * 
	 * @param isStatic
	 *            Are the attributes static or not.
	 * @param unappliedStereotypes
	 *            The attributes musn't have these stereotypes to be selected.
	 * @param appliedStereotypes
	 *            The attributes must have these stereotypes to be selected.
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Property.
	 */
	public Collection<Property> getAttributes(Boolean isStatic, String[] appliedStereotypes, String[] unappliedStereotypes) {

		Collection<Property> result = new ArrayList<Property>();
		Iterator uml2Attributes = uml2Class.getAttributes().iterator();
		Property currentAttribute;
		boolean getIt;

		while (uml2Attributes.hasNext()) {
			getIt = true;
			currentAttribute = new Property((org.eclipse.uml2.uml.Property) uml2Attributes.next());

			// Static or not?
			if (isStatic != null) {
				getIt = getIt && (currentAttribute.isStatic() == isStatic.booleanValue());
			}

			// Applied stereotypes
			if (appliedStereotypes != null) {
				for (int i = 0; i < appliedStereotypes.length; i++) {
					getIt = getIt && currentAttribute.hasStereotype(appliedStereotypes[i]);
				}
			}

			// Unapplied stereotypes
			if (unappliedStereotypes != null) {
				for (int i = 0; i < unappliedStereotypes.length; i++) {
					getIt = getIt && !currentAttribute.hasStereotype(unappliedStereotypes[i]);
				}
			}
			if (getIt) {
				result.add(currentAttribute);
			}
		}
		return result;
	}

	/**
	 * Gives all the attributes of the class matching the given criterions. If a criterion is null, then don't care about this value.
	 * 
	 * @param isStatic
	 *            Are the attributes static or not.
	 * @param unappliedStereotypes
	 *            The attributes musn't have these stereotypes to be selected.
	 * @param getFromParents
	 * @param appliedStereotypes
	 *            The attributes must have these stereotypes to be selected.
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Property.
	 */
	public Collection<Property> getAttributes(Boolean isStatic, String[] appliedStereotypes, String[] unappliedStereotypes, boolean getFromParents) {

		Collection<Property> result = getAttributes(isStatic, appliedStereotypes, unappliedStereotypes);

		// If needed, get the attributes from the superclasses
		// FIXME: do not add attributes that are already inherited!!!
		if (getFromParents) {
			Iterator superclassesIterator = getParents().iterator();
			Class currentSuperclass;
			Object currentObject;
			while (superclassesIterator.hasNext()) {
				currentObject = superclassesIterator.next();
				if (currentObject instanceof Class) {
					currentSuperclass = (Class) currentObject;
					result.addAll(currentSuperclass.getAttributes(isStatic, appliedStereotypes, unappliedStereotypes, true));
				}
			}
		}
		return result;
	}

	/**
	 * Return a set of Attributes owned by current class dependening on a specified visibility.
	 * 
	 * @param visibility
	 *            may be "", "public", "private" or "protected")
	 * @param visibilityAtt
	 * 
	 * @return A Set of com.cea.papyrus.umlutils.Property.
	 */
	public Collection<Property> getAttributes(String visibilityAtt) {
		Collection<Property> result = new ArrayList<Property>();

		// Parse all attributes
		Iterator uml2Attributes = uml2Class.getAttributes().iterator();
		Property currentAttribute;

		while (uml2Attributes.hasNext()) {
			currentAttribute = new Property((org.eclipse.uml2.uml.Property) uml2Attributes.next());

			if (visibilityAtt.equals("")) {
				// Retrieve everything
				result.add(currentAttribute);
			} else {
				// get visibility of the attribute
				String currentVisibility = currentAttribute.getVisibility().getValue();
				if (visibilityAtt == currentVisibility) {
					result.add(currentAttribute);
				}
			}
		}

		return result;
	}

	/**
	 * Get a list of operations that match the given criterions. For any criterion : a null values means this criterion can have any value.
	 * 
	 * @param visibility
	 *            The operation visibility qualifier
	 * @param isAbstract
	 *            The operation is/isn't abstract
	 * @param unappliedStereotypes
	 *            the operation musn't have those stereotype
	 * @param appliedStereotypes
	 *            the operation must have those stereotypes
	 * 
	 * @return The list of all the operations (Class com.cea.papyrus.umlutils.Operation) matching the criterions.
	 */
	public List<Operation> getOperations(Integer visibility, Boolean isAbstract, String[] appliedStereotypes, String[] unappliedStereotypes) {

		ArrayList<Operation> op = new ArrayList<Operation>();
		boolean takeIt = true;
		Iterator operationIterator = uml2Class.getOwnedOperations().iterator();
		org.eclipse.uml2.uml.Operation currentUml2Operation;
		Operation currentOperation;

		while (operationIterator.hasNext()) {
			takeIt = true;
			currentUml2Operation = (org.eclipse.uml2.uml.Operation) operationIterator.next();
			currentOperation = new Operation(currentUml2Operation);

			// Visibility
			if (visibility != null) {
				takeIt = takeIt && (currentOperation.getVisibility() == visibility.intValue());
			}

			// Abstract
			if (isAbstract != null) {
				takeIt = takeIt && (currentOperation.isAbstract() == isAbstract.booleanValue());
			}

			// AppliedStrereotypes
			if (appliedStereotypes != null) {
				for (int i = 0; i < appliedStereotypes.length; i++) {
					takeIt = takeIt && currentOperation.hasStereotype(appliedStereotypes[i]);
				}
			}

			// UnappliedStereotypes
			if (unappliedStereotypes != null) {
				for (int i = 0; i < unappliedStereotypes.length; i++) {
					takeIt = takeIt && !currentOperation.hasStereotype(unappliedStereotypes[i]);
				}
			}

			if (takeIt) {
				op.add(currentOperation);
			}
		}
		return op;
	}

	/**
	 * Get a list of operations that match the given criterions. For any criterion : a null values means this criterion can have any value.
	 * 
	 * @param visibility
	 *            The operation visibility qualifier
	 * @param isAbstract
	 *            The operation is/isn't abstract
	 * @param unappliedStereotypes
	 *            the operation musn't have those stereotype
	 * @param appliedStereotypes
	 *            the operation must have those stereotypes
	 * @param inherited
	 *            also get the operations inherited from the superclasses? Using this option will cause a recurive call to getOperations on any Class or interface this Class inherit from.
	 * 
	 * @return The list of all the operations (Class com.cea.papyrus.umlutils.Operation) matching the criterions.
	 */
	public List<Operation> getOperations(Integer visibility, Boolean isAbstract, String[] appliedStereotypes, String[] unappliedStereotypes, boolean inherited) {

		// Get the operations from this class
		List<Operation> op = getOperations(visibility, isAbstract, appliedStereotypes, unappliedStereotypes);

		// If the class inherits from another, get the operations of the parent
		// class.
		if (inherited) {
			op = addInheritedOperations(visibility, isAbstract, appliedStereotypes, unappliedStereotypes, op);
		}
		return op;
	}

	/**
	 * Add to a givne Collection the operations inherited from parent superclasses and implemented interfaces. Only operations matching the given criterions are added.
	 * 
	 * @param op
	 *            The list opf operations to be extended.
	 * @param visibility
	 *            The operation visibility qualifier
	 * @param isAbstract
	 *            The operation is/isn't abstract
	 * @param unappliedStereotypes
	 *            the operation musn't have those stereotype
	 * @param appliedStereotypes
	 *            the operation must have those stereotypes
	 * 
	 * @return A java.util.List of com.cea.papyrus.umlutils.Operation.
	 */
	public List<Operation> addInheritedOperations(Integer visibility, Boolean isAbstract, String[] appliedStereotypes, String[] unappliedStereotypes, List<Operation> op) {

		// Get operations inherited from superclasses
		op = addOperationsFromSuperClasses(visibility, isAbstract, appliedStereotypes, unappliedStereotypes, op);
		// Get operations inherited from interfaces.
		op = addOperationsFromInterfaces(visibility, isAbstract, appliedStereotypes, unappliedStereotypes, op);

		return op;
	}

	/**
	 * Add to the given operations list the operations inherited from the superclasses of this class.
	 * 
	 * @param op
	 *            The list opf operations to be extended.
	 * @param visibility
	 *            The operation visibility qualifier
	 * @param isAbstract
	 *            The operation is/isn't abstract
	 * @param unappliedStereotypes
	 *            the operation musn't have those stereotype
	 * @param appliedStereotypes
	 *            the operation must have those stereotypes
	 * 
	 * @return A java.util.List of com.cea.papyrus.umlutils.Operation.
	 */
	public List<Operation> addOperationsFromInterfaces(Integer visibility, Boolean isAbstract, String[] appliedStereotypes, String[] unappliedStereotypes, List<Operation> op) {

		Iterator operationsIterator;
		Operation currentOperation;
		// Get the operations inherited from the implemented Interfaces.
		// Only abstract operations can be inherited from Interfaces.
		if (isAbstract != null) {
			if (isAbstract.booleanValue()) {
				Iterator implementedInterfaces = getInterfaces().iterator();
				// If no visibility is defined only take public and protected
				// operations
				if (visibility != null) {
					if (visibility.intValue() != VisibilityKind.PRIVATE) {
						// Implemented interfaces loop
						while (implementedInterfaces.hasNext()) {
							Interface currentInterface = (Interface) implementedInterfaces.next();
							// All the operations from an Interface are abstract.
							Collection operations = currentInterface.getOperations(visibility, null, appliedStereotypes, unappliedStereotypes);
							operationsIterator = operations.iterator();
							while (operationsIterator.hasNext()) {
								currentOperation = (Operation) operationsIterator.next();
								if (!containsOperation(op, currentOperation)) {
									op.add(currentOperation);
								}
							}
						}// End Implemented interfaces loop
					}
				}
				// No specific visibility selected, get only public and protected
				// operations. Private operations should never be inherited.
				else {
					// Implemented interfaces loop
					while (implementedInterfaces.hasNext()) {
						Interface currentInterface = (Interface) implementedInterfaces.next();
						// All the operations from an Interface are abstract.
						Collection operations = currentInterface.getOperations(new Integer(VisibilityKind.PUBLIC), null, appliedStereotypes, unappliedStereotypes);
						operationsIterator = operations.iterator();
						// Public operations loop
						while (operationsIterator.hasNext()) {
							currentOperation = (Operation) operationsIterator.next();
							if (!containsOperation(op, currentOperation)) {
								op.add(currentOperation);
							}
						}// End Public operations loop

						operations = currentInterface.getOperations(new Integer(VisibilityKind.PROTECTED), null, appliedStereotypes, unappliedStereotypes);
						operationsIterator = operations.iterator();
						// Protected operations loop
						while (operationsIterator.hasNext()) {
							currentOperation = (Operation) operationsIterator.next();
							if (!containsOperation(op, currentOperation)) {
								op.add(currentOperation);
							}
						}// End Protected operations loop
					}// End implemented interfaces loop
				}// End visibility not selected (any)
			}
		}
		return op;
	}

	/**
	 * Add to the given operations list the operations inherited from the interfaces implemented by this class.
	 * 
	 * @param op
	 *            The list opf operations to be extended.
	 * @param visibility
	 *            The operation visibility qualifier
	 * @param isAbstract
	 *            The operation is/isn't abstract
	 * @param unappliedStereotypes
	 *            the operation musn't have those stereotype
	 * @param appliedStereotypes
	 *            the operation must have those stereotypes
	 * 
	 * @return A java.util.List of com.cea.papyrus.umlutils.Operation.
	 */
	public List<Operation> addOperationsFromSuperClasses(Integer visibility, Boolean isAbstract, String[] appliedStereotypes, String[] unappliedStereotypes, List<Operation> op) {

		Iterator superclassesIterator = getParents().iterator();
		Class currentSuperClass;
		Collection tempList;
		Iterator operationsIterator;
		Operation currentOperation;
		// Browse all the superclasses
		while (superclassesIterator.hasNext()) {
			currentSuperClass = (Class) superclassesIterator.next();

			// Visibility not selected - take public and protected operations
			if (visibility == null) {
				tempList = currentSuperClass.getOperations(new Integer(VisibilityKind.PROTECTED), isAbstract, appliedStereotypes, unappliedStereotypes, true);
				operationsIterator = tempList.iterator();
				// Browse the operations. For virtual operations, if many
				// operations have the same name, only take the first
				// operation found (ie the most specialized)

				// Protected operations loop
				while (operationsIterator.hasNext()) {
					currentOperation = (Operation) operationsIterator.next();
					if (currentOperation.isAbstract() || currentOperation.isVirtual()) {
						if (!containsOperation(op, currentOperation)) {
							op.add(currentOperation);
						}
					}
				}// End protected operations loop
				tempList = currentSuperClass.getOperations(new Integer(VisibilityKind.PUBLIC), isAbstract, appliedStereotypes, unappliedStereotypes, true);
				operationsIterator = tempList.iterator();
				// Browse the operations. For virtual operations, if many
				// operations have the same name, only take the first
				// operation found (ie the most specialized)

				// Public Operations loop
				while (operationsIterator.hasNext()) {
					currentOperation = (Operation) operationsIterator.next();
					if (currentOperation.isAbstract() || currentOperation.isVirtual()) {
						if (!containsOperation(op, currentOperation)) {
							op.add(currentOperation);
						}
					}
				}// End Public Operations loop
			}// End Visibility not selected
			else {
				// If no visibility is defined only take public and protected
				// operations
				if (visibility.intValue() != VisibilityKind.PRIVATE) {
					tempList = currentSuperClass.getOperations(visibility, isAbstract, appliedStereotypes, unappliedStereotypes);
					operationsIterator = tempList.iterator();
					// Browse the operations. For virtual operations, if many
					// operations have the same name, only take the first
					// operation found (ie the most specialized)

					// Operation loop
					while (operationsIterator.hasNext()) {
						currentOperation = (Operation) operationsIterator.next();
						if (currentOperation.isAbstract() || currentOperation.isVirtual()) {
							if (!containsOperation(op, currentOperation)) {
								op.add(currentOperation);
							}
						}
					}// End operation loop
				}
			}// End visibility not selected
		}// End Browse through Superclasses

		return op;
	}

	/**
	 * Is this class staticly or dynamicly instanciated.
	 * 
	 * @return
	 */
	public boolean isDynamic() {
		return hasStereotype("dynamicInstanciation");
	}

	/**
	 * Tells if this class uses the glib.
	 * 
	 * @return
	 */
	public boolean useGlib() {
		boolean glib = isDynamic();

		Package parent = getPackage();
		if (parent != null) {
			glib = glib && parent.usesGlib();
		}
		return glib;
	}

	/**
	 * Tells if this class can use c99 specific types.
	 * 
	 * @return
	 */
	public boolean useC99() {
		return getModel().useC99();
	}

	/**
	 * Tells if the Class has the stereotype <<functionToFile>>.
	 * 
	 * @return
	 */
	public boolean isFunctionToFile() {
		return hasStereotype("functionToFile");
	}

	/**
	 * Get all the classes that are superclasses of this class.
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Class
	 */
	public Collection<Class> getParents() {
		Collection<Class> parents = new ArrayList<Class>();
		Iterator superclassesIterator;
		EList superclasses = uml2Class.getSuperClasses();
		Class currentClass;
		if (superclasses != null) {
			superclassesIterator = superclasses.iterator();
			while (superclassesIterator.hasNext()) {
				currentClass = new Class((org.eclipse.uml2.uml.Class) superclassesIterator.next());
				parents.add(currentClass);
				parents.addAll(currentClass.getParents());
			}
		}
		return parents;
	}

	/**
	 * Get all the classes that are direct superclasses of this class.
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Class
	 */
	public Collection<Class> getSuperClasses() {
		Collection<Class> parents = new ArrayList<Class>();
		Iterator superclassesIterator = uml2Class.getSuperClasses().iterator();
		Class currentClass;
		while (superclassesIterator.hasNext()) {
			currentClass = new Class((org.eclipse.uml2.uml.Class) superclassesIterator.next());
			parents.add(currentClass);
		}
		return parents;
	}

	/**
	 * Gives the interfaces implemented by this class.
	 * 
	 * @return A Collection of com.cea.papyrus.umlutils.Interface.
	 */
	public Collection<Interface> getImplementedInterfaces() {
		// Collection interfaces = new HashSet();
		// Iterator interfacesIterator = uml2Class.getImplementedInterfaces().iterator();
		// Interface currentInterface;
		// while(interfacesIterator.hasNext()){
		// currentInterface = new Interface(
		// (org.eclipse.uml2.uml.Interface) interfacesIterator.next() );
		// interfaces.add(currentInterface);
		// }
		return null;
	}

	/**
	 * Check if a collection of operations contains a given operation. Usefull to avoid declaring many times the same virtual operation.
	 * 
	 * @param o
	 *            An operation
	 * @param c
	 *            A collection of operations.
	 * 
	 * @return
	 */
	public boolean containsOperation(Collection<Operation> c, Operation o) {
		boolean found = false;
		Iterator i = c.iterator();
		Operation currentOperation;
		while (i.hasNext() && !found) {
			currentOperation = (Operation) i.next();
			found = currentOperation.getName().equals(o.getName());
		}
		return found;
	}

	/**
	 * Gives the interfaces implemented by this class.
	 * 
	 * @return A Collection of com.cea.papyrus.umlutils.Interface.
	 */
	public Collection<Interface> getInterfaces() {
		// Collection interfaces = new HashSet();
		// Iterator interfacesIterator = uml2Class.getImplementedInterfaces().iterator();
		// Interface currentInterface;
		// while(interfacesIterator.hasNext()){
		// currentInterface = new Interface(
		// (org.eclipse.uml2.uml.Interface) interfacesIterator.next() );
		// interfaces.add(currentInterface);
		// interfaces.addAll(currentInterface.getSuperInterfaces());
		// }
		// Class currentClass;
		// Iterator superClassesIterator = getParents().iterator();
		// while(superClassesIterator.hasNext()){
		// currentClass = (Class)superClassesIterator.next();
		// interfaces.addAll(currentClass.getInterfaces());
		// }
		// return interfaces;
		return null;
	}

	/**
	 * Gives the operations that are implementations of abstract operations.
	 * 
	 * @return A collection of com.cea.papyrus.umlutils.Operation.
	 */
	public Collection<Operation> getImplementedAbstractOperations() {

		Collection<Operation> implementedAbstract = new ArrayList<Operation>();
		String[] unappliedStereotypes = new String[1];
		unappliedStereotypes[0] = "nocode";
		List<Operation> abstractOperations = getOperations(null, Boolean.TRUE, null, unappliedStereotypes, true);
		List<Operation> ownedOperations = getOperations(null, Boolean.FALSE, null, unappliedStereotypes, false);

		Iterator ownedIterator = ownedOperations.iterator();
		Operation currentOwnedOperation;
		while (ownedIterator.hasNext()) {

			currentOwnedOperation = (Operation) ownedIterator.next();
			if (containsOperation(abstractOperations, currentOwnedOperation) && !containsOperation(implementedAbstract, currentOwnedOperation)) {
				implementedAbstract.add(currentOwnedOperation);
			}
		}

		return implementedAbstract;
	}

	/**
	 * Tells if the class is a simple C structure.
	 * 
	 * @return
	 */
	public boolean isStruct() {
		return hasStereotype("struct");
	}

	/**
	 * Tells if the class is a C union.
	 * 
	 * @return
	 */
	public boolean isUnion() {
		return hasStereotype("union");
	}

	/**
	 * Gives the model that own the class.
	 * 
	 * @return
	 * 
	 * @deprecated replaced by Element.getModel()
	 */
	@Deprecated
	@Override
	public Model getModel() {
		return new Model(uml2Class.getModel());
	}

	// /**
	// * @param operation
	// * @param name
	// * @param isReentrant
	// * @return
	// * @deprecated use createActivity(Operation operation, String language, String name, boolean isReentrant) instead
	// */
	// public Activity createActivity(Operation operation, String name, boolean isReentrant) {
	// org.eclipse.uml2.uml.Activity uml2Activity = (org.eclipse.uml2.uml.Activity)uml2Class.createOwnedBehavior(UMLPackage.eINSTANCE.getActivity());
	// uml2Activity.setName(name);
	// // set links between operation and activity
	// uml2Activity.setSpecification(operation.getUml2Operation());
	// return new Activity(uml2Activity);
	// }

	/**
	 * Creates an activity, given specific parameters.
	 * 
	 * @param isReentrant
	 *            value of the 'isReentrant' property
	 * @param language
	 * @param name
	 *            name of the activity
	 * @param operation
	 *            specification operation
	 * 
	 * @return the created activity
	 */
	public Activity createActivity(Operation operation, String name, String language, boolean isReentrant) {
		org.eclipse.uml2.uml.Activity uml2Activity = (org.eclipse.uml2.uml.Activity) uml2Class.createOwnedBehavior(name, UMLPackage.eINSTANCE.getActivity());
		// set links between operation and activity
		uml2Activity.setSpecification(operation.getUml2Operation());
		org.eclipse.papyrus.umlutils.Activity utilsActivity = new org.eclipse.papyrus.umlutils.Activity(uml2Activity);

		Collection parameters = operation.getAllParameters();
		if (parameters != null) {
			Parameter currentParameter;
			for (Iterator paramsIt = parameters.iterator(); paramsIt.hasNext();) {
				currentParameter = (Parameter) paramsIt.next();
				utilsActivity.createActivityParameterNode(currentParameter.getName(), currentParameter);
			}
		}

		return new Activity(uml2Activity);
	}

	/**
	 * Creates an OpaqueBehavior, given specific parameters.
	 * 
	 * @param isReentrant
	 *            value of the 'isReentrant' property
	 * @param name
	 *            name of the OpaqueBehavior
	 * @param operation
	 *            specification operation
	 * 
	 * @return the created OpaqueBehavior
	 */
	public OpaqueBehavior createOpaqueBehavior(Operation operation, String name) {
		org.eclipse.uml2.uml.OpaqueBehavior uml2OpaqueBehavior = (org.eclipse.uml2.uml.OpaqueBehavior) uml2Class.createOwnedBehavior(name, UMLPackage.eINSTANCE.getOpaqueBehavior());
		// set links between operation and activity
		uml2OpaqueBehavior.setSpecification(operation.getUml2Operation());

		org.eclipse.papyrus.umlutils.OpaqueBehavior utilsOpaqueBehavior = new org.eclipse.papyrus.umlutils.OpaqueBehavior(uml2OpaqueBehavior);

		Collection parameters = operation.getAllParameters();
		if (parameters != null) {
			for (Iterator paramsIt = parameters.iterator(); paramsIt.hasNext();) {
				Parameter currentParameter = (Parameter) paramsIt.next();
				utilsOpaqueBehavior.createParameter(currentParameter.getName(), currentParameter);
			}
		}
		return utilsOpaqueBehavior;
	}

	/**
	 * Gets the comparison operation if one exists.
	 * 
	 * @return a <code>com.cea.papyrus.umlutils.Operation</code> or null if no comparison operation is avaliable.
	 */
	public Operation getComparisonOperation() {
		Operation op = null;

		String[] appliedStereotypes = { "greater" };
		String[] unappliedStereotypes = { "nocode" };

		List ops = getOperations(null, Boolean.FALSE, appliedStereotypes, unappliedStereotypes);

		if (ops.size() > 0) {
			op = (Operation) ops.get(0);
		}

		return op;
	}

	/**
	 * Tells if the class is a template.
	 * 
	 * @return
	 */
	public boolean isTemplate() {
		boolean template;
		TemplateSignature ts = uml2Class.getOwnedTemplateSignature();
		template = ts != null;
		// If the class inherits from a template it is also a template
		Collection superClasses = getParents();
		if (superClasses != null) {
			Iterator iSuperClasses = superClasses.iterator();
			Class currentSuperClass;
			while (iSuperClasses.hasNext()) {
				currentSuperClass = (Class) iSuperClasses.next();
				template = template || currentSuperClass.isTemplate();
			}
		}
		return template;
	}

	/**
	 * Get the list of all the <code>ParameteredElement</code> of the class.
	 * 
	 * @return A collection of <code>ParameteredElement</code> or <code>null</code> if the class is not parametred.
	 */
	public Collection<Type> getParameteredElement() {
		Collection<Type> params = new ArrayList<Type>();
		Iterator templateParametersIterator;
		TemplateSignature ts = uml2Class.getOwnedTemplateSignature();
		TemplateParameter tp;
		if (ts == null) {
			Iterator superClassesIterator = getParents().iterator();
			Class superClass;
			while (superClassesIterator.hasNext() && (ts == null)) {
				superClass = (Class) superClassesIterator.next();
				params.addAll(superClass.getParameteredElement());
			}
			if (params.size() == 0) {
				return null;
			}
		} else {
			templateParametersIterator = ts.getOwnedParameters().iterator();

			while (templateParametersIterator.hasNext()) {
				tp = (TemplateParameter) templateParametersIterator.next();
				params.add(new Type((org.eclipse.uml2.uml.Type) tp.getParameteredElement()));
			}
		}
		return params;
	}

	/**
	 * Get the list of all the <code>ParameteredElement</code> of the class.
	 * 
	 * @return A collection of <code>ParameteredElement</code> or <code>null</code> if the class is not parametred.
	 */
	public Collection<org.eclipse.papyrus.umlutils.TemplateParameter> getTemplateParameters() {

		Collection<org.eclipse.papyrus.umlutils.TemplateParameter> params = new ArrayList<org.eclipse.papyrus.umlutils.TemplateParameter>();

		Iterator templateParametersIterator;
		TemplateSignature ts = uml2Class.getOwnedTemplateSignature();
		TemplateParameter tp;
		if (ts != null) {
			templateParametersIterator = ts.getOwnedParameters().iterator();

			while (templateParametersIterator.hasNext()) {
				tp = (TemplateParameter) templateParametersIterator.next();
				params.add(new org.eclipse.papyrus.umlutils.TemplateParameter(tp, uml2Class));
			}
		}
		return params;
	}

	/**
	 * Tells if the class is a template implementation.
	 * 
	 * @return
	 */
	public boolean isTemplateBoundElement() {
		boolean result = false;
		EList tb = uml2Class.getTemplateBindings();
		if (tb != null) {
			Iterator itb = tb.iterator();
			TemplateBinding currentTb;
			while (itb.hasNext()) {
				currentTb = (TemplateBinding) itb.next();
				result = currentTb.getBoundElement() == uml2Class;
			}
		}
		return result;
	}

	/**
	 * Destroy the activity which is the method for an operation, given a specific language.
	 * 
	 * @param language
	 *            the language for the body of the activity
	 * @param operation
	 *            the operation for which the activity is the method
	 * 
	 * @deprecated
	 */
	@Deprecated
	public void destroyActivity(Operation operation, String language) {
		Activity activity = operation.getMethodActivity(language);
		if (activity != null) {
			activity.getUml2Activity().destroy();
		}
	}

	/**
	 * Gives the set of classes used by current class.
	 * 
	 * @param stereotypeName
	 *            select only classes
	 * 
	 * @return a Set of <code>com.cea.papyrus.umlutils.class</code> that are linked to current class with a dependency or <code>null</code>
	 */
	public Set<Class> getUsedClasses(String stereotypeName) {

		Set<org.eclipse.uml2.uml.NamedElement> usedElements = new HashSet<org.eclipse.uml2.uml.NamedElement>();
		Set<Class> usedClasses = new HashSet<Class>();

		org.eclipse.uml2.uml.NamedElement currentNamedElement;

		// initialize currentElement with currentPackage to acces getUsedElemens method
		org.eclipse.papyrus.umlutils.NamedElement currentClassAsNamedElement = new org.eclipse.papyrus.umlutils.NamedElement(uml2Class);
		org.eclipse.papyrus.umlutils.Class currentClass;

		usedElements = currentClassAsNamedElement.getUsedElements(stereotypeName);
		Iterator usedElementsIt = usedElements.iterator();

		while (usedElementsIt.hasNext()) {
			currentNamedElement = (org.eclipse.uml2.uml.NamedElement) usedElementsIt.next();

			if (currentNamedElement instanceof org.eclipse.uml2.uml.Class) {
				// If the element is a Class, it should be returned in the result set
				currentClass = new Class((org.eclipse.uml2.uml.Class) currentNamedElement);
				usedClasses.add(currentClass);
			}
		}

		return usedClasses;
	}

	/**
	 * Gives the set of classes associated to current class.
	 * 
	 * @return a Set of <code>com.cea.papyrus.umlutils.class</code> that are linked to current class with an association or <code>null</code>
	 */
	public Set<Class> getAssociatedClasses() {

		Set<Class> assocClasses = new HashSet<Class>();

		Iterator uml2Attributes = uml2Class.getAttributes().iterator();
		Property currentAttribute;

		while (uml2Attributes.hasNext()) {
			currentAttribute = new Property((org.eclipse.uml2.uml.Property) uml2Attributes.next());

			if (currentAttribute.isAssociation()) {
				// Retrieve classes only
				if (currentAttribute.getType().isClass()) {
					assocClasses.add(currentAttribute.getType().getTypeClass());
				}
			}
		}

		return assocClasses;
	}

	/**
	 * Gives the set of interfaces associated to current class.
	 * 
	 * @return a Set of <code>com.cea.papyrus.umlutils.Interface</code> that are linked to current class with an association or <code>null</code>
	 */
	public Set<Interface> getAssociatedInterfaces() {

		Set<Interface> assocInterfaces = new HashSet<Interface>();

		Iterator uml2Attributes = uml2Class.getAttributes().iterator();
		Property currentAttribute;

		while (uml2Attributes.hasNext()) {
			currentAttribute = new Property((org.eclipse.uml2.uml.Property) uml2Attributes.next());

			if (currentAttribute.isAssociation()) {
				// Retrieve interfaces only
				if (currentAttribute.getType().isInterface()) {
					assocInterfaces.add(currentAttribute.getType().getTypeInterface());
				}
			}
		}

		return assocInterfaces;
	}

	/**
	 * If at leats one operation is abstract (virtual or virtual pure) then return true else false.
	 * 
	 * @return true if one (or more) operation is abstract
	 */
	public boolean isAbstract() {
		boolean isAbstract = false;

		// Retrieve the list of abstract operations
		if (getOperations(null, new Boolean(true), null, null).size() != 0) {
			isAbstract = true;
		}

		return isAbstract;
	}

	/**
	 * Sets if the uml Class is abstract or not
	 * 
	 * @param b
	 *            <code>true</code> if this operation is abstract.
	 */
	public void setIsAbstract(boolean b) {
		getUml2Class().setIsAbstract(b);
	}

	/**
	 * Sets if the uml Class is active or not
	 * 
	 * @param b
	 *            <code>true</code> if this operation is active.
	 */
	public void setIsStatic(boolean b) {
		getUml2Class().setIsActive(b);
	}

	/**
	 * Returns the number of the service passed as parameter.
	 * 
	 * @param serviceName
	 * 
	 * @return the number of the service passed as parameter
	 */
	public int getServiceNumber(String serviceName) {
		int serviceNb = 0;
		boolean found = false;

		EList op = (this.getUml2Class()).getOwnedOperations();
		Iterator opIterator = op.iterator();
		while (opIterator.hasNext() && (found == false)) {
			org.eclipse.uml2.uml.Operation currentUml2Op = (org.eclipse.uml2.uml.Operation) opIterator.next();
			Operation currentOp = new Operation(currentUml2Op);
			if (!(currentOp.hasStereotype("AccordGenerated") || currentOp.hasStereotype("NoRTCode"))) {
				serviceNb = serviceNb + 1;
				if ((currentUml2Op.getName()).equals(serviceName)) {
					found = true;
				}
			}
		}
		return serviceNb;
	}

	/**
	 * Retrieves state machines of the class.
	 * 
	 * @return state machines of the class
	 */
	public ArrayList<StateMachine> getOwnedStateMachines() {
		ArrayList<StateMachine> result = new ArrayList<StateMachine>();

		Iterator<org.eclipse.uml2.uml.Behavior> smIter = getUml2Class().getOwnedBehaviors().iterator();
		while (smIter.hasNext()) {
			org.eclipse.uml2.uml.Behavior currentBehavior = smIter.next();
			if (currentBehavior instanceof StateMachine) {
				result.add((StateMachine) currentBehavior);
			}
		}

		return result;
	}

	public Collection<Property> getAllAttributes() {
		Collection<Property> result = new ArrayList<Property>();
		Iterator<org.eclipse.uml2.uml.Property> propIter = getUml2Class().getAllAttributes().iterator();
		while (propIter.hasNext()) {
			result.add(new Property(propIter.next()));
		}
		return result;
	}

}