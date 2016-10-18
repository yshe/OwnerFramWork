package leap.demo.util.common.designWay.FactoryModel;

public class RedLightFactory extends LightFactory{
	@Override
	public Light lightFactory() {
		return new RedLight();
	}
}
