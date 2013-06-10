/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.dialogs;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.IInteractionOverviewPreferenceConstants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Sets;

public class CreateInteractionUseDialog extends CreateInvocationActionDialog {

	public CreateInteractionUseDialog(final Shell shell, final Activity owner, final InvocationAction newAction) {
		super(shell, owner, newAction);
	}

	/**
	 * Get the id of the preference storing whether selection is the default
	 * choice.
	 * 
	 * @return preference id
	 */
	@Override
	protected String getSelectionIsDefaultPreference() {
		return IInteractionOverviewPreferenceConstants.PREF_NEW_INTERACTION_USE_SELECT_AS_DEFAULT;
	}

	/**
	 * Get the id of the preference storing the last selected owner.
	 * 
	 * @return preference id
	 */
	@Override
	protected String getCreationDefaultOwnerPreference() {
		return IInteractionOverviewPreferenceConstants.PREF_NEW_INTERACTION_USE_CREATION_OWNER;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionTitle()
	 */
	@Override
	protected String getInvocationCreationSectionTitle() {
		return Messages.CreateCallActionDialog_BehaviorInvocationCreationTitle;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionHelp()
	 */
	@Override
	protected String getInvocationCreationSectionHelp() {
		return Messages.CreateCallActionDialog_BehaviorInvocationCreationHelp;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationSelectionSectionTitle()
	 */
	@Override
	protected String getInvocationSelectionSectionTitle() {
		return Messages.CreateCallActionDialog_BehaviorInvocationSelectionTitle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateCallActionDialog#getTitle()
	 */
	@Override
	protected String getTitle() {
		return Messages.CreateCallActionDialog_BehaviorTitle;
	}

	@Override
	protected EClass[] getPossibleInvokedTypes() {
		return new EClass[]{ UMLPackage.eINSTANCE.getInteraction() };
	}

	@Override
	protected String getCreationLabel() {
		return Messages.CreateCallActionDialog_CreateBehavior;
	}

	@Override
	protected String getSelectionLabel() {
		return Messages.CreateCallActionDialog_SelectBehavior;
	}

	@Override
	protected void createExtraSections(final Composite pParent, final FormToolkit pToolkit) {
	}

	@Override
	protected Set<? extends EClassifier> getPossibleInvokedParents(final EObject actionParent) {
		return Sets.newHashSet(UMLPackage.Literals.PACKAGE, UMLPackage.Literals.BEHAVIORED_CLASSIFIER);
	}

	@Override
	protected boolean isPossibleInvokedParent(final EObject parent) {
		return parent instanceof Package || parent instanceof BehavioredClassifier;
	}

	@Override
	protected EReference getInvocationFeature() {
		return UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior();
	}

	@Override
	protected Image getParentImage() {
		return UMLElementTypes.getImage(UMLPackage.eINSTANCE.getPackage());
	}

	/**
	 * Set correctly the invoked object, by creating it if needed. Then,
	 * notifies that the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		final boolean isSelectionSelected = selectionRadio.getSelection();
		// create element if needed
		if(!isSelectionSelected) {
			selectedInvoked = UMLFactory.eINSTANCE.createInteraction();
			if(selectedInvoked instanceof NamedElement) {
				((NamedElement)selectedInvoked).setName(selectedName);
			}
			addInvokedInParent(selectedParent, selectedInvoked);
		}

		// InteractionUse
		final InteractionUse interactionUse = UMLFactory.eINSTANCE.createInteractionUse();
		interactionUse.setRefersTo((Interaction)selectedInvoked);
		interactionUse.setName(Messages.CreateInteractionUseDialog_InteractionUsePrefix + ((Interaction)selectedInvoked).getName());

		addInvokedInParent(selectedInvoked, interactionUse);

		// store user choices in preference
		final IPreferenceStore prefStore = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		// store choice between selection and creation
		prefStore.setValue(getSelectionIsDefaultPreference(), isSelectionSelected);
		if(!isSelectionSelected) {
			// store the owner choice
			final String ressUri = selectedParent.eResource().getURI().toString();
			final String parentURI = selectedParent.eResource().getURIFragment(selectedParent);
			final String prefValue = String.format(MAP_FORMAT, ressUri, parentURI);
			prefStore.setValue(getCreationDefaultOwnerPreference(), prefValue);
		}
		setReturnCode(OK);
		close();
	}
}
