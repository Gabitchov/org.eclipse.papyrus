/**
 * 
 */
package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.papyrus.di.presentation.DiActionBarContributor;
import org.eclipse.papyrus.di.presentation.DiEditor;
//import org.eclipse.papyrus.diagram.common.scribe.editor.abstracteditor.AbstractGraphicalPageWithFlyoutPalette;
import org.eclipse.papyrus.sasheditor.eclipsecopy.IMultiPageEditorActionBarContributor;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.EditorActionBarContributor;


/**
 * 
 * An ActionBarContributor composed of ActionBarContributor from multi editor.
 * This ActionBarContributor switch to the contributor dedicated to the active editor in
 * a MultiPageEditor environement.
 * 
 * @author dumoulin
 *
 */
public class GmfComposedActionBarContributor extends MultiPageEditorActionBarContributor {

	/**
	 * List of contributors.
	 */
	protected ContributorMap<Class<? extends IEditorPart>, EditorActionBarContributor> contributors = new ContributorMap<Class<? extends IEditorPart>, EditorActionBarContributor>();
	
	
	/**
	 * Contributor used as default.
	 */
	protected EditorActionBarContributor defaultContributor;
	
	/**
	 * The currently active contributor.
	 */
	protected EditorActionBarContributor activeContributor;
	
	
	/**
	 * Constructor.
	 */
	public GmfComposedActionBarContributor() {
		// Init the contributors
		loadContributors();
	}
	
	/**
	 * Sets the active page of the the multi-page editor to be the given editor. 
	 * Switch the currently active editor.
	 * <p>
	 * This method is called whenever the page changes. Subclasses must implement this method 
	 * to redirect actions to the given editor (if not already directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *            the new active editor, or <code>null</code> if there is no active page, or if the 
	 *            active page does not have a corresponding editor
	 */
	@Override
	public void setActivePage(IEditorPart activeEditor)
	{
		// Check if we are already initialized
		// Return if we are not
		if(getPage()==null)
			return;
		
		activeContributor = getActionBarContributorFor(activeEditor);
		// Use default if none is found
		if(activeContributor == null)
			activeContributor = getDefaultActionBarContributor();
		
		System.out.println(this.getClass().getSimpleName() 
				+ ".setActivePage(" + activeEditor
				+ ") :" + activeContributor );
		
		// Propagate call
		if(activeContributor instanceof IMultiPageEditorActionBarContributor)
			((IMultiPageEditorActionBarContributor)activeContributor).setActivePage(activeEditor);
		
		
	}

	/**
     * Sets the active editor for the contributor.
     * <p>
     * The <code>EditorActionBarContributor</code> implementation of this method does
     * nothing. Subclasses may reimplement. This generally entails disconnecting
     * from the old editor, connecting to the new editor, and updating the actions
     * to reflect the new editor.
     * </p>
     * 
     * @param targetEditor the new target editor
     */
    public void setActiveEditor(IEditorPart targetEditor) {
    	// Switch the editor and activeContributor.
    	super.setActiveEditor(targetEditor);
    	// Now, propagate to the new activeContributor
    	activeContributor.setActiveEditor(targetEditor);
    }	
    
	/**
	 * Lookup for the ActionBarContributor associated to the specified part.
	 * @param activeEditor
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributorFor(IEditorPart activeEditor) {
		Class<? extends IEditorPart> editorType = activeEditor.getClass();
		
		
		return contributors.get(editorType);
	}

	/**
	 * Get an action bar by its type.
	 * Return the action bar or null.
	 * @param class1
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor(Class<? extends EditorActionBarContributor> type) {
	 	return contributors.getValueByItsClass(type);
	}


    /**
     * Get a default ActionBarContributor.
	 * @return
	 */
	private EditorActionBarContributor getDefaultActionBarContributor() {
		return defaultContributor;
	}


