package com.yupog2003.tripdiary.thrift;

import org.apache.thrift.EncodingUtils;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trip implements org.apache.thrift.TBase<Trip, Trip._Fields>, java.io.Serializable, Cloneable, Comparable<Trip> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Trip");

  private static final org.apache.thrift.protocol.TField PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("path", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField LAT_FIELD_DESC = new org.apache.thrift.protocol.TField("lat", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField LNG_FIELD_DESC = new org.apache.thrift.protocol.TField("lng", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("time", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField UPLOAD_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("uploadTime", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField LIKES_FIELD_DESC = new org.apache.thrift.protocol.TField("likes", org.apache.thrift.protocol.TType.I32, (short)8);
  private static final org.apache.thrift.protocol.TField POSTS_FIELD_DESC = new org.apache.thrift.protocol.TField("posts", org.apache.thrift.protocol.TType.I32, (short)9);
  private static final org.apache.thrift.protocol.TField VIEWS_FIELD_DESC = new org.apache.thrift.protocol.TField("views", org.apache.thrift.protocol.TType.I32, (short)10);
  private static final org.apache.thrift.protocol.TField IS_PUBLIC_FIELD_DESC = new org.apache.thrift.protocol.TField("isPublic", org.apache.thrift.protocol.TType.BOOL, (short)11);
  private static final org.apache.thrift.protocol.TField POIS_FIELD_DESC = new org.apache.thrift.protocol.TField("pois", org.apache.thrift.protocol.TType.LIST, (short)12);
  private static final org.apache.thrift.protocol.TField NOTE_STR_FIELD_DESC = new org.apache.thrift.protocol.TField("noteStr", org.apache.thrift.protocol.TType.STRING, (short)13);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TripStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TripTupleSchemeFactory());
  }

  public String path; // required
  public String name; // required
  public String author; // required
  public double lat; // required
  public double lng; // required
  public String time; // required
  public String uploadTime; // required
  public int likes; // required
  public int posts; // required
  public int views; // required
  public boolean isPublic; // required
  public List<POI> pois; // required
  public String noteStr; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PATH((short)1, "path"),
    NAME((short)2, "name"),
    AUTHOR((short)3, "author"),
    LAT((short)4, "lat"),
    LNG((short)5, "lng"),
    TIME((short)6, "time"),
    UPLOAD_TIME((short)7, "uploadTime"),
    LIKES((short)8, "likes"),
    POSTS((short)9, "posts"),
    VIEWS((short)10, "views"),
    IS_PUBLIC((short)11, "isPublic"),
    POIS((short)12, "pois"),
    NOTE_STR((short)13, "noteStr");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PATH
          return PATH;
        case 2: // NAME
          return NAME;
        case 3: // AUTHOR
          return AUTHOR;
        case 4: // LAT
          return LAT;
        case 5: // LNG
          return LNG;
        case 6: // TIME
          return TIME;
        case 7: // UPLOAD_TIME
          return UPLOAD_TIME;
        case 8: // LIKES
          return LIKES;
        case 9: // POSTS
          return POSTS;
        case 10: // VIEWS
          return VIEWS;
        case 11: // IS_PUBLIC
          return IS_PUBLIC;
        case 12: // POIS
          return POIS;
        case 13: // NOTE_STR
          return NOTE_STR;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __LAT_ISSET_ID = 0;
  private static final int __LNG_ISSET_ID = 1;
  private static final int __LIKES_ISSET_ID = 2;
  private static final int __POSTS_ISSET_ID = 3;
  private static final int __VIEWS_ISSET_ID = 4;
  private static final int __ISPUBLIC_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PATH, new org.apache.thrift.meta_data.FieldMetaData("path", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAT, new org.apache.thrift.meta_data.FieldMetaData("lat", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LNG, new org.apache.thrift.meta_data.FieldMetaData("lng", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TIME, new org.apache.thrift.meta_data.FieldMetaData("time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.UPLOAD_TIME, new org.apache.thrift.meta_data.FieldMetaData("uploadTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LIKES, new org.apache.thrift.meta_data.FieldMetaData("likes", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.POSTS, new org.apache.thrift.meta_data.FieldMetaData("posts", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.VIEWS, new org.apache.thrift.meta_data.FieldMetaData("views", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IS_PUBLIC, new org.apache.thrift.meta_data.FieldMetaData("isPublic", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.POIS, new org.apache.thrift.meta_data.FieldMetaData("pois", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, POI.class))));
    tmpMap.put(_Fields.NOTE_STR, new org.apache.thrift.meta_data.FieldMetaData("noteStr", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Trip.class, metaDataMap);
  }

  public Trip() {
  }

  public Trip(
    String path,
    String name,
    String author,
    double lat,
    double lng,
    String time,
    String uploadTime,
    int likes,
    int posts,
    int views,
    boolean isPublic,
    List<POI> pois,
    String noteStr)
  {
    this();
    this.path = path;
    this.name = name;
    this.author = author;
    this.lat = lat;
    setLatIsSet(true);
    this.lng = lng;
    setLngIsSet(true);
    this.time = time;
    this.uploadTime = uploadTime;
    this.likes = likes;
    setLikesIsSet(true);
    this.posts = posts;
    setPostsIsSet(true);
    this.views = views;
    setViewsIsSet(true);
    this.isPublic = isPublic;
    setIsPublicIsSet(true);
    this.pois = pois;
    this.noteStr = noteStr;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Trip(Trip other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPath()) {
      this.path = other.path;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetAuthor()) {
      this.author = other.author;
    }
    this.lat = other.lat;
    this.lng = other.lng;
    if (other.isSetTime()) {
      this.time = other.time;
    }
    if (other.isSetUploadTime()) {
      this.uploadTime = other.uploadTime;
    }
    this.likes = other.likes;
    this.posts = other.posts;
    this.views = other.views;
    this.isPublic = other.isPublic;
    if (other.isSetPois()) {
      List<POI> __this__pois = new ArrayList<POI>(other.pois.size());
      for (POI other_element : other.pois) {
        __this__pois.add(new POI(other_element));
      }
      this.pois = __this__pois;
    }
    if (other.isSetNoteStr()) {
      this.noteStr = other.noteStr;
    }
  }

  public Trip deepCopy() {
    return new Trip(this);
  }

  @Override
  public void clear() {
    this.path = null;
    this.name = null;
    this.author = null;
    setLatIsSet(false);
    this.lat = 0.0;
    setLngIsSet(false);
    this.lng = 0.0;
    this.time = null;
    this.uploadTime = null;
    setLikesIsSet(false);
    this.likes = 0;
    setPostsIsSet(false);
    this.posts = 0;
    setViewsIsSet(false);
    this.views = 0;
    setIsPublicIsSet(false);
    this.isPublic = false;
    this.pois = null;
    this.noteStr = null;
  }

  public String getPath() {
    return this.path;
  }

  public Trip setPath(String path) {
    this.path = path;
    return this;
  }

  public void unsetPath() {
    this.path = null;
  }

  /** Returns true if field path is set (has been assigned a value) and false otherwise */
  public boolean isSetPath() {
    return this.path != null;
  }

  public void setPathIsSet(boolean value) {
    if (!value) {
      this.path = null;
    }
  }

  public String getName() {
    return this.name;
  }

  public Trip setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getAuthor() {
    return this.author;
  }

  public Trip setAuthor(String author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  public double getLat() {
    return this.lat;
  }

  public Trip setLat(double lat) {
    this.lat = lat;
    setLatIsSet(true);
    return this;
  }

  public void unsetLat() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  /** Returns true if field lat is set (has been assigned a value) and false otherwise */
  public boolean isSetLat() {
    return EncodingUtils.testBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  public void setLatIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LAT_ISSET_ID, value);
  }

  public double getLng() {
    return this.lng;
  }

  public Trip setLng(double lng) {
    this.lng = lng;
    setLngIsSet(true);
    return this;
  }

  public void unsetLng() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LNG_ISSET_ID);
  }

  /** Returns true if field lng is set (has been assigned a value) and false otherwise */
  public boolean isSetLng() {
    return EncodingUtils.testBit(__isset_bitfield, __LNG_ISSET_ID);
  }

  public void setLngIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LNG_ISSET_ID, value);
  }

  public String getTime() {
    return this.time;
  }

  public Trip setTime(String time) {
    this.time = time;
    return this;
  }

  public void unsetTime() {
    this.time = null;
  }

  /** Returns true if field time is set (has been assigned a value) and false otherwise */
  public boolean isSetTime() {
    return this.time != null;
  }

  public void setTimeIsSet(boolean value) {
    if (!value) {
      this.time = null;
    }
  }

  public String getUploadTime() {
    return this.uploadTime;
  }

  public Trip setUploadTime(String uploadTime) {
    this.uploadTime = uploadTime;
    return this;
  }

  public void unsetUploadTime() {
    this.uploadTime = null;
  }

  /** Returns true if field uploadTime is set (has been assigned a value) and false otherwise */
  public boolean isSetUploadTime() {
    return this.uploadTime != null;
  }

  public void setUploadTimeIsSet(boolean value) {
    if (!value) {
      this.uploadTime = null;
    }
  }

  public int getLikes() {
    return this.likes;
  }

  public Trip setLikes(int likes) {
    this.likes = likes;
    setLikesIsSet(true);
    return this;
  }

  public void unsetLikes() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LIKES_ISSET_ID);
  }

  /** Returns true if field likes is set (has been assigned a value) and false otherwise */
  public boolean isSetLikes() {
    return EncodingUtils.testBit(__isset_bitfield, __LIKES_ISSET_ID);
  }

  public void setLikesIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LIKES_ISSET_ID, value);
  }

  public int getPosts() {
    return this.posts;
  }

  public Trip setPosts(int posts) {
    this.posts = posts;
    setPostsIsSet(true);
    return this;
  }

  public void unsetPosts() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __POSTS_ISSET_ID);
  }

  /** Returns true if field posts is set (has been assigned a value) and false otherwise */
  public boolean isSetPosts() {
    return EncodingUtils.testBit(__isset_bitfield, __POSTS_ISSET_ID);
  }

  public void setPostsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __POSTS_ISSET_ID, value);
  }

  public int getViews() {
    return this.views;
  }

  public Trip setViews(int views) {
    this.views = views;
    setViewsIsSet(true);
    return this;
  }

  public void unsetViews() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __VIEWS_ISSET_ID);
  }

  /** Returns true if field views is set (has been assigned a value) and false otherwise */
  public boolean isSetViews() {
    return EncodingUtils.testBit(__isset_bitfield, __VIEWS_ISSET_ID);
  }

  public void setViewsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __VIEWS_ISSET_ID, value);
  }

  public boolean isIsPublic() {
    return this.isPublic;
  }

  public Trip setIsPublic(boolean isPublic) {
    this.isPublic = isPublic;
    setIsPublicIsSet(true);
    return this;
  }

  public void unsetIsPublic() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISPUBLIC_ISSET_ID);
  }

  /** Returns true if field isPublic is set (has been assigned a value) and false otherwise */
  public boolean isSetIsPublic() {
    return EncodingUtils.testBit(__isset_bitfield, __ISPUBLIC_ISSET_ID);
  }

  public void setIsPublicIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISPUBLIC_ISSET_ID, value);
  }

  public int getPoisSize() {
    return (this.pois == null) ? 0 : this.pois.size();
  }

  public java.util.Iterator<POI> getPoisIterator() {
    return (this.pois == null) ? null : this.pois.iterator();
  }

  public void addToPois(POI elem) {
    if (this.pois == null) {
      this.pois = new ArrayList<POI>();
    }
    this.pois.add(elem);
  }

  public List<POI> getPois() {
    return this.pois;
  }

  public Trip setPois(List<POI> pois) {
    this.pois = pois;
    return this;
  }

  public void unsetPois() {
    this.pois = null;
  }

  /** Returns true if field pois is set (has been assigned a value) and false otherwise */
  public boolean isSetPois() {
    return this.pois != null;
  }

  public void setPoisIsSet(boolean value) {
    if (!value) {
      this.pois = null;
    }
  }

  public String getNoteStr() {
    return this.noteStr;
  }

  public Trip setNoteStr(String noteStr) {
    this.noteStr = noteStr;
    return this;
  }

  public void unsetNoteStr() {
    this.noteStr = null;
  }

  /** Returns true if field noteStr is set (has been assigned a value) and false otherwise */
  public boolean isSetNoteStr() {
    return this.noteStr != null;
  }

  public void setNoteStrIsSet(boolean value) {
    if (!value) {
      this.noteStr = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PATH:
      if (value == null) {
        unsetPath();
      } else {
        setPath((String)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((String)value);
      }
      break;

    case LAT:
      if (value == null) {
        unsetLat();
      } else {
        setLat((Double)value);
      }
      break;

    case LNG:
      if (value == null) {
        unsetLng();
      } else {
        setLng((Double)value);
      }
      break;

    case TIME:
      if (value == null) {
        unsetTime();
      } else {
        setTime((String)value);
      }
      break;

    case UPLOAD_TIME:
      if (value == null) {
        unsetUploadTime();
      } else {
        setUploadTime((String)value);
      }
      break;

    case LIKES:
      if (value == null) {
        unsetLikes();
      } else {
        setLikes((Integer)value);
      }
      break;

    case POSTS:
      if (value == null) {
        unsetPosts();
      } else {
        setPosts((Integer)value);
      }
      break;

    case VIEWS:
      if (value == null) {
        unsetViews();
      } else {
        setViews((Integer)value);
      }
      break;

    case IS_PUBLIC:
      if (value == null) {
        unsetIsPublic();
      } else {
        setIsPublic((Boolean)value);
      }
      break;

    case POIS:
      if (value == null) {
        unsetPois();
      } else {
        setPois((List<POI>)value);
      }
      break;

    case NOTE_STR:
      if (value == null) {
        unsetNoteStr();
      } else {
        setNoteStr((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PATH:
      return getPath();

    case NAME:
      return getName();

    case AUTHOR:
      return getAuthor();

    case LAT:
      return Double.valueOf(getLat());

    case LNG:
      return Double.valueOf(getLng());

    case TIME:
      return getTime();

    case UPLOAD_TIME:
      return getUploadTime();

    case LIKES:
      return Integer.valueOf(getLikes());

    case POSTS:
      return Integer.valueOf(getPosts());

    case VIEWS:
      return Integer.valueOf(getViews());

    case IS_PUBLIC:
      return Boolean.valueOf(isIsPublic());

    case POIS:
      return getPois();

    case NOTE_STR:
      return getNoteStr();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PATH:
      return isSetPath();
    case NAME:
      return isSetName();
    case AUTHOR:
      return isSetAuthor();
    case LAT:
      return isSetLat();
    case LNG:
      return isSetLng();
    case TIME:
      return isSetTime();
    case UPLOAD_TIME:
      return isSetUploadTime();
    case LIKES:
      return isSetLikes();
    case POSTS:
      return isSetPosts();
    case VIEWS:
      return isSetViews();
    case IS_PUBLIC:
      return isSetIsPublic();
    case POIS:
      return isSetPois();
    case NOTE_STR:
      return isSetNoteStr();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Trip)
      return this.equals((Trip)that);
    return false;
  }

  public boolean equals(Trip that) {
    if (that == null)
      return false;

    boolean this_present_path = true && this.isSetPath();
    boolean that_present_path = true && that.isSetPath();
    if (this_present_path || that_present_path) {
      if (!(this_present_path && that_present_path))
        return false;
      if (!this.path.equals(that.path))
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_lat = true;
    boolean that_present_lat = true;
    if (this_present_lat || that_present_lat) {
      if (!(this_present_lat && that_present_lat))
        return false;
      if (this.lat != that.lat)
        return false;
    }

    boolean this_present_lng = true;
    boolean that_present_lng = true;
    if (this_present_lng || that_present_lng) {
      if (!(this_present_lng && that_present_lng))
        return false;
      if (this.lng != that.lng)
        return false;
    }

    boolean this_present_time = true && this.isSetTime();
    boolean that_present_time = true && that.isSetTime();
    if (this_present_time || that_present_time) {
      if (!(this_present_time && that_present_time))
        return false;
      if (!this.time.equals(that.time))
        return false;
    }

    boolean this_present_uploadTime = true && this.isSetUploadTime();
    boolean that_present_uploadTime = true && that.isSetUploadTime();
    if (this_present_uploadTime || that_present_uploadTime) {
      if (!(this_present_uploadTime && that_present_uploadTime))
        return false;
      if (!this.uploadTime.equals(that.uploadTime))
        return false;
    }

    boolean this_present_likes = true;
    boolean that_present_likes = true;
    if (this_present_likes || that_present_likes) {
      if (!(this_present_likes && that_present_likes))
        return false;
      if (this.likes != that.likes)
        return false;
    }

    boolean this_present_posts = true;
    boolean that_present_posts = true;
    if (this_present_posts || that_present_posts) {
      if (!(this_present_posts && that_present_posts))
        return false;
      if (this.posts != that.posts)
        return false;
    }

    boolean this_present_views = true;
    boolean that_present_views = true;
    if (this_present_views || that_present_views) {
      if (!(this_present_views && that_present_views))
        return false;
      if (this.views != that.views)
        return false;
    }

    boolean this_present_isPublic = true;
    boolean that_present_isPublic = true;
    if (this_present_isPublic || that_present_isPublic) {
      if (!(this_present_isPublic && that_present_isPublic))
        return false;
      if (this.isPublic != that.isPublic)
        return false;
    }

    boolean this_present_pois = true && this.isSetPois();
    boolean that_present_pois = true && that.isSetPois();
    if (this_present_pois || that_present_pois) {
      if (!(this_present_pois && that_present_pois))
        return false;
      if (!this.pois.equals(that.pois))
        return false;
    }

    boolean this_present_noteStr = true && this.isSetNoteStr();
    boolean that_present_noteStr = true && that.isSetNoteStr();
    if (this_present_noteStr || that_present_noteStr) {
      if (!(this_present_noteStr && that_present_noteStr))
        return false;
      if (!this.noteStr.equals(that.noteStr))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Trip other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetPath()).compareTo(other.isSetPath());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPath()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.path, other.path);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthor()).compareTo(other.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, other.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLat()).compareTo(other.isSetLat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lat, other.lat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLng()).compareTo(other.isSetLng());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLng()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lng, other.lng);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTime()).compareTo(other.isSetTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.time, other.time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUploadTime()).compareTo(other.isSetUploadTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUploadTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uploadTime, other.uploadTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLikes()).compareTo(other.isSetLikes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLikes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.likes, other.likes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPosts()).compareTo(other.isSetPosts());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPosts()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.posts, other.posts);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetViews()).compareTo(other.isSetViews());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetViews()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.views, other.views);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsPublic()).compareTo(other.isSetIsPublic());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsPublic()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isPublic, other.isPublic);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPois()).compareTo(other.isSetPois());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPois()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pois, other.pois);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNoteStr()).compareTo(other.isSetNoteStr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNoteStr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.noteStr, other.noteStr);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Trip(");
    boolean first = true;

    sb.append("path:");
    if (this.path == null) {
      sb.append("null");
    } else {
      sb.append(this.path);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("author:");
    if (this.author == null) {
      sb.append("null");
    } else {
      sb.append(this.author);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lat:");
    sb.append(this.lat);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lng:");
    sb.append(this.lng);
    first = false;
    if (!first) sb.append(", ");
    sb.append("time:");
    if (this.time == null) {
      sb.append("null");
    } else {
      sb.append(this.time);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("uploadTime:");
    if (this.uploadTime == null) {
      sb.append("null");
    } else {
      sb.append(this.uploadTime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("likes:");
    sb.append(this.likes);
    first = false;
    if (!first) sb.append(", ");
    sb.append("posts:");
    sb.append(this.posts);
    first = false;
    if (!first) sb.append(", ");
    sb.append("views:");
    sb.append(this.views);
    first = false;
    if (!first) sb.append(", ");
    sb.append("isPublic:");
    sb.append(this.isPublic);
    first = false;
    if (!first) sb.append(", ");
    sb.append("pois:");
    if (this.pois == null) {
      sb.append("null");
    } else {
      sb.append(this.pois);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("noteStr:");
    if (this.noteStr == null) {
      sb.append("null");
    } else {
      sb.append(this.noteStr);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TripStandardSchemeFactory implements SchemeFactory {
    public TripStandardScheme getScheme() {
      return new TripStandardScheme();
    }
  }

  private static class TripStandardScheme extends StandardScheme<Trip> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Trip struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PATH
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.path = iprot.readString();
              struct.setPathIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.author = iprot.readString();
              struct.setAuthorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LAT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lat = iprot.readDouble();
              struct.setLatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LNG
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lng = iprot.readDouble();
              struct.setLngIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.time = iprot.readString();
              struct.setTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // UPLOAD_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.uploadTime = iprot.readString();
              struct.setUploadTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // LIKES
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.likes = iprot.readI32();
              struct.setLikesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // POSTS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.posts = iprot.readI32();
              struct.setPostsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // VIEWS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.views = iprot.readI32();
              struct.setViewsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // IS_PUBLIC
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isPublic = iprot.readBool();
              struct.setIsPublicIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 12: // POIS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list24 = iprot.readListBegin();
                struct.pois = new ArrayList<POI>(_list24.size);
                for (int _i25 = 0; _i25 < _list24.size; ++_i25)
                {
                  POI _elem26;
                  _elem26 = new POI();
                  _elem26.read(iprot);
                  struct.pois.add(_elem26);
                }
                iprot.readListEnd();
              }
              struct.setPoisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 13: // NOTE_STR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.noteStr = iprot.readString();
              struct.setNoteStrIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Trip struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.path != null) {
        oprot.writeFieldBegin(PATH_FIELD_DESC);
        oprot.writeString(struct.path);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.author != null) {
        oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
        oprot.writeString(struct.author);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LAT_FIELD_DESC);
      oprot.writeDouble(struct.lat);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LNG_FIELD_DESC);
      oprot.writeDouble(struct.lng);
      oprot.writeFieldEnd();
      if (struct.time != null) {
        oprot.writeFieldBegin(TIME_FIELD_DESC);
        oprot.writeString(struct.time);
        oprot.writeFieldEnd();
      }
      if (struct.uploadTime != null) {
        oprot.writeFieldBegin(UPLOAD_TIME_FIELD_DESC);
        oprot.writeString(struct.uploadTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LIKES_FIELD_DESC);
      oprot.writeI32(struct.likes);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(POSTS_FIELD_DESC);
      oprot.writeI32(struct.posts);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(VIEWS_FIELD_DESC);
      oprot.writeI32(struct.views);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(IS_PUBLIC_FIELD_DESC);
      oprot.writeBool(struct.isPublic);
      oprot.writeFieldEnd();
      if (struct.pois != null) {
        oprot.writeFieldBegin(POIS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.pois.size()));
          for (POI _iter27 : struct.pois)
          {
            _iter27.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.noteStr != null) {
        oprot.writeFieldBegin(NOTE_STR_FIELD_DESC);
        oprot.writeString(struct.noteStr);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TripTupleSchemeFactory implements SchemeFactory {
    public TripTupleScheme getScheme() {
      return new TripTupleScheme();
    }
  }

  private static class TripTupleScheme extends TupleScheme<Trip> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Trip struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPath()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetAuthor()) {
        optionals.set(2);
      }
      if (struct.isSetLat()) {
        optionals.set(3);
      }
      if (struct.isSetLng()) {
        optionals.set(4);
      }
      if (struct.isSetTime()) {
        optionals.set(5);
      }
      if (struct.isSetUploadTime()) {
        optionals.set(6);
      }
      if (struct.isSetLikes()) {
        optionals.set(7);
      }
      if (struct.isSetPosts()) {
        optionals.set(8);
      }
      if (struct.isSetViews()) {
        optionals.set(9);
      }
      if (struct.isSetIsPublic()) {
        optionals.set(10);
      }
      if (struct.isSetPois()) {
        optionals.set(11);
      }
      if (struct.isSetNoteStr()) {
        optionals.set(12);
      }
      oprot.writeBitSet(optionals, 13);
      if (struct.isSetPath()) {
        oprot.writeString(struct.path);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetAuthor()) {
        oprot.writeString(struct.author);
      }
      if (struct.isSetLat()) {
        oprot.writeDouble(struct.lat);
      }
      if (struct.isSetLng()) {
        oprot.writeDouble(struct.lng);
      }
      if (struct.isSetTime()) {
        oprot.writeString(struct.time);
      }
      if (struct.isSetUploadTime()) {
        oprot.writeString(struct.uploadTime);
      }
      if (struct.isSetLikes()) {
        oprot.writeI32(struct.likes);
      }
      if (struct.isSetPosts()) {
        oprot.writeI32(struct.posts);
      }
      if (struct.isSetViews()) {
        oprot.writeI32(struct.views);
      }
      if (struct.isSetIsPublic()) {
        oprot.writeBool(struct.isPublic);
      }
      if (struct.isSetPois()) {
        {
          oprot.writeI32(struct.pois.size());
          for (POI _iter28 : struct.pois)
          {
            _iter28.write(oprot);
          }
        }
      }
      if (struct.isSetNoteStr()) {
        oprot.writeString(struct.noteStr);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Trip struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(13);
      if (incoming.get(0)) {
        struct.path = iprot.readString();
        struct.setPathIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.author = iprot.readString();
        struct.setAuthorIsSet(true);
      }
      if (incoming.get(3)) {
        struct.lat = iprot.readDouble();
        struct.setLatIsSet(true);
      }
      if (incoming.get(4)) {
        struct.lng = iprot.readDouble();
        struct.setLngIsSet(true);
      }
      if (incoming.get(5)) {
        struct.time = iprot.readString();
        struct.setTimeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.uploadTime = iprot.readString();
        struct.setUploadTimeIsSet(true);
      }
      if (incoming.get(7)) {
        struct.likes = iprot.readI32();
        struct.setLikesIsSet(true);
      }
      if (incoming.get(8)) {
        struct.posts = iprot.readI32();
        struct.setPostsIsSet(true);
      }
      if (incoming.get(9)) {
        struct.views = iprot.readI32();
        struct.setViewsIsSet(true);
      }
      if (incoming.get(10)) {
        struct.isPublic = iprot.readBool();
        struct.setIsPublicIsSet(true);
      }
      if (incoming.get(11)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.pois = new ArrayList<POI>(_list29.size);
          for (int _i30 = 0; _i30 < _list29.size; ++_i30)
          {
            POI _elem31;
            _elem31 = new POI();
            _elem31.read(iprot);
            struct.pois.add(_elem31);
          }
        }
        struct.setPoisIsSet(true);
      }
      if (incoming.get(12)) {
        struct.noteStr = iprot.readString();
        struct.setNoteStrIsSet(true);
      }
    }
  }

}

