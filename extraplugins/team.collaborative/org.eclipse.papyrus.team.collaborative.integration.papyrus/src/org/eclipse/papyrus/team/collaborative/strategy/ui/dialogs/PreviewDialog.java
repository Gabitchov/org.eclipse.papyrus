/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForWorkbenchPage;
import org.eclipse.papyrus.uml.tools.providers.SemanticUMLContentProvider;
import org.eclipse.papyrus.views.modelexplorer.CustomCommonViewer;
import org.eclipse.papyrus.views.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;


/**
 * The Class PreviewDialog.
 * The preview dialog is a generic dialog use to display feedback to the user using specific {@link ILabelProvider}
 */
public class PreviewDialog extends TitleAreaDialog {


	/** The title. */
	private String title;

	/** The message. */
	private String message;

	/** The label provider. */
	private ILabelProvider labelProvider;

	/** The tree viewer. */
	private TreeViewer treeViewer;

	/** The objects to reveal. */
	private Collection<EObject> objectsToReveal;



	/**
	 * Sets the objects to reveal.
	 * 
	 * @param objectToReveal
	 *        the new objects to reveal
	 */
	public void setObjectsToReveal(Collection<EObject> objectToReveal) {
		this.objectsToReveal = objectToReveal;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 *        the parent
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage(message);
		setTitle(title);
		Composite area = (Composite)super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer = new CustomCommonViewer("org.eclipse.papyrus.modelexplorer.modelexplorer", container, SWT.BORDER);
		treeViewer.setContentProvider(new SemanticUMLContentProvider() {

//			@Override
//			protected static EObject[] getRoots(ResourceSet root) {
//				if(root instanceof ModelSet) {
//					ModelSet modelSet = (ModelSet)root;
//					UmlModel umlModel = (UmlUtils.getUmlModel(modelSet));
//					
//					if(umlModel == null)
//						return null;
//					
//					EList<EObject> contents = umlModel.getResource().getContents();
//					ArrayList<EObject> result = new ArrayList<EObject>();
//					Iterator<EObject> iterator = contents.iterator();
//					while(iterator.hasNext()) {
//						EObject eObject = (EObject)iterator.next();
//						//Shall be improved
//						if(eObject.eClass().getEPackage().getNsURI().contains("uml")) {
//							result.add(eObject);
//						}
//					}
//				}
//				return result.toArray(new EObject[result.size()]);
//			}

			@Override
			public Object[] getChildren(Object parentElement) {
				//Remove duplicate
				Object[] superChildren = super.getChildren(parentElement);

				List<Object> result = new ArrayList<Object>();
				for(int i = 0; i < superChildren.length; i++) {
					Object c = superChildren[i];
					if(!result.contains(c)) {
						result.add(c);
					}
				}
				return result.toArray(new Object[result.size()]);
			}
		});
		treeViewer.setLabelProvider(labelProvider);

		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			ServicesRegistry serviceRegistry = ServiceUtilsForWorkbenchPage.getInstance().getServiceRegistry(activePage);
			treeViewer.setInput(serviceRegistry);
			if(objectsToReveal != null) {
				reveal(objectsToReveal);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 *        the parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 * 
	 * @return the initial size
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 600);
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param labelProvider
	 *        the label provider
	 * @param title
	 *        the title
	 * @param message
	 *        the message
	 */
	public PreviewDialog(Shell parentShell, ILabelProvider labelProvider, String title, String message) {
		super(parentShell);
		setShellStyle(SWT.SHELL_TRIM);
		setHelpAvailable(false);
		this.title = title;
		this.message = message;
		this.labelProvider = labelProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#open()
	 */
	@Override
	public int open() {
		int result = super.open();
		return result;
	}



	/**
	 * Reveal.
	 * 
	 * @param elementList
	 *        the element list
	 */
	public void reveal(Iterable<?> elementList) {
		ArrayList<IMatchingItem> matchingItemsToSelect = new ArrayList<IMatchingItem>();
		// filter out non EMF objects
		Iterable<EObject> list = Iterables.transform(Iterables.filter(elementList, EObject.class), new Function<Object, EObject>() {

			public EObject apply(Object from) {
				return (EObject)from;
			}
		});

		for(EObject currentEObject : list) {
			//TODO The custom ModelExplorer Revealer feature has not yet been backported. 
			//See bug 426360. For now, we only reveal the given EObjects.
			//EObject itemToSelect = ModelExplorerRevealerManager.getTargetObjectToRegveal(currentEObject);
			matchingItemsToSelect.add(new ModelElementItemMatchingItem(currentEObject));

			// Does the content provider exist?
			// if(treeViewer.getContentProvider() != null) {

			/*
			 * reveal the ancestors tree using expandToLevel on each of them
			 * in the good order. This is a lot faster than going through the whole tree
			 * using getChildren of the ContentProvider since our Viewer uses a Hashtable
			 * to keep track of the revealed elements.
			 * 
			 * However we need to use a dedicated MatchingItem to do the matching,
			 * and a specific comparer in our viewer so than the equals of MatchingItem is
			 * used in priority.
			 * 
			 * Please refer to MatchingItem for more infos.
			 */
			//for(IMatchingItem item : ModelExplorerRevealerManager.getChainToReveal(itemToSelect)) {
			//	treeViewer.expandToLevel(item, 1);
			//}
			//}
		}
		treeViewer.expandToLevel(new StructuredSelection(matchingItemsToSelect), TreeViewer.ALL_LEVELS);
	}

	/**
	 * Select reveal.
	 * 
	 * @param selection
	 *        the selection
	 */
	public void selectReveal(ISelection selection) {
		if(treeViewer != null) {
			treeViewer.setSelection(selection, true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.core.ui.IRevealSemanticElement#revealSemanticElement(java.util.List)
	 */
	/**
	 * Reveal semantic element.
	 * 
	 * @param elementList
	 *        the element list
	 */
	public void revealSemanticElement(List<?> elementList) {
		reveal(elementList);
	}

}
