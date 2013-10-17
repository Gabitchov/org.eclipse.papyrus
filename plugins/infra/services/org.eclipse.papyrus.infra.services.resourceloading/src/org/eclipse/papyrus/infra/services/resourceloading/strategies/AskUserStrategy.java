/*****************************************************************************
 * Copyright (c) 2010, 2013 ATOS ORIGIN, CEA LIST, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *  Christian W. Damus (CEA LIST) - support control mode in CDO resources
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading.strategies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategy;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * The strategy which ask user if the resource has to be loaded or not
 * 
 * @author tfaure
 * 
 */
public class AskUserStrategy implements ILoadingStrategy {

	/**
	 * the uris linked to the uri of an editor already guessed to the user
	 */
	private Map<URI, Set<URI>> alreadyGuessed = new HashMap<URI, Set<URI>>();

	/**
	 * the uris linked to the uri of an editor already authorized
	 */
	Map<URI, Set<URI>> authorized = new HashMap<URI, Set<URI>>();

	/**
	 * The extensions needed to load for each resource
	 */
	Map<URI, Map<URI, Set<String>>> mappingURIExtensions = new HashMap<URI, Map<URI, Set<String>>>();

	/**
	 * Listeners triggered when the editors are closed
	 */
	Map<URI, EditorCloseListener> listeners = new HashMap<URI, AskUserStrategy.EditorCloseListener>();

	/**
	 * All the notifications created for each editor
	 */
	Map<URI, List<INotification>> notifications = new HashMap<URI, List<INotification>>();

	/**
	 * Constant URI for Yes For All Option
	 */
	public static final URI YesForAllURI = URI.createURI(Messages.AskUserStrategy_YES_FOR_ALL_URI);

	/**
	 * Constant URI for No For All Option
	 */
	private static final URI NoForAllURI = URI.createURI(Messages.AskUserStrategy_NO_FOR_ALL_URI);

	/**
	 * @see org.eclipse.papyrus.infra.services.resourceloading.ILoadingStrategy#loadResource(org.eclipse.papyrus.infra.core.resource.ModelSet,
	 *      org.eclipse.emf.common.util.URI)
	 * 
	 * @param modelSet
	 * @param uri
	 * @return
	 */
	public boolean loadResource(ModelSet modelSet, URI uri) {
		// pathmap resource are always loaded
		boolean result = !modelSet.isUserModelResource(uri);
		URI initialURI = modelSet.getURIWithoutExtension();
		// if no listener is registered, a listener is added on the editor to remove the notifications 
		// when the editor is closed the listener removes too the choices made by the user.
		addClosingEditorListener(initialURI);

		// all the verification are made with the uri without the file extension
		// each load is performed for a set of resources
		URI trimFileExtensionAndFragment = uri.trimFragment().trimFileExtension();
		if(!result) {
			result = initialURI.equals(trimFileExtensionAndFragment);
		}
		if(!result) {
			manageExtensions(initialURI, uri);
			Set<URI> uris = authorized.get(initialURI);
			if(uris != null && (uris.contains(YesForAllURI) || uris.contains(trimFileExtensionAndFragment))) {
				result = true;
			}
			if(uris != null && (uris.contains(NoForAllURI))) {
				// in this case always false !
				return false;
			}
			if(!result) {
				manageGuess(modelSet, initialURI, trimFileExtensionAndFragment);
			}
		}
		return result;
	}

	/**
	 * Create the ask notification to the user
	 * 
	 * @param modelSet
	 * @param initialURI
	 * @param trimFragment
	 */
	protected void manageGuess(ModelSet modelSet, URI initialURI, URI trimFragment) {
		if(!alreadyGuessed(initialURI, trimFragment) && !alreadyGuessed(initialURI, YesForAllURI) && !alreadyGuessed(initialURI, NoForAllURI)) {
			String message = new StringBuffer(Messages.AskUserStrategy_MESSAGE_PART_1).append(initialURI.lastSegment()).append(Messages.AskUserStrategy_MESSAGE_PART_2).append(trimFragment.toString()).append(Messages.AskUserStrategy_MESSAGE_PART3).toString();
			addGuessed(initialURI, trimFragment);
			NotificationBuilder builder = getNotification(message, trimFragment, modelSet, initialURI);
			INotification notification = builder.run();
			addNotification(initialURI, new EncapsulatedNotification(notification, trimFragment));
			// notification
		}
	}

