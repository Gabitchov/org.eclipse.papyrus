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
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Parameter;

//FIXME How to manage circular inclusions?
/**
 * 
 * 
 * 
 * This class represents a class and encapsulates an org.eclipse.uml2.uml.Class object
 */
public class Interface extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Interface uml2Interface;

	/**
	 * 
	 * 
	 * @param uml2Interface
	 */
	public Interface(org.eclipse.uml2.uml.Interface uml2Interface) {
		super(uml2Interface);
		this.uml2Interface = uml2Interface;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Interface.
	 */
	public org.eclipse.uml2.uml.Interface getUml2Interface() {
		return uml2Interface;
	}

	/**
	 * Gives the Interface full name. The full name is the interface name prefixed by the package name.
	 * 
	 * @return The interface full name
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
	 * Get the package that owns the interface.
	 * 
	 * @return the package that owns the interface (null if none)
	 */
	public Package getPackage() {
		Package parent = null;
		org.eclipse.uml2.uml.Package u2parent = uml2Interface.getPackage();
		if (u2parent != null) {
			if (!(u2parent instanceof org.eclipse.uml2.uml.Model)) {
				parent = new Package(u2parent);
			}
		}
		return parent;
	}

	/**
	 * Check what header are needed by the interface. Provides a set of String, each string is the full path of the needed header.
	 * 
	 * @return A set of String.
	 */
	public Set<String> getNeededHeaders() {
		Set<String> includes = new HashSet<String>();
		Interface usedInterface;
		// Browse through the operation parameters
		Iterator operationsItreator = uml2Interface.getOwnedOperations().iterator();
		org.eclipse.uml2.uml.Operation currentOperation;
		// Browse through operations
		while (operationsItreator.hasNext()) {
			currentOperation = (org.eclipse.uml2.uml.Operation) operationsItreator.next();
			Iterator parametersItreator = currentOperation.getOwnedParameters().iterator();
			Parameter currentParameter;
			// Browse through parameters
			while (parametersItreator.hasNext()) {
				currentParameter = (Parameter) parametersItreator.next();
				if (currentParameter.getType() != null) {
					if (currentParameter.getType() instanceof org.eclipse.uml2.uml.Interface) {
						usedInterface = new Interface((org.eclipse.uml2.uml.Interface) currentParameter.getType());
						includes.add(usedInterface.getHeaderPath());
					}
				}
			}
		}
		return includes;
	}

	/**
	 * Provide the include to get visibility on this interface. Provides the full path of the .h file from the source directory. So the source directory has to be a default include directory (see
	 * compiler configuration).
	 * 
	 * @return the full path of the .h file.
	 */
	public String getHeaderPath() {
		String include = getName();
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			include = parentPackage.getName() + "/" + include;
		}
		return include + ".h";
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
		Iterator operationIterator = uml2Interface.getOwnedOperations().iterator();
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
	 * Tells if this interface uses the glib.
	 * 
	 * @return
	 */
	public boolean useGlib() {
		boolean glib = true;

		Package parent = getPackage();
		if (parent != null) {
			glib = parent.usesGlib();
		}
		return glib;
	}

	/**
	 * Tells if this interface can use c99 specific types.
	 * 
	 * @return
	 */
	public boolean useC99() {
		return getModel().useC99();
	}

	/**
	 * Gives all the generalizations of the current Interface.
	 * 
	 * @return
	 */
	public Collection<Interface> getSuperInterfaces() {
		Collection<Interface> superInterfaces = new ArrayList<Interface>();
		Iterator interfacesIterator = uml2Interface.getGenerals().iterator();
		Interface currentInterface;
		while (interfacesIterator.hasNext()) {
			currentInterface = new Interface((org.eclipse.uml2.uml.Interface) interfacesIterator.next());
			superInterfaces.add(currentInterface);
			superInterfaces.addAll(currentInterface.getSuperInterfaces());
		}
		return superInterfaces;
	}

	/**
	 * Gives the model that own the interface.
	 * 
	 * @return
	 */
	@Override
	public Model getModel() {
		return new Model(uml2Interface.getModel());
	}
}