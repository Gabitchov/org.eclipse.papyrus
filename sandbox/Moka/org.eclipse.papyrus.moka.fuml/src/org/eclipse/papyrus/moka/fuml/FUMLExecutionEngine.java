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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL3.ExecutionFactoryL3;
import org.eclipse.papyrus.moka.fuml.debug.ControlDelegate;
import org.eclipse.papyrus.moka.fuml.registry.DefaultSemanticStrategyRegistry;
import org.eclipse.papyrus.moka.fuml.registry.IOpaqueBehaviorExecutionRegistry;
import org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;

public class FUMLExecutionEngine extends AbstractExecutionEngine implements IExecutionEngine {

	protected final static String LIBRAY_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.library";
	protected final static String SERVICES_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.services" ;

	protected static Behavior main = null;

	protected String[] args ;

	protected List<ParameterValue> arguments ;

	protected Locus locus ;

	public static ControlDelegate controlDelegate ;

	protected boolean started = false ;

	protected static ServicesRegistry servicesRegistry ;

	protected static ILabelProvider labelProvider ;

	public static Image getImage(Object element) {
		try {
			if (element instanceof EObject && ((EObject)element).eIsProxy()) {
				labelProvider = null ;
				servicesRegistry = null ;
			}
			if (labelProvider == null) {
				if (servicesRegistry == null) {
					if (main.eIsProxy()) {
						IEditorPart part = EditorUtils.getEditorPart(main) ;
						ServicesRegistry servicesRegistry =  (ServicesRegistry)part.getAdapter(ServicesRegistry.class);
						ResourceSet resourceSet = null ;
						try {
							resourceSet = servicesRegistry.getService(ModelSet.class) ;
						} catch (ServiceException e1) {
							resourceSet = new ResourceSetImpl() ;
							e1.printStackTrace();
						}
						main = (Behavior) EcoreUtil.resolve(main, resourceSet) ;
					}
					else {
						servicesRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(main.eResource());
					}
				}
				LabelProviderService labelProviderService = servicesRegistry.getService(LabelProviderService.class);
				labelProvider = labelProviderService.getLabelProvider() ;
				labelProvider.getImage(element) ;
			}
			return labelProvider.getImage(element) ;
		}
		catch (Exception e) {
			Activator.log.error(e) ;
			return null ;
		}
	}

	@Override
	public void initRun(EObject eObjectToExecute, String[] args) {
		super.initRun(eObjectToExecute, args);
		AnimationUtils.init() ;
		servicesRegistry = null ;
		labelProvider = null ;
		if (eObjectToExecute instanceof Behavior) {
			main = (Behavior)eObjectToExecute ;
		}
		if (this.mode.equals(ILaunchManager.DEBUG_MODE)) {
			this.debugTarget.setName("fUML Execution Engine") ;
		}
	}

	@Override
	public void start() throws IOException {
		controlDelegate = new ControlDelegate() ;
		super.start();
	}

	// Starts the execution of the given behavior
	protected void start(Behavior behavior) {
		if(behavior != null) {
			main = behavior;
			// creates the locus, executor and execution factory
			this.locus = new Locus();
			this.locus.engine = this ;
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
			// sets the execution mode for the locus
			locus.initDebugInformation(this.mode, this) ;
			// Finally launches the execution
			this.locus.executor.execute(main, null,this.arguments);
			//
			this.isTerminated = true ;
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


	public boolean isDebugModeSupported() {
		return true;
	}

	public MokaThread[] getThreads() {
		if (this.locus == null)
			return new MokaThread[]{} ;
		//		if (this.locus.mainThread == null) {
		//			this.locus.initDebugInformation(this.mode, this) ;
		//		}
		return new MokaThread[]{this.locus.mainThread} ;
	}

	@Override
	public void initializeArguments(String[] args) {
		if (this.locus == null) {
			this.args = args ;
			return ;
		}

		this.arguments = new ArrayList<ParameterValue>() ;
		if (this.args == null)
			return ;

		List<Value> tmpArgs = new ArrayList<Value>() ;

		// analyzes arguments versus parameters of the main behavior
		List<Parameter> parameters = main.getOwnedParameters() ;
		if (parameters == null)
			return ;
		List<Parameter> parametersWhichNeedArguments = new ArrayList<Parameter>() ;
		// There must be the same number of parameters (except the return parameter)
		for (Parameter p : parameters) {
			if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
				parametersWhichNeedArguments.add(p) ;
		}
		if (parametersWhichNeedArguments.size() != this.args.length)
			return ;

		// iterates of parameters, and tries to create tokens corresponding to arguments
		int i = 0 ;
		for (Parameter p : parametersWhichNeedArguments) {
			Type t = p.getType() ;
			if (t != null) {
				PrimitiveType pt = this.locus.factory.getBuiltInType(t.getName()) ;
				if (pt == null)
					return ;
				if (pt.getName().equals("Integer")) {
					IntegerValue value = new IntegerValue() ;
					value.value = new Integer(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("String")) {
					StringValue value = new StringValue() ;
					value.value = this.args[i] ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("Boolean")) {
					BooleanValue value = new BooleanValue() ;
					value.value = new Boolean(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("UnlimitedNatural")) {
					UnlimitedNaturalValue value = new UnlimitedNaturalValue() ;
					value.value = new Integer(args[i]) ;
					tmpArgs.add(value) ;
				}
				else {
					return ; // Unsupported type. TODO Consider Real 
				}
			}
			i++ ;
		}

		i = 0 ;
		// creates actual arguments
		for (Value v : tmpArgs) {
			ParameterValue arg = new ParameterValue() ;
			arg.parameter = parameters.get(i) ;
			arg.values = new ArrayList<Value>() ;
			arg.values.add(v) ;
			this.arguments.add(arg) ;
			i++ ;
		}
	}

	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		controlDelegate.addBreakpoint(breakpoint) ;
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		controlDelegate.removeBreakpoint(breakpoint) ;
	}

	@Override
	public void disconnect() {
		// Does nothing
	}

	@Override
	public void resume(Resume_Request request) {
		if (!this.started) {
			this.started = true ;
			Runnable execution = new Runnable() {
				public void run() {
					if (main != null) {
						start(main) ;
					}
				}
			};
			Thread mainThread = new Thread(execution) ;
			mainThread.start() ;
		}
		else {
			locus.mainThread.setStackFrames(new IStackFrame[]{}) ;
			controlDelegate.resume(request) ;
		}
	}

	@Override
	public void resume() {
		if (main != null)
			this.start(main);
	}

	@Override
	public void suspend(Suspend_Request request) {
		controlDelegate.handleSuspendRequest() ;
	}

	@Override
	public void terminate(Terminate_Request request) {
		this.isTerminated = true ;
		controlDelegate.handleTerminateRequest() ;
	}

	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		if (this.locus.stackFrames == null)
			this.locus.stackFrames = new MokaStackFrame[]{} ;
		return this.locus.stackFrames ;
	}

}