	/**
	 * Add a listener closing the uri parameter
	 * 
	 * @param initialURI
	 */
	private void addClosingEditorListener(URI initialURI) {
		if(!listeners.containsKey(initialURI)) {
			EditorCloseListener value = new EditorCloseListener();
			if(addPageListener(value)) {
				listeners.put(initialURI, value);
			}
		}
	}

	/**
	 * Remember that an uri has already be asked
	 * 
	 * @param initialURI
	 *        , the uri opened by the editor
	 * @param guessed
	 */
	private void addGuessed(URI initialURI, URI guessed) {
		Set<URI> set = alreadyGuessed.get(initialURI);
		if(set == null) {
			set = new HashSet<URI>();
			alreadyGuessed.put(initialURI, set);
		}
		set.add(guessed);
	}

	/**
	 * Check if the uri is already asked
	 * 
	 * @param initialURI
	 *        , the uri opened by the editor
	 * @param toLoad
	 *        , the uri to load
	 * @return
	 */
	private boolean alreadyGuessed(URI initialURI, URI toLoad) {
		Set<URI> guessed = alreadyGuessed.get(initialURI);
		if(guessed != null) {
			return guessed.contains(toLoad);
		}
		return false;
	}

	/**
	 * The extensions are saved to load all the specified resource if the user
	 * wants to load a set of resources
	 * 
	 * @param uri
	 *        , the file to load
	 * @param trimFragment
	 */
	private void manageExtensions(URI initialURI, URI toLoad) {
		Map<URI, Set<String>> map = mappingURIExtensions.get(initialURI);
		if(map == null) {
			map = new HashMap<URI, Set<String>>();
			mappingURIExtensions.put(initialURI, map);
		}
		Set<String> extensions = map.get(toLoad.trimFileExtension());
		if(extensions == null) {
			extensions = new HashSet<String>();
			map.put(toLoad.trimFileExtension(), extensions);
		}
		extensions.add(toLoad.fileExtension());
	}

	/**
	 * Get the current editor
	 * 
	 * @return
	 */
	protected CoreMultiDiagramEditor getCurrentEditor() {
		IEditorPart editor = getEditor();
		if(editor instanceof CoreMultiDiagramEditor) {
			return (CoreMultiDiagramEditor)editor;
		}
		return null;
	}

	/**
	 * Create the notification with Yes/No/Yes For All/No For All option
	 * 
	 * @param message
	 *        , the message to display
	 * @param uri
	 *        , the uri to load
	 * @param modelSet
	 *        , the model set of the editor
	 * @param initialURI
	 *        , the uri opened by the editor
	 * @return a {@link NotificationBuilder} to build
	 */
	protected NotificationBuilder getNotification(String message, final URI uri, final ModelSet modelSet, final URI initialURI) {
		NotificationRunnable yes = getYesRunnable(uri, modelSet, initialURI);
		NotificationRunnable no = getNoRunnable(uri, modelSet, initialURI);
		NotificationRunnable yesForAll = getYesForAllRunnable(uri, modelSet, initialURI);
		NotificationRunnable noForAll = getNoForAllRunnable(uri, modelSet, initialURI);
		return new NotificationBuilder().setType(Type.QUESTION).setAsynchronous(true).setTemporary(false).setMessage(message).setHTML(true).setAsynchronous(true).setTitle(Messages.AskUserStrategy_LOAD_RESOURCE + uri.toString()).addAction(yes).addAction(no).addAction(yesForAll).addAction(noForAll);
	}

