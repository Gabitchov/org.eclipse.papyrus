/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.pagesmodel;


/**
 * This class  provides a set of static constructor helping in writing model.
 * <br>
 * Examples:
 * <ul>
 *   <li>PanelTerm query = folder("a", page(), page() );</li>
 *   <li>query = hSash( folder( page("p1"), page() ), vSash("s2",  folder( page() ),  folder( page() )) );</li>
 *   <li>PanelTerm query = hSash( folder("f1", page("p1"), page("p2"), page("p3") ), folder("f2", page("p4") ) );</li>
 *   <li></li>
 * </ul>
 * 
 * @author cedric dumoulin
 *
 */
public class SashPagesModelFactory {

	/**
	 * Static constructor for {@link Page}.
	 * @return
	 */
	static public Page page() {
		return new Page();
	}
	
	/**
	 * Static constructor for {@link Page}.
	 * @return
	 */
	static public Page page(String name) {
		return new Page(name);
	}
	
	/**
	 * Static constructor for {@link Folder}.
	 * @return
	 */
	static public Folder folder( Page ...pages ) {
		return new Folder(pages);
	}
	
	/**
	 * Static constructor for {@link Folder}.
	 * @return
	 */
	static public Folder folder( String name, Page ...pages ) {
		return new Folder(name, pages);
	}
	
	/**
	 * Static constructor for {@link VSash}.
	 * @return
	 */
	static public VSash vSash( String name, PanelTerm up, PanelTerm down) {
		return new VSash(name, up, down);
	}
	
	/**
	 * Static constructor for {@link VSash}.
	 * @return
	 */
	static public VSash vSash( PanelTerm up, PanelTerm down) {
		return new VSash(up, down);
	}
	
	/**
	 * Static constructor for {@link HSash}.
	 * @return
	 */
	static public HSash hSash( String name, PanelTerm left, PanelTerm right) {
		return new HSash(name, left, right);
	}
	
	/**
	 * Static constructor for {@link HSash}.
	 * @return
	 */
	static public HSash hSash( PanelTerm left, PanelTerm right) {
		return new HSash(left, right);
	}
	
}
