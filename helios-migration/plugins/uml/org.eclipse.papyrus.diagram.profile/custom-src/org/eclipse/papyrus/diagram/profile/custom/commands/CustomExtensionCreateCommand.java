/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.profile.custom.helper.ExtensionHelper;
import org.eclipse.papyrus.diagram.profile.custom.policies.CUMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.profile.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.profile.edit.commands.ExtensionCreateCommand;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <pre>
 * This class is a custom creation command for Extension.
 * 
 * Difficulties for Extension creation:
 * - differences between semantic (ExtensionEnd) graphical (Stereotype) ends of Extension 
 * 
 * 
 * The Extension source is declared as ExtensionEnd in the GMFGEN model to ensure correct validation,
 * but the real source is Stereotype.
 * 
 * </pre>
 */
/**
 * This class looks like org.eclipse.papyrus.diagram.composite.custom.edit.commandConnectorCreateCommand
 */
public class CustomExtensionCreateCommand extends ExtensionCreateCommand {

	/** Source of Extension (cannot use original due to private visibility) **/
	private final EObject source;

	/** Target of Extension (cannot use original due to private visibility) **/
	private final EObject target;

	/** Graphical parent of Source **/
	protected Property sourcePartWithPort = null;

	/**
	 * @generated
	 */
	//private final Component container;

	/**
	 * Constructor of Extension custom creation command
	 * 
	 * @param req
	 *        the creation request
	 * @param source
	 *        the extension source element
	 * @param target
	 *        the extension target element
	 */
	public CustomExtensionCreateCommand(CreateRelationshipRequest req, EObject source, EObject target) {
		super(req, source, target);
		this.source = source;
		this.target = target;
		// Resolve graphical parents of source store in request as Parameters
		// This parameter is added in request by (custom) GraphicalNodeEditPolicy
		if(req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT) instanceof Property) {
			sourcePartWithPort = (Property)req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT);
		}
	}


	/**
	 * Replaces the original getter which is cast as ExtensionEnd (expected end of Extension)
	 * 
	 * @return the element that is graphically connected to Extension as source
	 */
	protected Stereotype _getSource() {
		return (Stereotype)source;
	}

	/**
	 * <pre>
	 * Checks if the Extension can be created or not.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Stereotype) {
			return false;
		}
		if(target != null && false == target instanceof Class) {

			return false;
		}


		if(_getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}


		return CUMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateExtension_1013(getContainer(), _getSource(), getTarget());
	}

	/**
	 * <pre>
	 * Creates the new Connector.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		//create the extension
		Extension newExtension = UMLFactory.eINSTANCE.createExtension();
		newExtension.setName(ExtensionHelper.EXTENSION + _getSource().getName());

		//create the endSource
		ExtensionEnd endSource = UMLFactory.eINSTANCE.createExtensionEnd();

		if(_getSource() instanceof Stereotype) {
			//initialize the endSource
			endSource.setName(ExtensionHelper.EXTENSION.replaceFirst("E", "e") + _getSource().getName()); //$NON-NLS-1$ //$NON-NLS-2$
			endSource.setType(_getSource());
			endSource.setAggregation(AggregationKind.COMPOSITE_LITERAL);

			//add the endSource to the extension
			newExtension.getOwnedEnds().add(endSource); // add extension end to extension


			//create source_property
			Property property = UMLFactory.eINSTANCE.createProperty();
			property.setName(ExtensionHelper.BASE + getTarget().getName());
			//	property.setIsDerived(true);
			property.setType(getTarget()); // set the type
			property.setAssociation(newExtension); // Set the association link
			property.setAggregation(AggregationKind.NONE_LITERAL);

			//Association End à la place de la property
			newExtension.getMemberEnds().add(property);


			_getSource().getOwnedAttributes().add(property);

		}

		else {
			throw new ExecutionException("Invalid source in create Connector command"); //$NON-NLS-1$
		}




		doConfigure(newExtension, monitor, info);
		getContainer().getPackagedElements().add(newExtension);

		((CreateElementRequest)getRequest()).setNewElement(newExtension);
		return CommandResult.newOKCommandResult(newExtension);
	}

	/**
	 * @generated
	 */
	@Override
	protected void doConfigure(Extension newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, _getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);

		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}



}
