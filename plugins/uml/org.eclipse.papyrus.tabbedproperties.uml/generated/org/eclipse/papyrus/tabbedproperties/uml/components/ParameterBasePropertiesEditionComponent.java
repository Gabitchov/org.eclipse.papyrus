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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
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
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ParameterPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ParameterBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private Parameter parameter;
	
	/**
	 * The Base part
	 */
	private ParameterPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public ParameterBasePropertiesEditionComponent(EObject parameter, String mode) {
		if (parameter instanceof Parameter) {
			this.parameter = (Parameter)parameter;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.parameter.eAdapters().add(semanticAdapter);
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
				if (UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().equals(msg.getFeature()) && basePart != null)
					basePart.setIsOrdered((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().equals(msg.getFeature()) && basePart != null)
					basePart.setIsUnique((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getParameter_ParameterSet().equals(msg.getFeature())) {
					basePart.updateParameterSet(parameter);
				}
				if (UMLPackage.eINSTANCE.getParameter_Direction().equals(msg.getFeature()) && basePart != null)
					basePart.setDirection((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getParameter_IsException().equals(msg.getFeature()) && basePart != null)
					basePart.setIsException((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getParameter_IsStream().equals(msg.getFeature()) && basePart != null)
					basePart.setIsStream((Boolean)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getParameter_Effect().equals(msg.getFeature()) && basePart != null)
					basePart.setEffect((Enumerator)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getTypedElement_Type().equals(msg.getFeature()) && basePart != null)
					basePart.setType((EObject)msg.getNewValue());
				if (UMLPackage.eINSTANCE.getMultiplicityElement_Lower().equals(msg.getFeature()) && basePart != null)
					basePart.setLower(((Integer)msg.getNewValue()).toString());
				if (UMLPackage.eINSTANCE.getMultiplicityElement_Upper().equals(msg.getFeature()) && basePart != null)
					basePart.setUpper(((Integer)msg.getNewValue()).toString());


			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return UMLViewsRepository.Parameter.class;
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
		if (parameter != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if (provider != null) {
					basePart = (ParameterPropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.Parameter.class, kind, this);
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
		if (basePart != null && key == UMLViewsRepository.Parameter.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			Parameter parameter = (Parameter)elt;
			if (parameter.getName() != null)
				basePart.setName(parameter.getName());
				
			basePart.initVisibility((EEnum) UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), parameter.getVisibility());				
			basePart.setIsOrdered(parameter.isOrdered());				
			basePart.setIsUnique(parameter.isUnique());				
			basePart.initParameterSet(parameter, null, UMLPackage.eINSTANCE.getParameter_ParameterSet());				
			basePart.initDirection((EEnum) UMLPackage.eINSTANCE.getParameter_Direction().getEType(), parameter.getDirection());				
			basePart.setIsException(parameter.isException());				
			basePart.setIsStream(parameter.isStream());				
			basePart.initEffect((EEnum) UMLPackage.eINSTANCE.getParameter_Effect().getEType(), parameter.getEffect());				
			basePart.initType(allResource, parameter.getType());				
			basePart.setLower(String.valueOf(parameter.getLower()));
				
			basePart.setUpper(String.valueOf(parameter.getUpper()));
				
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
		if (parameter != null) {
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), basePart.getIsOrdered()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), basePart.getIsUnique()));
			List parameterSetToAdd = basePart.getParameterSetToAdd();
			for (Iterator iter = parameterSetToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_ParameterSet(), iter.next()));
			List parameterSetToRemove = basePart.getParameterSetToRemove();
			for (Iterator iter = parameterSetToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_ParameterSet(), iter.next()));
			//List parameterSetToMove = basePart.getParameterSetToMove();
			//for (Iterator iter = parameterSetToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameterSet(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_Direction(), basePart.getDirection()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_IsException(), basePart.getIsException()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_IsStream(), basePart.getIsStream()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getParameter_Effect(), basePart.getEffect()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getTypedElement_Type(), basePart.getType()));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), new Integer(basePart.getLower())));
			cc.append(SetCommand.create(editingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), new Integer(basePart.getUpper())));


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
		if (source instanceof Parameter) {
			Parameter parameterToUpdate = (Parameter)source;
			parameterToUpdate.setName(basePart.getName());
			parameterToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());
			parameterToUpdate.setIsOrdered(new Boolean(basePart.getIsOrdered()).booleanValue());
			parameterToUpdate.setIsUnique(new Boolean(basePart.getIsUnique()).booleanValue());
			parameterToUpdate.getParameterSets().addAll(basePart.getParameterSetToAdd());
			parameterToUpdate.setDirection((ParameterDirectionKind)basePart.getDirection());
			parameterToUpdate.setIsException(new Boolean(basePart.getIsException()).booleanValue());
			parameterToUpdate.setIsStream(new Boolean(basePart.getIsStream()).booleanValue());
			parameterToUpdate.setEffect((ParameterEffectKind)basePart.getEffect());
			parameterToUpdate.setType((Type)basePart.getType());
			parameterToUpdate.setLower(new Integer(basePart.getLower()).intValue());
			parameterToUpdate.setUpper(new Integer(basePart.getUpper()).intValue());


			return parameterToUpdate;
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
			if (UMLViewsRepository.Parameter.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));	

			if (UMLViewsRepository.Parameter.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.isOrdered == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.isUnique == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.parameterSet == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_ParameterSet(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_ParameterSet(), event.getNewValue()));
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_ParameterSet(), event.getNewValue(), event.getNewIndex()));
			}
			if (UMLViewsRepository.Parameter.direction == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_Direction(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.isException == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_IsException(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.isStream == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_IsStream(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.effect == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getParameter_Effect(), event.getNewValue()));

			if (UMLViewsRepository.Parameter.type == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getTypedElement_Type(), event.getNewValue()));	
			if (UMLViewsRepository.Parameter.lower == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Lower(), new Integer((String)event.getNewValue())));	

			if (UMLViewsRepository.Parameter.upper == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, parameter, UMLPackage.eINSTANCE.getMultiplicityElement_Upper(), new Integer((String)event.getNewValue())));	



			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (UMLViewsRepository.Parameter.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				
				
				
				
				
				
				
				if (UMLViewsRepository.Parameter.lower == event.getAffectedEditor())
					basePart.setMessageForLower(diag.getMessage(), IMessageProvider.ERROR);
				if (UMLViewsRepository.Parameter.upper == event.getAffectedEditor())
					basePart.setMessageForUpper(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (UMLViewsRepository.Parameter.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				
				
				
				
				
				
				
				if (UMLViewsRepository.Parameter.lower == event.getAffectedEditor())
					basePart.unsetMessageForLower();
				if (UMLViewsRepository.Parameter.upper == event.getAffectedEditor())
					basePart.unsetMessageForUpper();


			}
		}
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.Parameter.isOrdered || key == UMLViewsRepository.Parameter.isUnique || key == UMLViewsRepository.Parameter.direction || key == UMLViewsRepository.Parameter.isException || key == UMLViewsRepository.Parameter.isStream;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == UMLViewsRepository.Parameter.name)
				return "The name of the NamedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.visibility)
				return "Determines where the NamedElement appears within different Namespaces within the overall model, and its accessibility."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.isOrdered)
				return "For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this element are sequentially ordered."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.isUnique)
				return "For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this element are unique."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.parameterSet)
				return "The parameter sets containing the parameter. See ParameterSet."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.direction)
				return "Indicates whether a parameter is being sent into or out of a behavioral element."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.isException)
				return "Tells whether an output parameter may emit a value to the exclusion of the other outputs."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.isStream)
				return "Tells whether an input parameter may accept values while its behavior is executing, or whether an output parameter post values while the behavior is executing."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.effect)
				return "Specifies the effect that the owner of the parameter has on values passed in or out of the parameter."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.type)
				return "This information is derived from the return result for this Operation.The type of the TypedElement."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.lower)
				return "Specifies the lower bound of the multiplicity interval."; //$NON-NLS-1$
			if (key == UMLViewsRepository.Parameter.upper)
				return "Specifies the upper bound of the multiplicity interval."; //$NON-NLS-1$
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
			if (UMLViewsRepository.Parameter.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.visibility == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.isOrdered == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.isUnique == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.direction == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getParameter_Direction().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getParameter_Direction().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.isException == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getParameter_IsException().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getParameter_IsException().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.isStream == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getParameter_IsStream().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getParameter_IsStream().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.effect == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getParameter_Effect().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getParameter_Effect().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.lower == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_Lower().getEAttributeType(), newValue);
			}
			if (UMLViewsRepository.Parameter.upper == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getMultiplicityElement_Upper().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getMultiplicityElement_Upper().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(parameter);
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
			parameter.eAdapters().remove(semanticAdapter);
	}

}

