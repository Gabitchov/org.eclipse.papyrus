/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.infra.core.sasheditor.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.INestableKeyBindingService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.KeyBindingService;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.internal.PopupMenuExtender;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.contexts.NestableContextService;
import org.eclipse.ui.internal.expressions.ActivePartExpression;
import org.eclipse.ui.internal.handlers.LegacyHandlerService;
import org.eclipse.ui.internal.services.INestable;
import org.eclipse.ui.internal.services.IServiceLocatorCreator;
import org.eclipse.ui.internal.services.IWorkbenchLocationService;
import org.eclipse.ui.internal.services.ServiceLocator;
import org.eclipse.ui.internal.services.WorkbenchLocationService;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.services.IDisposable;
import org.eclipse.ui.services.IServiceScopes;


/**
 * Site for a nested editor within a multi-page editor. Selection is handled by
 * forwarding the event to the multi-page editor's selection listeners; most
 * other methods are forwarded to the multi-page editor's site.
 * <p>
 * The base implementation of <code>MultiPageEditor.createSite</code> creates an instance of this class. This class may be instantiated or subclassed.
 * </p>
 * 
 * This class only compile with Eclipse version starting from [4.2
 * On previous versions, use MultiPageEditorSite
 * 
 * @see org.eclipse.ui.part.MultiPageEditorSite.class
 */
public class MultiPageEditorSite4x implements IMultiPageEditorSite, INestable {


	org.eclipse.ui.part.MultiPageEditorSite e;

	/**
	 * The actionBarContributor associated to the site. Can be null. In this case,
	 * use the multiEditor ActionBarContributor.
	 */
	protected EditorActionBarContributor actionBarContributor;

	/**
	 * The nested editor.
	 */
	private IEditorPart editor;

	/**
	 * The list of popup menu extenders; <code>null</code> if none registered.
	 */
	private ArrayList menuExtenders;

	/**
	 * The main editor EditorSite.
	 */
	private IEditorSite mainEditorSite;

	/**
	 * The post selection changed listener.
	 */
	private ISelectionChangedListener postSelectionChangedListener = null;

	/**
	 * The selection change listener, initialized lazily; <code>null</code> if
	 * not yet created.
	 */
	private ISelectionChangedListener selectionChangedListener = null;

	/**
	 * The selection provider; <code>null</code> if none.
	 * 
	 * @see MultiPageEditorSite4x#setSelectionProvider(ISelectionProvider)
	 */
	private ISelectionProvider selectionProvider = null;

	/**
	 * The cached copy of the key binding service specific to this multi-page
	 * editor site. This value is <code>null</code> if it is not yet
	 * initialized.
	 */
	private IKeyBindingService service = null;

	/**
	 * The local service locator for this multi-page editor site. This value is
	 * never <code>null</code>.
	 */
	private final ServiceLocator serviceLocator;

	/** Since 4.x */
	private NestableContextService contextService;

	/** Since 4.x */
	private IEclipseContext context;

	private boolean active = false;

