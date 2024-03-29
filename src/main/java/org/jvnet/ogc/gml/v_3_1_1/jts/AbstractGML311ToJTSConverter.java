package org.jvnet.ogc.gml.v_3_1_1.jts;

import org.jvnet.jaxb.locator.ObjectLocator;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import net.opengis.gml.v_3_1_1.AbstractGeometryType;

public abstract class AbstractGML311ToJTSConverter<G extends AbstractGeometryType, P, J extends Geometry>
    implements GML311ToJTSConverterInterface<G, P, J> {
  private final GeometryFactory geometryFactory;
  private final GML311ToJTSSRIDConverterInterface sridConverter;

  public AbstractGML311ToJTSConverter(GeometryFactory geometryFactory, GML311ToJTSSRIDConverterInterface sridConverter) {
    super();
    this.geometryFactory = geometryFactory;
    this.sridConverter = sridConverter;
  }

  public GeometryFactory getGeometryFactory() {
    return geometryFactory;
  }

  public GML311ToJTSSRIDConverterInterface getSridConverter() {
    return sridConverter;
  }

  public J createGeometry(ObjectLocator locator, G geometryType) throws ConversionFailedException {
    final J geometry = doCreateGeometry(locator, geometryType);
    getSridConverter().convert(locator, geometryType, geometry);
    return geometry;
  }

  protected abstract J doCreateGeometry(ObjectLocator locator, G geometryType) throws ConversionFailedException;

}
