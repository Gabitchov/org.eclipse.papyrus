/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.uml2.uml.Connector;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ConnectorPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ConnectorBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Connector connector;

	/**
	 * The Base part
	 */
	private ConnectorPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ConnectorBasePropertiesEditionComponent(EObject connector, String editing_mode) {
		if (connector instanceof Connector) {
			this.connector = (Connector) connector;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.connector.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getComment())) {
					basePart.updateOwnedComment(connector);
				}
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
					basePart.updateClientDependency(connector);
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getFeature_IsStatic().equals(msg.getFeature()) && basePart != null)
					basePart.setIsStatic((Boolean) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getConnector_RedefinedConnector().equals(msg.getFeature()))
					basePart.updateRedefinedConnector(connector);
				if (msg.getFeature() != null
						&& (((EStructuralFeature) msg.getFeature()) == UMLPackage.eINSTANCE.getConnector_End() || ((EStructuralFeature) msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE
								.getConnectorEnd())) {
					basePart.updateEnd(connector);
				}
				if (UMLPackage.eINSTANCE.getConnector_Kind().equals(msg.getFeature()) && basePart != null)
					basePart.setKind((Enumerator) msg.getNewValue());

				if (UMLPackage.eINSTANCE.getConnector_Contract().equals(msg.getFeature()))
					basePart.updateContract(connector);

			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.Connector.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (connector != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ConnectorPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Connector.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart) basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.Connector.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Connector connector = (Connector) elt;
			basePart.initOwnedComment(connector, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if (connector.getName() != null)
				basePart.setName(connector.getName());

			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), connector.getVisibility());
			basePart.initClientDependency(connector, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(connector.isLeaf());

			basePart.setIsStatic(connector.isStatic());

			basePart.initRedefinedConnector(connector, null, UMLPackage.eINSTANCE.getConnector_RedefinedConnector());
			basePart.initEnd(connector, null, UMLPackage.eINSTANCE.getConnector_End());
			basePart.initKind((EEnum) UMLPackage.eINSTANCE.getConnector_Kind().getEType(), connector.getKind());
			basePart.initContract(connector, null, UMLPackage.eINSTANCE.getConnector_Contract());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (connector != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefresh = basePart.getOwnedCommentToEdit();
			for (Iterator iter = ownedCommentToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for ownedComment reference refreshment

				Comment nextElement = (Comment) iter.next();
				Comment ownedComment = (Comment) ownedCommentToRefresh.get(nextElement);

				// End of user code
			}
			List ownedCommentToRemove = basePart.getOwnedCommentToRemove();
			for (Iterator iter = ownedCommentToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMove = basePart.getOwnedCommentToMove();
			for (Iterator iter = ownedCommentToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAdd = basePart.getClientDependencyToAdd();
			for (Iterator iter = clientDependencyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemove = basePart.getClientDependencyToRemove();
			for (Iterator iter = clientDependencyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			// List clientDependencyToMove = basePart.getClientDependencyToMove();
			// for (Iterator iter = clientDependencyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			// }
			cc.append(SetCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			cc.append(SetCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getFeature_IsStatic(), basePart.getIsStatic()));

			List redefinedConnectorToAdd = basePart.getRedefinedConnectorToAdd();
			for (Iterator iter = redefinedConnectorToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_RedefinedConnector(), iter.next()));
			List redefinedConnectorToRemove = basePart.getRedefinedConnectorToRemove();
			for (Iterator iter = redefinedConnectorToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_RedefinedConnector(), iter.next()));
			// List redefinedConnectorToMove = basePart.getRedefinedConnectorToMove();
			// for (Iterator iter = redefinedConnectorToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List endToAdd = basePart.getEndToAdd();
			for (Iterator iter = endToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_End(), iter.next()));
			Map endToRefresh = basePart.getEndToEdit();
			for (Iterator iter = endToRefresh.keySet().iterator(); iter.hasNext();) {

				// Start of user code for end reference refreshment

				ConnectorEnd nextElement = (ConnectorEnd) iter.next();
				ConnectorEnd end = (ConnectorEnd) endToRefresh.get(nextElement);

				// End of user code
			}
			List endToRemove = basePart.getEndToRemove();
			for (Iterator iter = endToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List endToMove = basePart.getEndToMove();
			for (Iterator iter = endToMove.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement) iter.next();
				cc.append(MoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnectorEnd(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_Kind(), basePart.getKind()));

			List contractToAdd = basePart.getContractToAdd();
			for (Iterator iter = contractToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_Contract(), iter.next()));
			List contractToRemove = basePart.getContractToRemove();
			for (Iterator iter = contractToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getConnector_Contract(), iter.next()));
			// List contractToMove = basePart.getContractToMove();
			// for (Iterator iter = contractToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, connector, UMLPackage.eINSTANCE.getBehavior(), moveElement.getElement(), moveElement.getIndex()));
			// }

		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof Connector) {
			Connector connectorToUpdate = (Connector) source;
			connectorToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			connectorToUpdate.setName(basePart.getName());

			connectorToUpdate.setVisibility((VisibilityKind) basePart.getVisibility());

			connectorToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			connectorToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			connectorToUpdate.setIsStatic(new Boolean(basePart.getIsStatic()).booleanValue());

			connectorToUpdate.getRedefinedConnectors().addAll(basePart.getRedefinedConnectorToAdd());
			connectorToUpdate.getEnds().addAll(basePart.getEndToAdd());
			connectorToUpdate.setKind((ConnectorKind) basePart.getKind());

			connectorToUpdate.getContracts().addAll(basePart.getContractToAdd());

			return connectorToUpdate;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.Connector.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the connector update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Connector.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if (UMLViewsRepository.Connector.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Connector.clientDependency == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Connector.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.Connector.isStatic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getFeature_IsStatic(), event.getNewValue()));

			if (UMLViewsRepository.Connector.redefinedConnector == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_RedefinedConnector(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_RedefinedConnector(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_RedefinedConnector(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Connector.end == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					ConnectorEnd oldValue = (ConnectorEnd) event.getOldValue();
					ConnectorEnd newValue = (ConnectorEnd) event.getNewValue();

					// Start of user code for end live update command
					// TODO: Complete the connector update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_End(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnectorEnd(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Connector.kind == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_Kind(), event.getNewValue()));

			if (UMLViewsRepository.Connector.contract == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_Contract(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_Contract(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, connector, UMLPackage.eINSTANCE.getConnector_Contract(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

				if (UMLViewsRepository.Connector.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);

			} else {

				if (UMLViewsRepository.Connector.name == event.getAffectedEditor())
					basePart.unsetMessageForName();

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.Connector.isLeaf || key == UMLViewsRepository.Connector.isStatic || key == UMLViewsRepository.Connector.end;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Connector.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.name)
			return "The name of the NamedElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.visibility)
			return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.clientDependency)
			return "Indicates the dependencies that reference the client."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.isLeaf)
			return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.isStatic)
			return "Specifies whether this feature characterizes individual instances classified by the classifier (false) or the classifier itself (true)."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.redefinedConnector)
			return "A connector may be redefined when its containing classifier is specialized. The redefining connector may have a type that specializes the type of the redefined connector. The types of the connector ends of the redefining connector may specialize the types of the connector ends of the redefined connector. The properties of the connector ends of the redefining connector may be replaced."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.end)
			return "A connector consists of at least two connector ends, each representing the participation of instances of the classifiers typing the connectable elements attached to this end. The set of connector ends is ordered."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.kind)
			return "Indicates the kind of connector."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Connector.contract)
			return "The set of Behaviors that specify the valid interaction patterns across the connector."; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.Connector.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Connector.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Connector.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Connector.isStatic == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getFeature_IsStatic().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Connector.kind == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getConnector_Kind().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getConnector_Kind().getEAttributeType(), newValue);
			}

		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		} else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			return Diagnostician.INSTANCE.validate(connector);
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			connector.eAdapters().remove(semanticAdapter);
	}

}
