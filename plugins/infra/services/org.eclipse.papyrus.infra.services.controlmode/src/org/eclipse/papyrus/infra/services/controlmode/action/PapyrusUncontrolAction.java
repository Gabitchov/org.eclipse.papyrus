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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.services.controlmode.commands.UncontrolCommand;
import org.eclipse.papyrus.infra.services.controlmode.util.ControlModeUtil;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * An action to uncontrol a papyrus resource.
 * 
 * @author eperico
 */
public class PapyrusUncontrolAction extends CommandActionHandler {

	/** The selected eObject. */
	private EObject eObject;

	private IStructuredSelection selection;

	/**
	 * Instantiates a new papyrus uncontrol action when a controlled model object is selected.
	 * 
	 * @param domain
	 *        the domain
	 */
	public PapyrusUncontrolAction(EditingDomain domain) {
		super(domain, EMFEditUIPlugin.INSTANCE.getString("_UI_Uncontrol_menu_item"));
		setDescription("_UI_Uncontrol_menu_item_description");
		setToolTipText("Merge the external model with the current model");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return ControlModeUtil.canUncontrol(eObject);
	}

	/**
	 * The creation of AddCommand is done in the run() method, when the user specifies a target
	 * resource.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateSelection(IStructuredSelection theSelection) {
		boolean result = false;
		this.selection = theSelection;

		if(selection.size() == 1) {
			Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());
			if(object instanceof IAdaptable) {
				object = ((IAdaptable)object).getAdapter(EObject.class);
			}
			// Check whether the selected object is controllable
			if(domain != null) {
				result = domain.isControllable(object);
				if(result) {
					eObject = (EObject)object;
					result = AdapterFactoryEditingDomain.isControlled(eObject);
				} else {
					eObject = null;
				}
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	//FIXME: This method introduces a dependency to UML. Use the semantic service instead.
	@Override
	public void run() {
		// check if the uncontrol is made from the parent resource. If not, warn the user and disable action
		IModel umlModel = ModelUtils.getModelSet().getModel(UmlModel.MODEL_ID);
		Resource parentOfControlledResource = getParentOfControlledResource(eObject);
		boolean enableAction = false;
		if(eObject != null && umlModel instanceof AbstractBaseModel) {
			enableAction = ((AbstractBaseModel)umlModel).getResource().equals(parentOfControlledResource);
		}
		if(!enableAction) {
			NotificationBuilder.createAsyncPopup("You must perform uncontrol action from the resource:\n" + parentOfControlledResource.getURI().trimFileExtension().toString() + " for this element").setType(Type.INFO).run();
			return;
		}

		try {
			boolean confirmDelete = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Delete controlled resources?", "Delete the original controlled files ?");
			UncontrolCommand transactionalCommand = new UncontrolCommand((TransactionalEditingDomain)getEditingDomain(), eObject, "Uncontrol", null, confirmDelete);
			IStatus status = CheckedOperationHistory.getInstance().execute(transactionalCommand, new NullProgressMonitor(), null);
			if(!status.isOK()) {
				NotificationBuilder.createErrorPopup(status.getMessage()).setTitle("Unable to uncontrol").run();
			}
		} catch (ExecutionException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), EMFEditUIPlugin.INSTANCE.getString("_UI_InvalidURI_label"), EMFEditUIPlugin.INSTANCE.getString("_WARN_CannotCreateResource"));
			EMFEditUIPlugin.INSTANCE.log(e);
		}
	}

	/**
	 * Returns the first parent resource of the controlled resource in which the eObject is.
	 * 
	 * @param eObject
	 *        the specified eObject
	 * @return null otherwise
	 */
	private Resource getParentOfControlledResource(EObject eObject) {
		Resource currentResource = eObject.eResource();
		if(eObject.eContainer() != null) {
			if(!currentResource.equals(eObject.eContainer().eResource())) {
				return eObject.eContainer().eResource();
			} else {
				getParentOfControlledResource(eObject.eContainer());
			}
		}
		return null;
	}
}
