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
package org.eclipse.papyrus.alf.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.alf.validation.typing.SignatureFacade;
import org.eclipse.papyrus.alf.validation.typing.SignatureFacadeFactory;
import org.eclipse.papyrus.alf.validation.typing.TypeExpressionFactory;
import org.eclipse.papyrus.alf.validation.typing.TypeFacade;
import org.eclipse.papyrus.alf.validation.typing.TypeFacadeFactory;
import org.eclipse.papyrus.alf.validation.typing.TypeUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

public class PredefinedBehaviorsAndTypesUtils {
	
	private Map<String, List<SignatureFacade>> behaviorMap = new HashMap<String, List<SignatureFacade>>();
	private Map<String, TypeFacade> typeMap = new HashMap<String, TypeFacade>() ;
	private List<Behavior> behaviorInsertedAsElementImport = new ArrayList<Behavior>() ;
	private List<Classifier> classifierInsertedAsElementImport = new ArrayList<Classifier>();
	//private List<Behavior> predefinedCollectionFunctions = new ArrayList<Behavior>() ;
	//private Map<String, SignatureFacade> predefinedCollectionFunctionsMap = new HashMap<String, SignatureFacade>() ;
	
	public void init(org.eclipse.uml2.uml.Package library) {
		behaviorMap = new HashMap<String, List<SignatureFacade>>();
		typeMap = new HashMap<String, TypeFacade>() ;
		behaviorInsertedAsElementImport = new ArrayList<Behavior>() ;
		classifierInsertedAsElementImport = new ArrayList<Classifier>() ;
		TypeUtils.predefinedCollectionFunctions = new HashMap<String, SignatureFacade>() ;
		localInit(library) ;
		// initializes predefined type facades from TypeUtils
		TypeUtils._bitString = typeMap.get("BitString") ;
		TypeUtils._boolean = typeMap.get("Boolean") ;
		TypeUtils._integer = typeMap.get("Integer") ;
		TypeUtils._natural = typeMap.get("Natural") ;
		TypeUtils._string = typeMap.get("String") ;
		TypeUtils._undefined =  new TypeFacade();
		TypeUtils._unlimited = typeMap.get("UnlimitedNatural") ;
		TypeUtils._nullExpression = TypeExpressionFactory.eInstance.createTypeExpression(TypeUtils._undefined) ;
		TypeUtils._Collection = typeMap.get("Collection") ;
		TypeUtils._Set = typeMap.get("Set");
		TypeUtils._Bag = typeMap.get("Bag") ;
		TypeUtils._Queue = typeMap.get("Queue") ;
		TypeUtils._OrderedSet = typeMap.get("OrderedSet") ;
		TypeUtils._List = typeMap.get("List") ;
		TypeUtils._Deque = typeMap.get("Deque") ;
		TypeUtils._Map = typeMap.get("Map") ;
		TypeUtils._Entry = typeMap.get("Entry") ;
	}
	
	private void localInit(org.eclipse.uml2.uml.Package library) {
		if (library.getQualifiedName().equals("Alf::Library::CollectionFunctions")) {
			this.initCollectionFunctions(library) ;
		}
		for (NamedElement n : library.getOwnedMembers()) {
			if (n instanceof Behavior) {
				insertSignatureFacade(SignatureFacadeFactory.eInstance.createSignatureFacade(n)) ;
			}
			else if (n instanceof Classifier) {
				insertTypeFacade(TypeFacadeFactory.eInstance.createTypeFacade(n)) ;
			}
			else if (n instanceof org.eclipse.uml2.uml.Package) {
				localInit((org.eclipse.uml2.uml.Package)n) ;
			}
		}
		for (ElementImport eImport : library.getElementImports()) {
			if (eImport.getImportedElement() instanceof Behavior) {
				insertSignatureFacade(new SignatureFacade(eImport)) ;
				behaviorInsertedAsElementImport.add((Behavior)eImport.getImportedElement()) ;
			}
			else if (eImport.getImportedElement() instanceof Classifier) {
				insertTypeFacade(TypeFacadeFactory.eInstance.createTypeFacade(eImport)) ;
				classifierInsertedAsElementImport.add((Classifier)eImport.getImportedElement()) ;
			}
			else if (eImport.getImportedElement() instanceof org.eclipse.uml2.uml.Package) {
				localInit((org.eclipse.uml2.uml.Package)eImport.getImportedElement()) ;
			}
		}
		for (PackageImport pImport : library.getPackageImports()) {
			localInit(pImport.getImportedPackage()) ;
		}
		TypeUtils._Collection = typeMap.get("Collection") ;
		TypeUtils._Set = typeMap.get("Set");
		TypeUtils._Bag = typeMap.get("Bag") ;
		TypeUtils._Queue = typeMap.get("Queue") ;
		TypeUtils._OrderedSet = typeMap.get("OrderedSet") ;
		TypeUtils._List = typeMap.get("List") ;
		TypeUtils._Deque = typeMap.get("Deque") ;
		TypeUtils._Map = typeMap.get("Map") ;
		TypeUtils._Entry = typeMap.get("Entry") ;
		
	}
	
	private void initCollectionFunctions(Package library) {
		for (NamedElement element : library.getOwnedMembers()) {
			if (element instanceof Behavior) {
				SignatureFacade s = SignatureFacadeFactory.eInstance.createSignatureFacade(element) ;
				TypeUtils.predefinedCollectionFunctions.put(s.getName(), s) ;
			}
		}
		for (ElementImport eImport : library.getElementImports()) {
			if (eImport.getImportedElement() instanceof Behavior) {
				SignatureFacade s = SignatureFacadeFactory.eInstance.createSignatureFacade(eImport) ;
				TypeUtils.predefinedCollectionFunctions.put(eImport.getAlias() == null || eImport.getAlias().isEmpty() ? s.getName() : eImport.getAlias(), s) ;
			}
		}
	}

	public List<SignatureFacade> getSignatures(String name) {
		return behaviorMap.get(name) ;
	}
	
	public TypeFacade getClassifier(String name) {
		return typeMap.get(name) ;
	}
	
	private void insertSignatureFacade(SignatureFacade s) {
		for (Behavior b : behaviorInsertedAsElementImport) {
			if (s.equals(b))
				return ;
		}
		List<SignatureFacade> l = behaviorMap.get(s.getName()) ;
		if (l == null) {
			l = new ArrayList<SignatureFacade>() ;
			behaviorMap.put(s.getName(), l) ;
		}
		l.add(s) ;
	}
	
	private void insertTypeFacade(TypeFacade t) {
		for (Classifier c : classifierInsertedAsElementImport) {
			if (t.equals(c))
				return ;
		}
		if (typeMap.get(t.getLabel()) == null)
			typeMap.put(t.getLabel(), t) ;
	}
	
}
