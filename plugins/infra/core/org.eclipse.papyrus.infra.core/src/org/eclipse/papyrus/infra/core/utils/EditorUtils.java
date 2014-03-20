/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>: Code simplification and NPE
 *         management.
 *  Christian W. Damus (CEA LIST) - API for determining URI of a resource in an editor
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Set of utility methods for the CoreEditor. <br>
 * WARNING : Some of these methods rely on
 * PlatformUI.getWorkbench().getActiveWorkbenchWindow()getActivePage() to lookup
 * for shared objects owned by the main editor. This doesn't work during the
 * initialization of the main editor because the main editor is not yet
 * registered in the Eclipse workbench. This can lead to a null or an exception,
 * and sometime this can lead to getting the shared object of another main
 * editor !
 * 
 * @author cedric dumoulin
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
// FIXME throws Exception (eg: NotFoundException) instead of null
public class EditorUtils {

	/**
	 * Gets the opened multi-diagram editors.
	 * 
	 * @return The opened {@link IMultiDiagramEditor} or null if an error
	 *         occured.
	 */
	public static IMultiDiagramEditor[] getMultiDiagramEditors() {
		// Lookup ServiceRegistry
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(workbenchWindow == null) {
			return null;
		}
		IWorkbenchPage page = workbenchWindow.getActivePage();
		if(page == null) {
			return null;
		}
		List<IMultiDiagramEditor> list = new ArrayList<IMultiDiagramEditor>();
		for(IEditorReference editorRef : page.getEditorReferences()) {
			IEditorPart editorPart = editorRef.getEditor(false);
			if(editorPart instanceof IMultiDiagramEditor) {
				list.add((IMultiDiagramEditor)editorPart);
			}
		}
		return list.toArray(new IMultiDiagramEditor[list.size()]);
	}

