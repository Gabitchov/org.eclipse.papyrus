/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.launch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.moka.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaProcess;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.engine.MokaExecutionEngineJob;
import org.eclipse.ui.IEditorPart;


/**
 * An implementation of ILaunchConfigurationDelegate
 *
 */
public class MokaLaunchDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	/**
	 * The attribute name for the resource uri associated with a launch configuration
	 * The corresponding resource contains the EObject to be executed
	 */
	public static String URI_ATTRIBUTE_NAME = "URI_ATTRIBUTE" ;

	/**
	 * The attribute name for the uri fragment associated with a launch configuration
	 * This fragment is an id for the EObject to be executed 
	 */
	public static String FRAGMENT_ATTRIBUTE_NAME = "FRAGMENT_ATTRIBUTE" ;

	/**
	 * The attribute name for the arguments associated with a launch configuration
	 * This arguments are given to the execution engine for initialization, before actually starting execution.
	 */
	public static String ARGS_ATTRIBUTE_NAME = "ARGS_ATTRIBUTE" ;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {

		// instantiates the actual execution engine
		IExecutionEngine engine = this.instantiateExecutionEngine() ;
		if (engine == null)
			this.abort("Could not instantiate execution engine", null) ;

		// Create a job for the execution of this engine
		MokaExecutionEngineJob engineJob = new MokaExecutionEngineJob("Execution Engine Job", engine) ;

		// retrieves values for the various attributes associated with the launch configuration
		String resourceURI = configuration.getAttribute(URI_ATTRIBUTE_NAME, "") ;
		String uriFragment = configuration.getAttribute(FRAGMENT_ATTRIBUTE_NAME, "") ;
		String arguments = configuration.getAttribute(ARGS_ATTRIBUTE_NAME, "") ;
		String[] args = arguments.split("\\s+");

		IEditorPart part = EditorUtils.getEditorPart(resourceURI) ;

		//IEditorPart part = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor() ;
		ServicesRegistry servicesRegistry =  (ServicesRegistry)part.getAdapter(ServicesRegistry.class);
		ResourceSet resourceSet = null ;
		try {
			resourceSet = servicesRegistry.getService(ModelSet.class) ;
		} catch (ServiceException e1) {
			resourceSet = new ResourceSetImpl() ;
			e1.printStackTrace();
		}

		// from the arguments, retrieves the EObject to be executed

		//ResourceSet resourceSet = new ResourceSetImpl() ;
		Resource resource = resourceSet.getResource(URI.createURI(resourceURI), true) ;
		final EObject eObjectToExecute = resource.getEObject(uriFragment) ;

		// Gets port addresses for sockets
		int requestPort = -1;
		int replyPort = -1;
		int eventPort = -1;
		requestPort = findFreePort();
		eventPort = findFreePort();
		replyPort = findFreePort();
		if (requestPort == -1 || replyPort == -1 || eventPort == -1) {
			this.abort("Unable to find free port", null);
		}

		// The resulting job is used for the creation of MokaRuntimeProcess, thereby simulating a real, physical process
		IProcess process = new MokaProcess(launch, engineJob, "Moka runtime process", new HashMap<String,String>()) ;

		// Initializes the engine as well as the debug target
		MokaDebugTarget target = new MokaDebugTarget(launch, process);
		try {
			engine.init(eObjectToExecute, args, target, requestPort, replyPort, eventPort) ;
			target.connect(requestPort, replyPort, eventPort) ;
			launch.addDebugTarget(target);
			engineJob.setDebugTarget(target) ;
			engineJob.schedule() ;
		} catch (UnknownHostException e) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(e) ;
		} catch (IOException e) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(e) ;
		}
			
	}

	/**
	 * A convenience method for instantiating the actual execution engine.
	 * The class to be instantiated is determined in the Moka preference page (see MokaConstants.DEFAULT_EXECUTION_ENGINE)
	 * Any engine contributing to MokaConstants.ENGINE_EXTENSION_POINT_ID can be selected in this preference page.
	 * 
	 * @return
	 */
	protected IExecutionEngine instantiateExecutionEngine() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
		try {
			IConfigurationElement e = null;
			String selectedExecutionEngine = "" + Activator.getDefault().getPreferenceStore().getString(MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF);
			for(int i = 0; i < config.length; i++) {
				if(config[i].getNamespaceIdentifier().equals(selectedExecutionEngine))
					e = config[i];
			}
			final Object o = e.createExecutableExtension("class");
			return (IExecutionEngine)o ;
		} catch (CoreException ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex) ;
		} catch (Exception ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex) ;
		}
		// If null is returned, the calling method (launch) fires a CoreException
		return null ; 
	}

	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 * This code has been duplicated from the PDAExample. See http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free port
	 */
	protected static int findFreePort() {
		ServerSocket socket= null;
		try {
			socket= new ServerSocket(0);
			return socket.getLocalPort();
		} catch (IOException e) { 
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return -1;		
	}

	/**
	 * A convenience method for aborting launching.
	 * This code has been duplicated from the PDAExample. See http://www.eclipse.org/articles/Article-Debugger/how-to.html
	 * 
	 * @param message 
	 * @param e
	 * @throws CoreException
	 */
	protected void abort(String message, Throwable e) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, MokaConstants.MOKA_DEBUG_MODEL_ID, 0, message, e));
	}

}
