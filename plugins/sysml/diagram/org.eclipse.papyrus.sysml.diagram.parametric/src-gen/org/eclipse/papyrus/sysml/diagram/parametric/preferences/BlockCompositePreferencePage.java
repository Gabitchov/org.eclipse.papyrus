package org.eclipse.papyrus.sysml.diagram.parametric.preferences; 

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;

public class BlockCompositePreferencePage extends ParametricDiagramNodePreferencePage {

	/** Constant key to access preferences */
	public static String prefKey = ElementTypes.DIAGRAM_ID + "_" +  SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID; //$NON-NLS-1$

	/** The compartments default visibility for preferences */ 
	public static final Map<String, Boolean> compartmentDefaultVisibilityMap;

	/** The compartment titles default visibility for preferences */ 
	public static final Map<String, Boolean> compartmentTitleDefaultVisibilityMap;
		
	/** Static attribute initialization */
	static {
		compartmentDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentDefaultVisibilityMap.put("structure", Boolean.TRUE); //$NON-NLS-1$	
		
		compartmentTitleDefaultVisibilityMap = new LinkedHashMap<String, Boolean>();
		compartmentTitleDefaultVisibilityMap.put("structure", Boolean.TRUE); //$NON-NLS-1$
		
		
		// Start of user code custom static initializations
 		// End of user code
 		
 		Collections.unmodifiableMap(compartmentDefaultVisibilityMap);
 		Collections.unmodifiableMap(compartmentTitleDefaultVisibilityMap);
	}
	
	/** Constructor */
	public BlockCompositePreferencePage() {
		super();
		setPreferenceKey(ElementTypes.DIAGRAM_ID + "_" +  SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID); //$NON-NLS-1$
	}
	
	/** Default preferences initializer */
	public static void initDefaults(IPreferenceStore store) {
		// Start of user code custom default initializations
		// End of user code
		
		// Initialize default visibility for compartments in preference page.
		for(String compartmentName : compartmentDefaultVisibilityMap.keySet()) {
			String showCompartmentKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(showCompartmentKey, compartmentDefaultVisibilityMap.get(compartmentName));
		}

		// Initialize default title visibility for compartments in preference page.
		for(String compartmentName : compartmentTitleDefaultVisibilityMap.keySet()) {
			String showCompartmentTitleKey = PreferenceConstantHelper.getCompartmentElementConstant(prefKey, compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
			store.setDefault(showCompartmentTitleKey, compartmentTitleDefaultVisibilityMap.get(compartmentName));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentNamesList() {
		for(String name : compartmentDefaultVisibilityMap.keySet()) {
			this.compartmentNamesList.add(name);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initializeCompartmentTitlesList() {
		for(String name : compartmentTitleDefaultVisibilityMap.keySet()) {
			this.compartmentTitlesList.add(name);
		}
	}
	
}
