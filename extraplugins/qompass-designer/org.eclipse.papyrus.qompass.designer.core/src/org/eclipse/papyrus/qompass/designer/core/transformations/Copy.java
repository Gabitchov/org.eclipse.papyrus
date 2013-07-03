/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A specific copier that enables to make iterative and shallow copies of model elements
 * from a source to a target model. It also supports copy-listeners, i.e. listeners that
 * might apply modifications before and after an element is copied.
 * This class is very useful for model transformations that make a lazy copy of elements,
 * i.e. copy only elements that are needed in the target model.
 *
 * Iterative means that you can copy one element after another, i.e. you do not need
 * to copy all elements in a single call.
 * Shallow means that some elements are incomplete copies. For instance, if you copy an
 * attribute of a class into the target model, the copy routine will create the attribute within
 * a shallow copy of the original class. The created class is a kind of shallow "container". It
 * is required, since we can't create the attribute without having a class, but it would initially
 * only contain the attribute that we copy. This class would have the same qualified name as the
 * original, i.e. it would be created within shallow packages. 
 * A shallow copy can be transformed into a "real" copy
 * by explicitly copying it.
 * 
 * @author ansgar
 * 
 */
public class Copy extends Copier {

	public Copy(Package source_, Package target_, boolean copyExtResources_) {
		source = source_;
		target = target_;
		// useOriginalReferences = false;
		copyExtReferences = copyExtResources_;
		preCopyListeners = new BasicEList<CopyListener>();
		postCopyListeners = new BasicEList<CopyListener>();
		templateMapInfo = new HashMap<EObject, Map<EObject, EObject>>();
		standardMap = new HashMap<EObject, EObject>();
		shallowMap = new HashMap<EObject, Boolean>();
		boundPackages = new Stack<Namespace>();
		if(copyExtReferences) {
			// original source package becomes a sub-package in the target model
			Package newSourceRoot = target.createNestedPackage(source.getName());
			put(source, newSourceRoot);
		}
		else {
			put(source, target);
		}
	};

	/**
 * 
 */
	private static final long serialVersionUID = -1664013545661635289L;

	/**
	 * Source model within a transformation
	 */

	public Package source;

	/**
	 * Target model within a transformation
	 */
	public Package target;

	/**
	 * if true, copy packages or elements that are imported into the target
	 * model
	 */
	public boolean copyExtReferences;

	/**
	 * Bound package template
	 */
	private Namespace boundPackage;

	/**
	 * Map to identify target objects when given source objects
	 */
	private Map<EObject, EObject> standardMap;

	/**
	 * Map to identify target objects when given source objects
	 */
	private Map<EObject, EObject> templateMap;

	/**
	 * Set of maps for template instantiations
	 */
	private Map<EObject, Map<EObject, EObject>> templateMapInfo;

	/**
	 * Map using a target EObject as key
	 */
	private Map<EObject, Boolean> shallowMap;

	/**
	 * Elements within package templates must be treated differently, we have to ensure that:
	 * (1) several instantiations with same binding of the same package template do not lead to double copies
	 * (yet, it may be possible that a 2nd instantiation adds contents, e.g. the trace package template could be
	 * instantiated containing only OTF trace (and superclasses), a second instantiation might add a different trace
	 * implementation)
	 * (2) several instantiations with different binding do not prevent classes from being copied that have already
	 * been copied earlier.
	 * The solution is to use a different map for the elements with package template. This map is instantiated once
	 * for each binding (managed by the TemplateInstantiation class)
	 */
	public Map<EObject, EObject> getMap(EObject sourceEObj) {
		boolean withinTemplate = withinTemplate(sourceEObj);
		return withinTemplate ?
			templateMap :
			standardMap;
	}

	@Override
	public EObject get(Object sourceEObj) {
		if(sourceEObj instanceof EObject) {
			Map<EObject, EObject> map = getMap((EObject)sourceEObj);
			return map.get(sourceEObj);
		}
		return null;
	}

	@Override
	public EObject put(EObject sourceEObj, EObject targetEObj) {
		if(sourceEObj instanceof EObject) {
			Map<EObject, EObject> map = getMap((EObject)sourceEObj);
			return map.put(sourceEObj, targetEObj);
		}
		return null;
	}

	@Override
	public boolean containsKey(Object sourceEObj) {
		if(sourceEObj instanceof EObject) {
			Map<EObject, EObject> map = getMap((EObject)sourceEObj);
			return map.containsKey(sourceEObj);
		}
		return false;
	}

