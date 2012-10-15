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
package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModelUtils;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.services.controlmode.commands.IUncontrolCommand.STATE_CONTROL;
import org.eclipse.papyrus.infra.services.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.ui.PlatformUI;

/**
 * The Class UncontrolCommand in charge of uncontrolling all papyrus resources
 * 
 */
public class UncontrolCommand extends AbstractTransactionalCommand {

	/** extension point ID for custom control command */
	private static final String CONTROL_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.controlmode.customControlCommand";

	/** attribute ID for the custom command class. */
	private static final String UNCONTROL_CMD_ATTRIBUTE_EXTENSION_POINT = "uncontrolCommand";

	/** element ID for the custom command class. */
	private static final String UNCONTROL_CMD_ELEMENT_EXTENSION_POINT = "customUncontrolCommand";

	private EObject eObject;

	private ModelSet modelSet;

	private Resource controlledModel;

	private Resource controlledNotation;

	private Resource controlledDI;

	private List<IUncontrolCommand> commands;

	private List<ControledResource> controlledResourceToRemove;

	private List<ControledResource> addedControlledResource;

	private boolean deleteResources;

	/**
	 * Instantiates a new uncontrol command.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 * @param selectedObject
	 */
	public UncontrolCommand(TransactionalEditingDomain domain, EObject selectedObject, String label, List<?> affectedFiles) {
		this(domain, selectedObject, label, affectedFiles, false);
	}

	/**
	 * Instantiates a new uncontrol command.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 * @param selectedObject
	 * @param deleteUncontrolledResources whether to delete uncontrolled resources
	 */
	public UncontrolCommand(TransactionalEditingDomain domain, EObject selectedObject, String label, List<?> affectedFiles, boolean deleteUncontrolledResources) {
		super(domain, label, affectedFiles);
		this.eObject = selectedObject;
		// Add an undo context to allow the editor to react to that change
		addContext(new EditingDomainUndoContext(domain));
		controlledResourceToRemove = new LinkedList<ControledResource>();
		addedControlledResource = new LinkedList<ControledResource>();
		deleteResources = deleteUncontrolledResources;
		
		ResourceSet set = domain.getResourceSet();
		if (set instanceof ModelSet) {
			modelSet = (ModelSet) set;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		commands = getCommandExtensions();
		IStatus status = doRedo(monitor, info);
		CommandResult result;
		if (status.equals(Status.OK_STATUS)) {
			result = CommandResult.newOKCommandResult();			
		}
		else if (status.equals(Status.CANCEL_STATUS)) {
			result = CommandResult.newErrorCommandResult("Unable to execute uncontrol command");
		}
		else {
			result = CommandResult.newCancelledCommandResult();
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// execute control command
		ControlCommand transactionalCommand = new ControlCommand(modelSet.getTransactionalEditingDomain(), controlledModel, eObject, "Control", null);
		modelSet.getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(transactionalCommand));
		return Status.OK_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(eObject != null) {
			controlledModel = eObject.eResource();
			final URI newNotationURI = URI.createURI(controlledModel.getURI().trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION).toString());
			this.controlledNotation = getEditingDomain().getResourceSet().getResource(newNotationURI, true);

			final URI newDiURI = URI.createURI(controlledModel.getURI().trimFileExtension().appendFileExtension(DiModel.DI_FILE_EXTENSION).toString());
			this.controlledDI = getEditingDomain().getResourceSet().getResource(newDiURI, true);
		}
		if (modelSet == null) {
			modelSet = EditorUtils.getDiResourceSet();
		}
		
		CompoundCommand compoundCommand = new CompoundCommand();
		uncontrolNotation(compoundCommand);
		uncontrolModel(compoundCommand);

		// Ensure that all proxies are resolved so that references to the controlled object will be
		// updated to reference the new resource.
		EcoreUtil.resolveAll(getEditingDomain().getResourceSet());

		if(compoundCommand.canExecute()) {
			compoundCommand.execute();
			// TODO save resources, check if it is useful
			// try {
			// diResourceSet.save(new NullProgressMonitor());
			// } catch (IOException e) {
			// EMFEditUIPlugin.INSTANCE.log(e);
			// return Status.CANCEL_STATUS;
			// }
			deleteControlledResources();
			return Status.OK_STATUS;
		} else {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unable to uncontrol", "Unable to execute uncontrol command");
			return Status.CANCEL_STATUS;
		}
	}

