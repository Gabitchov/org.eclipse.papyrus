package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.memoryleak;
import static org.eclipse.papyrus.infra.core.sasheditor.tests.utils.memoryleak.MemoryLeakUtil.assertIsGarbageCollected;
import static org.eclipse.papyrus.infra.core.sasheditor.tests.utils.memoryleak.MemoryLeakUtil.assertIsGarbageCollected2;

import java.lang.ref.WeakReference;

import org.junit.Test;


/**
 * Test the memory ling assertions.
 * 
 * @copyright http://www.forkcan.com/viewcode/215/Detecting-memory-leak-in-unit-test
 *
 */
public class MemoryLeakTest {

  /* This test of the LeakingObject will fail */
  @Test
  public void testLeakingObject() {
    LeakingObject lo = new LeakingObject();

    // 1. Create WeakReference for the object
    WeakReference<LeakingObject> loWeakRef = new WeakReference<LeakingObject>(lo); 

    // 2. Remove strong reference for the object
    lo = null;  

    // 3. Test object is garbage collected correctly
    assertIsGarbageCollected(loWeakRef, 10*1000);
  }

  /* This test of the NonLeakingObject will succeed */
  @Test
  public void testNonLeakingObject() {
    NonLeakingObject lo = new NonLeakingObject();

    // 1. Create WeakReference for the object
    WeakReference<NonLeakingObject> loWeakRef = new WeakReference<NonLeakingObject>(lo); 

    // 2. Remove strong reference for the object
    lo = null;  

    // 3. Test object is garbage collected correctly
    assertIsGarbageCollected(loWeakRef, 10*1000);
  }

/* This test of the LeakingObject will fail */
  @Test
  public void testLeakingObject2() {
    LeakingObject lo = new LeakingObject();

    // 1. Create WeakReference for the object
    WeakReference<LeakingObject> loWeakRef = new WeakReference<LeakingObject>(lo); 

    // 2. Remove strong reference for the object
    lo = null;  

    // 3. Test object is garbage collected correctly
    assertIsGarbageCollected2(loWeakRef, 10*1000);
  }

/* This test of the NonLeakingObject will succeed */
  @Test
  public void testNonLeakingObject2() {
    NonLeakingObject lo = new NonLeakingObject();

    // 1. Create WeakReference for the object
    WeakReference<NonLeakingObject> loWeakRef = new WeakReference<NonLeakingObject>(lo); 

    // 2. Remove strong reference for the object
    lo = null;  

    // 3. Test object is garbage collected correctly
    assertIsGarbageCollected2(loWeakRef, 10*1000);
  }

  
}