package org.jvnet.ogc.gml.v_3_1_1.jts;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBElement;

import org.jvnet.jaxb.locator.ObjectLocator;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;

import net.opengis.gml.v_3_1_1.AbstractGeometricAggregateType;
import net.opengis.gml.v_3_1_1.AbstractGeometryType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.MultiGeometryPropertyType;
import net.opengis.gml.v_3_1_1.MultiGeometryType;

@SuppressWarnings("nls")
public class GML311ToJTSMultiGeometryConverter
    extends AbstractGML311ToJTSConverter<MultiGeometryType, MultiGeometryPropertyType, GeometryCollection> {

  // + MultiPolygon

  private final GML311ToJTSConverterInterface<AbstractGeometryType, Object, Geometry> geometryConverter;

  public GML311ToJTSMultiGeometryConverter(
      GeometryFactory geometryFactory,
      GML311ToJTSSRIDConverterInterface sridConverter,
      GML311ToJTSGeometryConverter geometryConverter) {
    super(geometryFactory, sridConverter);
    this.geometryConverter = geometryConverter;
  }

  @Override
  protected GeometryCollection doCreateGeometry(ObjectLocator locator, MultiGeometryType multiGeometryType)
      throws ConversionFailedException {

    final List<Geometry> geometries = new ArrayList<Geometry>();

    if (multiGeometryType.isSetGeometryMember()) {
      final ObjectLocator geometryMemberLocator = locator.property("geometryMember", multiGeometryType.getGeometryMember());
      for (int index = 0; index < multiGeometryType.getGeometryMember().size(); index++) {
        final GeometryPropertyType geometryPropertyType = multiGeometryType.getGeometryMember().get(index);
        geometries.add(this.geometryConverter.createGeometry(
            geometryMemberLocator.item(index, geometryPropertyType), geometryPropertyType));
      }
    }
    if (multiGeometryType.isSetGeometryMembers()) {
      final ObjectLocator geometryMemberLocator = locator.property(
          "geometryMembers", multiGeometryType.getGeometryMembers())
          .property("geometry", multiGeometryType.getGeometryMembers().getGeometry());
      for (int index = 0; index < multiGeometryType.getGeometryMembers().getGeometry().size(); index++) {
        final AbstractGeometryType abstractGeometryType =
            multiGeometryType.getGeometryMembers().getGeometry().get(index).getValue();
        geometries.add(
            this.geometryConverter.createGeometry(
                geometryMemberLocator.item(index, multiGeometryType.getGeometryMembers().getGeometry().get(index))
                    .property("value", abstractGeometryType),
                abstractGeometryType));
      }
    }
    return getGeometryFactory().createGeometryCollection(geometries.toArray(new Geometry[0]));
  }

  public GeometryCollection createGeometry(ObjectLocator locator,
                                           MultiGeometryPropertyType multiGeometryPropertyType)
      throws ConversionFailedException {
    if (multiGeometryPropertyType.isSetGeometricAggregate()) {
      final JAXBElement<? extends AbstractGeometricAggregateType> geometricAggregate =
          multiGeometryPropertyType.getGeometricAggregate();
      final AbstractGeometricAggregateType value = geometricAggregate.getValue();
      if (value instanceof MultiGeometryType) {
        return createGeometry(locator.
            property("geometricAggregate", geometricAggregate), (MultiGeometryType) value); //$NON-NLS-1$
      } else {
        throw new ConversionFailedException(
            locator.property("geometricAggregate", geometricAggregate), "Expected [MultiGeometry] element.");
      }
    } else {
      throw new ConversionFailedException(locator, "Expected [MultiGeometry] element."); //$NON-NLS-1$
    }
  }
}
