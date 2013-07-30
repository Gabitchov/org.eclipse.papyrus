package org.eclipse.papyrus.sysml.diagram.parametric.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;

public class CommentAnnotatedElementPreferencePage extends ParametricDiagramLinkPreferencePage {

	/** Constant key to access preferences */
	protected static String prefKey = ElementTypes.DIAGRAM_ID + "_CommentAnnotatedElement";  //$NON-NLS-1$

		
	/** Default constructor */
	public CommentAnnotatedElementPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_CommentAnnotatedElement"); //$NON-NLS-1$
	}
	
	/**
	 * Initialize defaults using a specified {@link IPreferenceStore}
	 * 
	 * @param store
	 *        the preference store.
	 */	
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
 		// End of user code
 		
	}
	
}	
