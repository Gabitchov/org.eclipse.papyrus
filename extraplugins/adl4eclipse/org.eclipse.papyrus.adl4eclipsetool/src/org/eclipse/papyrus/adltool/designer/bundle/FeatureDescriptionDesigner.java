package org.eclipse.papyrus.adltool.designer.bundle;

import java.util.ArrayList;

import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.uml2.uml.Component;


public class FeatureDescriptionDesigner extends AbstractBundleDescriptionDesigner {

	public String getSymbolicName(Object bundleProject) {
		if(bundleProject instanceof IFeatureModel){
			return	((IFeatureModel)bundleProject).getFeature().getId();
		}
		return null;
	}

	public void fillExportedPackages(Component bundleComponent, Object bundleProject) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBundleValue(Object bundleProject, String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
