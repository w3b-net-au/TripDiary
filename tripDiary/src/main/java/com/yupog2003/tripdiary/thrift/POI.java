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

public class POI implements org.apache.thrift.TBase<POI, POI._Fields>, java.io.Serializable, Cloneable, Comparable<POI> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("POI");

  private static final org.apache.thrift.protocol.TField PATH_FIELD_DESC = new org.apache.thrift.protocol.TField("path", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField LAT_FIELD_DESC = new org.apache.thrift.protocol.TField("lat", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField LNG_FIELD_DESC = new org.apache.thrift.protocol.TField("lng", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("time", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField ALTITUDE_FIELD_DESC = new org.apache.thrift.protocol.TField("altitude", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField DIARY_STR_FIELD_DESC = new org.apache.thrift.protocol.TField("diaryStr", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField PICTURES_FIELD_DESC = new org.apache.thrift.protocol.TField("pictures", org.apache.thrift.protocol.TType.LIST, (short)8);
  private static final org.apache.thrift.protocol.TField VIDEOS_FIELD_DESC = new org.apache.thrift.protocol.TField("videos", org.apache.thrift.protocol.TType.LIST, (short)9);
  private static final org.apache.thrift.protocol.TField AUDIOS_FIELD_DESC = new org.apache.thrift.protocol.TField("audios", org.apache.thrift.protocol.TType.LIST, (short)10);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new POIStandardSchemeFactory());
    schemes.put(TupleScheme.class, new POITupleSchemeFactory());
  }

  public String path; // required
  public String name; // required
  public double lat; // required
  public double lng; // required
  public String time; // required
  public double altitude; // required
  public String diaryStr; // required
  public List<String> pictures; // required
  public List<String> videos; // required
  public List<String> audios; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PATH((short)1, "path"),
    NAME((short)2, "name"),
    LAT((short)3, "lat"),
    LNG((short)4, "lng"),
    TIME((short)5, "time"),
    ALTITUDE((short)6, "altitude"),
    DIARY_STR((short)7, "diaryStr"),
    PICTURES((short)8, "pictures"),
    VIDEOS((short)9, "videos"),
    AUDIOS((short)10, "audios");

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
        case 3: // LAT
          return LAT;
        case 4: // LNG
          return LNG;
        case 5: // TIME
          return TIME;
        case 6: // ALTITUDE
          return ALTITUDE;
        case 7: // DIARY_STR
          return DIARY_STR;
        case 8: // PICTURES
          return PICTURES;
        case 9: // VIDEOS
          return VIDEOS;
        case 10: // AUDIOS
          return AUDIOS;
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
  private static final int __ALTITUDE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PATH, new org.apache.thrift.meta_data.FieldMetaData("path", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LAT, new org.apache.thrift.meta_data.FieldMetaData("lat", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LNG, new org.apache.thrift.meta_data.FieldMetaData("lng", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TIME, new org.apache.thrift.meta_data.FieldMetaData("time", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ALTITUDE, new org.apache.thrift.meta_data.FieldMetaData("altitude", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.DIARY_STR, new org.apache.thrift.meta_data.FieldMetaData("diaryStr", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PICTURES, new org.apache.thrift.meta_data.FieldMetaData("pictures", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.VIDEOS, new org.apache.thrift.meta_data.FieldMetaData("videos", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    tmpMap.put(_Fields.AUDIOS, new org.apache.thrift.meta_data.FieldMetaData("audios", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(POI.class, metaDataMap);
  }

  public POI() {
  }

  public POI(
    String path,
    String name,
    double lat,
    double lng,
    String time,
    double altitude,
    String diaryStr,
    List<String> pictures,
    List<String> videos,
    List<String> audios)
  {
    this();
    this.path = path;
    this.name = name;
    this.lat = lat;
    setLatIsSet(true);
    this.lng = lng;
    setLngIsSet(true);
    this.time = time;
    this.altitude = altitude;
    setAltitudeIsSet(true);
    this.diaryStr = diaryStr;
    this.pictures = pictures;
    this.videos = videos;
    this.audios = audios;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public POI(POI other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetPath()) {
      this.path = other.path;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.lat = other.lat;
    this.lng = other.lng;
    if (other.isSetTime()) {
      this.time = other.time;
    }
    this.altitude = other.altitude;
    if (other.isSetDiaryStr()) {
      this.diaryStr = other.diaryStr;
    }
    if (other.isSetPictures()) {
      List<String> __this__pictures = new ArrayList<String>(other.pictures);
      this.pictures = __this__pictures;
    }
    if (other.isSetVideos()) {
      List<String> __this__videos = new ArrayList<String>(other.videos);
      this.videos = __this__videos;
    }
    if (other.isSetAudios()) {
      List<String> __this__audios = new ArrayList<String>(other.audios);
      this.audios = __this__audios;
    }
  }

  public POI deepCopy() {
    return new POI(this);
  }

  @Override
  public void clear() {
    this.path = null;
    this.name = null;
    setLatIsSet(false);
    this.lat = 0.0;
    setLngIsSet(false);
    this.lng = 0.0;
    this.time = null;
    setAltitudeIsSet(false);
    this.altitude = 0.0;
    this.diaryStr = null;
    this.pictures = null;
    this.videos = null;
    this.audios = null;
  }

  public String getPath() {
    return this.path;
  }

  public POI setPath(String path) {
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

  public POI setName(String name) {
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

  public double getLat() {
    return this.lat;
  }

  public POI setLat(double lat) {
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

  public POI setLng(double lng) {
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

  public POI setTime(String time) {
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

  public double getAltitude() {
    return this.altitude;
  }

  public POI setAltitude(double altitude) {
    this.altitude = altitude;
    setAltitudeIsSet(true);
    return this;
  }

  public void unsetAltitude() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ALTITUDE_ISSET_ID);
  }

  /** Returns true if field altitude is set (has been assigned a value) and false otherwise */
  public boolean isSetAltitude() {
    return EncodingUtils.testBit(__isset_bitfield, __ALTITUDE_ISSET_ID);
  }

  public void setAltitudeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ALTITUDE_ISSET_ID, value);
  }

  public String getDiaryStr() {
    return this.diaryStr;
  }

  public POI setDiaryStr(String diaryStr) {
    this.diaryStr = diaryStr;
    return this;
  }

  public void unsetDiaryStr() {
    this.diaryStr = null;
  }

  /** Returns true if field diaryStr is set (has been assigned a value) and false otherwise */
  public boolean isSetDiaryStr() {
    return this.diaryStr != null;
  }

  public void setDiaryStrIsSet(boolean value) {
    if (!value) {
      this.diaryStr = null;
    }
  }

  public int getPicturesSize() {
    return (this.pictures == null) ? 0 : this.pictures.size();
  }

  public java.util.Iterator<String> getPicturesIterator() {
    return (this.pictures == null) ? null : this.pictures.iterator();
  }

  public void addToPictures(String elem) {
    if (this.pictures == null) {
      this.pictures = new ArrayList<String>();
    }
    this.pictures.add(elem);
  }

  public List<String> getPictures() {
    return this.pictures;
  }

  public POI setPictures(List<String> pictures) {
    this.pictures = pictures;
    return this;
  }

  public void unsetPictures() {
    this.pictures = null;
  }

  /** Returns true if field pictures is set (has been assigned a value) and false otherwise */
  public boolean isSetPictures() {
    return this.pictures != null;
  }

  public void setPicturesIsSet(boolean value) {
    if (!value) {
      this.pictures = null;
    }
  }

  public int getVideosSize() {
    return (this.videos == null) ? 0 : this.videos.size();
  }

  public java.util.Iterator<String> getVideosIterator() {
    return (this.videos == null) ? null : this.videos.iterator();
  }

  public void addToVideos(String elem) {
    if (this.videos == null) {
      this.videos = new ArrayList<String>();
    }
    this.videos.add(elem);
  }

  public List<String> getVideos() {
    return this.videos;
  }

  public POI setVideos(List<String> videos) {
    this.videos = videos;
    return this;
  }

  public void unsetVideos() {
    this.videos = null;
  }

  /** Returns true if field videos is set (has been assigned a value) and false otherwise */
  public boolean isSetVideos() {
    return this.videos != null;
  }

  public void setVideosIsSet(boolean value) {
    if (!value) {
      this.videos = null;
    }
  }

  public int getAudiosSize() {
    return (this.audios == null) ? 0 : this.audios.size();
  }

  public java.util.Iterator<String> getAudiosIterator() {
    return (this.audios == null) ? null : this.audios.iterator();
  }

  public void addToAudios(String elem) {
    if (this.audios == null) {
      this.audios = new ArrayList<String>();
    }
    this.audios.add(elem);
  }

  public List<String> getAudios() {
    return this.audios;
  }

  public POI setAudios(List<String> audios) {
    this.audios = audios;
    return this;
  }

  public void unsetAudios() {
    this.audios = null;
  }

  /** Returns true if field audios is set (has been assigned a value) and false otherwise */
  public boolean isSetAudios() {
    return this.audios != null;
  }

  public void setAudiosIsSet(boolean value) {
    if (!value) {
      this.audios = null;
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

    case ALTITUDE:
      if (value == null) {
        unsetAltitude();
      } else {
        setAltitude((Double)value);
      }
      break;

    case DIARY_STR:
      if (value == null) {
        unsetDiaryStr();
      } else {
        setDiaryStr((String)value);
      }
      break;

    case PICTURES:
      if (value == null) {
        unsetPictures();
      } else {
        setPictures((List<String>)value);
      }
      break;

    case VIDEOS:
      if (value == null) {
        unsetVideos();
      } else {
        setVideos((List<String>)value);
      }
      break;

    case AUDIOS:
      if (value == null) {
        unsetAudios();
      } else {
        setAudios((List<String>)value);
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

    case LAT:
      return Double.valueOf(getLat());

    case LNG:
      return Double.valueOf(getLng());

    case TIME:
      return getTime();

    case ALTITUDE:
      return Double.valueOf(getAltitude());

    case DIARY_STR:
      return getDiaryStr();

    case PICTURES:
      return getPictures();

    case VIDEOS:
      return getVideos();

    case AUDIOS:
      return getAudios();

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
    case LAT:
      return isSetLat();
    case LNG:
      return isSetLng();
    case TIME:
      return isSetTime();
    case ALTITUDE:
      return isSetAltitude();
    case DIARY_STR:
      return isSetDiaryStr();
    case PICTURES:
      return isSetPictures();
    case VIDEOS:
      return isSetVideos();
    case AUDIOS:
      return isSetAudios();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof POI)
      return this.equals((POI)that);
    return false;
  }

  public boolean equals(POI that) {
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

    boolean this_present_altitude = true;
    boolean that_present_altitude = true;
    if (this_present_altitude || that_present_altitude) {
      if (!(this_present_altitude && that_present_altitude))
        return false;
      if (this.altitude != that.altitude)
        return false;
    }

    boolean this_present_diaryStr = true && this.isSetDiaryStr();
    boolean that_present_diaryStr = true && that.isSetDiaryStr();
    if (this_present_diaryStr || that_present_diaryStr) {
      if (!(this_present_diaryStr && that_present_diaryStr))
        return false;
      if (!this.diaryStr.equals(that.diaryStr))
        return false;
    }

    boolean this_present_pictures = true && this.isSetPictures();
    boolean that_present_pictures = true && that.isSetPictures();
    if (this_present_pictures || that_present_pictures) {
      if (!(this_present_pictures && that_present_pictures))
        return false;
      if (!this.pictures.equals(that.pictures))
        return false;
    }

    boolean this_present_videos = true && this.isSetVideos();
    boolean that_present_videos = true && that.isSetVideos();
    if (this_present_videos || that_present_videos) {
      if (!(this_present_videos && that_present_videos))
        return false;
      if (!this.videos.equals(that.videos))
        return false;
    }

    boolean this_present_audios = true && this.isSetAudios();
    boolean that_present_audios = true && that.isSetAudios();
    if (this_present_audios || that_present_audios) {
      if (!(this_present_audios && that_present_audios))
        return false;
      if (!this.audios.equals(that.audios))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(POI other) {
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
    lastComparison = Boolean.valueOf(isSetAltitude()).compareTo(other.isSetAltitude());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAltitude()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.altitude, other.altitude);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDiaryStr()).compareTo(other.isSetDiaryStr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDiaryStr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.diaryStr, other.diaryStr);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPictures()).compareTo(other.isSetPictures());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPictures()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pictures, other.pictures);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVideos()).compareTo(other.isSetVideos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVideos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.videos, other.videos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAudios()).compareTo(other.isSetAudios());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAudios()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.audios, other.audios);
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
    StringBuilder sb = new StringBuilder("POI(");
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
    sb.append("altitude:");
    sb.append(this.altitude);
    first = false;
    if (!first) sb.append(", ");
    sb.append("diaryStr:");
    if (this.diaryStr == null) {
      sb.append("null");
    } else {
      sb.append(this.diaryStr);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pictures:");
    if (this.pictures == null) {
      sb.append("null");
    } else {
      sb.append(this.pictures);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("videos:");
    if (this.videos == null) {
      sb.append("null");
    } else {
      sb.append(this.videos);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("audios:");
    if (this.audios == null) {
      sb.append("null");
    } else {
      sb.append(this.audios);
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

  private static class POIStandardSchemeFactory implements SchemeFactory {
    public POIStandardScheme getScheme() {
      return new POIStandardScheme();
    }
  }

  private static class POIStandardScheme extends StandardScheme<POI> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, POI struct) throws org.apache.thrift.TException {
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
          case 3: // LAT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lat = iprot.readDouble();
              struct.setLatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LNG
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lng = iprot.readDouble();
              struct.setLngIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.time = iprot.readString();
              struct.setTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ALTITUDE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.altitude = iprot.readDouble();
              struct.setAltitudeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // DIARY_STR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.diaryStr = iprot.readString();
              struct.setDiaryStrIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // PICTURES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.pictures = new ArrayList<String>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  String _elem2;
                  _elem2 = iprot.readString();
                  struct.pictures.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setPicturesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 9: // VIDEOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.videos = new ArrayList<String>(_list3.size);
                for (int _i4 = 0; _i4 < _list3.size; ++_i4)
                {
                  String _elem5;
                  _elem5 = iprot.readString();
                  struct.videos.add(_elem5);
                }
                iprot.readListEnd();
              }
              struct.setVideosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // AUDIOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list6 = iprot.readListBegin();
                struct.audios = new ArrayList<String>(_list6.size);
                for (int _i7 = 0; _i7 < _list6.size; ++_i7)
                {
                  String _elem8;
                  _elem8 = iprot.readString();
                  struct.audios.add(_elem8);
                }
                iprot.readListEnd();
              }
              struct.setAudiosIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, POI struct) throws org.apache.thrift.TException {
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
      oprot.writeFieldBegin(ALTITUDE_FIELD_DESC);
      oprot.writeDouble(struct.altitude);
      oprot.writeFieldEnd();
      if (struct.diaryStr != null) {
        oprot.writeFieldBegin(DIARY_STR_FIELD_DESC);
        oprot.writeString(struct.diaryStr);
        oprot.writeFieldEnd();
      }
      if (struct.pictures != null) {
        oprot.writeFieldBegin(PICTURES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.pictures.size()));
          for (String _iter9 : struct.pictures)
          {
            oprot.writeString(_iter9);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.videos != null) {
        oprot.writeFieldBegin(VIDEOS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.videos.size()));
          for (String _iter10 : struct.videos)
          {
            oprot.writeString(_iter10);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.audios != null) {
        oprot.writeFieldBegin(AUDIOS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.audios.size()));
          for (String _iter11 : struct.audios)
          {
            oprot.writeString(_iter11);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class POITupleSchemeFactory implements SchemeFactory {
    public POITupleScheme getScheme() {
      return new POITupleScheme();
    }
  }

  private static class POITupleScheme extends TupleScheme<POI> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, POI struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetPath()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      if (struct.isSetLat()) {
        optionals.set(2);
      }
      if (struct.isSetLng()) {
        optionals.set(3);
      }
      if (struct.isSetTime()) {
        optionals.set(4);
      }
      if (struct.isSetAltitude()) {
        optionals.set(5);
      }
      if (struct.isSetDiaryStr()) {
        optionals.set(6);
      }
      if (struct.isSetPictures()) {
        optionals.set(7);
      }
      if (struct.isSetVideos()) {
        optionals.set(8);
      }
      if (struct.isSetAudios()) {
        optionals.set(9);
      }
      oprot.writeBitSet(optionals, 10);
      if (struct.isSetPath()) {
        oprot.writeString(struct.path);
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
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
      if (struct.isSetAltitude()) {
        oprot.writeDouble(struct.altitude);
      }
      if (struct.isSetDiaryStr()) {
        oprot.writeString(struct.diaryStr);
      }
      if (struct.isSetPictures()) {
        {
          oprot.writeI32(struct.pictures.size());
          for (String _iter12 : struct.pictures)
          {
            oprot.writeString(_iter12);
          }
        }
      }
      if (struct.isSetVideos()) {
        {
          oprot.writeI32(struct.videos.size());
          for (String _iter13 : struct.videos)
          {
            oprot.writeString(_iter13);
          }
        }
      }
      if (struct.isSetAudios()) {
        {
          oprot.writeI32(struct.audios.size());
          for (String _iter14 : struct.audios)
          {
            oprot.writeString(_iter14);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, POI struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(10);
      if (incoming.get(0)) {
        struct.path = iprot.readString();
        struct.setPathIsSet(true);
      }
      if (incoming.get(1)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lat = iprot.readDouble();
        struct.setLatIsSet(true);
      }
      if (incoming.get(3)) {
        struct.lng = iprot.readDouble();
        struct.setLngIsSet(true);
      }
      if (incoming.get(4)) {
        struct.time = iprot.readString();
        struct.setTimeIsSet(true);
      }
      if (incoming.get(5)) {
        struct.altitude = iprot.readDouble();
        struct.setAltitudeIsSet(true);
      }
      if (incoming.get(6)) {
        struct.diaryStr = iprot.readString();
        struct.setDiaryStrIsSet(true);
      }
      if (incoming.get(7)) {
        {
          org.apache.thrift.protocol.TList _list15 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.pictures = new ArrayList<String>(_list15.size);
          for (int _i16 = 0; _i16 < _list15.size; ++_i16)
          {
            String _elem17;
            _elem17 = iprot.readString();
            struct.pictures.add(_elem17);
          }
        }
        struct.setPicturesIsSet(true);
      }
      if (incoming.get(8)) {
        {
          org.apache.thrift.protocol.TList _list18 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.videos = new ArrayList<String>(_list18.size);
          for (int _i19 = 0; _i19 < _list18.size; ++_i19)
          {
            String _elem20;
            _elem20 = iprot.readString();
            struct.videos.add(_elem20);
          }
        }
        struct.setVideosIsSet(true);
      }
      if (incoming.get(9)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.audios = new ArrayList<String>(_list21.size);
          for (int _i22 = 0; _i22 < _list21.size; ++_i22)
          {
            String _elem23;
            _elem23 = iprot.readString();
            struct.audios.add(_elem23);
          }
        }
        struct.setAudiosIsSet(true);
      }
    }
  }

}

