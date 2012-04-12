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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.service.types.Activator;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.matcher.BlockMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.PartPropertyMatcher;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/** SysML Property Part edit helper advice */
public class PartPropertyEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Check if the creation context is a {@link Block}.
	 * 
	 * @see org.eclipse.papyrus.sysml.service.types.helper.AbstractStereotypedElementEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return true if the request is approved
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		boolean isApproved = super.approveRequest(request);

		if((request != null) && (request instanceof GetEditContextRequest)) {

			// Retrieve the edit context from request
			GetEditContextRequest editContextRequest = (GetEditContextRequest)request;

			// Test if the edit context is a Block
			if(editContextRequest.getEditContext() instanceof Element) {
				Element contextElement = (Element)editContextRequest.getEditContext();

				IElementMatcher matcher = new BlockMatcher();
				if(!matcher.matches(contextElement)) {
					isApproved = false;
				}
			}
		}

		return isApproved;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDuplicateCommand(DuplicateElementsRequest request) {
		Object targetContainer = request.getParameter("Target_Owner");
		// additional element should be a set of elements that will be duplicated. If this is null, the request will be ignored.
		if(!(targetContainer instanceof EObject)) {
			return super.getBeforeDuplicateCommand(request);
		}
		Property partToBeDuplicated = getDuplicatedPart(request);
		if(partToBeDuplicated == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		Property newPart = (Property)request.getAllDuplicatedElementsMap().get(partToBeDuplicated);
		if(newPart == null) {
			Activator.log.debug("Trying to create a command for a new part which has not been created yet");
			return super.getBeforeDuplicateCommand(request);
		}

		// check association has not be duplicated yet
		Association originalAssociation = partToBeDuplicated.getAssociation();
		Association newAssociation = (Association)request.getAllDuplicatedElementsMap().get(originalAssociation);
		if(newAssociation != null && newAssociation.equals(newPart.getAssociation())) {
			return super.getBeforeDuplicateCommand(request);
		}

		TransactionalEditingDomain editingDomain = getEditingDomain(partToBeDuplicated);
		if(editingDomain == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		Package targetPackage = getTargetContainer((EObject)targetContainer, partToBeDuplicated, newPart, request.getAllDuplicatedElementsMap());
		return new DuplicatePapyrusAssociationCommand(editingDomain, "Duplicate Association for part", originalAssociation, request.getAllDuplicatedElementsMap(), targetPackage);
	}

	/**
	 * Computes the target container for the new association
	 * 
	 * @param targetContainer
	 *        the target container of the association creation request
	 * @param partToBeDuplicated
	 *        the part which was duplicated
	 * @param newPart
	 *        the new part linked to the association
	 * @param allDuplicatedElementsMap
	 *        the map of all duplicated elements
	 * @return the target {@link Package} for the new association or <code>null</code> if no package was found
	 */
	protected Package getTargetContainer(EObject targetContainer, Property partToBeDuplicated, Property newPart, Map allDuplicatedElementsMap) {

		// 1. look if the new part has a nearest package
		// 2. look if the part to be duplicated has a package which has a copy
		// 3. if target container == package => this can be the place where the association could be placed
		// 4. look for the nearest package of the target container

		Package result = newPart.getNearestPackage();
		if(result != null) {
			return result;
		}

		Package originalPackage = partToBeDuplicated.getNearestPackage();
		// look for its equivalent in the list of duplicated objects
		Object o = allDuplicatedElementsMap.get(originalPackage);
		if(o instanceof Package) {
			return (Package)o;
		}

		if(targetContainer instanceof Package) {
			return ((Package)targetContainer);
		}

		if(targetContainer instanceof Element) {
			return ((Element)targetContainer).getNearestPackage();
		}

		return null;
	}

	/**
	 * Get the editing domain from an {@link EObject}
	 * 
	 * @param eObject
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)editingDomain;
		}
		return null;
	}

	/**
	 * Returns the Part to be duplicated
	 * 
	 * @return the Part to be duplicated or <code>null</code> if this is not a part
	 */
	protected Property getDuplicatedPart(DuplicateElementsRequest request) {
		List<Object> elementsToBeDuplicated = request.getElementsToBeDuplicated();
		if(elementsToBeDuplicated == null || elementsToBeDuplicated.isEmpty()) {
			return null;
		}
		Object firstElement = elementsToBeDuplicated.get(0); // there should be only one element here
		if(!(firstElement instanceof Property)) {
			return null;
		}
		PartPropertyMatcher matcher = new PartPropertyMatcher();
		return matcher.matches((Property)firstElement) ? (Property)firstElement : null;
	}

	/** Complete creation process by setting name and default aggregation */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property element = (Property)request.getElementToConfigure();
				if(element != null) {

					// Set default name
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase("part", element.eContainer().eContents()); //$NON-NLS-1$
					element.setName(initializedName);
					// Initialize the aggregation to composite.
					element.setAggregation(AggregationKind.COMPOSITE_LITERAL);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}

	/**
	 * Complete creation process by adding the related association.
	 * This assumes the part type has been set at this point.
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property sourcePart = (Property)request.getElementToConfigure();
				if((sourcePart != null) && (sourcePart.getType() != null)) {

					// Create association between element owner and element type
					Type sourceType = sourcePart.getClass_();
					//Type targetType = sourcePart.getType();
					Package associationContainer = sourceType.getNearestPackage();

					// Create targetProperty
					Property targetProperty = UMLFactory.eINSTANCE.createProperty();
					targetProperty.setType(sourceType);
					targetProperty.setName("");

					Association association = UMLFactory.eINSTANCE.createAssociation();
					association.getMemberEnds().add(sourcePart);
					association.getOwnedEnds().add(targetProperty);
					association.getMemberEnds().add(targetProperty);

					String associationName = NamedElementHelper.getDefaultNameWithIncrementFromBase("Association", associationContainer.eContents()); //$NON-NLS-1$
					association.setName(associationName);

					// Add SysML Nature on the new Association
					ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);

					association.setPackage(associationContainer);
				}
				return CommandResult.newOKCommandResult(sourcePart);
			}
		};
	}

	/**
	 * Command to duplicate an association and place it in a new container.
	 */
	public class DuplicatePapyrusAssociationCommand extends DuplicateEObjectsCommand {

		/** association to be duplicated */
		private final Association associationToDuplicate;

		/** target container */
		private final Package targetContainer;


		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects. Also sets the list of affected files to be the files,
		 * where the targetContainer is stored. Target container specifies the
		 * eObject into which the duplicated eObjects will be added.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param originalAssociation
		 *        <code>Association</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 * @param targetContainer
		 *        target package
		 */
		public DuplicatePapyrusAssociationCommand(TransactionalEditingDomain editingDomain, String label, Association originalAssociation, Map allDuplicatedObjectsMap, Package targetContainer) {
			super(editingDomain, label, Collections.singletonList(originalAssociation), allDuplicatedObjectsMap, targetContainer);
			this.associationToDuplicate = originalAssociation;
			this.targetContainer = targetContainer;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			// Remove elements whose container is getting copied.
			// ClipboardSupportUtil.getCopyElements(getObjectsToBeDuplicated());

			// Perform the copy and update the references.
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			copier.putAll(getAllDuplicatedObjectsMap());
			copier.copy(associationToDuplicate);
			copier.copyReferences();

			Association newAssociation = (Association)copier.get(associationToDuplicate);
			if(newAssociation == null) {
				return CommandResult.newErrorCommandResult("Impossible to find the copied association");
			}

			// note: can be executed only if targetcontainer is instanceof package, this means that there is no need to tests for null targetContainer 
			newAssociation.setPackage(targetContainer);
			String associationName = NamedElementHelper.getDefaultNameWithIncrementFromBase("Association", targetContainer.eContents()); //$NON-NLS-1$
			newAssociation.setName(associationName);
			return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		}

		@Override
		public boolean canExecute() {
			// should add some tests here? no need to test containement feature like previous, Table has no owner...
			return targetContainer instanceof Package;
		}
	}
}
