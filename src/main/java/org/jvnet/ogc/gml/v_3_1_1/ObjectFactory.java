package org.jvnet.ogc.gml.v_3_1_1;

import javax.xml.namespace.QName;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import net.opengis.gml.v_3_1_1.AbstractGeometryType;
import net.opengis.gml.v_3_1_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_1_1.CoordType;
import net.opengis.gml.v_3_1_1.CoordinatesType;
import net.opengis.gml.v_3_1_1.DirectPositionListType;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.LineStringPropertyType;
import net.opengis.gml.v_3_1_1.LineStringType;
import net.opengis.gml.v_3_1_1.LinearRingPropertyType;
import net.opengis.gml.v_3_1_1.LinearRingType;
import net.opengis.gml.v_3_1_1.MultiGeometryPropertyType;
import net.opengis.gml.v_3_1_1.MultiGeometryType;
import net.opengis.gml.v_3_1_1.MultiLineStringPropertyType;
import net.opengis.gml.v_3_1_1.MultiLineStringType;
import net.opengis.gml.v_3_1_1.MultiPointPropertyType;
import net.opengis.gml.v_3_1_1.MultiPointType;
import net.opengis.gml.v_3_1_1.MultiPolygonPropertyType;
import net.opengis.gml.v_3_1_1.MultiPolygonType;
import net.opengis.gml.v_3_1_1.PointPropertyType;
import net.opengis.gml.v_3_1_1.PointType;
import net.opengis.gml.v_3_1_1.PolygonPropertyType;
import net.opengis.gml.v_3_1_1.PolygonType;

@XmlRegistry
public class ObjectFactory implements ObjectFactoryInterface {

  public final static QName _Pos_QNAME =
      new QName("http://www.opengis.net/gml", "pos");

  public final static QName _Point_QNAME =
      new QName("http://www.opengis.net/gml", "Point");

  public final static QName _PointProperty_QNAME =
      new QName("http://www.opengis.net/gml", "pointProperty");

  public final static QName _LineString_QNAME =
      new QName("http://www.opengis.net/gml", "LineString");

  public final static QName _LineStringProperty_QNAME =
      new QName("http://www.opengis.net/gml", "lineStringProperty");

  public final static QName _LinearRing_QNAME =
      new QName("http://www.opengis.net/gml", "LinearRing");

  public final static QName _LinearRingProperty_QNAME =
      new QName("http://www.opengis.net/gml", "linearRingProperty");

  public final static QName _Exterior_QNAME =
      new QName("http://www.opengis.net/gml", "exterior");

  public final static QName _Interior_QNAME =
      new QName("http://www.opengis.net/gml", "interior");

  public final static QName _Polygon_QNAME =
      new QName("http://www.opengis.net/gml", "Polygon");

  public final static QName _PolygonProperty_QNAME =
      new QName("http://www.opengis.net/gml", "polygonProperty");

  public final static QName _MultiPoint_QNAME =
      new QName("http://www.opengis.net/gml", "MultiPoint");

  public final static QName _MultiPointProperty_QNAME =
      new QName("http://www.opengis.net/gml", "multiPointProperty");

  public final static QName _MultiLineString_QNAME =
      new QName("http://www.opengis.net/gml", "MultiLineString");

  public final static QName _MultiLineStringProperty_QNAME =
      new QName("http://www.opengis.net/gml", "multiLineStringProperty");

  public final static QName _MultiPolygon_QNAME =
      new QName("http://www.opengis.net/gml", "MultiPolygon");

  public final static QName _MultiPolygonProperty_QNAME =
      new QName("http://www.opengis.net/gml", "multiPolygonProperty");

  public final static QName _MultiGeometry_QNAME =
      new QName("http://www.opengis.net/gml", "MultiGeometry");

  public final static QName _MultiGeometryProperty_QNAME =
      new QName("http://www.opengis.net/gml", "multiGeometryProperty");

  public final static QName _Geometry_QNAME =
      new QName("http://www.opengis.net/gml", "_Geometry");

  public CoordType createCoordType() {
    return new CoordType();
  }