	@Override
	public EObject remove(Object sourceEObj) {
		if(sourceEObj instanceof EObject) {
			Map<EObject, EObject> map = getMap((EObject)sourceEObj);
			return map.remove(sourceEObj);
		}
		return null;
	}

	public void setShallow(EObject targetEObj, boolean isShallow) {
		shallowMap.put(targetEObj, isShallow);
	}

	/**
	 * return true, if a shallow copy of the passed EObject exists
	 * 
	 * @param sourceEObj
	 * @return
	 */
	public boolean isShallow(EObject targetEObj) {
		Boolean shallow = shallowMap.get(targetEObj);
		if(shallow != null) {
			return shallow;
		}
		return false;
	}

	// public Namespace getPackageTemplate() {
	// return null;
	// }

	/**
	 * Set the reference of a bound package template. It must be a member of the target model.
	 * Setting the package template is required to assure that elements that are part of a different
	 * resource get copied (if the copyExtReferences flag is set to false, copying would not be done otherwise)
	 * 
	 * @param packageTemplate
	 *        Reference to package (with a template signature) in source model that should be instantiated
	 * @param boundPackage
	 *        Reference to (an initially empty) package in which the packate template will be instantiated
	 *        during the copy process
	 */
	public void setPackageTemplate(Namespace packageTemplate, Namespace boundPackage) {
		this.boundPackage = boundPackage;
		if(packageTemplate == null) {
			return;
		}
		templateMap =
			templateMapInfo.get(boundPackage);
		if(templateMap == null) {
			templateMap = new HashMap<EObject, EObject>();
			templateMapInfo.put(boundPackage, templateMap);
		}
		// declare relation between packageTemplate and bound package
		// but: the owner of the package template is not equal to the packageTemplate (e.g. perClass)
		// since we can extend package templates in different models.
		standardMap.put(packageTemplate, boundPackage);
	}

	public void pushPackageTemplate() {
		boundPackages.push(boundPackage);
	}

	public void popPackageTemplate() {
		boundPackage = boundPackages.pop();
		templateMap =
			templateMapInfo.get(boundPackage);
	}

	private Stack<Namespace> boundPackages;

