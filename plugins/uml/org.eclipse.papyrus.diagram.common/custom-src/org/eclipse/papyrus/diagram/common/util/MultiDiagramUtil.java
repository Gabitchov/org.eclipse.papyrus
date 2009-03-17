/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 * 				 Gabriel Merin Cubero (Prodevelop) – Added version to diagrams
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.ids.MOSKittEditorIDs;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesDiagramEditor;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesEditorInput;
import org.eclipse.papyrus.diagram.common.part.EditingDomainRegistry;
import org.eclipse.papyrus.diagram.common.providers.IDiagramInitializer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class MultiDiagramUtil.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class MultiDiagramUtil {

	/** EAnnotation Source for elements that belong to this <Diagram>. */
	public static final String BelongToDiagramSource = "org.eclipse.papyrus.diagram.common.Belongs_To_This_Diagram";

	/** EAnnotation Source for diagrams that grow from this <View>. */
	public static final String DiagramsRelatedToElement = "org.eclipse.papyrus.diagram.common.DiagramsRelatedToElement";

	/**
	 * Associate diagram to view.
	 * 
	 * @param diagram
	 *            the diagram
	 */
	public static void associateDiagramToView(Diagram diagram) {
		EAnnotation eAnnotation = diagram.getEAnnotation(DiagramsRelatedToElement);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(DiagramsRelatedToElement);
			diagram.getEAnnotations().add(eAnnotation);
		}
		eAnnotation.getReferences().add(diagram.getElement());
	}

	/**
	 * Gets the diagrams associated to view.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the diagrams associated to view
	 */
	public static List<Diagram> getDiagramsAssociatedToView(Diagram diagram) {
		EObject domainElement = diagram != null ? diagram.getElement() : null;
		Resource resource = diagram != null ? diagram.eResource() : null;
		String diagramKind = diagram != null ? diagram.getType() : null;
		if (domainElement == null || resource == null || diagramKind == null) {
			return Collections.EMPTY_LIST;
		}
		List<Diagram> diagrams = new ArrayList<Diagram>();
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof Diagram) {
				Diagram containedDiagram = (Diagram) eObject;
				EAnnotation eAnnotation = containedDiagram.getEAnnotation(DiagramsRelatedToElement);
				if (eAnnotation != null) {
					if (eAnnotation.getReferences().contains(domainElement)) {
						diagrams.add(containedDiagram);
					}
				}
			}
		}
		return diagrams;
	}

	/**
	 * Gets the diagrams associated to element.
	 * 
	 * @param element
	 *            the element
	 * 
	 * @return the diagrams associated to element
	 */
	public static List<Diagram> getDiagramsAssociatedToElement(EObject element) {
		Resource resource = getDiagramResource();
		if (resource == null || element == null) {
			return Collections.EMPTY_LIST;
		}
		List<Diagram> diagrams = new ArrayList<Diagram>();
		for (EObject child : resource.getContents()) {
			if (child instanceof Diagram) {
				Diagram diagram = (Diagram) child;
				if (element.equals(diagram.getElement())) {
					diagrams.add(diagram);
				}
			}
		}
		return diagrams;
	}

	/**
	 * Gets the diagram resource.
	 * 
	 * @return the diagram resource
	 */
	private static GMFResource getDiagramResource() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor != null && activeEditor instanceof DiagramEditor) {
			TransactionalEditingDomain domain = ((DiagramEditor) activeEditor).getEditingDomain();
			if (domain == null) {
				return null;
			}
			for (Resource resource : domain.getResourceSet().getResources()) {
				if (resource instanceof GMFResource) {
					return (GMFResource) resource;
				}
			}
		}
		return null;
	}

	// //****////
	/**
	 * Adds the e annotation reference to diagram.
	 * 
	 * @param plugin
	 *            the plugin
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean addEAnnotationReferenceToDiagram(AbstractUIPlugin plugin, EObject eObject) {
		return AddEAnnotationReferenceToDiagram(DiagramEditPartsUtil.findDiagramFromPlugin(plugin), eObject);
	}

	/**
	 * Adds the e annotation reference to diagram.
	 * 
	 * @param editPart
	 *            the edit part
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean addEAnnotationReferenceToDiagram(EditPart editPart, EObject eObject) {
		return AddEAnnotationReferenceToDiagram(DiagramEditPartsUtil.findDiagramFromEditPart(editPart), eObject);
	}

	/**
	 * Adds the e annotation reference to diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean AddEAnnotationReferenceToDiagram(Diagram diagram, EObject eObject) {

		if (diagram != null) {
			EAnnotation eAnnotation = diagram.getEAnnotation(BelongToDiagramSource);
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(BelongToDiagramSource);
				diagram.getEAnnotations().add(eAnnotation);
			}
			// if (eAnnotation.getReferences().contains(eObject) == false) {
			eAnnotation.getReferences().add(eObject);
			// }
			return true;
		}
		return false;
	}

	/**
	 * Removes the e annotation reference from diagram.
	 * 
	 * @param plugin
	 *            the plugin
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean RemoveEAnnotationReferenceFromDiagram(AbstractUIPlugin plugin, EObject eObject) {
		return RemoveEAnnotationReferenceFromDiagram(DiagramEditPartsUtil.findDiagramFromPlugin(plugin), eObject);
	}

	/**
	 * Removes the e annotation reference from diagram.
	 * 
	 * @param editPart
	 *            the edit part
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean RemoveEAnnotationReferenceFromDiagram(EditPart editPart, EObject eObject) {
		return RemoveEAnnotationReferenceFromDiagram(DiagramEditPartsUtil.findDiagramFromEditPart(editPart), eObject);
	}

	/**
	 * Removes the e annotation reference from diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean RemoveEAnnotationReferenceFromDiagram(Diagram diagram, EObject eObject) {

		if (diagram != null) {
			EAnnotation eAnnotation = diagram.getEAnnotation(BelongToDiagramSource);
			if (eAnnotation == null) {
				return false;
			}
			if (eAnnotation.getReferences().contains(eObject) == true) {
				eAnnotation.getReferences().remove(eObject);
				return true;
			}
		}
		return false;
	}

	/**
	 * Find e object referenced in e annotation.
	 * 
	 * @param editPart
	 *            the edit part
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean findEObjectReferencedInEAnnotation(EditPart editPart, EObject eObject) {
		return findEObjectReferencedInEAnnotation(DiagramEditPartsUtil.findDiagramFromEditPart(editPart), eObject);
	}

	/**
	 * Find e object referenced in e annotation.
	 * 
	 * @param plugin
	 *            the plugin
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean findEObjectReferencedInEAnnotation(AbstractUIPlugin plugin, EObject eObject) {
		return findEObjectReferencedInEAnnotation(DiagramEditPartsUtil.findDiagramFromPlugin(plugin), eObject);
	}

	/**
	 * Find e object referenced in e annotation.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param eObject
	 *            the e object
	 * 
	 * @return true, if successful
	 */
	public static boolean findEObjectReferencedInEAnnotation(Diagram diagram, EObject eObject) {

		if (diagram != null) {
			EAnnotation eAnnotation = diagram.getEAnnotation(BelongToDiagramSource);
			if (eAnnotation == null || !eAnnotation.getReferences().contains(eObject)) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Gets the all references in e annotation.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the all references in e annotation
	 */
	public static List<EObject> getAllReferencesInEAnnotation(Diagram diagram) {
		EAnnotation eAnnotation = diagram.getEAnnotation(BelongToDiagramSource);
		if (eAnnotation != null) {
			return eAnnotation.getReferences();
		}
		return Collections.EMPTY_LIST;
	}

	// //****////
	/**
	 * Add to a diagram the version of the first editor that will modify the diagram. It uses MOSKittEditorsIDs.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
	 */
	public static void addMultiDiagramVersion(Diagram diagram) {
		String diagramKind = diagram.getType();
		if (diagramKind == null)
			return;
		String editorId = MOSKittEditorIDs.getAllExtensionModelToEditor().get(diagramKind);
		if (editorId == null)
			return;

		IPluginContribution pluginContribution = (IPluginContribution) PlatformUI.getWorkbench().getEditorRegistry().findEditor(editorId);
		Bundle bundle = Platform.getBundle(pluginContribution.getPluginId());
		String version = (String) bundle.getHeaders().get(Constants.BUNDLE_VERSION);

		MDTUtil.addDiagramVersion(diagram, version);
	}

	/**
	 * Intialize new diagram.
	 * 
	 * @param kind
	 *            the kind
	 * @param domainElement
	 *            the domain element
	 * @param resource
	 *            the resource
	 * @param initializers
	 *            the initializers
	 * 
	 * @return the diagram
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	public static Diagram intializeNewDiagram(String kind, EObject domainElement, Resource resource, Map<String, IDiagramInitializer> initializers) throws ExecutionException {
		return intializeNewDiagram(kind, domainElement, resource, initializers, true);
	}

	/**
	 * Intialize new diagram.
	 * 
	 * @param kind
	 *            the kind
	 * @param domainElement
	 *            the domain element
	 * @param resource
	 *            the resource
	 * @param initializers
	 *            the initializers
	 * @param askName
	 *            the ask name
	 * 
	 * @return the diagram
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	public static Diagram intializeNewDiagram(String kind, EObject domainElement, Resource resource, Map<String, IDiagramInitializer> initializers, boolean askName) throws ExecutionException {
		Diagram d = null;
		try {
			d = ViewService.createDiagram(domainElement, kind, MDTUtil.getPreferencesHint(kind));
			if (askName && !setDigramName(d)) {
				return null;
			}
		} catch (ExecutionException ex) {
			return null;
		}
		if (d == null) {
			throw new ExecutionException("Can't create diagram of '" + kind + "' kind");
		}

		// insert the eAnnotation to set the diagram to be opened in the
		// OpenUpper action
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) activeEditor;
			Diagram activeDiagram = diagramEditor.getDiagram();
		}

		associateDiagramToView(d);
		createInitialElements(d, initializers);
		// This will add the version of the editor that will edit the diagram
		addMultiDiagramVersion(d);
		resource.getContents().add(d);
		return d;
	}

	/**
	 * Sets the digram name.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return true, if successful
	 */
	protected static boolean setDigramName(Diagram diagram) {
		String message = "";
		message += "New " + diagram.getType() + " diagram name";
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Diagram name", message, diagram.getType(), null);
		int result = dialog.open();
		if (result == Window.OK) {
			String name = dialog.getValue();
			diagram.setName(name);
			return true;
		}
		return false;
	}

	/**
	 * Intialize new diagram.
	 * 
	 * @param kind
	 *            the kind
	 * @param domainElement
	 *            the domain element
	 * @param resource
	 *            the resource
	 * @param initializers
	 *            the initializers
	 * @param askName
	 *            the ask name
	 * @param name
	 *            the name
	 * 
	 * @return the diagram
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	public static Diagram intializeNewDiagram(String kind, EObject domainElement, Resource resource, Map<String, IDiagramInitializer> initializers, boolean askName, String name)
			throws ExecutionException {
		Diagram d = null;
		try {
			d = ViewService.createDiagram(domainElement, kind, MDTUtil.getPreferencesHint(kind));
			if (askName && !setDigramName(d, name)) {
				return null;
			}
		} catch (ExecutionException ex) {
			return null;
		}
		if (d == null) {
			throw new ExecutionException("Can't create diagram of '" + kind + "' kind");
		}

		// insert the eAnnotation to set the diagram to be opened in the
		// OpenUpper action
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) activeEditor;
			Diagram activeDiagram = diagramEditor.getDiagram();
		}

		associateDiagramToView(d);
		createInitialElements(d, initializers);
		// This will add the version of the editor that will edit the diagram
		addMultiDiagramVersion(d);
		resource.getContents().add(d);
		return d;
	}

	/**
	 * Sets the digram name.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param name
	 *            the name
	 * 
	 * @return true, if successful
	 */
	protected static boolean setDigramName(Diagram diagram, String name) {
		String message = "";
		message += "New " + diagram.getType() + " diagram name";
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Diagram name", message, name, null);
		int result = dialog.open();
		if (result == Window.OK) {
			String n = dialog.getValue();
			diagram.setName(n);
			return true;
		}
		return false;
	}

	/**
	 * Sets the editor for diagram.
	 * 
	 * @param uri
	 *            the uri
	 * @param editorID
	 *            the editor id
	 * 
	 * @throws CoreException
	 *             the core exception
	 */
	public static void setEditorForDiagram(URI uri, String editorID) throws CoreException {
		String part1 = uri.path().replaceFirst("resource", "");
		IPath path = new Path(part1);
		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if (file != null) {
			file.setPersistentProperty(IDE.EDITOR_KEY, editorID);
			return;
		}
		throw new CoreException(new Status(IStatus.ERROR, Activator.ID, "Error setting file property"));
	}

	/**
	 * Creates the initial elements.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param initializers
	 *            the initializers
	 */
	private static void createInitialElements(Diagram diagram, Map<String, IDiagramInitializer> initializers) {
		if (initializers != null) {
			String kind = diagram.getType();
			if (initializers.containsKey(kind)) {
				IDiagramInitializer initializer = initializers.get(kind);
				initializer.init(diagram);
			}
		}
	}

	/**
	 * Gets the save options.
	 * 
	 * @return the save options
	 */
	public static Map getSaveOptions() {
		Map saveOptions = new HashMap();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		return saveOptions;
	}

	/**
	 * Perform delete diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param confirm
	 *            the confirm
	 * 
	 * @return the diagram
	 */
	public static Diagram performDeleteDiagram(Diagram diagram, boolean confirm) {
		if (diagram == null) {
			return null;
		}
		// Get upper diagram to open in case the one deleted is active.
		Diagram diagramToOpen = getUpperDiagram(diagram);
		if (diagramToOpen == null || diagramToOpen.equals(diagram)) {
			// This is the uppest diagram we'll look for a diagram at the same
			// level
			diagramToOpen = getOtherDiagram(diagram);
			if (diagramToOpen == null) {
				// no suitable diagram to open
				return null;
			}
		}

		// The diagram is Ok to be deleted. Ask user confirmation.
		if (confirm) {
			MessageDialog confirmDialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Delete diagram?", null, "Are oyu sure you want to delete the selected diagram?",
					MessageDialog.WARNING, new String[] { "Yes", "No" }, 1);
			int result = confirmDialog.open();
			if (result == Window.CANCEL) {
				return null;
			}
		}

		if (!isDiagramActive(diagram)) {
			// If the diagram to delete is not active it can be deleted without
			// problems.
			deleteDiagramAndSave(diagram);
		} else {
			// If the diagram to delete is active, a complex process must be
			// folowed to delete it.
			// Close all diagram editors that have the diagram to be deleted
			// active.
			EditingDomainRegistry.getInstance().setChangingCachedEditors(true);
			closeEditorsThatShowDiagram(diagram);
			// Delete diagram
			deleteDiagramAndSave(diagram);
			// Open its upper diagram
			try {
				openDiagram(diagramToOpen);
			} catch (ExecutionException ex) {
				IStatus status = new Status(IStatus.ERROR, Activator.ID, "Can't open diagram");
				Activator.getDefault().getLog().log(status);
				return null;
			} finally {
				EditingDomainRegistry.getInstance().setChangingCachedEditors(false);
			}
		}
		return diagramToOpen;
	}

	/**
	 * Checks if is diagram active.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return true, if is diagram active
	 */
	public static boolean isDiagramActive(Diagram diagram) {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) activeEditor;
			Diagram activeDiagram = diagramEditor.getDiagram();
			if (diagram.equals(activeDiagram)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Delete diagram and save.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean deleteDiagramAndSave(Diagram diagram) {
		if (diagram != null && diagram.eResource() != null) {
			Resource diagramResource = diagram.eResource();
			if (deleteDiagramFromResource(diagram, diagram.eResource()) == false) {
				return false;
			}
			try {
				diagramResource.save(getSaveOptions());
			} catch (IOException ex) {
				IStatus status = new Status(IStatus.ERROR, Activator.ID, "Error saving resource");
				Activator.getDefault().getLog().log(status);
				return false;
			}
		}
		return true;
	}

	/**
	 * Deletes a <Diagram> in the given <Resource>.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param resource
	 *            the resource
	 * 
	 * @return true, if delete diagram from resource
	 */
	public static boolean deleteDiagramFromResource(Diagram diagram, Resource resource) {
		if (diagram == null || resource == null) {
			return false;
		}
		resource.getContents().remove(diagram);
		return resource.getContents().contains(diagram) == false;
	}

	/**
	 * Closes all diagram editors that are showing the given <Diagram>.
	 * 
	 * @param diagram
	 *            diagram to be closed
	 */
	public static void closeEditorsThatShowDiagram(Diagram diagram) {
		if (diagram == null) {
			return;
		}
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = page.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			IEditorPart editorPart = editorReference.getEditor(false);
			if (editorPart instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor) editorPart;
				Diagram editorDiagram = diagramEditor.getDiagram();
				if (diagram.equals(editorDiagram)) {
					page.closeEditor(diagramEditor, true);
				}
			}
		}
	}

	/**
	 * Delete and save e object in resource.
	 * 
	 * @param uri
	 *            the uri
	 * @param fragment
	 *            the fragment
	 * 
	 * @return true, if successful
	 */
	public static boolean deleteAndSaveEObjectInResource(URI uri, String fragment) {
		URI resourceURI = uri;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		Resource resource = resourceSet.getResource(resourceURI, true);
		EObject toDelete = resource.getEObject(fragment);
		if (toDelete != null && resource.getContents().contains(toDelete)) {
			resource.getContents().remove(toDelete);
			try {
				resource.save(getSaveOptions());
			} catch (IOException e) {
				Log.error(null, 0, "Error saving resource " + resource.toString(), e);
				return false;
			}
		}
		return true;
	}

	// //****////

	/**
	 * Open diagram and close the one we come from.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the i editor part
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	public static IEditorPart openDiagram(Diagram diagram) throws ExecutionException {
		return openDiagram(diagram, false);
	}

	/**
	 * Open diagram and optionally close the one we come from.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the i editor part
	 * 
	 * @throws ExecutionException
	 *             the execution exception
	 */
	public static IEditorPart openDiagram(Diagram diagram, boolean openInNew) throws ExecutionException {
		//
		MDTUtil.setLastOpenedDiagramProperty(diagram);
		//
		URI uri = diagram.eResource().getURI();
		uri = uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		String diagramName = MDTUtil.getDiagramName(diagram);
		IEditorInput editorInput = new CachedResourcesEditorInput(uri, diagramName, false, openInNew);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart activeEditor = page.getActiveEditor();
		// check if we can just change the input of the editor
		// if (openInNew == false && activeEditor instanceof CachedResourcesDiagramEditor) {
		// CachedResourcesDiagramEditor diagramEditor = (CachedResourcesDiagramEditor) activeEditor;
		// Diagram editorDiagram = diagramEditor.getDiagram();
		// if (editorDiagram != null) {
		// Resource editorDiagramResource = editorDiagram.eResource();
		// Resource diagramResource = diagram.eResource();
		// if (editorDiagramResource != null
		// && editorDiagramResource.equals(diagramResource)) {
		// if (checkDiagramForEditor(diagram, diagramEditor)) {
		// diagramEditor.doSave(new NullProgressMonitor());
		// diagramEditor.setInput(editorInput);
		// return diagramEditor;
		// }
		// }
		// }
		// }
		// close other diagrams using the same resource
		// and open the new one
		EditingDomainRegistry.getInstance().setChangingCachedEditors(true);
		// fjcano: test
		if (openInNew == false) {
			page.closeEditor(activeEditor, true);
			// closeOtherDiagrams(diagram, page, !sameResource);
		}
		try {
			String editorID = MOSKittEditorIDs.getAllExtensionModelToEditor().get(diagram.getType());
			IEditorPart openedEditor = page.openEditor(editorInput, editorID);
			page.activate(openedEditor);
			return openedEditor;
		} catch (PartInitException ex) {
			throw new ExecutionException("Can't open diagram", ex);
		} finally {
			EditingDomainRegistry.getInstance().setChangingCachedEditors(false);
		}
	}

	/**
	 * Check diagram for editor.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param editor
	 *            the editor
	 * 
	 * @return true, if successful
	 */
	protected static boolean checkDiagramForEditor(Diagram diagram, CachedResourcesDiagramEditor editor) {
		String kind = diagram.getType();
		String diagramEditorID = MOSKittEditorIDs.getAllExtensionModelToEditor().get(kind);
		String editorID = editor.getEditorID();
		return (diagramEditorID != null && diagramEditorID.equals(editorID));
	}

	/**
	 * Close other diagrams.
	 * 
	 * @param diagramToOpen
	 *            the diagram to open
	 * @param page
	 *            the page
	 * @param unload
	 *            the unload
	 */
	protected static void closeOtherDiagrams(Diagram diagramToOpen, IWorkbenchPage page, boolean unload) {
		EObject rootEObject = diagramToOpen.getElement();
		if (rootEObject == null) {
			return;
		}
		Resource activeResource = rootEObject.eResource();
		String activeUri = activeResource.getURI().trimFragment().toString();
		for (IEditorReference editorReference : page.getEditorReferences()) {
			IEditorPart editor = editorReference.getEditor(true);
			Resource resource = MDTUtil.getRootElementResource(editor);
			if (resource == null) {
				continue;
			}
			String uri = resource.getURI().trimFragment().toString();
			if (activeUri.equals(uri)) {
				editor.doSave(new NullProgressMonitor());
				if (editor instanceof CachedResourcesDiagramEditor) {
					((CachedResourcesDiagramEditor) editor).setUnloadOnDispose(unload);
				}
				page.closeEditor(editor, true);
			}
		}
	}

	// // Get upper diagram

	/**
	 * Gets the upper diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the upper diagram
	 */
	public static Diagram getUpperDiagram(Diagram diagram) {
		if (diagram == null) {
			return null;
		}

		EObject domainElement = diagram.getElement();
		Resource gmfResource = diagram.eResource();
		do {
			for (EObject eObject : gmfResource.getContents()) {
				if (eObject instanceof Diagram) {
					if (diagram.equals(eObject) == false && diagramHasElement((Diagram) eObject, domainElement)) {
						return (Diagram) eObject;
					}
				}
			}
			// no diagram that includes this element was found
			// search for diagrams that include the parent element
			domainElement = domainElement.eContainer();
		} while (domainElement != null);

		return null;
	}

	/**
	 * Gets the other diagram.
	 * 
	 * @param diagram
	 *            the diagram
	 * 
	 * @return the other diagram
	 */
	public static Diagram getOtherDiagram(Diagram diagram) {
		if (diagram == null) {
			return null;
		}

		EObject domainElement = diagram.getElement();
		Resource gmfResource = diagram.eResource();
		for (EObject eObject : gmfResource.getContents()) {
			if (eObject instanceof Diagram) {
				Diagram newDiagram = (Diagram) eObject;
				if (diagram.equals(newDiagram) == false && domainElement.equals(newDiagram.getElement())) {
					return newDiagram;
				}
			}
		}
		// no diagram that includes this element was found
		// search for diagrams that include the parent element
		domainElement = domainElement.eContainer();

		return null;
	}

	/**
	 * Checks whether a <Diagram> contains a <View> of the given element.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param element
	 *            the element
	 * 
	 * @return true, if successful
	 */
	private static boolean diagramHasElement(Diagram diagram, EObject element) {

		for (TreeIterator<EObject> iterator = diagram.eAllContents(); iterator.hasNext();) {
			EObject eObject = iterator.next();
			if (eObject instanceof View) {
				if (((View) eObject).getElement() != null && ((View) eObject).getElement().equals(element)) {
					return true;
				}
			}
		}

		return false;
	}

}
