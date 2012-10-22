/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.standardlibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.registry.AbstractOpaqueBehaviorExecutionRegistry;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.And;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Implies;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Not;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Or;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToBoolean;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.ToString;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_.Xor;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Abs;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Add;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Div;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Greater;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.GreaterOrEqual;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Lower;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.LowerOrEqual;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Max;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Min;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Minus;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Mod;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Neg;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.Times;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToInteger;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer.ToUnlimitedNatural;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListGet;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.list.ListSize;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Concat;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Size;
import org.eclipse.papyrus.moka.fuml.standardlibrary.library.string.Substring;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

public class StandardLibraryRegistry extends AbstractOpaqueBehaviorExecutionRegistry {

	protected final static String FUML_LIBRARY_NAME = "FoundationalModelLibrary";

	@Override
	public void registerOpaqueBehaviorExecutions(Locus locus) {
		this.locus = locus;
		this.buildOpaqueBehaviorsMap(FUML_LIBRARY_NAME);
		// TODO Only the PrimitiveBehaviors package is implemented. Common and BasicInputOutput need to be implemented.
		try {
			// ////////////////////
			// Integer functions
			// Neg
			this.registerOpaqueBehaviorExecution(new Neg(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Neg");
			// +
			this.registerOpaqueBehaviorExecution(new Add(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::+");
			// -
			this.registerOpaqueBehaviorExecution(new Minus(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::-");
			// *
			this.registerOpaqueBehaviorExecution(new Times(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::*");
			// Abs
			this.registerOpaqueBehaviorExecution(new Abs(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Abs");
			// Div
			this.registerOpaqueBehaviorExecution(new Div(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Div");
			// Mod
			this.registerOpaqueBehaviorExecution(new Mod(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Mod");
			// Max
			this.registerOpaqueBehaviorExecution(new Max(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Max");
			// Min
			this.registerOpaqueBehaviorExecution(new Min(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::Min");
			// <
			this.registerOpaqueBehaviorExecution(new Lower(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<");
			// >
			this.registerOpaqueBehaviorExecution(new Greater(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>");
			// <=
			this.registerOpaqueBehaviorExecution(new LowerOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::<=");
			// >=
			this.registerOpaqueBehaviorExecution(new GreaterOrEqual(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::>=");
			// ToString
			this.registerOpaqueBehaviorExecution(new ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToString");
			// ToUnlimitedNatural
			this.registerOpaqueBehaviorExecution(new ToUnlimitedNatural(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToUnlimitedNatural");
			// ToInteger
			this.registerOpaqueBehaviorExecution(new ToInteger(), "FoundationalModelLibrary::PrimitiveBehaviors::IntegerFunctions::ToInteger");
			// ////////////////////
			// Boolean functions
			// Or
			this.registerOpaqueBehaviorExecution(new Or(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Or");
			// Xor
			this.registerOpaqueBehaviorExecution(new Xor(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Xor");
			// And
			this.registerOpaqueBehaviorExecution(new And(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::And");
			// Not
			this.registerOpaqueBehaviorExecution(new Not(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Not");
			// Implies
			this.registerOpaqueBehaviorExecution(new Implies(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::Implies");
			// ToString
			this.registerOpaqueBehaviorExecution(new ToString(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToString");
			// ToBoolean
			this.registerOpaqueBehaviorExecution(new ToBoolean(), "FoundationalModelLibrary::PrimitiveBehaviors::BooleanFunctions::ToBoolean");
			// ////////////////////
			// String functions
			// Concat
			this.registerOpaqueBehaviorExecution(new Concat(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Concat");
			// Size
			this.registerOpaqueBehaviorExecution(new Size(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Size");
			// Substring
			this.registerOpaqueBehaviorExecution(new Substring(), "FoundationalModelLibrary::PrimitiveBehaviors::StringFunctions::Substring");
			// ////////////////////
			// List functions
			// ListSize
			this.registerOpaqueBehaviorExecution(new ListSize(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListSize");
			// ListGet
			this.registerOpaqueBehaviorExecution(new ListGet(), "FoundationalModelLibrary::PrimitiveBehaviors::ListFunctions::ListGet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO This overriding should not be necessary
	// The fUML standard library just needs to be a registered library
	@Override
	protected void buildOpaqueBehaviorsMap(String libraryName) {
		opaqueBehaviorsMap = new HashMap<String, OpaqueBehavior>();
		RegisteredLibrary[] libraries = RegisteredLibrary.getRegisteredLibraries();
		RegisteredLibrary alfLibrary = null;
		for(RegisteredLibrary l : libraries) {
			if(l.getName().equals("AlfLibrary"))
				alfLibrary = l;
		}
		if(alfLibrary != null) {
			URI libraryUri = alfLibrary.uri;
			ResourceSet resourceSet = contextEObject.eResource().getResourceSet();
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			Package libraryObject = (Package)libraryResource.getContents().get(0);
			Package fumlPackage = null;
			for(Element e : libraryObject.getOwnedElements()) {
				if(e instanceof PackageImport) {
					if(((PackageImport)e).getImportedPackage().getName().equals(libraryName))
						fumlPackage = ((PackageImport)e).getImportedPackage();
				}
			}
			if(fumlPackage != null) {
				List<Package> packagesForCurrentIteration = new ArrayList<Package>();
				packagesForCurrentIteration.add(fumlPackage);
				List<Package> packagesForNextIteration = new ArrayList<Package>();
				while(!packagesForCurrentIteration.isEmpty()) {
					for(Package p : packagesForCurrentIteration) {
						for(Element e : p.getOwnedElements()) {
							if(e instanceof Package) {
								packagesForNextIteration.add((Package)e);
							} else if(e instanceof FunctionBehavior) {
								FunctionBehavior f = (FunctionBehavior)e;
								opaqueBehaviorsMap.put(f.getQualifiedName(), f);
								System.out.println(f.getQualifiedName());
							}
						}
					}
					packagesForCurrentIteration.clear();
					packagesForCurrentIteration.addAll(packagesForNextIteration);
					packagesForNextIteration.clear();
				}
			}
		}
	}

	protected void registerOpaqueBehaviorExecution(OpaqueBehaviorExecution behaviorExecution, String behaviorQualifiedName) {
		behaviorExecution.types.add(this.opaqueBehaviorsMap.get(behaviorQualifiedName));
		locus.factory.primitiveBehaviorPrototypes.add(behaviorExecution);
	}
}
