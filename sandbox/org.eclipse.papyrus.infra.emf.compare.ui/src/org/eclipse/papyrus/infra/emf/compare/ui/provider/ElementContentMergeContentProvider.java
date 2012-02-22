/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.provider;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider;
import org.eclipse.papyrus.infra.emf.compare.ecore_diff_extension.CompareTwoElementsDiffModel;


/**
 * The ContentProvider used in the Merge Content Viewer.
 */
public class ElementContentMergeContentProvider extends ModelContentMergeContentProvider {

	/**
	 * Instantiates a new element content merge content provider.
	 *
	 * @param cc the cc
	 */
	public ElementContentMergeContentProvider(CompareConfiguration cc) {
		super(cc);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider#getLeftContent(java.lang.Object)
	 */
	@Override
	public Object getLeftContent(Object element) {
		//TODO verif this test!
		if(element instanceof ModelCompareInput) {
			// if we compared a complete resource set, we should display the different resources
			final Object diff = ((ModelCompareInput)element).getDiff();
          //Bug 336361 - [UML Compare] Compare two elements: show right element as root			
			if(diff instanceof CompareTwoElementsDiffModel) {
				return new RootObject(((CompareTwoElementsDiffModel)diff).getLeftRoots().get(0));
			}
		}
		return super.getLeftContent(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeContentProvider#getRightContent(java.lang.Object)
	 */
	@Override
	public Object getRightContent(Object element) {
		if(element instanceof ModelCompareInput) {
			// if we compared a complete resource set, we should display the different resources
			final Object diff = ((ModelCompareInput)element).getDiff();
	          //Bug 336361 - [UML Compare] Compare two elements: show right element as root			
			if(diff instanceof CompareTwoElementsDiffModel) {
				return new RootObject(((CompareTwoElementsDiffModel)diff).getRightRoots().get(0));
			}
		}
		return super.getRightContent(element);
	}

	/**
	 * The Class RootObject.
	 */
    //Bug 336361 - [UML Compare] Compare two elements: show right element as root			
	//FIXME : why in static?!
	public static class RootObject {

		/** The object. */
		public final Object object;

		/**
		 * Instantiates a new root object.
		 *
		 * @param object the object
		 */
		public RootObject(Object object) {
			this.object = object;
		}
	}


}
