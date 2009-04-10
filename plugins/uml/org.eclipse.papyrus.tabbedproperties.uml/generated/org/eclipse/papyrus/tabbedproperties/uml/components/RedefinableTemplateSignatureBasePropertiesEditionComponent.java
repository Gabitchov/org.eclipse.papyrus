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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement;
import org.eclipse.jface.dialogs.IMessageProvider;
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
	
	private String[] parts = {BASE_PART};
	
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
	public RedefinableTemplateSignatureBasePropertiesEditionComponent(EObject redefinableTemplateSignature, String mode) {
		if (redefinableTemplateSignature instanceof RedefinableTemplateSignature) {
			this.redefinableTemplateSignature = (RedefinableTemplateSignature)redefinableTemplateSignature;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.redefinableTemplateSignature.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.mode = mode;
	}
	
	/**
	 * Initialize the semantic model listener for live editing mode
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
				if (UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
					basePart.setVisibility((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
					basePart.setIsLeaf((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getTemplateSignature_Parameter().equals(msg.getFeature())) {
					basePart.updateParameter(redefinableTemplateSignature);
				}
				if (msg.getFeature() != null && 
						(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter()
						|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getTemplateParameter())) {
					basePart.updateOwnedParameter(redefinableTemplateSignature);
				}
				if (UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature().equals(msg.getFeature())) {
					basePart.updateExtendedSignature(redefinableTemplateSignature);
				}


			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.RedefinableTemplateSignature.class;
		return super.translatePart(key);
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (redefinableTemplateSignature != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (RedefinableTemplateSignaturePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.RedefinableTemplateSignature.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent
	 * 		#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 * 						org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == UMLViewsRepository.RedefinableTemplateSignature.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			RedefinableTemplateSignature redefinableTemplateSignature = (RedefinableTemplateSignature)elt;
			if (redefinableTemplateSignature.getName() != null)
				basePart.setName(redefinableTemplateSignature.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), redefinableTemplateSignature.getVisibility());				
			basePart.setIsLeaf(redefinableTemplateSignature.isLeaf());				
			basePart.initParameter(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getTemplateSignature_Parameter());				
			basePart.initOwnedParameter(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter());				
			basePart.initExtendedSignature(redefinableTemplateSignature, null, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature());				
		}

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 * (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (redefinableTemplateSignature != null) {
			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			cc.append(SetCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));
			List parameterToAdd = basePart.getParameterToAdd();
			for (Iterator iter = parameterToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), iter.next()));
			List parameterToRemove = basePart.getParameterToRemove();
			for (Iterator iter = parameterToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), iter.next()));
			//List parameterToMove = basePart.getParameterToMove();
			//for (Iterator iter = parameterToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List ownedParameterToAdd = basePart.getOwnedParameterToAdd();
			for (Iterator iter = ownedParameterToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter(), iter.next()));
			Map ownedParameterToRefresh = basePart.getOwnedParameterToEdit();
			for (Iterator iter = ownedParameterToRefresh.keySet().iterator(); iter.hasNext();) {
			
				// Start of user code for ownedParameter reference refreshment
				
				TemplateParameter nextElement = (TemplateParameter) iter.next();
				TemplateParameter ownedParameter = (TemplateParameter) ownedParameterToRefresh.get(nextElement);
				
				// End of user code			
			}
			List ownedParameterToRemove = basePart.getOwnedParameterToRemove();
			for (Iterator iter = ownedParameterToRemove.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedParameterToMove = basePart.getOwnedParameterToMove();
			for (Iterator iter = ownedParameterToMove.iterator(); iter.hasNext();){
				MoveElement moveElement = (MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), moveElement.getElement(), moveElement.getIndex()));
			}
			List extendedSignatureToAdd = basePart.getExtendedSignatureToAdd();
			for (Iterator iter = extendedSignatureToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), iter.next()));
			List extendedSignatureToRemove = basePart.getExtendedSignatureToRemove();
			for (Iterator iter = extendedSignatureToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), iter.next()));
			//List extendedSignatureToMove = basePart.getExtendedSignatureToMove();
			//for (Iterator iter = extendedSignatureToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature(), moveElement.getElement(), moveElement.getIndex()));
			//}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject
	 * ()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof RedefinableTemplateSignature) {
			RedefinableTemplateSignature redefinableTemplateSignatureToUpdate = (RedefinableTemplateSignature)source;
			redefinableTemplateSignatureToUpdate.setName(basePart.getName());
			redefinableTemplateSignatureToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			redefinableTemplateSignatureToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());
			redefinableTemplateSignatureToUpdate.getParameters().addAll(basePart.getParameterToAdd());
			redefinableTemplateSignatureToUpdate.getOwnedParameters().addAll(basePart.getOwnedParameterToAdd());
			redefinableTemplateSignatureToUpdate.getExtendedSignatures().addAll(basePart.getExtendedSignatureToAdd());


			return redefinableTemplateSignatureToUpdate;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PathedPropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
			CompoundCommand command = new CompoundCommand();
			if (UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.RedefinableTemplateSignature.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.RedefinableTemplateSignature.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if (UMLViewsRepository.RedefinableTemplateSignature.parameter == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_Parameter(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.RedefinableTemplateSignature.ownedParameter == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.SET == event.getKind()) {
					TemplateParameter oldValue = (TemplateParameter)event.getOldValue();
					TemplateParameter newValue = (TemplateParameter)event.getNewValue();
					// Start of user code for ownedParameter live update command
					// TODO: Complete the redefinableTemplateSignature update command
					// End of user code					
				}
				else if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateSignature_OwnedParameter(), event.getNewValue()));
				else if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getTemplateParameter(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.RedefinableTemplateSignature.extendedSignature == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, redefinableTemplateSignature, UMLPackage.eINSTANCE.getRedefinableTemplateSignature_ExtendedSignature(), event.getNewValue(), event.getNewIndex()));
			}


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				


			} else {
				if (UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.RedefinableTemplateSignature.isLeaf || key == UMLViewsRepository.RedefinableTemplateSignature.parameter;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.RedefinableTemplateSignature.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.RedefinableTemplateSignature.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.RedefinableTemplateSignature.isLeaf)
				return "Indicates whether it is possible to further specialize a RedefinableElement. If the value is true, then it is not possible to further specialize the RedefinableElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.RedefinableTemplateSignature.parameter)
				return "The ordered set of all formal template parameters for this template signature."; //$NON-NLS-1$
			if (key == UMLViewsRepository.RedefinableTemplateSignature.ownedParameter)
				return "The formal template parameters that are owned by this template signature."; //$NON-NLS-1$
			if (key == UMLViewsRepository.RedefinableTemplateSignature.extendedSignature)
				return "The template signature that is extended by this template signature."; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PathedPropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (UMLViewsRepository.RedefinableTemplateSignature.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.RedefinableTemplateSignature.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.RedefinableTemplateSignature.isLeaf == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
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
		if (IPropertiesEditionComponent.BATCH_MODE.equals(mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(mode))
			return Diagnostician.INSTANCE.validate(redefinableTemplateSignature);
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
			redefinableTemplateSignature.eAdapters().remove(semanticAdapter);
	}

}

