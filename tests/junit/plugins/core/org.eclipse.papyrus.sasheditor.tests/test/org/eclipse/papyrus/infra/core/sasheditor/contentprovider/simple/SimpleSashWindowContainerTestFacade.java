/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
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

package org.eclipse.papyrus.infra.core.sasheditor.contentprovider.simple;

import java.util.Map;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.editor.MessagePartModel;
import org.eclipse.papyrus.infra.core.sasheditor.internal.SashWindowsContainer;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.BadNameException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.IModelExp;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PagesModelException;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.PanelTerm;
import org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.WindowTerm;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProviderFacade;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Class providing a facade to test the {@link SashWindowsContainer} class.
 * <br>
 * This facade own a {@link SimpleSashWindowsContentProvider}, a {@link SashWindowsContainer} and
 * provides methods to manipulate it with the help of names. 
 * <br>
 * The facade allows to create pages and folders in the sashContainer, thru the ContentProvider.
 * It also allows to check the resulting structure inside the SashContainer.
 * The facade can also be used to create a particular configuration of the SashContainer, and apply
 * tests on this configuration.
 * <br>
 * Each element in the {@link SimpleSashWindowsContentProvider} can be identified
 * by a name (String). Then, the facade provide methods similar to {@link ISashWindowsContentProvider}, but using 
 * names rather than {@link IAbstractPanelModel} and {@link ITabFolderModel}.
 * <br>
 * The facade maintains a mapping between the names and the {@link ISashWindowsContentProvider} models.
 * <br>
 * The 
 * @author cedric dumoulin
 *
 */
public class SimpleSashWindowContainerTestFacade implements ISashWindowsContentProviderFacade {

	/**
	 * The internal content provider this facade is for.
	 */
	protected SimpleSashWindowsContentProvider contentProvider;
	
	/**
	 * The associated SashContainer
	 */
	protected SashWindowsContainer sashContainer;
	/**
	 * Display used to create windows.
	 */
	protected Display display;


	/**
	 * Mapping between names provided in the expressions and internal implementations of the {@link SimpleSashWindowsContentProvider}.
	 * This mapping is maintained when elements are added or removed.
	 * 
	 */
	protected Map<String, Object> namesMapping;
	
	/**
	 * Constructor.
	 * Create a default internal {@link SimpleSashWindowsContentProvider};
	 * @param modelMngr
	 */
	public SimpleSashWindowContainerTestFacade() {
		this.contentProvider = new SimpleSashWindowsContentProvider();
		initDisplay();
		sashContainer = createSashWindowsContainer(contentProvider);
	}

	/**
	 * Constructor.
	 *
	 * @param modelMngr
	 */
	public SimpleSashWindowContainerTestFacade(SimpleSashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
		initDisplay();
		sashContainer = createSashWindowsContainer(contentProvider);
	}
	
	/**
	 * Init the display object.
	 */
	protected void initDisplay() {
		display = Display.getCurrent();
		if(display == null) {
			display = new Display();
		}
	}
	/**
	 * Create a {@link SashWindowsContainer} to test. Initialize it with provided {@link ISashWindowsContentProvider}.
	 * 
	 * @param contentProvider
	 * @return
	 */
	protected SashWindowsContainer createSashWindowsContainer(ISashWindowsContentProvider contentProvider) {
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		//
		//new ShellEditor(shell);
		SashWindowsContainer sashWindowContainer = new SashWindowsContainer();

		sashWindowContainer.setContentProvider(contentProvider);

		sashWindowContainer.createPartControl(shell);
		//		shell.open();
		return sashWindowContainer;
	}

	
	/**
	 * @return the sashContainer
	 */
	public SashWindowsContainer getSashContainer() {
		return sashContainer;
	}

	/**
	 * @return the ISashWindowsContainer interface
	 */
	public ISashWindowsContainer getISashWindowsContainer() {
		return sashContainer;
	}

	/**
	 * @return the contentProvider
	 */
	public ISashWindowsContentProvider getIContentProvider() {
		return contentProvider;
	}

	/**
	 * Dispose the facade
	 */
	public void dispose() {
		sashContainer.dispose();
		//  display.dispose();
		if(namesMapping != null) {
			namesMapping.clear();
		}
		contentProvider = null;
		sashContainer = null;
	}
	
