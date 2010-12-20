package org.eclipse.papyrus.compare.content;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.PapyrusMatchEngine;


public class ElementContentMatchEngine extends PapyrusMatchEngine {

	private final EObject myLeft;

	private final EObject myRight;

	public ElementContentMatchEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}

	@Override
	protected AbstractSimilarityChecker prepareChecker() {
		return new AlwaysSimilarChecker(filter, super.prepareChecker());
	}

	private class AlwaysSimilarChecker extends AbstractSimilarityChecker {

		private AbstractSimilarityChecker delegate;

		public AlwaysSimilarChecker(MetamodelFilter filter, AbstractSimilarityChecker fallback) {
			super(filter);
			this.delegate = fallback;
		}

		@Override
		public boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
			return true;
		}

		@Override
		public void init(EObject leftObject, EObject rightObject) throws FactoryException {
			delegate.init(leftObject, rightObject);
		}

		@Override
		public void init(Resource leftResource, Resource rightResource) throws FactoryException {
			delegate.init(leftResource, rightResource);
		}

		@Override
		public double absoluteMetric(EObject obj1, EObject obj2) throws FactoryException {
			return delegate.absoluteMetric(obj1, obj2);
		}
	}

}