	public void removeForCopy(EObject element) {
		templateMap.remove(element);
		EClass eClass = element.eClass();
		for(int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
		{
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
			if(eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
			{
				if(eStructuralFeature instanceof EAttribute) {
					// copyAttribute((EAttribute)eStructuralFeature, sourceEObj, targetEObj);
				}
				else {
					EReference eReference = (EReference)eStructuralFeature;
					if(eReference.isContainment()) {
						for(EObject ref : getRefs(eReference, element)) {
							removeForCopy(ref);
						}
					}
					else if(!eReference.isContainer()) {
						// not contained, but copy reference as well

					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public EList<EObject> getRefs(EReference eReference, EObject eObject) {
		EList<EObject> refs = new BasicEList<EObject>();
		if(eObject.eIsSet(eReference)) {
			if(eReference.isMany()) {
				// @SuppressWarnings("unchecked")
				refs.addAll((List<EObject>)eObject.eGet(eReference));
			} else {
				refs.add((EObject)eObject.eGet(eReference));
			}
		}
		return refs;
	}

	/**
	 * Check whether the passed element (within the source model) is within a
	 * a template, i.e. one of is owners is mapped towards the bound package in
	 * the target model. Note that multiple owners in the source model may be
	 * mapped to the same bound package.
	 * 
	 * @param element
	 * @return
	 */
	public boolean withinTemplate(EObject element) {
		if(boundPackage != null) {
			EObject owner = element;
			while(owner != null) {
				owner = owner.eContainer();
				if(get(owner) == boundPackage) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns a copy of the given eObject.
	 * 
	 * Normally, we do not want to copy elements that are from a different
	 * resource. There are two exceptions (1) if this is explicitly specified
	 * (for producing "complete" models) (2) if we want to copy elements from a
	 * template into the target model.
	 * 
	 * @param sourceEObj
	 *        the object to copy.
	 * @return the copy.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EObject copy(EObject sourceEObj) {
		boolean withinTemplate = withinTemplate(sourceEObj);

		EObject targetEObj = get(sourceEObj);

		boolean shallowCopy = (targetEObj != null) && isShallow(targetEObj);

		if((targetEObj != null) && !shallowCopy) {
			// copy already exists, return
			return targetEObj;
		}
		setShallow(targetEObj, false);

		if(sourceEObj == null) {
			// this case may happen, if elements were systematically copied without checking for
			// null references in the application code (e.g. if swe copy a part-with-port which might
			// be null in case of delegation or connectors without ports
			return null;
		}
		boolean sameResource = (sourceEObj.eResource() == source.eResource());
		if(!sameResource && !copyExtReferences && !withinTemplate) {
			// do not copy if within different resource, unless
			// 1. copyImports
			// 2. within package template
			return sourceEObj;
		}

		if(sourceEObj instanceof Stereotype) {
			// do not copy Stereotypes, as it would imply copying meta-model elements (the base_X
			// attribute of the stereotype is typed with a meta-model element)
			return sourceEObj;
		}

		for(CopyListener listener : preCopyListeners) {
			EObject result = listener.copyEObject(this, sourceEObj);
			if(result != sourceEObj) {
				return result;
			}
		}

		if(sourceEObj instanceof NamedElement) {
			String name = ((NamedElement)sourceEObj).getQualifiedName();
			if((name != null) && name.startsWith("uml::")) { //$NON-NLS-1$
				Log.log(Status.ERROR, Log.TRAFO_COPY, "copy for meta-model element \"" + name + //$NON-NLS-1$
						"\" requested. Return original element"); //$NON-NLS-1$
				return sourceEObj;
			}			
		}
		// additional sanity check: want to avoid copying (instead of instantiating) elements
		// of a package template
		if((sourceEObj instanceof Package) && (!withinTemplate)) {
			if(((Package)sourceEObj).getOwnedTemplateSignature() != null) {
				Log.log(Status.WARNING, Log.TRAFO_COPY, "warning: copying a package template without instantiating a template"); //$NON-NLS-1$
			}
		}

		if(shallowCopy) {
			// shallowCopy is true: a copy exists already
		}
		else {
			targetEObj = createCopy(sourceEObj);
			put(sourceEObj, targetEObj);

			createShallowContainer(sourceEObj);
		}
		EClass eClass = sourceEObj.eClass();
		for(int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
		{
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
			if(eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived())
			{
				if(eStructuralFeature instanceof EAttribute) {
					copyAttribute((EAttribute)eStructuralFeature, sourceEObj, targetEObj);
				}
				else {
					EReference eReference = (EReference)eStructuralFeature;
					if(eReference.isContainment()) {
						copyContainment(eReference, sourceEObj, targetEObj);
					}
					// some containment relationships require copying the container completely
					// e.g. if an owned template signature is referenced, we need to follow the "template"
					// reference, which subsets the "owner" relationship.
					// e.g. if an operation is referenced, we need to copy the whole interface
					// Currently: only the standard owning reference is not copied recursively.
					// else if(!eReference.isContainer()) {
					else if(!eReference.getName().equals("owner")) {
						// not contained, but copy reference as well
						Object feature = sourceEObj.eGet(eStructuralFeature);
						if(feature instanceof Element) {
							copy((Element)feature);
						} else if(feature instanceof EList) {
							copyAll((EList<Object>)feature);
						}
						copyReference(eReference, sourceEObj, targetEObj);
					}
				}
			}
		}
		copyProxyURI(sourceEObj, targetEObj);
		copyID(sourceEObj, targetEObj);

		if(sourceEObj instanceof Element) {
			// TODO: handle stereotype copy in a generic way
			StUtils.copyStereotypes(this, (Element)sourceEObj, (Element)targetEObj);
		}

		for(CopyListener listener : postCopyListeners) {
			EObject result = listener.copyEObject(this, targetEObj);
			if(result != targetEObj) {
				return result;
			}
		}

		return targetEObj;
	}

	/**
	 * Copy the containment of an element with respect to a certain reference
	 * 
	 * @see org.eclipse.emf.ecore.util.EcoreUtil.Copier#copyContainment(org.eclipse.emf.ecore.EReference, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 *      Differences to referenced function in ECoreUtil
	 *      - If an element in copyAll is null, it is not added
	 *      - List elements are always cleared before copying, since the list elements may already have been
	 *      partially filled by a previous shallow copy
	 * 
	 * @param eReference
	 *        a reference, such as for instance packagedElement (the
	 *        caller needs to check, is this reference is a containment reference).
	 * @param eObject
	 *        the source eObject
	 * @param copyEObject
	 *        the copy of this eObject
	 */
	@Override
	protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if(eObject.eIsSet(eReference)) {
			if(eReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> source = (List<EObject>)eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				List<EObject> target = (List<EObject>)copyEObject.eGet(getTarget(eReference));
				// do not clear (would remove elements that are added by copy listeners)
				// But: better enforce exact copy? (listeners could only add in a post-copy step)
				// target.clear();
				if(!source.isEmpty()) {
					for(EObject copyEObj : copyAll(source)) {
						if(copyEObj != null) {
							target.add(copyEObj);
						}
					}
				}
			} else {
				EObject childEObject = (EObject)eObject.eGet(eReference);
				copyEObject.eSet(getTarget(eReference), childEObject == null ? null : copy(childEObject));
			}
		}
	}

	/**
	 * Copy the containment in a "shallow" way, i.e. copy references to contained objects, if these exist already.
	 * If called for instance for a package, it will add those elements to the packagedElements list of the
	 * target package, that have already been copied.
	 * 
	 * @param eReference
	 * @param eObject
	 * @param copyEObject
	 */
	protected void shallowCopyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if(eObject.eIsSet(eReference)) {
			if(eReference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> source = (List<EObject>)eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				List<EObject> target = (List<EObject>)copyEObject.eGet(getTarget(eReference));
				if(source.isEmpty()) {
					target.clear();
				} else {
					for(EObject sourceEObj : source) {
						// if eObject has already been copied, add it
						EObject copyEObj = get(sourceEObj);
						if((copyEObj != null) && (!target.contains(copyEObj))) {
							target.add(copyEObj);
						}
					}
				}
			} else {
				EObject childEObject = (EObject)eObject.eGet(eReference);
				copyEObject.eSet(getTarget(eReference), childEObject == null ? null : copy(childEObject));
			}
		}
	}

	/**
	 * Create a "shallow" container for an object, i.e. create (recursively) the owner without
	 * adding all other children of this owner (e.g. in case of a package, the package itself will
	 * be created, but not all elements within that package).
	 * 
	 * @param sourceEObj
	 */
	public void createShallowContainer(EObject sourceEObj) {
		EObject owner = sourceEObj.eContainer();
		EObject copy = null;
		EObject lastSource = null;
		while(owner != null) {
			if(containsKey(owner)) {
				// owner is in map, still need to re-copy (update) the containment
				// references, since one of the children did not exist before
				//
				shallowCopy(owner);
				return;
			}
			copy = shallowCopy(owner);
			if(copy instanceof NamedElement) {
				lastSource = owner;
				((NamedElement)copy).setName(((NamedElement)owner).getName());
			}
			owner = owner.eContainer();
		}
		if(copy instanceof PackageableElement) {
			// if we copy external resources, we might reach the "top" on the source level
			// which becomes a sub-package of the new model.
			target.getPackagedElements().add((PackageableElement)copy);
			// TODO: not very clean
			if(lastSource instanceof Element) {
				// TODO: cannot copy stereotypes only after creation, since eContainer does
				// not exist at this moment. Need to put that intelligently into createShallowContainer
				StUtils.copyStereotypes(this, (Element)lastSource, (Element)copy);
			}
		}
	}

	/**
	 * Make a shallow copy of an element, i.e. only create the element itself and not
	 * all of its contents. If a subset of the containing elements already exist in the copied
	 * model, update the containment references pointing to these. The function may be called
	 * multiple times in order to add elements to the containment references that
	 * have been copied since the previous call (i.e. it is possible to make a shallow copy
	 * of a package after a single class within it has been copied. It may be called again,
	 * once a second class within the package has been copied => the packagedElements reference
	 * of the package will be updated).
	 * 
	 * @param sourceEObj
	 * @return
	 */
	public EObject shallowCopy(EObject sourceEObj) {
		EObject targetEObj = get(sourceEObj);
		if(targetEObj == null) {
			targetEObj = createCopy(sourceEObj);
			put(sourceEObj, targetEObj);
			setShallow(targetEObj, true);
		}
		else if(!isShallow(targetEObj)) {
			// object has already been completely copied
			// TODO: only allow shallow for packages
			// return targetEObj;
		}
		if((sourceEObj instanceof Element) && (targetEObj instanceof Element)) {
			// TODO: can copy stereotypes only after creation, since eContainer does
			// not exist at this moment. Need to put that intelligently into createShallowContainer
			StUtils.copyStereotypes(this, (Element)sourceEObj, (Element)targetEObj);
		}

		EClass eClass = sourceEObj.eClass();

		for(int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
			if(eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {
				if(eStructuralFeature instanceof EAttribute) {
					// copyAttribute((EAttribute)eStructuralFeature, sourceEObj, targetEObj);
				} else {
					EReference eReference = (EReference)eStructuralFeature;
					// avoid that during create of shallow copy, a real copy is produced
					// (clarify why may elements are already copied)
					if(eReference.isContainment() && (!eReference.getName().equals("ownedTemplateSignature"))) {

						shallowCopyContainment(eReference, sourceEObj, targetEObj);
					}
				}
			}
		}
		return targetEObj;
	}

	@SuppressWarnings("unchecked")
	public <T extends Element> T getCopy(T source) {
		return (T)copy(source);
	}

	public EList<CopyListener> preCopyListeners;

	public EList<CopyListener> postCopyListeners;

	/**
	 * Called to handle the copying of a cross reference;
	 * this adds values or sets a single value as appropriate for the multiplicity
	 * while omitting any bidirectional reference that isn't in the copy map.
	 * 
	 * @param eReference
	 *        the reference to copy.
	 * @param eObject
	 *        the object from which to copy.
	 * @param copyEObject
	 *        the object to copy to.
	 */
	@Override
	protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject)
	{
		if(eObject.eIsSet(eReference)) {
			if(eReference.isMany()) {
				@SuppressWarnings("unchecked")
				InternalEList<EObject> source = (InternalEList<EObject>)eObject.eGet(eReference);
				@SuppressWarnings("unchecked")
				InternalEList<EObject> target = (InternalEList<EObject>)copyEObject.eGet(getTarget(eReference));
				if(source.isEmpty()) {
					target.clear();
				}
				else {
					boolean isBidirectional = eReference.getEOpposite() != null;
					int index = 0;
					for(Iterator<EObject> k = resolveProxies ? source.iterator() : source.basicIterator(); k.hasNext();) {
						EObject referencedEObject = k.next();
						EObject copyReferencedEObject = get(referencedEObject);
						if(copyReferencedEObject == null) {
							if(useOriginalReferences && !isBidirectional) {
								target.addUnique(index, referencedEObject);
								++index;
							}
						}
						else {
							if(isBidirectional) {
								int position = target.indexOf(copyReferencedEObject);
								if(position == -1) {
									target.addUnique(index, copyReferencedEObject);
								}
								else if(index != position) {
									target.move(index, copyReferencedEObject);
								}
							}
							else if(!target.contains(copyReferencedEObject)) {
								// TODO: does not allow multiple identical elements in the list. Problematic?
								// Check above is necessary, since some references that are not
								// part of the containment may have already been copied (e.g. in case of
								// a TemplateSignature "ownedParameter" subsets "parameter", thus copying
								// ownedParameter as part of the containment adds a template parameter)
								target.addUnique(index, copyReferencedEObject);
							}
							++index;
						}
					}
				}
			}
			else {
				Object referencedEObject = eObject.eGet(eReference, resolveProxies);
				if(referencedEObject == null) {
					copyEObject.eSet(getTarget(eReference), null);
				}
				else if(referencedEObject instanceof EObject) {
					// difference to original code in EcoreUtil: we obtain a copy (which might be null or the
					// source object) of the referenced EObject. This assures that we only set a value of a
					// reference to something we actually want to have in the target model.
					// Specific problematic case in original code: classifierBehavior is a reference, but assigning such
					// a behavior will also add an owned behavior. If we assign a referencedEObject (a behavior) from the
					// source model in the target, we will actually remove it from the source model (as it is uniquely owned).
					EObject copyReferencedEObject = copy((EObject)referencedEObject);
					if(copyReferencedEObject != null) {
						copyEObject.eSet(getTarget(eReference), copyReferencedEObject);
					}
				}
			}
		}
	}

	/**
	 * Copy all methods from the passed source-model class.
	 * This function is useful, if the passed class only exist
	 * as a shallow copy.
	 * 
	 * @param source
	 *        A class within the source model
	 */
	public void copyMethods(Class source) {
		for(Behavior method : source.getOwnedBehaviors()) {
			getCopy(method);
		}
	}

	/**
	 * Copy all attributes from the source-model classifier
	 * This function is useful, if the passed class only exist
	 * as a shallow copy.
	 * 
	 * @param source
	 *        A classifier within the source model
	 */
	public void copyAttributes(Classifier source) {
		for(Property attribute : source.getAttributes()) {
			getCopy(attribute);
		}
	}

	/**
	 * copy all operations from the source-model classifier.
	 * This function is useful, if the passed class only exist
	 * as a shallow copy.
	 * 
	 * @param source
	 *        A classifier within the source model
	 */
	public void copyOperations(Classifier source) {
		for(Operation operation : source.getOperations()) {
			getCopy(operation);
		}
	}

	// TODO: the functions that follow are static and should not be part of this class
	// as they use a different way of copying things.


	public static void copyFeatureModifiers(Feature source, Feature target) {
		target.setIsStatic(source.isStatic());
		target.setIsLeaf(source.isLeaf());
	}

	public static void copyMultElemModifiers(MultiplicityElement source, MultiplicityElement target) {
		target.setIsOrdered(source.isOrdered());
		target.setIsUnique(source.isUnique());
		target.setLower(source.getLower());
		target.setUpper(source.getUpper());
	}

	/**
	 * Copy a value to a target slot
	 * 
	 * @param smValue
	 * @param target
	 * @return
	 */
	public static ValueSpecification copyValue(ValueSpecification value, Slot target) {
		ValueSpecification newValue = target.createValue(value.getName(), value.getType(), value.eClass());
		return copyValue(value, newValue);
	}

	public static ValueSpecification copyDefaultValue(Property source, Property target) {
		ValueSpecification value = source.getDefaultValue();
		if(value != null) {
			ValueSpecification newValue = target.createDefaultValue(value.getName(), value.getType(), value.eClass());
			return copyValue(value, newValue);
		} else {
			return null;
		}
	}

	public static ValueSpecification copyValue(ValueSpecification smValue, ValueSpecification tmValue) {
		if(smValue instanceof OpaqueExpression) {
			OpaqueExpression oeValue = (OpaqueExpression)smValue;
			OpaqueExpression noeValue = (OpaqueExpression)tmValue;
			for(String language : oeValue.getLanguages()) {
				noeValue.getLanguages().add(language);
			}
			for(String body : oeValue.getBodies()) {
				noeValue.getBodies().add(body);
			}
		} else if(smValue instanceof LiteralString) {
			((LiteralString)tmValue).setValue(((LiteralString)smValue).getValue());
		} else if(smValue instanceof LiteralInteger) {
			((LiteralInteger)tmValue).setValue(((LiteralInteger)smValue).getValue());
		} else if(smValue instanceof LiteralUnlimitedNatural) {
			((LiteralUnlimitedNatural)tmValue).setValue(((LiteralUnlimitedNatural)smValue).getValue());
		} else if(smValue instanceof LiteralBoolean) {
			((LiteralBoolean)tmValue).setValue(((LiteralBoolean)smValue).booleanValue());
		} else if(smValue instanceof LiteralNull) {
		}
		return tmValue;
	}

	/**
	 * Copy the (XML) ID from the source to the destination model element. This
	 * is useful, if you want to create a diagram for (parts of) the generated
	 * target model. Otherwise, the IDs would change with each generation and
	 * references from the diagram to model elements would break (of course,
	 * they could still break, for instance if structural modifications of the
	 * source model are made).
	 * 
	 * @param source
	 *        source model element
	 * @param dest
	 *        corresponding target model element
	 */
	public static void copyID(EObject source, EObject target) {
		copyID(source, target, "");
	}

	/**
	 * Copy the (XML) ID from the source to the destination model element.
	 * Prefix the ID with a string passed as parameter
	 * 
	 * @param source
	 *        source model element
	 * @param dest
	 *        corresponding target model element
	 * @param prefix
	 *        a prefix for the target model ID
	 */
	@SuppressWarnings("deprecation")
	public static void copyID(EObject source, EObject target, String prefix) {
		Resource resourceSource = source.eResource();
		Resource resourceTarget = target.eResource();
		// TODO: use EcoreUtil getURI (InternalEObject) instead?

		if((resourceSource instanceof XMLResource) && (resourceTarget instanceof XMLResource)) {
			XMLResource xmlResSource = (XMLResource)resourceSource;
			XMLResource xmlResTarget = (XMLResource)resourceTarget;
			String id = prefix + xmlResSource.getID(source);
			int counter = 0;
			String uniqueID = id;
			while(xmlResTarget.getIDToEObjectMap().containsKey(uniqueID)) {
				uniqueID = id + counter;
				counter++;
			}
			xmlResTarget.setID(target, uniqueID);
		}
	}
}