	/**
	 * Returns the editors that are related to to given file.<BR>
	 * 
	 * @param file
	 *        The file (model, di or notation).
	 * @return The associated editors.
	 */
	public static IMultiDiagramEditor[] getRelatedEditors(IFile file) {
		// Get the DI file
		IFile diFile = DiModelUtils.getRelatedDiFile(file);
		if(diFile == null || !diFile.exists()) {
			return new IMultiDiagramEditor[0];
		}

		IMultiDiagramEditor[] openedEditors = EditorUtils.getMultiDiagramEditors();
		if(openedEditors == null) {
			return new IMultiDiagramEditor[0];
		}
		List<IMultiDiagramEditor> list = new ArrayList<IMultiDiagramEditor>(openedEditors.length);

		for(IMultiDiagramEditor editorPart : openedEditors) {
			if(editorPart.getEditorInput() instanceof IFileEditorInput && diFile.equals(((IFileEditorInput)editorPart.getEditorInput()).getFile())) {
				list.add(editorPart);
			}
		}
		return list.toArray(new IMultiDiagramEditor[list.size()]);
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource. This
	 * instance is suitable to add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @return The non transactional implementation of IPageMngr
	 */
	public static IPageManager getIPageMngr(Resource diResource) {
		return DiSashModelMngr.createIPageMngr(diResource);
	}


	////////////////////////////////////////////
	// The following methods are deprecated. They have been replaced by specific
	// implementations of ServiceUtils (e.g. ServiceUtilsForHandlers, ServiceUtilsForEObject),
	// which depend on a specific context (ExecutionEvent, EObject, ...) instead of
	// the active editor
	////////////////////////////////////////////

	/**
	 * Gets the {@link IMultiDiagramEditor} interface of the a Eclipse active
	 * editor, if possible, or null if not possible. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if there is no active editor, or if the editor is
	 * not instance of IMultiDiagramEditor. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. Usage of this method is discouraged. Use {@link #getMultiDiagramEditorChecked()} instead.
	 * 
	 * 
	 * @return Get the current {@link IMultiDiagramEditor} or null if not found.
	 */
	public static IMultiDiagramEditor getMultiDiagramEditor() {
		// Lookup ServiceRegistry
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(workbenchWindow == null) {
			return null;
		}
		IWorkbenchPage page = workbenchWindow.getActivePage();
		if(page == null) {
			return null;
		}
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof IMultiDiagramEditor) {
			return (IMultiDiagramEditor)editor;
		} else {
			return null;
		}
	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the
	 * current Diagram or null if none is active. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if the ServicesRegistry can not be found. <br>
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF
	 * plugin.
	 * 
	 * @return The active diagram or null if not found.
	 * 
	 * @deprecated The core do make suppositions about the type of nested
	 *             Editors, GMF stuff should be moved in GMF projects. In many
	 *             case, {@link #lookupActiveNestedIEditor()} can be used.
	 */
	//	@Deprecated
	//	public static Diagram lookupEditorActiveDiagram() {
	//		DiagramEditor diagEditor = lookupActiveDiagramEditor();
	//		return diagEditor == null ? null : diagEditor.getDiagram();
	//	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the
	 * current Diagram or null if none is active. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if the ServicesRegistry can not be found. <br>
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF
	 * plugin.
	 * 
	 * @return the active diagram editor or null if not found.
	 * 
	 * @deprecated The core do make suppositions about the type of nested
	 *             Editors, GMF stuff should be moved in GMF projects. In many
	 *             case, {@link #lookupActiveNestedIEditor()} can be used.
	 */
	//	@Deprecated
	//	public static DiagramEditor lookupActiveDiagramEditor() {
	//		// Get the active page within the sashcontainer
	//		IEditorPart activeEditor = lookupActiveNestedIEditor();
	//		// Check if it is a GMF DiagramEditor
	//		if(activeEditor instanceof DiagramEditor) {
	//			return ((DiagramEditor)activeEditor);
	//		} else {
	//			// Not found
	//			return null;
	//		}
	//
	//	}

	/**
	 * Lookup the currently active {@link IEditorPart} from the Papyrus editor.
	 * Return the current nested editor part, or null if it can not be found. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if the ServicesRegistry can not be found. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. An alternative is to use
	 * serviceRegistry.getService(ISashWindowsContainer
	 * .class).getActiveEditor(); <br>
	 * It is preferable to retrieve the ServiceRegistry from elsewhere whenever
	 * it is possible. <br>
	 * 
	 * 
	 * @return
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static IEditorPart lookupActiveNestedIEditor() {
		// Get the sashwindow container
		ISashWindowsContainer container = getSashWindowContainer();
		// Get the active page within the sashcontainer
		return container == null ? null : container.getActiveEditor();
	}

	/**
	 * Lookup the currently active IEditor in the SashSystem. If the currently
	 * eclipse active editor doesn't contains a {@link ISashWindowsContainer},
	 * return null. If the current SashSystem page is not a IEditor, return
	 * null. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if the ServicesRegistry can not be found. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. An alternative is to use
	 * serviceRegistry.getService(ISashWindowsContainer
	 * .class).getActiveSashWindowsPage(); <br>
	 * It is preferable to retrieve the ServiceRegistry from elsewhere whenever
	 * it is possible.
	 * 
	 * @return
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static IPage lookupActiveNestedPage() {

		// Get the sashwindow container
		ISashWindowsContainer container = getSashWindowContainer();
		// Get the active page within the sashcontainer
		return container == null ? null : container.getActiveSashWindowsPage();
	}

	/**
	 * 
	 * @return
	 */
	private static ISashWindowsContainer getSashWindowContainer() {

		try {
			return getServiceRegistryChecked().getService(ISashWindowsContainer.class);
		} catch (ServiceException e) {
			// The contract says that we return null if not found
			return null;
		}
	}

	/**
	 * Gets the di resource set.
	 * 
	 * @return Get the current {@link DiResourceSet} or null if not found.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static DiResourceSet getDiResourceSet() {
		try {
			ServicesRegistry registry = getServiceRegistry();
			return registry == null ? null : registry.getService(DiResourceSet.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Gets the {@link TransactionalEditingDomain} of the current active Eclipse
	 * Editor. This method should be used only when it is sure that the active
	 * editor exist, and that you want the EditingDomain of this editor. <br>
	 * This method return null if the TransactionalEditingDomain can not be
	 * found. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. An alternative is to use {@link #getTransactionalEditingDomainChecked()} and to catch the
	 * exception. <br>
	 * It is preferable to use {@link #getTransactionalEditingDomain(ServicesRegistry)} whenever it is
	 * possible. <br>
	 * In GMF EditParts or EditPolicies, the ServiceRegistry can be retrieved
	 * with methods from
	 * org.eclipse.papyrus.uml.diagram.common.util.DiagramCoreServiceUtils <br>
	 * WARNING: This method can return null if there is no Active Editor. This
	 * happen during the editor initialization, especially when there is no
	 * other editor opened.
	 * 
	 * @return Get the current {@link TransactionalEditingDomain} or null if not
	 *         found
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static TransactionalEditingDomain getTransactionalEditingDomain() {
		try {
			ServicesRegistry registry = getServiceRegistry();
			return registry == null ? null : registry.getService(TransactionalEditingDomain.class);
		} catch (IllegalStateException e) {
			// Registry can't be found, do nothing.
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Gets the {@link TransactionalEditingDomain} of the current active Eclipse
	 * Editor. This method should be used only when it is sure that the active
	 * editor exist, and that you want the EditingDomain of this editor. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * It is preferable to use {@link #getTransactionalEditingDomain(ServicesRegistry)} whenever it is
	 * possible. <br>
	 * This method throw a {@link ServiceException} if the
	 * TransactionalEditingDomain can not be found. <br>
	 * In GMF EditParts or EditPolicies, the ServiceRegistry can be retrieved
	 * with methods from
	 * org.eclipse.papyrus.uml.diagram.common.util.DiagramCoreServiceUtils
	 * 
	 * 
	 * WARNING: This method throws an exception when no Active Editor is found.
	 * This happen during the editor initialization, especially when there is no
	 * other editor opened.
	 * 
	 * @return Get the current {@link TransactionalEditingDomain}
	 * @throws ServiceException
	 * @throws ServiceNotFoundException
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static TransactionalEditingDomain getTransactionalEditingDomainChecked() throws ServiceException {
		try {
			ServicesRegistry registry = getServiceRegistryChecked();
			return registry.getService(TransactionalEditingDomain.class);
		} catch (IllegalStateException e) {
			throw new ServiceException(e);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 * 
	 * @param servicesRegistry
	 * @return
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             </ul>
	 */
	@Deprecated
	public static TransactionalEditingDomain getTransactionalEditingDomain(ServicesRegistry registry) {
		try {
			return registry.getService(TransactionalEditingDomain.class);
		} catch (IllegalStateException e) {
			// Registry can't be found, do nothing.
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 * 
	 * @param servicesRegistry
	 * @return
	 * @throws ServiceException
	 *         If the TransactionalEditingDomain can not be found.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             </ul>
	 */
	@Deprecated
	public static TransactionalEditingDomain getTransactionalEditingDomainChecked(ServicesRegistry registry) throws ServiceException {
		return registry.getService(TransactionalEditingDomain.class);
	}

	/**
	 * Get the {@link ServicesRegistry}of the currently active eclipse editor. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc. <br>
	 * This method return null if the ServicesRegistry can not be found. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. An alternative is to use {@link #getServiceRegistryChecked()} and
	 * to catch the exception. <br>
	 * It is preferable to retrieve the ServiceRegistry from elsewhere whenever
	 * it is possible. <br>
	 * In GMF EditParts or EditPolicies, the ServiceRegistry can be retrieved
	 * with methods from
	 * org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF
	 * 
	 * <br>
	 * WARNING: This method can return null if there is no Active Editor. This
	 * happen during the editor initialization, especially when there is no
	 * other editor opened.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	static public ServicesRegistry getServiceRegistry() {
		// Lookup ServiceRegistry
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		return editor == null ? null : (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
	}

	/**
	 * Get the service registry of the currently active main editor. <br>
	 * WARNING - This method doesn't work during the initialization of the main
	 * editor. See note in class doc.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 * @throws ServiceException
	 *         If an error occurs.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	static public ServicesRegistry getServiceRegistryChecked() throws ServiceException {
		// Lookup ServiceRegistry
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		if(editor == null) {
			throw new ServiceException("Can't get ServiceRegistry");
		}

		return (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
	}

	/**
	 * Get the ISashWindowsContentProvider of the active Eclipse Editor, if
	 * possible. <br>
	 * This method return null if the ServiceRegistry can not be found or if an
	 * error occur. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null. <br>
	 * 
	 * @return the ISashWindowsContentProvider from the main editor or null if
	 *         not found.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	static public ISashWindowsContentProvider getISashWindowsContentProvider() {

		try {
			return getServiceRegistryChecked().getService(ISashWindowsContentProvider.class);
		} catch (ServiceException e) {
			// The contract says that we return null if not found
			return null;
		}
	}

	/**
	 * Get the ISashWindowsContentProvider of the active Eclipse Editor, if
	 * possible. <br>
	 * This method return null if the ServiceRegistry can not be found or if an
	 * error occur. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * This method should not be used during the editor initialization phase. <br>
	 * In any case, a check should be done on the returned value that can be
	 * null.
	 * 
	 * @return the ISashWindowsContentProvider from the main editor or null if
	 *         not found.
	 * @deprecated Check
	 *             modeling/org.eclipse.mdt.papyrus/trunk/doc/DevelopperDocuments
	 *             /cookbook/PapyrusCookBook.odt and use one of the replacement:
	 *             <ul>
	 *             <li>org.eclipse.papyrus.infra.core.utils.ServiceUtils</li>
	 *             <li>
	 *             org.eclipse.papyrus.uml.diagram.common.util.ServiceUtilsForGMF</li>
	 *             <li>
	 *             org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers (to be used with care !)</li>
	 *             </ul>
	 */
	@Deprecated
	public static IPageMngr getIPageMngr() {

		try {
			return getServiceRegistryChecked().getService(IPageMngr.class);
		} catch (ServiceException e) {
			// The contract says that we return null if not found
			return null;
		}
	}

	/**
	 * Get the Eclipse ActiveEditor.
	 * 
	 * @return The active {@link CoreMultiDiagramEditor} or null if not found.
	 * @deprecated Use {@link EditorUtils#getMultiDiagramEditor()}
	 */
	@Deprecated
	protected static IEditorPart getWorkbenchActiveEditor() {
		IMultiDiagramEditor editorPart = getMultiDiagramEditor();
		if(editorPart instanceof CoreMultiDiagramEditor) {
			return editorPart;
		} else {
			return null;
		}
	}

	/**
	 * Gets the {@link IMultiDiagramEditor} interface of the a Eclipse active
	 * editor, if possible, or throw an exception if not possible. <br>
	 * WARNING - This method throw an exception during the initialization of the
	 * main editor. This method throws an exception if there is no active
	 * editor, or if the editor is not instance of IMultiDiagramEditor. <br>
	 * This method is designed to be used by ui actions that interact with the
	 * active editor. <br>
	 * 
	 * 
	 * @return Get the current {@link IMultiDiagramEditor} or null if not found.
	 * @throws BackboneException
	 *         If it is not possible to get an instanceof {@link IMultiDiagramEditor}
	 */
	public static IMultiDiagramEditor getMultiDiagramEditorChecked() throws BackboneException {
		IEditorPart editor;
		try {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		} catch (NullPointerException e) {
			// Can't get the active editor
			throw new BackboneException("Can't get the current Eclipse Active Editor: There is no active editor at this time.");
		}

		if(editor instanceof IMultiDiagramEditor) {
			return (IMultiDiagramEditor)editor;
		} else {
			throw new BackboneException("Can't get an Active Editor instance of IMultiDiagramEditor. (actual type:" + editor.getClass().getName() + ")");
		}
	}

	/**
	 * Obtains the URI of the EMF resource identified by the given editor reference.
	 * 
	 * @param editorRef
	 *        an editor reference
	 * 
	 * @return the best-effort URI of the resource that it edits, or {@code null} if it could not be determined,
	 *         including the case when the editor input could not be obtained from the reference
	 */
	public static URI getResourceURI(IEditorReference editorRef) {
		try {
			return getResourceURI(editorRef.getEditorInput());
		} catch (PartInitException e) {
			Activator.log.error("Could not obtain editor input from editor reference.", e); //$NON-NLS-1$
			return null;
		}
	}

	/**
	 * Obtains the URI of the EMF resource edited by the given {@code editor}.
	 * 
	 * @param editor
	 *        an open editor
	 * 
	 * @return the best-effort URI of the resource that it edits, or {@code null} if it could not be determined,
	 *         such as if the editor input could not be obtained from the editor
	 */
	public static URI getResourceURI(IEditorPart editor) {
		return getResourceURI(editor.getEditorInput());
	}

	/**
	 * Obtains the URI of the EMF resource identified by the given editor input.
	 * 
	 * @param editorInput
	 *        an editor input
	 * 
	 * @return the best-effort URI of the resource that it edits, or {@code null} if it could not be determined
	 */
	public static URI getResourceURI(IEditorInput editorInput) {
		URI result = null;

		if(editorInput instanceof IFileEditorInput) {
			result = URI.createPlatformResourceURI(((IFileEditorInput)editorInput).getFile().getFullPath().toString(), true);
		} else if(editorInput instanceof URIEditorInput) {
			result = ((URIEditorInput)editorInput).getURI();
		} else if(editorInput instanceof IURIEditorInput) {
			result = URI.createURI(((IURIEditorInput)editorInput).getURI().toASCIIString(), true);
		} else if(editorInput != null) {
			// desperation
			Object adapter = editorInput.getAdapter(URI.class);
			if(adapter instanceof URI) {
				result = (URI)adapter;
			}
		}

		return result;
	}
}
