/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbench;


public class CreateSeveralModelsWizard extends CreateModelWizard {

	private Map<String, NewModelFilePage> myCategory2modelFilePageMap = new TreeMap<String, NewModelFilePage>();

	private IStructuredSelection mySelection;

	@Override
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection) {
		return null;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		this.mySelection = selection;
	}

	@Override
	public IStatus diagramCategoryChanged(String... newCategories) {
		// clean pages
		List<String> newCategoriesList = Arrays.asList(newCategories);
		Collection<String> keys = new HashSet<String>(myCategory2modelFilePageMap.keySet());
		for(String oldCategory : keys) {
			if(!newCategoriesList.contains(oldCategory)) {
				myCategory2modelFilePageMap.remove(oldCategory);
			}
		}
		for(String newCategory : newCategories) {
			if(!myCategory2modelFilePageMap.containsKey(newCategory)) {
				NewModelFilePage newPage = createNewModelFilePage(mySelection, newCategory);
				myCategory2modelFilePageMap.put(newCategory, newPage);
			}
		}
		return Status.OK_STATUS;
	}
	
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection, String categoryId) {
		NewModelFilePage newPage =  new NewModelFilePage(createModelFilePageId(categoryId), selection);
		newPage.setWizard(this);
		newPage.setDescription(Messages.bind(Messages.CreateSeveralModelsWizard_new_model_file_page_title, categoryId));
		return newPage;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) { 
		String pageId = page.getName();
		if (SelectDiagramKindPage.PAGE_ID.equals(pageId)) {
			String nextKey = myCategory2modelFilePageMap.keySet().iterator().next();
			return myCategory2modelFilePageMap.get(nextKey);
		}
		if (isModelFilePageId(pageId) && myCategory2modelFilePageMap.containsKey(getCategoryForPage(pageId))) {
			String category = getCategoryForPage(pageId);
			Iterator<String> iterator = myCategory2modelFilePageMap.keySet().iterator();
			while (iterator.hasNext()) {
				if (category.equals(iterator.next())) {
					if (iterator.hasNext()) {
						String nextKey = iterator.next();
						return myCategory2modelFilePageMap.get(nextKey);
					}
				}
			}
			return null;
		}
		return super.getNextPage(page);
	}
	
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		// TODO allow navigation between pages
		return super.getPreviousPage(page);
	}
	
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		for (String category: getDiagramCategoryIds()) {
			
			final IFile newFile = createNewModelFile(category);
			DiResourceSet diResourceSet = new DiResourceSet();
			createAndOpenPapyrusModel(diResourceSet, newFile, category);
		}

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}
	
	@Override
	protected IFile createNewModelFile(String category) {
		NewModelFilePage newModelFilePage = myCategory2modelFilePageMap.get(category);
		if (newModelFilePage == null) {
			Activator.log.error(Messages.bind(Messages.CreateSeveralModelsWizard_cannot_initiate_page, category), new Exception());
			return null;
		}
		return newModelFilePage.createNewFile();
	}
	
	private static String createModelFilePageId(String categoryId) {
		return NEW_MODEL_FILE_PAGE_PREFIX + categoryId;
	}
	
	private static boolean isModelFilePageId(String pageId) {
		return pageId.startsWith(NEW_MODEL_FILE_PAGE_PREFIX);
	}
	
	private static String getCategoryForPage(String pageId) {
		return pageId.substring(NEW_MODEL_FILE_PAGE_PREFIX.length());
	}
	
	private static final String NEW_MODEL_FILE_PAGE_PREFIX = NewModelFilePage.PAGE_ID + "_"; //$NON-NLS-1$

}
