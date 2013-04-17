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
package org.eclipse.papyrus.moka.fuml;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL3.ExecutionFactoryL3;
import org.eclipse.papyrus.moka.fuml.debug.ControlDelegate;
import org.eclipse.papyrus.moka.fuml.registry.DefaultSemanticStrategyRegistry;
import org.eclipse.papyrus.moka.fuml.registry.IOpaqueBehaviorExecutionRegistry;
import org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;

public abstract class FUMLExecutionEngine extends AbstractExecutionEngine {

	protected final static String LIBRAY_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.library";
	protected final static String SERVICES_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.services" ;

	protected static Behavior main = null;

	protected String[] args ;

	protected List<ParameterValue> arguments ;

	protected Locus locus ;

	protected boolean started = false ;
	
	public static FUMLExecutionEngine eInstance ;

	// Starts the execution of the given behavior
	protected void start(Behavior behavior) {
		if(behavior != null) {
			main = behavior;
			// creates the locus, executor and execution factory
			this.locus = new Locus();
			this.locus.setExecutor(new Executor());
			this.locus.setFactory(new ExecutionFactoryL3());
			// initializes built-in primitive types
			this.initializeBuiltInPrimitiveTypes(locus);
			// Initializes opaque behavior executions
			this.registerOpaqueBehaviorExecutions(locus);
			// Initializes system services
			this.registerSystemServices(locus) ;
			// Initializes semantic strategies
			this.registerSemanticStrategies(locus);
			// Initializes arguments
			this.initializeArguments(this.args) ;
			// Finally launches the execution
			this.started = true ;
			this.locus.executor.execute(main, null,this.arguments);
		}
	}

	// Register semantic strategies available in the environment
	protected void registerSemanticStrategies(Locus locus) {
		// TODO Introduce an extension point
		new DefaultSemanticStrategyRegistry().registerSemanticStrategies(locus);
	}

	// Register OpaqueBehaviorExecutions available in the environment
	protected void registerOpaqueBehaviorExecutions(Locus locus) {
		// Load any OpaqueBehaviorExecution library contributing to the extension LIBRAY_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(LIBRAY_EXTENSION_POINT_ID);
		try {
			for(int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadLibrary(o, locus, main);
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Register System Services available in the environment
	protected void registerSystemServices(Locus locus) {
		// Load any contribution to the extension SERVICES_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(SERVICES_EXTENSION_POINT_ID);
		try {
			for(int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadServices(o, locus, main);
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Initializes primitive types of the locus with content of UMLPrimitiveTypes
	protected void initializeBuiltInPrimitiveTypes(Locus locus) {
		RegisteredLibrary[] libraries = RegisteredLibrary.getRegisteredLibraries();
		RegisteredLibrary umlPrimitiveTypes = null;
		for(RegisteredLibrary l : libraries) {
			if(l.getName().equals("UMLPrimitiveTypes"))
				umlPrimitiveTypes = l;
		}
		if(umlPrimitiveTypes != null) {
			URI libraryUri = umlPrimitiveTypes.uri;
			ResourceSet resourceSet = Util.getResourceSet(main);
			Resource libraryResource = resourceSet.getResource(libraryUri, true);
			Package libraryObject = (Package)libraryResource.getContents().get(0);
			for(Element e : libraryObject.getOwnedElements()) {
				if(e instanceof PrimitiveType)
					locus.factory.builtInTypes.add((PrimitiveType)e);
			}
		}
	}

	// Loads a library of OpaqueBehaviorExecutions using the safe runner pattern
	protected static void loadLibrary(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				System.out.println("Exception while loading the library");
			}

			public void run() throws Exception {
				((IOpaqueBehaviorExecutionRegistry)o).init(context).registerOpaqueBehaviorExecutions(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	// Loads System services using the safe runner pattern
	protected static void loadServices(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				System.out.println("Exception while loading system services");
			}

			public void run() throws Exception {
				((ISystemServicesRegistry)o).init(context).registerSystemServices(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	public abstract ControlDelegate getControlDelegate() ;
	
}
