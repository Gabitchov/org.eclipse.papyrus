/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;


/**
 * Visitor used to show the status of the different Tiles composing the sash system.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("unchecked")
public class ShowPartStatusVisitor extends PartVisitor {

	int level = 1;

	/**
	 * @param tile
	 */

	@Override
	public boolean accept(RootPart tile) {
		indent();
		tile.showStatus();
		//			System.out.println( "root:" + tile );
		level++;
		super.accept(tile);
		level--;
		return true;
	}

	/**
	 * 
	 */
	private void indent() {
		if(level < 1) {
			//error
			return;
		}

		for(int i = 0; i < level - 1; i++) {
			System.out.print("|   ");
		}
		// last segment
		System.out.print("+ ");
	}

	/**
	 * @param tile
	 */
	@Override
	public boolean accept(SashPanelPart tile) {
		indent();
		tile.showStatus();
		//			System.out.println( "sash:" + tile );
		level++;
		super.accept(tile);
		level--;
		return true;
	}

	/**
	 * @param tile
	 */
	@Override
	public boolean accept(TabFolderPart tile) {
		indent();
		tile.showStatus();
		//			System.out.println( "folder:" + tile );
		level++;
		super.accept(tile);
		level--;
		return true;
	}

	/**
	 * @param tile
	 */
	@Override
	public boolean accept(EditorPart tile) {
		indent();
		tile.showStatus();
		//			System.out.println( "editor:" + tile );
		level++;
		super.accept(tile);
		level--;
		return true;
	}

	/**
	 * @param tile
	 */
	@Override
	public boolean accept(ComponentPart tile) {
		indent();
		tile.showStatus();
		//			System.out.println( "editor:" + tile );
		level++;
		super.accept(tile);
		level--;
		return true;
	}


}
