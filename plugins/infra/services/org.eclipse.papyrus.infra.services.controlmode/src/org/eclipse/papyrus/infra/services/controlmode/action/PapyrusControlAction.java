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
package org.eclipse.papyrus.infra.services.controlmode.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.services.controlmode.commands.ControlCommand;
import org.eclipse.papyrus.infra.services.controlmode.util.ControlModeUtil;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * An action to control a papyrus resource.
 */
public class PapyrusControlAction extends ControlAction {

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
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return ControlModeUtil.canControl(eObject);
	}

	/**
	 * Checks if a specified element gets a diagram
	 * 
	 * @param eObject
	 * @return true if a diagram exists
	 */
	//FIXME: Refactoring: Why is there this test? It introduces a dependency to GMF Diagram, and doesn't seem useful.
	private boolean getDiagram(EObject eObject) {
		Resource modelResource = eObject.eResource();
		if(modelResource != null) {
			// only check for diagrams in the relative notation resource (same name as the opened resource)
			Resource notationResource = modelResource.getResourceSet().getResource(modelResource.getURI().trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION), true);
			if(notationResource != null) {
				for(EObject o : notationResource.getContents()) {
					if(o instanceof Diagram) {
						EObject element = ((Diagram)o).getElement();
						if(element != null && (element.equals(eObject) || EcoreUtil.isAncestor(this.eObject, element))) {
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
				object = ((IAdaptable)object).getAdapter(EObject.class);
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
		if(modelSet != null) {
			//FIXME: Refactoring: The modelSet should provide a method to get the "semantic model" or the "root element". We should remove the dependency to the UML Model
			IModel umlModel = modelSet.getModel(UmlModel.MODEL_ID);
			boolean enableControl = false;
			if(eObject != null && umlModel instanceof AbstractBaseModel) {
				enableControl = ((AbstractBaseModel)umlModel).getResource().equals(eObject.eResource());
			}
			if(!enableControl) {
				NotificationBuilder.createAsyncPopup("You must perform control action from the resource:\n" + eObject.eResource().getURI().trimFileExtension().toString() + " for this element").setType(Type.INFO).run();
				return;
			}

			//FIXME: Refactoring: Why is there this test? It introduces a dependency to GMF Diagram, and doesn't seem useful.
			if(!getDiagram(eObject)) {
				NotificationBuilder.createAsyncPopup("The selected package must contain a diagram to perform control action").setType(Type.INFO).run();
				return;
			}

			Resource controlledModel = getControlledResource();
			if(controlledModel == null) {
				return;
			}
			try {
				ControlCommand transactionalCommand = new ControlCommand(EditorUtils.getTransactionalEditingDomain(), controlledModel, eObject, "Control", null);
				IStatus status = CheckedOperationHistory.getInstance().execute(transactionalCommand, new NullProgressMonitor(), null);
				if(status.isOK()) {
					notifySave();
				} else {
					NotificationBuilder.createErrorPopup(status.getMessage()).setTitle("Unable to control").run();
				}
			} catch (ExecutionException e) {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
				EMFEditUIPlugin.INSTANCE.log(e);
			}
		}
	}

	/**
	 * Display asynchronous popup to inform user about the control action
	 */
	protected void notifySave() {
		new NotificationBuilder().setMessage("Your element has been controlled.\nYou need to save your model to see modifications in your workspace.\nDo you want to save ?").addAction(new NotificationRunnable() {

			public void run(IContext context) {
				try {
					Display.getDefault().syncExec(new Runnable() {

						public void run() {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().doSave(new NullProgressMonitor());
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public String getLabel() {
				return "Save";
			}
		}).setTemporary(true).setAsynchronous(true).setType(Type.INFO).setDelay(2000).run();
	}

	/**
	 * Instantiates a ControlResourceDialog and gets the controlled resource
	 * 
	 * @return the controlled resource
	 */
	private Resource getControlledResource() {
		org.eclipse.papyrus.infra.services.controlmode.ui.ControlResourceDialog dialog = new org.eclipse.papyrus.infra.services.controlmode.ui.ControlResourceDialog(Display.getDefault().getActiveShell(), getEditingDomain(), eObject.eResource(), getElementName(eObject));
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

}
