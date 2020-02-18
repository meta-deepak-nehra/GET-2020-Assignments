package DefaultNamespace;

public class AreaOfTriangleProxy implements DefaultNamespace.AreaOfTriangle {
  private String _endpoint = null;
  private DefaultNamespace.AreaOfTriangle areaOfTriangle = null;
  
  public AreaOfTriangleProxy() {
    _initAreaOfTriangleProxy();
  }
  
  public AreaOfTriangleProxy(String endpoint) {
    _endpoint = endpoint;
    _initAreaOfTriangleProxy();
  }
  
  private void _initAreaOfTriangleProxy() {
    try {
      areaOfTriangle = (new DefaultNamespace.AreaOfTriangleServiceLocator()).getAreaOfTriangle();
      if (areaOfTriangle != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)areaOfTriangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)areaOfTriangle)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (areaOfTriangle != null)
      ((javax.xml.rpc.Stub)areaOfTriangle)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.AreaOfTriangle getAreaOfTriangle() {
    if (areaOfTriangle == null)
      _initAreaOfTriangleProxy();
    return areaOfTriangle;
  }
  
  public double area(double a, double b, double c) throws java.rmi.RemoteException{
    if (areaOfTriangle == null)
      _initAreaOfTriangleProxy();
    return areaOfTriangle.area(a, b, c);
  }
  
  
}