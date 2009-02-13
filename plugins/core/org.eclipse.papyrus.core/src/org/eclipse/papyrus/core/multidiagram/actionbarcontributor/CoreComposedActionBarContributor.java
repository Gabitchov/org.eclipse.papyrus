/**
 * 
 */
package org.eclipse.papyrus.core.multidiagram.actionbarcontributor;

import java.util.List;

import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.sasheditor.eclipsecopy.ComposedActionBarContributor;
import org.eclipse.ui.IActionBars;
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
public class CoreComposedActionBarContributor extends ComposedActionBarContributor {

	/**
	 * The registry. Used to initialize the registered actionBars.
	 */
	protected ActionBarContributorRegistry actionBarContributorRegistry;
	
	protected List<EditorActionBarContributor> contributors;
	/**
	 * Constructor.
	 * @throws BackboneException 
	 */
	public CoreComposedActionBarContributor() throws BackboneException {
		// Init the contributors
		loadContributors();
	}
	

	private void loadContributors() throws BackboneException
	{
		actionBarContributorRegistry = new ActionBarContributorRegistry(Activator.PLUGIN_ID);
		
		contributors =  actionBarContributorRegistry.getActionBarContributors();
	}
	
    
	/**
	 * @return the actionBarContributorRegistry
	 */
	public ActionBarContributorRegistry getActionBarContributorRegistry() {
		return actionBarContributorRegistry;
	}


	/**
     * Dispose all the nested ActionBarContributors.
     */
    public void dispose() {
    	
    	// Dispose nested contributors.
    	for(EditorActionBarContributor contributor : contributors )
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
    	for(EditorActionBarContributor contributor : contributors )
    	{
    		System.out.println(this.getClass().getSimpleName() + ".init() : " + contributor.getClass().getName());
    		contributor.init(bars, page);
    	}

    }



}
