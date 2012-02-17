/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.compare.EMFCompareException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.compare.ui.editor.ModelCompareEditorInput;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.infra.core.editor.PageMngrServiceFactory;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusEMFCompareInstance;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISaveablesLifecycleListener;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.SaveablesLifecycleEvent;
import org.eclipse.ui.part.EditorPart;

//TODO the CompareEditor should be extented or Encapsulated?
public class EMFCompareEditor implements IReusableEditor, ISaveablesSource, IPropertyChangeListener, ISaveablesLifecycleListener {

	/** the type of the editor */
//	public static final String EDITOR_TYPE = "PapyrusGenericCompareEditor"; //$NON-NLS-1$

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	protected CompareEditor compareEditor;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public EMFCompareEditor(ServicesRegistry servicesRegistry, final PapyrusEMFCompareInstance rawModel) {
		super();
		this.servicesRegistry = servicesRegistry;
		compareEditor = new CompareEditor();
		ComparisonSnapshot snapshot = doContentCompare(rawModel.getLeft(), rawModel.getRight());
		//				CompareUI.openCompareEditor(new ModelCompareEditorInput(snapshot));
		//				openCompareEditor(input, true);
		//				openCompareEditorOnPage(input, null, activate);
		//				page.openEditor(input, COMPARE_EDITOR, activate);
		//				CompareUIPlugin plugin= CompareUIPlugin.getDefault();
		//				if (plugin != null)
		//					plugin.openCompareEditor(input, page, null, activate);
		//				
		//				IWorkbenchPage page2 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		this.input = new ModelCompareEditorInput(snapshot);
	}


	public void setCompareEditor(final CompareEditor compareEditor) {
		this.compareEditor = compareEditor;
	}

	private CompareEditorInput input;


	/**
	 * 
	 * @see org.eclipse.ui.IEditorPart#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if(input instanceof CompareEditorInput) {
			this.compareEditor.init(site, input);
		} else {
			this.compareEditor.init(site, this.input);
		}

	}

	public void handleLifecycleEvent(SaveablesLifecycleEvent event) {
		this.compareEditor.handleLifecycleEvent(event);

	}

	public void propertyChange(PropertyChangeEvent event) {
		this.compareEditor.propertyChange(event);

	}

	public Saveable[] getSaveables() {
		return this.compareEditor.getSaveables();
	}

	public Saveable[] getActiveSaveables() {
		return this.compareEditor.getActiveSaveables();
	}

	public void doSave(IProgressMonitor monitor) {
		this.compareEditor.doSave(monitor);

	}

	public void doSaveAs() {
		this.compareEditor.doSaveAs();

	}

	public boolean isDirty() {
		return this.compareEditor.isDirty();
	}

	public boolean isSaveAsAllowed() {
		return this.compareEditor.isDirty();
	}

	public void createPartControl(Composite parent) {
		this.compareEditor.createPartControl(parent);

	}

	public void setFocus() {
		this.compareEditor.setFocus();
	}

	public IEditorInput getEditorInput() {
		return this.compareEditor.getEditorInput();
	}

	public IEditorSite getEditorSite() {
		return this.compareEditor.getEditorSite();
	}

	public void addPropertyListener(IPropertyListener listener) {
		this.compareEditor.addPropertyListener(listener);

	}

	public void dispose() {
		this.compareEditor.dispose();
		int i=0;
		i++;
		//TODO : remove the listener on the partService
	}

	public IWorkbenchPartSite getSite() {
		return this.compareEditor.getSite();
	}

	public String getTitle() {
		return this.compareEditor.getTitle();
	}

	public Image getTitleImage() {
		return this.compareEditor.getTitleImage();
	}

	public String getTitleToolTip() {
		return this.compareEditor.getTitleToolTip();
	}

	public void removePropertyListener(IPropertyListener listener) {
		this.compareEditor.removePropertyListener(listener);

	}

	public Object getAdapter(Class adapter) {
		return this.compareEditor.getAdapter(adapter);
	}

	public boolean isSaveOnCloseNeeded() {
		return this.compareEditor.isSaveOnCloseNeeded();
	}


	public void setInput(IEditorInput input) {
		this.compareEditor.setInput(input);
	}

	protected ComparisonResourceSnapshot doContentCompare(final EObject left, final EObject right) {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot();

		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InterruptedException {
					final Map<String, Object> options = new EMFCompareMap<String, Object>();
					options.put(MatchOptions.OPTION_PROGRESS_MONITOR, monitor);
					options.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new GenericMatchScopeProvider(left.eResource(), right.eResource()));
					options.put(MatchOptions.OPTION_IGNORE_ID, Boolean.TRUE);
					options.put(MatchOptions.OPTION_IGNORE_XMI_ID, Boolean.TRUE);

					final MatchModel match = MatchService.doContentMatch(left, right, options);
					DiffModel diff = DiffService.doDiff(match);
					//						final MatchModel match = contentMatch(left, right, monitor);
					//						final DiffModel diff = contentDiff(left, right, match);

					snapshot.setDiff(diff);
					snapshot.setMatch(match);

				}

			});
		} catch (final InterruptedException e) {
			Activator.log.error(e);
		} catch (final EMFCompareException e) {
			Activator.log.error(e);
		} catch (final InvocationTargetException e) {
			Activator.log.error(e);
		}

		return snapshot;
	}

	
	

}
