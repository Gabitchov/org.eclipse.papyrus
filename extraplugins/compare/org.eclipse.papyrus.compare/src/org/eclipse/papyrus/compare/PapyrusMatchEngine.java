package org.eclipse.papyrus.compare;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


public class PapyrusMatchEngine extends GenericMatchEngine {
	
	@Override
	protected AbstractSimilarityChecker prepareChecker() {
		return new AbstractSimilarityChecker(filter) {
			
			@Override
			public boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void init(Resource leftResource, Resource rightResource) throws FactoryException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void init(EObject leftObject, EObject rightObject) throws FactoryException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public double absoluteMetric(EObject obj1, EObject obj2) throws FactoryException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	
}
