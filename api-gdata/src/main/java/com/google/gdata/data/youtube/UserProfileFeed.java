/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.youtube;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.Kind;

/**
 * Feed containing user profiles.
 *
 * 
 */
@Kind.Term(YouTubeNamespace.KIND_USER_PROFILE)
public class UserProfileFeed
    extends BaseFeed<UserProfileFeed, UserProfileEntry> {

  public UserProfileFeed() {
    super(UserProfileEntry.class);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_USER_PROFILE);
  }

  public UserProfileFeed(BaseFeed<?, ?> base) {
    super(UserProfileEntry.class, base);
    EntryUtils.setKind(this, YouTubeNamespace.KIND_USER_PROFILE);
  }
}
