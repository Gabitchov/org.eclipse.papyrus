/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *  Christian W. Damus (CEA) - Support creating models in repositories (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbench;

/**
 * Creates several new model files - one each selected diagram category. 
 * This functionality in under development now. 
 */
// TODO: Provide proper file names for the new model file pages after the first one
// TODO: Allow the user to skip NewModelFile page and invoke finish in advance. 
public class CreateSeveralModelsWizard extends CreateModelWizard {

	/** The my category2model file page map. */
	private Map<String, NewModelFilePage> myCategory2modelFilePageMap = new TreeMap<String, NewModelFilePage>();

	/** The my selection. */
	private IStructuredSelection mySelection;

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		this.mySelection = selection;
	}
	
	@Override
	public boolean isCreateMultipleModelsWizard() {
		return true;
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
		return super.diagramCategoryChanged(newCategories);
	}
	
	/**
	 * Creates the new model file page.
	 *
	 * @param selection the selection
	 * @param categoryId the category id
	 * @return the new model file page
	 */
	protected NewModelFilePage createNewModelFilePage(IStructuredSelection selection, String categoryId) {
		NewModelFilePage newPage = new NewModelFilePage(
			createModelFilePageId(categoryId), selection, getModelKindName());
		newPage.setWizard(this);
		newPage.setDescription(Messages.bind(Messages.CreateSeveralModelsWizard_new_model_file_page_title, categoryId));
		return newPage;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getPreviousPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		// TODO allow navigation between pages
		return super.getPreviousPage(page);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.diagram.wizards.CreateModelWizard#createSelectDiagramCategoryPage()
	 */
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return new SelectDiagramCategoryPage(true);
	}

	/**
	 * Perform finish.
	 *
	 * @return true, if successful
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		for (String category: getDiagramCategoryIds()) {
			
			final URI newURI = createNewModelURI(category);
			createAndOpenPapyrusModel(newURI, category);
		}

		saveDiagramCategorySettings();
		saveDiagramKindSettings();
		return true;
	}
	
	@Override
	protected URI createNewModelURI(String category) {
		NewModelFilePage newModelFilePage = myCategory2modelFilePageMap.get(category);
		if (newModelFilePage == null) {
			Activator.log.error(Messages.bind(Messages.CreateSeveralModelsWizard_cannot_initiate_page, category), new Exception());
			return null;
		}
		
		IFile file = newModelFilePage.createNewFile();
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}
	
	/**
	 * Creates the model file page id.
	 *
	 * @param categoryId the category id
	 * @return the string
	 */
	private static String createModelFilePageId(String categoryId) {
		return NEW_MODEL_FILE_PAGE_PREFIX + categoryId;
	}
	
	/**
	 * Checks if is model file page id.
	 *
	 * @param pageId the page id
	 * @return true, if is model file page id
	 */
	private static boolean isModelFilePageId(String pageId) {
		return pageId.startsWith(NEW_MODEL_FILE_PAGE_PREFIX);
	}
	
	/**
	 * Gets the category for page.
	 *
	 * @param pageId the page id
	 * @return the category for page
	 */
	private static String getCategoryForPage(String pageId) {
		return pageId.substring(NEW_MODEL_FILE_PAGE_PREFIX.length());
	}
	
	/** The Constant NEW_MODEL_FILE_PAGE_PREFIX. */
	private static final String NEW_MODEL_FILE_PAGE_PREFIX = NewModelFilePage.PAGE_ID + "_"; //$NON-NLS-1$

}
