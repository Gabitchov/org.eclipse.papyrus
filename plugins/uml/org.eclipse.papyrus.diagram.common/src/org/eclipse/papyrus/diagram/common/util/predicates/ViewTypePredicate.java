package org.eclipse.papyrus.diagram.common.util.predicates;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.notation.View;

import com.google.common.base.Predicate;

/**
 * Predicate used to filter views by ID
 * @author arthur daussy
 */
public class ViewTypePredicate implements Predicate<View>{
	/**
	 * Visual Id
	 */
	private String id;

	/**
	 * Visual Id your are looking for
	 * @param id
	 */
	public ViewTypePredicate(String id) {
		super();
		Assert.isNotNull(id);
		this.id = id;
	}

	public boolean apply(View input) {	
		return id.equals(input.getType());
	}
	
	
}