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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.RedefinableTemplateSignaturePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class RedefinableTemplateSignatureBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private RedefinableTemplateSignature redefinableTemplateSignature;

	/**
	 * The Base part
	 */
	private RedefinableTemplateSignaturePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public RedefinableTemplateSignatureBasePropertiesEditionComponent(EObject redefinableTemplateSignature, String editing_mode) {
		if(redefinableTemplateSignature instanceof RedefinableTemplateSignature) {
			this.redefinableTemplateSignature = (RedefinableTemplateSignature)redefinableTemplateSignature;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.redefinableTemplateSignature.eAdapters().add(semanticAdapter);
			}
		}
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
				if(basePart == null)
					RedefinableTemplateSignatureBasePropertiesEditionComponent.this.dispose();
				else {
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getTemplateSignature_Parameter().equals(msg.getFeature()))
						basePart.updateParameter(redefinableTemplateSignature);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter())) {
						basePart.updateOwnedParameter(redefinableTemplateSignature);
					}
					if(UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature().equals(msg.getFeature()))
						basePart.updateExtendedSignature(redefinableTemplateSignature);


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if(BASE_PART.equals(key))
			return UMLViewsRepository.RedefinableTemplateSignature.class;
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
		if(redefinableTemplateSignature != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (RedefinableTemplateSignaturePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.RedefinableTemplateSignature.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent# setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if(key == UMLViewsRepository.RedefinableTemplateSignature.class)
			this.basePart = (RedefinableTemplateSignaturePropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.RedefinableTemplateSignature.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final RedefinableTemplateSignature redefinableTemplateSignature = (RedefinableTemplateSignature)elt;
			// init values
			if(redefinableTemplateSignature.getName() != null)
				basePart.setName(redefinableTemplateSignature.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), redefinableTemplateSignature.getVisibility());
			basePart.setIsLeaf(redefinableTemplateSignature.isLeaf());

			basePart.initParameter(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getTemplateSignature_Parameter());
			basePart.initOwnedParameter(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter());
			basePart.initExtendedSignature(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature());

			// init filters



			basePart.addFilterToParameter(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInParameterTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToParameter(new EObjectFilter(UMLPackage.eINSTANCE.getTemplateParameter()));
			// Start of user code for additional businessfilters for parameter

			// End of user code
			basePart.addFilterToOwnedParameter(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedParameter

			// End of user code
			basePart.addFilterToExtendedSignature(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInExtendedSignatureTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToExtendedSignature(new EObjectFilter(UMLPackage.eINSTANCE.getRedefinableTemplateSignature()));
			// Start of user code for additional businessfilters for extendedSignature

			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *      (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if(redefinableTemplateSignature != null) {
			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List parameterToAddFromParameter = basePart.getParameterToAdd();
			for(Iterator iter = parameterToAddFromParameter.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), iter.next()));
			List parameterToRemoveFromParameter = basePart.getParameterToRemove();
			for(Iterator iter = parameterToRemoveFromParameter.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), iter.next()));
			//List parameterToMoveFromParameter = basePart.getParameterToMove();
			//for (Iterator iter = parameterToMoveFromParameter.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedParameterToAddFromOwnedParameter = basePart.getOwnedParameterToAdd();
			for(Iterator iter = ownedParameterToAddFromOwnedParameter.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter(), iter.next()));
			Map ownedParameterToRefreshFromOwnedParameter = basePart.getOwnedParameterToEdit();
			for(Iterator iter = ownedParameterToRefreshFromOwnedParameter.keySet().iterator(); iter.hasNext();) {



				TemplateParameter nextElement = (TemplateParameter)iter.next();
				TemplateParameter ownedParameter = (TemplateParameter)ownedParameterToRefreshFromOwnedParameter.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedParameter.eGet(feature)));
					}
				}



			}
			List ownedParameterToRemoveFromOwnedParameter = basePart.getOwnedParameterToRemove();
			for(Iterator iter = ownedParameterToRemoveFromOwnedParameter.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterToMoveFromOwnedParameter = basePart.getOwnedParameterToMove();
			for(Iterator iter = ownedParameterToMoveFromOwnedParameter.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extendedSignatureToAddFromExtendedSignature = basePart.getExtendedSignatureToAdd();
			for(Iterator iter = extendedSignatureToAddFromExtendedSignature.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), iter.next()));
			List extendedSignatureToRemoveFromExtendedSignature = basePart.getExtendedSignatureToRemove();
			for(Iterator iter = extendedSignatureToRemoveFromExtendedSignature.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), iter.next()));
			//List extendedSignatureToMoveFromExtendedSignature = basePart.getExtendedSignatureToMove();
			//for (Iterator iter = extendedSignatureToMoveFromExtendedSignature.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature(), moveElement.getElement(), moveElement.getIndex()));
			//}


		}
		if(!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if(source instanceof RedefinableTemplateSignature) {
			RedefinableTemplateSignature redefinableTemplateSignatureToUpdate = (RedefinableTemplateSignature)source;
			redefinableTemplateSignatureToUpdate.setName(basePart.getName());

			redefinableTemplateSignatureToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			redefinableTemplateSignatureToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			redefinableTemplateSignatureToUpdate.getParameters().addAll(basePart.getParameterToAdd());
			redefinableTemplateSignatureToUpdate.getOwnedParameters().addAll(basePart.getOwnedParameterToAdd());
			redefinableTemplateSignatureToUpdate.getExtendedSignatures().addAll(basePart.getExtendedSignatureToAdd());


			return redefinableTemplateSignatureToUpdate;
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
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.RedefinableTemplateSignature.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.RedefinableTemplateSignature.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.RedefinableTemplateSignature.parameter == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.RedefinableTemplateSignature.ownedParameter == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					TemplateParameter oldValue = (TemplateParameter)event.getOldValue();
					TemplateParameter newValue = (TemplateParameter)event.getNewValue();


					// TODO: Complete the redefinableTemplateSignature update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.RedefinableTemplateSignature.extendedSignature == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {
				if(UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {
				if(UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
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
		return key == UMLViewsRepository.RedefinableTemplateSignature.isLeaf || key == UMLViewsRepository.RedefinableTemplateSignature.parameter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if(event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if(UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.RedefinableTemplateSignature.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.RedefinableTemplateSignature.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate = Diagnostician.INSTANCE.validate(copy);
		} else if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(redefinableTemplateSignature);
		// Start of user code for custom validation check

		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if(semanticAdapter != null)
			redefinableTemplateSignature.eAdapters().remove(semanticAdapter);
	}

}
