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

import org.eclipse.uml2.uml.Clause;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.OutputPin;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart;
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
public class ClauseBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Clause clause;

	/**
	 * The Base part
	 */
	private ClausePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ClauseBasePropertiesEditionComponent(EObject clause, String editing_mode) {
		if (clause instanceof Clause) {
			this.clause = (Clause) clause;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.clause.eAdapters().add(semanticAdapter);
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
					basePart.updateOwnedComment(clause);
				}
				if (UMLPackage.eINSTANCE.getClause_Test().equals(msg.getFeature()))
					basePart.updateTest(clause);
				if (UMLPackage.eINSTANCE.getClause_Body().equals(msg.getFeature()))
					basePart.updateBody(clause);
				if (UMLPackage.eINSTANCE.getClause_PredecessorClause().equals(msg.getFeature()))
					basePart.updatePredecessorClause(clause);
				if (UMLPackage.eINSTANCE.getClause_SuccessorClause().equals(msg.getFeature()))
					basePart.updateSuccessorClause(clause);
				if (UMLPackage.eINSTANCE.getClause_BodyOutput().equals(msg.getFeature()))
					basePart.updateBodyOutput(clause);

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
			return UMLViewsRepository.Clause.class;
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
		if (clause != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ClausePropertiesEditionPart) provider.getPropertiesEditionPart(UMLViewsRepository.Clause.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Clause.class) {
			((IPropertiesEditionPart) basePart).setContext(elt, allResource);
			Clause clause = (Clause) elt;
			basePart.initOwnedComment(clause, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			basePart.initTest(clause, null, UMLPackage.eINSTANCE.getClause_Test());
			basePart.initBody(clause, null, UMLPackage.eINSTANCE.getClause_Body());
			basePart.initPredecessorClause(clause, null, UMLPackage.eINSTANCE.getClause_PredecessorClause());
			basePart.initSuccessorClause(clause, null, UMLPackage.eINSTANCE.getClause_SuccessorClause());
			basePart.initBodyOutput(clause, null, UMLPackage.eINSTANCE.getClause_BodyOutput());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (clause != null) {
			List ownedCommentToAdd = basePart.getOwnedCommentToAdd();
			for (Iterator iter = ownedCommentToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List testToAdd = basePart.getTestToAdd();
			for (Iterator iter = testToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), iter.next()));
			List testToRemove = basePart.getTestToRemove();
			for (Iterator iter = testToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), iter.next()));
			// List testToMove = basePart.getTestToMove();
			// for (Iterator iter = testToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List bodyToAdd = basePart.getBodyToAdd();
			for (Iterator iter = bodyToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), iter.next()));
			List bodyToRemove = basePart.getBodyToRemove();
			for (Iterator iter = bodyToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), iter.next()));
			// List bodyToMove = basePart.getBodyToMove();
			// for (Iterator iter = bodyToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List predecessorClauseToAdd = basePart.getPredecessorClauseToAdd();
			for (Iterator iter = predecessorClauseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), iter.next()));
			List predecessorClauseToRemove = basePart.getPredecessorClauseToRemove();
			for (Iterator iter = predecessorClauseToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), iter.next()));
			// List predecessorClauseToMove = basePart.getPredecessorClauseToMove();
			// for (Iterator iter = predecessorClauseToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List successorClauseToAdd = basePart.getSuccessorClauseToAdd();
			for (Iterator iter = successorClauseToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), iter.next()));
			List successorClauseToRemove = basePart.getSuccessorClauseToRemove();
			for (Iterator iter = successorClauseToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), iter.next()));
			// List successorClauseToMove = basePart.getSuccessorClauseToMove();
			// for (Iterator iter = successorClauseToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause(), moveElement.getElement(), moveElement.getIndex()));
			// }
			List bodyOutputToAdd = basePart.getBodyOutputToAdd();
			for (Iterator iter = bodyOutputToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), iter.next()));
			List bodyOutputToRemove = basePart.getBodyOutputToRemove();
			for (Iterator iter = bodyOutputToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), iter.next()));
			// List bodyOutputToMove = basePart.getBodyOutputToMove();
			// for (Iterator iter = bodyOutputToMove.iterator(); iter.hasNext();){
			// org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			// cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
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
		if (source instanceof Clause) {
			Clause clauseToUpdate = (Clause) source;
			clauseToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			clauseToUpdate.getTests().addAll(basePart.getTestToAdd());
			clauseToUpdate.getBodies().addAll(basePart.getBodyToAdd());
			clauseToUpdate.getPredecessorClauses().addAll(basePart.getPredecessorClauseToAdd());
			clauseToUpdate.getSuccessorClauses().addAll(basePart.getSuccessorClauseToAdd());
			clauseToUpdate.getBodyOutputs().addAll(basePart.getBodyOutputToAdd());

			return clauseToUpdate;
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
			if (UMLViewsRepository.Clause.ownedComment == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment) event.getOldValue();
					Comment newValue = (Comment) event.getNewValue();

					// Start of user code for ownedComment live update command
					// TODO: Complete the clause update command
					// End of user code
				} else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Clause.test == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Clause.body == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Clause.predecessorClause == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Clause.successorClause == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Clause.bodyOutput == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue(), event.getNewIndex()));
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
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == UMLViewsRepository.Clause.ownedComment)
			return "The Comments owned by this element."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Clause.test)
			return "A nested activity fragment with a designated output pin that specifies the result of the test."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Clause.body)
			return "A nested activity fragment that is executed if the test evaluates to true and the clause is chosen over any concurrent clauses that also evaluate to true."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Clause.predecessorClause)
			return "A set of clauses whose tests must all evaluate false before the current clause can be tested."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Clause.successorClause)
			return "A set of clauses which may not be tested unless the current clause tests false."; //$NON-NLS-1$
		if (key == UMLViewsRepository.Clause.bodyOutput)
			return "A list of output pins within the body fragment whose values are moved to the result pins of the containing conditional node after execution of the clause body."; //$NON-NLS-1$
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
			return Diagnostician.INSTANCE.validate(clause);
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
			clause.eAdapters().remove(semanticAdapter);
	}

}
