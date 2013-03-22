package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ExecutionSpecification;

public class LifelineModelChildrenHelper {

	/**
	 * Try to fixed the bug about display ExecutionSpecifications(ES).
	 * 
	 * At some times, the child ES would be displayed under the parent ES.
	 * 
	 * Fixed to sort them with bounds in model before creating.
	 */
	public static List<View> getModelChildren(View lifeline) {
		if(lifeline == null) {
			return Collections.emptyList();
		}
		@SuppressWarnings("unchecked")
		List<View> children = new ArrayList<View>(lifeline.getVisibleChildren());
		List<View> result = sortChildren(children);
		return result;
	}

	private static List<View> sortChildren(List<View> children) {
		List<View> result = new ArrayList<View>();
		List<View> original = new ArrayList<View>(children);
		for(Iterator<View> iterator = original.iterator(); iterator.hasNext();) {
			View view = iterator.next();
			EObject elt = ViewUtil.resolveSemanticElement(view);
			if(!(elt instanceof ExecutionSpecification)) {
				result.add(view);
				iterator.remove();
			}
		}
		result.addAll(doSortExecutionSpecifications(original));
		return result;
	}

	private static List<View> doSortExecutionSpecifications(List<View> executionSpecifications) {
		if(executionSpecifications.isEmpty()) {
			return executionSpecifications;
		}
		List<View> views = new ArrayList<View>(executionSpecifications);
		List<View> result = new ArrayList<View>(executionSpecifications.size());
		int minX = -1;
		for(View view : views) {
			Rectangle rect = getViewBounds(view);
			if(minX == -1 || rect.x < minX) {
				minX = rect.x;
			}
		}
		List<View> firstLevelViews = new ArrayList<View>();
		for(View view : views) {
			Rectangle rect = getViewBounds(view);
			if(rect.x >= minX - 2 && rect.x <= minX + 2) {
				firstLevelViews.add(view);
			}
		}
		List<View> insertViews = doSortVertically(firstLevelViews);
		for(View view : insertViews) {
			doInsert(view, result, views, new ArrayList<View>(insertViews));
		}
		List<View> remains = new ArrayList<View>();
		for(View view : views) {
			if(!result.contains(view)) {
				remains.add(view);
			}
		}
		insertViews = doSortVertically(remains);
		for(View view : remains) {
			doInsert(view, result, views, new ArrayList<View>(insertViews));
		}
		return result;
	}

	private static void doInsert(View view, List<View> result, List<View> allViews, List<View> ignoreViews) {
		Rectangle r1 = getViewBounds(view);
		r1.width = 16;
		if(!result.contains(view)) {
			result.add(view);
		}
		ignoreViews.add(view);
		List<View> newLevelViews = new ArrayList<View>();
		for(View v : allViews) {
			if(ignoreViews.contains(v)) {
				continue;
			}
			Rectangle r2 = getViewBounds(v);
			r2.width = 16;
			if(r2.x > r1.x && r2.x < r1.right() && r2.y >= r1.y && r2.y <= r1.bottom()) {
				newLevelViews.add(v);
			}
		}
		newLevelViews = doSortVertically(newLevelViews);
		ignoreViews.addAll(newLevelViews);
		for(View v : newLevelViews) {
			doInsert(v, result, allViews, ignoreViews);
		}
	}

	private static List<View> doSortVertically(List<View> views) {
		List<View> insertViews = new ArrayList<View>();
		for(int i = 0; i < views.size(); i++) {
			View current = views.get(i);
			Rectangle r1 = getViewBounds(current);
			int index = insertViews.size();
			for(int j = 0; j < insertViews.size(); j++) {
				Rectangle r2 = getViewBounds(insertViews.get(j));
				if(r1.y < r2.y) {
					index = j;
				}
			}
			insertViews.add(index, current);
		}
		return insertViews;
	}

	private static Rectangle getViewBounds(View view) {
		if(view == null) {
			return null;
		}
		Integer x = getFeatureValue(view, NotationPackage.eINSTANCE.getLocation_X());
		Integer y = getFeatureValue(view, NotationPackage.eINSTANCE.getLocation_Y());
		Integer width = getFeatureValue(view, NotationPackage.eINSTANCE.getSize_Width());
		Integer height = getFeatureValue(view, NotationPackage.eINSTANCE.getSize_Height());
		if(x == null && y == null && width == null && height == null) {
			return null;
		}
		return new Rectangle(x == null ? 0 : x.intValue(), y == null ? 0 : y.intValue(), width == null ? -1 : width.intValue(), height == null ? -1 : height.intValue());
	}

	private static Integer getFeatureValue(View view, EStructuralFeature feature) {
		if(view == null || feature == null) {
			return null;
		}
		return (Integer)ViewUtil.getPropertyValue(view, feature, feature.getEContainingClass());
	}
}
