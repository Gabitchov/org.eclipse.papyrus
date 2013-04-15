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
package org.eclipse.papyrus.moka.fuml.registry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.uml2.uml.OpaqueBehavior;

public abstract class AbstractOpaqueBehaviorExecutionRegistry implements IOpaqueBehaviorExecutionRegistry {

	protected EObject contextEObject = null;

	protected Locus locus = null;

	protected Map<String, OpaqueBehavior> opaqueBehaviorsMap = null;

	public IOpaqueBehaviorExecutionRegistry init(Object parameters) {
		if(parameters instanceof EObject)
			this.contextEObject = (EObject)parameters;
		return this;
	}

	public void registerOpaqueBehaviorExecutions(Locus locus) {
		this.locus = locus;
	}

	protected void buildOpaqueBehaviorsMap(final String LIBRARY_NAME) {
		opaqueBehaviorsMap = new HashMap<String, OpaqueBehavior>();
		RegisteredLibrary[] libraries = RegisteredLibrary.getRegisteredLibraries();
		RegisteredLibrary library = null;
		for(RegisteredLibrary l : libraries) {
			if(l.getName().equals(LIBRARY_NAME))
				library = l;
		}
		if(library != null) {
			URI libraryUri = library.uri;
			ResourceSet resourceSet = Util.getResourceSet(contextEObject);
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			for(Iterator<EObject> i = libraryResource.getAllContents(); i.hasNext();) {
				EObject cddOpaqueBehavior = i.next();
				if(cddOpaqueBehavior instanceof OpaqueBehavior) {
					OpaqueBehavior f = (OpaqueBehavior)cddOpaqueBehavior;
					opaqueBehaviorsMap.put(f.getQualifiedName(), f);
				}
			}
		}
	}

	protected void registerOpaqueBehaviorExecution(OpaqueBehaviorExecution behaviorExecution, String behaviorQualifiedName) {
		behaviorExecution.types.add(this.opaqueBehaviorsMap.get(behaviorQualifiedName));
		locus.factory.primitiveBehaviorPrototypes.add(behaviorExecution);
	}
}