	/**
	 * Reset the namesMapping context accordingly to the provided expr.
	 * A side effect is that the internal structure is checked against the expr.
	 * <br>
	 * Reseting the names context allows to remove or add names to the context. 
	 * It is used to add names of newly created elements (created with addPage() or createFolder() )

	 * @param expr
	 * @throws PagesModelException
	 */
	public void resetNamesContext(IModelExp expr) throws PagesModelException {
		namesMapping = queryModel(expr);
	}
	
	/**
	 * Check if the internal {@link ISashWindowsContentProvider} is conformed to the specified expression.
	 * @param expr
	 * @throws QueryException 
	 */
	public void assertConform(IModelExp expr) throws PagesModelException {
		
		Object first;
		if( expr instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( expr instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + expr.toString() + ")");
		}
		
		CheckVisitor visitor = new CheckVisitor();
		expr.accept(visitor, first);
	}

	/**
	 * Create an internal model conform to the specified expression.
	 * Any previous model is disguarded.
	 * 
	 * This method should only be called once on a {@link SimpleSashWindowsContentProvider}.
	 * <br>
	 * If an expr term have a name, this name is kept in the facade and can be used later in methods like move, delete, ...
	 * 
	 * @param expr Expression denoting the configuration to create. Must be one of (Folder, HSash, VSash)
	 * @throws QueryException 
	 * 
	 * TODO Ensure that the method can only be called once. For example,
	 * let this class extends {@link SimpleSashWindowsContentProvider}, and the constructor
	 * call this method.
	 */
	public void createModel(IModelExp expr) throws PagesModelException {
		
		Object first ;
		if( expr instanceof PanelTerm) {
			first = getFirstWindowModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + expr.toString() + ")");
		}
		
		// Create a surrounding WindowTerm
		WindowTerm windowTerm = new WindowTerm((PanelTerm)expr);
		
		CreateModelInSimpleContentProviderVisitor visitor = new CreateModelInSimpleContentProviderVisitor(contentProvider);
		windowTerm.accept(visitor, first);
		
