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
package com.phloc.json2;

import java.io.Serializable;

import com.phloc.commons.ICloneable;
import com.phloc.commons.IHasStringRepresentation;

/**
 * Base interface for all JSON object types: list, object and key-value-pair
 * 
 * @author Philip Helger
 */
public interface IJson extends ICloneable <IJson>, Serializable, IHasStringRepresentation
{
  /**
   * @return <code>true</code> if it is an array and can be case to
   *         {@link IJsonArray}, <code>false</code> otherwise.
   */
  boolean isArray ();

  /**
   * @return <code>true</code> if it is an array and can be case to
   *         {@link IJsonObject}, <code>false</code> otherwise.
   */
  boolean isObject ();

  /**
   * @return <code>true</code> if it is an array and can be case to
   *         {@link IJsonValue}, <code>false</code> otherwise.
   */
  boolean isValue ();
}
