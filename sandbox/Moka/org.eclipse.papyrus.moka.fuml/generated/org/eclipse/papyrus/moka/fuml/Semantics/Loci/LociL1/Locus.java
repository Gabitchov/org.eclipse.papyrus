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
package org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.debug.FumlThread;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class Locus {
	
	public boolean isInDebugMode = false ;
	
	public FUMLExecutionEngine engine ;
	
	public FumlThread mainThread ;
	
	public MokaStackFrame[] stackFrames ;
	
	public void initDebugInformation(String debugMode, FUMLExecutionEngine engine) {
		this.engine = engine ;
		Locus.debugTarget = engine.getDebugTarget() ;
		if (debugMode.equals(ILaunchManager.DEBUG_MODE)) {
			this.isInDebugMode = true ;
			this.mainThread = new FumlThread(engine.getDebugTarget()) ;
			this.mainThread.setName("Main thread") ;
		}
	}
	
	protected static MokaDebugTarget debugTarget ;
	
	public static MokaDebugTarget getDebugTarget() {
		return Locus.debugTarget ;
	}
	
	/*
	 * The executor to be used at this locus.
	 */
	public Executor executor;

	/*
	 * The factory to be used at this locus.
	 */
	public ExecutionFactory factory;

	/*
	 * The set of values that are members of classifier extents at this locus.
	 */
	public List<ExtensionalValue> extensionalValues = new ArrayList<ExtensionalValue>();

	public void setExecutor(Executor executor) {
		// Set the executor for this locus.
		this.executor = executor;
		this.executor.locus = this;
	}

	public void setFactory(ExecutionFactory factory) {
		// Set the factory for this locus.
		this.factory = factory;
		this.factory.locus = this;
	}

	public List<ExtensionalValue> getExtent(Classifier classifier) {
		// Return the set of extensional values at this locus which have the
		// given classifier as a type.
		List<ExtensionalValue> extent = new ArrayList<ExtensionalValue>();
		List<ExtensionalValue> extensionalValues = this.extensionalValues;
		for(int i = 0; i < extensionalValues.size(); i++) {
			ExtensionalValue value = extensionalValues.get(i);
			List<Classifier> types = value.getTypes();
			boolean conforms = false;
			int j = 1;
			while(!conforms & j <= types.size()) {
				conforms = this.conforms(types.get(j - 1), classifier);
				j = j + 1;
			}
			if(conforms) {
				extent.add(value);
			}
		}
		return extent;
	}

	public void add(ExtensionalValue value) {
		// Add the given extensional value to this locus
		value.locus = this;
		this.extensionalValues.add(value);
	}

	public void remove(ExtensionalValue value) {
		// Remove the given extensional value from this locus.
		value.locus = null;
		boolean notFound = true;
		int i = 1;
		while(notFound & i <= this.extensionalValues.size()) {
			if(this.extensionalValues.get(i - 1) == value) {
				this.extensionalValues.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
	}

	public Object_ instantiate(Class type) {
		// Instantiate the given class at this locus.
		Object_ object = null;
		if(type instanceof Behavior) {
			object = this.factory.createExecution((Behavior)type, null);
		} else {
			object = new Object_();
			object.types.add(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}

	public Boolean conforms(Classifier type, Classifier classifier) {
		// Test if a type conforms to a given classifier, that is, the type is
		// equal to or a descendant of the classifier.
		boolean doesConform = false;
		if(type == classifier) {
			doesConform = true;
		} else {
			int i = 1;
			while(!doesConform & i <= type.getGenerals().size()) {
				doesConform = this.conforms(type.getGenerals().get(i - 1), classifier);
				i = i + 1;
			}
		}
		return doesConform;
	}
}
