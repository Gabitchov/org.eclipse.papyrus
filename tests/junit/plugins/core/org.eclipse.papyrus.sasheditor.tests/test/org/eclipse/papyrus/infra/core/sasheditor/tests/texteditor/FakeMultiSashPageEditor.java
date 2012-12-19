/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple.SimpleSashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IMultiPageEditorPart;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.internal.IMultiEditorManager;
import org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy.MultiPageSelectionProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;

/**
 * A fake editor used for JUnit tests.
 * 
 * This main editor provide the minimum required to let a {@link SashWindowsContainer} run inside.
 * It allows addition of pages (editor and components).
 * To create an instance of this editor, use one of the {@link #openEditor()} method. It is possible to provide
 * a {@link ISashWindowsContentProvider} fully initialized.
 * See {@link FakeMultiSashPageEditorTest} for code examples.
 * 
 * For tests to run properly, the editor should be registered as eclipse extension:
 * 
 * <pre>
 * {@code
 *     <extension
 *          point="org.eclipse.ui.editors">
 *       <editor
 *             class="org.eclipse.papyrus.infra.core.sasheditor.tests.texteditor.FakeMultiSashPageEditor"
 *             default="false"
 *             id="org.eclipse.papyrus.infra.core.sasheditor.tests.editor.FakeMultiSashPageEditor"
 *             name="FakeMultiSashPageEditor">
 *       </editor>
 *    </extension>
 *  }
 * </pre>
 * 
 * @author Cedric Dumoulin
 */
public class FakeMultiSashPageEditor extends EditorPart implements IMultiEditorManager, IMultiPageEditorPart {

	/**
	 * Id used to register this editor in Eclipse.
	 * Can be used to open the editor.
	 */
	public static String EditorID = "org.eclipse.papyrus.infra.core.sasheditor.tests.editor.FakeMultiSashPageEditor";

	/** The pageProvider */
	private ISashWindowsContentProvider pageProvider;

	/** The sash windows system :-) */
	private SashWindowsContainer sashContainer;

	/**
	 * IEditorPart of the opened editor.
	 */
	protected IEditorPart mainEditorPart;


	/**
	 * Return an instance of the editor inside the Eclipse framework.
	 * The Editor should be registered to Eclipse extension.
	 * The editor will be created with the specified number of nested editors of type {@link TestTextEditor}
	 * 
	 * @param nestedEditorCount
	 *        Number of expected nested editors.
	 * 
	 * @throws PartInitException
	 */
	public static FakeMultiSashPageEditor openEditor(int nestedEditorCount) throws PartInitException {
		// Create a content provider with one editor
		SimpleSashWindowsContentProvider contentProvider = new SimpleSashWindowsContentProvider();
		// Create pages and add them to the default folder
		for(int i = 0; i < nestedEditorCount; i++) {
			IPageModel newModel = new TextEditorPartModel("editor" + i);
			contentProvider.addPage(newModel);
		}

		return openEditor(contentProvider);
	}

	/**
	 * Return an instance of the editor inside the Eclipse framework.
	 * The Editor should be registered to Eclipse extension.
	 * The editor will contain one nested editor.
	 * 
	 * @throws PartInitException
	 */
	public static FakeMultiSashPageEditor openEditor() throws PartInitException {

		return openEditor(1);
	}

	private static class OpenEditorRunnable implements Runnable {

		private ISashWindowsContentProvider contentProvider;

		private FakeMultiSashPageEditor editor;

		public OpenEditorRunnable(ISashWindowsContentProvider contentProvider) {
			this.contentProvider = contentProvider;
		}

		public void run() {
			IEditorInput input = new FakeEditorInput(contentProvider);

			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			try {
				IEditorPart part = page.openEditor(input, FakeMultiSashPageEditor.EditorID);

				this.editor = (FakeMultiSashPageEditor)part;
			} catch (PartInitException ex) {
				ex.printStackTrace(System.out);
			}
		}

		public FakeMultiSashPageEditor getEditor() {
			return editor;
		}
	}

	/**
	 * Return an instance of the editor inside the Eclipse framework.
	 * The Editor should be registered to Eclipse extension.
	 * 
	 * @throws PartInitException
	 */
	public static FakeMultiSashPageEditor openEditor(ISashWindowsContentProvider contentProvider) throws PartInitException {
		OpenEditorRunnable runnable = new OpenEditorRunnable(contentProvider);
		Display.getDefault().syncExec(runnable);
		return runnable.getEditor();
	}