	/**
	 * NO for all registers the NoForAll URI and do nothing
	 * 
	 * @param uri
	 * @param modelSet
	 * @param initialURI
	 * @return
	 */
	protected LoadAndRefreshRunnable getNoForAllRunnable(final URI uri, final ModelSet modelSet, final URI initialURI) {
		return new LoadAndRefreshRunnable(initialURI, uri, modelSet, Messages.AskUserStrategy_NO_FOR_ALL) {

			@Override
			public void run(IContext context) {
				addGuessed(getInitialURI(), NoForAllURI);
				super.run(context);
			}

			@Override
			protected void manageRefresh(IEditorReference ref, IEditorPart part) {
				addAuthorized(getInitialURI(), NoForAllURI);

				List<INotification> list = notifications.get(getInitialURI());
				if(list != null) {
					for(INotification n : notifications.get(getInitialURI())) {
						if(n != getNotification()) {
							n.delete();
						}
					}
				}
				// DO NOTHING
			}

			@Override
			public int getActionValue() {
				return SWT.NO;
			}
		};
	}

	/**
	 * Yes for All registers Yes For All URI and refresh the tabs to take in account the loaded elements
	 * 
	 * @param uri
	 * @param modelSet
	 * @param initialURI
	 * @return
	 */
	protected LoadAndRefreshRunnable getYesForAllRunnable(final URI uri, final ModelSet modelSet, final URI initialURI) {
		return new LoadAndRefreshRunnable(initialURI, uri, modelSet, Messages.AskUserStrategy_0) {

			@Override
			public void run(IContext context) {
				addGuessed(getInitialURI(), YesForAllURI);
				super.run(context);
			}

			@Override
			RefreshRunnable getRunnable() {
				return new RefreshRunnable(modelSet, uri, initialURI, true, true) {

					@Override
					public void run(CoreMultiDiagramEditor editor) {
						List<INotification> list = notifications.get(getInitialURI());
						if(list != null) {
							for(INotification n : notifications.get(getInitialURI())) {
								if(n instanceof EncapsulatedNotification) {
									EncapsulatedNotification encapsulated = (EncapsulatedNotification)n;
									new RefreshRunnable(modelSet, encapsulated.getURIToLoad(), getInitialURI(), false, false).run(editor);
								}
							}
						}
						new RefreshRunnable(modelSet, null, getInitialURI(), true, true).run(editor);
					}
				};

			}

			@Override
			protected void manageRefresh(IEditorReference ref, IEditorPart part) {
				addAuthorized(getInitialURI(), YesForAllURI);
				INotification currentNotification = getNotification();
				List<INotification> list = notifications.get(getInitialURI());
				if(list != null) {
					for(INotification n : notifications.get(getInitialURI())) {
						if(n != currentNotification) {
							n.delete();
						}
					}
				}
				super.manageRefresh(ref, part);
			}

			@Override
			public int getActionValue() {
				return SWT.YES;
			}
		};
	}

	/**
	 * No runnable does not accept the URI asked
	 * 
	 * @param uri
	 * @param modelSet
	 * @param initialURI
	 * @return
	 */
	protected LoadAndRefreshRunnable getNoRunnable(final URI uri, final ModelSet modelSet, final URI initialURI) {
		return new LoadAndRefreshRunnable(initialURI, uri, modelSet, Messages.AskUserStrategy_NO) {

			@Override
			protected void manageRefresh(IEditorReference ref, IEditorPart part) {
				// DO NOTHING
				// inheritance for close listener
			}

			@Override
			public int getActionValue() {
				return SWT.NO;
			}
		};
	}

	/**
	 * Yes registers the URI and refresh the tab to take in account the loaded elements
	 * 
	 * @param uri
	 * @param modelSet
	 * @param initialURI
	 * @return
	 */
	protected LoadAndRefreshRunnable getYesRunnable(final URI uri, final ModelSet modelSet, final URI initialURI) {
		return new LoadAndRefreshRunnable(initialURI, uri, modelSet, Messages.AskUserStrategy_YES);
	}