	/**
	 * Uncontrol the model resource
	 * 
	 * @param compoundCommand
	 */
	private void uncontrolModel(CompoundCommand compoundCommand) {
		// PRE uncontrol operation
		Resource resource = UmlUtils.getUmlModel(modelSet).getResource();
		uncontrol(getEditingDomain(), eObject, controlledModel, resource, compoundCommand, STATE_CONTROL.PRE_MODEL);

		// Create the Command to Uncontrol the model object
		compoundCommand.append(new RemoveCommand(getEditingDomain(), eObject.eResource().getContents(), eObject));

		unassignControlledResourceOfCurrentElement(getEditingDomain(), compoundCommand, getDIResource(eObject), eObject.eResource().getURI().toString(), resource.getURI().toString());

		// POST uncontrol operation
		uncontrol(getEditingDomain(), eObject, controlledModel, resource, compoundCommand, STATE_CONTROL.POST_MODEL);
	}

	/**
	 * Uncontrol the notation resource
	 * 
	 * @param compoundCommand
	 */
	private void uncontrolNotation(CompoundCommand compoundCommand) {
		// First retrieve the Diagrams that match with the model object to Uncontrol
		final List<Diagram> controlledDiagrams = NotationUtils.getDiagrams(controlledNotation, eObject);

		if(!controlledDiagrams.isEmpty()) {
			// PRE uncontrol operation
			Resource notationResource = NotationUtils.getNotationModel(modelSet).getResource();

			for(Diagram diag : controlledDiagrams) {
				uncontrol(getEditingDomain(), diag, controlledNotation, notationResource, compoundCommand, STATE_CONTROL.PRE_NOTATION);
			}

			// uncontrol the Notation model
			compoundCommand.append(new AddCommand(getEditingDomain(), notationResource.getContents(), controlledDiagrams));
			Set<Resource> resources = new HashSet<Resource>(controlledDiagrams.size());
			for(Diagram d : controlledDiagrams) {
				resources.add(d.eResource());
			}
			for(Resource r : resources) {
				unassignControlledResourceOfCurrentElement(getEditingDomain(), compoundCommand, getDIResource(eObject), r.getURI().toString(), notationResource.getURI().toString());
			}

			// POST uncontrol operation
			for(Diagram diag : controlledDiagrams) {
				uncontrol(getEditingDomain(), diag, controlledNotation, notationResource, compoundCommand, STATE_CONTROL.POST_NOTATION);
			}
		}
	}

	/**
	 * Analyze the history model to update the controlled children
	 * 
	 * @param domain
	 * @param compoundCommand
	 * @param model
	 * @param currentURL
	 * @param newURL
	 */
	private void unassignControlledResourceOfCurrentElement(EditingDomain domain, CompoundCommand compoundCommand, Resource model, String oldURL, String newURL) {
		controlledResourceToRemove.clear();
		addedControlledResource.clear();
		if(model != null) {
			URI uriPath = HistoryUtils.getURIFullPath(newURL);
			newURL = HistoryUtils.resolve(uriPath, newURL);
			oldURL = HistoryUtils.resolve(uriPath, oldURL);
			Set<ControledResource> controledOldURL = new HashSet<ControledResource>(HistoryUtils.getControledResourcesForURL(modelSet, oldURL));
			controledOldURL.addAll(HistoryUtils.getControledResourcesForURL(modelSet, oldURL.substring(oldURL.lastIndexOf("/")+1,oldURL.length())));
			List<ControledResource> controledNewURL = HistoryUtils.getControledResourcesForURL(modelSet, newURL);
			for(ControledResource resourceOldURL : controledOldURL) {
				if(resourceOldURL.getChildren().isEmpty()) {
					// store the controlled resource to remove
					controlledResourceToRemove.add(resourceOldURL);
				} else {
					if(resourceOldURL.eContainer() instanceof ControledResource) {
						compoundCommand.append(AddCommand.create(domain, resourceOldURL.eContainer(), historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, Collections.singleton(resourceOldURL)));
					} else {
						for(ControledResource resourceNewURL : controledNewURL) {
							// add children of the old controlled resource to the controlled resource with the new URL
							compoundCommand.append(AddCommand.create(domain, resourceNewURL, historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, resourceOldURL.getChildren()));
							addedControlledResource.addAll(resourceOldURL.getChildren());

							// resolve url to be relative to the new resource
							for(ControledResource c : resourceOldURL.getChildren()) {
								String childRelativeUrl = c.getResourceURL();
								URI absoluteChildPath = URI.createURI(c.eResource().getURI().trimSegments(1).toString() + "/");
								URI absoluteChildURI = URI.createURI(childRelativeUrl).resolve(absoluteChildPath);
								String urlResolved = absoluteChildURI.deresolve(uriPath).toString();
								compoundCommand.append(SetCommand.create(domain, c, historyPackage.Literals.CONTROLED_RESOURCE__RESOURCE_URL, urlResolved));
							}
						}
					}
				}
			}
			// remove children and parent if needed
			for(ControledResource parent : controledNewURL) {
				if(controlledResourceToRemove.containsAll(parent.getChildren()) && addedControlledResource.isEmpty()) {
					compoundCommand.append(new RemoveCommand(domain, parent.eResource().getContents(), parent));
				} else {
					for(ControledResource r : controlledResourceToRemove) {
						compoundCommand.append(RemoveCommand.create(domain, r.eContainer(), historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, r));
					}
				}
			}
		}
	}