	private void loadContributors()
	{
		// default
		defaultContributor = new GmfUmlMultiDiagramActionBarContributor();
//		contributors.put( , defaultContributor);
		
		// scribe
//		EditorActionBarContributor contributor = new MultiPagesEditorActionBarContributor();
//		contributors.add( AbstractGraphicalPageWithFlyoutPalette.class, contributor);
		
		// GMF
		EditorActionBarContributor contributor = new UMLDiagramActionBarContributor();
		contributors.add( DiagramDocumentEditor.class, contributor);
		
		// emf
		contributor = new DiActionBarContributor();
		contributors.add( DiEditor.class, contributor);
		
	}
	
	// ************************************************ //
	//      Propagate method calls  //
	// ************************************************ //
	
    /**
     * Returns this contributor's action bars.
     *
     * @return the action bars
     */
    public IActionBars getActionBars() {
        return activeContributor.getActionBars();
    }

    /**
     * Dispose all the nested ActionBarContributors.
     */
    public void dispose() {
    	
    	// Dispose nested contributors.
    	for(EditorActionBarContributor contributor : contributors.values() )
    	{
    		contributor.dispose();
    	}
    }

    /**
     * The <code>EditorActionBarContributor</code> implementation of this 
     * <code>IEditorActionBarContributor</code> method remembers the page
     * then forwards the call to <code>init(IActionBars)</code> for
     * backward compatibility
     */
    public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);
        
        System.out.println(this.getClass().getSimpleName() + ".init("+ bars+ ")");
     	// init nested contributors.
    	for(EditorActionBarContributor contributor : contributors.values() )
    	{
    		contributor.init(bars, page);
    	}
    	defaultContributor.init(bars, page);

    }


    /**
     * A light implementation of a map for contributors.
	 * Map can't be used as we need to check inheritance for the key.
     * @author dumoulin
     *
     */
    protected class ContributorMap <K extends Class, V> {
    	
    	List<ContributorMapEntry<K, V>> entries = new ArrayList<ContributorMapEntry<K, V>>();
    	
    	/**
    	 * Add the specified value, associated with the key.
    	 * @param key
    	 * @param value
    	 */
    	public void add( K key, V value  )
    	{
    		if(indexOf(key) >=0)
    			return;
    		
    		entries.add(new ContributorMapEntry<K, V>(key, value));
    	}
    	
    	/**
    	 * Get the index of the entry containing the specified key.
    	 * @param key
    	 * @return
    	 */
    	protected int indexOf( K key)
    	{
    		for(int i=0; i<entries.size(); i++)
    		{
    			ContributorMapEntry<K, V> entry = entries.get(i);
    			if( entry.key.isInstance(key) )
    				return i;
    		}
     		// not found
    		return -1;
    		
    	}
    	/**
    	 * Get a value by its key.
    	 * Check for subclasses.
    	 * @param key
    	 * @return
    	 */
    	public V get( K key)
    	{
    		for(ContributorMapEntry<K, V> entry : entries)
    		{
    			
    			if( entry.key.isAssignableFrom(key) )
    				return entry.value;
    		}
     		// not found
    		return null;
    	}
    	
       	/**
    	 * Get a value by its class type.
    	 * Check for subclasses.
    	 * @param key
    	 * @return
    	 */
    	public V getValueByItsClass( Class<? extends EditorActionBarContributor> type)
    	{
    		for(ContributorMapEntry<K, V> entry : entries)
    		{
    			
    			if( type.isInstance(entry.value) )
    				return entry.value;
    		}
     		// not found
    		return null;
    	}
    	
    	/**
    	 * Return a collection containing the values.
    	 * TODO: return a view instead of a copy
    	 * @return
    	 */
    	public Collection<V> values()
    	{
    		List<V> res = new ArrayList<V>();
    		for(ContributorMapEntry<K, V> entry : entries)
    		{
    			res.add(entry.value);
    		}
     		// not found
    		return res;
   		
    	}
    }
    
	/**
	 * A structure associating a contributor and a key. 
	 * Map can't be used as we need to check inheritance for the key.
	 * @author dumoulin
	 *
	 */
	protected class ContributorMapEntry <K extends Class, T>{
		protected T value;
		protected K key;
		/**
		 * @param key
		 * @param value
		 */
		public ContributorMapEntry(K key, T value) {
			this.key = key;
			this.value = value;
		}
		
	}

}
