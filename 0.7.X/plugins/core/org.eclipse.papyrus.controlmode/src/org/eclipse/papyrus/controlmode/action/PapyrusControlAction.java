/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.controlmode.action;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.controlmode.commands.ControlCommand;
import org.eclipse.papyrus.controlmode.commands.IControlCondition;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.resource.AbstractBaseModel;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * An action to control a papyrus resource.
 */
public class PapyrusControlAction extends ControlAction {

	/** extension point ID for custom control command */
	private static final String CONTROL_CONDITION_EXTENSION_POINT_ID = "org.eclipse.papyrus.controlmode.customControlCommand";

	/** attribute ID for the custom command class. */
	private static final String CONTROL_CONDITION_ATTRIBUTE_EXTENSION_POINT = "controlCondition";

	/** element ID for the custom command class. */
	private static final String CONTROL_CONDITION_ELEMENT_EXTENSION_POINT = "enableControlCommand";

	/** custom commands from extensions */
	private static List<IControlCondition> commands;
	
	/**
	 * Instantiates a new papyrus control action.
	 * 
	 * @param domain
	 *        the domain
	 */
	public PapyrusControlAction(EditingDomain domain) {
		super(domain);
		setDescription(EMFEditUIPlugin.INSTANCE.getString("_UI_Control_menu_item_description"));
		setToolTipText("Split the model into an external model");
		commands = getCommandConditionsExtensions();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		boolean enableControl = true;
		for(IControlCondition cond : commands) {
			// check if action is disabled by an extension
			enableControl &= cond.enableControl(eObject);
		}
		return enableControl && getEditingDomain().isControllable(eObject) && !AdapterFactoryEditingDomain.isControlled(eObject) && getDiagram(eObject);
	}
	
	/**
	 * Checks if a specified element gets a diagram
	 * @param eObject
	 * @return true if a diagram exists
	 */
	private boolean getDiagram(EObject eObject) {
		Resource modelResource = eObject.eResource();
		if (modelResource != null) {
			// only check for diagrams in the relative notation resource (same name as the opened resource)
			Resource notationResource = modelResource.getResourceSet().getResource(modelResource.getURI().trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION), true);
			if (notationResource != null) {
				for (EObject o : notationResource.getContents()) {
					if (o instanceof Diagram) {
						EObject element = ((Diagram)o).getElement();
						if (element != null && (element.equals(eObject) || EcoreUtil.isAncestor(this.eObject, element))) {
							return true;
						}
					}
				}				
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		boolean result = false;
		this.selection = selection;

		if(selection.size() == 1) {
			Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
			if(object instanceof IAdaptable) {
				object = (EObject)((IAdaptable)object).getAdapter(EObject.class);
			}
			// Check whether the selected object is controllable
			result = domain.isControllable(object);
			if(result) {
				eObject = (EObject)object;
			} else {
				eObject = null;
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		// check if object selection is in the current model set. If not, warn the user and disable action
		ModelSet modelSet = ModelUtils.getModelSet();
		if (modelSet != null) {			
			IModel umlModel = modelSet.getModel(UmlModel.MODEL_ID);
			boolean enableControl = false;
			if (eObject != null && umlModel instanceof AbstractBaseModel) {
				enableControl = ((AbstractBaseModel) umlModel).getResource().equals(eObject.eResource());
			}
			if (!enableControl) {
				NotificationBuilder.createAsyncPopup("You must perform control action from the resource:\n" + eObject.eResource().getURI().trimFileExtension().toString() + " for this element").setType(Type.INFO).run();			
				return;
			}
			
			Resource controlledModel = getControlledResource();
			if(controlledModel == null) {
				return;
			}
			try {
				ControlCommand transactionalCommand = new ControlCommand(EditorUtils.getTransactionalEditingDomain(), controlledModel, eObject, "Control", null);
				OperationHistoryFactory.getOperationHistory().execute(transactionalCommand, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
				EMFEditUIPlugin.INSTANCE.log(e);
			}
		}
	}

	/**
	 * Instantiates a ControlResourceDialog and gets the controlled resource
	 * 
	 * @return the controlled resource
	 */
	private Resource getControlledResource() {
		org.eclipse.papyrus.controlmode.ui.ControlResourceDialog dialog = new org.eclipse.papyrus.controlmode.ui.ControlResourceDialog(Display.getDefault().getActiveShell(), getEditingDomain(), eObject.eResource(), getElementName(eObject));
		int returnCode = dialog.open();
		Resource resource = null;

		if(returnCode == Window.OK) {
			resource = dialog.getControlResource();

			if(resource == null || !resource.getURI().isPlatformResource()) {
				MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
				resource = null;
			}
		}
		return resource;
	}

	/**
	 * Gets the specified object name, a default name if not found
	 * 
	 * @param obj
	 * @return the element name
	 */
	private String getElementName(EObject eObject) {
		EStructuralFeature nameFeature = getLabelFeature(eObject.eClass());
		if(nameFeature != null) {
			Object value = eObject.eGet(nameFeature);
			if(value != null) {
				return value.toString();
			}
		}
		// Default file name to use for the controlled resource if no appropriate "name" was found
		// on the controlled element.
		return "Unknown";
	}

	/**
	 * Copied from org.eclipse.emf.edit.provider.ReflectiveItemProvider and slightly modified to
	 * return null if no likely candidate is found.
	 * 
	 * @param eClass
	 * @return the EStructuralFeature for the class
	 */
	protected EStructuralFeature getLabelFeature(EClass eClass) {
		EAttribute result = null;
		for(EAttribute eAttribute : eClass.getEAllAttributes()) {
			if(!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if("name".equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				} else if(eAttribute.getEAttributeType().getInstanceClass() == String.class && result != null && result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}
			}
		}
		return result;
	}

	/**
	 * Gets the conditions that enable control action
	 * 
	 * @return the command extensions
	 */
	private List<IControlCondition> getCommandConditionsExtensions() {
		List<IControlCondition> commands = new LinkedList<IControlCondition>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(CONTROL_CONDITION_EXTENSION_POINT_ID);
		for(IConfigurationElement e : extensions) {
			if(CONTROL_CONDITION_ELEMENT_EXTENSION_POINT.equals(e.getName())) {
				try {
					IControlCondition controlCondition = (IControlCondition)e.createExecutableExtension(CONTROL_CONDITION_ATTRIBUTE_EXTENSION_POINT);
					commands.add(controlCondition);
				} catch (CoreException exception) {
					exception.printStackTrace();
				}
			}
		}
		return commands;
	}

}
