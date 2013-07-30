package org.eclipse.papyrus.sysml.diagram.parametric.preferences; 

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;

public class FlowPortPreferencePage extends ParametricDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_shape_sysml_flowport_as_affixed"; //$NON-NLS-1$

	/** The labels default visibility for preferences */
	public static final Map<String, Boolean> labelDefaultVisibilityMap;
	
	/** Static attribute initialization */
	static {
		labelDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		labelDefaultVisibilityMap.put("FlowPortAffixedLabel", Boolean.TRUE); //$NON-NLS-1$	
		labelDefaultVisibilityMap.put("AppliedStereotypeAffixedLabel", Boolean.TRUE); //$NON-NLS-1$	
		
		// Start of user code custom static initializations
 		// End of user code

		Collections.unmodifiableMap(labelDefaultVisibilityMap);		
	}	
	
	/** Constructor */	
	public FlowPortPreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_shape_sysml_flowport_as_affixed"); //$NON-NLS-1$
	}

	/** Default preferences initializer */	
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
 		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.WIDTH), 20);
		store.setDefault(PreferenceConstantHelper.getElementConstant(prefKey, PreferenceConstantHelper.HEIGHT), 20);
		// End of user code
		
		// Initialize default visibility for labels in preference page.
		for(String labelName : labelDefaultVisibilityMap.keySet()) {
			String showLabelKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, labelName, PreferenceConstantHelper.LABEL_VISIBILITY);
			store.setDefault(showLabelKey, labelDefaultVisibilityMap.get(labelName));
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeLabelsList() {
		for(String name : labelDefaultVisibilityMap.keySet()) {
			this.labelsList.add(name);
		}
	}
}