	/**
	 * Creates a site for the given editor nested within the given multi-page
	 * editor.
	 * 
	 * @param mainEditorSite
	 *        the multi-page editor
	 * @param editor
	 *        the nested editor
	 * @param editDomain
	 *        The shared editDomain.
	 */
	@SuppressWarnings("restriction")
	public MultiPageEditorSite4x(IEditorSite mainEditorSite, IEditorPart editor, EditorActionBarContributor actionBarContributor) {
		Assert.isNotNull(mainEditorSite);
		Assert.isNotNull(editor);
		this.mainEditorSite = mainEditorSite;
		this.editor = editor;
		this.actionBarContributor = actionBarContributor;

		//		final IServiceLocator parentServiceLocator = mainEditorSite;
		//		IServiceLocatorCreator slc = (IServiceLocatorCreator)parentServiceLocator.getService(IServiceLocatorCreator.class);
		//		this.serviceLocator = (ServiceLocator)slc.createServiceLocator(mainEditorSite, null, new IDisposable() {
		//
		//			public void dispose() {
		//				final Control control = ((PartSite)getMainEditorSite()).getPane().getControl();
		//				if(control != null && !control.isDisposed()) {
		//					((PartSite)getMainEditorSite()).getPane().doHide();
		//				}
		//			}
		//		});

		// Updated for e4
		// Copied from CT org.eclipse.ui.part.MultiPageEditorSite()
		PartSite site = (PartSite)mainEditorSite;
		IServiceLocatorCreator slc = (IServiceLocatorCreator)mainEditorSite.getService(IServiceLocatorCreator.class);
		this.serviceLocator = (ServiceLocator)slc.createServiceLocator(getMainEditorSite(), null, new IDisposable() {

			public void dispose() {
				// Check close method in original MPE
				//				getMultiPageEditor().close();
				// copied from 4.2 org.eclipse.ui.part.MultiPageEditorPart.close()
				// 3.x implementation closes the editor when the ISL is disposed
				PartSite partSite = (PartSite)getMainEditorSite();
				MPart model = partSite.getModel();
				Widget widget = (Widget)model.getWidget();
				if(widget != null && !widget.isDisposed()) {
					getMainEditorSite().getPage().closeEditor(getMultiPageEditorPart(), true);
				}

			}
		});

		context = site.getModel().getContext().createChild("MultiPageEditorSite"); //$NON-NLS-1$
		serviceLocator.setContext(context);

		initializeDefaultServices();
	}

	/**
	 * Returns the multi-page editor.
	 * 
	 * @return the multi-page editor
	 */
	public IEditorPart getMultiPageEditorPart() {
		return (IEditorPart)mainEditorSite.getPart();
	}


	/**
	 * Return the site of the main editor.
	 * 
	 * @return
	 */
	private IWorkbenchPartSite getMainEditorSite() {
		return mainEditorSite;
	}

	/**
	 * Return the EditorSite of the main editor.
	 * This is the same object as getMainEditorSite.
	 * TODO: Remove this one.
	 * 
	 * @return
	 */
	private IEditorSite getMainEditorEditorSite() {
		return mainEditorSite;
	}

	/**
	 * Initialize the slave services for this site.
	 */
	private void initializeDefaultServices() {
		serviceLocator.registerService(IWorkbenchLocationService.class, new WorkbenchLocationService(IServiceScopes.MPESITE_SCOPE, getWorkbenchWindow().getWorkbench(), getWorkbenchWindow(), getMainEditorSite(), this, null, 3));

		//		serviceLocator.registerService(IMultiPageEditorSiteHolder.class,
		//				new IMultiPageEditorSiteHolder() {
		//					public MultiPageEditorSite getSite() {
		//						return MultiPageEditorSite.this;
		//					}
		//				});


		context.set(IContextService.class.getName(), new ContextFunction() {

			@Override
			public Object compute(IEclipseContext ctxt) {
				if(contextService == null) {
					contextService = new NestableContextService(ctxt.getParent().get(IContextService.class), new ActivePartExpression(mainEditorSite.getPart()));
				}
				return contextService;
			}
		});

		// create a local handler service so that when this page
		// activates/deactivates, its handlers will also be taken into/out of
		// consideration during handler lookups
		IHandlerService handlerService = new LegacyHandlerService(context);
		context.set(IHandlerService.class, handlerService);

	}

	/**
	 * Notifies the multi page editor service that the component within which it
	 * exists has become active.
	 * 
	 * @since 3.2
	 */
	public final void activate() {
		active = true;
		context.activate();
		serviceLocator.activate();

		if(contextService != null) {
			contextService.activate();
		}

	}

	/**
	 * Notifies the multi page editor service that the component within which it
	 * exists has been deactived.
	 * 
	 * @since 3.2
	 */
	public final void deactivate() {
		active = false;
		if(contextService != null) {
			contextService.deactivate();
		}

		serviceLocator.deactivate();
		context.deactivate();
	}