	/**
	 * Close the specified editor.
	 * 
	 * @param editor
	 */
	public static void closeEditor(final FakeMultiSashPageEditor editor) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				IWorkbenchPage page = window.getActivePage();
				page.closeEditor(editor, false);
			}
		});
	}

	/**
	 * get the contentProvider. Create it if necessary.
	 * 
	 * @return
	 */
	public ISashWindowsContentProvider getContentProvider() {

		return getContentProviderImpl();
	}

	/**
	 * get the contentProvider. Create it if necessary.
	 * This return the internal implementation.
	 * Misc method. If the internal impl is not of the specified type, throw an exception ...
	 * 
	 * @return
	 */
	public SimpleSashWindowsContentProvider getContentProviderImpl() {
		if(pageProvider == null) {
			pageProvider = createPageProvider();
		}

		return (SimpleSashWindowsContentProvider)pageProvider;
	}

	/**
	 * Set the contentProvider if not set. If it is already set, this method do not change it.
	 * 
	 * @param contentProvider
	 */
	public void setContentProvider(ISashWindowsContentProvider contentProvider) {
		if(pageProvider == null) {
			pageProvider = contentProvider;
		}
	}

	/**
	 * Create and initialize the pageProvider.
	 */
	protected ISashWindowsContentProvider createPageProvider() {
		ISashWindowsContentProvider pageProvider = new SimpleSashWindowsContentProvider();
		// Adding requested pages
		pageProvider.addPage(new TextEditorPartModel());

		return pageProvider;
	}

	/**
	 * Handles a property change notification from a nested editor. The default implementation simply forwards the change to
	 * listeners on this multi-page editor by calling <code>firePropertyChange</code> with the same property id. For example, if
	 * the dirty state of a nested editor changes (property id <code>IEditorPart.PROP_DIRTY</code>), this method handles it
	 * by firing a property change event for <code>IEditorPart.PROP_DIRTY</code> to property listeners on this multi-page
	 * editor.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @copiedfrom org.eclipse.ui.part.MultiPageEditorPart.handlePropertyChange(int)
	 * 
	 * @param propertyId
	 *        the id of the property that changed
	 */
	//	protected void handlePropertyChange(int propertyId) {
	//		firePropertyChange(propertyId);
	//	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IEditorPart</code> method sets its site to the given
	 * site, its input to the given input, and the site's selection provider to a <code>MultiPageSelectionProvider</code>.
	 * Subclasses may extend this method.
	 * 
	 * @copiedfrom org.eclipse.ui.part.MultiPageEditorPart
	 * @param site
	 *        The site for which this part is being created; must not be <code>null</code>.
	 * @param input
	 *        The input on which this editor should be created; must not be <code>null</code>.
	 * @throws PartInitException
	 *         If the initialization of the part fails -- currently never.
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {

		// Check if the input carry a ContentProvider.
		if(input instanceof FakeEditorInput) {
			// Get the content provider from the input
			FakeEditorInput providerInput = (FakeEditorInput)input;
			ISashWindowsContentProvider provider = providerInput.getContentProvider();
			if(provider != null) {
				setContentProvider(provider);
			}
		}

		setSite(site);
		setInput(input);
		site.setSelectionProvider(new MultiPageSelectionProvider(this));
	}

	/**
	 * Create the part controls. {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		// Create and intialize sash windows
		sashContainer = new SashWindowsContainer(this);
		sashContainer.setContentProvider(getContentProvider());
		sashContainer.createPartControl(parent);
		activate();
	}

	/**
	 * Method to activate the editor.
	 * Called immediately after createPartControl() is complete.
	 * To be implemented by subclasses. Default implementation do nothing.
	 */
	protected void activate() {
	}

	/**
	 * Method to deactivate the editor.
	 * Called when dispose() is called.
	 * To be implemented by subclasses. Default implementation do nothing.
	 */
	protected void deactivate() {
	}

	/**
	 * Dispose the Editor. Also dispose the sashsystem.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		deactivate();
		super.dispose();
		//		System.err.println("editor disposed");
		// Clean references
		mainEditorPart = null;
		pageProvider = null;
		sashContainer = null;
	}

	/**
	 * Refresh the sash windows system
	 */
	public void refreshTabs() {
		if(sashContainer != null) {
			sashContainer.refreshTabs();
		}

	}


	/**
	 * Needed by MultiPageActionBarContributor and MultiPageSelectionProvider.
	 */
	public IEditorPart getActiveEditor() {
		return sashContainer.getActiveEditor();
	}

	/**
	 * Get the {@link ISashWindowsContainer}.
	 * Note the the ISashWindowsContainer can also be acuired with getAdapter(ISashWindowsContainer.class).
	 */
	public ISashWindowsContainer getISashWindowsContainer() {
		return sashContainer;
	}

	/**
	 * Get the {@link ISashWindowsContainer}.
	 * Note the the ISashWindowsContainer can also be acuired with getAdapter(ISashWindowsContainer.class).
	 */
	public SashWindowsContainer getSashWindowsContainer() {
		return sashContainer;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		sashContainer.setFocus();

	}

	/**
	 * (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isDirty() {
		return false;
	}


}
