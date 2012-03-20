/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.syntax.units;

import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.DocumentedElement;
import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.uml.alf.syntax.expressions.QualifiedName;
import org.eclipse.uml2.uml.Profile;

public class UnitDefinition extends DocumentedElement {

	// Synthesized properties
	public List<ImportReference> _import ;
	public NamespaceDefinition definition ;
	public QualifiedName namespaceName ;
	
	// Derived Properties
	public List<Profile> appliedProfile ;
	public boolean isModelLibrary ;
	public ElementReference namespace ;
	
	// Constraints
	
	/*
	 * The profiles applied to a unit definition include any profiles applied to the containing namespace of the
	 * 	unit definition. If the unit definition is for a package, then the applied profiles for the unit definition also
	 * 	include the applied profiles for its associated package definition.
	 */
	public void checkUnitDefinitionAppliedProfileDerivation() {
		
	}
	
	/*
	 * Unless the unit definition is a model library, it has private package import references for all the subpackages
	 * 	of the Alf::Library package.
	 */
	public void checkUnitDefinitionImplicitImports() {
		
	}
	
	/*
	 * A unit definition is for a model library if its associated namespace definition has a stereotype annotation
	 * 	for the UML standard stereotype ModelLibrary.
	 */
	public void checkUnitDefinitionIsModelLibraryDerivation() {
		
	}
	
	/*
	 * The declared namespace name for a unit definition, if any, must resolve to a UML namespace of an Alf
	 * 	unit definition. If it is an Alf unit definition, then it must have a stub for this unit definition.
	 */
	public void checkUnitDefinitionNamespace() {
		
	}
	
	/*
	 * If a unit definition has a declared namespace name, then the containing namespace for the unit is the
	 * 	referent for that name.
	 */
	public void checkUnitDefinitionNamespaceDerivation() {
		
	}
	
	
}