  public CoordinatesType createCoordinatesType() {
    return new CoordinatesType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pos")
  public JAXBElement<DirectPositionType> createPos(DirectPositionType value) {
    return new JAXBElement<DirectPositionType>(_Pos_QNAME, DirectPositionType.class, null, value);
  }

  public DirectPositionType createDirectPositionType() {
    return new DirectPositionType();
  }

  public DirectPositionListType createDirectPositionListType() {
    return new DirectPositionListType();
  }

  public PointType createPointType() {
    return new PointType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Point", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricPrimitive")
  public JAXBElement<PointType> createPoint(PointType value) {
    return new JAXBElement<PointType>(_Point_QNAME, PointType.class, null, value);
  }

  public PointPropertyType createPointPropertyType() {
    return new PointPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointProperty")
  public JAXBElement<PointPropertyType> createPointProperty(PointPropertyType value) {
    return new JAXBElement<PointPropertyType>(_PointProperty_QNAME, PointPropertyType.class, null, value);
  }

  public LineStringType createLineStringType() {
    return new LineStringType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LineString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Curve")
  public JAXBElement<LineStringType> createLineString(LineStringType value) {
    return new JAXBElement<LineStringType>(_LineString_QNAME, LineStringType.class, null, value);
  }

  public LineStringPropertyType createLineStringPropertyType() {
    return new LineStringPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "lineStringProperty")
  public JAXBElement<LineStringPropertyType> createLineStringProperty(LineStringPropertyType value) {
    return new JAXBElement<LineStringPropertyType>(_LineStringProperty_QNAME, LineStringPropertyType.class, null, value);
  }

  public LinearRingType createLinearRingType() {
    return new LinearRingType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LinearRing", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Ring")
  public JAXBElement<LinearRingType> createLinearRing(LinearRingType value) {
    return new JAXBElement<LinearRingType>(_LinearRing_QNAME, LinearRingType.class, null, value);
  }

  public LinearRingPropertyType createLinearRingPropertyType() {
    return new LinearRingPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "linearRingProperty")
  public JAXBElement<LinearRingPropertyType> createLinearRingProperty(LinearRingPropertyType value) {
    return new JAXBElement<LinearRingPropertyType>(_LinearRingProperty_QNAME, LinearRingPropertyType.class, null, value);
  }


  public AbstractRingPropertyType createAbstractRingPropertyType() {
    return new AbstractRingPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "exterior")
  public JAXBElement<AbstractRingPropertyType> createExterior(AbstractRingPropertyType value) {
    return new JAXBElement<AbstractRingPropertyType>(_Exterior_QNAME, AbstractRingPropertyType.class, null, value);
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "interior")
  public JAXBElement<AbstractRingPropertyType> createInterior(AbstractRingPropertyType value) {
    return new JAXBElement<AbstractRingPropertyType>(_Interior_QNAME, AbstractRingPropertyType.class, null, value);
  }

  public PolygonType createPolygonType() {
    return new PolygonType();
  }

  public PolygonPropertyType createPolygonPropertyType() {
    return new PolygonPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Polygon", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Surface")
  public JAXBElement<PolygonType> createPolygon(PolygonType value) {
    return new JAXBElement<PolygonType>(_Polygon_QNAME, PolygonType.class, null, value);
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "polygonProperty")
  public JAXBElement<PolygonPropertyType> createPolygonProperty(PolygonPropertyType value) {
    return new JAXBElement<PolygonPropertyType>(_PolygonProperty_QNAME, PolygonPropertyType.class, null, value);
  }

  public MultiPointType createMultiPointType() {
    return new MultiPointType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiPoint", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
  public JAXBElement<MultiPointType> createMultiPoint(MultiPointType value) {
    return new JAXBElement<MultiPointType>(_MultiPoint_QNAME, MultiPointType.class, null, value);
  }

  public MultiPointPropertyType createMultiPointPropertyType() {
    return new MultiPointPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiPointProperty")
  public JAXBElement<MultiPointPropertyType> createMultiPointProperty(MultiPointPropertyType value) {
    return new JAXBElement<MultiPointPropertyType>(_MultiPointProperty_QNAME, MultiPointPropertyType.class, null, value);
  }

  public MultiLineStringType createMultiLineStringType() {
    return new MultiLineStringType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiLineString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
  public JAXBElement<MultiLineStringType> createMultiLineString(MultiLineStringType value) {
    return new JAXBElement<MultiLineStringType>(_MultiLineString_QNAME, MultiLineStringType.class, null, value);
  }

  public MultiLineStringPropertyType createMultiLineStringPropertyType() {
    return new MultiLineStringPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiLineStringProperty")
  public JAXBElement<MultiLineStringPropertyType> createMultiLineStringProperty(MultiLineStringPropertyType value) {
    return new JAXBElement<MultiLineStringPropertyType>(_MultiLineStringProperty_QNAME, MultiLineStringPropertyType.class, null, value);
  }

  public MultiPolygonType createMultiPolygonType() {
    return new MultiPolygonType();
  }

  public MultiPolygonPropertyType createMultiPolygonPropertyType() {
    return new MultiPolygonPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiPolygon", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
  public JAXBElement<MultiPolygonType> createMultiPolygon(MultiPolygonType value) {
    return new JAXBElement<MultiPolygonType>(_MultiPolygon_QNAME, MultiPolygonType.class, null, value);
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiPolygonProperty")
  public JAXBElement<MultiPolygonPropertyType> createMultiPolygonProperty(MultiPolygonPropertyType value) {
    return new JAXBElement<MultiPolygonPropertyType>(_MultiPolygonProperty_QNAME, MultiPolygonPropertyType.class, null, value);
  }

  public MultiGeometryType createMultiGeometryType() {
    return new MultiGeometryType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
  public JAXBElement<MultiGeometryType> createMultiGeometry(MultiGeometryType value) {
    return new JAXBElement<MultiGeometryType>(_MultiGeometry_QNAME, MultiGeometryType.class, null, value);
  }

  public MultiGeometryPropertyType createMultiGeometryPropertyType() {
    return new MultiGeometryPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiGeometryProperty")
  public JAXBElement<MultiGeometryPropertyType> createMultiGeometryProperty(
      MultiGeometryPropertyType value) {
    return new JAXBElement<MultiGeometryPropertyType>(_MultiGeometryProperty_QNAME, MultiGeometryPropertyType.class, null, value);
  }

  public GeometryPropertyType createGeometryPropertyType() {
    return new GeometryPropertyType();
  }

  @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Geometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
  public JAXBElement<AbstractGeometryType> createGeometry(AbstractGeometryType value) {
    return new JAXBElement<AbstractGeometryType>(_Geometry_QNAME, AbstractGeometryType.class, null, value);
  }

}
