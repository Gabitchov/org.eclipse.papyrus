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

import org.eclipse.uml2.uml.ExceptionHandler;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UMLFactory;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ExceptionHandlerPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ExceptionHandlerBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private ExceptionHandler exceptionHandler;

	/**
	 * The Base part
	 */
	private ExceptionHandlerPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ExceptionHandlerBasePropertiesEditionComponent(EObject exceptionHandler, String editing_mode) {
		if (exceptionHandler instanceof ExceptionHandler) {
			this.exceptionHandler = (ExceptionHandler) exceptionHandler;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.exceptionHandler.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(exceptionHandler);
				}
				if (UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType().equals(msg.getFeature()))
					basePart.updateExceptionType(exceptionHandler);

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
			return UMLViewsRepository.ExceptionHandler.class;
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
		if (exceptionHandler != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ExceptionHandlerPropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.ExceptionHandler.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.ExceptionHandler.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			ExceptionHandler exceptionHandler = (ExceptionHandler) elt;
			basePart.initOwnedComment(exceptionHandler, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			basePart.initExceptionType(exceptionHandler, null, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (exceptionHandler != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, exceptionHandler, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, exceptionHandler, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List exceptionTypeToAdd = basePart.getExceptionTypeToAdd();
			for (Iterator iter = exceptionTypeToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, exceptionHandler, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType(), iter.next()));
			List exceptionTypeToRemove = basePart.getExceptionTypeToRemove();
			for (Iterator iter = exceptionTypeToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, exceptionHandler, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType(), iter.next()));
			// List exceptionTypeToMove = basePart.getExceptionTypeToMove();
			// for (Iterator iter = exceptionTypeToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, exceptionHandler, UMLPackage.eINSTANCE.getClassifier(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof ExceptionHandler) {
			ExceptionHandler exceptionHandlerToUpdate = (ExceptionHandler) source;
			exceptionHandlerToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			exceptionHandlerToUpdate.getExceptionTypes().addAll(basePart.getExceptionTypeToAdd());

			return exceptionHandlerToUpdate;
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
			if (UMLViewsRepository.ExceptionHandler.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the exceptionHandler update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, exceptionHandler, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, exceptionHandler, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.ExceptionHandler.exceptionType == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, exceptionHandler, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, exceptionHandler, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, exceptionHandler, UMLPackage.eINSTANCE.getExceptionHandler_ExceptionType(), event.getNewValue(), event.getNewIndex()));
			}

			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {

			} else {

			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.ExceptionHandler.exceptionType;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.ExceptionHandler.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.ExceptionHandler.exceptionType)
			return "The kind of instances that the handler catches. If an exception occurs whose type is any of the classifiers in the set, the handler catches the exception and executes its body."; //$NON-NLS-1$
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
			return Diagnostician.INSTANCE.validate(exceptionHandler);
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
			exceptionHandler.eAdapters().remove(semanticAdapter);
	}

}
