/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 * 				 Gabriel Merin Cubero (Prodevelop) – Operations to add a diagram version
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.ids.MOSKittEditorIDs;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesDiagramEditor;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesEditorInput;
import org.eclipse.papyrus.diagram.common.part.EditingDomainRegistry;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

/**
 * The Class MDTUtil.
 * 
 * @author <a href="fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @author <a href="gmerin@prodevelop.es">Grabriel Merin Cubero</a>
 * 
 */
public class MDTUtil {

	// ID for the EAnnotation that describes the version of the first editor
	// that modified the diagram
	/** The EDITO r_ version. */
	public static String EDITOR_VERSION = "org.eclipse.papyrus.diagram.common.Editor";

	/**
	 * Add to a diagram the version of the first editor that will modify the diagram.
	 * 
	 * @param diagram
	 *        the diagram
	 * @param version
	 *        version of the editor that is going to modify the diagram
	 * 
	 * @author gmerin
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
	 */
	public static void addDiagramVersion(Diagram diagram, String version) {
		if(version == null) {
			// if version is null no action will be taken:
			return;
		}
		EAnnotation eAnnotation = diagram.getEAnnotation(EDITOR_VERSION);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(EDITOR_VERSION);
			// Add a detail to store the version
			eAnnotation.getDetails().put("version", version);

			diagram.getEAnnotations().add(eAnnotation);
		}
	}

	/**
	 * Obtain the diagram the version of first editor that modified the diagram.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return the diagram version
	 * 
	 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a> The version of the first
	 *         editor that modified the diagram
	 */
	// @unused
	public static String getDiagramVersion(Diagram diagram) {
		EAnnotation eAnnotation = diagram.getEAnnotation(EDITOR_VERSION);
		// No version of the diagram
		if(eAnnotation == null) {
			return null;
		}
		return eAnnotation.getDetails().get("version");
	}

	/**
	 * Obtain the plugin's version of the editor.
	 * 
	 * @param editor
	 *        Editor Part
	 * 
	 * @return the editor version
	 * 
	 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a> The version of the editor
	 */
	// @unused
	public static String getEditorVersion(IEditorPart editor) {
		return getBundleVersion(editor.getSite().getPluginId());
	}

	/**
	 * Obtain the plugin's version of the editor.
	 * 
	 * @param pluginId
	 *        Plugin ID
	 * 
	 * @return The version of the plugin
	 * 
	 * @author gmerin
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
	 */
	public static String getBundleVersion(String pluginId) {
		Bundle bundle = Platform.getBundle(pluginId);
		if(bundle == null) {
			return null;
		}
		String version = (String)bundle.getHeaders().get(Constants.BUNDLE_VERSION);
		return version;
	}

	/**
	 * Gets the workspace location.
	 * 
	 * @return the workspace location
	 */
	public static IPath getWorkspaceLocation() {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getLocation();
		} catch (NullPointerException ex) {
			IStatus status = new Status(IStatus.ERROR, Activator.ID, "Error getting workspace", ex);
			Activator.getDefault().getLog().log(status);
			return null;
		}
	}

	/**
	 * Full file path to resource.
	 * 
	 * @param filePath
	 *        the file path
	 * 
	 * @return the string
	 */
	public static String fullFilePathToResource(String filePath) {
		String workspaceLocation = getWorkspaceLocation().toString();
		return filePath.replaceFirst(workspaceLocation, "");
	}

	/**
	 * Full file path to resource uri.
	 * 
	 * @param filePath
	 *        the file path
	 * 
	 * @return the uRI
	 */
	public static URI fullFilePathToResourceURI(String filePath) {
		String uri = fullFilePathToResource(filePath);
		return URI.createPlatformResourceURI(uri, true);
	}

	/**
	 * Gets the diagram name.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return the diagram name
	 */
	public static String getDiagramName(Diagram diagram) {
		if(diagram != null) {
			String type = diagram.getType();
			String label = MOSKittEditorIDs.getExtensionsMapModelToLabel().get(type);
			label = label != null ? label : "";
			return label + " : " + diagram.getName();
		}
		return null;
	}

	/**
	 * Retieves the <Diagram> from the given <IEditorPart>.
	 * 
	 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
	 * @param editor
	 * @return
	 */
	public static Diagram getDiagramFomEditor(IEditorPart editor) {
		if(editor instanceof DiagramEditor) {
			return ((DiagramEditor)editor).getDiagram();
		} else {
			if(editor != null) {
				Object adapted = editor.getAdapter(Diagram.class);
				if(adapted instanceof Diagram) {
					return (Diagram)adapted;
				}
			}
		}
		return null;
	}

	// @unused
	public static IEditorPart getActiveEditor() {
		try {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		} catch (NullPointerException ex) {
			return null;
		}
	}

	/**
	 * Gets the preferences hint.
	 * 
	 * @param kind
	 *        the kind
	 * 
	 * @return the preferences hint
	 * 
	 * @throws ExecutionException
	 *         the execution exception
	 */
	public static PreferencesHint getPreferencesHint(String kind) throws ExecutionException {
		String editor = MOSKittEditorIDs.getAllExtensionModelToEditor().get(kind);
		return new PreferencesHint(editor);
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
	 * Gets the root element resource.
	 * 
	 * @param editorPart
	 *        the editor part
	 * 
	 * @return the root element resource
	 */
	public static Resource getRootElementResource(IEditorPart editorPart) {
		EObject rootElement = getEditorRootelement(editorPart);
		Resource resource = null;
		if(rootElement != null) {
			resource = rootElement.eResource();
		}
		return resource;
	}

	/**
	 * Gets the editor rootelement.
	 * 
	 * @param editorPart
	 *        the editor part
	 * 
	 * @return the editor rootelement
	 */
	public static EObject getEditorRootelement(IEditorPart editorPart) {
		EditPart rootEditPart = (EditPart)editorPart.getAdapter(EditPart.class);
		if(rootEditPart == null) {
			return null;
		}
		EObject rootElement = null;
		Object object = ((EditPart)rootEditPart.getChildren().get(0)).getModel();
		if(object instanceof View) {
			rootElement = ((View)object).getElement();
		}
		return rootElement;
	}

	/**
	 * Gets the host diagram.
	 * 
	 * @param policy
	 *        the policy
	 * 
	 * @return the host diagram
	 */
	// @unused
	public static Diagram getHostDiagram(EditPolicy policy) {
		if(policy.getHost() instanceof IGraphicalEditPart) {
			View view = ((IGraphicalEditPart)policy.getHost()).getNotationView();
			if(view != null) {
				view = view.getDiagram();
			}
			if(view instanceof Diagram) {
				return (Diagram)view;
			}
		}
		return null;
	}

	/**
	 * Gets a Diagram from the Request looking for it in the extended data with key
	 * <MultiDiagramUtil.BelongToDiagramSource>
	 * 
	 * @param request
	 * @return
	 */
	// @unused
	public static Diagram getDiagramFromRequest(IEditCommandRequest request) {
		Diagram diagram = null;
		if(request != null) {
			Object data = request.getParameters().get(MultiDiagramUtil.BelongToDiagramSource);
			if(data instanceof Diagram) {
				diagram = (Diagram)data;
			}
		}
		return diagram;
	}

	public static List<EObject> getRootElementsFromFile(IEditorInput input) {
		return getRootElementsFromFile(input, null);
	}

	public static List<EObject> getRootElementsFromFile(IEditorInput input, ResourceSet resourceSet) {
		URI uri = null;
		IURIEditorInput uriEditorInput = (IURIEditorInput)Platform.getAdapterManager().getAdapter(input, IURIEditorInput.class);
		if(uriEditorInput != null) {
			uri = URI.createURI(uriEditorInput.getURI().toString());
		} else {
			IFileEditorInput fileEditorInput = (IFileEditorInput)Platform.getAdapterManager().getAdapter(input, IFileEditorInput.class);
			if(fileEditorInput != null) {
				uri = URI.createURI(fileEditorInput.getFile().getLocationURI().toString());
			}
		}
		if(uri != null) {
			resourceSet = resourceSet != null ? resourceSet : new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			if(resource != null) {
				List<EObject> rootEObjects = new ArrayList<EObject>();
				for(EObject eObject : resource.getContents()) {
					rootEObjects.add(eObject);
				}
				return rootEObjects;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Gets the object name or empty string.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the object name or empty string
	 */
	// @unused
	public static String getObjectNameOrEmptyString(Object object) {
		String name = getObjectName(object);
		return name == null ? "" : name;
	}

	/** The Constant getNameNames. */
	private static final String[] getNameNames = { "getName", "getname" };

	/**
	 * Gets the object name.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the object name
	 */
	public static String getObjectName(Object object) {
		if(object == null) {
			return null;
		}
		Method method = null;
		Object o = null;
		for(String methodName : getNameNames) {
			try {
				method = object.getClass().getMethod(methodName, (Class[])null);
			} catch (NoSuchMethodException e) {
				method = null;
			}
			if(method != null) {
				break;
			}
		}
		if(method != null) {
			try {
				o = method.invoke(object, (Object[])null);
			} catch (IllegalAccessException ex) {
				return null;
			} catch (InvocationTargetException ex) {
				return null;
			}
			if(o instanceof String) {
				return (String)o;
			}
		}
		return null;
	}

	/**
	 * Resolve semantic.
	 * 
	 * @param object
	 *        the object
	 * 
	 * @return the e object
	 */
	public static EObject resolveSemantic(Object object) {
		if(object instanceof EditPart) {
			object = ((EditPart)object).getModel();
		}
		if(object instanceof View) {
			object = ((View)object).getElement();
		}
		if(object instanceof EObject) {
			return (EObject)object;
		}
		return null;
	}

	private static final String LastOpenedDiagramPropertyBase = "lastOpenedDiagram";

	/** The Constant LastOpenedDiagramProperty. */
	public static final QualifiedName LastOpenedDiagramProperty = new QualifiedName(Activator.ID, LastOpenedDiagramPropertyBase);

	/**
	 * A QualifiedName for a specific editor.
	 * 
	 * @param editorID
	 * @return
	 */
	public static QualifiedName getLastOpenedDiagramPropertyQualifiedNameForEditor(String editorID) {
		return new QualifiedName(Activator.ID, LastOpenedDiagramPropertyBase + (editorID != null ? editorID : ""));
	}

	// @unused
	public static CachedResourcesDiagramEditor getCachedResourcesDiagramEditorFromEditorRef(IEditorReference reference) {
		if(reference == null) {
			return null;
		}
		IWorkbenchPart part = reference.getEditor(false);

		if(part == null) {
			return null;
		}

		CachedResourcesDiagramEditor editor = (CachedResourcesDiagramEditor)Platform.getAdapterManager().getAdapter(part, CachedResourcesDiagramEditor.class);
		if(editor != null) {
			return editor;
		}
		return null;
	}

	/**
	 * Sets the last opened diagram property.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean setLastOpenedDiagramProperty(Diagram diagram) {
		return setLastOpenedDiagramProperty(diagram, null);
	}

	/**
	 * Sets the last opened diagram property.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean setLastOpenedDiagramProperty(Diagram diagram, String editorID) {
		return setLastOpenedDiagramProperty(diagram, editorID, true);
	}

	/**
	 * Sets the last opened diagram property.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean setLastOpenedDiagramProperty(Diagram diagram, String editorID, boolean setEditorForFileProperty) {
		if(editorID == null) {
			editorID = MOSKittEditorIDs.getAllExtensionModelToEditor().get(diagram.getType());
		}
		// get Diagram fragment
		String fragment = diagram.eResource().getURIFragment(diagram);
		// get Diagram IFile
		URI uri = diagram.eResource().getURI();
		uri = uri != null ? uri.trimFragment() : null;
		String path = PathsUtil.fromAbsoluteFileSystemToAbsoluteWorkspace(uri.toPlatformString(true));
		return setLastOpenedDiagramProperty(path, fragment, editorID, setEditorForFileProperty);
	}

	/**
	 * Sets the last opened diagram property.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean setLastOpenedDiagramProperty(String path, String fragment, String editorID, boolean setEditorForFileProperty) {
		IPath filePath = new Path(path);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
		// set IFile property
		if(file != null) {
			try {
				QualifiedName propertyQualifiedName = getLastOpenedDiagramPropertyQualifiedNameForEditor(editorID);
				file.setPersistentProperty(propertyQualifiedName, fragment);
				// set the correct editor to edit
				if(setEditorForFileProperty && editorID != null) {
					setEditorForDiagramProperty(file, editorID);
				}
				return true;
			} catch (CoreException ex) {
				IStatus status = new Status(IStatus.WARNING, Activator.ID, "Error setting file property");
				Activator.getDefault().getLog().log(status);
			}
		}

		return false;
	}

	/**
	 * Sets the last opened diagram property.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return true, if successful
	 */
	public static boolean removeLastOpenedDiagramProperty(Diagram diagram) {
		if(diagram == null || diagram.eResource() == null) {
			return false;
		}

		// get Diagram fragment
		String fragment = diagram.eResource().getURIFragment(diagram);

		// get Diagram IFile
		URI uri = diagram.eResource().getURI();
		uri = uri != null ? uri.trimFragment() : null;
		String path = PathsUtil.fromAbsoluteFileSystemToAbsoluteWorkspace(uri.toPlatformString(true));
		IPath filePath = new Path(path);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
		// set IFile property
		if(file != null) {
			try {
				file.setPersistentProperty(LastOpenedDiagramProperty, null);
				// set the correct editor to edit
				Diagram firstDiagram = null;
				for(EObject elem : diagram.eResource().getContents()) {
					if(elem instanceof Diagram) {
						firstDiagram = (Diagram)elem;
						break;
					}
				}
				String editorID = MOSKittEditorIDs.getAllExtensionModelToEditor().get(firstDiagram.getType());
				if(editorID != null) {
					setEditorForDiagramProperty(file, editorID);
				}
				return true;
			} catch (CoreException ex) {
				IStatus status = new Status(IStatus.WARNING, Activator.ID, "Error setting file property");
				Activator.getDefault().getLog().log(status);
			}
		}

		return false;
	}

	/**
	 * Sets the editor for diagram property.
	 * 
	 * @param uri
	 *        the uri
	 * @param editorID
	 *        the editor id
	 * 
	 * @throws CoreException
	 *         the core exception
	 */
	public static void setEditorForDiagramProperty(URI uri, String editorID) {
		String part1 = uri.path().replaceFirst("resource", "");
		IPath path = new Path(part1);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if(file != null) {
			setEditorForDiagramProperty(file, editorID);
		}
	}

	/**
	 * Sets the editor for diagram property.
	 * 
	 * @param file
	 *        the file
	 * @param editorID
	 *        the editor id
	 * 
	 * @throws CoreException
	 *         the core exception
	 */
	public static void setEditorForDiagramProperty(IFile file, String editorID) {
		if(file != null) {
			try {
				file.setPersistentProperty(IDE.EDITOR_KEY, editorID);
			} catch (CoreException ex) {
				Activator.getDefault().logError("Couldn't set file editorToOpen property", ex);
			}
			return;
		}
	}

	/**
	 * Removes the property that specifies the editor that opens an IFile.
	 * 
	 * @param uri
	 * @return
	 */
	public static boolean removeEditorForDiagramProperty(URI uri) {
		String part1 = uri.path().replaceFirst("resource", "");
		IPath path = new Path(part1);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if(file != null) {
			return removeEditorForDiagramProperty(file);
		}
		return false;
	}

	/**
	 * Removes the property that specifies the editor that opens an IFile.
	 * 
	 * @param file
	 * @return
	 */
	public static boolean removeEditorForDiagramProperty(IFile file) {
		try {
			file.setPersistentProperty(IDE.EDITOR_KEY, null);
			return true;
		} catch (CoreException ex) {
			return false;
		}
	}

	// @unused
	public static boolean setEditorForDiagramForFirstDiagram(Resource resource) {
		Diagram diagram = MDTUtil.getFirstDiagramFromResource(resource);
		if(diagram != null) {
			String kind = diagram.getType();
			String editorID = MOSKittEditorIDs.getAllExtensionModelToEditor().get(kind);
			if(editorID != null) {
				MDTUtil.setEditorForDiagramProperty(resource.getURI(), editorID);
			}
		}
		return false;
	}

	/**
	 * Gets the last opened diagram property.
	 * 
	 * @param filePath
	 *        the file path
	 * 
	 * @return the last opened diagram property
	 */
	public static String getLastOpenedDiagramProperty(String filePath) {
		return getLastOpenedDiagramPropertyForEditor(filePath, null);
	}

	public static String getLastOpenedDiagramPropertyForEditor(String filePath, String editorID) {
		if(filePath == null) {
			return null;
		}
		IPath path = new Path(filePath);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		if(file != null) {
			try {
				return file.getPersistentProperty(getLastOpenedDiagramPropertyQualifiedNameForEditor(editorID));
			} catch (CoreException ex) {
				IStatus status = new Status(IStatus.WARNING, Activator.ID, "Error retieving editor property: ", ex);
				Activator.getDefault().getLog().log(status);
			}
		}
		return null;
	}

	/**
	 * Copy editor input but uri.
	 * 
	 * @param input
	 *        the input
	 * @param uri
	 *        the uri
	 * 
	 * @return the cached resources editor input
	 */
	public static CachedResourcesEditorInput copyEditorInputButUri(IEditorInput input, URI uri) {
		CachedResourcesEditorInput cachedInput = new CachedResourcesEditorInput(uri, input.getName());
		if(input instanceof CachedResourcesEditorInput) {
			cachedInput.setUnload(((CachedResourcesEditorInput)input).isUnload());
		}
		return cachedInput;
	}

	/**
	 * Gets or builds a valid CachedResourcesEditorInput for a given URI. The given URI must point
	 * to a valid GMFResource. <br>
	 * This URI can have a fragment defined. If the fragment does not point to a valid Diagram, the
	 * first Diagram of the Resource is returned as input.
	 * 
	 * @param editorInput
	 * @param editorID
	 * @return
	 */
	// @unused
	public static CachedResourcesEditorInput getValidEditorInput(URI editorInput, String editorID) {
		if(editorID != null && editorInput != null) {
			// get the shared editing domain, that will have the resources
			// already loaded and with the latest changes.
			TransactionalEditingDomain domain = EditingDomainRegistry.getInstance().get(editorID, editorInput.trimFragment().toString());
			if(domain != null) {
				// search for the given diagram in all the resourceSet.
				URI uri = getProperDiagramURIToOpen(domain.getResourceSet(), editorInput);
				if(uri != null) {
					// if we found a matching diagram, return it as a
					// CachedResourcesEditorInput
					return new CachedResourcesEditorInput(uri, false);
				}
			}
		}
		return null;
	}

	/**
	 * Tries to get the given Diagram in URI. If not, it will get the first Diagram.
	 * 
	 * @param resourceSet
	 * @param editorInput
	 * @return
	 */
	public static URI getProperDiagramURIToOpen(ResourceSet resourceSet, URI editorInput) {
		// search the target diagram in the resourceset.
		EObject eObject = searchEObjectFromFragment(editorInput, resourceSet);
		if(eObject != null) {
			// if found, make sure it is a Diagram
			Diagram diagram = (Diagram)Platform.getAdapterManager().getAdapter(eObject, Diagram.class);
			if(diagram != null) {
				// if it's a Diagram, return the proper URI
				return diagram.eResource().getURI().appendFragment(diagram.eResource().getURIFragment(diagram));
			}
		}
		// if target diagram is not found, look for the first Diagram
		Resource resource = resourceSet.getResource(editorInput.trimFragment(), true);
		if(resource != null) {
			Diagram diagram = getFirstDiagramFromResource(resource);
			if(diagram != null) {
				// if we find a diagram, return its URI.
				return resource.getURI().appendFragment(resource.getURIFragment(diagram));
			}
		}
		return null;
	}

	/**
	 * Searchs for an EObject in a ResourceSet by its fragment.
	 * 
	 * @param uriFragment
	 * @param resourceSet
	 * @return
	 */
	public static EObject searchEObjectFromFragment(URI uri, ResourceSet resourceSet) {
		if(uri == null) {
			return null;
		}
		String uriFragment = uri.fragment();
		if(uriFragment != null && uriFragment.length() > 0 && resourceSet != null) {
			resourceSet.getResource(uri.trimFragment(), true);
			for(Resource resource : resourceSet.getResources()) {
				// search for the EObject in each Resource
				EObject eObject = searchEObjectFromFragment(uriFragment, resource);
				if(eObject != null) {
					// if we find the target EObject in any of the Resources,
					// return it.
					return eObject;
				}
			}
		}
		return null;
	}

	/**
	 * Searchs for an EObject in a Resource by its fragment.
	 * 
	 * @param uriFragment
	 * @param resource
	 * @return
	 */
	public static EObject searchEObjectFromFragment(String uriFragment, Resource resource) {
		if(uriFragment != null && uriFragment.length() > 0 && resource != null) {
			// search for the EObject in the Resource.
			return resource.getEObject(uriFragment);
		}
		return null;
	}

	/**
	 * Returns the first Diagram in a GMFResource.
	 * 
	 * @param resource
	 * @return
	 */
	public static Diagram getFirstDiagramFromResource(Resource resource) {
		if(resource != null && resource.getContents().size() > 0) {
			// look for a Diagram in the whole Resource
			for(EObject eObject : resource.getContents()) {
				Diagram diagram = (Diagram)Platform.getAdapterManager().getAdapter(eObject, Diagram.class);
				if(diagram != null) {
					// the first Diagram found is returned.
					return diagram;
				}
			}
		}
		return null;
	}

	/**
	 * Looks in the class hierarchy for a Class or Interface with qualified name className.
	 * 
	 * @param clazz
	 * @param className
	 * @return
	 */
	public static boolean isOfType(Class clazz, String className) {
		if(clazz == null || className == null) {
			return false;
		}
		// check class
		if(clazz.getName().equals(className)) {
			return true;
		}
		// look interfaces
		for(Class c : clazz.getInterfaces()) {
			if(isOfType(c, className)) {
				return true;
			}
		}
		// look superclass
		return isOfType(clazz.getSuperclass(), className);
	}

	/**
	 * Gets the edits the parts from selection.
	 * 
	 * @param selection
	 *        the selection
	 * 
	 * @return the edits the parts from selection
	 */
	// @unused
	public static List<EditPart> getEditPartsFromSelection(ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			List<EditPart> editParts = new ArrayList<EditPart>();
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			for(Object object : structuredSelection.toList()) {
				if(object instanceof EditPart) {
					editParts.add((EditPart)object);
				}
			}
			return editParts;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the e objects from selection.
	 * 
	 * @param selection
	 *        the selection
	 * 
	 * @return the e objects from selection
	 */
	// @unused
	public static List<EObject> getEObjectsFromSelection(ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			List<EObject> eObjects = new ArrayList<EObject>();
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			for(Object object : structuredSelection.toList()) {
				EObject eObject = resolveSemantic(object);
				if(eObject != null) {
					eObjects.add(eObject);
				}
			}
			return eObjects;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Looks for <Diagram>s associated to an <EObject> and all its children.
	 * 
	 * @param eObject
	 *        <EObject> to begin the search
	 * @param gmfResource
	 *        <GMFResource> to look for <Diagram>s. If null, a <GMFResource> will be looked up
	 *        in the <EObject>'s <ResourceSet>, if any.
	 * 
	 * @return the diagrams in hierarchy
	 */
	// @unused
	public static List<Diagram> getDiagramsInHierarchy(EObject eObject, Resource gmfResource) {
		// no eObject means nothing to search for
		if(eObject == null) {
			return Collections.EMPTY_LIST;
		}
		// no gmfResource given, we'll search one
		if(gmfResource instanceof GMFResource == false) {
			Resource resource = eObject.eResource();
			ResourceSet resourceSet = resource != null ? resource.getResourceSet() : null;
			if(resourceSet != null) {
				for(Resource resourceAux : resourceSet.getResources()) {
					if(resourceAux instanceof GMFResource) {
						// gmfResource found
						gmfResource = resourceAux;
						break;
					}
				}
			}
		}
		// no gmfResource given nor found. Nothing to do.
		if(gmfResource instanceof GMFResource == false) {
			return Collections.EMPTY_LIST;
		}
		// start of search
		// List to store all found <Diagram>s
		List<Diagram> diagrams = new ArrayList<Diagram>();
		// List of all <EObject>s to check
		List<EObject> allEObjects = new ArrayList<EObject>();
		allEObjects.add(eObject);
		for(Iterator<EObject> iterator = eObject.eAllContents(); iterator.hasNext();) {
			allEObjects.add(iterator.next());
		}
		// search for each <EObject>'s <Diagram>s
		for(EObject element : allEObjects) {
			for(EObject content : gmfResource.getContents()) {
				if(content instanceof Diagram && element.equals(((Diagram)content).getElement())) {
					// a <Diagram> that references an affected <EObject> has
					// been found
					diagrams.add((Diagram)content);
				}
			}
		}
		if(diagrams.size() > 0) {
			// some <Diagram>s were found
			return diagrams;
		}
		return Collections.EMPTY_LIST;
	}

	// // Filter Views and Labels

	/** The Constant FilterViewAndLabelsSource. */
	public static final String FilterViewAndLabelsSource = "org.eclipse.papyrus.diagram.common.FilterViewsAndLabelsSource";

	/**
	 * Sets the elements to filter to diagram.
	 * 
	 * @param diagram
	 *        the diagram
	 * @param infos
	 *        the infos
	 */
	public static void setElementsToFilterToDiagram(Diagram diagram, Collection<Integer> infos) {
		if(diagram == null || infos == null) {
			return;
		}
		EAnnotation eAnnotation = diagram.getEAnnotation(FilterViewAndLabelsSource);
		if(eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(FilterViewAndLabelsSource);
			diagram.getEAnnotations().add(eAnnotation);
		}
		Collection<Integer> existing = getAllViewsToFilterFromDiagram(diagram);
		Collection<Integer> toAdd = new ArrayList<Integer>();
		Collection<Integer> toDelete = new ArrayList<Integer>();
		// build toAdd list
		for(Integer integer : infos) {
			if(existing.contains(integer) == false) {
				toAdd.add(integer);
			}
		}
		// build toDelete list
		for(Integer integer : existing) {
			if(infos.contains(integer) == false) {
				toDelete.add(integer);
			}
		}
		// add
		for(Integer integer : toAdd) {
			String key = String.valueOf(integer);
			if(false == eAnnotation.getDetails().containsKey(key)) {
				eAnnotation.getDetails().put(key, "");
			}
		}
		// delete
		for(Integer integer : toDelete) {
			String key = String.valueOf(integer);
			if(true == eAnnotation.getDetails().containsKey(key)) {
				eAnnotation.getDetails().remove(key);
			}
		}
	}

	/**
	 * Removes the element to filter from diagram.
	 * 
	 * @param diagram
	 *        the diagram
	 * @param infos
	 *        the infos
	 */
	// @unused
	public static void removeElementToFilterFromDiagram(Diagram diagram, Collection<ViewInfo> infos) {
		if(diagram == null || infos == null || infos.size() <= 0) {
			return;
		}
		EAnnotation eAnnotation = diagram.getEAnnotation(FilterViewAndLabelsSource);
		if(eAnnotation == null) {
			return;
		}
		for(ViewInfo info : infos) {
			String key = String.valueOf(info.getVisualID());
			if(eAnnotation.getDetails().containsKey(key)) {
				eAnnotation.getDetails().removeKey(key);
			}
		}
	}

	/**
	 * Gets the all views to filter from diagram.
	 * 
	 * @param diagram
	 *        the diagram
	 * 
	 * @return the all views to filter from diagram
	 */
	public static Collection<Integer> getAllViewsToFilterFromDiagram(Diagram diagram) {
		EAnnotation eAnnotation = diagram.getEAnnotation(FilterViewAndLabelsSource);
		if(eAnnotation == null) {
			return Collections.EMPTY_LIST;
		}
		Collection<Integer> keys = new ArrayList<Integer>();
		for(String key : eAnnotation.getDetails().keySet()) {
			keys.add(Integer.valueOf(key));
		}
		return keys;
	}

	/**
	 * Find element in diagram filter.
	 * 
	 * @param diagram
	 *        the diagram
	 * @param visualID
	 *        the visual id
	 * 
	 * @return true, if successful
	 */
	// @unused
	public static boolean findElementInDiagramFilter(Diagram diagram, int visualID) {
		if(diagram != null) {
			EAnnotation eAnnotation = diagram.getEAnnotation(FilterViewAndLabelsSource);
			if(eAnnotation == null) {
				return false;
			}
			String key = String.valueOf(visualID);
			return eAnnotation.getDetails().containsKey(key);
		}
		return false;
	}

	/**
	 * Filter diagram views.
	 * 
	 * @param diagram
	 *        the diagram
	 */
	public static void filterDiagramViews(Diagram diagram) {
		Collection<Integer> filters = getAllViewsToFilterFromDiagram(diagram);
		Iterator<EObject> it = diagram.eAllContents();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof View) {
				View view = (View)eObject;
				Integer integer = null;
				try {
					integer = Integer.valueOf(view.getType());
				} catch (NumberFormatException ex) {
					integer = null;
				}
				if(integer != null) {
					SetRequest request = null;
					if(filters.contains(integer)) {
						request = new SetRequest(view, NotationPackage.eINSTANCE.getView_Visible(), false);
					} else {
						request = new SetRequest(view, NotationPackage.eINSTANCE.getView_Visible(), true);
					}
					SetValueCommand command = new SetValueCommand(request);
					Object value = request.getValue();
					EObject elementToEdit = request.getElementToEdit();
					EStructuralFeature feature = request.getFeature();
					if(value != null && elementToEdit != null && feature != null && elementToEdit.eGet(feature) != null && !value.equals(elementToEdit.eGet(feature))) {
						TransactionUtil.getEditingDomain(view).getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
					}
				}
			}
		}
	}

	// //****////
	// @unused
	public static IStatusLineManager getStatusLineManager() {
		try {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars().getStatusLineManager();
		} catch (NullPointerException ex) {
			return null;
		}
	}

}