	/**
	 * Register the notification created to the URI open by the editor
	 * 
	 * @param initialURI
	 * @param notification
	 */
	protected void addNotification(URI initialURI, INotification notification) {
		List<INotification> notifs = notifications.get(initialURI);
		if(notifs == null) {
			notifs = new LinkedList<INotification>();
			notifications.put(initialURI, notifs);
		}
		notifs.add(notification);
	}

	protected IEditorPart getEditor() {
		IWorkbenchWindow activeWorkbenchWindow = getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null) {
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			if(activePage != null) {
				return activePage.getActiveEditor();
			}
		}
		return null;
	}

	protected IWorkbenchWindow getActiveWorkbenchWindow() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench != null) {
			return workbench.getActiveWorkbenchWindow();
		}
		return null;
	}

	protected IWorkbenchPage getActivePage() {
		IWorkbenchWindow activeWorkbenchWindow = getActiveWorkbenchWindow();
		if(activeWorkbenchWindow != null) {
			return activeWorkbenchWindow.getActivePage();
		}
		return null;
	}

	/**
	 * A basic runnable managing the load of a resource and a refresh of the tabs
	 * If the editor is not opened or activated some listeners will be triggered to launch the refresh
	 * 
	 * @author tfaure
	 * 
	 */
	private class LoadAndRefreshRunnable implements NotificationRunnable {

		protected URI initialURI;

		protected URI uri;

		protected ModelSet modelSet;

		protected final String label;

		protected IContext theContext;

		public LoadAndRefreshRunnable(URI initialURI, URI uri, ModelSet modelSet, String label) {
			this(initialURI, uri, modelSet, label, false);
		}

		public LoadAndRefreshRunnable(URI initialURI, URI uri, ModelSet modelSet, String label, boolean refreshAll) {
			this.initialURI = initialURI;
			this.uri = uri;
			this.modelSet = modelSet;
			this.label = label;
		}

		public URI getInitialURI() {
			return initialURI;
		}

		public void run(IContext context) {
			context.put(IContext.ACTION_ID, getActionValue());
			theContext = context;
			IWorkbenchPage activePage = getActivePage();
			if(activePage != null) {
				// search the editor which opened the given URI
				for(IEditorReference ref : activePage.getEditorReferences()) {
					try {
						URI uri = getURI(ref.getEditorInput());
						if((uri != null) && uri.trimFileExtension().equals(initialURI)) {
							IEditorPart part = (IEditorPart)ref.getPart(false);
							manageRefresh(ref, part);
							// add the uris to load in authorized list
						}
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			} else {
				PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {

					public void windowOpened(IWorkbenchWindow window) {
					}

					public void windowDeactivated(IWorkbenchWindow window) {
					}

					public void windowClosed(IWorkbenchWindow window) {
					}

					public void windowActivated(IWorkbenchWindow window) {
						if(window.getActivePage() != null) {
							run(new IContext.Context());
							PlatformUI.getWorkbench().removeWindowListener(this);
						}
					}
				});
			}
		}

		public int getActionValue() {
			return SWT.YES;
		}

		public INotification getNotification() {
			return new EncapsulatedNotification((INotification)theContext.get(IContext.NOTIFICATION_OBJECT), uri);
		}

		protected void manageRefresh(IEditorReference ref, IEditorPart part) {
			addAuthorized(initialURI, uri);
			if(part != null) {
				getRunnable().run((CoreMultiDiagramEditor)part);
			} else {
				addPageListener(new EditorActivateListener(ref, modelSet, uri, initialURI, getRunnable()));
			}
		}

		RefreshRunnable getRunnable() {
			return new RefreshRunnable(modelSet, uri, initialURI, false, true);

		}

		public String getLabel() {
			return label;
		}

	}

	/**
	 * Add a page listener
	 * 
	 * @param listener
	 * @return
	 */
	protected boolean addPageListener(IPartListener listener) {
		IWorkbenchPage page = getActivePage();
		if(page != null) {
			page.addPartListener(listener);
			return true;
		}
		return false;
	}

	/**
	 * Register a listener of the perspective to know when the editor is finally closed
	 * 
	 * @param listener
	 * @return
	 */
	protected boolean addPerspectiveListener(IPerspectiveListener listener) {
		if(PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().addPerspectiveListener(listener);
			return true;
		}
		return false;
	}

	/**
	 * Unregister a perspective listener
	 * 
	 * @param listener
	 * @return
	 */
	protected void removePerspectiveListener(IPerspectiveListener listener) {
		if(PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().removePerspectiveListener(listener);
		}
	}

	protected void removePageListener(IPartListener listener) {
		IWorkbenchPage page = getActivePage();
		if(page != null) {
			page.removePartListener(listener);
		}
	}

	protected void addAuthorized(URI initial, URI toAutorized) {
		Set<URI> uris = authorized.get(initial);
		if(uris == null) {
			uris = new HashSet<URI>();
			authorized.put(initial, uris);
		}
		uris.add(toAutorized);
	}

	protected static URI getURI(final IEditorInput input) {
		URI result;
		
		IFile file = (IFile)input.getAdapter(IFile.class);
		if((file != null) && (file.getFullPath() != null)) {
			result = URI.createPlatformResourceURI(file.getFullPath().removeFileExtension().toString(), true);
		} else {
			result = (URI) input.getAdapter(URI.class);
		}

		return result;
	}
	
	/**
	 * Notification containing the {@link URI} loaded
	 * 
	 */
	public class EncapsulatedNotification implements INotification {

		private final INotification notification;

		private final URI uri;

		public EncapsulatedNotification(INotification notification, URI uri) {
			this.notification = notification;
			this.uri = uri;
		}

		public void delete() {
			this.notification.delete();
		}

		public boolean isDeleted() {
			return this.notification.isDeleted();
		}

		public URI getURIToLoad() {
			return uri;
		}
	}

	/**
	 * An empty {@link IPartListener} implementation
	 * 
	 * @author tfaure
	 * 
	 */
	private class EditorAdapter implements IPartListener {

		public void partActivated(IWorkbenchPart part) {
		}

		public void partBroughtToTop(IWorkbenchPart part) {
		}

		public void partClosed(IWorkbenchPart part) {
		}

		public void partDeactivated(IWorkbenchPart part) {
		}

		public void partOpened(IWorkbenchPart part) {
		}

	}

	/**
	 * Listener which is notifid when an editor is activated
	 * 
	 * @author tfaure
	 * 
	 */
	private class EditorActivateListener extends EditorAdapter {

		private final IEditorReference reference;

		private final RefreshRunnable refreshRunnable;

		public EditorActivateListener(IEditorReference reference, ModelSet set, URI uri, URI initialURI, RefreshRunnable refreshRunnable) {
			this.reference = reference;
			this.refreshRunnable = refreshRunnable;
		}

		@Override
		public void partActivated(IWorkbenchPart part) {
			if(reference.getPart(false) == part && part instanceof CoreMultiDiagramEditor) {
				refreshRunnable.run((CoreMultiDiagramEditor)part);
				removePageListener(this);
			}
		}

	}

	/**
	 * Listener which is notifid when an editor is closed
	 * 
	 * @author tfaure
	 * 
	 */
	private class EditorCloseListener extends EditorAdapter {

		@Override
		public void partClosed(IWorkbenchPart part) {
			super.partClosed(part);
			if(part instanceof CoreMultiDiagramEditor) {
				CoreMultiDiagramEditor editor = (CoreMultiDiagramEditor)part;
				
				URI uri = getURI(editor.getEditorInput());
				if (uri != null) {
					uri = uri.trimFileExtension();
					addPerspectiveListener(new EditorClosePerspectiveListener(uri));
					removePageListener(this);
					listeners.remove(uri);
				}
			}
		}

	}

	/**
	 * A perspective listener which choices of an user
	 * 
	 * @author tfaure
	 * 
	 */
	protected class EditorClosePerspectiveListener implements IPerspectiveListener {

		private final URI uri;

		public EditorClosePerspectiveListener(URI uri) {
			this.uri = uri;
		}

		public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		}

		public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
			authorized.remove(uri);
			mappingURIExtensions.remove(uri);
			alreadyGuessed.remove(uri);
			List<INotification> list = notifications.get(uri);
			if(list != null) {
				for(INotification n : list) {
					n.delete();
				}
			}
			notifications.remove(uri);
			removePerspectiveListener(this);
		}

	}

	/**
	 * A runnable refreshing resource and/or pages
	 * 
	 * @author tfaure
	 * 
	 */
	public class RefreshRunnable {

		protected IPageManager pageMngr;

		protected URI uri;

		protected final ModelSet modelSet;

		protected final URI initialURI;

		private final boolean refreshAll;

		private final boolean refreshTab;

		public RefreshRunnable(ModelSet modelSet, URI uriToLoad, URI initialURI, boolean refreshAll, boolean refreshTab) {
			this.modelSet = modelSet;
			uri = uriToLoad;
			this.initialURI = initialURI;
			this.refreshAll = refreshAll;
			this.refreshTab = refreshTab;
		}

		public void run(CoreMultiDiagramEditor editor) {
			final Set<URI> alreadyLoaded = new HashSet<URI>();
			try {
				pageMngr = editor.getServicesRegistry().getService(IPageManager.class);
				List<Object> allPages = pageMngr.allPages();
				// the uri is added after getting all the pages. If it is done
				// before, the eobjects are resolved
				NotificationBuilder error = NotificationBuilder.createAsyncPopup(Messages.AskUserStrategy_ERROR, String.format(Messages.AskUserStrategy_UNABLE_TO_LOAD, uri != null ? uri.toString() : Messages.AskUserStrategy_12)).setType(Type.ERROR).setDelay(2000);
				// load associated resources
				// the extensions needed for each element are saved so it is not needed to check filesystem
				Set<String> extensions = getExtensions();
				if(extensions != null) {
					for(String s : extensions) {
						try {
							if(s != null) {
								URI uriToLoad = URI.createURI(uri.toString());
								if(s != null) {
									uriToLoad = uriToLoad.appendFileExtension(s);
								}
								// the resource is loaded only if it is needed
								if(!alreadyLoaded.contains(uriToLoad)) {
									Resource r = modelSet.getResource(uriToLoad, true);
									alreadyLoaded.add(uriToLoad);
									if(r == null) {
										error.run();
									}
								}
							}
						} catch (Exception re) {
							error.run();
							re.printStackTrace();
						}
					}
				}
				// refresh tabs
				for(Object o : allPages) {
					if(o instanceof EObject) {
						EObject eobject = (EObject)o;
						URI eobjectURI = EcoreUtil.getURI(eobject);
						if(refreshAll || (refreshTab && eobjectURI.trimFileExtension().trimFragment().equals(uri))) {
							// TODO improve this when an update is created
							pageMngr.selectPage(eobject);
						}
					}
				}

			} catch (ServiceException e1) {
				e1.printStackTrace();
			}

		}

		public Set<String> getExtensions() {
			Map<URI, Set<String>> map = mappingURIExtensions.get(initialURI);
			if(map != null) {
				return map.get(uri);
			}
			return null;
		}

		public IWorkbenchPage getActivePage() {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if(workbench != null) {
				IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
				if(activeWorkbenchWindow != null) {
					if(activeWorkbenchWindow.getActivePage() != null) {
						return activeWorkbenchWindow.getActivePage();
					}
				}
			}
			return null;
		}

	}
}
