package leap.demo.util.common.designWay.FactoryModel;

public class YellowLightFactory extends LightFactory{

	@Override
	public Light lightFactory() {
		return new YellowLight();
	}

}
