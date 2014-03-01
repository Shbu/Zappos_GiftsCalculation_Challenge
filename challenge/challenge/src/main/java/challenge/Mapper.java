package challenge;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Mapper {

	ObjectMapper mapper = new ObjectMapper();
	private CalculateGiftsCombination calculateGiftsCombination = null;

	public FinalOutputBean getPojoFromJsonString(String outputInJsonFormat) {
		FinalOutputBean finalResultsInJsonFormat = null;
		try {
			finalResultsInJsonFormat = new FinalOutputBean();
			if (null != finalResultsInJsonFormat) {
				finalResultsInJsonFormat = mapper.readValue(outputInJsonFormat,
						FinalOutputBean.class);
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalResultsInJsonFormat;
	}

	public List<Results> parseValuesToCalculateGiftsCombination(
			int productsCount, Float price, FinalOutputBean finalOutputBean) {
		calculateGiftsCombination = new CalculateGiftsCombination(
				finalOutputBean);
		List<Results> outputProductsList = calculateGiftsCombination
				.removeProductsGreaterThanGivenPrice(productsCount, price);
		return outputProductsList;
	}

}
