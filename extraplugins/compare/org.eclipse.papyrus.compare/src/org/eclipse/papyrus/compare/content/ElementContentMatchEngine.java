package org.eclipse.papyrus.compare.content;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.PapyrusMatchEngine;


public class ElementContentMatchEngine extends PapyrusMatchEngine {
	
	private final EObject myLeft;
	
	private final EObject myRight;
	
	public ElementContentMatchEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}
	
	@Override
	public MatchModel contentMatch(EObject leftObject, EObject rightObject, Map<String, Object> optionMap) {
		// TODO Auto-generated method stub
		return super.contentMatch(leftObject, rightObject, optionMap);
	}
	
	@Override
	protected boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
		if (myLeft == obj1 && myRight == obj2) {
			return true;
		}
		// TODO Auto-generated method stub
		return super.isSimilar(obj1, obj2);
	}
	
	@Override
	protected EObject findMostSimilar(EObject eObj, List<EObject> list) throws FactoryException {
		if (eObj == myLeft) {
			return myRight;
		}
		// TODO Auto-generated method stub
		return super.findMostSimilar(eObj, list);
	}

}
