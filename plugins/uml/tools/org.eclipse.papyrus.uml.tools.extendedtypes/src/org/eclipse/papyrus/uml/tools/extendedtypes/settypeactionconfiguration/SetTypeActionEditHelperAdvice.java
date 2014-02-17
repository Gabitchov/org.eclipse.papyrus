/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.extendedtypes.settypeactionconfiguration;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.extendedtypes.IActionEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.emf.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElement;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;

/**
 * advice for the {@link ApplyStereotypeActionConfiguration}
 */
public class SetTypeActionEditHelperAdvice extends AbstractEditHelperAdvice implements IActionEditHelperAdvice<SetTypeActionConfiguration> {

	/** configuration for this edit helper advice */
	protected SetTypeActionConfiguration configuration;

	/**
	 * {@inheritDoc}
	 */
	public void init(SetTypeActionConfiguration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		return super.approveRequest(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		return super.getBeforeConfigureCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		if(configuration==null) {
			return null;
		}
		ICommand resultCommand = null;
		// retrieve eobject 
		final EObject elementToConfigure = request.getElementToConfigure();
		if(!(elementToConfigure instanceof Element)) {
			return null;
		}
		
		final TransactionalEditingDomain editingDomain = request.getEditingDomain();
		if(editingDomain ==null) {
			return null;
		}
		// retrieve edit service to get features from configure command
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(elementToConfigure);
		if(service == null) {
			Activator.log.error("Impossible to get edit service from element: " + elementToConfigure, null);
			return null;
		}
		
		 resultCommand = new AbstractTransactionalCommand(editingDomain, "Editing type", Arrays.asList((WorkspaceSynchronizer.getFile(elementToConfigure.eResource())))) {
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				UMLModelElement umlModelElement = new UMLModelElement(elementToConfigure, editingDomain);
				ReferenceValueFactory factory = umlModelElement.getValueFactory("type");
				Object elemObject = factory.edit(Display.getDefault().getFocusControl(), elementToConfigure);
				return CommandResult.newOKCommandResult(elemObject);
			}
		};
		
		return resultCommand;
	}

	/**
	 * @return
	 */
	protected EObject getDefaultTypeContainer(ConfigureRequest request) {
		if(request.getElementToConfigure() instanceof Element) {
			return ((Element)request.getElementToConfigure()).getNearestPackage();
		}
		return request.getElementToConfigure().eContainer();
	}

	
}