	/**
	 * Dispose the contributions.
	 */
	public void dispose() {
		if(menuExtenders != null) {
			for(int i = 0; i < menuExtenders.size(); i++) {
				((PopupMenuExtender)menuExtenders.get(i)).dispose();
			}
			menuExtenders = null;
		}

		// Remove myself from the list of nested key binding services.
		if(service != null) {
			// TODO : check original implem - use main editor site !
			IKeyBindingService parentService = getMainEditorSite().getKeyBindingService();
			if(parentService instanceof INestableKeyBindingService) {
				INestableKeyBindingService nestableParent = (INestableKeyBindingService)parentService;
				nestableParent.removeKeyBindingService(this);
			}
			// TODO : dispose service ?
			if(service instanceof KeyBindingService) {
				((KeyBindingService)service).dispose();
			}
			service = null;
		}

		if(contextService != null) {
			contextService.dispose();
		}

		if(serviceLocator != null) {
			serviceLocator.dispose();
		}
		context.dispose();

		// dispose properties to help GC
		setSelectionProvider(null);
		mainEditorSite = null;
		editor = null;
		actionBarContributor = null;

	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IEditorSite</code> method returns the EditorActionBarContributor associated
	 * to the site if one is defined,
	 * or the EditorActionBarContributor of the multiEditor.
	 * 
	 * @return <code>null</code>
	 */
	public IEditorActionBarContributor getActionBarContributor() {

		// If we use an action bar contributor, look for a registered ActionBarContributor.
		// TODO : enable next asap
		//		ActionBarContributor contributor =  multiPageEditor.getEditorSite().getActionBarContributor();
		//		if(contributor instanceof ComposedActionBarContributor)
		//		{
		//			ComposedActionBarContributor composedContributor = (ComposedActionBarContributor)contributor;
		//			return composedContributor.getContributorFor(editor);
		//		}

		// Return the main ActionBarContributor, usually ComposedActionBarContributor

		if(actionBarContributor != null) {
			return actionBarContributor;
		} else {
			return getMainEditorEditorSite().getActionBarContributor();
			//		return null;
		}
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IEditorSite</code> method forwards to the multi-page editor to
	 * return the action bars.
	 * 
	 * @return The action bars from the parent multi-page editor.
	 */
	public IActionBars getActionBars() {
		return getMainEditorEditorSite().getActionBars();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * to return the decorator manager.
	 * 
	 * @return The decorator from the workbench window.
	 * @deprecated use IWorkbench.getDecoratorManager()
	 */
	@Deprecated
	public ILabelDecorator getDecoratorManager() {
		return getWorkbenchWindow().getWorkbench().getDecoratorManager().getLabelDecorator();
	}

	/**
	 * Returns the nested editor.
	 * 
	 * @return the nested editor
	 */
	public IEditorPart getEditor() {
		return editor;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method returns an empty string since the
	 * nested editor is not created from the registry.
	 * 
	 * @return An empty string.
	 */
	public String getId() {
		return ""; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc) Method declared on IEditorSite.
	 */
	public IKeyBindingService getKeyBindingService() {
		if(service == null) {
			service = getMainEditorEditorSite().getKeyBindingService();
			if(service instanceof INestableKeyBindingService) {
				INestableKeyBindingService nestableService = (INestableKeyBindingService)service;
				service = nestableService.getKeyBindingService(this);

			} else {
				/*
				 * This is an internal reference, and should not be copied by
				 * client code. If you are thinking of copying this, DON'T DO
				 * IT.
				 */
				WorkbenchPlugin.log("MultiPageEditorSite.getKeyBindingService()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		return service;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * to return the workbench page.
	 * 
	 * @return The workbench page in which this editor site resides.
	 */
	public IWorkbenchPage getPage() {
		return getMainEditorSite().getPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPart()
	 */
	public IWorkbenchPart getPart() {
		return editor;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method returns an empty string since the
	 * nested editor is not created from the registry.
	 * 
	 * @return An empty string.
	 */
	public String getPluginId() {
		return ""; //$NON-NLS-1$
	}

	/**
	 * Returns the post selection change listener which listens to the nested
	 * editor's selection changes.
	 * 
	 * @return the post selection change listener.
	 */
	private ISelectionChangedListener getPostSelectionChangedListener() {
		if(postSelectionChangedListener == null) {
			postSelectionChangedListener = new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					MultiPageEditorSite4x.this.handlePostSelectionChanged(event);
				}
			};
		}
		return postSelectionChangedListener;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method returns an empty string since the
	 * nested editor is not created from the registry.
	 * 
	 * @return An empty string.
	 */
	public String getRegisteredName() {
		return ""; //$NON-NLS-1$
	}

	/**
	 * Returns the selection changed listener which listens to the nested
	 * editor's selection changes, and calls <code>handleSelectionChanged</code> .
	 * 
	 * @return the selection changed listener
	 */
	private ISelectionChangedListener getSelectionChangedListener() {
		if(selectionChangedListener == null) {
			selectionChangedListener = new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					MultiPageEditorSite4x.this.handleSelectionChanged(event);
				}
			};
		}
		return selectionChangedListener;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method returns the selection provider set
	 * by <code>setSelectionProvider</code>.
	 * 
	 * @return The current selection provider.
	 */
	public ISelectionProvider getSelectionProvider() {
		return selectionProvider;
	}

	public final Object getService(final Class key) {
		Object service = serviceLocator.getService(key);
		if(active && service instanceof INestable) {
			// services need to know that it is currently in an active state
			((INestable)service).activate();
		}
		return service;
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * to return the shell.
	 * 
	 * @return The shell in which this editor site resides.
	 */
	public Shell getShell() {
		return getMainEditorSite().getShell();
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * to return the workbench window.
	 * 
	 * @return The workbench window in which this editor site resides.
	 */
	public IWorkbenchWindow getWorkbenchWindow() {
		return getMainEditorSite().getWorkbenchWindow();
	}

	/**
	 * Handles a post selection changed even from the nexted editor.
	 * <p>
	 * Subclasses may extend or reimplement this method
	 * 
	 * @param event
	 *        the event
	 * 
	 * @since 3.2
	 */
	protected void handlePostSelectionChanged(SelectionChangedEvent event) {
		ISelectionProvider parentProvider = getMainEditorSite().getSelectionProvider();

		// TODO : use org.eclipse.ui.part.MultiPageSelectionProvider ?
		if(parentProvider instanceof MultiPageSelectionProvider) {
			SelectionChangedEvent newEvent = new SelectionChangedEvent(parentProvider, event.getSelection());
			MultiPageSelectionProvider prov = (MultiPageSelectionProvider)parentProvider;
			prov.firePostSelectionChanged(newEvent);
		}
	}

	/**
	 * Handles a selection changed event from the nested editor. The default
	 * implementation gets the selection provider from the multi-page editor's
	 * site, and calls <code>fireSelectionChanged</code> on it (only if it is an
	 * instance of <code>MultiPageSelectionProvider</code>), passing a new event
	 * object.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @param event
	 *        the event
	 */
	protected void handleSelectionChanged(SelectionChangedEvent event) {
		ISelectionProvider parentProvider = getMainEditorSite().getSelectionProvider();
		if(parentProvider instanceof MultiPageSelectionProvider) {
			SelectionChangedEvent newEvent = new SelectionChangedEvent(parentProvider, event.getSelection());
			MultiPageSelectionProvider prov = (MultiPageSelectionProvider)parentProvider;
			prov.fireSelectionChanged(newEvent);
		}
	}

	public final boolean hasService(final Class key) {
		return serviceLocator.hasService(key);
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * for registration.
	 * 
	 * @param menuManager
	 *        The menu manager
	 * @param selProvider
	 *        The selection provider.
	 */
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selProvider) {
		getMainEditorSite().registerContextMenu(menuManager, selProvider);
	}

	public final void registerContextMenu(final MenuManager menuManager, final ISelectionProvider selectionProvider, final boolean includeEditorInput) {
		registerContextMenu(getId(), menuManager, selectionProvider, includeEditorInput);
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method forwards to the multi-page editor
	 * for registration.
	 * 
	 * @param menuID
	 *        The identifier for the menu.
	 * @param menuMgr
	 *        The menu manager
	 * @param selProvider
	 *        The selection provider.
	 */
	public void registerContextMenu(String menuID, MenuManager menuMgr, ISelectionProvider selProvider) {
		if(menuExtenders == null) {
			menuExtenders = new ArrayList(1);
		}
		registerContextMenu(menuID, menuMgr, selProvider, true, editor, context, menuExtenders);
	}

	public final void registerContextMenu(final String menuId, final MenuManager menuManager, final ISelectionProvider selectionProvider, final boolean includeEditorInput) {
		if(menuExtenders == null) {
			menuExtenders = new ArrayList(1);
		}
		registerContextMenu(menuId, menuManager, selectionProvider, includeEditorInput, editor, context, menuExtenders);
	}

	/**
	 * The <code>MultiPageEditorSite</code> implementation of this <code>IWorkbenchPartSite</code> method remembers the selection provider,
	 * and also hooks a listener on it, which calls <code>handleSelectionChanged</code> when a selection changed event
	 * occurs.
	 * 
	 * @param provider
	 *        The selection provider.
	 * @see MultiPageEditorSite4x#handleSelectionChanged(SelectionChangedEvent)
	 */
	public void setSelectionProvider(ISelectionProvider provider) {
		ISelectionProvider oldSelectionProvider = selectionProvider;
		selectionProvider = provider;
		if(oldSelectionProvider != null) {
			//see code WindowSelectionService (line287)
			// in some case as GraphicalView do not implement IPostSelectionProvider
			oldSelectionProvider.removeSelectionChangedListener(getSelectionChangedListener());
			if(oldSelectionProvider instanceof IPostSelectionProvider) {
				((IPostSelectionProvider)oldSelectionProvider).removePostSelectionChangedListener(getPostSelectionChangedListener());
			} else {
				oldSelectionProvider.removeSelectionChangedListener(getPostSelectionChangedListener());
			}
		}
		if(selectionProvider != null) {
			selectionProvider.addSelectionChangedListener(getSelectionChangedListener());
			if(selectionProvider instanceof IPostSelectionProvider) {
				((IPostSelectionProvider)selectionProvider).addPostSelectionChangedListener(getPostSelectionChangedListener());
			} else {
				selectionProvider.addSelectionChangedListener(getPostSelectionChangedListener());

			}
		}
	}

	/**
	 * This is a helper method for the register context menu functionality. It
	 * is provided so that different implementations of the <code>IWorkbenchPartSite</code> interface don't have to worry about how
	 * context menus should work.
	 * 
	 * @param menuId
	 *        the menu id
	 * @param menuManager
	 *        the menu manager
	 * @param selectionProvider
	 *        the selection provider
	 * @param includeEditorInput
	 *        whether editor inputs should be included in the structured
	 *        selection when calculating contributions
	 * @param part
	 *        the part for this site
	 * @param menuExtenders
	 *        the collection of menu extenders for this site
	 * @see IWorkbenchPartSite#registerContextMenu(MenuManager, ISelectionProvider)
	 */
	public static final void registerContextMenu(final String menuId, final MenuManager menuManager, final ISelectionProvider selectionProvider, final boolean includeEditorInput, final IWorkbenchPart part, final IEclipseContext context, final Collection menuExtenders) {
		/*
		 * Check to see if the same menu manager and selection provider have
		 * already been used. If they have, then we can just add another menu
		 * identifier to the existing PopupMenuExtender.
		 */
		final Iterator extenderItr = menuExtenders.iterator();
		boolean foundMatch = false;
		while(extenderItr.hasNext()) {
			final PopupMenuExtender existingExtender = (PopupMenuExtender)extenderItr.next();
			if(existingExtender.matches(menuManager, selectionProvider, part)) {
				existingExtender.addMenuId(menuId);
				foundMatch = true;
				break;
			}
		}

		if(!foundMatch) {
			try {
				//4.2.2
				PartSite.registerContextMenu(menuId, menuManager, selectionProvider, includeEditorInput, part, context, menuExtenders);
			} catch (NoSuchMethodError ex) {
				//Method not found (4.2.1)
				try {
					Constructor<PopupMenuExtender> constructor = PopupMenuExtender.class.getConstructor(String.class, MenuManager.class, ISelectionProvider.class, IWorkbenchPart.class, boolean.class);
					PopupMenuExtender extender = constructor.newInstance(menuId, menuManager, selectionProvider, part, includeEditorInput);
					menuExtenders.add(extender);
				} catch (Exception ex2) {
					Activator.log.error(ex2);
				}
			}
		}
	}
}
