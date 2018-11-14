/**
 * Copyright (C) 2006-2015 phloc systems
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
package com.phloc.json.impl;

/**
 * This exception is thrown if a JSON String is parsed into a {@link JSONObject}
 * and an error occurs due to invalid JSON input string.
 * 
 * @author Boris Gregorcic
 */
public class JSONParsingException extends Exception
{
  private static final long serialVersionUID = -1482562259009147578L;

  /**
   * Ctor with only a message
   * 
   * @param sMsg
   *        Exception message
   */
  public JSONParsingException (final String sMsg)
  {
    super (sMsg);
  }

  /**
   * Ctor with a message and an inner exception
   * 
   * @param sMessage
   *        Exception message
   * @param aException
   *        nested exception
   */
  public JSONParsingException (final String sMessage, final Throwable aException)
  {
    super (sMessage, aException);
  }
}
