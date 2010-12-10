package org.eclipse.papyrus.compare.content;

import java.util.Collection;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.compare.PapyrusDiffEngine;


public class ElementContentDiffEngine extends PapyrusDiffEngine {
	
	private final EObject myLeft;
	
	private final EObject myRight;
	
	public ElementContentDiffEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}
	
	protected DiffGroup doDiffTwoWay(MatchModel match) {
		return super.doDiffTwoWay(match);
//		final DiffGroup diffRoot = DiffFactory.eINSTANCE.createDiffGroup();
//
//		// It is a possibility that no elements were matched
//		if (match.getMatchedElements().size() > 0) {
//			// we have to browse the model and create the corresponding operations
//			final Match2Elements matchRoot = (Match2Elements)match.getMatchedElements().get(0);
//			// browsing the match model
//
//			final DiffGroup current = diffRoot;
//			Match2Elements match2Element = MatchFactory.eINSTANCE.createMatch2Elements();
//			match2Element.setLeftElement(myLeft);
//			match2Element.setRightElement(myRight);
//			current.setRightParent(match2Element.getRightElement());
//			try {
//				checkForDiffs(current, match2Element);
//			} catch (final FactoryException e) {
//				log(e);
//			}
//		}
//		// iterate over the unmatched elements end determine if they have been
//		// added or removed.
//		processUnmatchedElements(diffRoot, match.getUnmatchedElements());
//		return diffRoot;
	}
	
	

	private EObject getMatch(EObject from) {
		final Collection<EStructuralFeature.Setting> settings = matchCrossReferencer.get(from);
		if (settings == null)
			return null;
		for (final org.eclipse.emf.ecore.EStructuralFeature.Setting setting : settings) {
			if (setting.getEObject() instanceof Match2Elements) {
				return setting.getEObject();
			}
		}
		return null;
	}

}
