/**
 * Copyright (C) 2006-2014 phloc systems
 * http://www.phloc.com
 * office[at]phloc[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phloc.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Nonnull;

import org.junit.Test;

import com.phloc.commons.collections.ContainerHelper;
import com.phloc.commons.mock.PhlocTestUtils;
import com.phloc.json.impl.JSONObject;
import com.phloc.json.impl.JSONParsingException;
import com.phloc.json.impl.JSONReader;
import com.phloc.json.impl.value.JSONPropertyValueList;

public abstract class AbstractJSONTestCase
{
  protected static final String PROP_ONE = "ONE"; //$NON-NLS-1$
  protected static final String PROP_TWO = "TWO"; //$NON-NLS-1$
  protected static final String PROP_THREE = "THREE"; //$NON-NLS-1$
  protected static final String PROP_FOUR = "FOUR"; //$NON-NLS-1$
  protected static final String PROP_FIVE = "FIVE"; //$NON-NLS-1$

  protected static final String VALUE_ONE = "dummy"; //$NON-NLS-1$
  protected static final String VALUE_TWO = "1234"; //$NON-NLS-1$
  protected static final String VALUE_THREE = "0815"; //$NON-NLS-1$
  protected static final boolean VALUE_BOOL = true;
  protected static final int VALUE_INT1 = 42;
  protected static final int VALUE_INT2 = 47;
  protected static final int VALUE_INT3 = 11;
  protected static final double VALUE_DOUBLE = 1.78;
  protected static final String VALUE_FOUR = "I\"1"; //$NON-NLS-1$
  protected static final String VALUE_FIVE = "I\t2"; //$NON-NLS-1$

  protected static final String STR_VALUE1 = "puit"; //$NON-NLS-1$
  protected static final String STR_VALUE2 = "fjord"; //$NON-NLS-1$
  protected static final String STR_VALUE3 = "narf"; //$NON-NLS-1$

  protected final IJSONObject m_aSimpleObject;
  protected final IJSONObject m_aComplexObject;

  @Nonnull
  private static final IJSONObject createTestObjectSimple ()
  {
    final JSONObject aObj = new JSONObject ();
    aObj.setIntegerProperty (PROP_ONE, VALUE_INT1);
    aObj.setBooleanProperty (PROP_TWO, VALUE_BOOL);
    final List <String> aListValues = ContainerHelper.newList (VALUE_TWO, VALUE_THREE);
    aObj.setStringListProperty (PROP_THREE, aListValues);
    return aObj;
  }

  @Nonnull
  private static final IJSONObject createTestObjectComplex ()
  {
    final IJSONObject aObj = createTestObjectSimple ();
    aObj.setObjectProperty (PROP_FOUR, createTestObjectSimple ());
    final IJSONPropertyValueList <IJSONPropertyValueList <IJSONObject>> aList = new JSONPropertyValueList <IJSONPropertyValueList <IJSONObject>> ();

    final JSONPropertyValueList <IJSONObject> aInnerListOne = new JSONPropertyValueList <IJSONObject> ();
    aInnerListOne.addValue (createTestObjectSimple ());
    aInnerListOne.addValue (createTestObjectSimple ());
    aList.addValue (aInnerListOne);

    final JSONPropertyValueList <IJSONObject> aInnerListTwo = new JSONPropertyValueList <IJSONObject> ();
    aInnerListTwo.addValue (createTestObjectSimple ());
    aInnerListTwo.addValue (createTestObjectSimple ());
    aList.addValue (aInnerListTwo);

    aObj.setListProperty (PROP_FIVE, aList);
    return aObj;
  }

  /**
   * Ctor
   */
  protected AbstractJSONTestCase ()
  {
    this.m_aSimpleObject = createTestObjectSimple ();
    this.m_aComplexObject = createTestObjectComplex ();
  }

  @SuppressWarnings ("static-method")
  @Test
  public final void testGetJSONString () throws JSONParsingException
  {
    final IJSONObject aObj = createTestObjectComplex ();

    final String sPrettyJSON = aObj.getJSONString (true);
    final String sCompactJSON = aObj.getJSONString ();

    final IJSONObject aPrettyParsed = JSONReader.parseObject (sPrettyJSON);
    final IJSONObject aCompactParsed = JSONReader.parseObject (sCompactJSON);

    assertEquals (aPrettyParsed, aObj);
    assertEquals (aCompactParsed, aObj);
  }

  @Test
  public final void doTestJSONObject ()
  {
    assertNotNull (this.m_aSimpleObject.getProperty (PROP_ONE));
    assertNotNull (this.m_aSimpleObject.getProperty (PROP_TWO));
    assertNotNull (this.m_aSimpleObject.getProperty (PROP_THREE));
    assertEquals (this.m_aSimpleObject.getIntegerProperty (PROP_ONE), Integer.valueOf (VALUE_INT1));
    assertEquals (this.m_aSimpleObject.getBooleanProperty (PROP_TWO), Boolean.TRUE);
    assertEquals (this.m_aSimpleObject.getProperty (PROP_ONE).getValue ().getData (), Integer.valueOf (VALUE_INT1));
    assertEquals (this.m_aSimpleObject.getProperty (PROP_TWO).getValue ().getData (), Boolean.valueOf (VALUE_BOOL));

    final List <?> aListValues = this.m_aSimpleObject.getListProperty (PROP_THREE);
    assertEquals (aListValues.size (), 2);
    assertEquals (aListValues.get (0), VALUE_TWO);
    assertEquals (aListValues.get (1), VALUE_THREE);
  }

  @Test
  public final void doTestClone ()
  {
    PhlocTestUtils.testGetClone (this.m_aSimpleObject);
    PhlocTestUtils.testGetClone (this.m_aComplexObject);
  }
}
