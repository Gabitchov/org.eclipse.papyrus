package org.eclipse.papyrus.adltool.designer.bundle;

import java.util.ArrayList;

import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.pde.internal.core.ifeature.IFeatureImport;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.uml2.uml.Component;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.VersionRange;


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

	/**
	 * 
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getRequiredBundle(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 * @return
	 */
	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		ArrayList<ReferencedOSGIElement> bundleListName=new ArrayList<ReferencedOSGIElement>();
		if( bundleProject instanceof IFeatureModel){
			IFeatureModel currentFeatureModel=(IFeatureModel)bundleProject;
			IFeatureImport[] imports=currentFeatureModel.getFeature().getImports();

			for(int i = 0; i < imports.length; i++) {

				ReferencedOSGIElement newRefElement= new ReferencedOSGIElement(null,imports[i].getId());
				if( imports[i].getType()==1){
					newRefElement.setKindRef(ReferencedOSGIElement.FEATURE);
				}
				bundleListName.add(newRefElement);
			}
		}

			return bundleListName;
		}

		@Override
		public String getBundleValue(Object bundleProject, String key) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getName(Object bundleProject) {
			// TODO Auto-generated method stub
			return null;
		}
	}