	/**
	 * Get the history resource of the specified eObject
	 * 
	 * @param eObject
	 * @return
	 */
	private Resource getDIResource(EObject eObject) {
		// uncontrol command is only available from its parent. With this condition, the current sashModel is the parent
		return SashModelUtils.getSashModel(modelSet).getResource();
	}

	/**
	 * Control action applied on the specified selection
	 * 
	 * @param domain
	 * @param selection
	 * @param source
	 * @param target
	 * @param command
	 * @param state
	 */
	public void uncontrol(EditingDomain domain, EObject selection, Resource source, Resource target, CompoundCommand command, STATE_CONTROL state) {
		for(IUncontrolCommand cmd : commands) {
			if(cmd.provides(selection, state, source, target)) {
				cmd.uncontrol(domain, selection, state, source, target, command);
			}
		}
	}

	/**
	 * Gets the custom command extensions that will be executed with the default uncontrol action.
	 * 
	 * @return the command extensions
	 */
	private List<IUncontrolCommand> getCommandExtensions() {
		List<IUncontrolCommand> commands = new LinkedList<IUncontrolCommand>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(CONTROL_EXTENSION_POINT_ID);
		for(IConfigurationElement e : extensions) {
			if(UNCONTROL_CMD_ELEMENT_EXTENSION_POINT.equals(e.getName())) {
				try {
					IUncontrolCommand uncontrolCmd = (IUncontrolCommand)e.createExecutableExtension(UNCONTROL_CMD_ATTRIBUTE_EXTENSION_POINT);
					commands.add(uncontrolCmd);
				} catch (CoreException exception) {
					exception.printStackTrace();
				}
			}
		}
		return commands;
	}

	/**
	 * Delete the controlled resources.
	 */
	private void deleteControlledResources() {
		// Remove the controlled resources from the resource set.
		EList<Resource> resources = getEditingDomain().getResourceSet().getResources();
		resources.remove(controlledModel);
		resources.remove(controlledNotation);
		resources.remove(controlledDI);

		Collection<IResource> todelete = new ArrayList<IResource>();
		addFileResource(controlledModel, todelete);
		addFileResource(controlledNotation, todelete);
		addFileResource(controlledDI, todelete);

		// if confirmed delete is false, uncontrol is done and old controlled resource is a single
		// resource
		if(deleteResources) {
			for(IResource file : todelete) {
				try {
					file.delete(true, new NullProgressMonitor());
				} catch (CoreException exception) {
					EMFEditUIPlugin.INSTANCE.log(exception);
				}
			}
		}
	}

	/**
	 * private method that comes from org.topcased.modeler.internal.actions.ModelerUncontrolAction
	 */
	private void addFileResource(Resource emfRes, Collection<IResource> fileResources) {
		URI uri = (emfRes != null) ? emfRes.getURI() : null;
		if(uri != null && uri.isPlatformResource()) {
			IPath path = new Path(uri.toPlatformString(false));
			IResource r = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
			if(r != null) {
				fileResources.add(r);
			}
		}
	}

}
