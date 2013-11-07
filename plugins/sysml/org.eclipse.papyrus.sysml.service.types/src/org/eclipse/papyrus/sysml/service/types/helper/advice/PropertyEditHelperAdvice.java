/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.utils.RequestParameterConstants;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.service.types.Activator;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * <pre>
 * This HelperAdvice completes {@link Property} edit commands with:
 * 		- possibly required (sysML) association re-factor command.
 * </pre>
 */
public class PropertyEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While setting {@link Property} (excluding {@link Port} and {@link ConstraintParameter} type:
	 * - add possibly required (sysML) association re-factor command when needed.
	 * - add/remove possibly required ConstraintProperty stereotype when needed.
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
  		ICommand gmfCommand = super.getBeforeSetCommand(request);

		EObject elementToEdit = request.getElementToEdit();
		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && 
				(request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && (request.getValue() instanceof Type)) {

			Property propertyToEdit = (Property)elementToEdit;

			// SysML specification : all property typed by a ConstraintBlock must have a ContraintProperty stereotype applied
			if (request.getValue() instanceof org.eclipse.uml2.uml.Class) {
				ICommand stereotypeApplicationCommand = getConstraintPropertyStereotypeApplicationCommand(propertyToEdit, (org.eclipse.uml2.uml.Class)request.getValue(), request);
				gmfCommand = CompositeCommand.compose(gmfCommand, stereotypeApplicationCommand);
			}

			// Exclude ConstraintParameter (simple property without ConstraintProperty stereotype owned by a ConstraintBlock) 
			if (propertyToEdit.eContainer() instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication((Element)propertyToEdit.eContainer(), ConstraintBlock.class) != null) {
				if (UMLUtil.getStereotypeApplication(propertyToEdit, ConstraintProperty.class) == null) {
					return gmfCommand;
				}
			}

			Association relatedAssociation = propertyToEdit.getAssociation();

			// The edited property has to be related to a SysML association
			if((relatedAssociation == null) || !(ElementUtil.hasNature(relatedAssociation, SysMLElementTypes.SYSML_NATURE))) {
				
				// If no association exist and the new type is a Block 
				// (not a ConstraintBlock => a property typed by a ConstraintBlock is a ConstraintProperty, not a Part neither a Reference),
				// add the association
				if ((relatedAssociation == null) 
					&& ((ISpecializationType) SysMLElementTypes.BLOCK).getMatcher().matches((Type) request.getValue())
					&& !((ISpecializationType) SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches((Type) request.getValue())
					&& ((ISpecializationType) SysMLElementTypes.BLOCK).getMatcher().matches(propertyToEdit.eContainer())) {
					
					ICommand addAssociationCommand = getCreatePartAssociationCommand((org.eclipse.uml2.uml.Class)propertyToEdit.eContainer(), propertyToEdit, (org.eclipse.uml2.uml.Class)request.getValue());
					gmfCommand = CompositeCommand.compose(gmfCommand, addAssociationCommand);
				}
				
				return gmfCommand;
			}

			// Setting new type can be related to an association re-orient (or trigger the association re-orient)
			// Retrieve elements already under re-factor.
			List<EObject> currentlyRefactoredElements = (request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) != null) ? (List<EObject>)request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) : new ArrayList<EObject>();
			if(!currentlyRefactoredElements.contains(propertyToEdit)) {
				currentlyRefactoredElements.add(propertyToEdit);
				request.getParameters().put(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS, currentlyRefactoredElements);

				// Current association already under re-factor ?
				if(currentlyRefactoredElements.contains(relatedAssociation)) {
					return gmfCommand;
				}
			}

			// If the new type is not a block, destroy related association
			// This must be done only if the setting of the property type is not part of an association re-orient (hence after the previous code-block),
			// otherwise there is no legitimate reason to destroy the existing association while re-orienting it.
 			if (!((ISpecializationType) SysMLElementTypes.BLOCK).getMatcher().matches((Type) request.getValue()) && propertyToEdit.getType() != null) {
				ICommand destroyCommand = getDestroyPartAssociationCommand(relatedAssociation, propertyToEdit);
				gmfCommand = CompositeCommand.compose(gmfCommand, destroyCommand);
				
				return gmfCommand;
			}

			ICommand refactorCommand = getAssociationRefactoringCommand(propertyToEdit, relatedAssociation, request);
			gmfCommand = CompositeCommand.compose(gmfCommand, refactorCommand);
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}

	/**
	 * Create a re-factoring command related to a Property move.
	 * 
	 * @param setProperty
	 *        the property which type is set
	 * @param associationToRefactor
	 *        the association to re-factor (re-orient action)
	 * @param request
	 *        the original set request
	 * @return the re-factoring command
	 */
	private ICommand getAssociationRefactoringCommand(Property setProperty, Association associationToRefactor, SetRequest request) {

		Association relatedAssociation = setProperty.getAssociation(); // Should not be null, test before calling method.

		if (associationToRefactor.getMemberEnds().size() >= 2) {
			// Re-orient the related association (do not use edit service to avoid infinite loop here)
			int direction = ReorientRelationshipRequest.REORIENT_TARGET;
			if(setProperty == associationToRefactor.getMemberEnds().get(1)) {
				direction = ReorientRelationshipRequest.REORIENT_SOURCE;
			}
	
			ReorientRelationshipRequest reorientRequest = new ReorientRelationshipRequest(relatedAssociation, (Type)request.getValue(), setProperty.eContainer(), direction);
			reorientRequest.addParameters(request.getParameters());
	
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(relatedAssociation);
			if(provider != null) {
				return provider.getEditCommand(reorientRequest);
			}
		}

		return null;
	}
	
	/**
	 * Create a part association creation command.
	 * 
	 * @return the part association creation command
	 */
	private ICommand getCreatePartAssociationCommand(final org.eclipse.uml2.uml.Class sourceBlock, final Property sourceProperty, final org.eclipse.uml2.uml.Class targetBlock) {
		
		return new AbstractCommand("Create part association") {
			
			@Override
			protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
 				Association association = UMLFactory.eINSTANCE.createAssociation();
				
				// Add the association in the model
				org.eclipse.uml2.uml.Package container = (org.eclipse.uml2.uml.Package)EMFCoreUtil.getLeastCommonContainer(Arrays.asList(new EObject[]{sourceBlock, targetBlock}), UMLPackage.eINSTANCE.getPackage());
				container.getPackagedElements().add(association);
				
				// Use existing Property as source...
				association.getMemberEnds().add(sourceProperty);
				// ... and create the opposite (unnamed) Property
				Property targetProperty = UMLFactory.eINSTANCE.createProperty();
				association.getOwnedEnds().add(targetProperty);

				// Set Association name
				// Initialize the element name based on the created IElementType
				String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase(UMLPackage.eINSTANCE.getAssociation().getName(), association.eContainer().eContents());
				association.setName(initializedName);
				
				// Add SysML Nature on the new Association
				ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);
				
				return CommandResult.newOKCommandResult(association) ;
			}
		};

	}
	
	/**
	 * Apply/remove the ConstraintProperty stereotype application
	 * 
	 * @return the ConstraintProperty stereotype application command
	 */
	private ICommand getConstraintPropertyStereotypeApplicationCommand(final Property sourceProperty, final org.eclipse.uml2.uml.Class targetBlock, final SetRequest request) {
		
		return new AbstractTransactionalCommand(request.getEditingDomain(), "Apply/Remove ConstraintProperty Stereotype", null) {
				
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				// SysML specification : all property typed by a ConstraintBlock must have a ContraintProperty stereotype applied
				ConstraintProperty constraintPropertyApplication = UMLUtil.getStereotypeApplication(sourceProperty, ConstraintProperty.class);
				if (UMLUtil.getStereotypeApplication(targetBlock, ConstraintBlock.class) != null) {
					if (constraintPropertyApplication == null) {
						StereotypeApplicationHelper.INSTANCE.applyStereotype(sourceProperty, ConstraintsPackage.eINSTANCE.getConstraintProperty());
						final String diagramType = null;
						// Remove representations
						Set<View> memberViewsToDestroy = CrossReferencerUtil.getCrossReferencingViews(sourceProperty, diagramType);
						if (memberViewsToDestroy.size() != 0) {
							final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
							final String DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY = "displayMessageForTypingActionPreferenceKey";
							boolean contains = store.contains(DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY);
							if(!contains) {
								store.setValue(DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY, MessageDialogWithToggle.NEVER);
								store.setDefault(DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY, MessageDialogWithToggle.NEVER);
							}
							final String hideValue = store.getString(DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY);
							if(!hideValue.equals(MessageDialogWithToggle.ALWAYS)) {
								int size = memberViewsToDestroy.size();
								MessageDialogWithToggle.openInformation(Display.getDefault().getActiveShell(), 
										"Change Type Action", 
										"WARNING! Typing a Property by a ConstraintBlock make this property become a ConstraintProperty. ConstraintProperty have a specific representation. "
										+ "\nSo all representations of this property will be removed from the model  (" + size + " occurence" + ((size > 1) ? "s" : "") + ")."
										, "Don't show this dialog the next time", 
										false, store, DISPLAY_MESSAGE_FOR_TYPING_ACTION_PREFERENCE_KEY);
							}
							
						}
						for (View view : memberViewsToDestroy) {
							final DestroyElementRequest destroyRequest = new DestroyElementRequest(request.getEditingDomain(), view, false);
							final IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(view);
							ICommand editCommand = commandProvider.getEditCommand(destroyRequest);
							editCommand.execute(progressMonitor, info);
						}
					}
				}
				else {
					if (constraintPropertyApplication != null) {
						StereotypeApplicationHelper.INSTANCE.removeFromContainmentList(sourceProperty, constraintPropertyApplication);
					}
				}
				return CommandResult.newOKCommandResult(sourceProperty) ;
			}
		};
	}

	/**
	 * Create a part association destroy command.
	 * 
	 * @return the part association destroy command
	 */
	@SuppressWarnings("unchecked")
	private ICommand getDestroyPartAssociationCommand(Association partAssociation, Property propertyToEdit) {
				
		DestroyElementRequest request = new DestroyElementRequest(partAssociation, false);
		List<EObject> dependentsToKeep = Arrays.asList(new EObject[] { propertyToEdit });
		request.getParameters().put(RequestParameterConstants.DEPENDENTS_TO_KEEP, dependentsToKeep);
		
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(partAssociation.eContainer());
		if(provider == null) {
			return null;
		}
		ICommand destroyCommand = provider.getEditCommand(request);
		
		return destroyCommand;
	}
}