		// Fill mapping
		namesMapping = queryModel(expr);
	}

	/**
	 * Get element in the model.
	 * Each model element whose corresponding model query part as a name is added to the result map.
	 * The element is then accessible with the name set in the query part.
	 * 
	 * @param query
	 * @return
	 * @throws QueryException
	 */
	public Map<String, Object> queryModel(IModelExp query) throws PagesModelException {
		
		Object first;
		if( query instanceof WindowTerm) {
			first = getFirstWindowModel();
		}
		else if( query instanceof PanelTerm) {
			first = getFirstPanelModel();
		}
		else {
			throw new PagesModelException("Don't know how to get the model associated to the first term of the expression (" + query.toString() + ")");
		}
		
		QueryVisitor visitor = new QueryVisitor();
		query.accept(visitor, first);
		
		return visitor.getResult();
	}

	/**
	 * Get the model of the first the first window (in actual implementation their is only one window).
	 * @return
	 */
	private RootModel getFirstWindowModel() {
		// Silly method to get the RootModel
		return (RootModel)((AbstractPanelModel)contentProvider.getRootModel()).getParent();
	}

	/**
	 * Get the panel of the first window (in actual implementation their is only one window).
	 * @return
	 */
	private AbstractPanelModel getFirstPanelModel() {
		// In this implementation, the root is always of type AbstractPanelModel
		return (AbstractPanelModel)contentProvider.getRootModel();
	}

	/**
	 * Add a page to the model
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.common.ISashWindowsContentProviderFacade#addPage(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page, java.lang.String, int)
	 *
	 * @param page
	 * @param folderName
	 * @param index
	 * @throws PagesModelException 
	 */
	public void /*IPageModel*/ addPage(Page page, String folderName, int index) throws PagesModelException {
		// Get the folder
		TabFolderModel folderModel = getITabFolderModel( folderName );
		
		IPageModel pageModel = createPageModel(page);
		
		contentProvider.addPage(folderModel, index, pageModel);
		
//		return pageModel;
	}

	/**
	 * Add a page to the model
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.common.ISashWindowsContentProviderFacade#addPage(org.eclipse.papyrus.infra.core.sasheditor.pagesmodel.Page, java.lang.String, int)
	 *
	 * @param page
	 * @param folderName
	 * @throws PagesModelException 
	 */
	public void /*IPageModel*/ addPage(Page page, String folderName) throws PagesModelException {
		// Get the folder
		TabFolderModel folderModel = getITabFolderModel( folderName );
		
		IPageModel pageModel = createPageModel(page);
		
		contentProvider.addPage(folderModel, pageModel);
		
//		return pageModel;
	}

	/**
	 * Create a {@link IPageModel} for the specified {@link Page}.
	 * @param page
	 * @return
	 */
	static public IPageModel createPageModel( Page page ) {
		return new MessagePartModel( page.getName(), page.getName() );
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.tests.common.ISashWindowsContentProviderFacade#movePage(java.lang.String, int, int)
	 *
	 * @param folderName
	 * @param oldIndex
	 * @param newIndex
	 * @throws NotFoundException 
	 */
	public void movePage(String folderName, int oldIndex, int newIndex) throws NotFoundException {
		// Get the folder
		ITabFolderModel folderModel = getITabFolderModel( folderName );
		
		contentProvider.movePage(folderModel, oldIndex, newIndex);
	}

	public void movePage(String srcFolderName, int sourceIndex, String targetFolderName, int targetIndex) throws NotFoundException {
		// Get the folders
		ITabFolderModel srcFolderModel = getITabFolderModel( srcFolderName );
		ITabFolderModel targetFolderModel = getITabFolderModel( targetFolderName );
		
		contentProvider.movePage(srcFolderModel, sourceIndex, targetFolderModel, targetIndex);
	}

	public void removePage(String pageName) throws NotFoundException {
		IPageModel pageModel = getIPageModel(pageName);
		
		contentProvider.removePage(pageModel);
		
	}

	public void removePage(String folderName, int tabIndex) throws NotFoundException {
		// Get the folder
		ITabFolderModel folderModel = getITabFolderModel( folderName );
		
		contentProvider.removePage(folderModel, tabIndex);
		// TODO remove page name from context
	}

	public void createFolder(String tabFolderName, int tabIndex, String targetFolderName, int side) throws PagesModelException {
		// Get the folders
		ITabFolderModel srcFolderModel = getITabFolderModel( tabFolderName );
		TabFolderModel targetFolderModel = getITabFolderModel( targetFolderName );
		
		contentProvider.createFolder(srcFolderModel, tabIndex, targetFolderModel, side);
		
	}

	/**
	 * Add an element in namesMapping. Throw an exception if the name already exist or if the name is not correct.
	 * 
	 * @param name
	 * @param element
	 * @throws BadNameException
	 */
	protected void putNameMapping( String name, Object element) throws BadNameException {
		
		if( name == null || name.length() == 0 ) {
			throw new BadNameException("Name '" + name + "' is not valid.");			
		}

	    if(namesMapping.containsKey(name)) {
			throw new BadNameException("Name '" + name + "' already exist in the context. Can't add it (but element is created).");
		}
		
	}
	/**
	 * Get the {@link ITabFolderModel} associated to the name.
	 * In this implementation, this is the internal folder.
	 * @param folderName
	 * @return
	 * @throws NotFoundException 
	 */
	public TabFolderModel getITabFolderModel(String folderName) throws NotFoundException {


		Object res = namesMapping.get(folderName);
		if(res == null) 
			throw new NotFoundException("Folder named '" + folderName + "' not found in the context of the expression.");

		if( ! (res instanceof TabFolderModel) )
			throw new NotFoundException("An element named '" + folderName + "' is found but it is not of the expected type (ITabFolderModel). " );

		return (TabFolderModel)res;
	}
	
	/**
	 * Get the {@link IPageModel} associated to the name.
	 * In this implementation, this is the internal element.
	 * @param pageName
	 * @return
	 * @throws NotFoundException 
	 */
	public IPageModel getIPageModel(String pageName) throws NotFoundException {


		Object res = namesMapping.get(pageName);
		if(res == null) 
			throw new NotFoundException("Page named '" + pageName + "' not found in the context of the expression.");

		if( ! (res instanceof IPageModel) )
			throw new NotFoundException("An element named '" + pageName + "' is found but it is not of the expected type (IPageModel). " );

		return (IPageModel)res;
	}

	/**
	 * Return the associated maps of (names, internal representation).
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.ISashWindowsContentProviderFacade#getNamesToInternalMap()
	 *
	 * @return
	 */
	public Map<String, Object> getNamesToInternalMap() {
		return namesMapping;
	}
	
	
}
